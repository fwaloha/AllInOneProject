package com.example.wangfei.compositeproject.model;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.view.View;

import com.example.wangfei.compositeproject.R;


/**
 * Created by wangfei on 16/9/9.
 */

public abstract class BaseDialog {

    private final Dialog mDialog;
    private final View view;

    public BaseDialog(Context context) {
        view = setDialogView(context);
        mDialog = getDefaultDialog(context, view);
    }

    //子类重写该方法,赋予dialog特有样式
    public abstract View setDialogView(Context context);

    public Dialog getDefaultDialog(Context context, View view) {
        ProgressDialog progressDialog = new ProgressDialog(context, R.style.default_dialog);
        progressDialog.setCancelable(true);
//        progressDialog.setContentView(view);
        return progressDialog;
    }

    public void show() {
        if (mDialog != null) {
            mDialog.show();
        }
        mDialog.setContentView(view);
    }

    public void dismiss() {
        if (mDialog != null) {
            mDialog.dismiss();
        }
    }
}
