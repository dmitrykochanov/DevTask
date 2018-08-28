package com.dmko.devtask.injection.controller;

import com.dmko.devtask.injection.scopes.ControllerScope;
import com.dmko.devtask.ui.screens.images.recyclerview.ImagesAdapter;

import dagger.Module;
import dagger.Provides;

@Module
public class ControllerModule {

    @Provides
    @ControllerScope
    public ImagesAdapter provideImagesAdapter() {
        return new ImagesAdapter();
    }
}
