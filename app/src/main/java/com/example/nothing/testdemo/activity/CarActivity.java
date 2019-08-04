package com.example.nothing.testdemo.activity;

import android.view.View;
import android.widget.ImageView;

import com.example.nothing.testdemo.R;
import com.example.nothing.testdemo.base.BaseActivity;

import butterknife.BindView;

public class CarActivity extends BaseActivity implements View.OnClickListener {

    @BindView(R.id.title_back)
    ImageView titleBack;


    @Override
    protected int setLayoutId() {
        return R.layout.activity_car;
    }

    @Override
    protected void initView() {

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
