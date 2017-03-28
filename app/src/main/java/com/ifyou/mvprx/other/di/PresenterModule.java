package com.ifyou.mvprx.other.di;

import com.ifyou.mvprx.model.Model;
import com.ifyou.mvprx.model.ModelImpl;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import io.reactivex.disposables.CompositeDisposable;

/**
 * Created by Baranov on 27.03.2017.
 */

@Module
public class PresenterModule {

    @Provides
    @Singleton
    Model provideDataRepository() {
        return new ModelImpl();
    }

    @Provides
    CompositeDisposable provideCompositeSubscription() {
        return new CompositeDisposable();
    }
}