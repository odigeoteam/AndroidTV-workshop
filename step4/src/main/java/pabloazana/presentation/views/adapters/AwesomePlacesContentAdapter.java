package pabloazana.presentation.views.adapters;

import android.content.Context;
import android.support.v17.leanback.widget.ArrayObjectAdapter;
import android.support.v17.leanback.widget.HeaderItem;
import android.support.v17.leanback.widget.ListRow;
import android.support.v17.leanback.widget.Presenter;

import com.pabloazana.models.AwesomePlace;
import com.pabloazana.models.Category;

import java.util.List;

import pabloazana.presentation.views.adapters.CardItemPresenter;

public class AwesomePlacesContentAdapter extends ArrayObjectAdapter {

    private Context mContext;

    public AwesomePlacesContentAdapter(Presenter presenter, Context context) {
        super(presenter);
        mContext = context;
    }

    public void paintCategories(List<Category> categoryList) {

        for (Category category : categoryList) {
            ArrayObjectAdapter listRowAdapter = new ArrayObjectAdapter(new CardItemPresenter(mContext, category.getCardType()));
            for (AwesomePlace places : category.getAwesomePlaceList()) {
                listRowAdapter.add(places);
            }
            HeaderItem header = new HeaderItem(0, category.getCategoryName());
            this.add(new ListRow(header, listRowAdapter));
        }

    }

}
