package com.example.nothing.testdemo.fragment;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.example.nothing.testdemo.R;
import com.example.nothing.testdemo.adapter.MyFragmentPageAdapter;
import com.example.nothing.testdemo.base.BaseFragment;
import com.google.android.material.tabs.TabLayout;

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
}
