package com.uv.okhttpnetprocess.task;

import android.content.Context;
import android.text.TextUtils;

import com.afollestad.materialdialogs.MaterialDialog;
import com.uv.okhttpnetprocess.NPApplication;
import com.uv.okhttpnetprocess.NPConstant;
import com.uv.okhttpnetprocess.R;
import com.uv.okhttpnetprocess.util.HttpUtil;
import com.uv.okhttpnetprocess.util.ToastUtil;


/**
 * CTaskListener
 */
public abstract class BaseTaskListener {

    private static String error, codeError;
    private Context context;
    private MaterialDialog waitingDialog;

    protected boolean isLogout = false;

    public static NPConstant.TASK_RESULT checkhead(String[] array) {

        if (NPConstant.KEY_REQUEST_SUCCESS.equals(array[0])) {
            return NPConstant.TASK_RESULT.OK;
        }
        error = array[1];
        codeError = array[2];
        return NPConstant.TASK_RESULT.ERROR;
    }

    /**
     * onPreExecute 准备操作
     */
    public void doOnPreExecute(Context context, boolean isLoading, Object... obj) {
        // obj.open;
        this.context = context;
        if (isLoading) {

            waitingDialog = new MaterialDialog.Builder(context)
                    .content(R.string.waiting)
                    .progress(true, 0)
                    .build();
            waitingDialog.setCanceledOnTouchOutside(false);
            waitingDialog.show();
        }

    }

    /**
     * doInBackground 工作线程操作
     */
    public abstract NPConstant.TASK_RESULT doInBackground(Object... obj);

    /**
     * onPostExecute 成功操作
     */
    public void doOnPostExecuteOK(Object... obj) {
        // obj.close
        if (waitingDialog != null) {
            // obj.close
            waitingDialog.dismiss();
        }
    }

    /**
     * onPostExecute 失败操作
     */
    public void doOnPostExecuteError(Object... obj) {

        if (!HttpUtil.isNet(NPApplication.getContext())) {
            ToastUtil.addToast(R.string.network_error);
            if (waitingDialog != null) {
                // obj.close
                waitingDialog.dismiss();
            }
        } else {
//            if (CAConstant.LOGOUT_CODE_1.equals(codeError) ||
//                    CAConstant.LOGOUT_CODE_2.equals(codeError) ||
//                    CAConstant.LOGOUT_CODE_3.equals(codeError)) {
//
//                isLogout = true;
//
//                // token过期 清空
//                ActivityHelper.cleanToken();
//
//                if (waitingDialog != null) {
//                    // obj.close
//                    waitingDialog.dismiss();
//                }
//            } else {
//
//                isLogout = false;
//
//                if (TextUtils.isEmpty(error)) {
//                    ActivityHelper.addToast(R.string.network_loading_failed);
//                    if (waitingDialog != null) {
//                        // obj.close
//                        waitingDialog.dismiss();
//                    }
//                } else {
//                    ActivityHelper.addToast(error);
//                    if (waitingDialog != null) {
//                        // obj.close
//                        waitingDialog.dismiss();
//                    }
//                }
//            }
        }



    }

    /**
     * onPostExecute 无为操作
     */
    void doOnPostExecuteNothing() {
        if (waitingDialog != null) {
            // obj.close
            waitingDialog.dismiss();
        }
    }

    /**
     * onPostExecute 最终操作
     */
    void doOnPostExecuteFinally() {
        if (waitingDialog != null) {
            // obj.close
            waitingDialog.dismiss();
        }
    }

    /**
     * onCancelled 取消操作
     */
    public void doOnCancelled(Object... obj) {
        if (waitingDialog != null) {
            // obj.close
            waitingDialog.dismiss();
        }
    }

}
