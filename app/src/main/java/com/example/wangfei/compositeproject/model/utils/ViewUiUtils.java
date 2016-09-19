package com.example.wangfei.compositeproject.model.utils;

import android.view.View;

/**
 * Created by wangfei on 16/9/19.
 */

public class ViewUiUtils {

    /**
     * 伸缩功能,一般是点击一个条目,展示或隐藏下一个条目
     *
     * @param title 点击的条目
     * @param info  点击条目下面的条目
     */
    public static void expend(final View title, final View info) {
        if (title.isEnabled()) {
            title.setEnabled(false);
            info.setVisibility(View.VISIBLE);
        } else {
            title.setEnabled(true);
            info.setVisibility(View.GONE);
        }
    }
}
