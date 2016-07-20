package com.ga.android.myapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;



public class MainActivity extends AppCompatActivity implements AListFragment.OnListItemClickedListener {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.main_content_container,
                 //       new MainFragment())
                MainFragment.newInstance(this))//sets the activity as the onItemClickListener
                .commit();
        //STEP 9: change newMainFragment to MainFragment.newInstance(this))
    }

    @Override
    //public void onListItemClicked(int position)
    public void onListItemClicked(int tabPosition, int listItemPosition) {//changed the parameters, now go back to detailfragment

        Bundle aBundleOfJoy = new Bundle();
        aBundleOfJoy.putInt("tab_position",tabPosition);//shoulda made constants for those keys
        aBundleOfJoy.putInt("list_item_position",listItemPosition);

        getSupportFragmentManager()
                .beginTransaction()
                .addToBackStack("MainActivity")
                .replace(R.id.main_content_container,DetailFragment.newInstance(aBundleOfJoy))//newInstance takes a bundle, so we're gonna make one above
                .commit();

    }
}
