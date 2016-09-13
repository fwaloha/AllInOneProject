package com.example.wangfei.compositeproject;

import android.app.Application;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

import java.io.IOException;

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
    }

    public static MyApplication getInstance(){
        return mInstance;
    }

    public static RequestQueue getRequestQueue(){
        return requestQueue;
    }

}
