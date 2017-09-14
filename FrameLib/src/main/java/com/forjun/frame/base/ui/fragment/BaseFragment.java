package com.forjun.frame.base.ui.fragment;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.forjun.frame.app.BaseApplication;
import com.forjun.frame.base.ui.DialogInterface;
import com.forjun.frame.base.ui.ToastInterface;
import com.forjun.frame.base.ui.WaitingDialogInterface;
import com.forjun.frame.base.ui.dialog.WaitingDialog;
import com.forjun.frame.utils.LogUtil;
import com.forjun.frame.utils.ToastUtil;
import com.umeng.analytics.MobclickAgent;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by forjun on 2017/9/14.
 */

public abstract class BaseFragment extends Fragment implements ToastInterface, WaitingDialogInterface {

	protected static String  TAG;
	protected        View    mRootView;
	protected        Context mContext;
	Unbinder unbinder;
	/* #################### 扩展封装 开始 ####################*/
	private WaitingDialog mWatingFragment;

	/**
	 * 获取界面资源id
	 *
	 * @return
	 */
	protected abstract int getLayoutResId();

	/**
	 * 初始化
	 */
	protected void init() {
		initView();
		initData();
		initListener();
	}

	protected abstract void initView();

	protected void initListener() {
	}

	protected void initData() {
	}

	/* ~~~~~~~~~~~~~~~~~~~~  扩展封装 结束 ~~~~~~~~~~~~~~~~~~~~*/
	/* #################### 用户提示 开始 #################### */
	@Override
	public void showToast(String msg) {
		ToastUtil.show( msg );
	}

	@Override
	public void showToast(int resId) {
		ToastUtil.show( resId );
	}

	@Override
	public void dismissToast() {
		ToastUtil.cancel();
	}

	@Override
	public void showWaitingDialog() {
		mWatingFragment = new WaitingDialog( mContext );
		mWatingFragment.setCancelable( true );
		mWatingFragment.show();
	}

	@Override
	public void showWaitingDialog(String msg) {
		mWatingFragment = new WaitingDialog( mContext );
		mWatingFragment.setCancelable( true );
		mWatingFragment.show();
	}


	@Override
	public void dismissDialog() {
		if ( mWatingFragment != null ) {
			mWatingFragment.dismiss();
			mWatingFragment = null;
		}
	}

    /* ~~~~~~~~~~~~~~~~~~~~ 用户提示 结束 ~~~~~~~~~~~~~~~~~~~~*/


	/* #################### 监听生命周期 开始 #################### */
	@Override
	public void onAttach(Activity activity) {
		super.onAttach( activity );
		TAG = this.getClass().getSimpleName();
		mContext = activity;
		if ( LogUtil.lifeCycle ) {
			LogUtil.d( TAG, TAG + " onAttach() invoked." );
		}
	}

	@Override
	public void onDetach() {
		if ( LogUtil.lifeCycle ) {
			LogUtil.d( TAG, TAG + " onDetach() invoked." );
		}
		super.onDetach();
	}


	@Nullable
	@Override
	public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
		mRootView = inflater.inflate( getLayoutResId(), null );
		unbinder = ButterKnife.bind( this, mRootView );
		return mRootView;
	}


	@Override
	public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
		super.onViewCreated( view, savedInstanceState );
		if ( LogUtil.lifeCycle ) {
			LogUtil.d( TAG, TAG + " onViewCreated() invoked." );
		}
		init();

	}


	@Override
	public void onCreate(Bundle savedInstanceState) {
		if ( LogUtil.lifeCycle ) {
			LogUtil.d( TAG, TAG + " onCreate() invoked." );
		}
		super.onCreate( savedInstanceState );

	}


	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		if ( LogUtil.lifeCycle ) {
			LogUtil.d( TAG, TAG + " onActivityCreated() invoked." );
		}
		super.onActivityCreated( savedInstanceState );
	}

	@Override
	public void onDestroy() {
		if ( LogUtil.lifeCycle ) {
			LogUtil.d( TAG, TAG + " onDestroy() invoked." );
		}
		super.onDestroy();
	}

	@Override
	public void onDestroyView() {
		if ( LogUtil.lifeCycle ) {
			LogUtil.d( TAG, TAG + " onDestroyView() invoked." );
		}
		super.onDestroyView();
		unbinder.unbind();
	}


	@Override
	public void onResume() {
		if ( LogUtil.lifeCycle ) {
			LogUtil.d( TAG, TAG + " onResume() invoked." );
		}
		super.onResume();
		MobclickAgent.onPageStart( TAG ); // 友盟统计#页面跳转统计
	}

	@Override
	public void onPause() {
		if ( LogUtil.lifeCycle ) {
			LogUtil.d( TAG, TAG + " onPause() invoked." );
		}
		super.onPause();
		MobclickAgent.onPageEnd( TAG ); // 友盟统计#页面跳转统计
	}

	@Override
	public void onStart() {
		if ( LogUtil.lifeCycle ) {
			LogUtil.d( TAG, TAG + " onStart() invoked." );
		}
		super.onStart();

	}

	@Override
	public void onStop() {
		if ( LogUtil.lifeCycle ) {
			LogUtil.d( TAG, TAG + " onStop() invoked." );
		}
		super.onStop();
	}


	/* ~~~~~~~~~~~~~~~~~~~~ 监听生命周期 结束 ~~~~~~~~~~~~~~~~~~~~*/

}
