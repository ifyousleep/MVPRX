package com.ifyou.mvprx.view.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.ifyou.mvprx.R;

import java.util.List;

/**
 * Created by Baranov on 27.03.2017.
 */

public abstract class BaseAdapter<T> extends RecyclerView.Adapter<BaseAdapter.ViewHolder> {

    protected List<T> list;

    public BaseAdapter(List<T> list) {
        this.list = list;
    }

    public List<T> getList() {
        return list;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.text_item_layout, viewGroup, false);
        return new ViewHolder(v);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        com.lucasurbas.listitemview.ListItemView text;

        public ViewHolder(View itemView) {
            super(itemView);
            text = (com.lucasurbas.listitemview.ListItemView) itemView.findViewById(R.id.textView);
        }
    }

}
