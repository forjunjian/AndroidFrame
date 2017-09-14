package com.forjun.frame.base.ui;

/**
 * Created by 黄骏健 on 2017/7/28.
 */

public interface ToastInterface {

	void showToast(String msg);

	void showToast(int msg);

	void showToastL(String msg);

	void showToastL(int msg);

	void dismissToast();
}
