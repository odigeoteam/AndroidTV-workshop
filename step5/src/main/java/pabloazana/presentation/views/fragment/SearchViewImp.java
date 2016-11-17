package pabloazana.presentation.views.fragment;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.support.v17.leanback.app.BackgroundManager;
import android.support.v17.leanback.app.SearchFragment;
import android.support.v17.leanback.app.SearchFragment.SearchResultProvider;
import android.support.v17.leanback.widget.ListRowPresenter;
import android.support.v17.leanback.widget.ObjectAdapter;
import android.support.v17.leanback.widget.OnItemViewClickedListener;
import android.support.v17.leanback.widget.OnItemViewSelectedListener;
import android.support.v17.leanback.widget.Presenter;
import android.support.v17.leanback.widget.Row;
import android.support.v17.leanback.widget.RowPresenter;
import android.text.TextUtils;
import android.view.View;

import com.pabloazana.models.AwesomePlace;
import com.pabloazana.models.Category;

import java.util.List;

import pabloazana.DependencyInjector;
import pabloazana.presentation.presenter.SearchViewPresenter;
import pabloazana.presentation.presenter.SearchViewPresenter.SearchNavigator;
import pabloazana.presentation.presenter.SearchViewPresenter.SearchView;
import pabloazana.presentation.views.adapters.AwesomePlacesContentAdapter;
import pabloazana.presentation.views.utils.SearchRunnable;

public class SearchViewImp extends SearchFragment implements SearchView, SearchResultProvider {

    private static final int SEARCH_DELAY_MS = 300;
    private SearchRunnable mSearchRunnable;
    private AwesomePlacesContentAdapter contentAdapter;
    private Handler mHandler = new Handler();
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
        setOnItemViewSelectedListener(new OnItemViewSelectedListener() {
            @Override
            public void onItemSelected(Presenter.ViewHolder itemViewHolder, Object item, RowPresenter.ViewHolder rowViewHolder, Row row) {
                if (item instanceof AwesomePlace) {
                    mPresenter.changeBackgroundImage(((AwesomePlace) item).getBackgroundImageUri());
                }
            }
        });

        setOnItemViewClickedListener(new OnItemViewClickedListener() {
            @Override
            public void onItemClicked(Presenter.ViewHolder itemViewHolder, Object item, RowPresenter.ViewHolder rowViewHolder, Row row) {
                mPresenter.navigateToDetailsScreen(((AwesomePlace)item).getId());
            }
        });
    }

    @Override
    public ObjectAdapter getResultsAdapter() {
        return contentAdapter;
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
        contentAdapter.clear();
        if (!TextUtils.isEmpty(query)) {
            mSearchRunnable.setSearchQuery(query);
            mHandler.removeCallbacks(mSearchRunnable);
            mHandler.postDelayed(mSearchRunnable, SEARCH_DELAY_MS);
        }
        return true;
    }

    @Override
    public void paintContent(List<Category> categoryList) {
        contentAdapter.paintCategories(categoryList);
    }

    @Override
    public void updateBackground(Drawable backgroundDrawable) {
        if(isVisible()){
            mBackgroundManager.setDrawable(backgroundDrawable);
        }
    }

    private void prepareBackgroundManager() {
        mBackgroundManager = BackgroundManager.getInstance(getActivity());
        mBackgroundManager.attach(getActivity().getWindow());
    }

}
