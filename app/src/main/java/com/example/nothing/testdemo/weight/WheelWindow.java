package com.example.nothing.testdemo.weight;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.example.nothing.testdemo.R;
import com.example.nothing.testdemo.api.ConstantsAPI;
import com.zyyoona7.wheel.WheelView;

import java.util.ArrayList;

public class WheelWindow implements View.OnClickListener {
    private static final String TAG = "WheelWindow";
    private Context context;
    private WheelView wheelView;
    private View contentView;
    private OnSelectSureListener listener;
    private int position , windowWidth , windowHeight;
    private Dialog dialog;
    private String item;

    public WheelWindow(Context context , int windowWidth , int windowHeight) {
        this.context = context;
        this.windowWidth = windowWidth;
        this .windowHeight = windowHeight;
        init();
    }

    private void init() {
        dialog = new Dialog(context, R.style.WheelPopupwindowAnim);
        contentView = LayoutInflater.from(context).inflate(R.layout.wheelwindow_layout, null, false);
        dialog.setContentView(contentView);
        Window window = dialog.getWindow();
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.width=WindowManager.LayoutParams.MATCH_PARENT;
        attributes.height = windowHeight/3;
        attributes.gravity=Gravity.BOTTOM;
        window.setAttributes(attributes);
        TextView sure = contentView.findViewById(R.id.wheelwindow_sure);
        TextView cancel = contentView.findViewById(R.id.wheelwindow_cancel);
        wheelView = contentView.findViewById(R.id.wheelview);
        sure.setOnClickListener(this);
        cancel.setOnClickListener(this);
        ArrayList<String> monthsLaterData = ConstantsAPI.get12MonthsLaterData();
        wheelView.setData(monthsLaterData);
        wheelView.setOnItemSelectedListener(new WheelView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(WheelView wheelView, Object data, int position) {
                WheelWindow.this.position = position;
                WheelWindow.this.item = data + "";
            }
        });
    }

    public void show() {
        dialog.show();
    }

    public void dismiss() {
        dialog.dismiss();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.wheelwindow_sure:
                if (listener != null)
                    listener.onSelectSure(position, item);
                break;
            case R.id.wheelwindow_cancel:
                dismiss();
                break;
            default:
                break;
        }
    }

    public interface OnSelectSureListener {
        void onSelectSure(int position, String item);
    }

    public void setOnSelectSureListener(OnSelectSureListener listener) {
        this.listener = listener;
    }
}
