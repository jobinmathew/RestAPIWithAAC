package com.jobin.restapiwithaac.network;

import com.jobin.restapiwithaac.database.AlbumContentModel;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;

/**
 * Class RetrofitAPIInterface
 * Description :
 * Created by Jobin Mathew on 06:55 28-11-2018.
 * All rights reserved @ hashincludes.com
 */

public interface RetrofitAPIInterface {
    @GET("/albums")
    Observable<List<AlbumContentModel>> getAlbumContents();
}
