package com.forjun.testdemo.utils;

import com.forjun.frame.base.ui.activity.BaseKKTestActivity;
import com.forjun.frame.utils.LogUtil;
import com.forjun.frame.utils.ScreenUtils;

/**
 * Created by Administrator on 2017/10/9.
 */

public class ShowScreenUtilsActivity extends BaseKKTestActivity {

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
                new DemoInfo("设置当前activity屏幕亮度", null) {
                    @Override
                    protected void onItemClick() {
                        SeekBarDialog seekBarDialog = new SeekBarDialog(mContext);
                        float brightness = ScreenUtils.getWindowBrightness(mContext);

                        seekBarDialog.setSeekBarProgress(brightness);
                        LogUtil.e(TAG, "windowBrightness =  " + brightness);
                        seekBarDialog.setListener(new SeekBarDialog.OnSeekDialogListener() {
                            @Override
                            public void onProgressChanged(float progress) {

                            }

                            @Override
                            public void onStartTrackingTouch(float progress) {

                            }

                            @Override
                            public void onStopTrackingTouch(float progress) {
                                ScreenUtils.setWindowBrightness(mContext, progress);
                            }

                            @Override
                            public void onConfirm(float progress) {
                                ScreenUtils.setWindowBrightness(mContext, progress);
                            }
                        });
                        seekBarDialog.show();

                    }
                },
                new DemoInfo("设置系统屏幕亮度",
                        "1.如果设置过window的亮度的话，会在这个window中看不到效果，除非window中的信息亮度为-1；\r\n" +
                                "2.华为（M2-A01L）这坑爹货，居然设置后，系统设置那里显示居然不是实时同步！\r\n" +
                                "3.kpos的系统没有这provider,导致部分系统失效，坑爹啊！") {

                    @Override
                    protected void onItemClick() {
                        SeekBarDialog seekBarDialog = new SeekBarDialog(mContext);

                        float brightness = ScreenUtils.getSystemBrightness(mContext) / 255f;
                        seekBarDialog.setSeekBarProgress(brightness);

                        LogUtil.e(TAG, "SystemBrightness =  " + brightness);
                        seekBarDialog.setListener(new SeekBarDialog.OnSeekDialogListener() {
                            @Override
                            public void onProgressChanged(float progress) {

                            }

                            @Override
                            public void onStartTrackingTouch(float progress) {

                            }

                            @Override
                            public void onStopTrackingTouch(float progress) {
                                ScreenUtils.setSystemBrightness(mContext, (int) (progress * 255));
                            }

                            @Override
                            public void onConfirm(float progress) {
                                ScreenUtils.setSystemBrightness(mContext, (int) (progress * 255));
                            }
                        });
                        seekBarDialog.show();
                    }
                }

        };
    }
}
