package com.jobin.restapiwithaac.database;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

/**
 * Class AlbumContentDatabase
 * Description :
 * Created by Jobin Mathew on 06:58 28-11-2018.
 * All rights reserved @ hashincludes.com
 */

@Database(entities = {AlbumContentModel.class}, version = 1)
public abstract class AlbumContentDatabase extends RoomDatabase {
    public abstract AlbumContentModelDAO albumContentModelDAO();
}
