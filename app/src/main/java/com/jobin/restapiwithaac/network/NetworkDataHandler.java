package com.jobin.restapiwithaac.network;

import com.jobin.restapiwithaac.database.AlbumContentModel;

import java.util.List;

import io.reactivex.Observable;

/**
 * Class NetworkDataHandler
 * Description :
 * Created by Jobin Mathew on 07:17 28-11-2018.
 * All rights reserved @ hashincludes.com
 */

public class NetworkDataHandler implements NetworkData{

    private RetrofitAPIInterface retrofitAPIInterface;

    public NetworkDataHandler(RetrofitAPIInterface retrofitAPIInterface){
        this.retrofitAPIInterface = retrofitAPIInterface;
    }
    public Observable<List<AlbumContentModel>> getAlbumContents() {
        return retrofitAPIInterface.getAlbumContents();
    }
}
