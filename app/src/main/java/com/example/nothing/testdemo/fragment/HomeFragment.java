package com.example.nothing.testdemo.fragment;

import android.os.Bundle;

import com.daimajia.slider.library.Animations.DescriptionAnimation;
import com.daimajia.slider.library.Indicators.PagerIndicator;
import com.daimajia.slider.library.SliderLayout;
import com.daimajia.slider.library.SliderTypes.BaseSliderView;
import com.daimajia.slider.library.SliderTypes.TextSliderView;
import com.daimajia.slider.library.Tricks.ViewPagerEx;
import com.example.nothing.testdemo.R;
import com.example.nothing.testdemo.api.ConstantsAPI;
import com.example.nothing.testdemo.base.BaseFragment;

import java.util.HashMap;

import butterknife.BindView;

public class HomeFragment extends BaseFragment implements BaseSliderView.OnSliderClickListener, ViewPagerEx.OnPageChangeListener {

    @BindView(R.id.home_slider)
    SliderLayout homeSlider;
    @BindView(R.id.home_indicator)
    PagerIndicator homeIndicator;

    private HashMap<String , String> sliderData = new HashMap<>();

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
                    .setScaleType(BaseSliderView.ScaleType.Fit)
                    .setOnSliderClickListener(this);
            textSliderView.bundle(new Bundle());
            textSliderView.getBundle()
                    .putString("extra",name);

            homeSlider.addSlider(textSliderView);
        }
        homeSlider.setPresetTransformer(SliderLayout.Transformer.Accordion);
        homeSlider.setCustomIndicator(homeIndicator);
        homeSlider.setCustomAnimation(new DescriptionAnimation());
        homeSlider.setDuration(4000);
        homeSlider.addOnPageChangeListener(this);
    }

    @Override
    protected void initData() {
        sliderData = ConstantsAPI.getSliderData();
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
}
