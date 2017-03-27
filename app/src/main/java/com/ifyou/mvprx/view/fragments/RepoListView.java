package com.ifyou.mvprx.view.fragments;

import com.ifyou.mvprx.presenter.vo.Repository;

import java.util.List;

/**
 * Created by Baranov on 26.03.2017.
 */

public interface RepoListView extends View {

    void showRepoList(List<Repository> vo);

    void startRepoInfoFragment(Repository vo);

    void showEmptyList();

    String getUserName();
}