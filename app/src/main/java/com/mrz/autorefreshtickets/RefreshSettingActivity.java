package com.mrz.autorefreshtickets;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.CalendarView;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.mrz.autorefreshtickets.presenters.RefreshSettingPresenter;
import com.mrz.autorefreshtickets.utils.Constants;
import com.mrz.autorefreshtickets.utils.SharedPUtil;
import com.mrz.autorefreshtickets.utils.TimeUtils;
import com.mrz.autorefreshtickets.utils.ToastUtils;
import com.mrz.autorefreshtickets.viewinferface.RefreshSettingView;

import java.util.ArrayList;
import java.util.Set;

public class RefreshSettingActivity extends AppCompatActivity implements RefreshSettingView {
    // Content View Elements

    private AutoCompleteTextView et_departure;
    private AutoCompleteTextView et_arrival;
    private CalendarView calendar;
    private RefreshSettingPresenter refreshSettingPresenter;
    private JSONObject jsonObject;

    // End Of Content View Elements

    private void bindViews() {

        et_departure = (AutoCompleteTextView) findViewById(R.id.aTv_departure);
        et_arrival = (AutoCompleteTextView) findViewById(R.id.aTv_arrival);
        calendar = (CalendarView) findViewById(R.id.calendar);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_refesh_setting);
        bindViews();
        refreshSettingPresenter = new RefreshSettingPresenter(this);
        initData();
    }

    private void initData() {
        ArrayList<String> stations = new ArrayList<>();
        et_arrival.setText(SharedPUtil.getInstance().getArrival());
        et_departure.setText(SharedPUtil.getInstance().getDeparture());
        jsonObject = (JSONObject) JSON.parse(Constants.stations);
        Set<String> keys = jsonObject.keySet();
        for (String key : keys) {
            stations.add(key);
        }
        ArrayAdapter arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, stations);


        et_departure.setAdapter(arrayAdapter);
        et_arrival.setAdapter(arrayAdapter);
    }

    public void save(View v) {
        String arrival = et_arrival.getText().toString();
        String departure = et_departure.getText().toString();
        String arrivalShort = null;
        String departureShort = null;
        arrivalShort = (String) jsonObject.get(arrival);
        departureShort = (String) jsonObject.get(departure);
        String dateFromTimeStampMS = TimeUtils.getDateFromTimeStampMS(calendar.getDate());
        refreshSettingPresenter.saveRefreshSetting(arrivalShort, departureShort, dateFromTimeStampMS);
        ToastUtils.showLongMessage("保存成功");
        finish();
    }
}
