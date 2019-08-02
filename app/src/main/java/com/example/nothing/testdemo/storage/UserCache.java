package com.example.nothing.testdemo.storage;

import android.content.Context;
import android.content.SharedPreferences;

import com.example.nothing.testdemo.api.ConstantsAPI;

/**
 * Created by tkc on 2017/12/12.
 */

public class UserCache extends BasicStorage {

    private static UserCache userCache;

    public boolean userIsLogin;
    public String userAccount;
    public String userPassword;
    public boolean userIsFirstLogin;
    public boolean isVibrateOpen;
    public boolean isNoticeOpen;
    public boolean userIsFirstOpen;

    /**
     * @param ctx
     */
    private UserCache(Context ctx) {
        super(ctx);
    }

    public static UserCache getUserCache(Context context) {
        if (userCache == null){
            userCache = new UserCache(context);
        }
        userCache.load();
        return userCache;
    }

    @Override
    public void ser(SharedPreferences sp) {
        sp.edit().putString("userAccount" , userAccount)
                .putString("userPassword" , userPassword)
                .putBoolean("userIsLogin" , userIsLogin)
                .putBoolean("userIsFirstLogin" , userIsFirstLogin)
                .putBoolean("isVibrateOpen" , isVibrateOpen)
                .putBoolean("isNoticeOpen" , isNoticeOpen)
                .putBoolean("userIsFirstOpen" , userIsFirstOpen)
                .commit();
    }

    @Override
    public void unSer(SharedPreferences sp) {
        userIsLogin = sp.getBoolean("userIsLogin" , false);
        userIsFirstLogin = sp.getBoolean("userIsFirstLogin" , true);
        userAccount = sp.getString("userAccount" , ConstantsAPI.Login.ACCOUNT);
        userPassword = sp.getString("userPassword" , ConstantsAPI.Login.PASSWORD);
        isNoticeOpen = sp.getBoolean("isNoticeOpen" , true);
        isVibrateOpen = sp.getBoolean("isVibrateOpen" , true);
        userIsFirstOpen = sp.getBoolean("userIsFirstOpen" , true);
    }

    @Override
    public void del(SharedPreferences sp) {
        sp.edit().remove("userIsLogin")
                .remove("userIsFirstLogin")
                .remove("userAccount")
                .remove("userPassword")
                .remove("userIsFirstOpen")
                .remove("isNoticeOpen")
                .remove("isVibrateOpen")
                .commit();
    }


    @Override
    public String getIdentifer() {
        return UserCache.class.getName();
    }
}
