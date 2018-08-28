package com.dmko.devtask.data;

import java.util.List;

import io.reactivex.Observable;
import timber.log.Timber;

public class ImagesRepositoryImpl implements ImagesRepository {

    private ImagesApi imagesApi;

    public ImagesRepositoryImpl(ImagesApi imagesApi) {
        this.imagesApi = imagesApi;
    }

    @Override
    public Observable<List<String>> getImagesUrls() {
        return imagesApi.getImages()
                .doOnNext(imagesUrls -> Timber.d("Loaded %s image urls", imagesUrls.size()));
    }
}
