package com.uv.okhttpnetprocess;

import android.app.Application;
import android.content.Context;

/**
 * Created by chinauv on 2017/10/25.
 * NP Application
 */

public class NPApplication extends Application {

    private static Context mContext;

    @Override
    public void onCreate() {
        super.onCreate();
        initBaseData();
    }

    /**
     * 系统基本数据设置，application中必须要执行的流程
     */
    private void initBaseData() {
        mContext = getApplicationContext();
    }

    public static Context getContext() {
        return mContext;
    }
}
