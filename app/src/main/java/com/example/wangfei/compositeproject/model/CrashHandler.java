package com.example.wangfei.compositeproject.model;

import android.content.Context;

import com.example.wangfei.compositeproject.model.utils.ToastUtils;

/**
 * Created by wangfei on 16/10/17.
 */

public class CrashHandler implements Thread.UncaughtExceptionHandler {

    private Context context;
    private static CrashHandler crashHandler;

    private CrashHandler() {
    }

    public void init(Context context){
        this.context = context;
    }

    public static synchronized CrashHandler getInstance(){
        if(crashHandler == null){
            crashHandler = new CrashHandler();
        }
        return crashHandler;
    }
    @Override
    public void uncaughtException(Thread thread, Throwable ex) {
        ToastUtils.show("crash");
        android.os.Process.killProcess(android.os.Process.myPid());
    }
}
