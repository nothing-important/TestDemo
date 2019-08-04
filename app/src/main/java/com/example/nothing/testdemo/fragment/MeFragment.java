package com.example.nothing.testdemo.fragment;

import android.content.Intent;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.nothing.testdemo.R;
import com.example.nothing.testdemo.activity.AddressActivity;
import com.example.nothing.testdemo.activity.SettingActivity;
import com.example.nothing.testdemo.base.BaseFragment;

import butterknife.BindView;

public class MeFragment extends BaseFragment implements View.OnClickListener {

    @BindView(R.id.title_back)
    ImageView titleBack;
    @BindView(R.id.title_name)
    TextView titleName;
    @BindView(R.id.me_money)
    LinearLayout meMoney;
    @BindView(R.id.me_address)
    LinearLayout meAddress;
    @BindView(R.id.me_setting)
    LinearLayout meSetting;

    @Override
    protected int setLayoutId() {
        return R.layout.fragment_me;
    }

    @Override
    protected void initView() {
        titleName.setVisibility(View.VISIBLE);
        titleName.setText("我的");
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void setListener() {
        meMoney.setOnClickListener(this);
        meAddress.setOnClickListener(this);
        meSetting.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.me_money:

                break;
            case R.id.me_address:
                Intent intent1 = new Intent(getActivity() , AddressActivity.class);
                startActivity(intent1);
                break;
            case R.id.me_setting:
                Intent intent = new Intent(getActivity() , SettingActivity.class);
                startActivity(intent);
                break;
        }
    }
}
