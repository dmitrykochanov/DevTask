package com.dmko.devtask.data;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface ImagesApi {

    @GET("task-m-001/list.php")
    Observable<List<String>> getImages();
}
