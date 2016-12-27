package com.example.wangfei.compositeproject.model.broadcastreceiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import com.example.wangfei.compositeproject.model.utils.ToastUtils;

/**
 * Created by wangfei on 16/10/13.
 */

public class TestBroadcastReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        ToastUtils.show("hahaha");
        String body = intent.getStringExtra("apple");
        ToastUtils.show("hahah,get it apple:  "+ body);
    }
}
