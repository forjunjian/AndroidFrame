package com.forjun.frame;

import com.forjun.frame.example.DemoHucActivity;
import com.forjun.learn.frame.testframe.BaseKKTestActivity;

/**
 * demo例子
 */
public class HomeActivity extends BaseKKTestActivity {
    @Override
    protected DemoInfo[] getDemos() {
        return new DemoInfo[]{
                new DemoInfo("title","decs", DemoHucActivity.class),
                new DemoInfo("title","decs", DemoHucActivity.class)
        }
       ;
    }
}
