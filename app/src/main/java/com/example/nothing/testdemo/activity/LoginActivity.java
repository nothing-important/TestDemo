package com.example.nothing.testdemo.activity;

import android.content.Intent;
import android.os.Bundle;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.nothing.testdemo.MainActivity;
import com.example.nothing.testdemo.R;
import com.example.nothing.testdemo.api.ConstantsAPI;
import com.example.nothing.testdemo.base.BaseActivity;
import com.example.nothing.testdemo.storage.UserCache;
import com.example.nothing.testdemo.utils.ToastU;

import butterknife.BindView;

public class LoginActivity extends BaseActivity implements View.OnClickListener {

    @BindView(R.id.login_account)
    EditText loginAccount;
    @BindView(R.id.login_password)
    EditText loginPassword;
    @BindView(R.id.login_jump)
    TextView loginJump;
    @BindView(R.id.login_hide)
    ImageView loginHide;
    @BindView(R.id.login_login)
    TextView loginLogin;
    @BindView(R.id.login_forget)
    TextView loginForget;
    private boolean isHide = true;
    private UserCache userCache;

    @Override
    protected int setLayoutId() {
        return R.layout.activity_login;
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void initData() {
        userCache = UserCache.getUserCache(this);
    }

    @Override
    protected void setListener() {
        loginLogin.setOnClickListener(this);
        loginJump.setOnClickListener(this);
        loginHide.setOnClickListener(this);
        loginForget.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.login_login:
                String account = loginAccount.getText().toString().trim();
                String password = loginPassword.getText().toString().trim();
                if (account == null || account.length() != 11){
                    ToastU.showShort(LoginActivity.this , "请输入" +
                            "手机号");
                    return;
                }
                if (password == null || password.length() <= 0){
                    ToastU.showShort(LoginActivity.this , "请输入密码");
                    return;
                }
                if (account.equals(userCache.userAccount) && password.equals(userCache.userPassword)){
                    userCache.userAccount = account;
                    userCache.userPassword = password;
                    userCache.userIsLogin = true;
                    userCache.save();
                    toMainActivity();
                }else {
                    ToastU.showShort(LoginActivity.this , "账号或密码错误");
                }
                break;
            case R.id.login_hide:
                if (isHide){
                    loginPassword.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                }else {
                    loginPassword.setTransformationMethod(PasswordTransformationMethod.getInstance());
                }
                isHide = !isHide;
                break;
            case R.id.login_jump:
                toMainActivity();
                break;
            case R.id.login_forget:

                break;
        }
    }

    private void toMainActivity(){
        Intent intent = new Intent(this , MainActivity.class);
        startActivity(intent);
        finish();
    }

}
