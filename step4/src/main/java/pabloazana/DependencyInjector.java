package pabloazana;

import android.content.Context;

import com.pabloazana.DomainDependencyInjector;
import com.pabloazana.contracts.AwesomePlacesDataSource;
import com.pabloazana.contracts.InMemoryCache;
import com.pabloazana.contracts.ThreadExecutor;
import com.pabloazana.contracts.UIThreadExecutor;
import com.pabloazana.models.Category;

import java.util.List;
import java.util.Timer;

import pabloazana.controllers.data.datasource.AwesomePlacesCacheImp;
import pabloazana.controllers.data.datasource.AwesomePlacesMockDataSource;
import pabloazana.controllers.data.datasource.ImageDataSource;
import pabloazana.controllers.executor.ThreadExecutorImp;
import pabloazana.controllers.executor.UIThreadExecutorImp;
import pabloazana.controllers.video.VideoController;
import pabloazana.controllers.video.VideoControllerImp;
import pabloazana.presentation.presenter.BrowseViewPresenter;
import pabloazana.presentation.presenter.BrowseViewPresenter.BrowseNavigator;
import pabloazana.presentation.presenter.BrowseViewPresenter.BrowseView;
import pabloazana.presentation.presenter.DetailsViewPresenter;
import pabloazana.presentation.presenter.DetailsViewPresenter.DetailsNavigator;
import pabloazana.presentation.presenter.DetailsViewPresenter.DetailsView;
import pabloazana.presentation.presenter.SearchViewPresenter;
import pabloazana.presentation.presenter.SearchViewPresenter.SearchNavigator;
import pabloazana.presentation.presenter.SearchViewPresenter.SearchView;
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
        return new BrowseViewPresenter(view, navigator, injectGetAwesomePlacesUseCase(), new Timer(),
                injectImageDataSource((Context) navigator));
    }

    public SearchViewPresenter injectSearchViewPresenter(SearchView view, SearchNavigator navigator) {
        return new SearchViewPresenter(view, navigator, new Timer(), injectImageDataSource((Context) navigator),
                injectSearchAwesomePlacesUseCase());
    }

    public DetailsViewPresenter injectDetailsViewPresenter(DetailsView view, DetailsNavigator navigator) {
        return new DetailsViewPresenter(view, navigator, injectGetDetailUseCase(), injectImageDataSource((Context) navigator));
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

    public VideoController injectVideoController(Context context) {
        return new VideoControllerImp(context);
    }
}
