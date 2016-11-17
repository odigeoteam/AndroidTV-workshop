package pabloazana.presentation.presenter;

import android.graphics.drawable.Drawable;

import com.pabloazana.models.Category;
import com.pabloazana.usecases.BaseUseCase.UseCaseListener;
import com.pabloazana.usecases.SearchAwesomePlacesUseCase;

import java.util.List;
import java.util.Timer;

import pabloazana.controllers.data.datasource.ImageDataSource;
import pabloazana.presentation.contracts.BaseNavigator;
import pabloazana.presentation.contracts.BaseView;


public class SearchViewPresenter extends BackGroundPresenter<SearchViewPresenter.SearchView, SearchViewPresenter.SearchNavigator> {

    private SearchAwesomePlacesUseCase mSearchAwesomePlacesUseCase;

    public SearchViewPresenter(SearchView view, SearchNavigator navigator, Timer backgroundTimer,
                               ImageDataSource imageProvider, SearchAwesomePlacesUseCase searchAwesomePlacesUseCase) {
        super(view, navigator, backgroundTimer, imageProvider);
        mSearchAwesomePlacesUseCase = searchAwesomePlacesUseCase;
    }

    public void navigateToDetailsScreen(int awesomePlaceId) {
        mNavigator.navigateToDetail(awesomePlaceId);
    }

    public void search(String query) {
        mSearchAwesomePlacesUseCase.setQuery(query);
        mSearchAwesomePlacesUseCase.execute(new UseCaseListener<List<Category>>() {
            @Override
            public void onSuccess(List<Category> searchResults) {
                mView.paintContent(searchResults);
            }

            @Override
            public void onError(Exception exception) {

            }
        });
    }

    @Override
    protected void paintBackgroundImage(Drawable backGroundDrawable){
        mView.updateBackground(backGroundDrawable);
    }

    public interface SearchView extends BaseView {
        void paintContent(List<Category> categoryList);
        void updateBackground(Drawable backgroundDrawable);
    }

    public interface SearchNavigator extends BaseNavigator {
        void navigateToDetail(int awesomePlaceId);
    }


}
