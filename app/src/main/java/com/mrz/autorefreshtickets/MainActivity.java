package com.mrz.autorefreshtickets;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.mrz.autorefreshtickets.viewinferface.MainView;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.https.HttpsUtils;

import okhttp3.OkHttpClient;

public class MainActivity extends AppCompatActivity implements MainView {
    String url = "https://kyfw.12306.cn/otn/leftTicket/queryA?leftTicketDTO.train_date=2017-01-23&leftTicketDTO.from_station=BJP&leftTicketDTO.to_station=WHN&purpose_codes=ADULT";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        HttpsUtils.SSLParams sslParams = HttpsUtils.getSslSocketFactory(null, null, null);
        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .sslSocketFactory(sslParams.sSLSocketFactory, sslParams.trustManager)
                //其他配置
                .build();
        OkHttpUtils.initClient(okHttpClient);

    }

    public void setting(View v) {
        startActivity(new Intent(MainActivity.this, RefreshSettingActivity.class));
//        Log.d("dddd", "ddddddddddddddd");
//        OkHttpUtils.get().url(url).build().execute(new Callback() {
//            @Override
//            public Object parseNetworkResponse(Response response, int id) throws Exception {
//                Log.d("dddd", "dddddddddddddddparseNetworkResponse");
//                String string = response.body().string();
//                // Toast.makeText(MainActivity.this, string, Toast.LENGTH_SHORT).show();
//                Log.d("dddd", string);
//                return null;
//            }
//
//            @Override
//            public void onError(Call call, Exception e, int id) {
//                Log.d("dddd", "onError");
//                e.printStackTrace();
//            }
//
//            @Override
//            public void onResponse(Object response, int id) {
//                Log.d("dddd", "ddddddddddddddd11111parseNetworkResponse");
//                Toast.makeText(MainActivity.this, "ddddddd", Toast.LENGTH_SHORT).show();
//            }
//        });
    }
}
