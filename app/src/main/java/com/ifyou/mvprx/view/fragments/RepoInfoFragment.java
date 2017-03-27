package com.ifyou.mvprx.view.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.ifyou.mvprx.R;
import com.ifyou.mvprx.presenter.BasePresenter;
import com.ifyou.mvprx.presenter.RepoInfoPresenter;
import com.ifyou.mvprx.presenter.vo.Branch;
import com.ifyou.mvprx.presenter.vo.Contributor;
import com.ifyou.mvprx.presenter.vo.Repository;
import com.ifyou.mvprx.view.adapters.BranchesAdapter;
import com.ifyou.mvprx.view.adapters.ContributorsAdapter;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by Baranov on 27.03.2017.
 */

public class RepoInfoFragment extends BaseFragment implements RepoInfoView {

    private static final String BUNDLE_REPO_KEY = "BUNDLE_REPO_KEY";

    @BindView(R.id.repo_info)
    TextView info;

    @BindView(R.id.recycler_view_branches)
    RecyclerView branchesRecyclerView;

    @BindView(R.id.recycler_view_contributors)
    RecyclerView contributorsRecyclerView;

    @BindView(R.id.linear_layout)
    View layout;

    private Unbinder unbinder;

    private RepoInfoPresenter presenter;

    public static RepoInfoFragment newInstance(Repository repository) {
        RepoInfoFragment myFragment = new RepoInfoFragment();

        Bundle args = new Bundle();
        args.putSerializable(BUNDLE_REPO_KEY, repository);
        myFragment.setArguments(args);

        return myFragment;
    }


    @Override
    protected BasePresenter getPresenter() {
        return presenter;
    }

    private Repository getRepositoryVO() {
        return (Repository) getArguments().getSerializable(BUNDLE_REPO_KEY);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_repo_info, container, false);
        unbinder = ButterKnife.bind(this, view);

        String infoText = getRepositoryVO().getRepoName() + " (" + getRepositoryVO().getOwnerName() + ")";
        info.setText(infoText);

        branchesRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        contributorsRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        presenter = new RepoInfoPresenter(this, getRepositoryVO());
        presenter.onCreate(savedInstanceState);

        return view;
    }


    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        presenter.onSaveInstanceState(outState);
    }


    @Override
    public void showError(String error) {
        makeToast(error);
    }


    private void makeToast(String text) {
        Snackbar.make(layout, text, Snackbar.LENGTH_LONG).show();
    }

    @Override
    public void showContributors(List<Contributor> contributors) {
        branchesRecyclerView.setAdapter(new ContributorsAdapter(contributors));
    }

    @Override
    public void showBranches(List<Branch> branches) {
        contributorsRecyclerView.setAdapter(new BranchesAdapter(branches));

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

}
