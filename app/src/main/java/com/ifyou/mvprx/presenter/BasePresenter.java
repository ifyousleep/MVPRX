package com.ifyou.mvprx.presenter;

import com.ifyou.mvprx.model.Model;
import com.ifyou.mvprx.model.ModelImpl;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

/**
 * Created by Baranov on 26.03.2017.
 */

public class BasePresenter implements Presenter {

    protected Model dataRepository = new ModelImpl();
    private CompositeDisposable compositeSubscription = new CompositeDisposable();

    protected void addSubscription(Disposable subscription) {
        compositeSubscription.add(subscription);
    }

    @Override
    public void onStop() {
        compositeSubscription.clear();
    }
}
