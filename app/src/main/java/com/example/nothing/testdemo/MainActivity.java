package com.example.nothing.testdemo;


import android.view.View;
import android.widget.FrameLayout;
import android.widget.RadioButton;

import com.example.nothing.testdemo.base.BaseActivity;
import com.example.nothing.testdemo.fragment.DriveFragment;
import com.example.nothing.testdemo.fragment.HomeFragment;
import com.example.nothing.testdemo.fragment.MeFragment;

import androidx.fragment.app.FragmentTransaction;
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

    @Override
    protected int setLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void initData() {
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
                FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
                hideFragment(fragmentTransaction);
                if (homeFragment == null){
                    homeFragment = new HomeFragment();
                    fragmentTransaction.add(R.id.container , homeFragment);
                }else {
                    fragmentTransaction.show(homeFragment);
                }
                fragmentTransaction.commit();
                break;
            case 1:
                FragmentTransaction fragmentTransaction1 = getSupportFragmentManager().beginTransaction();
                hideFragment(fragmentTransaction1);
                if (driveFragment == null){
                    driveFragment = new DriveFragment();
                    fragmentTransaction1.add(R.id.container , driveFragment);
                }else {
                    fragmentTransaction1.show(driveFragment);
                }
                fragmentTransaction1.commit();
                break;
            case 2:
                FragmentTransaction fragmentTransaction2 = getSupportFragmentManager().beginTransaction();
                hideFragment(fragmentTransaction2);
                if (meFragment == null){
                    meFragment = new MeFragment();
                    fragmentTransaction2.add(R.id.container , meFragment);
                }else {
                    fragmentTransaction2.show(meFragment);
                }
                fragmentTransaction2.commit();
                break;
        }
    }

    private void hideFragment(FragmentTransaction fragmentTransaction){
        if (homeFragment != null){
            fragmentTransaction.hide(homeFragment);
        }
        if (driveFragment != null){
            fragmentTransaction.hide(driveFragment);
        }
        if (meFragment != null){
            fragmentTransaction.hide(meFragment);
        }
    }
}
