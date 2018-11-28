package com.jobin.restapiwithaac.viewmodel;

import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;

import com.jobin.restapiwithaac.network.LocalData;
import com.jobin.restapiwithaac.network.NetworkData;

import javax.inject.Inject;
import javax.inject.Named;

import io.reactivex.disposables.CompositeDisposable;

/**
 * Class AlbumContentModelFactory
 * Description :
 * Created by Jobin Mathew on 07:55 28-11-2018.
 * All rights reserved @ hashincludes.com
 */

public class AlbumContentModelFactory implements ViewModelProvider.Factory {

    @Inject
    LocalData localData;
    @Inject
    NetworkData networkData;
    @Inject
    @Named("vm")
    CompositeDisposable compositeDisposable;

    @Inject
    public AlbumContentModelFactory() {
    }

    @Override
    public <T extends ViewModel> T create(Class<T> modelClass) {
        if (modelClass.isAssignableFrom(AlbumContentViewModel.class)) {
            return (T) new AlbumContentViewModel(localData, networkData, compositeDisposable);
        }
        throw new IllegalArgumentException("Exception in AlbumContentModelFactory");
    }
}
