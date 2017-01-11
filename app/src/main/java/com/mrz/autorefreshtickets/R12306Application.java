package com.mrz.autorefreshtickets;

import android.app.Application;
import android.content.Context;
import android.support.multidex.MultiDex;

import com.mrz.autorefreshtickets.utils.FetchPatchHandler;
import com.tencent.tinker.loader.app.ApplicationLike;
import com.tinkerpatch.sdk.TinkerPatch;
import com.tinkerpatch.sdk.loader.TinkerPatchApplicationLike;

/**
 * Created by zhengpeng on 2017/1/9.
 */
public class R12306Application extends Application {
    private static Application application;
    private ApplicationLike tinkerApplicationLike;

    public R12306Application() {

    }

    @Override
    public void onCreate() {
        super.onCreate();
        application = this;
        tinkerApplicationLike = TinkerPatchApplicationLike.getTinkerPatchApplicationLike();

        //开始检查是否有补丁，这里配置的是每隔访问3小时服务器是否有更新。
        TinkerPatch.init(tinkerApplicationLike)
                .reflectPatchLibrary()
                .setPatchRollbackOnScreenOff(true)
                .setPatchRestartOnSrceenOff(true);

        //每隔3个小时去访问后台时候有更新,通过handler实现轮训的效果
        new FetchPatchHandler().fetchPatchWithInterval(3);
    }

    public static Application getInstance() {
        return application;
    }

    @Override
    public void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        //you must install multiDex whatever tinker is installed!
        MultiDex.install(base);
    }
}
