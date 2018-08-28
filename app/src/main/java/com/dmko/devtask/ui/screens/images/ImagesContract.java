package com.dmko.devtask.ui.screens.images;

import com.dmko.devtask.ui.mvpbase.BasePresenter;
import com.dmko.devtask.ui.mvpbase.BaseView;

import java.util.List;

public interface ImagesContract {

    interface View extends BaseView {

        void setImages(List<String> images);
    }

    interface Presenter extends BasePresenter<View> {

        void loadImages();
    }
}
