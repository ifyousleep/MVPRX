package com.ifyou.mvprx.model;

import com.ifyou.mvprx.model.api.ApiInterface;
import com.ifyou.mvprx.model.api.ApiModule;
import com.ifyou.mvprx.model.dto.BranchDTO;
import com.ifyou.mvprx.model.dto.ContributorDTO;
import com.ifyou.mvprx.model.dto.RepositoryDTO;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.ObservableTransformer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by Baranov on 25.03.2017.
 */

public class ModelImpl implements Model {

    private final ObservableTransformer schedulersTransformer;
    private ApiInterface apiInterface = ApiModule.getApiInterface();

    public ModelImpl() {
        schedulersTransformer = o -> (o).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .unsubscribeOn(Schedulers.io());
    }

    /*@Override
    public Observable<List<RepositoryDTO>> getRepoList(String name) {
        return apiInterface.getRepositories(name)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }*/

    @Override
    public Observable<List<RepositoryDTO>> getRepoList(String name) {
        return apiInterface
                .getRepositories(name)
                .compose(applySchedulers());
    }

    @Override
    public Observable<List<BranchDTO>> getRepoBranches(String owner, String name) {
        return apiInterface
                .getBranches(owner, name)
                .compose(applySchedulers());
    }

    @Override
    public Observable<List<ContributorDTO>> getRepoContributors(String owner, String name) {
        return apiInterface
                .getContributors(owner, name)
                .compose(applySchedulers());
    }

    @SuppressWarnings("unchecked")
    private <T> ObservableTransformer<T, T> applySchedulers() {
        return (ObservableTransformer<T, T>) schedulersTransformer;
    }
}
