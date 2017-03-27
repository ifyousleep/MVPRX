package com.ifyou.mvprx.other.di;

import com.ifyou.mvprx.model.ModelImpl;
import com.ifyou.mvprx.presenter.BasePresenter;
import com.ifyou.mvprx.presenter.RepoInfoPresenter;
import com.ifyou.mvprx.presenter.RepoListPresenter;
import com.ifyou.mvprx.view.fragments.RepoInfoFragment;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by Baranov on 27.03.2017.
 */

@Singleton
@Component(modules = {ModelModule.class, PresenterModule.class, ViewModule.class})
public interface AppComponent {

    void inject(ModelImpl dataRepository);

    void inject(BasePresenter basePresenter);

    void inject(RepoListPresenter repoListPresenter);

    void inject(RepoInfoPresenter repoInfoPresenter);

    void inject(RepoInfoFragment repoInfoFragment);
}