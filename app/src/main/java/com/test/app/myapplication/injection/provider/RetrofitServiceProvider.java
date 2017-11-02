package com.test.app.myapplication.injection.provider;

import javax.inject.Inject;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;


/**
 * Created by Vist on 12.09.2016.
 */
public class RetrofitServiceProvider {
    private Retrofit.Builder service;
    private OkHttpClient defaultHttpClient;

    @Inject
    public RetrofitServiceProvider() {

        defaultHttpClient = new OkHttpClient.Builder()
        .build();
        service = new Retrofit.Builder()
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .client(defaultHttpClient)
                .baseUrl("https://jsonplaceholder.typicode.com/");

    }

    public <T>T getServiceRetrofit(final Class<T> clazz) {
    return service.build().create(clazz);
    }

}
