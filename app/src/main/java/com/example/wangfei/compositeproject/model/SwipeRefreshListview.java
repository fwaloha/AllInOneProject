package com.example.wangfei.compositeproject.model;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ListView;

import com.example.wangfei.compositeproject.R;

/**
 * Created by wangfei on 16/9/28.
 */

public class SwipeRefreshListview extends ListView {
    private boolean isLoading;
    private View footView;

    public SwipeRefreshListview(Context context) {
        this(context, null);
    }

    public SwipeRefreshListview(Context context, AttributeSet attrs) {
        super(context, attrs);

        initFootView(context);
        isBottom();
    }

    private void initFootView(Context context) {
        footView = View.inflate(context, R.layout.footloading, null);
    }

    public boolean isBottom() {
        int mTotal = this.getChildCount();
        final int lastVisiblePosition = this.getLastVisiblePosition();

        if (lastVisiblePosition == mTotal - 1) {
            return true;
        } else {
            return false;
        }
    }

    public void setLoading(boolean loading) {
        isLoading = loading;
        if (isLoading) {
            this.addFooterView(footView);
            footView.setVisibility(VISIBLE);
        } else {
            footView.setVisibility(GONE);
        }
    }
}
