package pabloazana.presentation.presenter;

import android.graphics.drawable.Drawable;

import com.pabloazana.models.Category;
import com.pabloazana.usecases.GetAwesomePlacesUseCase;

import java.util.List;
import java.util.Timer;

import pabloazana.controllers.data.datasource.ImageDataSource;
import pabloazana.presentation.contracts.BaseNavigator;
import pabloazana.presentation.contracts.BaseView;


public class BrowseViewPresenter extends BackGroundPresenter<BrowseViewPresenter.BrowseView, BrowseViewPresenter.BrowseNavigator> {

    private GetAwesomePlacesUseCase mAwesomePlaceUseCase;

    public BrowseViewPresenter(BrowseView view, BrowseNavigator navigator,
                               GetAwesomePlacesUseCase awesomePlacesUseCase, Timer backgroundTimer,
                               ImageDataSource imageProvider) {
        super(view, navigator, backgroundTimer, imageProvider);
        mAwesomePlaceUseCase = awesomePlacesUseCase;
    }

    public void getAwesomePlaces() {
        List<Category> categoryList = mAwesomePlaceUseCase.getAwesomePlacesFromCache();
        mView.configureItemHeader(categoryList.size());
        mView.paintAwesomePlaces(categoryList);
    }

    public void navigateToSearchScreen() {
        mNavigator.navigateToSearch();
    }

    public void navigateToDetailsScreen(int awesomePlaceId) {
        mNavigator.navigateToDetail(awesomePlaceId);
    }

    @Override
    protected void paintBackgroundImage(Drawable backgroundDrawable) {
        mView.updateBackground(backgroundDrawable);
    }


    public interface BrowseView extends BaseView {
        void paintAwesomePlaces(List<Category> awesomePlaces);
        void configureItemHeader(int numberOfCategories);
        void updateBackground(Drawable backgroundDrawable);
    }

    public interface BrowseNavigator extends BaseNavigator {
        void navigateToSearch();
        void navigateToDetail(int awesomePlaceId);
    }




}
