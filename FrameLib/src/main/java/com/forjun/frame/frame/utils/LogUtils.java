package com.forjun.frame.frame.utils;

import android.util.Log;

/**
 * 吐司工具类
 */
public class LogUtils {
    private static final boolean flag = true;
    private static LogUtils instance;

    public static void d(String TAG, String msg) {
        if(flag){
            Log.i(TAG, msg);
        }
    }

    public static void i(String TAG, String msg) {
        if(flag){
            Log.i(TAG, msg);
        }
    }

    public static void e(String TAG, String msg) {
        if(flag){
            Log.i(TAG, msg);
        }
    }

}
