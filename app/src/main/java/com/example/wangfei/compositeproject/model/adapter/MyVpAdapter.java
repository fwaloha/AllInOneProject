package com.example.wangfei.compositeproject.model.adapter;


import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;

/**
 * Created by wangfei on 16/9/18.
 */

public class MyVpAdapter extends FragmentPagerAdapter {

    private ArrayList<Fragment> fragments;

    public MyVpAdapter(FragmentManager fm, ArrayList mlist) {
        super(fm);
        fragments = mlist;
    }


    @Override
    public android.support.v4.app.Fragment getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public int getCount() {
        return 4;
    }
}
