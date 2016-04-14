package com.example.logesh.ny;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.example.logesh.ny.Adapters.PagerAdapter;

import it.neokree.materialtabs.MaterialTab;
import it.neokree.materialtabs.MaterialTabHost;
import it.neokree.materialtabs.MaterialTabListener;

/**
 * Created by logesh on 15-03-2016.
 */
public class MainActivity extends AppCompatActivity implements MaterialTabListener{
    private Toolbar toolbar = null;
    MaterialTabHost tab;
    ViewPager pager;
    PagerAdapter mPagerAdapter;

    private String url = "http://api.nytimes.com/svc/topstories/v1/world.json?api-key=0d9d9f4410216e11cffda77938025cda:7:74509033";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar = (Toolbar) findViewById(R.id.app_bar_layout);
        tab = (MaterialTabHost) findViewById(R.id.materialTabHost);
        pager = (ViewPager) findViewById(R.id.viewPager);
        mPagerAdapter = new PagerAdapter(getSupportFragmentManager());
        pager.setAdapter(mPagerAdapter);
        pager.setOffscreenPageLimit(5);
        pager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                tab.setSelectedNavigationItem(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        for (int i = 0; i < mPagerAdapter.getCount(); i++) {
            tab.addTab(tab.newTab().setText(mPagerAdapter.getPageTitle(i)).setTabListener(this));
        }

        setSupportActionBar(toolbar);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return false;
    }

    @Override
    public void onTabSelected(MaterialTab tab) {
        pager.setCurrentItem(tab.getPosition());
    }

    @Override
    public void onTabReselected(MaterialTab tab) {

    }

    @Override
    public void onTabUnselected(MaterialTab tab) {

    }
}
