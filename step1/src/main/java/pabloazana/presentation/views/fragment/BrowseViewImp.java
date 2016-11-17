package pabloazana.presentation.views.fragment;

import android.os.Bundle;
import android.support.v17.leanback.app.BrowseFragment;

import pabloazana.DependencyInjector;
import pabloazana.presentation.presenter.BrowseViewPresenter;
import pabloazana.presentation.presenter.BrowseViewPresenter.BrowseNavigator;
import pabloazana.presentation.presenter.BrowseViewPresenter.BrowseView;

public class BrowseViewImp extends BrowseFragment implements BrowseView {

    private BrowseViewPresenter mPresenter;

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initializePresenter();
        setUpApplicationIcon();
        setUpSearchIcon();
    }

    private void initializePresenter() {
        mPresenter = DependencyInjector.getInstance().injectBrowseViewPresenter(this, (BrowseNavigator) getActivity());
    }

    private void setUpApplicationIcon(){
        /* Configure here the application Icon */
    }

    private void setUpSearchIcon() {
        /* Allow the in-app search by showing the search icon and configuring it */
    }


}
