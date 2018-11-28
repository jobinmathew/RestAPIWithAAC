package com.jobin.restapiwithaac;

import android.app.Application;
import android.content.Context;

import com.jobin.restapiwithaac.component.ApplicationComponent;
import com.jobin.restapiwithaac.component.DaggerApplicationComponent;

/**
 * Class RestAPIWithAACApplication
 * Description :
 * Created by Jobin Mathew on 06:39 28-11-2018.
 * All rights reserved @ hashincludes.com
 */

public class RestAPIWithAACApplication extends Application{

    public static Context mContext;
    private ApplicationComponent mApplicationComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        mApplicationComponent = DaggerApplicationComponent.builder().build();
        mContext = getApplicationContext();
    }

    public static ApplicationComponent getApplicationComponent(Context context) {
        return ((RestAPIWithAACApplication)context.getApplicationContext()).mApplicationComponent;
    }

    @Override
    public void onTerminate() {
        super.onTerminate();
    }

}
