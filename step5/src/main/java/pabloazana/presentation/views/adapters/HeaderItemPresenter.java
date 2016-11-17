package pabloazana.presentation.views.adapters;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v17.leanback.widget.ListRow;
import android.support.v17.leanback.widget.Presenter;
import android.support.v17.leanback.widget.RowHeaderPresenter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import pabloazana.DependencyInjector;
import pabloazana.controllers.data.datasource.ImageDataSource;
import pabloazana.presentation.views.model.HeaderItemModel;
import pabloazana.step5.R;


public class HeaderItemPresenter extends RowHeaderPresenter {

    private ImageDataSource mImageDataSource;
    private Context mContext;

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent) {

        mContext = parent.getContext();
        mImageDataSource = DependencyInjector.getInstance().injectImageDataSource(mContext);

        LayoutInflater inflater = (LayoutInflater) parent.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        return new ViewHolder(inflater.inflate(R.layout.header_view, null));
    }

    @Override
    public void onBindViewHolder(Presenter.ViewHolder viewHolder, Object item) {
        HeaderItemModel headerItem = (HeaderItemModel) ((ListRow) item).getHeaderItem();
        View rootView = viewHolder.view;
        ImageView iconView = (ImageView) rootView.findViewById(R.id.header_icon);

        Drawable icon = rootView.getResources().getDrawable(mImageDataSource.getResourceIdByName(headerItem.getIconName(), "drawable"), null);
        icon.setTint(mContext.getResources().getColor(R.color.lb_tv_white));
        iconView.setImageDrawable(icon);
        TextView label = (TextView) rootView.findViewById(R.id.header_label);
        label.setText(headerItem.getName());
    }

    @Override
    public void onUnbindViewHolder(Presenter.ViewHolder viewHolder) {

    }

}
