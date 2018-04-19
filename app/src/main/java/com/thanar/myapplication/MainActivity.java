package com.thanar.myapplication;

import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.os.Parcelable;
import android.support.annotation.Nullable;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.DisplayMetrics;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class MainActivity extends AppCompatActivity implements ItemClickListener {

    private Button en;
    private Button th;

    private List<People> you;
    private DrawerLayout mDrawerLayout;

    private RecyclerViewAdapter adapter;

    ActionBarDrawerToggle actionBarDrawerToggle;

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (actionBarDrawerToggle.onOptionsItemSelected(item))
            return true;
        return false;
    }

    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        actionBarDrawerToggle.syncState();

    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        actionBarDrawerToggle.onConfigurationChanged(newConfig);

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        en = findViewById(R.id.togglebutton);
        th = findViewById(R.id.togglebutton1);


        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        actionBarDrawerToggle = new ActionBarDrawerToggle(MainActivity.this,
                mDrawerLayout,
                R.string.open_drawer,
                R.string.close_drawer);
        mDrawerLayout.addDrawerListener(actionBarDrawerToggle);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        String[] surname = {"Aerith ", "Barret ", "Cait "
                , "Cid ", "Cloud ", "RedXIII", "Sephiroth"
                , "Tifa ", "Vincent ", "Yuffie "
                , "ZackFair"};
        String[] name = {"Gainsborough", "Wallace", "Sith"
                , "Highwind", "Strife", "", ""
                , " Lockhart", " Valentine", "Kisaragi"
                , ""};


        en.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Resources res = getApplicationContext().getResources();
                DisplayMetrics dm = res.getDisplayMetrics();
                android.content.res.Configuration conf = res.getConfiguration();
                conf.locale = new Locale("en");
                res.updateConfiguration(conf, dm);
                setContentView(R.layout.activity_main);
                Intent refresh = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(refresh);
                finish();

            }
        });

        th.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Resources res = getApplicationContext().getResources();
                DisplayMetrics dm = res.getDisplayMetrics();
                android.content.res.Configuration conf = res.getConfiguration();
                conf.locale = new Locale("th");
                res.updateConfiguration(conf, dm);
                setContentView(R.layout.activity_main);

                Intent refresh = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(refresh);
                finish();

            }
        });


        you = new ArrayList<People>();
        for (int i = 0; i < name.length; i++)
            you.add(new People(name[i], surname[i],R.mipmap.ic_people));


        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.rvPeople);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new RecyclerViewAdapter(this, you);
        adapter.setClickListener(this);
        recyclerView.setAdapter(adapter);


    }


    @Override
    public void onItemClick(View view, int position) {
        Intent intent = new Intent(this, ShowInfo.class);
        intent.putExtra("People", you.get(position));
        startActivity(intent);
    }
}
