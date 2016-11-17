package pabloazana.presentation.presenter;

import pabloazana.presentation.contracts.BaseNavigator;
import pabloazana.presentation.contracts.BaseView;


public class BrowseViewPresenter extends BasePresenter<BrowseViewPresenter.BrowseView, BrowseViewPresenter.BrowseNavigator> {


    public BrowseViewPresenter(BrowseView view, BrowseNavigator navigator) {
        super(view, navigator);
    }

    public interface BrowseView extends BaseView {
    }

    public interface BrowseNavigator extends BaseNavigator {
    }




}
