package com.forjun.frame.base.ui.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.forjun.frame.base.ui.AleartDialogInterface;
import com.forjun.frame.base.ui.ToastInterface;
import com.forjun.frame.base.ui.WaitingDialogInterface;
import com.forjun.frame.base.ui.dialog.WaitingDialog;
import com.forjun.frame.utils.ToastUtil;

import butterknife.ButterKnife;

/**
 * Created by forjun on 2017/4/27.
 */
public abstract class BaseActivity extends AppCompatActivity implements ToastInterface, WaitingDialogInterface, AleartDialogInterface {

	private static String            TAG;
	protected      AppCompatActivity mContext;


	@Override
	protected void onCreate(@Nullable Bundle savedInstanceState) {
		super.onCreate( savedInstanceState );
		mContext = this;
		TAG = this.getClass().getSimpleName();
		setContentView( getResourcesId() );
		ButterKnife.bind( this );
		init();
	}

	/**
	 * 获取layoutId
	 *
	 * @return
	 */
	protected abstract int getResourcesId();

	/**
	 * 初始化
	 */
	protected void init() {
		initView();
		initData();
		initListener();
	}

	protected abstract void initView();

	protected void initData() {

	}

	protected void initListener() {

	}


	@Override
	public void showToast(String msg) {
		ToastUtil.show( msg );
	}

	public void showToast(int msg) {
		ToastUtil.show( msg );
	}

	@Override
	public void showToastL(String msg) {
		ToastUtil.showL( msg );
	}

	@Override
	public void showToastL(int msg) {
		ToastUtil.showL( msg );
	}

	@Override
	public void dismissToast() {
		ToastUtil.cancel();
	}

	@Override
	public void showAleartDialog(String msg) {

	}

	@Override
	public void showAleartDialog(String title, String contentMsg) {

	}

	@Override
	public void showAleartDialog(String title, String contentMsg, AleartDialogListener listener) {

	}

	@Override
	public void showAleartDialog(String title, String contentMsg, boolean isCancleAble, AleartDialogListener listener) {

	}

	private WaitingDialog mWaitingDialog;

	public void showWaitingDialog() {
		mWaitingDialog = new WaitingDialog( this );
		mWaitingDialog.show();
	}

	@Override
	public void showWaitingDialog(String msg) {
		mWaitingDialog = new WaitingDialog( this, msg );
		mWaitingDialog.show();
	}

	@Override
	public void showWaitingDialog(String title, String subHead) {
		mWaitingDialog = new WaitingDialog( this, title, subHead );
		mWaitingDialog.show();
	}

	@Override
	public void dismissDialog() {
		mWaitingDialog.dismiss();
	}
}
