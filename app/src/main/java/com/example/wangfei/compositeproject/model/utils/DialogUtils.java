package com.example.wangfei.compositeproject.model.utils;

import android.app.Activity;
import android.app.ProgressDialog;

/**
 * Created by wangfei on 16/11/25.
 */

public class DialogUtils {

    private static ProgressDialog progressDialog;

    public static void showDialog(Activity mActivity) {
        if (progressDialog == null) {
            progressDialog = new ProgressDialog(mActivity);
        }
        progressDialog.setMessage("loading");
        progressDialog.show();
    }

    public static void dismissDialog(Activity mActivity) {
        if(progressDialog!=null){
            progressDialog.dismiss();
        }
    }
}
