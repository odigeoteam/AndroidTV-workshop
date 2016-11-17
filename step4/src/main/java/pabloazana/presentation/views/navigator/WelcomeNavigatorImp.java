package pabloazana.presentation.views.navigator;

import android.support.v4.app.FragmentManager;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.*;

import pabloazana.presentation.presenter.WelcomeViewPresenter;
import pabloazana.presentation.views.fragment.WelcomeViewImp;
import pabloazana.step4.R;


public class WelcomeNavigatorImp extends BaseNavigatorImp implements WelcomeViewPresenter.WelcomeNavigator {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        replaceFragment(WelcomeViewImp.newInstance());
    }

    @Override
    protected void setContentView() {
        setContentView(R.layout.welcome_activity);
    }

    private void replaceFragment(Fragment fragmetToReplace){
//        FragmentTransaction fragmentTransaction = ge
//        fragmentTransaction.replace(R.id.welcome_container, fragmetToReplace);
//        fragmentTransaction.commit();
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.welcome_container, fragmetToReplace);
        fragmentTransaction.commit();
    }

    @Override
    public void navigateToBrowseView() {
        Intent intent = new Intent(this, BrowseNavigatorImp.class);
        startActivity(intent);
    }


}
