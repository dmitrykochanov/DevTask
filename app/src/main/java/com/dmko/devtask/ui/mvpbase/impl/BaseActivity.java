package com.dmko.devtask.ui.mvpbase.impl;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;

import com.dmko.devtask.R;
import com.dmko.devtask.injection.controller.ControllerComponent;
import com.dmko.devtask.injection.controller.ControllerModule;
import com.dmko.devtask.injection.controller.PresenterModule;
import com.dmko.devtask.ui.App;
import com.dmko.devtask.ui.mvpbase.BaseView;

public abstract class BaseActivity extends AppCompatActivity implements BaseView {

    protected ControllerComponent getControllerComponent() {
        return ((App) getApplication())
                .getApplicationComponent()
                .newControllerComponent(new PresenterModule(), new ControllerModule());
    }

    @Override
    public void showNoInternetDialog() {
        new AlertDialog.Builder(this)
                .setTitle(R.string.title_no_internet)
                .setPositiveButton(R.string.button_ok, null)
                .show();
    }

    @Override
    public void showErrorDialog() {
        new AlertDialog.Builder(this)
                .setTitle(R.string.title_error)
                .setPositiveButton(R.string.button_ok, null)
                .show();
    }

    @SuppressWarnings("ConstantConditions")
    @Override
    public boolean isOnline() {
        ConnectivityManager cm = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetwork = cm.getActiveNetworkInfo();
        return activeNetwork != null && activeNetwork.isConnectedOrConnecting();
    }
}
