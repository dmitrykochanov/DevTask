package com.dmko.devtask.ui.screens.images;

import com.dmko.devtask.data.ImagesRepository;
import com.dmko.devtask.ui.mvpbase.impl.BasePresenterImpl;
import com.dmko.devtask.utils.SchedulersFacade;

import timber.log.Timber;

public class ImagesPresenter extends BasePresenterImpl<ImagesContract.View> implements ImagesContract.Presenter {

    private SchedulersFacade schedulers;
    private ImagesRepository imagesRepository;

    public ImagesPresenter(SchedulersFacade schedulersFacade, ImagesRepository imagesRepository) {
        this.schedulers = schedulersFacade;
        this.imagesRepository = imagesRepository;
    }

    @Override
    public void loadImages() {
        if (isViewAttached() && getView().isOnline()) {
            addDisposable(imagesRepository.getImagesUrls()
                    .subscribeOn(schedulers.io())
                    .observeOn(schedulers.ui())
                    .subscribe(imagesUrls -> {
                        if (isViewAttached()) {
                            Timber.d("Sending %s images urls to the view", imagesUrls.size());
                            getView().setImages(imagesUrls);
                        }
                    }, throwable -> {
                        Timber.e(throwable);
                        if (isViewAttached()) {
                            Timber.d("Showing error dialog");
                            getView().showErrorDialog();
                        }
                    }));
        } else {
            Timber.d("Showing no internet dialog");
            getView().showNoInternetDialog();
        }
    }
}
