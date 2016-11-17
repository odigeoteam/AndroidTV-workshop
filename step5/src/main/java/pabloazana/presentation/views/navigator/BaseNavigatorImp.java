package pabloazana.presentation.views.navigator;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;


public abstract class BaseNavigatorImp extends FragmentActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView();
    }

    protected abstract void setContentView();

}
