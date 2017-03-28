package com.ifyou.mvprx.model.api;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Baranov on 25.03.2017.
 */

public class ApiModule {

    private ApiModule() {

    }

    public static ApiInterface getApiInterface(String url) {
        Retrofit.Builder builder = new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create());
        return builder.build().create(ApiInterface.class);
    }
}