package com.forjun.frame.utils;

import android.util.Log;

/**
 * 吐司工具类
 */
public class LogUtil {

    private static final boolean flag      = true;
    public static final  boolean lifeCycle = true;
    private static LogUtil instance;

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
