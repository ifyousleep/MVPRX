package com.ifyou.mvprx.model.api;

import com.ifyou.mvprx.model.dto.BranchDTO;
import com.ifyou.mvprx.model.dto.ContributorDTO;
import com.ifyou.mvprx.model.dto.RepositoryDTO;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by Baranov on 25.03.2017.
 */

public interface ApiInterface {

    @GET("users/{user}/repos")
    Observable<List<RepositoryDTO>> getRepositories(@Path("user") String user);

    @GET("/repos/{owner}/{repo}/contributors")
    Observable<List<ContributorDTO>> getContributors(@Path("owner") String owner, @Path("repo") String repo);

    @GET("/repos/{owner}/{repo}/branches")
    Observable<List<BranchDTO>> getBranches(@Path("owner") String owner, @Path("repo") String repo);

}