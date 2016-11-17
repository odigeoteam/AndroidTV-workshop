package pabloazana.presentation.views.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import pabloazana.DependencyInjector;
import pabloazana.controllers.data.datasource.ImageDataSource;
import pabloazana.step4.R;

public class ImageCarouselFragment extends Fragment {

    private static final String IMAGE_URI = "IMAGE_URI";
    private ImageView mCarouselImageView;

    public static ImageCarouselFragment newInstance(String imageUri) {
        ImageCarouselFragment instance = new ImageCarouselFragment();
        Bundle bundle = new Bundle();
        bundle.putString(IMAGE_URI, imageUri);
        instance.setArguments(bundle);
        return instance;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.carousel_image_layout, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mCarouselImageView = (ImageView) view.findViewById(R.id.carousel_image_view);

        paintImage(getArguments().getString(IMAGE_URI));
    }

    private void paintImage(String imageUri) {
        ImageDataSource imageDataSource = DependencyInjector.getInstance().injectImageDataSource(getActivity());
        imageDataSource.paintImage(mCarouselImageView, imageUri);
    }
}
