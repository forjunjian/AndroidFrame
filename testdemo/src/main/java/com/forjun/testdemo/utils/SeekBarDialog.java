package com.forjun.testdemo.utils;

import android.app.AlertDialog;
import android.content.Context;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

import com.forjun.testdemo.R;

import java.text.DecimalFormat;

/**
 * Created by Administrator on 2017/10/9.
 */

public class SeekBarDialog extends AlertDialog {

    private TextView tv_dialog_seek_bar;
    private SeekBar sb_dialog_seek_bar;
    private Button btn_dialog_seek_bar;

    protected SeekBarDialog(Context context) {
        super(context);
        setContentView(R.layout.dialog_seek_bar);
        tv_dialog_seek_bar = (TextView) findViewById(R.id.tv_dialog_seek_bar);
        sb_dialog_seek_bar = (SeekBar) findViewById(R.id.sb_dialog_seek_bar);
        btn_dialog_seek_bar = (Button) findViewById(R.id.btn_dialog_seek_bar);


        sb_dialog_seek_bar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                DecimalFormat decimalFormat = new DecimalFormat("#0.00");
                tv_dialog_seek_bar.setText(decimalFormat.format(progress / 100d) + "%");
                if (mListener != null) {
                    mListener.onProgressChanged(seekBar, progress, fromUser);
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                if (mListener != null) {
                    mListener.onStartTrackingTouch(seekBar);
                }
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                if (mListener != null) {
                    mListener.onStopTrackingTouch(seekBar);
                }
            }
        });

        btn_dialog_seek_bar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mListener != null) {
                    mListener.onConfirm(getSeekBarProgress());
                }
                dismiss();
            }
        });

    }

    private OnSeekDialogListener mListener;

    public float getSeekBarProgress() {
        return sb_dialog_seek_bar.getProgress() / 100f;
    }

    public interface OnSeekDialogListener extends SeekBar.OnSeekBarChangeListener {
        void onConfirm(float progress);
    }

    public void setListener(OnSeekDialogListener listener) {
        mListener = listener;
    }
}
