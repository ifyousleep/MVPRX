package com.ifyou.mvprx.view.fragments;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.ifyou.mvprx.R;
import com.ifyou.mvprx.presenter.BasePresenter;
import com.ifyou.mvprx.presenter.RepoListPresenter;
import com.ifyou.mvprx.presenter.vo.Repository;
import com.ifyou.mvprx.view.ActivityCallback;
import com.ifyou.mvprx.view.adapters.RepoListAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by Baranov on 27.03.2017.
 */

public class RepoListFragment extends BaseFragment implements RepoListView {

    @BindView(R.id.recycler_view)
    RecyclerView recyclerView;

    @BindView(R.id.edit_text)
    EditText editText;

    @BindView(R.id.button_search)
    Button searchButton;

    private RepoListPresenter presenter = new RepoListPresenter(this);

    private RepoListAdapter adapter;

    private ActivityCallback activityCallback;

    private Unbinder unbinder;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        Activity a;
        if (context instanceof Activity) {
            a = (Activity) context;
            try {
                activityCallback = (ActivityCallback) a;
            } catch (ClassCastException e) {
                throw new ClassCastException(a.toString()
                        + " must implement activityCallback");
            }
        }
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_repo_list, container, false);
        unbinder = ButterKnife.bind(this, view);

        LinearLayoutManager llm = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(llm);
        adapter = new RepoListAdapter(new ArrayList<>(), presenter);
        recyclerView.setAdapter(adapter);

        searchButton.setOnClickListener(v -> presenter.onSearchButtonClick());

        presenter.onCreate(savedInstanceState);

        return view;
    }


    private void makeToast(String text) {
        Snackbar.make(recyclerView, text, Snackbar.LENGTH_LONG).show();
    }

    @Override
    protected BasePresenter getPresenter() {
        return presenter;
    }


    @Override
    public void showError(String error) {
        makeToast(error);
    }

    @Override
    public void showRepoList(List<Repository> repoList) {
        adapter.setRepoList(repoList);
    }

    @Override
    public void startRepoInfoFragment(Repository repository) {
        activityCallback.startRepoInfoFragment(repository);
    }

    @Override
    public void showEmptyList() {
        makeToast(getActivity().getString(R.string.empty_list));
    }

    @Override
    public String getUserName() {
        return editText.getText().toString();
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        presenter.onSaveInstanceState(outState);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

}