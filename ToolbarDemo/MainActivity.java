package com.example.owlslubic.toolbardemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    //STEP 1: action bars are default, so we go to the STYLES.XML resource to remove it

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //STEP 3: get a reference to toolbar from xml
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        //STEP 4: set the toolbar as an actionbar
        setSupportActionBar(toolbar);//this tells the app that i want it to act like an actionbar - having the homebutton
        //STEP 5: adding the menu - first we make a new resource directory with the type "menu" and add a layout



    }

    //STEP 5a: inflate the menu
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu,menu);
        return super.onCreateOptionsMenu(menu);
    }
    //STEP 6: set some onClickListener-equivalents so that our menu does... anything
    @Override//when it returns true: that's telling the system that the event has been handled and we dont need to worry
    //false means that the action has not happened yet, keep worrying about it
    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId()){
            case R.id.action_share:
                //setting this with an intent to take us to the next activity so that we can check out our cool other toolbar
                //passing intent directly into start activity rather than saving it as a variable
                startActivity(new Intent(this, ChildActivity.class));
                Toast.makeText(MainActivity.this, "Share Clicked", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.action_settings:
                Toast.makeText(MainActivity.this, "Settings Clicked", Toast.LENGTH_SHORT).show();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
