package pabloazana.presentation.views.navigator;


import pabloazana.presentation.presenter.DetailsViewPresenter;
import pabloazana.step4.R;

public class DetailsNavigatorImp extends BaseNavigatorImp implements DetailsViewPresenter.DetailsNavigator {

    @Override
    protected void setContentView() {
        setContentView(R.layout.details_activity);
    }
}
