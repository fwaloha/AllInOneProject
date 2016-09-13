package com.example.wangfei.compositeproject.model.utils;

import android.widget.Toast;

import com.example.wangfei.compositeproject.MyApplication;

/**
 * Created by wangfei on 16/9/8.
 */

public class ToastUtils {

    /* 单例toast */
    private static Toast toast = null;

    public static Toast getInstance() {
        if (toast == null) {
            synchronized (ToastUtils.class) {
                if (toast == null) {
                    toast = Toast.makeText(MyApplication.getInstance(), "", Toast.LENGTH_SHORT);
                }
            }
        }
        return toast;
    }

    public static void show(String str) {
        getInstance();
        toast.setText(str);
        toast.show();
    }
}
