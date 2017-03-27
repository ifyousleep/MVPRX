package com.ifyou.mvprx.view.adapters;

import com.ifyou.mvprx.presenter.vo.Contributor;

import java.util.List;

/**
 * Created by Baranov on 27.03.2017.
 */

public class ContributorsAdapter extends BaseAdapter<Contributor> {

    public ContributorsAdapter(List<Contributor> list) {
        super(list);
    }

    @Override
    public void onBindViewHolder(BaseAdapter.ViewHolder viewHolder, int i) {
        String text = list.get(i).getName();
        viewHolder.text.setTitle(text);
    }
}
