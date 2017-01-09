package com.mrz.autorefreshtickets.utils;

import android.content.Context;
import android.content.SharedPreferences;

import com.mrz.autorefreshtickets.R12306Application;

/**
 * Created by zhengpeng on 2017/1/9.
 */
public class SharedPUtil {
    private SharedPreferences sp;
    private Context context;
    private volatile static SharedPUtil spu;
    private String SP_UserAccount = "UserAccount";
    private String SP_help = "help";
    private String SP_USERINFO = "USERINFO";
    private String SP_RefreshSetting = "SP_RefreshSetting";


    public SharedPUtil(Context context) {
        this.context = context;
    }

    public static SharedPUtil getInstance() {
        if (spu == null) {
            synchronized (SharedPUtil.class) {
                if (spu == null) {
                    spu = new SharedPUtil(R12306Application.getInstance());
                }
            }
        }
        return spu;
    }

    public String getDeparture() {
        sp = context.getSharedPreferences(SP_RefreshSetting, Context.MODE_PRIVATE);
        return sp.getString("departure", "");
    }

    public void setDeparture(String value) {
        sp = context.getSharedPreferences(SP_RefreshSetting, Context.MODE_PRIVATE);
        sp.edit().putString("departure", value).apply();
    }

    public String getArrival() {
        sp = context.getSharedPreferences(SP_RefreshSetting, Context.MODE_PRIVATE);
        return sp.getString("Arrival", "");
    }

    public void setArrival(String value) {
        sp = context.getSharedPreferences(SP_RefreshSetting, Context.MODE_PRIVATE);
        sp.edit().putString("Arrival", value).apply();
    }

    public String getDate() {
        sp = context.getSharedPreferences(SP_RefreshSetting, Context.MODE_PRIVATE);
        return sp.getString("Date", "");
    }

    public void setDate(String value) {
        sp = context.getSharedPreferences(SP_RefreshSetting, Context.MODE_PRIVATE);
        sp.edit().putString("Date", value).apply();
    }
}
