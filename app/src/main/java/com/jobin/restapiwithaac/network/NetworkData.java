package com.jobin.restapiwithaac.network;

import com.jobin.restapiwithaac.database.AlbumContentModel;

import java.util.List;

import io.reactivex.Observable;

/**
 * Class NetworkData
 * Description :
 * Created by Jobin Mathew on 07:16 28-11-2018.
 * All rights reserved @ hashincludes.com
 */

public interface NetworkData {
    Observable<List<AlbumContentModel>> getAlbumContents();
}
