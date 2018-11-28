package com.jobin.restapiwithaac;

import android.arch.persistence.room.Room;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;

import com.jobin.restapiwithaac.database.AlbumContentDatabase;
import com.jobin.restapiwithaac.database.AlbumContentModel;
import com.jobin.restapiwithaac.database.AlbumContentModelDAO;
import com.jobin.restapiwithaac.viewmodel.AlbumContentViewModel;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Flowable;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertNotNull;

/**
 * Class DatabaseTest
 * Description :
 * Created by Jobin Mathew on 08:36 28-11-2018.
 * All rights reserved @ hashincludes.com
 */

@RunWith(AndroidJUnit4.class)

public class DatabaseTest {

    @Inject
    private AlbumContentViewModel albumContentViewModel;

    protected AlbumContentDatabase db;
    AlbumContentModelDAO aAlbumContentModelDAO;
    @Before
    public void initDb() {
        db = Room.inMemoryDatabaseBuilder(InstrumentationRegistry.getContext(), AlbumContentDatabase.class).build();
    }

    @Test
    public void insertAndLoad() throws InterruptedException {
        aAlbumContentModelDAO = db.albumContentModelDAO();
        final AlbumContentModel albumContentModel = new AlbumContentModel(1,111,"This is my new album");
        aAlbumContentModelDAO.insertAlbumContent(albumContentModel);
        assertEquals(1, aAlbumContentModelDAO.getAlbumRowCount());
        aAlbumContentModelDAO.deleteAllAlbumContents();
        assertEquals(0, aAlbumContentModelDAO.getAlbumRowCount());
    }

    @After
    public void closeDb() {
        db.close();
    }
}
