package com.uv.okhttpnetprocess.util;


import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;


public class HttpUtil {

    /**
     * 判断是否有可用网络
     */
    public static boolean isNet(Context paramContext) {
        ConnectivityManager localConnectivityManager = (ConnectivityManager) paramContext.getSystemService(Context.CONNECTIVITY_SERVICE);

        while (true) {


            NetworkInfo localNetworkInfo = localConnectivityManager.getActiveNetworkInfo();
            if ((localNetworkInfo != null) && (localNetworkInfo.isConnected())) {
                //
                if (localNetworkInfo.getState() == NetworkInfo.State.CONNECTED) {
                    return true;
                }
            }

            return false;
        }
    }

//
//    /**
//     * make true current connect service is wifi
//     *
//     * @param mContext
//     * @return
//     */
//    private static boolean isWifi(Context mContext) {
//        ConnectivityManager connectivityManager = (ConnectivityManager) mContext
//                .getSystemService(Context.CONNECTIVITY_SERVICE);
//        NetworkInfo activeNetInfo = connectivityManager.getActiveNetworkInfo();
//        return activeNetInfo != null
//                && activeNetInfo.getType() == ConnectivityManager.TYPE_WIFI;
//    }
//
//    public static int netWork(Context mContext) {
//        ConnectivityManager connectivityManager = (ConnectivityManager) mContext
//                .getSystemService(Context.CONNECTIVITY_SERVICE);
//        NetworkInfo activeNetInfo = connectivityManager.getActiveNetworkInfo();
//        if (activeNetInfo != null) {
//            if (activeNetInfo.isConnected()) {
//                if (activeNetInfo.getType() == ConnectivityManager.TYPE_WIFI) {
//                    return 2;
//                }
//                if (activeNetInfo.getState() == NetworkInfo.State.CONNECTED) {
//                    return 1;
//                }
//            }
//            return 0;
//        }
//        return 0;
//    }


}

