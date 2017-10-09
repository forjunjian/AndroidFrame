package com.forjun.frame.utils;

import android.app.Activity;
import android.content.ContentResolver;
import android.content.Context;
import android.net.Uri;
import android.provider.Settings;
import android.view.WindowManager;

/**
 * Created by forjun on 2017/10/9.
 */

public class ScreenUtils {

    /**
     * 判断是否开启了自动亮度调节
     */
    public static boolean isAutoBrightness(ContentResolver aContentResolver) {
        boolean automaticBrightness = false;
        try {
            automaticBrightness = Settings.System.getInt(aContentResolver,
                    Settings.System.SCREEN_BRIGHTNESS_MODE) == Settings.System.SCREEN_BRIGHTNESS_MODE_AUTOMATIC;
        } catch (Settings.SettingNotFoundException e) {
            e.printStackTrace();
        }
        return automaticBrightness;
    }

    /**
     * 开启亮度自动调节
     */
    public static void startAutoBrightness(Activity activity) {
        Settings.System.putInt(activity.getContentResolver(),
                Settings.System.SCREEN_BRIGHTNESS_MODE,
                Settings.System.SCREEN_BRIGHTNESS_MODE_AUTOMATIC);
    }

    /**
     * 停止自动亮度调节
     */
    public static void stopAutoBrightness(Activity activity) {
        Settings.System.putInt(activity.getContentResolver(),
                Settings.System.SCREEN_BRIGHTNESS_MODE,
                Settings.System.SCREEN_BRIGHTNESS_MODE_MANUAL);
    }

    /**
     * 获取屏幕的亮度
     */
    public static int getBrightness(Activity activity) {
        int nowBrightnessValue = 0;
        ContentResolver resolver = activity.getContentResolver();
        try {
            nowBrightnessValue = android.provider.Settings.System.getInt(resolver, Settings.System.SCREEN_BRIGHTNESS);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return nowBrightnessValue;
    }

    /**
     * 设置当前Activity的亮度,退出后亮度失效
     * <p>{@link #saveBrightness(Context, float)}为修改系统亮度</p>
     */
    public static void setBrightness(Activity activity, float brightness) {
        // 如果开启自动亮度调节，则会失效
        if (isAutoBrightness(activity.getContentResolver())) {
            //关闭自动亮度调节
            stopAutoBrightness(activity);
        }

        WindowManager.LayoutParams lp = activity.getWindow().getAttributes();
        lp.screenBrightness = brightness;

        activity.getWindow().setAttributes(lp);
    }

    /**
     * 系统保存亮度设置状态
     * <p>{@link #setBrightness(Activity, float)}为对应的activity有作用，退出对应的activity后，亮度失效。</p>
     */
    public static void saveBrightness(Context context, float brightness) {

        Uri uri = android.provider.Settings.System.getUriFor("screen_brightness");
        android.provider.Settings.System.putFloat(context.getContentResolver(), "screen_brightness", brightness);
        context.getContentResolver().notifyChange(uri, null);
    }


}
