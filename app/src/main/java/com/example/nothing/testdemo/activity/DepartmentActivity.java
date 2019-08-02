package com.example.nothing.testdemo.activity;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.nothing.testdemo.R;
import com.example.nothing.testdemo.adapter.AdapterPhone;
import com.example.nothing.testdemo.api.ConstantsAPI;
import com.example.nothing.testdemo.base.BaseActivity;
import com.example.nothing.testdemo.base.BeanPhone;

import java.util.List;

import butterknife.BindView;

public class DepartmentActivity extends BaseActivity implements View.OnClickListener {

    @BindView(R.id.title_back)
    ImageView titleBack;
    @BindView(R.id.title_name)
    TextView titleName;
//    @BindView(R.id.phone_mine)
//    LinearLayout phoneMine;
    @BindView(R.id.phone_recycler)
    RecyclerView phoneRecycler;
    private List<BeanPhone> phoneList;

    @Override
    protected int setLayoutId() {
        return R.layout.activity_phone_mine;
    }

    @Override
    protected void initView() {
        titleBack.setVisibility(View.VISIBLE);
        titleName.setVisibility(View.VISIBLE);
        titleName.setText("我的部门");
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        phoneRecycler.setLayoutManager(linearLayoutManager);
        AdapterPhone adapterPhone = new AdapterPhone(this , phoneList);
        phoneRecycler.setAdapter(adapterPhone);
    }

    @Override
    protected void initData() {
        phoneList = ConstantsAPI.getDepartmentData();
    }

    @Override
    protected void setListener() {
        titleBack.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.title_back:
                finish();
                break;
        }
    }
}
