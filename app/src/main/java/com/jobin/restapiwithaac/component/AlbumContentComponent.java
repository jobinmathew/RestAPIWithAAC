package com.jobin.restapiwithaac.component;

import com.jobin.restapiwithaac.ui.HomeScreenActivity;

import dagger.Subcomponent;

/**
 * Class AlbumContentComponent
 * Description :
 * Created by Jobin Mathew on 06:46 28-11-2018.
 * All rights reserved @ hashincludes.com
 */
@Subcomponent(modules = AlbumContentModule.class)
public interface AlbumContentComponent {
    void inject(HomeScreenActivity homeScreenActivity);
}
