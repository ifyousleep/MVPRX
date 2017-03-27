package com.ifyou.mvprx.presenter;

import com.ifyou.mvprx.model.Model;
import com.ifyou.mvprx.model.ModelImpl;
import com.ifyou.mvprx.model.dto.RepositoryDTO;
import com.ifyou.mvprx.view.fragments.View;

import java.util.List;

import io.reactivex.disposables.Disposable;
import io.reactivex.disposables.Disposables;
import io.reactivex.observers.DisposableObserver;

/**
 * Created by Baranov on 25.03.2017.
 */

public class ResponseListPresenter implements Presenter {

    private Model model = new ModelImpl();
    private View view;
    private Disposable subscription = Disposables.empty();

    public ResponseListPresenter(View view) {
        this.view = view;
    }

    /*@Override
    public void onSearchButtonClick() {
        if (!subscription.isDisposed()) {
            subscription.dispose();
        }
        subscription = model.getRepoList(view.getUserName())
                .subscribeWith(new DisposableObserver<List<RepositoryDTO>>() {
                    @Override
                    public void onComplete() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        view.showError(e.getMessage());
                    }

                    @Override
                    public void onNext(List<RepositoryDTO> data) {
                        if (data != null && !data.isEmpty()) {
                            view.showData(data);
                        } else {
                            view.showEmptyList();
                        }
                    }
                });
    }*/

    @Override
    public void onStop() {
        if (!subscription.isDisposed()) {
            subscription.dispose();
        }
    }
}
