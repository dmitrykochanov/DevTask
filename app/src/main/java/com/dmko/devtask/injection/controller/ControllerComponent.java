package com.dmko.devtask.injection.controller;

import com.dmko.devtask.injection.scopes.ControllerScope;
import com.dmko.devtask.ui.screens.images.ImagesActivity;

import dagger.Subcomponent;

@ControllerScope
@Subcomponent(modules = {PresenterModule.class, ControllerModule.class})
public interface ControllerComponent {

    void inject(ImagesActivity imagesActivity);
}
