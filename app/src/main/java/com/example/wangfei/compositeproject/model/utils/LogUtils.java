package com.example.wangfei.compositeproject.model.utils;


import android.util.Log;

import com.example.wangfei.compositeproject.BuildConfig;
import com.example.wangfei.compositeproject.MyApplication;
import com.example.wangfei.compositeproject.R;

/**
 * Created by wangfei on 16/9/9.
 */

public class LogUtils {
    private LogUtils() {
    }

    public static final boolean DEBUG = BuildConfig.DEBUG;
    public static String TAG = MyApplication.getInstance().getString(R.string.config_logcat_tag);

    public static void d(String msg) {
        d(TAG, msg);
    }

    public static void d(String tag, String msg) {
        if (DEBUG) {
            Log.d(tag, msg);
        }
    }

    public static void e(String msg) {
        e(TAG, msg);
    }

    public static void e(String tag, String msg) {
        if (DEBUG) {
            Log.e(tag, msg);
        }
    }

    public static void v(String msg) {
        v(TAG, msg);
    }

    public static void v(String tag, String msg) {
        if (DEBUG) {
            Log.v(tag, msg);
        }
    }

    public static void exception(String msg) {
        e(msg);
    }
}
