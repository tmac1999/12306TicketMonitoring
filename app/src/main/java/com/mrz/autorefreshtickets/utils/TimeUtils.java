package com.mrz.autorefreshtickets.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by zhengpeng on 2017/1/9.
 */
public class TimeUtils {
    /**
     * 将时间戳转为字符串
     *
     * @param millisecond 时间戳 （毫秒）
     * @return yyyy-MM-dd
     */
    public static String getDateFromTimeStampMS(long millisecond) {
        String re_StrTime = null;

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        re_StrTime = sdf.format(new Date(millisecond));
        System.out.println(" re_StrTime " + re_StrTime);

        return re_StrTime;

    }
}
