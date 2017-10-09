package com.forjun.frame.utils;

import android.widget.Toast;

import com.forjun.frame.base.BaseApplication;

/**
 * Created by 黄骏健 on 2017/7/28.
 */

public class ToastUtil {

	private static Toast mToast;


	private static void instanceIsEmpty() {
		if ( mToast == null ) {
			synchronized ( ToastUtil.class ) {
				if ( mToast == null ) {
					mToast = new Toast( BaseApplication.getApplication() );
				}
			}

		}
	}


	public static final void show(String msg) {
		instanceIsEmpty();
		mToast.setText( msg );
		mToast.setDuration( Toast.LENGTH_SHORT );
		mToast.show();
	}

	public static final void show(int msg) {
		instanceIsEmpty();
		mToast.setText( msg );
		mToast.setDuration( Toast.LENGTH_SHORT );
		mToast.show();
	}

	public static final void showL(String msg) {
		instanceIsEmpty();
		mToast.setText( msg );
		mToast.setDuration( Toast.LENGTH_LONG );
		mToast.show();
	}

	public static final void showL(int msg) {
		instanceIsEmpty();
		mToast.setText( msg );
		mToast.setDuration( Toast.LENGTH_LONG );
		mToast.show();
	}

	public static final void cancel() {
		if ( mToast != null ) {
			mToast.cancel();
		}
	}

}
