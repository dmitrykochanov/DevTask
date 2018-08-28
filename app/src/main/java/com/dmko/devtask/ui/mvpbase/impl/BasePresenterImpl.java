package com.dmko.devtask.ui.mvpbase.impl;


import com.dmko.devtask.ui.mvpbase.BasePresenter;
import com.dmko.devtask.ui.mvpbase.BaseView;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

public class BasePresenterImpl<T extends BaseView> implements BasePresenter<T> {

    private T view;
    private CompositeDisposable compositeDisposable = new CompositeDisposable();

    @Override
    public void attachView(T view) {
        this.view = view;
    }

    @Override
    public void detachView() {
        view = null;
    }

    @Override
    public void stop() {
        compositeDisposable.clear();
    }

    protected T getView() {
        return view;
    }

    protected boolean isViewAttached() {
        return view != null;
    }

    protected void addDisposable(Disposable disposable) {
        compositeDisposable.add(disposable);
    }
}
