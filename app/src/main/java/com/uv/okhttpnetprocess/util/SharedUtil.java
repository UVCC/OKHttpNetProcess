package com.uv.okhttpnetprocess.util;

import android.content.Context;
import android.content.SharedPreferences;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by chinauv on 2017/10/25.
 * SharedPreferences 保存用户信息
 */
public class SharedUtil {
    public final static String USER_ID = "USER_ID";
    public final static String TOKEN = "TOKEN";
    public final static String MOBILE = "MOBILE";
    public final static String DEVICETOKEN = "DEVICETOKEN";
    public final static String CUSTOMER_TYPE = "CUSTOMER_TYPE";
    public final static String GROUP_TYPE = "GROUP_TYPE";
    public final static String TRANSACTION_ACCOUNT_ID = "TRANSACTION_ACCOUNT_ID";
    public final static String CONFIRMSTR = "confirmStr";
    public final static String CUSTOMER_ID = "CUSTOMER_ID";
    public final static String SWITCH_STATE = "SWITCH_STATE";
    public final static String KEY = "KEY";
    public final static String URL = "URL";

    // 登录类型
    public final static String LOGIN_TYPE = "LOGIN_TYPE";
    // 证件类型
    public final static String CERTIFICATE_TYPE = "CERTIFICATE_TYPE";
    // 证件号
    public final static String CERTIFICATE_ID = "CERTIFICATE_ID";
    // 证件名称
    public final static String CERTIFICATE_NAME = "CERTIFICATE_NAME";

    // 账号
    public final static String ACCOUNT_ID = "ACCOUNT_ID";

    public static void saveCertificateType(Context context, String certificateType) {
        SharedPreferences sp = context.getSharedPreferences(CERTIFICATE_TYPE, 0);
        SharedPreferences.Editor editor = sp.edit();
        editor.clear();
        editor.putString("certificateType", certificateType);
        editor.commit();
    }

    public static String getCertificateType(Context context) {
        Context ctx = context;
        SharedPreferences sp = ctx.getSharedPreferences(CERTIFICATE_TYPE, 0);
        String id = sp.getString("certificateType", "");
        return id;
    }

    public static void saveCertificateId(Context context, String certificateId) {
        SharedPreferences sp = context.getSharedPreferences(CERTIFICATE_ID, 0);
        SharedPreferences.Editor editor = sp.edit();
        editor.clear();
        editor.putString("certificateId", certificateId);
        editor.commit();
    }

    public static String getCertificateId(Context context) {
        Context ctx = context;
        SharedPreferences sp = ctx.getSharedPreferences(CERTIFICATE_ID, 0);
        String id = sp.getString("certificateId", "");
        return id;
    }

    public static void saveCertificateName(Context context, String certificateName) {
        SharedPreferences sp = context.getSharedPreferences(CERTIFICATE_NAME, 0);
        SharedPreferences.Editor editor = sp.edit();
        editor.clear();
        editor.putString("certificateName", certificateName);
        editor.commit();
    }

    public static String getCertificateName(Context context) {
        Context ctx = context;
        SharedPreferences sp = ctx.getSharedPreferences(CERTIFICATE_NAME, 0);
        String id = sp.getString("certificateName", "");
        return id;
    }

    public static void saveAccountId(Context context, String accountId) {
        SharedPreferences sp = context.getSharedPreferences(ACCOUNT_ID, 0);
        SharedPreferences.Editor editor = sp.edit();
        editor.clear();
        editor.putString("accountId", accountId);
        editor.commit();
    }

    public static String getAccountId(Context context) {
        Context ctx = context;
        SharedPreferences sp = ctx.getSharedPreferences(ACCOUNT_ID, 0);
        String id = sp.getString("accountId", "");
        return id;
    }

    public static void saveCustomerId(Context context, String customerId) {
        SharedPreferences sp = context.getSharedPreferences(CUSTOMER_ID, 0);
        SharedPreferences.Editor editor = sp.edit();
        editor.clear();
        editor.putString("customerId", customerId);
        editor.commit();
    }

    public static String getCustomerId(Context context) {
        Context ctx = context;
        SharedPreferences sp = ctx.getSharedPreferences(CUSTOMER_ID, 0);
        String id = sp.getString("customerId", "");
        return id;
    }

    public static void saveUserId(Context context, String id) {
        SharedPreferences sp = context.getSharedPreferences(USER_ID, 0);
        SharedPreferences.Editor editor = sp.edit();
        editor.clear();
        editor.putString("id", id);
        editor.commit();
    }

    public static String getUserId(Context context) {
        Context ctx = context;
        SharedPreferences sp = ctx.getSharedPreferences(USER_ID, 0);
        String id = sp.getString("id", "");
        return id;
    }


    public static  void clearUID(Context context) {
        Context ctx = context;
        SharedPreferences sp = ctx.getSharedPreferences(USER_ID, 0);
        SharedPreferences.Editor editor = sp.edit();
        editor.clear().commit();
    }
    public static void saveCustomerType(Context context, String customerType) {
        SharedPreferences sp = context.getSharedPreferences(CUSTOMER_TYPE, 0);
        SharedPreferences.Editor editor = sp.edit();
        editor.clear();
        editor.putString("customerType", customerType);
        editor.commit();
    }

    public static String getCustomerType(Context context) {
        Context ctx = context;
        SharedPreferences sp = ctx.getSharedPreferences(CUSTOMER_TYPE, 0);
        String id = sp.getString("customerType", "");
        return id;
    }
    public static  void clearCustomerType(Context context) {
        Context ctx = context;
        SharedPreferences sp = ctx.getSharedPreferences(CUSTOMER_TYPE, 0);
        SharedPreferences.Editor editor = sp.edit();
        editor.clear().commit();
    }
    public static void saveToken(Context context, String token) {
        SharedPreferences sp = context.getSharedPreferences(TOKEN, 0);
        SharedPreferences.Editor editor = sp.edit();
        editor.clear();
        editor.putString("token", token);
        editor.commit();
    }

    public static String getToken(Context context) {
        Context ctx = context;
        SharedPreferences sp = ctx.getSharedPreferences(TOKEN, 0);
        String name = sp.getString("token", "");
        return name;
    }
    public static void clearToken(Context context) {
        Context ctx = context;
        SharedPreferences sp = ctx.getSharedPreferences(TOKEN, 0);
        SharedPreferences.Editor editor = sp.edit();
        editor.clear().commit();
    }
    public static String getMobile(Context context) {
        Context ctx = context;
        SharedPreferences sp = ctx.getSharedPreferences(MOBILE, 0);
        String id = sp.getString("mobile", "");
        return id;
    }


    public static void saveMobile(Context context, String mobile) {
        SharedPreferences sp = context.getSharedPreferences(MOBILE, 0);
        SharedPreferences.Editor editor = sp.edit();
        editor.clear();
        editor.putString("mobile", mobile);
        editor.commit();
    }
    public static void clearMobile(Context context) {
        Context ctx = context;
        SharedPreferences sp = ctx.getSharedPreferences(MOBILE, 0);
        SharedPreferences.Editor editor = sp.edit();
        editor.clear().commit();
    }

    public static void saveTransactionAccountId(Context context, String id) {
        SharedPreferences sp = context.getSharedPreferences(TRANSACTION_ACCOUNT_ID, 0);
        SharedPreferences.Editor editor = sp.edit();
        editor.clear();
        editor.putString("transactionAccountId", id);
        editor.commit();
    }

    public static String geTransactionAccountId(Context context) {
        Context ctx = context;
        SharedPreferences sp = ctx.getSharedPreferences(TRANSACTION_ACCOUNT_ID, 0);
        String id = sp.getString("transactionAccountId", "");
        return id;
    }
    public static  void clearTransactionAccountId(Context context) {
        Context ctx = context;
        SharedPreferences sp = ctx.getSharedPreferences(TRANSACTION_ACCOUNT_ID, 0);
        SharedPreferences.Editor editor = sp.edit();
        editor.clear().commit();
    }

    public static void saveConfirmStr(Context context, String confirmStr) {
        SharedPreferences sp = context.getSharedPreferences(CONFIRMSTR, 0);
        SharedPreferences.Editor editor = sp.edit();
        editor.clear();
        editor.putString("confirmStr", confirmStr);
        editor.commit();
    }

    public static String getConfirmStr(Context context) {
        Context ctx = context;
        SharedPreferences sp = ctx.getSharedPreferences(CONFIRMSTR, 0);
        String confirmStr = sp.getString("confirmStr", "");
        return confirmStr;
    }
    public static  void clearConfirmStr(Context context) {
        Context ctx = context;
        SharedPreferences sp = ctx.getSharedPreferences(CONFIRMSTR, 0);
        SharedPreferences.Editor editor = sp.edit();
        editor.clear().commit();
    }


    public static void saveGroupType(Context context, String customerType) {
        SharedPreferences sp = context.getSharedPreferences(GROUP_TYPE, 0);
        SharedPreferences.Editor editor = sp.edit();
        editor.clear();
        editor.putString("groupType", customerType);
        editor.commit();
    }

    public static String getGroupType(Context context) {
        Context ctx = context;
        SharedPreferences sp = ctx.getSharedPreferences(GROUP_TYPE, 0);
        String id = sp.getString("groupType", "");
        return id;
    }
    public static  void clearGroupType(Context context) {
        Context ctx = context;
        SharedPreferences sp = ctx.getSharedPreferences(GROUP_TYPE, 0);
        SharedPreferences.Editor editor = sp.edit();
        editor.clear().commit();
    }

    public static  void clearSwitchState(Context context) {
        Context ctx = context;
        SharedPreferences sp = ctx.getSharedPreferences(SWITCH_STATE, 0);
        SharedPreferences.Editor editor = sp.edit();
        editor.clear().commit();
    }


    //加密key
    public static void saveKey(Context context, String key) {
        SharedPreferences sp = context.getSharedPreferences(KEY, 0);
        SharedPreferences.Editor editor = sp.edit();
        editor.clear();
        editor.putString("key", key);
        editor.commit();
    }
    public static String getKey(Context context) {
        Context ctx = context;
        SharedPreferences sp = ctx.getSharedPreferences(KEY, 0);
        String name = sp.getString("key", "");
        return name;
    }
    public static  void clearKey(Context context) {
        Context ctx = context;
        SharedPreferences sp = ctx.getSharedPreferences(KEY, 0);
        SharedPreferences.Editor editor = sp.edit();
        editor.clear().commit();
    }


    public static void saveUrl(Context context, String url) {
        SharedPreferences sp = context.getSharedPreferences(URL, 0);
        SharedPreferences.Editor editor = sp.edit();
        editor.clear();
        editor.putString("url", url);
        editor.commit();
    }

    public static String getUrl(Context context) {
        Context ctx = context;
        SharedPreferences sp = ctx.getSharedPreferences(URL, 0);
        String id = sp.getString("url", "");
        return id;
    }
    public static  void clearUrl(Context context) {
        Context ctx = context;
        SharedPreferences sp = ctx.getSharedPreferences(URL, 0);
        SharedPreferences.Editor editor = sp.edit();
        editor.clear().commit();
    }


//    private static String SHAREFERENCES ="NP";
//
//    /**
//     * SharedPreferences存储在sd卡中的文件名字
//     */
//    private static String getSpName(Context context) {
//        return SHAREFERENCES;
//    }
//
//    /**
//     * 保存数据的方法，我们需要拿到保存数据的具体类型，然后根据类型调用不同的保存方法
//     */
//    public static void putAndApply(Context context, String key, Object object) {
//        SharedPreferences sp = context.getSharedPreferences(getSpName(context), Context.MODE_PRIVATE);
//        SharedPreferences.Editor editor = sp.edit();
//
//        if (object instanceof String) {
//            editor.putString(key, (String) object);
//        } else if (object instanceof Integer) {
//            editor.putInt(key, (Integer) object);
//        } else if (object instanceof Boolean) {
//            editor.putBoolean(key, (Boolean) object);
//        } else if (object instanceof Float) {
//            editor.putFloat(key, (Float) object);
//        } else if (object instanceof Long) {
//            editor.putLong(key, (Long) object);
//        } else {
//            editor.putString(key, object.toString());
//        }
//
//        SharedPreferencesCompat.apply(editor);
//    }
//
//    /**
//     * 得到保存数据的方法，我们根据默认值得到保存的数据的具体类型，然后调用相对于的方法获取值
//     */
//    public static Object get(Context context, String key, Object defaultObject) {
//        SharedPreferences sp = context.getSharedPreferences(getSpName(context), Context.MODE_PRIVATE);
//
//        if (defaultObject instanceof String) {
//            return sp.getString(key, (String) defaultObject);
//        } else if (defaultObject instanceof Integer) {
//            return sp.getInt(key, (Integer) defaultObject);
//        } else if (defaultObject instanceof Boolean) {
//            return sp.getBoolean(key, (Boolean) defaultObject);
//        } else if (defaultObject instanceof Float) {
//            return sp.getFloat(key, (Float) defaultObject);
//        } else if (defaultObject instanceof Long) {
//            return sp.getLong(key, (Long) defaultObject);
//        } else {
//            return null;
//        }
//    }
//
//    /**
//     * 创建一个解决SharedPreferencesCompat.apply方法的一个兼容类
//     *
//     * @author zhy
//     */
//    private static class SharedPreferencesCompat {
//
//        private static final Method sApplyMethod = findApplyMethod();
//
//        /**
//         * 反射查找apply的方法
//         */
//        @SuppressWarnings({"unchecked", "rawtypes"})
//        private static Method findApplyMethod() {
//            try {
//                Class clz = SharedPreferences.Editor.class;
//                return clz.getMethod("apply");
//            } catch (NoSuchMethodException e) {
//            }
//
//            return null;
//        }
//
//        /**
//         * 如果找到则使用apply执行，否则使用commit
//         */
//        public static void apply(SharedPreferences.Editor editor) {
//            try {
//                if (sApplyMethod != null) {
//                    sApplyMethod.invoke(editor);
//                    return;
//                }
//            } catch (IllegalArgumentException expected) {
//            } catch (IllegalAccessException expected) {
//            } catch (InvocationTargetException expected) {
//            }
//            editor.commit();
//        }
//    }
}