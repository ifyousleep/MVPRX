package com.ifyou.mvprx.other.di.view;

import com.ifyou.mvprx.presenter.RepoListPresenter;
import com.ifyou.mvprx.view.ActivityCallback;
import com.ifyou.mvprx.view.fragments.RepoListView;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Baranov on 27.03.2017.
 */

@Module
public class ViewDynamicModule {

    private RepoListView view;

    private ActivityCallback activityCallback;

    public ViewDynamicModule(RepoListView view, ActivityCallback activityCallback) {
        this.view = view;
        this.activityCallback = activityCallback;
    }

    @Provides
    RepoListPresenter provideRepoListPresenter() {
        return new RepoListPresenter(view, activityCallback);
    }


}