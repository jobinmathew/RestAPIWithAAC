package com.jobin.restapiwithaac.database;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Class AlbumContentModel
 * Description :
 * Created by Jobin Mathew on 07:09 28-11-2018.
 * All rights reserved @ hashincludes.com
 */

@Entity
public class AlbumContentModel {

    @SerializedName("userId")
    @Expose
    public int userId;

    @PrimaryKey
    @SerializedName("id")
    @Expose
    public int id;

    @SerializedName("title")
    @Expose
    public String title;

    public AlbumContentModel (int userId, int id, String title) {
        this.id = id;
        this.userId = id;
        this.title = title;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}