package com.example.nothing.testdemo.activity;

import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.nothing.testdemo.R;
import com.example.nothing.testdemo.base.BaseActivity;
import com.example.nothing.testdemo.storage.UserCache;
import com.example.nothing.testdemo.utils.ToastU;

import butterknife.BindView;

public class ChangePwdActivity extends BaseActivity implements View.OnClickListener {

    @BindView(R.id.title_back)
    ImageView titleBack;
    @BindView(R.id.title_name)
    TextView titleName;
    @BindView(R.id.change_account)
    EditText changeAccount;
    @BindView(R.id.change_sms)
    EditText changeSMS;
    @BindView(R.id.change_password)
    EditText changePassword;
    @BindView(R.id.change_next)
    TextView changeNext;
    private UserCache userCache;

    @Override
    protected int setLayoutId() {
        return R.layout.activity_change_pwd;
    }

    @Override
    protected void initView() {
        titleBack.setVisibility(View.VISIBLE);
        titleName.setVisibility(View.VISIBLE);
        titleName.setText("修改密码");
    }

    @Override
    protected void initData() {
        userCache = UserCache.getUserCache(this);
    }

    @Override
    protected void setListener() {
        titleBack.setOnClickListener(this);
        changeNext.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.title_back:
                finish();
                break;
            case R.id.change_next:
                String account = changeAccount.getText().toString().trim();
                String sms = changeSMS.getText().toString().trim();
                String password = changePassword.getText().toString().trim();
                if (account == null || account.length() != 11){
                    ToastU.showShort(this , "请输入手机号");
                    return;
                }
                if (sms == null || sms.length() != 4){
                    ToastU.showShort(this , "请输入验证码");
                    return;
                }
                if (password == null || password.length() <= 0){
                    ToastU.showShort(this , "请输入密码");
                    return;
                }
                userCache.userAccount = account;
                userCache.userPassword = password;
                userCache.save();
                ToastU.showShort(this , "密码修改成功");
                finish();
                break;
        }
    }
}
