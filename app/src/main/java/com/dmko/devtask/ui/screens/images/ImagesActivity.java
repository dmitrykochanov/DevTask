package com.dmko.devtask.ui.screens.images;

import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.dmko.devtask.R;
import com.dmko.devtask.ui.mvpbase.impl.BaseActivity;
import com.dmko.devtask.ui.screens.images.recyclerview.ImagesAdapter;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ImagesActivity extends BaseActivity implements ImagesContract.View {

    @BindView(R.id.recycler_images) RecyclerView recyclerImages;

    @Inject ImagesContract.Presenter presenter;
    @Inject ImagesAdapter imagesAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_images);
        ButterKnife.bind(this);
        getControllerComponent().inject(this);
        presenter.attachView(this);

        recyclerImages.setAdapter(imagesAdapter);
        recyclerImages.setLayoutManager(new GridLayoutManager(this, isWideScreen() ? 3 : 2));
    }

    @Override
    protected void onStart() {
        super.onStart();
        presenter.loadImages();
    }

    @Override
    protected void onStop() {
        super.onStop();
        presenter.stop();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.detachView();
    }

    @Override
    public void setImages(List<String> images) {
        imagesAdapter.setImages(images);
    }

    private boolean isWideScreen() {
        return getResources().getConfiguration().screenWidthDp >= 600;
    }
}
