package pabloazana.presentation.presenter;

import android.view.KeyEvent;
import android.view.Surface;

import com.pabloazana.models.Detail;
import com.pabloazana.usecases.BaseUseCase;
import com.pabloazana.usecases.GetDetailsUseCase;

import java.io.IOException;
import java.util.List;

import pabloazana.controllers.data.datasource.ImageDataSource;
import pabloazana.controllers.video.VideoController;
import pabloazana.presentation.contracts.BaseNavigator;
import pabloazana.presentation.contracts.BaseView;


public class DetailsViewPresenter extends BasePresenter<DetailsViewPresenter.DetailsView, DetailsViewPresenter.DetailsNavigator> {

    private GetDetailsUseCase mGetDetailsUseCase;
    private ImageDataSource mImageDataSource;

    public DetailsViewPresenter(DetailsView view, DetailsNavigator navigator, GetDetailsUseCase getDetailsUseCase,
                                ImageDataSource imageDataSource) {
        super(view, navigator);
        mGetDetailsUseCase = getDetailsUseCase;
        mImageDataSource = imageDataSource;
    }

    public void buildDetails(int awesomePlaceId, final String packageName) {
        mGetDetailsUseCase.setAwesomePlaceId(awesomePlaceId);
        mGetDetailsUseCase.execute(new BaseUseCase.UseCaseListener<Detail>() {
            @Override
            public void onSuccess(Detail detail) {
                configureDetailsView(detail);
                String uri = "android.resource://" + packageName + "/" +
                        mImageDataSource.getResourceIdByName(detail.getVideoUri(), "raw");
                mView.initializeVideoSurface(uri);
                buildImagesCarousel(detail);
            }

            @Override
            public void onError(Exception exception) {
            }
        });
    }

    private void configureDetailsView(Detail detail) {
        boolean thereIsVideoAvailable = !detail.getVideoUri().equals("");
        boolean thereIsCarouselAvailable = detail.getImageUriList().size() != 0;
        mView.configureView(thereIsVideoAvailable, thereIsCarouselAvailable);
    }

    public void keyNavigator(KeyEvent keyEvent) {
        if (keyEvent.getAction() != KeyEvent.ACTION_UP) {
            /* Use this method for decide which action execute depending on the
             * key pressed */
        }
    }

    private void buildImagesCarousel(Detail details) {
        mView.initializeCarousel(details.getImageUriList());
    }

    public interface DetailsView extends BaseView {

        void configureView(boolean showVideo, boolean showCarousel);

        void onKeyDown();

        void onKeyUp();

        void onKeyRight();

        void onKeyLeft();

        void initializeCarousel(List<String> imageUriList);

        void initializeVideoSurface(String videoUri);
    }

    public interface DetailsNavigator extends BaseNavigator {

    }
}
