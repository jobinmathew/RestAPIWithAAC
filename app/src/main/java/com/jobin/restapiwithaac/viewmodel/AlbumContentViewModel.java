package com.jobin.restapiwithaac.viewmodel;

import android.arch.lifecycle.ViewModel;
import android.util.Log;

import com.jobin.restapiwithaac.database.AlbumContentModel;
import com.jobin.restapiwithaac.network.LocalData;
import com.jobin.restapiwithaac.network.NetworkData;

import java.util.List;

import io.reactivex.Flowable;
import io.reactivex.Maybe;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * Class AlbumContentViewModel
 * Description :
 * Created by Jobin Mathew on 07:46 28-11-2018.
 * All rights reserved @ hashincludes.com
 */

public class AlbumContentViewModel extends ViewModel {

    private LocalData localData;
    private NetworkData networkData;
    private CompositeDisposable compositeDisposable;

    public AlbumContentViewModel(LocalData localData, NetworkData networkData, CompositeDisposable disposable){
        this.localData = localData;
        this.networkData = networkData;
        compositeDisposable = disposable;
    }

    public Flowable<List<AlbumContentModel>> getAlbumContents(){
        return localData.getAlbumContents();
    }

    public Maybe<AlbumContentModel> getAlbumContentById(int id){
        return localData.getAlbumContentById(id);
    }

    public void insertAlbumContent(AlbumContentModel albumContentModel){
        localData.insertAlbumContent(albumContentModel);
    }

    public void deleteAllAlbumContents(){
        localData.deleteAllAlbumContents();
    }

    public int getAlbumContentsRowCount() {
        return localData.getAlbumRowCount();
    }

    public void getNetworkAlbumContents(){
        compositeDisposable.add(io.reactivex.Observable.just(1)
                .subscribeOn(Schedulers.computation())
                .flatMap(i -> { return networkData.getAlbumContents();})
                .subscribeOn(Schedulers.io())
                .subscribe(new Consumer<List<AlbumContentModel>>() {
                    @Override
                    public void accept(List<AlbumContentModel> albumContentModelList) throws Exception {
                        for(AlbumContentModel albumContentModel : albumContentModelList){
                            localData.insertAlbumContent(albumContentModel);
                        }
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        Log.e("TAG", "Exception while getting data from network :", throwable);
                    }
                }));

    }
    @Override
    public void onCleared(){
        if (compositeDisposable != null && !compositeDisposable.isDisposed()) {
            compositeDisposable.clear();
        }
    }

}
