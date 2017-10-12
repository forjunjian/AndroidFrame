package com.forjun.testdemo;


import com.forjun.frame.base.ui.activity.BaseKKTestActivity;
import com.forjun.testdemo.base.ui.activity.BaseUiActivityLevelActivity;
import com.forjun.testdemo.base.ui.activity.ShowBaseActivity;
import com.forjun.testdemo.utils.UtilsLevelActivity;

public class AllLevelActivity extends BaseKKTestActivity {

    @Override
    protected DemoInfo[] getDemos() {
        return new DemoInfo[]{
                new DemoInfo("base#activity", null, BaseUiActivityLevelActivity.class),
                new DemoInfo("base#adapter", null, ShowBaseActivity.class),
                new DemoInfo("utils", null, UtilsLevelActivity.class)
        };
    }

}
