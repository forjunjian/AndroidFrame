package com.forjun.testdemo.utils;

import android.widget.SeekBar;

import com.forjun.frame.base.ui.activity.BaseKKTestActivity;
import com.forjun.frame.utils.ScreenUtils;

/**
 * Created by Administrator on 2017/10/9.
 */

public class ScreenUtilsActivity extends BaseKKTestActivity {
    @Override
    protected DemoInfo[] getDemos() {

        return new DemoInfo[]{
                new DemoInfo("开启自动调节亮度", null) {
                    @Override
                    protected void onItemClick() {
                        ScreenUtils.startAutoBrightness(mContext);
                    }
                },
                new DemoInfo("关闭自动调节亮度", null) {
                    @Override
                    protected void onItemClick() {
                        ScreenUtils.stopAutoBrightness(mContext);
                    }
                },
                new DemoInfo("设置屏幕亮度", null) {
                    @Override
                    protected void onItemClick() {
                        SeekBarDialog seekBarDialog = new SeekBarDialog(mContext);
                        seekBarDialog.setListener(new SeekBarDialog.OnSeekDialogListener() {
                            @Override
                            public void onConfirm(float progress) {
                                ScreenUtils.setBrightness(mContext, progress);
                            }

                            @Override
                            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                                ScreenUtils.setBrightness(mContext, seekBar.getProgress());
                            }

                            @Override
                            public void onStartTrackingTouch(SeekBar seekBar) {
                                ScreenUtils.setBrightness(mContext, seekBar.getProgress());
                            }

                            @Override
                            public void onStopTrackingTouch(SeekBar seekBar) {
                                ScreenUtils.setBrightness(mContext, seekBar.getProgress());
                            }
                        });
                        seekBarDialog.show();
                    }
                },
                new DemoInfo("永久化屏幕亮度", null) {
                    @Override
                    protected void onItemClick() {
                        SeekBarDialog seekBarDialog = new SeekBarDialog(mContext);
                        seekBarDialog.setListener(new SeekBarDialog.OnSeekDialogListener() {
                            @Override
                            public void onConfirm(float progress) {
                                ScreenUtils.saveBrightness(mContext, progress);
                            }

                            @Override
                            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                                ScreenUtils.saveBrightness(mContext, seekBar.getProgress());
                            }

                            @Override
                            public void onStartTrackingTouch(SeekBar seekBar) {
                                ScreenUtils.saveBrightness(mContext, seekBar.getProgress());
                            }

                            @Override
                            public void onStopTrackingTouch(SeekBar seekBar) {
                                ScreenUtils.saveBrightness(mContext, seekBar.getProgress());
                            }
                        });
                        seekBarDialog.show();
                    }
                }

        };
    }
}
