package me.kaede.mvp.outteradapter.view;

import android.app.Activity;

import java.util.List;

/**
 * Created by kaede on 2015/5/19.
 */
public interface IAdapterView {
	public void onGetDataList(List<String> datas);
	public void onLoadMoreData(String item);
	public void toast(String msg);
	public Activity onGetActivity();
	public void onShowFooterView(Boolean isShow);
}
