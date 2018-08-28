package com.dmko.devtask.ui;

import android.app.Application;
import android.os.StrictMode;

import com.dmko.devtask.BuildConfig;
import com.dmko.devtask.injection.application.ApplicationComponent;
import com.dmko.devtask.injection.application.DaggerApplicationComponent;
import com.dmko.devtask.injection.application.DataModule;
import com.dmko.devtask.utils.ProductionTree;

import timber.log.Timber;

public class App extends Application {

    private ApplicationComponent applicationComponent;

    public ApplicationComponent getApplicationComponent() {
        if (applicationComponent == null) {
            applicationComponent = DaggerApplicationComponent.builder()
                    .dataModule(new DataModule())
                    .build();
        }
        return applicationComponent;
    }

    @Override
    public void onCreate() {
        super.onCreate();

        if (BuildConfig.DEBUG) {
            StrictMode.enableDefaults();
            Timber.plant(new Timber.DebugTree());
        } else {
            Timber.plant(new ProductionTree());
        }
    }
}
