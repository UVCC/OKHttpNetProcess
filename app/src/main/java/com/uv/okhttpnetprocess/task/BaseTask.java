package com.uv.okhttpnetprocess.task;

import android.content.Context;
import android.os.AsyncTask;
import android.view.View;

import com.uv.okhttpnetprocess.NPApplication;
import com.uv.okhttpnetprocess.NPConstant;
import com.uv.okhttpnetprocess.util.HttpUtil;
import com.uv.okhttpnetprocess.util.LogUtil;


/**
 * BaseTask
 */
public class BaseTask extends AsyncTask<Integer, Integer, NPConstant.TASK_RESULT> {

    private BaseTaskListener baseTaskListener = null;

    private View containerView;

    private Context context;

    public BaseTask() {
        super();
    }

    public BaseTask(BaseTaskListener listener, Context context) {
        super();
        baseTaskListener = listener;
        this.context = context;
    }

    @Override
    protected void onPreExecute() {

//        if (!HttpUtil.isnet(CAApplication.getContext())) {
//
//            // 取消Task并中断线程
//            this.cancel(true);
//
////            if (null != containerView) {
////                Snackbar.make(containerView, "网络错误", Snackbar.LENGTH_SHORT)
////                        .setAction("Action", null).show();
////            }
//        }

        // 准备操作
        baseTaskListener.doOnPreExecute(context, true);
    }

    /**
     * 这里的Integer参数对应AsyncTask中的第一个参数
     * 这里的String返回值对应AsyncTask的第三个参数
     * 该方法并不运行在UI线程当中，主要用于异步操作，所有在该方法中不能对UI当中的空间进行设置和修改
     * 但是可以调用publishProgress方法触发onProgressUpdate对UI进行操作
     */
    @Override
    protected NPConstant.TASK_RESULT doInBackground(Integer... params) {

        NPConstant.TASK_RESULT taskResult = NPConstant.TASK_RESULT.NOTHING;

        if (!HttpUtil.isNet(NPApplication.getContext())) {
            return NPConstant.TASK_RESULT.ERROR;
        }

        try {
            if (null != baseTaskListener) {
                // 工作线程操作
                taskResult = baseTaskListener.doInBackground();
            }

            return taskResult;

        } catch (Exception e) {
            e.printStackTrace();
            return NPConstant.TASK_RESULT.ERROR;
        }
    }

    /**
     * 这里的String参数对应AsyncTask中的第三个参数（也就是接收doInBackground的返回值）
     * 在doInBackground方法执行结束之后在运行，并且运行在UI线程当中 可以对UI空间进行设置
     */
    @Override
    protected void onPostExecute(NPConstant.TASK_RESULT taskResult) {

        LogUtil.i("------- onPostExecute taskResult " + String.valueOf(taskResult));

        if (null == baseTaskListener) {
            return;
        }

        // 最终操作
        baseTaskListener.doOnPostExecuteFinally();

        switch (taskResult) {
            case OK:
                // 成功操作
                baseTaskListener.doOnPostExecuteOK();
                break;
            case ERROR:
                // 失败操作

                baseTaskListener.doOnPostExecuteError();
                break;
            case NOTHING:
                // 无为操作
                baseTaskListener.doOnPostExecuteNothing();
                break;
            default:
                break;
        }
    }

    /**
     * 取消
     */
    @Override
    protected void onCancelled() {
        baseTaskListener.doOnCancelled();
    }
}
