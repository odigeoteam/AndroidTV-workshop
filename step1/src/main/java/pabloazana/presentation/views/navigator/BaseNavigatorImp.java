package pabloazana.presentation.views.navigator;

import android.app.Activity;
import android.os.Bundle;


public abstract class BaseNavigatorImp extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView();
    }

    protected abstract void setContentView();

}
