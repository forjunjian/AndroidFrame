package com.forjun.testdemo.utils;

import android.app.AlertDialog;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.StyleRes;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

import com.forjun.frame.utils.LogUtil;
import com.forjun.testdemo.R;

import java.text.DecimalFormat;

/**
 * seekBarDialog
 * Created by Administrator on 2017/10/9.
 */

public class SeekBarDialog extends AlertDialog {
    private static final String TAG = "SeekBarDialog";

    private TextView tv_dialog_seek_bar;
    private SeekBar sb_dialog_seek_bar;
    private Button btn_dialog_seek_bar;

    private float progress = 0f;
    DecimalFormat decimalFormat = new DecimalFormat("#0");

    protected SeekBarDialog(Context context) {
        this(context, R.style.custom_style_dialog_transparent);
    }

    public SeekBarDialog(Context context, @StyleRes int themeResId) {
        super(context, themeResId);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dialog_seek_bar);
        tv_dialog_seek_bar = (TextView) findViewById(R.id.tv_dialog_seek_bar);
        sb_dialog_seek_bar = (SeekBar) findViewById(R.id.sb_dialog_seek_bar);
        btn_dialog_seek_bar = (Button) findViewById(R.id.btn_dialog_seek_bar);

        setLocalProgress();
        sb_dialog_seek_bar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

                int seekBarProgress = seekBar.getProgress();
                tv_dialog_seek_bar.setText(decimalFormat.format(seekBarProgress) + "%");

                float floatSeekProgress = seekBarProgress / 100f;
                LogUtil.e(TAG, "onProgressChanged()#seekBarProgress = " + floatSeekProgress);
                if (mListener != null) {
                    mListener.onProgressChanged(floatSeekProgress);
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                int seekBarProgress = seekBar.getProgress();
                tv_dialog_seek_bar.setText(decimalFormat.format(seekBarProgress) + "%");

                float floatSeekProgress = seekBarProgress / 100f;
                LogUtil.e(TAG, "onStartTrackingTouch()#seekBarProgress = " + floatSeekProgress);
                if (mListener != null) {
                    mListener.onStartTrackingTouch(floatSeekProgress);
                }
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                int seekBarProgress = seekBar.getProgress();
                tv_dialog_seek_bar.setText(decimalFormat.format(seekBarProgress) + "%");

                float floatSeekProgress = seekBarProgress / 100f;
                LogUtil.e(TAG, "onStopTrackingTouch()#seekBarProgress = " + floatSeekProgress);
                if (mListener != null) {
                    mListener.onStopTrackingTouch(floatSeekProgress);
                }
            }
        });

        btn_dialog_seek_bar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int seekBarProgress = sb_dialog_seek_bar.getProgress();
                tv_dialog_seek_bar.setText(decimalFormat.format(seekBarProgress) + "%");

                float floatSeekProgress = seekBarProgress / 100f;
                LogUtil.e(TAG, "onStopTrackingTouch()#seekBarProgress = " + floatSeekProgress);
                if (mListener != null) {
                    mListener.onConfirm(floatSeekProgress);
                }
                dismiss();
            }
        });

    }

    private void setLocalProgress() {
        LogUtil.e(TAG, "onCreate()#progress = " + progress);
        int progressNow = (int) (progress * 100);
        LogUtil.e(TAG, "onCreate()#progressNow = " + progressNow);
        sb_dialog_seek_bar.setProgress(progressNow);
        tv_dialog_seek_bar.setText(decimalFormat.format(progress * 100) + "%");
    }

    private OnSeekDialogListener mListener;

    public void setSeekBarProgress(float progress) {
        this.progress = progress;
        LogUtil.e(TAG, "setSeekBarProgress()#progress =  " + progress);
        if (sb_dialog_seek_bar != null) {
            LogUtil.e(TAG, "setSeekBarProgress()#seekBar ！=null ");
            setLocalProgress();
        } else {
            LogUtil.e(TAG, "setSeekBarProgress()#seekBar 居然为null ");
        }
    }
    public float getSeekBarProgress() {
        if (sb_dialog_seek_bar != null) {
            return sb_dialog_seek_bar.getProgress() / 100f;
        } else {
            return progress;
        }
    }

    public interface OnSeekDialogListener {
        void onProgressChanged(float progress);

        void onStartTrackingTouch(float progress);

        void onStopTrackingTouch(float progress);
        void onConfirm(float progress);
    }

    public void setListener(OnSeekDialogListener listener) {
        mListener = listener;
    }
}
