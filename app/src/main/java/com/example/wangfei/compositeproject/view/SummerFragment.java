package com.example.wangfei.compositeproject.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.wangfei.compositeproject.R;
import com.example.wangfei.compositeproject.model.BaseFragment;

/**
 * Created by wangfei on 16/9/14.
 */

public class SummerFragment extends BaseFragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_summer, null);
        return view;
    }
}
