package com.forjun.testdemo.base.ui.activity;

import com.forjun.frame.base.ui.activity.BaseKKTestActivity;

/**
 * Created by Administrator on 2017/10/12.
 */

public class BaseUiActivityLevelActivity extends BaseKKTestActivity {
    @Override
    protected DemoInfo[] getDemos() {
        return new DemoInfo[]{
                new DemoInfo("baseActivity例子", null, ShowBaseActivity.class),
                new DemoInfo("快速测试activity例子", null, ShowKKTestActivity.class),
                new DemoInfo("activity#刷新页面的例子", null, ShowRefreshActivity.class),
                new DemoInfo("activity#上拉加载更多", null, ShowPullToRefreshActivity.class)
        };
    }
}
