package com.forjun.testdemo;

import android.os.Binder;

import com.forjun.frame.base.ui.activity.BaseKKTestActivity;
import com.forjun.testdemo.base.adapter.FootRecycleViewActivity;
import com.forjun.testdemo.base.ui.activity.ShowKKTestActivity;
import com.forjun.testdemo.utils.ScreenUtilsActivity;

public class MainActivity extends BaseKKTestActivity {

    @Override
    protected DemoInfo[] getDemos() {
        Binder binder = new Binder();

        return new DemoInfo[]{
                new DemoInfo("ShowKKTestActivity", "显示并测试BaseActivity功能", ShowKKTestActivity.class),
                new DemoInfo("title", "decs", DemoHucActivity.class),
                new DemoInfo("title", "decs") {
                    @Override
                    protected void onItemClick() {
                        // 条目被点击了
                    }
                },
                new DemoInfo("FootRecycleViewActivity", "", FootRecycleViewActivity.class),
                new DemoInfo(null, "测试Utils包下的应用", ScreenUtilsActivity.class)
        };
    }

}
