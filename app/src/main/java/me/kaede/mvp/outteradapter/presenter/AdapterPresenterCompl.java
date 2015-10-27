package me.kaede.mvp.outteradapter.presenter;

import android.app.Activity;
import android.os.Handler;
import android.os.Looper;
import me.kaede.mvp.outteradapter.view.IAdapterView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by kaede on 2015/5/19.
 */
public class AdapterPresenterCompl implements IAdapterPresenter {
	List<String> datas;
	IAdapterView iAdapterView;

	public AdapterPresenterCompl(IAdapterView iAdapterView) {
		this.iAdapterView = iAdapterView;
	}

	@Override
	public void loadDatas() {
		String[] countries = new String[]{"Kaede Akatsuki","Loves","Neko Tattsun","Deeply"};
		datas = new ArrayList<>();
		for (String item:countries){
			datas.add(item);
		}

		Handler handler = new Handler(Looper.getMainLooper());
		handler.postDelayed(new Runnable() {
			@Override
			public void run() {
				iAdapterView.onGetDataList(datas);
			}
		}, 2000);
	}

	@Override
	public void loadMoreData(final String item) {
		showFooterView(true);
		Handler handler = new Handler(Looper.getMainLooper());
		handler.postDelayed(new Runnable() {
			@Override
			public void run() {
				iAdapterView.onLoadMoreData(item);
			}
		}, 2000);
	}

	@Override
	public Activity getActivity() {
		return iAdapterView.onGetActivity();
	}

	@Override
	public void showFooterView(Boolean isShow) {
		iAdapterView.onShowFooterView(isShow);
	}
}
