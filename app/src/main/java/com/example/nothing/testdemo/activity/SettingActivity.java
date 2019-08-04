package com.example.nothing.testdemo.activity;

import android.content.Intent;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.nothing.testdemo.R;
import com.example.nothing.testdemo.api.MyApplication;
import com.example.nothing.testdemo.base.BaseActivity;

import butterknife.BindView;

public class SettingActivity extends BaseActivity implements View.OnClickListener {

    @BindView(R.id.title_back)
    ImageView titleBack;
    @BindView(R.id.title_name)
    TextView titleName;
    @BindView(R.id.setting_logout)
    TextView settingLogout;
    @BindView(R.id.setting_account)
    LinearLayout settingAccount;
    @BindView(R.id.setting_about)
    LinearLayout settingAbout;
    @BindView(R.id.setting_notice)
    LinearLayout settingNotice;

    @Override
    protected int setLayoutId() {
        return R.layout.activity_setting;
    }

    @Override
    protected void initView() {
        titleBack.setVisibility(View.VISIBLE);
        titleName.setVisibility(View.VISIBLE);
        titleName.setText("设置");
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void setListener() {
        titleBack.setOnClickListener(this);
        settingLogout.setOnClickListener(this);
        settingAccount.setOnClickListener(this);
        settingAbout.setOnClickListener(this);
        settingNotice.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.title_back:
                finish();
                break;
            case R.id.setting_logout:
                MyApplication.finishAllActivity();
                Intent intent = new Intent(SettingActivity.this , LoginActivity.class);
                startActivity(intent);
                break;
            case R.id.setting_account:
                Intent intent1 = new Intent(SettingActivity.this , AccountActivity.class);
                startActivity(intent1);
                break;
            case R.id.setting_about:
                Intent intent2 = new Intent(SettingActivity.this , AboutUsActivity.class);
                startActivity(intent2);
                break;
            case R.id.setting_notice:
                Intent intent3 = new Intent(SettingActivity.this , NoticeActivity.class);
                startActivity(intent3);
                break;
        }
    }
}
