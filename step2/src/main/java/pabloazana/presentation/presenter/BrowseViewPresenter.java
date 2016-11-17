package pabloazana.presentation.presenter;

import com.pabloazana.models.Category;
import com.pabloazana.usecases.GetAwesomePlacesUseCase;
import java.util.List;
import pabloazana.presentation.contracts.BaseNavigator;
import pabloazana.presentation.contracts.BaseView;


public class BrowseViewPresenter extends BasePresenter<BrowseViewPresenter.BrowseView, BrowseViewPresenter.BrowseNavigator> {

    private GetAwesomePlacesUseCase mAwesomePlaceUseCase;

    public BrowseViewPresenter(BrowseView view, BrowseNavigator navigator,
                               GetAwesomePlacesUseCase awesomePlacesUseCase) {
        super(view, navigator);
        mAwesomePlaceUseCase = awesomePlacesUseCase;
    }

    public void getAwesomePlaces() {
        List<Category> categoryList = mAwesomePlaceUseCase.getAwesomePlacesFromCache();
        mView.paintAwesomePlaces(categoryList);
    }

    public interface BrowseView extends BaseView {
        void paintAwesomePlaces(List<Category> awesomePlaces);
    }

    public interface BrowseNavigator extends BaseNavigator {
    }




}
