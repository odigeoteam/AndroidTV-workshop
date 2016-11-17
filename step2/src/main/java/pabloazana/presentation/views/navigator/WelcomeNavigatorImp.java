package pabloazana.presentation.views.navigator;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;

import pabloazana.presentation.presenter.WelcomeViewPresenter;
import pabloazana.presentation.views.fragment.WelcomeViewImp;
import pabloazana.step2.R;


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
        FragmentTransaction fragmentTransaction = this.getFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.welcome_container, fragmetToReplace);
        fragmentTransaction.commit();
    }

    @Override
    public void navigateToBrowseView() {
        Intent intent = new Intent(this, BrowseNavigatorImp.class);
        startActivity(intent);
    }


}
