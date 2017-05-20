package com.forjun.testdemo.base.adapter;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;

import com.forjun.frame.frame.base.adapter.FootRecycleAdapter;
import com.forjun.frame.frame.base.ui.activity.BaseActivity;
import com.forjun.testdemo.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 黄骏健 on 2017/5/20.
 */

public class FootRecycleViewActivity extends BaseActivity {

    private RecyclerView mRclview;
    private FootRecycleAdapter mAdapter;


    @Override
    protected int getResourcesId() {
        return R.layout.activity_foot_recycle_view;
    }

    @Override
    protected void init() {
        super.init();
        initView();
    }

    private void initView() {
        mRclview = (RecyclerView) findViewById(R.id.rclview);
        mRclview.setHasFixedSize(true);
        mRclview.setLayoutManager(new LinearLayoutManager(this));
        mAdapter = new FootRecycleAdapter(this);
        mAdapter.setNormalDataList(getTestNormalData());
        mRclview.setAdapter(mAdapter);
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.test_recycle_with_foot, menu);
        return true;
    }

    /**
     * 测试代码
     * @param item
     * @return
     */
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.foot_recycle_remove:
                mAdapter.setFootViewData(null);
                mAdapter.notifyDataSetChanged();
                break;
            case R.id.foot_recyle_add:
                mAdapter.setFootViewData("底部有值");
                mAdapter.notifyDataSetChanged();
                break;
        }
        return true;

    }

    /**
     * 测试数据
     * @return
     */
    private List<String> getTestNormalData() {
        List<String> nomalData = new ArrayList<>();
        for (int i = 0; i < 13; i++) {
            nomalData.add("position"+i);
        }
        return nomalData;
    }
}
