package com.example.wangfei.compositeproject.control;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

import com.example.wangfei.compositeproject.R;
import com.example.wangfei.compositeproject.model.utils.ToastUtils;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ToolbarActivity extends AppCompatActivity {

    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.button2)
    Button button2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_toolbar);
        ButterKnife.bind(this);

        initData();
    }

    private void initData() {
        toolbar.setTitle("主Title");
        toolbar.setSubtitle("subTitle");
        toolbar.setLogo(R.mipmap.logo);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
//        toolbar.setNavigationIcon(R.mipmap.ic_arrow_down);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ToastUtils.show("back ....");
            }
        });
    }

    @OnClick(R.id.button2)
    public void onClick() {
        Intent intent = new Intent();
        intent.setAction("com.example.wangfei.compositeproject.model.broadcastreceiver.TestBroadcastReceiver");
        intent.putExtra("apple","13");
        this.sendBroadcast(intent);
        ToastUtils.show("fasongle");
    }
}
