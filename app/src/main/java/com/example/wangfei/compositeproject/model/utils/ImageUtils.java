package com.example.wangfei.compositeproject.model.utils;

import android.content.Context;
import android.net.Uri;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.wangfei.compositeproject.model.BaseFragment;

/**
 * Created by wangfei on 16/11/7.
 */

public class ImageUtils {
    public static void loadBitmap(Context context, String url, ImageView imageview){
        Glide.with(context).load(url).into(imageview);
    }
    public static void loadBitmap(BaseFragment fragment, Uri url, ImageView imageview){
        Glide.with(fragment).load(url).into(imageview);
    }
    public static void loadBitmap(BaseFragment fragment, String url,ImageView imageView,int errorImage,int loadingImage){
        Glide.with(fragment).load(url).error(errorImage).placeholder(loadingImage).into(imageView);
    }
}
