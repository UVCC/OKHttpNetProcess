package com.uv.okhttpnetprocess;

import android.provider.Settings;

import okhttp3.MediaType;

/**
 * Created by chinauv on 2017/10/25.
 * 常量文件
 */

public class NPConstant {

    // resp_code KEY  成功
    public static final String KEY_RESPONSE_KEY_SUCCESS = "success";
    // resp_code KEY  内容
    public static final String KEY_CONTENT = "content";

    // AES 加密传输开关
    public static final boolean IS_USE_AES = false;
    // AES 加密向量
    public static final String AES_IV = "CHINAUVCC1234567";

    // 传输数据类型
    public static final MediaType JSON = MediaType.parse("application/json; charset=utf-8");

    // 网络请求地址前缀
    public static final String HTTP_URL = "http://192.168.0.177:7070";
    // 网络请求地址中缀 不含 AES
    public static final String HTTP_URL_4_NULL = HTTP_URL + "/undoaes";
    // 网络请求地址中缀 含 AES
    public static final String HTTP_URL_4_AES = HTTP_URL +"/doaes";

    //设备唯一标识
    public static String ANDROID_ID = Settings.Secure.getString(NPApplication.getContext().getContentResolver(), Settings.Secure.ANDROID_ID);

    //接口请求成功 1
    public static final String KEY_REQUEST_SUCCESS = "1";

    public enum TASK_RESULT {
        OK,
        ERROR,
        CANCELLED,
        NET_ERROR,
        NOTHING
    }
}
