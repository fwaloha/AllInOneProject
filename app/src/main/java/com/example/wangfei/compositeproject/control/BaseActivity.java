package com.example.wangfei.compositeproject.control;

import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;

import com.example.wangfei.compositeproject.R;
import com.example.wangfei.compositeproject.model.utils.ToastUtils;

public class BaseActivity extends AppCompatActivity {

    private long lastTime = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base);
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (event.getAction() == KeyEvent.ACTION_DOWN) {
            long currTime = System.currentTimeMillis();
            if (currTime - lastTime > 1500) {
                ToastUtils.show("再按一次退出!");
                lastTime = currTime;
                return true;
            }
        }
        return super.onKeyDown(keyCode, event);
    }
}
