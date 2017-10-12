package com.forjun.testdemo.base.ui.activity;

import android.view.Menu;
import android.view.MenuItem;

import com.forjun.frame.base.ui.activity.BaseKKTestActivity;
import com.forjun.testdemo.R;

/**
 * Created by 黄骏健 on 2017/7/30.
 */

public class ShowKKTestActivity extends BaseKKTestActivity {


	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate( R.menu.baseshowbaseactivity, menu );
		return true;
	}

	/**
	 * 测试代码
	 *
	 * @param item
	 * @return
	 */
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		int itemId = item.getItemId();
		switch ( itemId ) {
			case R.id.dismiss_dialog:
				dismissDialog();
				break;
			case R.id.show_waiting_dialog:
				showWaitingDialog();
				break;
			case R.id.show_aleart_dialog:

				break;
		}
		return true;
	}

	@Override
	protected DemoInfo[] getDemos() {
		return new DemoInfo[0];
	}
}
