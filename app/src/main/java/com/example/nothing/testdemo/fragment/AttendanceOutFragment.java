package com.example.nothing.testdemo.fragment;

import android.Manifest;
import android.view.View;
import android.widget.ImageView;

import com.example.nothing.testdemo.R;
import com.example.nothing.testdemo.activity.DepartmentActivity;
import com.example.nothing.testdemo.base.BaseActivity;
import com.example.nothing.testdemo.base.BaseFragment;
import com.example.nothing.testdemo.utils.CommonUtils;

import java.io.File;
import java.util.List;

import butterknife.BindView;

public class AttendanceOutFragment extends BaseFragment implements View.OnClickListener {

    @BindView(R.id.attendance_out_camera)
    ImageView attendanceOutCamera;

    @Override
    protected int setLayoutId() {
        return R.layout.fragment_attendance_out;
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void initData() {

    }

    @Override
    protected void setListener() {
        attendanceOutCamera.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.attendance_out_camera:
                ((BaseActivity)getActivity()).requestSelfPermissions(new String[]{Manifest.permission.CAMERA , Manifest.permission.WRITE_EXTERNAL_STORAGE , Manifest.permission.READ_EXTERNAL_STORAGE}, 11, new BaseActivity.PermissionRequestListener() {
                    @Override
                    public void onPermissionGranted(List<String> allGrantedPermission) {
                        File tempFile = CommonUtils.createTempFile();
                        CommonUtils.toSystemPhotoCapturer(getActivity() , 111 , tempFile);
                    }

                    @Override
                    public void onPermissionDenied(List<String> deniedPermissions) {
                        ((BaseActivity)getActivity()).showSettingDialog(getActivity());
                    }
                });
                break;
        }
    }
}
