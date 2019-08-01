package com.example.nothing.testdemo.activity;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;

import com.example.nothing.testdemo.R;
import com.example.nothing.testdemo.base.BaseActivity;

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

    @Override
    protected int setLayoutId() {
        return R.layout.activity_work_attendance;
    }

    @Override
    protected void initView() {
        titleBack.setVisibility(View.VISIBLE);
        titleName.setVisibility(View.VISIBLE);
        titleName.setText("考勤打卡");
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void setListener() {
        titleBack.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.title_back:
                finish();
                break;
        }
    }
}
