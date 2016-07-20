package com.ga.android.myapplication;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

/**
 * Created by owlslubic on 7/19/16.
 */
public class DetailFragment extends Fragment {


    private TextView textView;

    private int mTabPosition, mListItemPosition;

    //    public static Fragment newInstance(int tabPosition, int listItemPosition){
//        DetailFragment fragment = new DetailFragment();
////        fragment.mTabPosition = tabPosition;
////        fragment.mListItemPosition = listItemPosition;
//    }
    public static Fragment newInstance(Bundle args) {
        DetailFragment fragment = new DetailFragment();
        fragment.setArguments(args);
        return fragment;
    }//now we need to get the info from this down yonder

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(android.R.layout.simple_list_item_1, container, false); //setting the textview of the premade laytout to dp what we want
        textView = (TextView) rootView.findViewById(android.R.id.text1);//member variable so we can access it in onviewcreated

        return rootView;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        //accessing his cool lists
        // getResources().getStringArray()//inside the pager adapter and inside the fragment we have the position, but we need the list that we're even looking at,
        //so we go back and modify the interface so that it will return both the tab positiona nd the item positiion

        mTabPosition = getArguments().getInt("tab_position", 0);
        mListItemPosition = getArguments().getInt("list_item_position", 0); //now we can go get the values that we need

        String[] strings = null;

        switch (mTabPosition) {
            default:
            case 0:
               // textView.setText(getResources().getStringArray(R.array.planets)[mListItemPosition]);//this returns a string
                strings = getResources().getStringArray(R.array.planets);
                break;
            case 1:
                strings = getResources().getStringArray(R.array.grocery_list);//or do it this way
                break;
            case 2:
                strings = getResources().getStringArray(R.array.to_do_list);
                break;
        }

        textView.setText(strings[mListItemPosition]);
    }

}

