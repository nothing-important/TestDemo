package com.example.nothing.testdemo.adapter;

import android.content.Context;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import java.util.List;

public class MyFragmentPageAdapter extends FragmentPagerAdapter {

    private Context context;
    private List<String> titles;
    private List<Fragment> fragments;

    public MyFragmentPageAdapter(FragmentManager fm , Context context , List<String> titles , List<Fragment> fragments) {
        super(fm);
        this.context = context;
        this.titles = titles;
        this.fragments = fragments;
    }

    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public int getCount() {
        return fragments.size();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return titles.get(position);
    }
}
