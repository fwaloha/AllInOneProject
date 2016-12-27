package com.example.wangfei.compositeproject.view;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.wangfei.compositeproject.R;
import com.example.wangfei.compositeproject.model.BaseFragment;
import com.example.wangfei.compositeproject.model.utils.LogUtils;

/**
 * Created by wangfei on 16/9/14.
 */

public class SummerFragment extends BaseFragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_summer, null);
        LogUtils.d("Summer -----", "onCreateView");

        return view;
    }

    @Override
    public void onAttach(Activity activity) {
        // TODO Auto-generated method stub
        LogUtils.d("Summer -----", "onAttach");
        super.onAttach(activity);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        LogUtils.d("Summer -----", "onCreate");
        super.onCreate(savedInstanceState);
    }


    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        LogUtils.d("Summer -----", "onActivityCreated");
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public void onStart() {
        // TODO Auto-generated method stub
        LogUtils.d("Summer -----", "onStart");
        super.onStart();
    }

    @Override
    public void onResume() {
        // TODO Auto-generated method stub
        LogUtils.d("Summer -----", "onResume");
        super.onResume();
    }

    @Override
    public void onPause() {
        // TODO Auto-generated method stub
        LogUtils.d("Summer -----", "onPause");
        super.onPause();
    }

    @Override
    public void onStop() {
        // TODO Auto-generated method stub
        LogUtils.d("Summer -----", "onStop");
        super.onStop();
    }

    @Override
    public void onDestroyView() {
        // TODO Auto-generated method stub
        LogUtils.d("Summer -----", "onDestroyView");
        super.onDestroyView();
    }

    @Override
    public void onDestroy() {
        // TODO Auto-generated method stub
        LogUtils.d("Summer -----", "onDestroy");
        super.onDestroy();
    }

    @Override
    public void onDetach() {
        // TODO Auto-generated method stub
        LogUtils.d("Summer -----", "onDetach");
        super.onDetach();
    }
}
