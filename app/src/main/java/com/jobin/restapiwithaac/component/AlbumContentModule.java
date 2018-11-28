package com.jobin.restapiwithaac.component;

import android.arch.persistence.room.Room;
import android.content.Context;

import com.jobin.restapiwithaac.database.AlbumContentDatabase;
import com.jobin.restapiwithaac.database.AlbumContentModelDAO;
import com.jobin.restapiwithaac.network.LocalData;
import com.jobin.restapiwithaac.network.LocalDataHandler;
import com.jobin.restapiwithaac.network.NetworkData;
import com.jobin.restapiwithaac.network.NetworkDataHandler;
import com.jobin.restapiwithaac.network.RetrofitAPIInterface;

import java.util.concurrent.Executor;

import javax.inject.Named;

import dagger.Module;
import dagger.Provides;
import io.reactivex.disposables.CompositeDisposable;

/**
 * Class AlbumContentModule
 * Description :
 * Created by Jobin Mathew on 06:45 28-11-2018.
 * All rights reserved @ hashincludes.com
 */

@Module
public class AlbumContentModule {

    private Context context;

    public AlbumContentModule(Context context){
        this.context = context;
    }
    @Provides
    public AlbumContentModelDAO getAlbumContentDAO(AlbumContentDatabase albumContentDatabase){
        return albumContentDatabase.albumContentModelDAO();
    }

    @Provides
    public AlbumContentDatabase getAlbumContentDatabase(){
        return Room.databaseBuilder(context.getApplicationContext(),AlbumContentDatabase.class, "albumcontent.db").build();
    }

    @Provides
    @Named("activity")
    public CompositeDisposable getCompositeDisposable(){
        return new CompositeDisposable();
    }

    @Provides @Named("vm")
    public CompositeDisposable getVMCompositeDisposable(){
        return new CompositeDisposable();
    }

    @Provides
    public NetworkData getNetworkData(RetrofitAPIInterface retrofitAPIInterface){
        return new NetworkDataHandler(retrofitAPIInterface);
    }

    @Provides
    public LocalData getLocalData(AlbumContentModelDAO albumContentModelDAO, Executor executor){
        return new LocalDataHandler(albumContentModelDAO, executor);
    }
}
