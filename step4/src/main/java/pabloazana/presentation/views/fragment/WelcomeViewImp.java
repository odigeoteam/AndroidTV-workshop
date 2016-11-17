package pabloazana.presentation.views.fragment;


import pabloazana.DependencyInjector;
import pabloazana.presentation.presenter.WelcomeViewPresenter;
import pabloazana.step4.R;

public class WelcomeViewImp extends BaseViewImp<WelcomeViewPresenter> implements WelcomeViewPresenter.WelcomeView {

    public static WelcomeViewImp newInstance() {
        return new WelcomeViewImp();
    }

    @Override
    protected void initializePresenter() {
        mPresenter = DependencyInjector.getInstance().injectWelcomeViewPresenter(this,
                (WelcomeViewPresenter.WelcomeNavigator) getActivity());
    }

    @Override
    protected int selectLayout() {
        return R.layout.welcome_fragment;
    }
}
