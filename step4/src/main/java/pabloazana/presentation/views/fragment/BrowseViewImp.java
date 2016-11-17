package pabloazana.presentation.views.fragment;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v17.leanback.app.BackgroundManager;
import android.support.v17.leanback.app.BrowseFragment;
import android.support.v17.leanback.widget.ListRowPresenter;
import android.support.v17.leanback.widget.OnItemViewClickedListener;
import android.support.v17.leanback.widget.OnItemViewSelectedListener;
import android.support.v17.leanback.widget.Presenter;
import android.support.v17.leanback.widget.PresenterSelector;
import android.support.v17.leanback.widget.Row;
import android.support.v17.leanback.widget.RowPresenter;
import android.view.View;

import com.pabloazana.models.AwesomePlace;
import com.pabloazana.models.Category;

import java.util.List;

import pabloazana.DependencyInjector;
import pabloazana.presentation.presenter.BrowseViewPresenter;
import pabloazana.presentation.presenter.BrowseViewPresenter.BrowseNavigator;
import pabloazana.presentation.presenter.BrowseViewPresenter.BrowseView;
import pabloazana.presentation.views.adapters.AwesomePlacesContentAdapter;
import pabloazana.presentation.views.adapters.HeaderItemPresenter;
import pabloazana.step4.R;

public class BrowseViewImp extends BrowseFragment implements BrowseView {

    private BrowseViewPresenter mPresenter;
    private AwesomePlacesContentAdapter mAdapter;
    private BackgroundManager mBackgroundManager;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mAdapter = new AwesomePlacesContentAdapter(new ListRowPresenter(), getActivity());
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initializePresenter();
        prepareBackgroundManager();
        setUpApplicationIcon();
        setUpSearchIcon();
        setupUIElements();
        mPresenter.getAwesomePlaces();
    }

    private void initializePresenter() {
        mPresenter = DependencyInjector.getInstance().injectBrowseViewPresenter(this, (BrowseNavigator) getActivity());
    }

    private void setUpApplicationIcon(){
        setBadgeDrawable(getResources().getDrawable(R.drawable.edreams_logo_main));
    }

    private void setUpSearchIcon() {
        setOnSearchClickedListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mPresenter.navigateToSearchScreen();
            }
        });
        setSearchAffordanceColor(getResources().getColor(R.color.semantic_information));
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
    public void paintAwesomePlaces(List<Category> awesomePlaces) {
        mAdapter.clear();
        mAdapter.paintCategories(awesomePlaces);
        setAdapter(mAdapter);
    }

    @Override
    public void configureItemHeader(int numberOfCategories) {
        if(numberOfCategories > 5) {
            setBrandColor(getResources().getColor(R.color.primary_brand));
            setHeaderPresenterSelector(new PresenterSelector() {
                @Override
                public Presenter getPresenter(Object item) {
                    return new HeaderItemPresenter();
                }
            });
        } else {
            setHeadersState(HEADERS_DISABLED);
        }
    }

    @Override
    public void updateBackground(Drawable backgroundDrawable) {
        mBackgroundManager.setDrawable(backgroundDrawable);
    }

    private void prepareBackgroundManager() {
        mBackgroundManager = BackgroundManager.getInstance(getActivity());
        mBackgroundManager.attach(getActivity().getWindow());
    }


}
