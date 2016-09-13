package com.example.wangfei.compositeproject.model.utils;

import android.graphics.Bitmap;
import android.util.LruCache;
import android.widget.ImageView;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.ImageRequest;
import com.android.volley.toolbox.NetworkImageView;
import com.example.wangfei.compositeproject.MyApplication;
import com.example.wangfei.compositeproject.R;

/**
 * Created by wangfei on 16/9/12.
 */

public class ImageLoaderUtil {
    /*
     * 通过ImageRequest来显示网络图片
     * */
    public static void setImageRequest(String url, final ImageView imageView) {
        ImageRequest imageRequest = new ImageRequest(url, new Response.Listener<Bitmap>() {
            @Override
            public void onResponse(Bitmap bitmap) {
//            imageView.setImageBitmap(bitmap);

            }
        }, 0, 0, Bitmap.Config.RGB_565, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {
                imageView.setBackgroundResource(R.mipmap.loading);
            }
        });
        MyApplication.getRequestQueue().add(imageRequest);
    }

    /*
     * 通过ImageLoader来显示网络图片
     * */
    public static void setImageLoader(String url, ImageView imageView, int defaultImageResId, int errorImageResId) {
        ImageLoader loader = new ImageLoader(MyApplication.getRequestQueue(), new BitmapCatch());
        ImageLoader.ImageListener imageListener = ImageLoader.getImageListener(imageView, defaultImageResId, errorImageResId);
        loader.get(url, imageListener);
    }

    /*
     * 通过Volley的NetWorkImageView来显示网络图片
     * */
    public static void setNetWorkImageView(String url, NetworkImageView networkImageView, int defaultImageResId, int errorImageResId) {
//        new ImageLoader(MyApplication.getRequestQueue(),)
        ImageLoader imageLoader = new ImageLoader(MyApplication.getRequestQueue(), new BitmapCatch());
        networkImageView.setDefaultImageResId(defaultImageResId);
        networkImageView.setErrorImageResId(errorImageResId);
        networkImageView.setImageUrl(url, imageLoader);
    }

    public static class BitmapCatch implements ImageLoader.ImageCache {

        private int max = 10 * 1024 * 1024;
        private final LruCache<String, Bitmap> lruCache;

        public BitmapCatch() {
            lruCache = new LruCache<String, Bitmap>(max) {
                @Override
                protected int sizeOf(String key, Bitmap value) {
                    return value.getRowBytes() * value.getHeight();
                }
            };
        }

        @Override
        public Bitmap getBitmap(String url) {
            return null;
        }

        @Override
        public void putBitmap(String url, Bitmap bitmap) {

        }
    }
}
