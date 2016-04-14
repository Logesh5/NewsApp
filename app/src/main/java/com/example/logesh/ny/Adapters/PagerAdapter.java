package com.example.logesh.ny.Adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.example.logesh.ny.Fragments.Fragment_Fashion;
import com.example.logesh.ny.Fragments.Fragment_Food;
import com.example.logesh.ny.Fragments.Fragment_Sports;
import com.example.logesh.ny.Fragments.Fragment_Top_Stories;
import com.example.logesh.ny.Fragments.Fragment_Travel;

/**
 * Created by logesh on 12-04-2016.
 */
public class PagerAdapter extends FragmentStatePagerAdapter {


    public PagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch(position){
            case 0: return new Fragment_Top_Stories();
            case 1: return new Fragment_Sports();
            case 2: return new Fragment_Food();
            case 3: return new Fragment_Fashion();
            case 4: return new Fragment_Travel();
        }

        return null;
    }

    @Override
    public int getCount() {
        return 5;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        if(position == 0){
            return "Top Stories";
        }
        if(position == 1){
            return "Sports";
        }
        if(position == 2){
            return "Food";
        }
        if(position == 3){
            return "Fashion";
        }
        if(position == 4){
            return "Travel";
        }

        return super.getPageTitle(position);
    }
}
