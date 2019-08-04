package com.example.nothing.testdemo.api;

import android.app.Activity;
import android.app.Application;

import java.util.Stack;

public class MyApplication extends Application {

    private static Stack<Activity> activityStack = new Stack<Activity>();

    @Override
    public void onCreate() {
        super.onCreate();

    }

    //添加Activity到容器中
    public static void addActivity(Activity activity) {
        activityStack.push(activity);
    }

    /**
     * 结束所有Activity
     */
    public static void finishAllActivity() {
        for (Activity activity : activityStack) {
            if (activity != null) {
                activity.finish();
            }
        }
        activityStack.clear();
    }


}
