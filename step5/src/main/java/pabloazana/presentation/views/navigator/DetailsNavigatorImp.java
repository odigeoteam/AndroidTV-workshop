package pabloazana.presentation.views.navigator;


import pabloazana.presentation.presenter.DetailsViewPresenter;
import pabloazana.step5.R;

public class DetailsNavigatorImp extends BaseNavigatorImp implements DetailsViewPresenter.DetailsNavigator {

    @Override
    protected void setContentView() {
        setContentView(R.layout.details_activity);
    }
}
