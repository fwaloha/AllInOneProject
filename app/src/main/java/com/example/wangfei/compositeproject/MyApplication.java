package com.example.wangfei.compositeproject;

import android.app.ActivityManager;
import android.app.Application;
import android.content.Context;
import android.util.Log;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;
import com.example.wangfei.compositeproject.model.CrashHandler;
import com.xiaomi.channel.commonutils.logger.LoggerInterface;
import com.xiaomi.mipush.sdk.Logger;
import com.xiaomi.mipush.sdk.MiPushClient;

import java.io.IOException;
import java.util.List;

/**
 * Created by wangfei on 16/9/7.
 */

public class MyApplication extends Application {

    private static MyApplication mInstance;
    private static RequestQueue requestQueue;
    private static RequestQueue httpsRequestQueue;

    @Override
    public void onCreate() {
        super.onCreate();

        mInstance = this;
        try {
            httpsRequestQueue = Volley.createHttpsRequestQueue(this, null, getAssets().open("kyfw.bks"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        requestQueue = Volley.newRequestQueue(this);

        CrashHandler instance = CrashHandler.getInstance();
        instance.init(getApplicationContext());
        Thread.setDefaultUncaughtExceptionHandler(instance);

        openMipush();

    }
//    private boolean shouldInit() {
//        ActivityManager am = ((ActivityManager) getSystemService(Context.ACTIVITY_SERVICE));
//        List<ActivityManager.RunningAppProcessInfo> processInfos = am.getRunningAppProcesses();
//        String mainProcessName = getPackageName();
//        int myPid = Process.myPid();
//        for (ActivityManager.RunningAppProcessInfo info : processInfos) {
//            if (info.pid == myPid && mainProcessName.equals(info.processName)) {
//                return true;
//            }
//        }
//        return false;
//    }

    private void openMipush() {

        MiPushClient.registerPush(this, "2882303761517527770", "5981752776770");
        LoggerInterface newLogger = new LoggerInterface() {
            @Override
            public void setTag(String tag) {
                // ignore
            }
            @Override
            public void log(String content, Throwable t) {
                Log.d("mipush", content, t);
            }
            @Override
            public void log(String content) {
                Log.d("mipush", content);
            }
        };
        Logger.setLogger(this, newLogger);
    }

    public static MyApplication getInstance(){
        return mInstance;
    }

    public static RequestQueue getRequestQueue(){
        return requestQueue;
    }

}
