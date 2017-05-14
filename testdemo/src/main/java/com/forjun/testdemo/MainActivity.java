package com.forjun.testdemo;

import com.forjun.frame.frame.testframe.BaseKKTestActivity;

public class MainActivity extends BaseKKTestActivity {
    @Override
    protected DemoInfo[] getDemos() {
        return new DemoInfo[]{
                new DemoInfo("title","decs", DemoHucActivity.class),
                new DemoInfo("title","decs", DemoHucActivity.class)
        };
    }
}
