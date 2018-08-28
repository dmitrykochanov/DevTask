package com.dmko.devtask.injection.controller;

import com.dmko.devtask.data.ImagesRepository;
import com.dmko.devtask.injection.scopes.ControllerScope;
import com.dmko.devtask.ui.screens.images.ImagesContract;
import com.dmko.devtask.ui.screens.images.ImagesPresenter;
import com.dmko.devtask.utils.SchedulersFacade;

import dagger.Module;
import dagger.Provides;

@Module
public class PresenterModule {

    @Provides
    @ControllerScope
    public ImagesContract.Presenter provideImagesPresenter(SchedulersFacade schedulers, ImagesRepository imagesRepository) {
        return new ImagesPresenter(schedulers, imagesRepository);
    }
}
