package com.jobin.restapiwithaac.component;

import com.jobin.restapiwithaac.network.RetrofitAPIInterface;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Class ApplicationModule
 * Description :
 * Created by Jobin Mathew on 06:47 28-11-2018.
 * All rights reserved @ hashincludes.com
 */

@Module
public class ApplicationModule {

    @Singleton
    @Provides
    public Executor getExecutor(){
        return  Executors.newFixedThreadPool(2);
    }

    @Singleton
    @Provides
    public Retrofit getRemoteClient(){
        return new Retrofit.Builder()
                .baseUrl("https://jsonplaceholder.typicode.com")
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.createWithScheduler(Schedulers.io()))
                .build();
    }

    @Singleton
    @Provides
    public RetrofitAPIInterface getRetrofitClient(Retrofit retrofit){
        return retrofit.create(RetrofitAPIInterface.class);
    }
}
