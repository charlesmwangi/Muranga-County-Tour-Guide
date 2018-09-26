package com.example.android.murangacountytourguide;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.android.murangacountytourguide.ui.HotelFragment;
import com.example.android.murangacountytourguide.ui.MallFragment;
import com.example.android.murangacountytourguide.ui.HistoricalSitesFragment;
import com.example.android.murangacountytourguide.ui.SchoolFragment;

public class TourGuidePagerAdapter extends FragmentPagerAdapter {
    private Context mContext;

    public TourGuidePagerAdapter(FragmentManager fm, Context context) {
        super(fm);
        mContext = context;
    }

    /**
     * Return the {@link Fragment} that should be displayed for the given page number.
     */
    @Override
    public Fragment getItem(int position) {
        if (position == 0) {
            return new HotelFragment();
        } else if (position == 1) {
            return new MallFragment();
        } else if (position == 2) {
            return new HistoricalSitesFragment();
        } else {
            return new SchoolFragment();
        }
    }

    /**
     * Return the total number of pages.
     */
    @Override
    public int getCount() {
        return 4;
    }
    /**
     * Set the page titles
     */
    @Override
    public CharSequence getPageTitle(int position) {
        if (position == 0) {
            return mContext.getString(R.string.category_hotels);
        } else if (position == 1) {
            return mContext.getString(R.string.category_malls);
        } else if (position == 2) {
            return mContext.getString(R.string.historical_sites);
        } else {
            return mContext.getString(R.string.category_schools);
        }
    }
}
