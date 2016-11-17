package pabloazana.presentation.views.model;

import android.support.v17.leanback.widget.HeaderItem;

public class HeaderItemModel extends HeaderItem {

    private String mIconName;

    public HeaderItemModel(String name, String iconName) {
        super(name);
        mIconName = iconName;
    }

    public String getIconName() {
        return mIconName;
    }
}
