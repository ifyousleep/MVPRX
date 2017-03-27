package com.ifyou.mvprx.view.adapters;

import com.ifyou.mvprx.presenter.vo.Branch;

import java.util.List;

/**
 * Created by Baranov on 27.03.2017.
 */

public class BranchesAdapter extends BaseAdapter<Branch> {

    public BranchesAdapter(List<Branch> list) {
        super(list);
    }

    @Override
    public void onBindViewHolder(BaseAdapter.ViewHolder holder, int position) {
        String text = list.get(position).getName();
        holder.text.setTitle(text);
    }
}
