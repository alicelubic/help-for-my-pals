package com.ga.android.myapplication;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

/**
 * Created by alanjcaceres on 7/19/16.
 */

public class AListFragment extends Fragment {

    public static final String LIST_NUMBER = "list_number";

    ListView mListView;

    int listNumber = 0;
    //STEP 1
    //creating an interface so we can communicate with the activity
    public interface OnListItemClickedListener{
        void onListItemClicked(int tabPosition, int listItemPosition); //added int position after step 4, now lets go to what is holding this list fragment aka the adapter
    }
    //STEP 2
    private OnListItemClickedListener mListItemClickedListener;//reference to the listener

    public static AListFragment newInstance(int sectionNumber, OnListItemClickedListener listener) {
        AListFragment fragment = new AListFragment();
        Bundle args = new Bundle();
        args.putInt(LIST_NUMBER, sectionNumber);
        fragment.setArguments(args);                    //STEP 3
        fragment.mListItemClickedListener = listener; //wahtever we pass into this new instance method, we have a reference to it
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_list, container, false);
        mListView = (ListView) rootView.findViewById(R.id.listview_fragment);
        return rootView;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        ArrayAdapter<String> adapter;

        listNumber = getArguments().getInt(LIST_NUMBER, 0); //Getting the argument

        //Setting the adapter based on the ViewPager position we provided in the argument
        switch (listNumber){
            default:
            case 0:
                adapter = new ArrayAdapter<>(getContext(),
                        android.R.layout.simple_list_item_1,
                        getResources().getStringArray(R.array.planets));
                break;
            case 1:

                adapter = new ArrayAdapter<>(getContext(),
                        android.R.layout.simple_list_item_1,
                        getResources().getStringArray(R.array.grocery_list));
                break;
            case 2:
                adapter = new ArrayAdapter<>(getContext(),
                        android.R.layout.simple_list_item_1,
                        getResources().getStringArray(R.array.to_do_list));
                break;
        }

        mListView.setAdapter(adapter);

        //STEP 4
        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
               // mListItemClickedListener.onListItemClicked(position);//it doesnt like position so we need to change method above to include int position
                //the NEW INTANCE the fragment knows the position "int sectionNumber", and ListNUMBER is a keyvalue with the section number which is mentioned above
                mListItemClickedListener.onListItemClicked(listNumber, position);
            }
        });
    }
}
