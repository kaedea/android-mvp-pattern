package me.kaede.mvp.home.view;

import java.util.List;

/**
 * Created by kaede on 2015/5/19.
 */
public interface IHomeView {
	public void onGetDataList(List<String> datas);
	public void toast(String msg);
}
