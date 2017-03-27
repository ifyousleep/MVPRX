package com.ifyou.mvprx.presenter;

import android.os.Bundle;
import android.text.TextUtils;

import com.ifyou.mvprx.presenter.mappers.RepoListMapper;
import com.ifyou.mvprx.presenter.vo.Repository;
import com.ifyou.mvprx.view.fragments.RepoListView;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.disposables.Disposable;
import io.reactivex.observers.DisposableObserver;

/**
 * Created by Baranov on 27.03.2017.
 */

public class RepoListPresenter extends BasePresenter {

    private static final String BUNDLE_REPO_LIST_KEY = "BUNDLE_REPO_LIST_KEY";

    private RepoListView view;

    private RepoListMapper repoListMapper = new RepoListMapper();

    private List<Repository> repoList;

    public RepoListPresenter(RepoListView view) {
        this.view = view;
    }

    public void onSearchButtonClick() {
        String name = view.getUserName();
        if (TextUtils.isEmpty(name)) return;

        Disposable subscription = dataRepository.getRepoList(name)
                .map(repoListMapper)
                .subscribeWith(new DisposableObserver<List<Repository>>() {
                    @Override
                    public void onComplete() {
                    }

                    @Override
                    public void onError(Throwable e) {
                        view.showError(e.getMessage());
                    }

                    @Override
                    public void onNext(List<Repository> list) {
                        if (list != null && !list.isEmpty()) {
                            repoList = list;
                            view.showRepoList(list);
                        } else {
                            view.showEmptyList();
                        }
                    }
                });
        addSubscription(subscription);
    }

    @SuppressWarnings("unchecked")
    public void onCreate(Bundle savedInstanceState) {
        if (savedInstanceState != null) {
            repoList = (List<Repository>) savedInstanceState.getSerializable(BUNDLE_REPO_LIST_KEY);
        }

        if (!isRepoListEmpty()) {
            view.showRepoList(repoList);
        }
    }

    private boolean isRepoListEmpty() {
        return repoList == null || repoList.isEmpty();
    }

    public void onSaveInstanceState(Bundle outState) {
        if (!isRepoListEmpty()) {
            outState.putSerializable(BUNDLE_REPO_LIST_KEY, new ArrayList<>(repoList));
        }
    }

    public void clickRepo(Repository repository) {
        view.startRepoInfoFragment(repository);
    }

}
