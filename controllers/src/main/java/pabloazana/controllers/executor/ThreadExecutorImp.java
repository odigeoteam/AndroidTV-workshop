package pabloazana.controllers.executor;

import android.support.annotation.NonNull;

import com.pabloazana.contracts.ThreadExecutor;

import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;



public class ThreadExecutorImp extends ThreadPoolExecutor implements ThreadExecutor {

    private static final int INITIAL_POOL_SIZE = 3;
    private static final int MAX_POOL_SIZE = 5;
    private static final int KEEP_ALIVE_TIME = 10;
    private static final TimeUnit KEEP_ALIVE_TIME_UNIT = TimeUnit.SECONDS;

    private static ThreadExecutorImp sThreadExecutor;

    public static ThreadExecutorImp getInstance() {
        if(sThreadExecutor == null) {
            sThreadExecutor = new ThreadExecutorImp();
        }

        return sThreadExecutor;
    }

    private ThreadExecutorImp() {
        super(INITIAL_POOL_SIZE, MAX_POOL_SIZE, KEEP_ALIVE_TIME, KEEP_ALIVE_TIME_UNIT,
                new LinkedBlockingDeque<Runnable>(), new JobThreadFactory());
    }

    private static class JobThreadFactory implements ThreadFactory {

        private static final String THREAD_NAME = "android_";
        private int counter;

        @Override public Thread newThread(@NonNull Runnable runnable) {
            counter++;
            return new Thread(runnable, THREAD_NAME + counter);
        }
    }
}
