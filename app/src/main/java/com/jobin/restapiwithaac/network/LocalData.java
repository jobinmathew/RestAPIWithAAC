package com.jobin.restapiwithaac.network;

import com.jobin.restapiwithaac.database.AlbumContentModel;

import java.util.List;

import io.reactivex.Flowable;
import io.reactivex.Maybe;

/**
 * Class LocalData
 * Description :
 * Created by Jobin Mathew on 07:21 28-11-2018.
 * All rights reserved @ hashincludes.com
 */

public interface LocalData {
    Flowable<List<AlbumContentModel>> getAlbumContents();
    Maybe<AlbumContentModel> getAlbumContentById(int id);
    void insertAlbumContent(AlbumContentModel albumContentModel);
    void deleteAllAlbumContents();
    int getAlbumRowCount();
}
