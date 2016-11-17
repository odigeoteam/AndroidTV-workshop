package pabloazana.androidtvworkshop.controllers;

import android.app.Activity;
import android.content.Intent;
import android.provider.MediaStore;

import pabloazana.androidtvworkshop.views.MainView;

public class CameraController extends PhotoController<MainView> {

    public static final int REQUEST_IMAGE_CAPTURE = 1;

    private Activity mActivity;

    public CameraController(MainView view) {
        super(view);
        mActivity = (Activity) view;
    }

    @Override
    public void doPhotoAction() {

        Intent takePhotoIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if(takePhotoIntent.resolveActivity(mActivity.getPackageManager()) != null) {
            mActivity.startActivityForResult(takePhotoIntent, REQUEST_IMAGE_CAPTURE);
        }
    }


}
