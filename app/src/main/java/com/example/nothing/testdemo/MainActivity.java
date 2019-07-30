package com.example.nothing.testdemo;


import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.RadioButton;

import com.example.nothing.testdemo.base.BaseActivity;
import com.example.nothing.testdemo.fragment.DriveFragment;
import com.example.nothing.testdemo.fragment.HomeFragment;
import com.example.nothing.testdemo.fragment.MeFragment;

import butterknife.BindView;

public class MainActivity extends BaseActivity implements View.OnClickListener {

    @BindView(R.id.container)
    FrameLayout container;
    @BindView(R.id.main_home)
    RadioButton mainHome;
    @BindView(R.id.main_drive)
    RadioButton mainDrive;
    @BindView(R.id.main_me)
    RadioButton mainMe;

    private HomeFragment homeFragment;
    private DriveFragment driveFragment;
    private MeFragment meFragment;
    private FragmentTransaction transaction;

    @Override
    protected int setLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void initData() {
        transaction = getSupportFragmentManager().beginTransaction();
    }

    @Override
    protected void setListener() {
        mainHome.setOnClickListener(this);
        mainDrive.setOnClickListener(this);
        mainMe.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.main_home:
                switchFragment(0);
                break;
            case R.id.main_drive:
                switchFragment(1);
                break;
            case R.id.main_me:
                switchFragment(2);
                break;
        }
    }

    private void switchFragment(int value){
        switch (value){
            case 0:
                hideFragment();
                if (homeFragment == null){
                    homeFragment = new HomeFragment();
                    transaction.add(R.id.container , homeFragment);
                }else {
                    transaction.show(homeFragment);
                }
                break;
            case 1:
                hideFragment();
                if (driveFragment == null){
                    driveFragment = new DriveFragment();
                    transaction.add(R.id.container , driveFragment);
                }else {
                    transaction.show(driveFragment);
                }
                break;
            case 2:
                hideFragment();
                if (meFragment == null){
                    meFragment = new MeFragment();
                    transaction.add(R.id.container , meFragment);
                }else {
                    transaction.show(meFragment);
                }
                break;
        }
    }

    private void hideFragment(){
        if (homeFragment != null){
            transaction.hide(homeFragment);
        }
        if (driveFragment != null){
            transaction.hide(driveFragment);
        }
        if (meFragment != null){
            transaction.hide(meFragment);
        }
    }
}
