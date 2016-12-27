package com.example.wangfei.compositeproject.model.utils;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.support.v4.graphics.drawable.RoundedBitmapDrawable;
import android.support.v4.graphics.drawable.RoundedBitmapDrawableFactory;

/**
 * Created by wangfei on 16/11/8.
 */

public class RoundImageview {
    public RoundImageview() {
    }

    public static RoundedBitmapDrawable getCircle(Resources resource, Bitmap bitmap){
        RoundedBitmapDrawable roundedBitmapDrawable = RoundedBitmapDrawableFactory.create(resource, bitmap);
        roundedBitmapDrawable.setCircular(true);
        return roundedBitmapDrawable;
    }
}
