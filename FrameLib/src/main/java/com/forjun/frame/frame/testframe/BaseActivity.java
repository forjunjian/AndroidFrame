package com.forjun.frame.frame.testframe;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by 黄骏健 on 2017/4/27.
 */

public abstract class BaseActivity extends AppCompatActivity {

    protected AppCompatActivity mContext;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContext = this;
        setContentView(getResourcesId());

        init();
    }

    protected  void init(){}

    protected abstract int getResourcesId() ;
}
