package com.example.nothing.testdemo.activity;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.nothing.testdemo.R;
import com.example.nothing.testdemo.base.BaseActivity;

import butterknife.BindView;

public class AddressActivity extends BaseActivity {

    @BindView(R.id.title_back)
    ImageView titlBack;
    @BindView(R.id.title_name)
    TextView titlName;

    @Override
    protected int setLayoutId() {
        return R.layout.activity_address;
    }

    @Override
    protected void initView() {
        titlBack.setVisibility(View.VISIBLE);
        titlName.setVisibility(View.VISIBLE);
        titlName.setText("我的地址");
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void setListener() {

    }
}
