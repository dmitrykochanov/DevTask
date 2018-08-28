package com.dmko.devtask.data;

import java.util.List;

import io.reactivex.Observable;

public interface ImagesRepository {

    Observable<List<String>> getImagesUrls();
}
