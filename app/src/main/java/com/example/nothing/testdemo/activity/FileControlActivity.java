package com.example.nothing.testdemo.activity;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.nothing.testdemo.R;
import com.example.nothing.testdemo.base.BaseActivity;

import butterknife.BindView;

public class FileControlActivity extends BaseActivity implements View.OnClickListener {

    @BindView(R.id.title_back)
    ImageView titleBack;
    @BindView(R.id.title_name)
    TextView titleName;
    @BindView(R.id.file_shouce)
    LinearLayout fileShouce;
    @BindView(R.id.file_beian)
    LinearLayout fileBeian;

    @Override
    protected int setLayoutId() {
        return R.layout.activity_file_control;
    }

    @Override
    protected void initView() {
        titleBack.setVisibility(View.VISIBLE);
        titleName.setVisibility(View.VISIBLE);
        titleName.setText("文件管理");
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void setListener() {
        titleBack.setOnClickListener(this);
        fileShouce.setOnClickListener(this);
        fileBeian.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.title_back:
                finish();
                break;
            case R.id.file_shouce:
                PDFActivity.trans(FileControlActivity.this , "使用手册" , "shi_yong_shou_ce.pdf");
                break;
            case R.id.file_beian:
                PDFActivity.trans(FileControlActivity.this , "合同备案" , "he_tong_bei_an.pdf");
                break;
        }
    }
}
