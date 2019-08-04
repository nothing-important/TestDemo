package com.example.nothing.testdemo.activity;

import android.content.Intent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.nothing.testdemo.R;
import com.example.nothing.testdemo.base.BaseActivity;

import butterknife.BindView;

public class AccessControlActivity extends BaseActivity implements View.OnClickListener {

    @BindView(R.id.title_back)
    ImageView titleBack;
    @BindView(R.id.title_name)
    TextView titleName;
    @BindView(R.id.access_key)
    TextView accessKey;

    @Override
    protected int setLayoutId() {
        return R.layout.activity_access_control;
    }

    @Override
    protected void initView() {
        titleBack.setVisibility(View.VISIBLE);
        titleName.setVisibility(View.VISIBLE);
        titleName.setText("智慧门禁");
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void setListener() {
        titleBack.setOnClickListener(this);
        accessKey.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.title_back:
                finish();
                break;
            case R.id.access_key:
                startActivity(new Intent(AccessControlActivity.this , MyKeyActivity.class));
                break;
        }
    }
}
