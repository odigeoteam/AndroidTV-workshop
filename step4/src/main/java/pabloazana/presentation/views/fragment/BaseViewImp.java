package pabloazana.presentation.views.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import pabloazana.presentation.contracts.BaseView;
import pabloazana.presentation.presenter.BasePresenter;


public abstract class BaseViewImp<P extends BasePresenter> extends android.support.v4.app.Fragment implements BaseView {

    protected P mPresenter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(selectLayout(), container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initializePresenter();
    }

    protected abstract void initializePresenter();
    protected abstract int selectLayout();

}
