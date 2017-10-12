package com.forjun.frame.utils;

import android.content.ContentResolver;
import android.net.Uri;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
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
    public static void startAutoBrightness(AppCompatActivity activity) {
        Settings.System.putInt(activity.getContentResolver(),
                Settings.System.SCREEN_BRIGHTNESS_MODE,
                Settings.System.SCREEN_BRIGHTNESS_MODE_AUTOMATIC);
    }

    /**
     * 停止自动亮度调节
     */
    public static void stopAutoBrightness(AppCompatActivity activity) {
        Settings.System.putInt(activity.getContentResolver(),
                Settings.System.SCREEN_BRIGHTNESS_MODE,
                Settings.System.SCREEN_BRIGHTNESS_MODE_MANUAL);
    }


    /**
     * 获取屏幕的亮度
     */
    public static float getWindowBrightness(AppCompatActivity activity) {
        float brightness = 0f;
        WindowManager.LayoutParams lp = activity.getWindow().getAttributes();

        brightness = lp.screenBrightness;
        if (-1 == brightness) {
            int systemBrightness = getSystemBrightness(activity);
            brightness = systemBrightness / 255f;
        }
        return brightness;
    }

    /**
     * 设置当前Activity的亮度,退出后亮度失效
     * <p>{@link #setSystemBrightness(AppCompatActivity, int)}为修改系统亮度</p>
     */
    public static void setWindowBrightness(AppCompatActivity activity, float brightness) {
        WindowManager.LayoutParams lp = activity.getWindow().getAttributes();
        lp.screenBrightness = brightness;

        activity.getWindow().setAttributes(lp);
    }

    public static int getSystemBrightness(AppCompatActivity activity) {
        int systemBrightness = 0;
        try {
            systemBrightness = Settings.System.getInt(activity.getContentResolver(), Settings.System.SCREEN_BRIGHTNESS);
        } catch (Settings.SettingNotFoundException e) {
            e.printStackTrace();
        }
        return systemBrightness;
    }


    /**
     * 系统保存亮度设置状态,如果设置过windown亮度的值以后，修改系统的亮度会在window中会看不到修改的效果，出去以后才能看到。
     * <p>{@link #setWindowBrightness(AppCompatActivity, float)}为对应的activity有作用，退出对应的activity后，亮度失效。</p>
     */
    public static void setSystemBrightness(AppCompatActivity context, int brightness) {

        // 如果开启自动亮度调节，则会失效
        if (isAutoBrightness(context.getContentResolver())) {
            //关闭自动亮度调节
            stopAutoBrightness(context);
        }

        Uri uri = Settings.System.getUriFor(Settings.System.SCREEN_BRIGHTNESS);
        Settings.System.putInt(context.getContentResolver(), Settings.System.SCREEN_BRIGHTNESS, brightness);
        context.getContentResolver().notifyChange(uri, null);
    }


}
