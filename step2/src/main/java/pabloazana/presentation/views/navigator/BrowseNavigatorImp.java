package pabloazana.presentation.views.navigator;

import pabloazana.presentation.presenter.BrowseViewPresenter.BrowseNavigator;
import pabloazana.step2.R;


public class BrowseNavigatorImp extends BaseNavigatorImp implements BrowseNavigator {

    @Override
    protected void setContentView() {
        setContentView(R.layout.main_browse_view);
    }
}
