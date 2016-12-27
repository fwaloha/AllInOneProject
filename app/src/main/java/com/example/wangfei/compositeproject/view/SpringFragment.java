package com.example.wangfei.compositeproject.view;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.volley.toolbox.NetworkImageView;
import com.example.wangfei.compositeproject.R;
import com.example.wangfei.compositeproject.model.BaseFragment;
import com.example.wangfei.compositeproject.model.utils.DialogUtils;
import com.example.wangfei.compositeproject.model.utils.ImageLoaderUtil;
import com.example.wangfei.compositeproject.model.utils.LogUtils;
import com.example.wangfei.compositeproject.model.utils.SpanUtils;
import com.example.wangfei.compositeproject.model.utils.ToastUtils;
import com.example.wangfei.compositeproject.model.utils.ViewUiUtils;
import com.viewpagerindicator.CirclePageIndicator;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by wangfei on 16/9/14.
 */

public class SpringFragment extends BaseFragment {

    @BindView(R.id.vpindicator)
    CirclePageIndicator vpIndicator;
    @BindView(R.id.iv_glide)
    ImageView ivGlide;
    @BindView(R.id.bt_test)
    Button btTest;
    private View view;
    private ViewPager mVp;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        LogUtils.d("Spring ----------", "onCreate");

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        LogUtils.d("Spring ----------", "onCreateView");

        view = inflater.inflate(R.layout.fragment_spring, null);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mActivity = getActivity();
        LogUtils.d("Spring ----------", "onActivityCreated");


        mVp = (ViewPager) view.findViewById(R.id.vp);
        final ArrayList<String> urlLists = new ArrayList<>();
//        urlLists.add("http://img.daokoudai.com/banner/7b/85/7b858e3976ba1b62445e3fe81df5556e.jpg");
//        urlLists.add("http://img.daokoudai.com/banner/af/0c/af0cb53e8a80e0a2d58598892973f087.jpg");
//        urlLists.add("http://img.daokoudai.com/banner/5a/43/5a43f0c9e402f906b6c2065ec5cfa92c.jpg");
        urlLists.add("http://img.daokoudai.com/banner/7b/85/7b858e3976ba1b62445e3fe81df5556e.jpg");
        urlLists.add("http://img.daokoudai.com/banner/1c/44/1c44c2943a45af694e733c029566ddcb.jpg");
        urlLists.add("http://img.daokoudai.com/banner/89/82/8982424408451a55ccf087c88852889f.jpg");

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
            public Object instantiateItem(ViewGroup container, final int position) {
                View view = View.inflate(mActivity, R.layout.viewpager_banner, null);
                NetworkImageView mNetIv = (NetworkImageView) view.findViewById(R.id.net_iv);
                ImageLoaderUtil.setNetWorkImageView(urlLists.get(position), mNetIv, R.mipmap.loading, R.mipmap.loading);
                container.addView(view);

                view.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        ToastUtils.show("haha" + urlLists.get(position));
                    }
                });
                return view;
            }

            @Override
            public void destroyItem(ViewGroup container, int position, Object object) {
                container.removeView((View) object);
            }
        });
        vpIndicator.setViewPager(mVp);
        final Handler handler = new Handler() {
            int i;

            @Override
            public void handleMessage(Message msg) {
                switch (msg.what) {
                    case 1:
                        vpIndicator.setCurrentItem(i++);
                }
            }
        };

        new Thread() {
            @Override
            public void run() {
                while (true) {
                    try {
                        Thread.sleep(3000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    handler.sendEmptyMessage(1);
                }
            }
        }.start();


        final TextView mTvTitle = (TextView) view.findViewById(R.id.tv_title);
        final TextView mTvInfo = (TextView) view.findViewById(R.id.tv_info);
        mTvInfo.setText("hahahhahahdhadhasldjfl打了多久了发掘的法律手段困死了都解放了圣诞节啥地方记录");

        view.findViewById(R.id.ll_title).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ToastUtils.show("che");
                ViewUiUtils.expend(mTvTitle, mTvInfo);
            }
        });

        TextView mSpanner = (TextView) view.findViewById(R.id.tv_spanner);

        SpanUtils.bindSpanableStr("diandlsjdlfiwoejfowpflj");
        SpanUtils.addForegroundColor(Color.BLUE, 3, 9);
        mSpanner.setText(SpanUtils.getSpannableStr());

//        Glide.with(this).load("http://img.daokoudai.com/banner/1e/f2/1ef2aacd6c39e05b05581ab7f56aac8f.jpg").into(ivGlide);
//        ImageUtils.loadBitmap(this,"http://img.daokoudai.com/banner/1e/f2/1ef2aacd6c39e05b05581ab7f56aac8f.jpg",ivGlide);
    }

    @OnClick(R.id.bt_test)
    public void onClick() {
        DialogUtils.showDialog(mActivity);
//        DialogUtils.dismissDialog(mActivity);
    }


    public class ClickAble extends ClickableSpan {

        private final int mColor;
        private final boolean mUnderline;

        @Override
        public void onClick(View widget) {
            ToastUtils.show("haha,success!");
        }

        public ClickAble(int color, boolean underline) {
            mColor = color;
            mUnderline = underline;
        }

        @Override
        public void updateDrawState(TextPaint ds) {
            ds.setColor(mColor);
            ds.setUnderlineText(mUnderline);
        }
    }

    @Override
    public void onAttach(Activity activity) {
        // TODO Auto-generated method stub
        LogUtils.d("Spring ----------", "onAttach");
        super.onAttach(activity);
    }


    @Override
    public void onStart() {
        // TODO Auto-generated method stub
        LogUtils.d("Spring -----", "onStart");
        super.onStart();
    }

    @Override
    public void onResume() {
        // TODO Auto-generated method stub
        LogUtils.d("Spring -----", "onResume");
        super.onResume();
    }

    @Override
    public void onPause() {
        // TODO Auto-generated method stub
        LogUtils.d("Spring -----", "onPause");
        super.onPause();
    }

    @Override
    public void onStop() {
        // TODO Auto-generated method stub
        LogUtils.d("Spring -----", "onStop");
        super.onStop();
    }

    @Override
    public void onDestroyView() {
        // TODO Auto-generated method stub
        LogUtils.d("Spring -----", "onDestroyView");
        super.onDestroyView();
    }

    @Override
    public void onDestroy() {
        // TODO Auto-generated method stub
        LogUtils.d("Spring -----", "onDestroy");
        super.onDestroy();
    }

    @Override
    public void onDetach() {
        // TODO Auto-generated method stub
        LogUtils.d("Spring -----", "onDetach");
        super.onDetach();
    }
}
