package com.forjun.testdemo.utils;

import com.forjun.frame.base.ui.activity.BaseKKTestActivity;

/**
 * Created by Administrator on 2017/10/12.
 */

public class UtilsLevelActivity extends BaseKKTestActivity {
    @Override
    protected DemoInfo[] getDemos() {
        return new DemoInfo[]{
                new DemoInfo("屏幕相关Util的例子", null, ShowScreenUtilsActivity.class),
        };
    }
}
