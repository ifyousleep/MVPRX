package com.ifyou.mvprx.view.fragments;

import com.ifyou.mvprx.presenter.vo.Branch;
import com.ifyou.mvprx.presenter.vo.Contributor;

import java.util.List;

/**
 * Created by Baranov on 26.03.2017.
 */

public interface RepoInfoView extends View {

    void showContributors(List<Contributor> contributors);

    void showBranches(List<Branch> branches);

}