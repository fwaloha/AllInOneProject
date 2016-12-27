package com.example.wangfei.compositeproject;

/**
 * Created by wangfei on 16/9/12.
 */

public class TipsOfUtilsUse {

    private static TipsOfUtilsUse mInstance;
//单例模式 懒汉式
    private TipsOfUtilsUse() {
    }

    public static synchronized TipsOfUtilsUse getInstance(){
        if(mInstance == null){
            synchronized (TipsOfUtilsUse.class) {
                if(mInstance == null)
                mInstance = new TipsOfUtilsUse();
            }
        }
        return mInstance;
    }

    /**
     * 网络访问,需要 url, params(post),context(展示dialog需要)
     */
//    private void 网络获取() {
////        String url = "http://www.daokoudai.com/api/2.0/a_xiaoyoujinfu/getTeacherList?appKey=66666666&imei=865291025924316&from=AC&params=%7B%22token%22%3A%22e58b5e5be2de449a9fc419e0146975d7%22%2C%22page%22%3A1%2C%22size%22%3A10%2C%22sortThreshold%22%3A0%7D&version=1.2.3&apiName=empty";
//        String url = "http://ip.taobao.com/service/getIpInfo.php";
//        Map<String, String> params = new HashMap<>();
//        params.put("ip", "21.22.11.33");
//        RequestQun.addRequet(MainActivity.this,com.android.volley.Request.Method.GET, url, null, null, new RequestQun.NetWorkRequestListener() {
//
//            @Override
//            public void onPreRequest() {
//                ToastUtils.show("开始了");
//            }
//
//            @Override
//            public void onResponse(String response) {
//                ToastUtils.show("success!");
//                LogUtils.d("----success", response);
//            }
//
//            @Override
//            public void onFailed(VolleyError error) {
//                ToastUtils.show("网络连接不上failed!");
//            }
//        });
//    }


    /**
     * volley的简易网络图片加载,xml中的布局
     */
//    <com.android.volley.toolbox.NetworkImageView


    /**
     * spannable 调用方式
     */
//    TextView mSpanner = (TextView) view.findViewById(R.id.tv_spanner);
//
//    SpanUtils.bindSpanableStr("diandlsjdlfiwoejfowpflj");
//    SpanUtils.addClickAbleSpan(new ClickAble(Color.CYAN,false),mSpanner,3,9);
//    mSpanner.setText(SpanUtils.getSpannableStr());
//}
//
//
//    public class ClickAble extends ClickableSpan{
//
//    private final int mColor;
//    private final boolean mUnderline;
//
//    @Override
//    public void onClick(View widget) {
//        ToastUtils.show("haha,success!");
//    }
//
//    public ClickAble(int color, boolean underline) {
//        mColor = color;
//        mUnderline = underline;
//    }
//
//    @Override
//    public void updateDrawState(TextPaint ds) {
//        ds.setColor(mColor);
//        ds.setUnderlineText(mUnderline);
//    }
//}
}
