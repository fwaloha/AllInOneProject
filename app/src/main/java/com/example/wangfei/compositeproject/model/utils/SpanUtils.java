package com.example.wangfei.compositeproject.model.utils;

import android.hardware.camera2.params.ColorSpaceTransform;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.widget.TextView;

/**
 * Created by wangfei on 16/9/19.
 */

public class SpanUtils {

    private static SpannableString spannableString;

    public SpanUtils() {
    }

    /**
     * 绑定 str到spannableString
     *
     * @param str
     */
    public static void bindSpanableStr(String str) {
        spannableString = new SpannableString(str);
    }

    /**
     * 获取绑定的spannableString
     *
     * @param str
     * @return
     */
    public static SpannableString getSpannableStr() {
        return spannableString;
    }

    /**
     * spannable 添加颜色 ,
     *
     * @param color
     * @param start
     * @param end
     * @param flag  不传默认为 Spanned.SPAN_EXCLUSIVE_EXCLUSIVE 前闭后开
     */
    public static void addForegroundColor(int color, int start, int end, int flag) {
        ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(color);
        spannableString.setSpan(foregroundColorSpan, start, end, flag);
    }

    public static void addForegroundColor(int color, int start, int end) {
        ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(color);
        spannableString.setSpan(foregroundColorSpan, start, end, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
    }

    /**
     * 添加点击事件的spannable
     *
     * @param clickableSpan
     * @param textView
     * @param start
     * @param end
     * @param flag
     */
    public static void addClickAbleSpan(ClickAble clickableSpan, TextView textView, int start, int end, int flag) {
        textView.setMovementMethod(LinkMovementMethod.getInstance());
        spannableString.setSpan(clickableSpan, start, end, flag);
    }

    public static void addClickAbleSpan(ClickableSpan clickableSpan, TextView textView, int start, int end) {
        textView.setMovementMethod(LinkMovementMethod.getInstance());
        spannableString.setSpan(clickableSpan, start, end, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
    }


    /**
     * 复写这个类,做到点击事件的下划线去掉,并且更改可点击字体的颜色
     */
    public abstract class ClickAble extends ClickableSpan {

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
}
