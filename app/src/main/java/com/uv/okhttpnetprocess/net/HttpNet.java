package com.uv.okhttpnetprocess.net;

import android.content.Context;

import com.uv.okhttpnetprocess.NPConstant;
import com.uv.okhttpnetprocess.util.AESUtil;
import com.uv.okhttpnetprocess.util.JacksonUtil;
import com.uv.okhttpnetprocess.util.LogUtil;
import com.uv.okhttpnetprocess.util.SharedUtil;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

import static com.uv.okhttpnetprocess.NPConstant.KEY_CONTENT;

/**
 * Created by chinauv on 2017/10/25.
 * 网络处理
 */

public class HttpNet {

    private static final OkHttpClient mOkHttpClient = new OkHttpClient.Builder()
            .connectTimeout(15, TimeUnit.SECONDS)
            .readTimeout(17, TimeUnit.SECONDS)
            .build();

    /**
     * 普通Post  请求
     * 已经去除空请求参数
     */
    public static String[] doPost(Context context, String subURL, Map argsMap) {

        String array[] = new String[3];

        try {

            // 网络请求 （含 AES 加密判断）
            Response response = requestNetWithMap(context, subURL, argsMap);

            String result = response.body().string();

            // 是否使用AES解密
            result = decryptResponse(context, result);

            JSONObject jsonObject = new JSONObject(result);
            Boolean isSuccess = (Boolean) jsonObject.get(NPConstant.KEY_RESPONSE_KEY_SUCCESS);

//            LogUtil.i("***** sessionId*****" + subURL + "=" + ActivityHelper.getToken(context));
            LogUtil.i("***** result*****" + subURL + "=" + result);
            LogUtil.i("***** success *****" + subURL + "=" + isSuccess);

            if (isSuccess) {

                array[0] = "1";
                array[1] = result;

            } else {
                String message = jsonObject.get("message").toString();
                String messageCode = jsonObject.get("megCode").toString();

                array[0] = "0";
                array[1] = message;
                array[2] = messageCode;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return array;

    }

    /**
     * 网络请求 （含 AES 加密判断）
     */
    private static Response requestNetWithMap (Context context, String subURL, Map argsMap) throws IOException {

        String jsonStr = JacksonUtil.getInstance().writeValueAsString(argsMap);

        return requestNetWithString(context, subURL, jsonStr);
    }

    /**
     * 网络请求 （含 AES 加密判断）
     */
    private static Response requestNetWithString (Context context, String subURL, String jsonStr) throws IOException {

        // 请求地址
        String requestURL;

        RequestBody requestBody;

        // 是否使用AES加密
        if (NPConstant.IS_USE_AES) {
            //加密key值
            String encryptKey = SharedUtil.getKey(context);
            //进行加密
            String ensString = AESUtil.encrypt(jsonStr, encryptKey);
            Map<String, String> map = new HashMap<>();
            map.put(NPConstant.KEY_CONTENT, ensString);

            String miStr = JacksonUtil.getInstance().writeValueAsString(map);
            requestBody = RequestBody.create(NPConstant.JSON, miStr);

            // AES 加密请求地址
            requestURL = NPConstant.HTTP_URL_4_AES + subURL;

        } else {
            requestBody = RequestBody.create(NPConstant.JSON, jsonStr);

            // 普通请求地址
            requestURL = NPConstant.HTTP_URL_4_NULL + subURL;
        }

        LogUtil.i("***** request URL *****" + subURL + "=" + requestURL);
        LogUtil.i("***** request json *****" + subURL + "=" + jsonStr);

        Request request = new Request.Builder()
                .url(requestURL)
//                .addHeader(CAConstant.REQUEST_HEADER_KEY_SESSION_ID, ActivityHelper.getToken(context))
//                .addHeader(CAConstant.REQUEST_HEADER_KEY_UDID, NPConstant.ANDROID_ID)
//                .addHeader(CAConstant.REQUEST_HEADER_CONTENT_TYPE, CAConstant.REQUEST_HEADER_CONTENT_TYPE_VALUE)
                .post(requestBody)
                .build();

        Response response = mOkHttpClient.newCall(request).execute();

//        // 909 响应状态 加密 key 失效
//        if(NET_CODE_909 == response.code()){
//            ActivityHelper.GetAESKeyTaskListener getKeyListener = new ActivityHelper.GetAESKeyTaskListener(false);
//            BaseTask task = new BaseTask(getKeyListener, CAApplication.getContext());
//            task.execute();
//        }

        return response;
    }

    /**
     * 是否使用AES解密
     */
    private static String decryptResponse(Context context, String result) throws JSONException {

        // 是否使用AES解密
        if (NPConstant.IS_USE_AES) {

            JSONObject jsonObjectAes = new JSONObject(result);

            String des = jsonObjectAes.get(NPConstant.KEY_CONTENT).toString();

            //加密key值
            String encryptKey = SharedUtil.getKey(context);

            //进行解密
            result = AESUtil.decrypt(des, encryptKey);
        }

        return result;
    }
}
