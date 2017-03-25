package com.ifyou.mvprx.model;

import com.ifyou.mvprx.model.data.Response;

import java.util.List;

import io.reactivex.Observable;

/**
 * Created by Baranov on 25.03.2017.
 */

public interface Model {

    Observable<List<Response>> getRepoList(String name);
}
