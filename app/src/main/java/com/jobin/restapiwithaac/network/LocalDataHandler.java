package com.jobin.restapiwithaac.network;

import com.jobin.restapiwithaac.database.AlbumContentModel;
import com.jobin.restapiwithaac.database.AlbumContentModelDAO;

import java.util.List;
import java.util.concurrent.Executor;

import io.reactivex.Flowable;
import io.reactivex.Maybe;

/**
 * Class LocalDataHandler
 * Description :
 * Created by Jobin Mathew on 07:22 28-11-2018.
 * All rights reserved @ hashincludes.com
 */

public class LocalDataHandler implements LocalData {

    private AlbumContentModelDAO couponDAO;
    private Executor executor;

    public LocalDataHandler(AlbumContentModelDAO couponDAO, Executor executor) {
        this.couponDAO = couponDAO;
        this.executor = executor;
    }

    @Override
    public Flowable<List<AlbumContentModel>> getAlbumContents() {
        return couponDAO.getAlbumContents();
    }

    @Override
    public Maybe<AlbumContentModel> getAlbumContentById(int id) {
        return couponDAO.getAlbumContentById(id);
    }

    @Override
    public void insertAlbumContent(AlbumContentModel albumContentModel) {
        executor.execute(() -> {
            couponDAO.insertAlbumContent(albumContentModel);
        });
    }

    @Override
    public void deleteAllAlbumContents() {
        executor.execute(() -> {
            couponDAO.deleteAllAlbumContents();
        });
    }

    @Override
    public int getAlbumRowCount() {
        return couponDAO.getAlbumRowCount();
    }
}
