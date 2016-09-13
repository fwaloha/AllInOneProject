package com.example.wangfei.compositeproject.model.utils;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import android.widget.ListView;

/**
 * Created by wangfei on 16/9/8.
 */

public class Test {

    public static void getListviewHeight(Context context, ListView listView){
        ListAdapter adapter = listView.getAdapter();
        if(adapter == null){
            return;
        }

        int totalHeight = 0;

        for (int i=0;i<adapter.getCount();i++){
            View view = adapter.getView(i, null, listView);
            view.measure(0,0);
            totalHeight += view.getHeight();
        }

        ViewGroup.LayoutParams layoutParams = listView.getLayoutParams();

        totalHeight += listView.getDividerHeight()*(adapter.getCount()-1);
        layoutParams.height = totalHeight;

        listView.setLayoutParams(layoutParams);
    }
}
