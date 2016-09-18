package com.example.wangfei.compositeproject.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.android.volley.toolbox.NetworkImageView;
import com.example.wangfei.compositeproject.R;
import com.example.wangfei.compositeproject.model.BaseFragment;
import com.example.wangfei.compositeproject.model.utils.ImageLoaderUtil;

import java.util.ArrayList;

/**
 * Created by wangfei on 16/9/14.
 */

public class SpringFragment extends BaseFragment {

    private View view;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment_spring, null);
        return view;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mActivity = getActivity();

        ViewPager mVp = (ViewPager) view.findViewById(R.id.vp);
        final ArrayList<String> urlLists = new ArrayList<>();
        urlLists.add("http://img.daokoudai.com/banner/5a/b5/5ab56a5b3356a1ccd6c3884a67dd597a.jpg");
        urlLists.add("http://img.daokoudai.com/banner/af/0c/af0cb53e8a80e0a2d58598892973f087.jpg");
        urlLists.add("http://img.daokoudai.com/banner/5a/43/5a43f0c9e402f906b6c2065ec5cfa92c.jpg");
        mVp.setAdapter(new PagerAdapter() {
            @Override
            public int getCount() {
                return urlLists.size();
            }

            @Override
            public boolean isViewFromObject(View view, Object object) {
                return view == object;
            }

            @Override
            public Object instantiateItem(ViewGroup container, int position) {
                View view = View.inflate(mActivity, R.layout.viewpager_banner, null);
                NetworkImageView mNetIv = (NetworkImageView) view.findViewById(R.id.net_iv);
                ImageLoaderUtil.setNetWorkImageView(urlLists.get(position), mNetIv, R.mipmap.loading, R.mipmap.loading);
                container.addView(view);
                return view;
            }

            @Override
            public void destroyItem(ViewGroup container, int position, Object object) {
                container.removeView((View) object);
            }
        });
    }
}
