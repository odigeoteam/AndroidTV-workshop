package pabloazana.presentation.views.fragment;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.support.v17.leanback.app.BackgroundManager;
import android.support.v17.leanback.app.SearchFragment;
import android.support.v17.leanback.app.SearchFragment.SearchResultProvider;
import android.support.v17.leanback.widget.ListRowPresenter;
import android.support.v17.leanback.widget.ObjectAdapter;
import android.view.View;
import com.pabloazana.models.Category;
import java.util.List;
import pabloazana.DependencyInjector;
import pabloazana.presentation.presenter.SearchViewPresenter;
import pabloazana.presentation.presenter.SearchViewPresenter.SearchNavigator;
import pabloazana.presentation.presenter.SearchViewPresenter.SearchView;
import pabloazana.presentation.views.utils.AwesomePlacesContentAdapter;
import pabloazana.presentation.views.utils.SearchRunnable;

public class SearchViewImp extends SearchFragment implements SearchView, SearchResultProvider {

    private SearchRunnable mSearchRunnable;
    private Handler mHandler = new Handler();
    private AwesomePlacesContentAdapter contentAdapter;
    private SearchViewPresenter mPresenter;
    private BackgroundManager mBackgroundManager;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        contentAdapter = new AwesomePlacesContentAdapter(new ListRowPresenter(), getActivity());
        setSearchResultProvider(this);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initializePresenter();
        prepareBackgroundManager();
        setupUIElements();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mPresenter.destroyView();
    }

    private void initializePresenter() {
        mPresenter = DependencyInjector.getInstance().injectSearchViewPresenter(this,
                (SearchNavigator) getActivity());
        mSearchRunnable = new SearchRunnable(mPresenter);
    }

    private void setupUIElements() {
        /* Call the correspondence presenter method when the user select a card in order to
         * change de background. Tip, as you can see, BrowseViewPresenter and SearchViewPresenter
         * extends of the same BackgroundPresenter in order to share common logic.*/
    }

    @Override
    public ObjectAdapter getResultsAdapter() {
        /* You must return your adapter here */
        return null;
    }


    @Override
    public boolean onQueryTextChange(String newQuery) {
        return doSearch(newQuery);
    }

    @Override
    public boolean onQueryTextSubmit(String query) {
        return doSearch(query);
    }

    private boolean doSearch(String query) {
        /* Use the RunnableSearch and the handler for make a search request trough the
         * SearchPresenter */
        return true;
    }

    @Override
    public void paintContent(List<Category> categoryList) {
        contentAdapter.paintCategories(categoryList);
    }

    @Override
    public void updateBackground(Drawable backgroundDrawable) {
        /* Use this method for updating the background using the BackgroundManager */
    }

    private void prepareBackgroundManager() {
        /* Use this method to initialize the BackgroundManager */
    }

}
