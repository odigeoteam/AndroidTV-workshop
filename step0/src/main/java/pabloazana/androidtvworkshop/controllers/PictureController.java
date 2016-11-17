package pabloazana.androidtvworkshop.controllers;

import android.content.Context;

import pabloazana.androidtvworkshop.R;
import pabloazana.androidtvworkshop.views.MainView;

public class PictureController extends PhotoController<MainView> {

    private Context mContext;

    public PictureController(MainView view) {
        super(view);
        mContext = (Context) view;
    }

    @Override
    public void doPhotoAction() {
        paintDrawable(mContext.getResources().getDrawable(R.drawable.splash));
    }
}
