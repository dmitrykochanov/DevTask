package com.dmko.devtask.ui.mvpbase;


public interface BasePresenter<T extends BaseView> {

    void attachView(T view);

    void detachView();

    void stop();
}
