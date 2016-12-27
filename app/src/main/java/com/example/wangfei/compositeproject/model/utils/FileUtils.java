package com.example.wangfei.compositeproject.model.utils;

import android.content.Context;
import android.os.Environment;

import com.example.wangfei.compositeproject.MyApplication;

import java.io.File;

/**
 * Created by wangfei on 16/9/21.
 */

public class FileUtils {


    public static void makePath(String path) {
    }

    /**
     * 判断是否挂载sd卡
     *
     * @return
     */
    public static boolean isExternalStorMounted() {
        return Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED);
    }

    /**
     * 获取存储的路径
     *
     * @return
     */
    public static String getRootPath() {
        String mPath;
        if (isExternalStorMounted()) {
            mPath = Environment.getExternalStorageDirectory().getAbsolutePath() + File.separator + "Android/data/" + MyApplication.getInstance().getPackageName()+"/cache";
        } else {
            mPath = Environment.getDataDirectory().getAbsolutePath() + File.separator + "data/" + MyApplication.getInstance().getPackageName()+"cache";
        }
        return newPath(mPath);
    }

    public static String newPath(String path) {
        return correctPath(path);
    }

    private static String correctPath(String path) {
        File mFile = new File(path);
        String mPath = "";
        if (mFile.exists()) {
            mPath = mFile.getAbsolutePath();
        } else if (mFile.mkdirs()) {
            mPath = mFile.getAbsolutePath();
        } else {
            mPath = Environment.getExternalStorageDirectory().getAbsolutePath();
        }
        return mPath;
    }


}
