package pabloazana.androidtvworkshop.controllers;


import android.graphics.drawable.Drawable;

import pabloazana.androidtvworkshop.views.MainView;

public abstract class PhotoController<V extends MainView> {

    private V mView;

    PhotoController(V view) {
        mView = view;
    }

    public abstract void doPhotoAction();

    void paintDrawable(Drawable drawable) {
        mView.changeBackground(drawable);
    }

}
