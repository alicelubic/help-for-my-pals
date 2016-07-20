package com.ga.android.myapplication;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Created by alanjcaceres on 7/19/16.
 */

public class SectionsPagerAdapter extends FragmentPagerAdapter {

    private AListFragment.OnListItemClickedListener mListItemClickListener;

    public SectionsPagerAdapter(FragmentManager fm, AListFragment.OnListItemClickedListener listener) { //STEP 6: add lsiener to paramerters, set a member variable, and assign it to the parameter
        super(fm);
        mListItemClickListener = listener;
    }

    @Override
    public Fragment getItem(int position) {
        // getItem is called to instantiate the fragment for the given page.
        // Return a AListFragment (defined as a static inner class below).

        //STEP 5:
     //   return AListFragment.newInstance(position);//this adapter is holding an instance of the fragment, now it requires a listener
     //we would modify the sections pager adapter constructor to take in our listitemclciklsitener

        //STEP 7 use the new listener passed in
        return AListFragment.newInstance(position, mListItemClickListener);
    }

    @Override
    public int getCount() {
        // Show 3 total pages.
        return 3;
    }

    @Override
    public CharSequence getPageTitle(int position) {//this populates the tab layout at the top
        switch (position){
            default:
            case 0:
                return "Planets";
            case 1:
                return "Groceries";
            case 2:
                return "To Do List";
        }

    }
}
