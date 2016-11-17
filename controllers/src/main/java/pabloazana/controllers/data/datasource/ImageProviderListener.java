package pabloazana.controllers.data.datasource;

import android.graphics.drawable.Drawable;


public interface ImageProviderListener {

    void onSuccess(Drawable imageDrawable);
    void onError();
}
