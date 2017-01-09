package com.mrz.autorefreshtickets.utils;

import android.widget.Toast;

import com.mrz.autorefreshtickets.R12306Application;


/**
 * @author LXM
 * @date 2015-7-8
 * @detail :Toast工具类
 */
public class ToastUtils {


    /**
     * @param msg 支持连续消息展示  singleton toast
     */
    public static void showMessage(String msg) {
        Toast.makeText(R12306Application.getInstance(), msg, Toast.LENGTH_SHORT).show();
    }

    /**
     * 长时间弹出框
     *
     * @param msg
     */
    public static void showLongMessage(String msg) {
        Toast.makeText(R12306Application.getInstance(), msg, Toast.LENGTH_LONG).show();
    }


}