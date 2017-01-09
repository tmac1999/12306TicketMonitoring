package com.mrz.autorefreshtickets;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CalendarView;
import android.widget.EditText;

import com.mrz.autorefreshtickets.presenters.RefreshSettingPresenter;
import com.mrz.autorefreshtickets.utils.SharedPUtil;
import com.mrz.autorefreshtickets.utils.TimeUtils;
import com.mrz.autorefreshtickets.utils.ToastUtils;
import com.mrz.autorefreshtickets.viewinferface.RefreshSettingView;

public class RefreshSettingActivity extends AppCompatActivity implements RefreshSettingView {
    // Content View Elements

    private EditText et_departure;
    private EditText et_arrival;
    private CalendarView calendar;
    private RefreshSettingPresenter refreshSettingPresenter;

    // End Of Content View Elements

    private void bindViews() {

        et_departure = (EditText) findViewById(R.id.et_departure);
        et_arrival = (EditText) findViewById(R.id.et_arrival);
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
        et_arrival.setText(SharedPUtil.getInstance().getArrival());
        et_departure.setText(SharedPUtil.getInstance().getDeparture());
    }

    public void save(View v) {
        String arrival = et_arrival.getText().toString();
        String departure = et_departure.getText().toString();
        String dateFromTimeStampMS = TimeUtils.getDateFromTimeStampMS(calendar.getDate());
        refreshSettingPresenter.saveRefreshSetting(arrival, departure, dateFromTimeStampMS);
        ToastUtils.showLongMessage("保存成功");
        finish();
    }
}
