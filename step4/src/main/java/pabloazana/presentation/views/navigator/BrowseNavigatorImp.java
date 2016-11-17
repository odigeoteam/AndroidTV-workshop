package pabloazana.presentation.views.navigator;

import android.content.Intent;

import pabloazana.presentation.presenter.BrowseViewPresenter.BrowseNavigator;
import pabloazana.step4.R;


public class BrowseNavigatorImp extends BaseNavigatorImp implements BrowseNavigator {

    public static final String AWESOME_PLACE_ID = "awesome_place_id";

    @Override
    protected void setContentView() {
        setContentView(R.layout.main_browse_view);
    }

    @Override
    public void navigateToSearch() {
        Intent intent = new Intent(this, SearchNavigatorImp.class);
        startActivity(intent);
    }

    @Override
    public void navigateToDetail(int awesomePlaceId) {
        Intent intent = new Intent(this,  DetailsNavigatorImp.class);
        intent.putExtra(AWESOME_PLACE_ID, awesomePlaceId);
        startActivity(intent);
    }
}
