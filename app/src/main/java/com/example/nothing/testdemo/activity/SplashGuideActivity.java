package com.example.nothing.testdemo.activity;

import android.content.Intent;
import android.util.DisplayMetrics;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.WindowManager;
import android.widget.ImageView;

import androidx.viewpager.widget.ViewPager;

import com.example.nothing.testdemo.MainActivity;
import com.example.nothing.testdemo.R;
import com.example.nothing.testdemo.adapter.AdapterSplash;
import com.example.nothing.testdemo.api.ConstantsAPI;
import com.example.nothing.testdemo.base.BaseActivity;
import com.example.nothing.testdemo.storage.UserCache;

import java.util.List;

import butterknife.BindView;

public class SplashGuideActivity extends BaseActivity implements ViewPager.OnPageChangeListener {

    @BindView(R.id.splash_viewpager)
    ViewPager splashViewpager;
    @BindView(R.id.splash_indicator_one)
    ImageView splashIndicatorOne;
    @BindView(R.id.splash_indicator_two)
    ImageView splashIndicatorTwo;
    @BindView(R.id.splash_indicator_three)
    ImageView splashIndicatorThree;
    @BindView(R.id.splash_indicator_four)
    ImageView splashIndicatorFour;
    private List<String> dataList;
    private GestureDetector mGestureDetector;
    private int currentItem = 0;
    private int flaggingWidth = 0;
    private UserCache userCache;

    @Override
    protected int setLayoutId() {
        return R.layout.activity_splash;
    }

    @Override
    protected void initView() {
        getWindow().setFlags(WindowManager.LayoutParams. FLAG_FULLSCREEN ,
                WindowManager.LayoutParams. FLAG_FULLSCREEN);
        AdapterSplash adapterSplash = new AdapterSplash(dataList , this);
        splashViewpager.setAdapter(adapterSplash);
        splashViewpager.setOnPageChangeListener(this);
        slipToMain();
    }

    @Override
    public void setStatusBarColor() {
    }

    @Override
    protected void initData() {
        userCache = UserCache.getUserCache(this);
        if (userCache.userIsFirstOpen){
            dataList = ConstantsAPI.getSplashData();
            // 获取分辨率
            DisplayMetrics dm = new DisplayMetrics();
            getWindowManager().getDefaultDisplay().getMetrics(dm);
            flaggingWidth = dm.widthPixels / 3;
        }else {
            toMainActivity();
        }
    }

    @Override
    protected void setListener() {

    }

    private void slipToMain(){
        mGestureDetector = new GestureDetector(this,
                new GestureDetector.SimpleOnGestureListener() {

                    @Override
                    public boolean onFling(MotionEvent e1, MotionEvent e2,
                                           float velocityX, float velocityY) {
                        if (currentItem == 3) {
                            if ((e1.getRawX() - e2.getRawX()) >= flaggingWidth) {
                                toMainActivity();
                                return true;
                            }
                        }
                        return false;
                    }

                });
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        currentItem = position;
        clearAllPoint();
        switch (position){
            case 0:
                setSelectPoint(splashIndicatorOne);
                break;
            case 1:
                setSelectPoint(splashIndicatorTwo);
                break;
            case 2:
                setSelectPoint(splashIndicatorThree);
                break;
            case 3:
                setSelectPoint(splashIndicatorFour);
                break;
        }
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }

    private void toMainActivity(){
        userCache.userIsFirstOpen = false;
        userCache.save();
        if (userCache.userIsLogin){
            Intent intent = new Intent(SplashGuideActivity.this, MainActivity.class);
            startActivity(intent);
            finish();
        }else {
            userCache.userIsLogin = true;
            userCache.save();
            Intent intent = new Intent(SplashGuideActivity.this, LoginActivity.class);
            startActivity(intent);
            finish();
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        mGestureDetector.onTouchEvent(event);
        return super.onTouchEvent(event);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        if (mGestureDetector.onTouchEvent(ev)){
            ev.setAction(MotionEvent.ACTION_CANCEL);
        }
        return super.dispatchTouchEvent(ev);
    }

    private void clearAllPoint(){
        splashIndicatorOne.setBackgroundResource(R.drawable.circle_point_grey);
        splashIndicatorThree.setBackgroundResource(R.drawable.circle_point_grey);
        splashIndicatorTwo.setBackgroundResource(R.drawable.circle_point_grey);
        splashIndicatorFour.setBackgroundResource(R.drawable.circle_point_grey);
    }
    private void setSelectPoint(ImageView imageView){
        imageView.setBackgroundResource(R.drawable.circle_point_white);
    }
}
