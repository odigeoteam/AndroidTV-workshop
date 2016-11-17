package pabloazana.presentation.views.navigator;


import android.content.Intent;

import pabloazana.presentation.presenter.SearchViewPresenter;
import pabloazana.step5.R;

import static pabloazana.presentation.views.navigator.BrowseNavigatorImp.AWESOME_PLACE_ID;

public class SearchNavigatorImp extends BaseNavigatorImp implements SearchViewPresenter.SearchNavigator {

    @Override
    protected void setContentView() {
        setContentView(R.layout.search_view);
    }

    @Override
    public void navigateToDetail(int awesomePlaceId) {
        Intent intent = new Intent(this,  DetailsNavigatorImp.class);
        intent.putExtra(AWESOME_PLACE_ID, awesomePlaceId);
        startActivity(intent);
    }
}
