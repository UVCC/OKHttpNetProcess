package com.uv.okhttpnetprocess.util;

import android.support.annotation.StringRes;
import android.widget.Toast;

import com.uv.okhttpnetprocess.NPApplication;

/**
 * Created by chinauv on 2017/10/25.
 * Toast Util
 */

public class ToastUtil {
    private static Toast mToast;

    /**
     * 显示提示 Toast
     */
    public static void addToast(@StringRes int resid) {
        if (mToast == null) {
            mToast = Toast.makeText(NPApplication.getContext(), NPApplication.getContext().getResources().getText(resid), Toast.LENGTH_SHORT);
        } else {
            mToast.setText(NPApplication.getContext().getResources().getText(resid));
            mToast.setDuration(Toast.LENGTH_SHORT);
        }
        mToast.show();
    }
}
