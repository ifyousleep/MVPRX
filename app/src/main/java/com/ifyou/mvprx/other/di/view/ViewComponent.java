package com.ifyou.mvprx.other.di.view;

import com.ifyou.mvprx.view.fragments.RepoListFragment;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by Baranov on 27.03.2017.
 */

@Singleton
@Component(modules = {ViewDynamicModule.class})
public interface ViewComponent {
    void inject(RepoListFragment repoListFragment);
}
