package com.ifyou.mvprx.other.di;

import com.ifyou.mvprx.presenter.RepoInfoPresenter;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Baranov on 27.03.2017.
 */

@Module
public class ViewModule {

    @Provides
    RepoInfoPresenter provideRepoInfoPresenter() {
        return new RepoInfoPresenter();
    }

}