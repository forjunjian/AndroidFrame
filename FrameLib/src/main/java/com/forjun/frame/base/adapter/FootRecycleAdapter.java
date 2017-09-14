package com.forjun.frame.base.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 黄骏健 on 2017/5/20.
 */

public class FootRecycleAdapter extends RecyclerView.Adapter {
    private static final String TAG = "FootRecycleAdapter";

    Context mContext;

    List<String> mNormalDataList = new ArrayList<>();
    String mFootItemData = "最后一行的数据";

    private  static final int TYPE_NORMAL = 0;
    private  static final int TYPE_FOOT = 1;

    public FootRecycleAdapter(Context context) {
        mContext = context;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        switch (viewType){
            case TYPE_NORMAL:
                TextView normalView = new TextView(mContext);
                return  new NormalViewHolder(normalView);
            case TYPE_FOOT:
                TextView footview = new TextView(mContext);
                return  new FootViewHolder(footview);
        }
        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        Log.d(TAG, "onBindViewHolder: "+position);
        if(position< mNormalDataList.size()){
            NormalViewHolder normalViewHolder = (NormalViewHolder) holder;
            normalViewHolder.bindData(mNormalDataList.get(position));
        }else{
            FootViewHolder footViewHolder = (FootViewHolder) holder;
            footViewHolder.bindData(mFootItemData);
        }

    }


    @Override
    public int getItemCount() {

        int count = 0;
        if(mFootItemData == null){
            count =  mNormalDataList.size();
        }else{
            count = mNormalDataList.size()+1;
        }
        Log.d(TAG, "getItemCount: "+count);
        return count;
    }

    @Override
    public int getItemViewType(int position) {
        Log.d(TAG, "getItemViewType: "+position);
        if(position < mNormalDataList.size()){
            return TYPE_NORMAL;
        }
        return TYPE_FOOT;
    }

    /**
     * 如果footViewData 为空 则不显示最后一列
     * @param footViewData
     */
    public void setFootViewData(String footViewData){
        mFootItemData = footViewData;
    }

    /**
     * 设置正常数据的列
     * @param normalDataList
     */
    public void setNormalDataList(List<String> normalDataList){
        mNormalDataList.clear();
        mNormalDataList.addAll(normalDataList);
    }

    /**
     * 最后一行
     */
    private static class FootViewHolder extends RecyclerView.ViewHolder {
        TextView mTitle;
        public FootViewHolder(View itemView) {
            super(itemView);
            mTitle = (TextView) itemView;
        }
        public void bindData(String title){
            mTitle.setText(title);
        }
    }

    /**
     * 正常数据
     */
    private static class NormalViewHolder extends RecyclerView.ViewHolder {
        TextView mTitle;
        public NormalViewHolder(View itemView) {
            super(itemView);
            mTitle = (TextView) itemView;
        }
        public void bindData(String title){
            mTitle.setText(title);
        }
    }
}
