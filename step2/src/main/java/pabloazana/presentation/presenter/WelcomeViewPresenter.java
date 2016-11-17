package pabloazana.presentation.presenter;


import com.pabloazana.models.Category;
import com.pabloazana.usecases.BaseUseCase;
import com.pabloazana.usecases.GetAwesomePlacesUseCase;

import java.util.List;

import pabloazana.presentation.contracts.BaseNavigator;
import pabloazana.presentation.contracts.BaseView;

public class WelcomeViewPresenter extends BasePresenter<WelcomeViewPresenter.WelcomeView, WelcomeViewPresenter.WelcomeNavigator> {

    private GetAwesomePlacesUseCase mGetAwesomePlacesUseCase;

    public WelcomeViewPresenter(WelcomeView view, WelcomeNavigator navigator, GetAwesomePlacesUseCase getAwesomePlacesUseCase) {
        super(view, navigator);
        mGetAwesomePlacesUseCase = getAwesomePlacesUseCase;
        getAwesomePlaces();
    }

    private void getAwesomePlaces(){
        mGetAwesomePlacesUseCase.execute(new BaseUseCase.UseCaseListener<List<Category>>() {
            @Override
            public void onSuccess(List<Category> awesomePlaces) {
                mNavigator.navigateToBrowseView();
            }

            @Override
            public void onError(Exception exception) {

            }
        });
    }

    public interface WelcomeView extends BaseView { }

    public interface WelcomeNavigator extends BaseNavigator {
        void navigateToBrowseView();
    }

}
