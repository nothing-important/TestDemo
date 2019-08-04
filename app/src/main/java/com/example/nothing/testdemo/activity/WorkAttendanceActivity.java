package com.example.nothing.testdemo.activity;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;

import com.example.nothing.testdemo.R;
import com.example.nothing.testdemo.base.BaseActivity;
import com.example.nothing.testdemo.fragment.AttendanceFragment;
import com.example.nothing.testdemo.fragment.DriveFragment;
import com.example.nothing.testdemo.fragment.HomeFragment;
import com.example.nothing.testdemo.fragment.MeFragment;
import com.example.nothing.testdemo.fragment.StatisticsFragment;

import androidx.fragment.app.FragmentTransaction;
import butterknife.BindView;

public class WorkAttendanceActivity extends BaseActivity implements View.OnClickListener {

    @BindView(R.id.title_back)
    ImageView titleBack;
    @BindView(R.id.title_name)
    TextView titleName;
    @BindView(R.id.work_container)
    FrameLayout workContainer;
    @BindView(R.id.work_attendance)
    RadioButton workAttendance;
    @BindView(R.id.work_statistics)
    RadioButton workStatistics;
    private AttendanceFragment attendanceFragment;
    private StatisticsFragment statisticsFragment;

    @Override
    protected int setLayoutId() {
        return R.layout.activity_work_attendance;
    }

    @Override
    protected void initView() {
        titleBack.setVisibility(View.VISIBLE);
        titleName.setVisibility(View.VISIBLE);
        titleName.setText("考勤打卡");
        showFirstFragment();
        workAttendance.setChecked(true);
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void setListener() {
        titleBack.setOnClickListener(this);
        workAttendance.setOnClickListener(this);
        workStatistics.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.title_back:
                finish();
                break;
            case R.id.work_attendance:
                switchFragment(0);
                titleName.setText("考勤打卡");
                break;
            case R.id.work_statistics:
                switchFragment(1);
                titleName.setText("统计");
                break;
        }
    }

    private void switchFragment(int value){
        switch (value){
            case 0:
                FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
                hideFragment(fragmentTransaction);
                if (attendanceFragment == null){
                    attendanceFragment = new AttendanceFragment();
                    fragmentTransaction.add(R.id.work_container , attendanceFragment);
                }else {
                    fragmentTransaction.show(attendanceFragment);
                }
                fragmentTransaction.commit();
                break;
            case 1:
                FragmentTransaction fragmentTransaction1 = getSupportFragmentManager().beginTransaction();
                hideFragment(fragmentTransaction1);
                if (statisticsFragment == null){
                    statisticsFragment = new StatisticsFragment();
                    fragmentTransaction1.add(R.id.work_container , statisticsFragment);
                }else {
                    fragmentTransaction1.show(statisticsFragment);
                }
                fragmentTransaction1.commit();
                break;
        }
    }

    private void hideFragment(FragmentTransaction fragmentTransaction){
        if (attendanceFragment != null){
            fragmentTransaction.hide(attendanceFragment);
        }
        if (statisticsFragment != null){
            fragmentTransaction.hide(statisticsFragment);
        }
    }

    private void showFirstFragment(){
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        hideFragment(fragmentTransaction);
        if (attendanceFragment == null){
            attendanceFragment = new AttendanceFragment();
            fragmentTransaction.add(R.id.work_container , attendanceFragment);
        }else {
            fragmentTransaction.show(attendanceFragment);
        }
        fragmentTransaction.commit();
    }
}
