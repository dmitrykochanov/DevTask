package com.dmko.devtask.ui.mvpbase;


public interface BaseView {

    boolean isOnline();

    void showNoInternetDialog();

    void showErrorDialog();
}
