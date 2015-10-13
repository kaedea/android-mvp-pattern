package me.kaede.mvp.outteradapter.presenter;

import android.app.Activity;

/**
 * Created by kaede on 2015/5/19.
 */
public interface IAdapterPresenter {
	public void loadDatas();
	public void loadMoreData(String item);
	public Activity getActivity();
	public void showFooterView(Boolean isShow);
}
