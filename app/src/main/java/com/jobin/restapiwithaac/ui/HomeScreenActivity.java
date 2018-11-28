package com.jobin.restapiwithaac.ui;

import android.arch.lifecycle.ViewModelProviders;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.jobin.restapiwithaac.R;
import com.jobin.restapiwithaac.RestAPIWithAACApplication;
import com.jobin.restapiwithaac.component.AlbumContentModule;
import com.jobin.restapiwithaac.database.AlbumContentModel;
import com.jobin.restapiwithaac.viewmodel.AlbumContentModelFactory;
import com.jobin.restapiwithaac.viewmodel.AlbumContentViewModel;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import okhttp3.internal.platform.Platform;

public class HomeScreenActivity extends AppCompatActivity {

    @Inject
    @Named("activity")
    CompositeDisposable compositeDisposable;
    @Inject
    AlbumContentModelFactory albumContentModelFactory;
    private AlbumContentViewModel albumContentViewModel;
    private RecyclerView albumRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen);

        RestAPIWithAACApplication.getApplicationComponent(getApplicationContext()).getAlbumContentComponent(new AlbumContentModule(getApplicationContext())).inject(this);
        albumContentViewModel = ViewModelProviders.of(this, albumContentModelFactory).get(AlbumContentViewModel.class);
        albumContentViewModel.getNetworkAlbumContents();
        albumRecyclerView = (RecyclerView) findViewById(R.id.recyclerview);
        RecyclerView.LayoutManager couponLayoutManager = new LinearLayoutManager(this);
        albumRecyclerView.setLayoutManager(couponLayoutManager);
    }

    @Override
    protected void onStart() {
        super.onStart();
        compositeDisposable.add(albumContentViewModel.getAlbumContents()
                .subscribeOn(Schedulers.computation())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<List<AlbumContentModel>>() {
                    @Override
                    public void accept(List<AlbumContentModel> albumContentModelList) throws Exception {
                        if(albumContentModelList != null) {
                            sortAlbumContentModelList(albumContentModelList);
                            RecyclerViewAdapter recyclerViewAdapter = new RecyclerViewAdapter(albumContentModelList, HomeScreenActivity.this);
                            albumRecyclerView.setAdapter(recyclerViewAdapter);
                        } else
                            Log.e("HomeScreenActivity", "No data in local database");
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        Log.e("HomeScreenActivity", "Exception while fectching data from room");
                    }
                }));
    }

    @Override
    protected void onDestroy() {
        if (compositeDisposable != null && !compositeDisposable.isDisposed()) {
            compositeDisposable.clear();
        }
        super.onDestroy();
    }

    public void sortAlbumContentModelList(List<AlbumContentModel> albumContentModelList) {
        Collections.sort(albumContentModelList, new Comparator<AlbumContentModel>() {
            public int compare(final AlbumContentModel object1, final AlbumContentModel object2) {
                return object1.getTitle().toLowerCase().compareTo(object2.getTitle().toLowerCase());
            }
        });
    }
}
