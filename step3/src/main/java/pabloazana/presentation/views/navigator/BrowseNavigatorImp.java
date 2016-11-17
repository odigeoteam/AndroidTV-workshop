package pabloazana.presentation.views.navigator;

import android.content.Intent;

import pabloazana.presentation.presenter.BrowseViewPresenter.BrowseNavigator;
import pabloazana.step3.R;


public class BrowseNavigatorImp extends BaseNavigatorImp implements BrowseNavigator {

    @Override
    protected void setContentView() {
        setContentView(R.layout.main_browse_view);
    }

    @Override
    public void navigateToSearch() {
        Intent intent = new Intent(this, SearchNavigatorImp.class);
        startActivity(intent);
    }
}
