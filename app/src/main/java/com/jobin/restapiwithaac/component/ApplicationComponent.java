package com.jobin.restapiwithaac.component;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Class AppComponent
 * Description :
 * Created by Jobin Mathew on 06:44 28-11-2018.
 * All rights reserved @ hashincludes.com
 */

@Singleton
@Component(modules={ApplicationModule.class})
public interface ApplicationComponent {
    AlbumContentComponent getAlbumContentComponent(AlbumContentModule albumContentModule);
}
