package com.forjun.frame.base.ui.dialog;

import android.app.AlertDialog;
import android.content.Context;

/**
 * Created by Administrator on 2017/10/9.
 */

public class BaseAlertDialog extends AlertDialog {

    protected BaseAlertDialog(Context context) {
        this(context, true, null);

    }

    protected BaseAlertDialog(Context context, boolean cancelable, OnCancelListener cancelListener) {
        super(context, cancelable, cancelListener);

    }
}
