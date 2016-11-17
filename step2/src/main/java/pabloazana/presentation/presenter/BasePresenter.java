package pabloazana.presentation.presenter;

import pabloazana.presentation.contracts.BaseNavigator;
import pabloazana.presentation.contracts.BaseView;

public class BasePresenter<V extends BaseView, N extends BaseNavigator> {

    V mView;
    N mNavigator;

    BasePresenter(V view, N navigator) {
        mView = view;
        mNavigator = navigator;
    }
}
