package com.example.nothing.testdemo.fragment;

import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.example.nothing.testdemo.R;
import com.example.nothing.testdemo.adapter.MyFragmentPageAdapter;
import com.example.nothing.testdemo.base.BaseFragment;
import com.google.android.material.tabs.TabLayout;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

public class AttendanceFragment extends BaseFragment {

    @BindView(R.id.attendance_tab)
    TabLayout attendanceTab;
    @BindView(R.id.attendance_viewpager)
    ViewPager attendanceViewpager;

    private List<Fragment> fragments = new ArrayList<>();
    private List<String> titles = new ArrayList<>();
    private MyFragmentPageAdapter adapter;

    @Override
    protected int setLayoutId() {
        return R.layout.fragment_attendance;
    }

    @Override
    protected void initView() {
        //setIndicator(getActivity() , attendanceTab , 30 , 30);
    }

    @Override
    protected void initData() {
        titles.add("上班打卡 ");
        titles.add("外勤打卡 ");
        fragments.add(new AttendanceInFragment());
        fragments.add(new AttendanceOutFragment());
        adapter = new MyFragmentPageAdapter(getChildFragmentManager() , getActivity() , titles , fragments);
        attendanceViewpager.setAdapter(adapter);
        attendanceTab.setupWithViewPager(attendanceViewpager);
    }

    @Override
    protected void setListener() {

    }

    public void setTabLine(Context context, TabLayout tab, int left, int right) {
        try {
            Class<?> tablayout = tab.getClass();
            Field tabStrip = tablayout.getDeclaredField("mTabStrip");
            tabStrip.setAccessible(true);
            LinearLayout ll_tab = (LinearLayout) tabStrip.get(tab);
            for (int i = 0; i < ll_tab.getChildCount(); i++) {
                View child = ll_tab.getChildAt(i);
                child.setPadding(0, 0, 0, 0);
                LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(0, LinearLayout.LayoutParams.MATCH_PARENT, 1);
                //修改两个tab的间距
                params.setMarginStart(dip2px(context, left));
                params.setMarginEnd(dip2px(context, right));
                child.setLayoutParams(params);
                child.invalidate();
            }
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    public int dip2px(Context context, float dpValue) {
        return ((int) (dpValue
                * context.getResources().getDisplayMetrics().density + 0.5f));
    }

    public void setIndicator(Context context, TabLayout tabs, int leftDip, int rightDip) {
        Class<?> tabLayout = tabs.getClass();
        Field tabStrip = null;
        try {
            tabStrip = tabLayout.getDeclaredField("mTabStrip");
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }

        tabStrip.setAccessible(true);
        LinearLayout ll_tab = null;
        try {
            ll_tab = (LinearLayout) tabStrip.get(tabs);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        int left = dip2px(context , leftDip);
        int right = dip2px(context , rightDip);

        for (int i = 0; i < ll_tab.getChildCount(); i++) {
            View child = ll_tab.getChildAt(i);
            child.setPadding(0, 0, 0, 0);
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(0, LinearLayout.LayoutParams.MATCH_PARENT, 1);
            params.leftMargin = left;
            params.rightMargin = right;
            child.setLayoutParams(params);
            child.invalidate();
        }
    }
}
