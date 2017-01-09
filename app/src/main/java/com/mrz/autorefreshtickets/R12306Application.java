package com.mrz.autorefreshtickets;

import android.app.Application;

/**
 * Created by zhengpeng on 2017/1/9.
 */
public class R12306Application extends Application {
    private static Application application;

    @Override
    public void onCreate() {
        super.onCreate();
        application = this;
    }

    public static Application getInstance() {
        return application;
    }
}
