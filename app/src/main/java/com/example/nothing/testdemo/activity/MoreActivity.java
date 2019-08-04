package com.example.nothing.testdemo.activity;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.nothing.testdemo.R;
import com.example.nothing.testdemo.adapter.AdapterHome;
import com.example.nothing.testdemo.adapter.AdapterHomeTop;
import com.example.nothing.testdemo.api.ConstantsAPI;
import com.example.nothing.testdemo.base.BaseActivity;
import com.example.nothing.testdemo.bean.BeanIcon;

import java.util.ArrayList;
import java.util.List;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;

public class MoreActivity extends BaseActivity implements View.OnClickListener {

    @BindView(R.id.title_back)
    ImageView titleBack;
    @BindView(R.id.title_name)
    TextView titleName;
    @BindView(R.id.title_right)
    TextView titleRight;
    @BindView(R.id.more_select_recycler)
    RecyclerView moreSelectRecycler;
    @BindView(R.id.more_all_recycler)
    RecyclerView moreAllRecycler;
    private List<BeanIcon> allData , selectData = new ArrayList<>();
    private boolean isEdit = true;
    private AdapterHome adapterHomeTop;
    private AdapterHome adapterHome;

    @Override
    protected int setLayoutId() {
        return R.layout.activity_more;
    }

    @Override
    protected void initView() {
        titleBack.setVisibility(View.VISIBLE);
        titleName.setVisibility(View.VISIBLE);
        titleRight.setVisibility(View.VISIBLE);
        titleName.setText("更多");
        titleRight.setText("编辑");
    }

    @Override
    protected void initData() {
        allData = ConstantsAPI.getIconData();
        for (int i = 0; i < allData.size(); i++) {
            if (allData.get(i).isSelect()){
                selectData.add(allData.get(i));
            }
        }
        selectData = ConstantsAPI.getIconSelectedData();
        for (int i = 0; i < selectData.size(); i++) {
            selectData.get(i).setBootom(false);
        }
        adapterHome = new AdapterHome(allData , this , false);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this , 4);
        moreAllRecycler.setLayoutManager(gridLayoutManager);
        moreAllRecycler.setAdapter(adapterHome);
        adapterHomeTop = new AdapterHome(selectData , this , true);
        GridLayoutManager gridLayoutManager1 = new GridLayoutManager(this , 4);
        moreSelectRecycler.setLayoutManager(gridLayoutManager1);
        moreSelectRecycler.setAdapter(adapterHomeTop);
        adapterHome.setOnButtonClick(new AdapterHome.ButtonClick() {
            @Override
            public void onButtonClick(boolean isTop, int psn) {
                BeanIcon beanIcon = allData.get(psn);
                if (!beanIcon.isSelect()){
                    beanIcon.setSelect(true);
                    BeanIcon tempBean = new BeanIcon();
                    tempBean.setBootom(beanIcon.isBootom());
                    tempBean.setSelect(beanIcon.isSelect());
                    tempBean.setShowIcon(beanIcon.isShowIcon());
                    tempBean.setImgSrc(beanIcon.getImgSrc());
                    tempBean.setName(beanIcon.getName());
                    selectData.add(tempBean);
                    adapterHome.notifyDataSetChanged();
                    adapterHomeTop.notifyDataSetChanged();
                }
            }
        });
        adapterHomeTop.setOnButtonClick(new AdapterHome.ButtonClick() {
            @Override
            public void onButtonClick(boolean isTop, int psn) {
                BeanIcon beanIcon = selectData.get(psn);
                selectData.remove(psn);
                for (int i = 0; i < allData.size(); i++) {
                    if (allData.get(i).getName().equals(beanIcon.getName())){
                        allData.get(i).setSelect(false);
                    }
                }
                adapterHome.notifyDataSetChanged();
                adapterHomeTop.notifyDataSetChanged();
            }
        });
    }

    @Override
    protected void setListener() {
        titleBack.setOnClickListener(this);
        titleRight.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.title_back:
                finish();
                break;
            case R.id.title_right:
                //selectData.clear();
                if (isEdit) {
                    titleRight.setText("完成");
                    for (int i = 0; i < selectData.size(); i++) {
                        selectData.get(i).setShowIcon(true);
                        selectData.get(i).setBootom(true);
                    }
                    for (int i = 0; i < allData.size(); i++) {
                        allData.get(i).setShowIcon(true);
                    }
                    adapterHome.notifyDataSetChanged();
                    adapterHomeTop.notifyDataSetChanged();
                }else {
                    titleRight.setText("编辑");
                    for (int i = 0; i < selectData.size(); i++) {
                        selectData.get(i).setShowIcon(false);
                        selectData.get(i).setBootom(false);
                    }
                    for (int i = 0; i < allData.size(); i++) {
                        allData.get(i).setShowIcon(false);
                        allData.get(i).setBootom(true);
                    }
                    adapterHome.notifyDataSetChanged();
                    adapterHomeTop.notifyDataSetChanged();
                }
                isEdit = !isEdit;
                break;
        }
    }
}
