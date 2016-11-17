package pabloazana;

import android.content.Context;

import com.pabloazana.DomainDependencyInjector;
import com.pabloazana.contracts.AwesomePlacesDataSource;
import com.pabloazana.contracts.InMemoryCache;
import com.pabloazana.contracts.ThreadExecutor;
import com.pabloazana.contracts.UIThreadExecutor;
import com.pabloazana.models.Category;

import java.util.List;

import pabloazana.controllers.data.datasource.AwesomePlacesCacheImp;
import pabloazana.controllers.data.datasource.AwesomePlacesMockDataSource;
import pabloazana.controllers.data.datasource.ImageDataSource;
import pabloazana.controllers.executor.ThreadExecutorImp;
import pabloazana.controllers.executor.UIThreadExecutorImp;
import pabloazana.presentation.presenter.BrowseViewPresenter;
import pabloazana.presentation.presenter.BrowseViewPresenter.BrowseNavigator;
import pabloazana.presentation.presenter.BrowseViewPresenter.BrowseView;
import pabloazana.presentation.presenter.WelcomeViewPresenter;
import pabloazana.presentation.presenter.WelcomeViewPresenter.WelcomeNavigator;
import pabloazana.presentation.presenter.WelcomeViewPresenter.WelcomeView;


public class DependencyInjector extends DomainDependencyInjector {

    private static DependencyInjector mInstance;

    public static DependencyInjector getInstance() {
        if (mInstance == null) {
            mInstance = new DependencyInjector();
        }
        return mInstance;
    }

    public WelcomeViewPresenter injectWelcomeViewPresenter(WelcomeView view, WelcomeNavigator navigator) {
        return new WelcomeViewPresenter(view, navigator, injectGetAwesomePlacesUseCase());
    }

    public BrowseViewPresenter injectBrowseViewPresenter(BrowseView view, BrowseNavigator navigator) {
        return new BrowseViewPresenter(view, navigator, injectGetAwesomePlacesUseCase());
    }

    @Override
    public ThreadExecutor injectThreadExecutor() {
        return ThreadExecutorImp.getInstance();
    }

    @Override
    public UIThreadExecutor injectUIThreadExecutor() {
        return UIThreadExecutorImp.getInstance();
    }

    @Override
    public InMemoryCache<List<Category>> injectInMemoryCache() {
        return AwesomePlacesCacheImp.getInstance();
    }

    @Override
    public AwesomePlacesDataSource injectAwesomePlaceDataSource() {
        return new AwesomePlacesMockDataSource();
    }

    public ImageDataSource injectImageDataSource(Context context) {
        return new ImageDataSource(context);
    }
}
