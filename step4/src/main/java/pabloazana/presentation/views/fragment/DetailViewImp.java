package pabloazana.presentation.views.fragment;

import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ImageView;
import java.util.List;

import pabloazana.DependencyInjector;
import pabloazana.presentation.presenter.DetailsViewPresenter;
import pabloazana.presentation.presenter.DetailsViewPresenter.DetailsView;
import pabloazana.presentation.views.customviews.DetailsViewFlipper;
import pabloazana.presentation.views.navigator.BrowseNavigatorImp;
import pabloazana.step4.R;

import static android.view.View.GONE;

public class DetailViewImp extends BaseViewImp<DetailsViewPresenter> implements DetailsView {

    private ImageView mVideoIcon;
    private ImageView mPictureIcon;
    private DetailsViewFlipper mDetailsViewFlipper;

    @Override
    public void onPause() {
        super.onPause();
        mDetailsViewFlipper.destroyView();
    }

    @Override
    protected void initializePresenter() {
        mPresenter = DependencyInjector.getInstance().injectDetailsViewPresenter(this,
                (DetailsViewPresenter.DetailsNavigator) getActivity());
        mPresenter.buildDetails(getActivity().getIntent().getIntExtra(BrowseNavigatorImp.AWESOME_PLACE_ID, -1),
                getActivity().getPackageName());
    }

    @Override
    protected int selectLayout() {
        return R.layout.details_view;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mVideoIcon = (ImageView) view.findViewById(R.id.icon_video_imageView);
        mPictureIcon = (ImageView) view.findViewById(R.id.icon_picture_imageView);
        mDetailsViewFlipper = (DetailsViewFlipper) view.findViewById(R.id.details_view_flipper);
        view.setFocusableInTouchMode(true);
        view.requestFocus();
        view.setOnKeyListener(onKeyBehaviour());
    }

    @Override
    public void configureView(boolean showVideo, boolean showCarousel) {
        if(!showVideo) {
            mDetailsViewFlipper.hideVideoView();
            mVideoIcon.setVisibility(GONE);
            activatePictureIcon();
        }

        if(!showCarousel) {
            mDetailsViewFlipper.hideCarouselView();
            mPictureIcon.setVisibility(GONE);
            activateVideoIcon();
        }
    }

    @Override
    public void onKeyDown() {
        mDetailsViewFlipper.showNextElement();
        activatePictureIcon();
    }

    @Override
    public void onKeyUp() {
        mDetailsViewFlipper.showPreviousElement();
        activateVideoIcon();
    }

    @Override
    public void onKeyRight() {
        mDetailsViewFlipper.showNextImageCarousel();
    }

    @Override
    public void onKeyLeft() {
        mDetailsViewFlipper.showPreviousImageCarousel();
    }

    @Override
    public void initializeCarousel(List<String> imageUriList) {
        mDetailsViewFlipper.buildCarouselView(imageUriList);
    }

    @Override
    public void initializeVideoSurface(String videoUri) {
        mDetailsViewFlipper.initializeVideoSurface(videoUri);
    }

    private View.OnKeyListener onKeyBehaviour() {
        /* Use this method for build a KeyListener in order to know when the user
        * press any key of the control */
        return null;
    }

    private void activateVideoIcon() {
        if(mVideoIcon.getVisibility() == View.VISIBLE) {
            mVideoIcon.setImageDrawable(getResources().getDrawable(R.drawable.ic_video_active));
            mPictureIcon.setImageDrawable(getResources().getDrawable(R.drawable.ic_pictures_inactive));
        }
    }

    private void activatePictureIcon() {
        if(mPictureIcon.getVisibility() == View.VISIBLE) {
            mVideoIcon.setImageDrawable(getResources().getDrawable(R.drawable.ic_video_inactive));
            mPictureIcon.setImageDrawable(getResources().getDrawable(R.drawable.ic_pictures_active));
        }
    }
}
