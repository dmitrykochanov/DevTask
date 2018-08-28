package com.dmko.devtask.injection.application;

import com.dmko.devtask.injection.controller.ControllerComponent;
import com.dmko.devtask.injection.controller.ControllerModule;
import com.dmko.devtask.injection.controller.PresenterModule;
import com.dmko.devtask.injection.scopes.ApplicationScope;

import dagger.Component;

@ApplicationScope
@Component(modules = {DataModule.class})
public interface ApplicationComponent {

    ControllerComponent newControllerComponent(PresenterModule presenterModule, ControllerModule controllerModule);
}
