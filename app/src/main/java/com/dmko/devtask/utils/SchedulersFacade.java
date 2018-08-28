package com.dmko.devtask.utils;

import io.reactivex.Scheduler;

public interface SchedulersFacade {

    Scheduler io();

    Scheduler ui();
}
