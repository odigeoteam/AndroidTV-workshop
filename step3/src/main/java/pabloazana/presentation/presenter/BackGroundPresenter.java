package pabloazana.presentation.presenter;

import android.app.Activity;
import android.graphics.drawable.Drawable;

import java.util.Timer;
import java.util.TimerTask;

import pabloazana.controllers.data.datasource.ImageDataSource;
import pabloazana.controllers.data.datasource.ImageProviderListener;
import pabloazana.presentation.contracts.BaseNavigator;
import pabloazana.presentation.contracts.BaseView;


public abstract class BackGroundPresenter<V extends BaseView, N extends BaseNavigator> extends BasePresenter<V, N> {

    private static final int BACKGROUND_UPDATE_DELAY = 300;
    private Timer mBackgroundTimer;
    private ImageDataSource mImageDataSource;

    BackGroundPresenter(V view, N navigator, Timer backGroundTimer, ImageDataSource imageDataSource) {
        super(view, navigator);
        mBackgroundTimer = backGroundTimer;
        mImageDataSource = imageDataSource;
    }

    public void destroyView(){
        if(mBackgroundTimer != null) {
            mBackgroundTimer.cancel();
        }
    }

    public void changeBackgroundImage(String backgroundImageUri) {
        if(mBackgroundTimer != null) {
            mBackgroundTimer.cancel();
        }
        mBackgroundTimer = new Timer();
        mBackgroundTimer.schedule(new UpdateBackgroundTask(backgroundImageUri), BACKGROUND_UPDATE_DELAY);
    }

    private class UpdateBackgroundTask extends TimerTask {

        private String mBackgroundImageName;

        UpdateBackgroundTask(String backgroundImageUri) {
            mBackgroundImageName = backgroundImageUri;
        }

        @Override
        public void run() {

            mImageDataSource.getDrawableFromUri(mBackgroundImageName, new ImageProviderListener() {
                @Override
                public void onSuccess(Drawable imageDrawable) {
                    paintBackgroundImage(imageDrawable);
                }

                @Override
                public void onError() {

                }
            }, (Activity) mNavigator);
        }
    }

    protected abstract void paintBackgroundImage(Drawable backgroundDrawable);


}
