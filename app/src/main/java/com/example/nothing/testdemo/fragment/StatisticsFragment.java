package com.example.nothing.testdemo.fragment;

import android.util.DisplayMetrics;
import android.view.View;
import android.widget.LinearLayout;

import com.example.nothing.testdemo.R;
import com.example.nothing.testdemo.base.BaseFragment;
import com.example.nothing.testdemo.utils.ToastU;
import com.example.nothing.testdemo.weight.WheelWindow;

import butterknife.BindView;

public class StatisticsFragment extends BaseFragment {

    @BindView(R.id.statistics_date_pick)
    LinearLayout statisticsDatePick;
    private WheelWindow wheelWindow;

    @Override
    protected int setLayoutId() {
        return R.layout.fragment_statistics;
    }

    @Override
    protected void initView() {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        getActivity().getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        int windowWidth = displayMetrics.widthPixels;
        int windowHeight = displayMetrics.heightPixels;
        wheelWindow = new WheelWindow(getActivity() , windowWidth , windowHeight);
        statisticsDatePick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                wheelWindow.show();
            }
        });
        wheelWindow.setOnSelectSureListener(new WheelWindow.OnSelectSureListener() {
            @Override
            public void onSelectSure(int position, String item) {
                wheelWindow.dismiss();
            }
        });
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void setListener() {

    }

    @Override
    public void onStop() {
        super.onStop();
        wheelWindow.dismiss();
    }
}
