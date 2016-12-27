package com.example.wangfei.compositeproject.model.network;

import android.content.Context;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import com.android.volley.AuthFailureError;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.example.wangfei.compositeproject.MyApplication;
import com.example.wangfei.compositeproject.R;
import com.example.wangfei.compositeproject.model.BaseDialog;
import com.example.wangfei.compositeproject.model.utils.ToastUtils;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.Map;
/**
 * Created by wangfei on 16/9/8.
 */

public class RequestQun {


    public static void addRequet(
            Context context,
            final int method,
            String url,
            final Map<String, String> params,
            final Map<String, String> header,
            final NetWorkRequestListener listener) {

        if (method == com.android.volley.Request.Method.GET) {
            url = NetworkParams.spliceUrlParams(url, params);
        }

        final BaseDialog baseDialog = new BaseDialog(context) {
            @Override
            public View setDialogView(Context context) {
                View view = View.inflate(context, R.layout.dialog_loading, null);
                Animation animation = AnimationUtils.loadAnimation(context, R.anim.loading_rotate);
                View icon = view.findViewById(R.id.imageView);
                icon.startAnimation(animation);
                return view;
            }
        };
        baseDialog.show();
        listener.onPreRequest();
        StringRequest request = new StringRequest(method, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                try {
                    JSONObject jsonObject = new JSONObject(response);
                    if (jsonObject.has("success")) {
                        if (!jsonObject.optBoolean("success", true)) {
                            ToastUtils.show("网络异常!");
                            return;
                        }
                    } else if (jsonObject.has("resCode")) {
                        if (!jsonObject.optString("resCode").endsWith("0000")) {
                            ToastUtils.show(jsonObject.optString("resMsg", "unknow"));
                            return;
                        }
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }finally {
                    baseDialog.dismiss();
                }
                listener.onResponse(response);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                listener.onFailed(error);
                baseDialog.dismiss();
            }
        }) {
//            @Override
//            public Map<String, String> getHeaders() throws AuthFailureError {
//                if(header == null){
//                    return null;
//                }
//                Map<String, String> map = header;
//                if (map == null) {
//                    map = new HashMap<>();
//                }
//                map.put("versionname", BuildConfig.VERSION_NAME);
//                TelephonyManager tm = (TelephonyManager) MyApplication.getInstance().getSystemService(Context.TELEPHONY_SERVICE);
//                map.put("IMEI", tm.getDeviceId());
//                return map;
//            }

            @Override
            protected Map<String, String> getParams() throws AuthFailureError {

                return params;
            }
        };
        request.setRetryPolicy(new com.android.volley.DefaultRetryPolicy(10 * 1000, 2, 1.0f));

        MyApplication.getRequestQueue().add(request);

    }



    public interface NetWorkRequestListener {
        void onPreRequest();

        void onResponse(String response);

        void onFailed(VolleyError error);
    }
}
