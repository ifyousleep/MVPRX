package com.ifyou.mvprx.presenter;

import android.os.Bundle;

import com.ifyou.mvprx.presenter.mappers.RepoBranchesMapper;
import com.ifyou.mvprx.presenter.mappers.RepoContributorsMapper;
import com.ifyou.mvprx.presenter.vo.Branch;
import com.ifyou.mvprx.presenter.vo.Contributor;
import com.ifyou.mvprx.presenter.vo.Repository;
import com.ifyou.mvprx.view.fragments.RepoInfoView;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.disposables.Disposable;
import io.reactivex.observers.DisposableObserver;

/**
 * Created by Baranov on 26.03.2017.
 */

public class RepoInfoPresenter extends BasePresenter {

    private static final String BUNDLE_BRANCHES_KEY = "BUNDLE_BRANCHES_KEY";
    private static final String BUNDLE_CONTRIBUTORS_KEY = "BUNDLE_CONTRIBUTORS_KEY";

    private RepoInfoView view;

    private RepoBranchesMapper branchesMapper = new RepoBranchesMapper();
    private RepoContributorsMapper contributorsMapper = new RepoContributorsMapper();

    private List<Contributor> contributorList;
    private List<Branch> branchList;

    private Repository repository;

    public RepoInfoPresenter(RepoInfoView view, Repository repository) {
        this.view = view;
        this.repository = repository;
    }

    private void loadData() {
        String owner = repository.getOwnerName();
        String name = repository.getRepoName();

        Disposable subscriptionBranches = dataRepository.getRepoBranches(owner, name)
                .map(branchesMapper)
                .subscribeWith(new DisposableObserver<List<Branch>>() {
                    @Override
                    public void onComplete() {
                    }

                    @Override
                    public void onError(Throwable e) {
                        view.showError(e.getMessage());
                    }

                    @Override
                    public void onNext(List<Branch> list) {
                        branchList = list;
                        view.showBranches(list);
                    }
                });
        addSubscription(subscriptionBranches);

        Disposable subscriptionContributors = dataRepository.getRepoContributors(owner, name)
                .map(contributorsMapper)
                .subscribeWith(new DisposableObserver<List<Contributor>>() {
                    @Override
                    public void onComplete() {
                    }

                    @Override
                    public void onError(Throwable e) {
                        view.showError(e.getMessage());
                    }

                    @Override
                    public void onNext(List<Contributor> list) {
                        contributorList = list;
                        view.showContributors(list);
                    }
                });

        addSubscription(subscriptionContributors);
    }

    @SuppressWarnings("unchecked")
    public void onCreate(Bundle savedInstanceState) {
        if (savedInstanceState != null) {
            contributorList = (List<Contributor>) savedInstanceState.getSerializable(BUNDLE_CONTRIBUTORS_KEY);
            branchList = (List<Branch>) savedInstanceState.getSerializable(BUNDLE_BRANCHES_KEY);
        }
        if (contributorList == null || branchList == null) {
            loadData();
        } else {
            view.showBranches(branchList);
            view.showContributors(contributorList);
        }

    }

    public void onSaveInstanceState(Bundle outState) {
        if (contributorList != null)
            outState.putSerializable(BUNDLE_CONTRIBUTORS_KEY, new ArrayList<>(contributorList));
        if (branchList != null)
            outState.putSerializable(BUNDLE_BRANCHES_KEY, new ArrayList<>(branchList));

    }
}
