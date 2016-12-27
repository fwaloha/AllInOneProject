package com.example.wangfei.compositeproject.control;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.android.volley.VolleyError;
import com.example.wangfei.compositeproject.R;
import com.example.wangfei.compositeproject.model.NoPreloadViewPager;
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
    private NoPreloadViewPager viewpager;
    private RadioGroup mRadiogroup;
    private int viewState;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        LogUtils.d("activity-----", "call onCreate");

        setContentView(R.layout.activity_main);
        View decorView = getWindow().getDecorView();
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
//            viewState = View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
//                    | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
//                    | View.SYSTEM_UI_FLAG_LAYOUT_STABLE;
//            decorView.setSystemUiVisibility(viewState);
//            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
//                getWindow().setNavigationBarColor(Color.TRANSPARENT);
//                getWindow().setStatusBarColor(Color.TRANSPARENT);
//            }
//        }
//        ActionBar supportActionBar = getSupportActionBar();
//        supportActionBar.hide();

        mContex = MainActivity.this;
        initViews();
        initData();

        mRadiogroup = (RadioGroup) findViewById(R.id.rgroup);
//        mRadiogroup.setOnClickListener(this);


//        FragmentManager fragmentManager = getFragmentManager();
//        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
//        SpringFragment springFragment = new SpringFragment();
////        fragmentTransaction.replace(R.id.frame, springFragment);
//        fragmentTransaction.commit();

        viewpager = (NoPreloadViewPager) findViewById(R.id.viewpager);
        viewpager.setOffscreenPageLimit(0);
        ArrayList<Fragment> fragments = new ArrayList<>();
        fragments.add(new SpringFragment());
        fragments.add(new SummerFragment());
        fragments.add(new AutumnFragment());
        fragments.add(new WinterFragment());

        fragments.get(0).setUserVisibleHint(false);

        MyVpAdapter myVpAdapter = new MyVpAdapter(getSupportFragmentManager(), fragments);
        viewpager.setOffscreenPageLimit(0);
        viewpager.setAdapter(myVpAdapter);
        mRadiogroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.rb1:
                        viewpager.setCurrentItem(0, true);
                        break;
                    case R.id.rb2:
                        viewpager.setCurrentItem(1, true);
                        break;
                    case R.id.rb3:
                        viewpager.setCurrentItem(2, true);
                        break;
                    case R.id.rb4:
                        viewpager.setCurrentItem(3, true);
                        break;
                }
            }
        });

//        viewpager.OnPageChangeListener(){
//            @Override
//            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
//
//            }
//
//            @Override
//            public void onPageSelected(int position) {
//
//            }
//
//            @Override
//            public void onPageScrollStateChanged(int state) {
//
//            }
//        });

        viewpager.setOnPageChangeListener(new NoPreloadViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                RadioButton mButton = (RadioButton) mRadiogroup.getChildAt(position);
                LogUtils.d("-----",position+":"+positionOffset+":"+positionOffsetPixels);
            }

            @Override
            public void onPageSelected(int position) {
                RadioButton mRadioButton = (RadioButton) mRadiogroup.getChildAt(position);
                mRadioButton.setChecked(true);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
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
                new String("kk");
            }

            @Override
            public void onFailed(VolleyError error) {
                ToastUtils.show("网络连接不上failed!");
//                dialog.dismiss();
            }

        });
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


    @Override
    protected void onStart() {
        super.onStart();
        LogUtils.d("activity-----", "call onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        LogUtils.d("activity-----", "call onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        LogUtils.d("activity-----", "call onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        LogUtils.d("activity-----", "call onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        LogUtils.d("activity-----", "call onDestroy");
    }
}
