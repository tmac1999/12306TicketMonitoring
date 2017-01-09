package com.mrz.autorefreshtickets.presenters;

import android.content.Context;

import com.mrz.autorefreshtickets.utils.SharedPUtil;

/**
 * Created by zhengpeng on 2017/1/9.
 */
public class RefreshSettingPresenter {

    private final SharedPUtil sharedPUtil;

    public RefreshSettingPresenter(Context context) {
        sharedPUtil = SharedPUtil.getInstance();
    }

    public void saveRefreshSetting(String arr, String dep, String date) {
        sharedPUtil.setArrival(arr);
        sharedPUtil.setDeparture(dep);
        sharedPUtil.setDate(date);
    }
}
