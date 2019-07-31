package com.example.nothing.testdemo.base;

import android.app.Activity;
import android.os.Bundle;

import com.example.nothing.testdemo.R;
import com.example.nothing.testdemo.utils.StatusBarUtil;

import androidx.fragment.app.FragmentActivity;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public abstract class BaseActivity extends FragmentActivity {

    private Unbinder unbinder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setStatusBarColor();
        setContentView(setLayoutId());
        unbinder = ButterKnife.bind(this);
        initData();
        initView();
        setListener();
    }

    protected abstract int setLayoutId();
    protected abstract void initView();
    protected abstract void initData();
    protected abstract void setListener();

    public void setStatusBarColor(){
        StatusBarUtil.setColorForSwipeBack(this, getResources().getColor(R.color.white), 0);
        StatusBarUtil.setLightMode(this, true);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unbinder.unbind();
    }
}
