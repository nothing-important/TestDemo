package com.example.nothing.testdemo.base;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.ButterKnife;
import butterknife.Unbinder;

public abstract class BaseFragment extends Fragment {

    private Unbinder bind;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(setLayoutId() , container , false);
        bind = ButterKnife.bind(this, view);
        return view;
    }

    protected abstract int setLayoutId();
    protected abstract void initView();
    protected abstract void initData();
    protected abstract void setListener();

    @Override
    public void onDestroy() {
        super.onDestroy();
        bind.unbind();
    }
}
