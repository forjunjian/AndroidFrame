package com.forjun.frame.frame.testframe;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.forjun.frame.R;


/**
 * 快速测试的框架
 * <p>主要是RecycleView的一个列表，当点击条目后会跳转到一个新的Activity。包含Title和描述</p>
 * <p>需要子类实现 {@link #getDemos()}</p>
 */
public abstract class BaseKKTestActivity extends BaseActivity {
    private static final String TAG = BaseKKTestActivity.class.getSimpleName();
    private DemoInfo[] mDEMOS;

    RecyclerView mClvHome;

    @Override
    protected int getResourcesId() {
        return R.layout.activity_base_test;
    }

    @Override
    protected void init() {
        super.init();
        mClvHome = (RecyclerView) findViewById(R.id.clv_base_test);
        mDEMOS = getDemos();
        mClvHome.setHasFixedSize(true);
        mClvHome.setLayoutManager(new LinearLayoutManager(mContext));
        mClvHome.setAdapter(new DemoListAdapter());

    }

    protected abstract DemoInfo[] getDemos();

    private  class DemoListAdapter extends RecyclerView.Adapter<ContainViewHolder>{

        @Override
        public ContainViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View inflate = LayoutInflater.from(mContext).inflate(R.layout.demo_info_item, parent, false);
            ContainViewHolder holder = new ContainViewHolder(inflate);
            return holder;
        }

        @Override
        public void onBindViewHolder(ContainViewHolder holder, int position) {
            holder.bindView(mDEMOS[position]);
        }

        @Override
        public int getItemCount() {
            return mDEMOS.length;
        }
    }

    class ContainViewHolder extends RecyclerView.ViewHolder {
        View rootView;
        TextView mTitle;
        TextView mDesc;

        public ContainViewHolder(View itemView) {
            super(itemView);
            rootView = itemView;
            mTitle = (TextView) itemView.findViewById(R.id.item_test_base_title);
            mDesc = (TextView) itemView.findViewById(R.id.item_test_base_desc);
        }

        public void bindView(final DemoInfo info){
            mTitle.setText(info.title);
            mDesc.setText(info.desc);
            rootView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(mContext, info.demoClass);
                    mContext.startActivity(intent);
                }
            });
        }
    }




    /**
     * item的信息结构
     */
    public static class DemoInfo {
        /** 点击Item跳转的View*/
        final Class<? extends Activity> demoClass;
        /** 条目的标题 */
        final String title;
        /** 描述 */
        final String desc;


        public DemoInfo(String title, String desc,
                        Class<? extends Activity> demoClass) {
            this.title = title;
            this.desc = desc;
            this.demoClass = demoClass;
        }
    }
}
