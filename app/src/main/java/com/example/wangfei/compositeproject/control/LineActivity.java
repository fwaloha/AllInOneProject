package com.example.wangfei.compositeproject.control;

import android.graphics.Color;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.NetworkImageView;
import com.example.wangfei.compositeproject.R;
import com.example.wangfei.compositeproject.model.bean.Meizi;
import com.example.wangfei.compositeproject.model.network.RequestQun;
import com.example.wangfei.compositeproject.model.utils.ImageLoaderUtil;
import com.example.wangfei.compositeproject.model.utils.LogUtils;
import com.example.wangfei.compositeproject.model.utils.ToastUtils;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class LineActivity extends AppCompatActivity {

    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.recycler)
    RecyclerView recycler;
    @BindView(R.id.swipe)
    SwipeRefreshLayout swipe;
    @BindView(R.id.activity_line)
    CoordinatorLayout activityLine;
    private ArrayList<Meizi> urlList;
    private int t;
    private LinearLayoutManager linearLayoutManager1;
    private String mUrl = "http://gank.io/api/data/%E7%A6%8F%E5%88%A9/10/";
    private int index;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_line);
        ButterKnife.bind(this);
        setSupportActionBar(toolbar);

        t = 0;
        index = 0;
//        doGetinfo(mUrl + index);//获取图片资源
        doGetinfo(mUrl + (++index));
//        new GetData().execute();
        initRefresh();


    }

    private class GetData extends AsyncTask{

        @Override
        protected Object doInBackground(Object[] params) {
            doGetinfo(mUrl + (++index));
            return null;
        }
    }

    private void initRefresh() {
        swipe.setColorSchemeColors(Color.CYAN, R.color.cyan);
        //设置刷新图标的起始终点位置
//        swipe.setProgressViewOffset(false,0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,24,getResources().getDisplayMetrics()));
        swipe.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                ToastUtils.show("shuaxinle......" + t++);
                swipe.setRefreshing(false);
            }
        });

    }

    private void doGetinfo(String url) {
        RequestQun.addRequet(this, Request.Method.GET, url, null, null, new RequestQun.NetWorkRequestListener() {

            private JSONObject jsonObject;

            @Override
            public void onPreRequest() {
                ToastUtils.show("connected....");
            }

            @Override
            public void onResponse(String response) {
//                ToastUtils.show(response);
                LogUtils.d(response);
                Gson gson = new Gson();
                try {
                    jsonObject = new JSONObject(response);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                RecyclerAdapter recyclerAdapter = new RecyclerAdapter();
                JSONArray results = jsonObject.optJSONArray("results");
                if (urlList == null) {
                    urlList = new ArrayList<>();
                    String result = jsonObject.optString("results");
                    urlList = gson.fromJson(result, new TypeToken<List<Meizi>>() {
                    }.getType());
                }else {
                    String result = jsonObject.optString("results");
                    urlList.addAll((Collection<? extends Meizi>) gson.fromJson(result, new TypeToken<List<Meizi>>() {
                    }.getType()));
                    recyclerAdapter.notifyDataSetChanged();
                }
//                for (int i = 0; i < results.length(); i++) {
//                    try {
//                        urlList.add(results.getJSONObject(i).optString("url"));
//                    } catch (JSONException e) {
//                        e.printStackTrace();
//                    }
//                    LogUtils.d(urlList.get(i)+"\n");
//                }

//              设置recyclerview
                linearLayoutManager1 = new LinearLayoutManager(LineActivity.this);
                GridLayoutManager gridLayoutManager = new GridLayoutManager(LineActivity.this, 2);
                StaggeredGridLayoutManager staggeredGridLayoutManager = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
                recycler.setLayoutManager(linearLayoutManager1);
                recycler.setAdapter(recyclerAdapter);

                recycler.addOnScrollListener(new RecyclerView.OnScrollListener() {

                    private int lastVisibleItemPosition;

                    @Override
                    public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                        if (newState == RecyclerView.SCROLL_STATE_IDLE && lastVisibleItemPosition + 2 >= linearLayoutManager1.getChildCount()) {
//                            doGetinfo(mUrl + (++index));
//                            new GetData().execute();
                            doGetinfo(mUrl + (++index));
                        }
                    }

                    @Override
                    public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                        super.onScrolled(recyclerView, dx, dy);
                        lastVisibleItemPosition = linearLayoutManager1.findLastVisibleItemPosition();
                    }
                });
            }

            @Override
            public void onFailed(VolleyError error) {
                ToastUtils.show("connect failed....");
            }
        });
    }

    private class RecyclerAdapter extends RecyclerView.Adapter<RecyclerViewholder> {

        @Override
        public RecyclerViewholder onCreateViewHolder(ViewGroup parent, int viewType) {
            View rootView = View.inflate(LineActivity.this, R.layout.recylerview, null);
            RecyclerViewholder recyclerViewholder = new RecyclerViewholder(rootView);

//            recyclerview条目的点击事件
            rootView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int posi = recycler.getChildAdapterPosition(v);
                    ToastUtils.show("dianjile" + posi);
                    Snackbar.make(activityLine, "dddddddddd", Snackbar.LENGTH_SHORT).show();
                }
            });
            return recyclerViewholder;
        }

        @Override
        public void onBindViewHolder(RecyclerViewholder holder, int position) {
            holder.mTvName.setText("第几张:" + position);
            ImageLoaderUtil.setNetWorkImageView(urlList.get(position).getmUrl(), holder.mNetImage, R.mipmap.loading, R.mipmap.loading);
        }

        @Override
        public int getItemCount() {
            return urlList.size();
        }

        public void addItem() {
            notifyItemInserted(1);
        }
    }

    private class RecyclerViewholder extends RecyclerView.ViewHolder {

        public NetworkImageView mNetImage;
        public TextView mTvName;

        public RecyclerViewholder(View itemView) {
            super(itemView);
            mNetImage = (NetworkImageView) itemView.findViewById(R.id.netimag);
            mTvName = (TextView) itemView.findViewById(R.id.tv_imagname);
        }
    }
}
