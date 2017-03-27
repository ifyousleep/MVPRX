package com.ifyou.mvprx.view.adapters;

import com.ifyou.mvprx.presenter.RepoListPresenter;
import com.ifyou.mvprx.presenter.vo.Repository;

import java.util.List;

/**
 * Created by Baranov on 27.03.2017.
 */

public class RepoListAdapter extends BaseAdapter<Repository> {
    private RepoListPresenter presenter;


    public RepoListAdapter(List<Repository> list, RepoListPresenter presenter) {
        super(list);
        this.presenter = presenter;
    }

    @Override
    public void onBindViewHolder(BaseAdapter.ViewHolder viewHolder, int i) {
        Repository repo = list.get(i);
        viewHolder.text.setText(repo.getRepoName());
        viewHolder.text.setOnClickListener(v -> presenter.clickRepo(repo));
    }

    public void setRepoList(List<Repository> list) {
        this.list = list;
        notifyDataSetChanged();
    }
}