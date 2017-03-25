package com.ifyou.mvprx.model.api;

import com.ifyou.mvprx.model.data.Response;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by Baranov on 25.03.2017.
 */

public interface ApiInterface {

    @GET("users/{user}/repos")
    Observable<List<Response>> getRepositories(@Path("user") String user);

}