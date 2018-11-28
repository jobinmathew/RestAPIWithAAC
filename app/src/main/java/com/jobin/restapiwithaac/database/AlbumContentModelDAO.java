package com.jobin.restapiwithaac.database;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import java.util.List;

import io.reactivex.Flowable;
import io.reactivex.Maybe;

/**
 * Class AlbumContentModelDAO
 * Description :
 * Created by Jobin Mathew on 07:10 28-11-2018.
 * All rights reserved @ hashincludes.com
 */

@Dao
public interface AlbumContentModelDAO {
    @Query("SELECT * FROM AlbumContentModel")
    Flowable<List<AlbumContentModel>> getAlbumContents();

    @Query("SELECT * FROM AlbumContentModel WHERE id = :id ")
    Maybe<AlbumContentModel> getAlbumContentById(int id);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAlbumContent(AlbumContentModel albumContentModel);

    @Query("DELETE FROM AlbumContentModel")
    void deleteAllAlbumContents();

    @Query("SELECT COUNT(*) FROM AlbumContentModel")
    int getAlbumRowCount();
}
