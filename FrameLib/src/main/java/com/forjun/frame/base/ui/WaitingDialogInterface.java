package com.forjun.frame.base.ui;

/**
 * Created by 黄骏健 on 2017/7/28.
 */

public interface WaitingDialogInterface extends DialogInterface {

	void showWaitingDialog();

	void showWaitingDialog(String msg);

	void showWaitingDialog(String title, String subHead);
}
