package com.forjun.frame.base.ui;

/**
 * Created by 黄骏健 on 2017/7/28.
 */

public interface AleartDialogInterface extends DialogInterface {

	void showAlertDialog(String msg);

	void showAlertDialog(String title, String contentMsg);

	void showAlertDialog(String title, String contentMsg, AleartDialogListener listener);

	void showAlertDialog(String title, String contentMsg, boolean isCancleAble, AleartDialogListener listener);

	interface AleartDialogListener {

		void onCancle();

		void onConfirm();
	}
}
