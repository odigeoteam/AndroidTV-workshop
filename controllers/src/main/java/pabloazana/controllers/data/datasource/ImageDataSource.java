package pabloazana.controllers.data.datasource;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.os.Handler;
import android.os.Looper;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.ViewTreeObserver;
import android.widget.ImageView;

import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;


public class ImageDataSource {

    private DisplayMetrics mMetrics;
    private Context mContext;

    public ImageDataSource(Context context) {
        mMetrics = new DisplayMetrics();
        mContext = context;
    }

    public void getDrawableFromUri(final String name, final ImageProviderListener imageListener, final Activity context) {

        context.getWindowManager().getDefaultDisplay().getMetrics(mMetrics);

        final int width = mMetrics.widthPixels;
        final int height = mMetrics.heightPixels;
        final ImageView image = new ImageView(context);

        Handler handler = new Handler(Looper.getMainLooper());
        handler.post(new Runnable() {
            @Override
            public void run() {
                Picasso.with(context).
                        load(getResourceIdByName(name, "drawable")).resize(width, height).
                        centerCrop().
                        into(image, new Callback() {
                            @Override
                            public void onSuccess() {
                                imageListener.onSuccess(image.getDrawable());
                            }

                            @Override
                            public void onError() {

                            }
                        })
                ;
            }
        });
    }

    public void paintImage(final ImageView imageView, final String imageName) {

        ViewTreeObserver vto = imageView.getViewTreeObserver();
        vto.addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener() {
            public boolean onPreDraw() {
                imageView.getViewTreeObserver().removeOnPreDrawListener(this);
                Picasso.with(mContext).load(getResourceIdByName(imageName, "drawable")).
                        resize(imageView.getMeasuredWidth(), imageView.getMeasuredHeight()).centerCrop().into(imageView);
                return true;
            }
        });
    }


    public int getResourceIdByName(String resourceName, String resourceType) {
        Resources resources = mContext.getResources();
        return resources.getIdentifier(resourceName, resourceType, mContext.getPackageName());
    }


}
