package pabloazana.presentation.views.navigator;


import pabloazana.presentation.presenter.SearchViewPresenter;
import pabloazana.step3.R;

public class SearchNavigatorImp extends BaseNavigatorImp implements SearchViewPresenter.SearchNavigator {

    @Override
    protected void setContentView() {
        setContentView(R.layout.search_view);
    }

}
