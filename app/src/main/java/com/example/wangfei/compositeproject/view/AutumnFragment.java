package com.example.wangfei.compositeproject.view;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.wangfei.compositeproject.R;
import com.example.wangfei.compositeproject.model.BaseFragment;
import com.example.wangfei.compositeproject.model.utils.LogUtils;
import com.example.wangfei.compositeproject.model.utils.ToastUtils;

/**
 * Created by wangfei on 16/9/14.
 */

public class AutumnFragment extends BaseFragment implements SwipeRefreshLayout.OnRefreshListener {

    private View view;
    private SwipeRefreshLayout swipe;
//    private RecyclerView recycler;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_autumn, null);
        LogUtils.d("Autumn", "onCreateView");

        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        LogUtils.d("Autumn -----", "onActivityCreated");

        initView();
    }

    private void initView() {
        swipe = (SwipeRefreshLayout) view.findViewById(R.id.swipe);
        swipe.setOnRefreshListener(this);
        swipe.setColorSchemeColors(Color.CYAN, Color.BLUE, Color.GREEN);
    }

    @Override
    public void onRefresh() {


        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                ToastUtils.show("this time");

                swipe.setRefreshing(false);
            }
        },2000);
    }

    @Override
    public void onAttach(Activity activity) {
        // TODO Auto-generated method stub
        LogUtils.d("Autumn -----", "onAttach");
        super.onAttach(activity);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
    }



    @Override
    public void onStart() {
        // TODO Auto-generated method stub
        LogUtils.d("Autumn -----", "onStart");
        super.onStart();
    }

    @Override
    public void onResume() {
        // TODO Auto-generated method stub
        LogUtils.d("Autumn -----", "onResume");
        super.onResume();
    }

    @Override
    public void onPause() {
        // TODO Auto-generated method stub
        LogUtils.d("Autumn -----", "onPause");
        super.onPause();
    }

    @Override
    public void onStop() {
        // TODO Auto-generated method stub
        LogUtils.d("Autumn -----", "onStop");
        super.onStop();
    }

    @Override
    public void onDestroyView() {
        // TODO Auto-generated method stub
        LogUtils.d("Autumn -----", "onDestroyView");
        super.onDestroyView();
    }

    @Override
    public void onDestroy() {
        // TODO Auto-generated method stub
        LogUtils.d("Autumn -----", "onDestroy");
        super.onDestroy();
    }

    @Override
    public void onDetach() {
        // TODO Auto-generated method stub
        LogUtils.d("Autumn -----", "onDetach");
        super.onDetach();
    }
}
