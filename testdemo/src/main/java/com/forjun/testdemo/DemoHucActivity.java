package com.forjun.testdemo;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.forjun.frame.base.ui.activity.BaseActivity;

/**
 * Created by 黄骏健 on 2017/5/14.
 */
public class DemoHucActivity extends BaseActivity {

	private ListView             lv_container;
	private BaseAdapter          mLocalAdapter;
	private RecyclerView         rv_container;
	private RecyclerView.Adapter mLocalRvAdapter;

    @Override
    protected int getResourcesId() {
        return R.layout.activity_demo;
    }


	@Override
	protected void initView() {
		lv_container = ( ListView ) findViewById( R.id.lv_container );
		mLocalAdapter = new LocalLvAdapter();
		lv_container.setAdapter( mLocalAdapter );

		rv_container = ( RecyclerView ) findViewById( R.id.rv_container );
		rv_container.setLayoutManager( new LinearLayoutManager( mContext, LinearLayoutManager.HORIZONTAL, false ) );
		mLocalRvAdapter = new LocalRvAdapter();
		rv_container.setAdapter( mLocalRvAdapter );

	}

	class LocalRvAdapter extends RecyclerView.Adapter {

		@Override
		public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
			View         view   = View.inflate( mContext, R.layout.wiget_demo, null );
			RvViewHolder holder = new RvViewHolder( view );
			return holder;
		}

		@Override
		public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
			RvViewHolder rvHolder = ( RvViewHolder ) holder;
			rvHolder.onBindViewholder( position );
		}

		@Override
		public int getItemCount() {
			return 100;
		}
	}


	class RvViewHolder extends RecyclerView.ViewHolder {

		private TextView mTextView;

		public RvViewHolder(View itemView) {
			super( itemView );
			mTextView = ( TextView ) itemView.findViewById( R.id.tv_item );
		}

		public void onBindViewholder(int position) {
			mTextView.setText( "somthing" + position );

		}
	}


	class LocalLvAdapter extends BaseAdapter {

		@Override
		public int getCount() {
			return 100;
		}

		@Override
		public String getItem(int position) {
			return "something";
		}

		@Override
		public long getItemId(int position) {
			return position;
		}

		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			ViewHolder holder = null;
			if ( convertView == null ) {
				convertView = View.inflate( mContext, R.layout.wiget_demo, null );

				holder = new ViewHolder();
				holder.mTv = ( TextView ) convertView.findViewById( R.id.tv_item );
				convertView.setTag( holder );
			} else {
				holder = ( ViewHolder ) convertView.getTag();
			}
			String item = getItem( position );
			holder.mTv.setText( item );

			return convertView;
		}
	}


	private static class ViewHolder {

		TextView mTv;
	}
}
