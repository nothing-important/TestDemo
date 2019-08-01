package com.example.nothing.testdemo.activity;

import android.util.Log;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;

import com.example.nothing.testdemo.R;
import com.example.nothing.testdemo.base.BaseActivity;
import com.example.nothing.testdemo.storage.UserCache;

import butterknife.BindView;

public class NoticeActivity extends BaseActivity implements View.OnClickListener {

    @BindView(R.id.title_back)
    ImageView titleBack;
    @BindView(R.id.title_name)
    TextView titleName;
    @BindView(R.id.notice_notice)
    Switch noticeNotice;
    @BindView(R.id.notice_vibrate)
    Switch noticeVibrate;
    private UserCache userCache;

    @Override
    protected int setLayoutId() {
        return R.layout.activity_notice;
    }

    @Override
    protected void initView() {
        titleBack.setVisibility(View.VISIBLE);
        titleName.setVisibility(View.VISIBLE);
        titleName.setText("消息通知");
    }

    @Override
    protected void initData() {
        userCache = UserCache.getUserCache(this);
        noticeVibrate.setChecked(userCache.isVibrateOpen);
        noticeNotice.setChecked(userCache.isNoticeOpen);
    }

    @Override
    protected void setListener() {
        titleBack.setOnClickListener(this);
        noticeNotice.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                userCache.isNoticeOpen = isChecked;
                userCache.save();
            }
        });
        noticeVibrate.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                userCache.isVibrateOpen = isChecked;
                userCache.save();
            }
        });
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
