package com.ifyou.mvprx.view.fragments;

import android.support.v4.app.Fragment;

import com.ifyou.mvprx.presenter.BasePresenter;

/**
 * Created by Baranov on 26.03.2017.
 */

public abstract class BaseFragment extends Fragment {

    protected abstract BasePresenter getPresenter();

    @Override
    public void onStop() {
        super.onStop();
        if (getPresenter() != null) {
            getPresenter().onStop();
        }
    }
}