package pabloazana.controllers.executor;

import android.os.Handler;
import android.os.Looper;

import com.pabloazana.contracts.UIThreadExecutor;


public class UIThreadExecutorImp implements UIThreadExecutor {

    private static UIThreadExecutorImp sUIThreadExecutor;
    private Handler mHandler;

    public static UIThreadExecutorImp getInstance(){
        if(sUIThreadExecutor == null) {
            sUIThreadExecutor = new UIThreadExecutorImp();
        }

        return sUIThreadExecutor;
    }

    private UIThreadExecutorImp() {
        mHandler = new Handler(Looper.getMainLooper());
    }

    @Override
    public void execute(Runnable runnable) {
        mHandler.post(runnable);
    }

}
