package pabloazana.presentation.views.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import pabloazana.presentation.views.fragment.ImageCarouselFragment;

public class CarouselPagerAdapter extends FragmentStatePagerAdapter {

    private int mNumberOfElements;
    private List<String> mImageUriList;

    public CarouselPagerAdapter(FragmentManager fm, List<String> imageUriList) {
        super(fm);
        mNumberOfElements = imageUriList.size();
        mImageUriList = imageUriList;
    }

    @Override
    public Fragment getItem(int position) {
        return ImageCarouselFragment.newInstance(mImageUriList.get(position));
    }

    @Override
    public int getCount() {
        return mNumberOfElements;
    }
}
