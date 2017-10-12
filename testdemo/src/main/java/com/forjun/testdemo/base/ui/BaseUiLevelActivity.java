package com.forjun.testdemo.base.ui;

import com.forjun.frame.base.ui.activity.BaseKKTestActivity;
import com.forjun.testdemo.base.ui.activity.BaseUiActivityLevelActivity;

/**
 * Created by Administrator on 2017/10/12.
 */

public class BaseUiLevelActivity extends BaseKKTestActivity {
    @Override
    protected DemoInfo[] getDemos() {
        return new DemoInfo[]{
                new DemoInfo("activity的例子", null, BaseUiActivityLevelActivity.class)
        };
    }
}
