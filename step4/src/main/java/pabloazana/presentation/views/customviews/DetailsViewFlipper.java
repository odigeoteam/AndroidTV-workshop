package pabloazana.presentation.views.customviews;


import android.content.Context;
import android.graphics.SurfaceTexture;
import android.support.v4.app.FragmentActivity;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.Surface;
import android.view.TextureView;
import android.widget.RelativeLayout;
import android.widget.ViewFlipper;

import java.io.IOException;
import java.util.List;

import pabloazana.DependencyInjector;
import pabloazana.controllers.video.VideoController;
import pabloazana.presentation.views.adapters.CarouselPagerAdapter;
import pabloazana.presentation.views.utils.ZoomOutPageTransformer;
import pabloazana.step4.R;

public class DetailsViewFlipper extends ViewFlipper implements TextureView.SurfaceTextureListener{

    private int mMaxVerticalElements;
    private int mMaxHorizontalElements;

    private TextureView mVideoTextureView;
    private CustomDurationViewPager mCarouselViewPager;
    private ViewFlipper mViewFlipper;
    private RelativeLayout mVideoLayout;

    private String mVideoUri;
    private VideoController mVideoController;
    private int mCurrentPosition;
    private int mCurrentImageCarouselPosition;
    private Context mContext;

    public DetailsViewFlipper(Context context) {
        this(context, null);
    }

    public DetailsViewFlipper(Context context, AttributeSet attrs) {
        super(context, attrs);
        mContext = context;
        init();
    }

    public void init() {
        mCurrentPosition = 0;
        mMaxVerticalElements = 2;

        LayoutInflater inflater = (LayoutInflater) mContext
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.details_view_flipper, this, true);

        mViewFlipper = (ViewFlipper) findViewById(R.id.verticalFlipper);
        mVideoTextureView = (TextureView) findViewById(R.id.video_textureView);
        mCarouselViewPager = (CustomDurationViewPager) findViewById(R.id.carousel_view_pager);
        mVideoLayout = (RelativeLayout) findViewById(R.id.video_layout);

    }

    public void buildCarouselView(List<String> imageUriList) {
        mMaxHorizontalElements = imageUriList.size();
        mCurrentImageCarouselPosition = 0;
        mCarouselViewPager.setScrollDurationFactor(8);
        FragmentActivity activity = (FragmentActivity) getContext();
        mCarouselViewPager.setAdapter(new CarouselPagerAdapter(activity.getSupportFragmentManager(), imageUriList));
        mCarouselViewPager.setPageTransformer(true, new ZoomOutPageTransformer());
    }

    public void initializeVideoSurface(String videoUri) {
        mVideoController = DependencyInjector.getInstance().injectVideoController(getContext());
        mVideoUri = videoUri;
        mVideoTextureView.setSurfaceTextureListener(this);
    }

    public void showNextElement() {
        if (mCurrentPosition < mMaxVerticalElements - 1) {
            mCurrentPosition++;
            mVideoController.pausePlaying();
            mViewFlipper.setOutAnimation(getContext(), R.anim.slide_out_from_top);
            mViewFlipper.setInAnimation(getContext(), R.anim.slide_in_from_button);
            mViewFlipper.showNext();
        }
    }

    public void showPreviousElement() {
        if (mCurrentPosition > 0) {
            mCurrentPosition--;
            mVideoController.continuePlaying();
            mViewFlipper.setInAnimation(getContext(), R.anim.slide_in_from_top);
            mViewFlipper.setOutAnimation(getContext(), R.anim.slide_out_from_button);
            mViewFlipper.showPrevious();
        }
    }

    public void showNextImageCarousel() {
        if (mCurrentPosition == mMaxVerticalElements -1  && mCurrentImageCarouselPosition < mMaxHorizontalElements) {
            mCurrentImageCarouselPosition++;
            goToCarouselPosition(mCurrentImageCarouselPosition);

        }
    }

    public void showPreviousImageCarousel() {
        if (mCurrentPosition == mMaxVerticalElements - 1 && mCurrentImageCarouselPosition > 0) {
            mCurrentImageCarouselPosition--;
            goToCarouselPosition(mCurrentImageCarouselPosition);
        }
    }

    public void goToCarouselPosition(int position) {
        mCarouselViewPager.setCurrentItem(position);
    }

    public void destroyView() {
        mVideoController.releaseMediaPlayer();
    }

    public void hideVideoView() {
        mViewFlipper.removeView(mVideoLayout);
        mMaxVerticalElements = 1;
    }

    public void hideCarouselView() {
        mViewFlipper.removeView(mCarouselViewPager);
        mMaxVerticalElements = 1;
    }


    @Override
    public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int width, int height) {
        Surface surface = new Surface(surfaceTexture);
        try {
            mVideoController.setDataSource(mVideoUri, surface);
        } catch (IOException ignored) {

        }
    }

    @Override
    public void onSurfaceTextureSizeChanged(SurfaceTexture surface, int width, int height) { }

    @Override
    public boolean onSurfaceTextureDestroyed(SurfaceTexture surface) {
        return false;
    }

    @Override
    public void onSurfaceTextureUpdated(SurfaceTexture surface) { }
}
