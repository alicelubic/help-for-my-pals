package com.example.owlslubic.toolbardemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class ChildActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_child);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar_too);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);//returns us the actionbar version of this toolbar so we can set the home button


    }
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.child_menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId()){
            case android.R.id.home:
                //this option allows us to navigate up to our parent activity
                onNavigateUp();
                //but we have to add something in our manifest to tell it that hte main activity is the parent activity
                return true;
            case R.id.action_compass:
                Toast.makeText(ChildActivity.this, "Nowhere To Go!", Toast.LENGTH_LONG).show();
                return true;
            case R.id.action_call:
                Toast.makeText(ChildActivity.this, "No One To Call!", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.action_bye:
                Toast.makeText(ChildActivity.this, "Bye.", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.action_settings:
                Toast.makeText(ChildActivity.this, "You have no power over me!", Toast.LENGTH_SHORT).show();
        }
        return super.onOptionsItemSelected(item);
    }
}
