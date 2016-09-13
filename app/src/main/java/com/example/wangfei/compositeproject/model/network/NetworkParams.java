package com.example.wangfei.compositeproject.model.network;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by wangfei on 16/9/8.
 */

public class NetworkParams {

    //map to  string
    public static String paramsToString(Map<String, String> map) {
        if (map == null) {
            return null;
        }
        StringBuilder stringBuilder = new StringBuilder();
        ArrayList<String> keys = new ArrayList<>(map.keySet());

        for (int i = 0; i < keys.size(); i++) {
            String key = keys.get(i);
            String value = map.get(key);
            if (value != null) {
                stringBuilder.append((i == 0 ? "" : "&") + key + "=" + value);
            } else {
                stringBuilder.append((i == 0 ? "" : "&") + key + "=");
            }
        }
        return stringBuilder.toString();
    }

    //map url encode
    public static Map<String, String> getUrlEncodeParams(Map<String, String> map) {
        if (map == null) {
            return null;
        }
        ArrayList<String> keys = new ArrayList<>(map.keySet());

        Map<String, String> paramsMap = new HashMap<>();
        for (String key : keys) {
            String value = map.get(key);
            try {
                value = URLEncoder.encode(value, "utf-8");
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
            paramsMap.put(key, value);
        }
        return paramsMap;
    }

    //splice url and params
    public static String spliceUrlParams(String url, Map<String, String> params) {

        if(params == null || params.isEmpty()){
            return url;
        }
        return url + "?"+ paramsToString(params);
    }
}
