package com.pabloazana.usecases;


import com.pabloazana.contracts.ThreadExecutor;
import com.pabloazana.contracts.UIThreadExecutor;

public abstract class BaseUseCase<T> {

    private ThreadExecutor mThreadExecutor;
    private UIThreadExecutor mUIThreadExecutor;
    private UseCaseListener<T> mUseCaseListener;

    BaseUseCase(ThreadExecutor threadExecutor, UIThreadExecutor uiThreadExecutor){
        mThreadExecutor = threadExecutor;
        mUIThreadExecutor = uiThreadExecutor;
    }

    public void execute(final UseCaseListener<T> useCaseListener){
        mUseCaseListener = useCaseListener;
        doInBackgroundThread(new Runnable() {
            @Override
            public void run() {
                doAction(useCaseListener);
            }
        });
    }

    void onSuccess(final T object) {
        doInUIThread(new Runnable() {
            @Override
            public void run() {
                mUseCaseListener.onSuccess(object);
            }
        });
    }

    void onError(final Exception exception) {
        doInUIThread(new Runnable() {
            @Override
            public void run() {
                mUseCaseListener.onError(exception);
            }
        });
    }

    abstract void doAction(UseCaseListener useCaseListener);

    public interface UseCaseListener<T> {
        void onSuccess(T t);
        void onError(Exception exception);
    }

    private void doInBackgroundThread(Runnable runnable){
        mThreadExecutor.execute(runnable);
    }

    private void doInUIThread(Runnable runnable) {
        mUIThreadExecutor.execute(runnable);
    }









}
