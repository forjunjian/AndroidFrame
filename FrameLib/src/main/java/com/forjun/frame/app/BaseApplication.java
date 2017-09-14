package com.forjun.frame.app;

import android.app.Application;
import android.content.Context;
import android.content.pm.ApplicationInfo;

/**
 * Created by 黄骏健 on 2017/7/30.
 */

public class BaseApplication extends Application {

	public static boolean isDebug = true;

	private static BaseApplication instance;

	public static BaseApplication getApplication() {
		return instance;
	}


	@Override
	public void onCreate() {
		super.onCreate();
		instance = this;
		isDebug = isApkDebugAble( this );
	}

	/**
	 * 是否debug模式
	 * <p>1.其值就取决于ant的打包参数是release还是debug.
	 * <p>2.AndroidManifest.xml中设置其debug.<pre>   {@code
	 *     <application android:debuggable="true" tools:ignore="HardcodedDebugMode"
	 *      ....
	 *      .... />}<pre><br/>
	 * <p>
	 * <p>因此在AndroidManifest.xml中最好不设置android:debuggable属性置，而是由打包方式来决定其值.
	 */
	public static boolean isApkDebugAble(Context context) {
		try {
			ApplicationInfo info = context.getApplicationInfo();
			return ( info.flags & ApplicationInfo.FLAG_DEBUGGABLE ) != 0;
		} catch ( Exception e ) {

		}
		return false;
	}
}
