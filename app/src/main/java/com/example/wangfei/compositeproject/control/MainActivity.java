package com.example.wangfei.compositeproject.control;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.android.volley.VolleyError;
import com.android.volley.toolbox.NetworkImageView;
import com.example.wangfei.compositeproject.MyApplication;
import com.example.wangfei.compositeproject.R;
import com.example.wangfei.compositeproject.model.network.RequestQun;
import com.example.wangfei.compositeproject.model.utils.ImageLoaderUtil;
import com.example.wangfei.compositeproject.model.utils.LogUtils;
import com.example.wangfei.compositeproject.model.utils.ToastUtils;

import java.security.MessageDigest;
import java.util.HashMap;
import java.util.Map;

public class MainActivity extends BaseActivity {

    TextView mTvCountry, mTvIP;
    private Button mTvCountryId;
    private int millis;
    private Context mContex;
    private ViewPager parentVp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mContex = MainActivity.this;
        initViews();
        initData();
    }

    private void initViews() {

        parentVp = (ViewPager) findViewById(R.id.pvp);
        View view1 = View.inflate(mContex, R.layout.vp1_layout, null);
        View view2 = View.inflate(mContex, R.layout.vp2_layout, null);

        parentVp.addView(view1);
        parentVp.addView(view2);
    }

    private void initData() {
//        String url = "http://www.daokoudai.com/api/2.0/a_xiaoyoujinfu/getTeacherList?appKey=66666666&imei=865291025924316&from=AC&params=%7B%22token%22%3A%22e58b5e5be2de449a9fc419e0146975d7%22%2C%22page%22%3A1%2C%22size%22%3A10%2C%22sortThreshold%22%3A0%7D&version=1.2.3&apiName=empty";
        String url = "http://ip.taobao.com/service/getIpInfo.php";
//        String url = "https://kyfw.12306.cn/otn/";
        Map<String, String> params = new HashMap<>();
//        params.put("ip", "21.22.11.33");
        RequestQun.addRequet(MainActivity.this, com.android.volley.Request.Method.GET, url, null, null, new RequestQun.NetWorkRequestListener() {

            private ProgressDialog dialog;

            @Override
            public void onPreRequest() {
                ToastUtils.show("开始了");
//                dialog = new ProgressDialog(MainActivity.this);
//                dialog.show();
            }

            @Override
            public void onResponse(String response) {
                ToastUtils.show("success!" + response);
                LogUtils.d("----success", response);
//                dialog.dismiss();
            }

            @Override
            public void onFailed(VolleyError error) {
                ToastUtils.show("网络连接不上failed!");
//                dialog.dismiss();
            }

        });
    }

    @Override
    protected void onStop() {
        super.onStop();
    }
}
