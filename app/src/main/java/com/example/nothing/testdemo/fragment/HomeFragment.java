package com.example.nothing.testdemo.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.daimajia.slider.library.Indicators.PagerIndicator;
import com.daimajia.slider.library.SliderLayout;
import com.daimajia.slider.library.SliderTypes.BaseSliderView;
import com.daimajia.slider.library.SliderTypes.TextSliderView;
import com.daimajia.slider.library.Tricks.ViewPagerEx;
import com.example.nothing.testdemo.R;
import com.example.nothing.testdemo.activity.AccessControlActivity;
import com.example.nothing.testdemo.activity.FileControlActivity;
import com.example.nothing.testdemo.activity.PhoneActivity;
import com.example.nothing.testdemo.activity.WorkAttendanceActivity;
import com.example.nothing.testdemo.adapter.AdapterHome;
import com.example.nothing.testdemo.adapter.AdapterHomeNews;
import com.example.nothing.testdemo.api.ConstantsAPI;
import com.example.nothing.testdemo.base.BaseFragment;
import com.example.nothing.testdemo.bean.BeanIcon;
import com.example.nothing.testdemo.bean.BeanNews;
import com.example.nothing.testdemo.weight.DescriptionAnimation1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;

public class HomeFragment extends BaseFragment implements BaseSliderView.OnSliderClickListener, ViewPagerEx.OnPageChangeListener, AdapterHome.HomeItemClick {

    @BindView(R.id.home_slider)
    SliderLayout homeSlider;
    @BindView(R.id.home_indicator)
    PagerIndicator homeIndicator;
    @BindView(R.id.home_recycler)
    RecyclerView homeRecycler;
    @BindView(R.id.home_recycler_news)
    RecyclerView homeRecyclerNews;

    private HashMap<String , String> sliderData = new HashMap<>();
    private AdapterHome adapterHome;
    private AdapterHomeNews adapterHomeNews;
    private List<BeanIcon> selectedIconData = new ArrayList<>();
    private List<BeanNews> newsData = new ArrayList<>();

    @Override
    protected int setLayoutId() {
        return R.layout.fragment_home;
    }

    @Override
    protected void initView() {
        for(String name : sliderData.keySet()){
            TextSliderView textSliderView = new TextSliderView(getActivity());
            textSliderView
                    .image(sliderData.get(name))
                    .setScaleType(BaseSliderView.ScaleType.CenterCrop)
                    .setOnSliderClickListener(this);
            textSliderView.bundle(new Bundle());
            textSliderView.getBundle()
                    .putString("extra",name);
            Log.e("ooo", "initView: "+sliderData.get(name));
            homeSlider.addSlider(textSliderView);
        }
        homeSlider.setPresetTransformer(SliderLayout.Transformer.Accordion);
        homeSlider.setCustomIndicator(homeIndicator);
        homeSlider.setCustomAnimation(new DescriptionAnimation1());
        homeSlider.setDuration(4000);
        homeSlider.addOnPageChangeListener(this);
        initRecycler();
    }

    private void initRecycler() {
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getActivity() , 4);
        homeRecycler.setLayoutManager(gridLayoutManager);
        homeRecycler.setHasFixedSize(true);
        homeRecycler.setNestedScrollingEnabled(false);
        adapterHome = new AdapterHome(selectedIconData , getActivity());
        adapterHome.setOnHomeItemClickListener(this);
        homeRecycler.setAdapter(adapterHome);
        LinearLayoutManager linearLayout = new LinearLayoutManager(getActivity());
        homeRecyclerNews.setLayoutManager(linearLayout);
        homeRecyclerNews.setHasFixedSize(true);
        homeRecyclerNews.setNestedScrollingEnabled(false);
        adapterHomeNews = new AdapterHomeNews(newsData , getActivity());
        homeRecyclerNews.setAdapter(adapterHomeNews);
    }

    @Override
    protected void initData() {
        sliderData = ConstantsAPI.getSliderData();
        selectedIconData = ConstantsAPI.getIconSelectedData();
        newsData = ConstantsAPI.getNewsData();
    }

    @Override
    protected void setListener() {

    }

    @Override
    public void onSliderClick(BaseSliderView slider) {

    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {

    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }

    @Override
    public void onHomeItemClick(int psn) {
        BeanIcon beanIcon = selectedIconData.get(psn);
        String name = beanIcon.getName();
        Intent intent = null;
        if (name.equals("智慧门禁")){
            intent = new Intent(getActivity() , AccessControlActivity.class);
        }else if (name.equals("文件管理")){
            intent = new Intent(getActivity() , FileControlActivity.class);
        }else if (name.equals("考勤打卡")){
            intent = new Intent(getActivity() , WorkAttendanceActivity.class);
        }else if (name.equals("通讯录")){
            intent = new Intent(getActivity() , PhoneActivity.class);
        }
        if (intent == null){
            return;
        }
        startActivity(intent);
    }
}
