package com.example.wangfei.compositeproject.control;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.View;

import com.android.volley.VolleyError;
import com.example.wangfei.compositeproject.R;
import com.example.wangfei.compositeproject.model.adapter.MyVpAdapter;
import com.example.wangfei.compositeproject.model.network.RequestQun;
import com.example.wangfei.compositeproject.model.utils.LogUtils;
import com.example.wangfei.compositeproject.model.utils.ToastUtils;
import com.example.wangfei.compositeproject.view.AutumnFragment;
import com.example.wangfei.compositeproject.view.SpringFragment;
import com.example.wangfei.compositeproject.view.SummerFragment;
import com.example.wangfei.compositeproject.view.WinterFragment;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MainActivity extends BaseActivity implements View.OnClickListener {

    private Context mContex;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mContex = MainActivity.this;
        initViews();
        initData();

        findViewById(R.id.rgroup).setOnClickListener(this);

//        FragmentManager fragmentManager = getFragmentManager();
//        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
//        SpringFragment springFragment = new SpringFragment();
////        fragmentTransaction.replace(R.id.frame, springFragment);
//        fragmentTransaction.commit();

        ViewPager viewpager = (ViewPager) findViewById(R.id.viewpager);
        ArrayList<Fragment> fragments = new ArrayList<>();
        fragments.add(new SpringFragment());
        fragments.add(new SummerFragment());
        fragments.add(new AutumnFragment());
        fragments.add(new WinterFragment());

        MyVpAdapter myVpAdapter = new MyVpAdapter(getSupportFragmentManager(), fragments);
        viewpager.setAdapter(myVpAdapter);
    }

    private void initViews() {

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

    @Override
    public void onClick(View v) {
//        FragmentManager fragmentManager = this.getFragmentManager();
//        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        switch (v.getId()) {
            case R.id.rb1:
//                fragmentTransaction.replace(R.id.frame, new SpringFragment());
                break;
            case R.id.rb2:
//                fragmentTransaction.replace(R.id.frame, new SummerFragment());

                break;
            case R.id.rb3:
//                fragmentTransaction.replace(R.id.frame, new AutumnFragment());

                break;
            case R.id.rb4:
//                fragmentTransaction.replace(R.id.frame, new WinterFragment());

                break;
        }

//        fragmentTransaction.commit();
    }
}
