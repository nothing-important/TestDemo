package com.example.nothing.testdemo.utils;

import android.content.Context;
import android.widget.Toast;

public class ToastU {

    public static void showShort(Context context , String toastContent){
        Toast.makeText(context , toastContent , Toast.LENGTH_SHORT).show();
    }

}
