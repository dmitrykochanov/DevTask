package com.dmko.devtask.injection.application;

import com.dmko.devtask.data.ImagesRepository;
import com.dmko.devtask.data.ImagesApi;
import com.dmko.devtask.data.ImagesRepositoryImpl;
import com.dmko.devtask.injection.scopes.ApplicationScope;
import com.dmko.devtask.utils.SchedulersFacade;
import com.dmko.devtask.utils.SchedulersFacadeImpl;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public class DataModule {

    private static final String BASE_URL = "http://dev-tasks.alef.im/";

    @Provides
    @ApplicationScope
    public Retrofit provideRetrofit() {
        return new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
    }

    @Provides
    @ApplicationScope
    public ImagesApi provideImagesApi(Retrofit retrofit) {
        return retrofit.create(ImagesApi.class);
    }

    @Provides
    @ApplicationScope
    public ImagesRepository provideImagesRepository(ImagesApi imagesApi) {
        return new ImagesRepositoryImpl(imagesApi);
    }

    @Provides
    @ApplicationScope
    public SchedulersFacade provideSchedulersFacade() {
        return new SchedulersFacadeImpl();
    }
}
