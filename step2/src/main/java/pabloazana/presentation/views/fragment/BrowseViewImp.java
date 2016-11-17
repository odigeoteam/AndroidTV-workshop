package pabloazana.presentation.views.fragment;

import android.os.Bundle;
import android.support.v17.leanback.app.BrowseFragment;
import android.view.View;
import com.pabloazana.models.Category;
import java.util.List;
import pabloazana.DependencyInjector;
import pabloazana.presentation.presenter.BrowseViewPresenter;
import pabloazana.presentation.presenter.BrowseViewPresenter.BrowseNavigator;
import pabloazana.presentation.presenter.BrowseViewPresenter.BrowseView;
import pabloazana.step2.R;

public class BrowseViewImp extends BrowseFragment implements BrowseView {

    private BrowseViewPresenter mPresenter;

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initializePresenter();
        setUpApplicationIcon();
        setUpSearchIcon();
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

            }
        });
        setSearchAffordanceColor(getResources().getColor(R.color.semantic_information));
    }


    @Override
    public void paintAwesomePlaces(List<Category> awesomePlaces) {
        /* Use this method for painting the content in the BrowseView. You already have
        * the list of Categories with AwesomePlaces*/
    }

}
