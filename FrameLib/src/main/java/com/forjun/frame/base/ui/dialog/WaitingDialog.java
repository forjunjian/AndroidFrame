package com.forjun.frame.base.ui.dialog;

import android.app.ProgressDialog;
import android.content.Context;

/**
 * Created by 黄骏健 on 2017/7/30.
 */

public class WaitingDialog extends ProgressDialog {


	private String mTitle;
	private String mSubHead;

	public WaitingDialog(Context context) {
		this( context, null, null );
	}

	public WaitingDialog(Context context, String msg) {
		this( context, msg, null );
	}

	public WaitingDialog(Context context, String title, String subHead) {
		super( context );
		mTitle = title;
		mSubHead = subHead;
		setCancelable( false );
	}
}
