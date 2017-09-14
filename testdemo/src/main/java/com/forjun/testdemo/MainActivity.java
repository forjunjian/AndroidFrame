package com.forjun.testdemo;

import android.os.Binder;

import com.forjun.frame.base.ui.activity.BaseKKJumpActivity;
import com.forjun.testdemo.base.adapter.FootRecycleViewActivity;
import com.forjun.testdemo.base.ui.activity.ShowKKTestActivity;

public class MainActivity extends BaseKKJumpActivity {

    @Override
    protected DemoInfo[] getDemos() {
        Binder binder = new Binder();

        return new DemoInfo[]{
            new DemoInfo( "ShowKKTestActivity", "显示并测试BaseActivity功能", ShowKKTestActivity.class ),
            new DemoInfo( "title", "decs", DemoHucActivity.class ),
            new DemoInfo( "FootRecycleViewActivity", "", FootRecycleViewActivity.class )
        };
    }

}
