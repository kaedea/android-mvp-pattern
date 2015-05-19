package me.kaede.mvp.home.presenter;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import me.kaede.mvp.R;
import me.kaede.mvp.home.view.IHomeView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by kaede on 2015/5/19.
 */
public class HomePresenterCompl implements IHomePresenter {
	List<String> datas;
	Context      context;
	IHomeView homeView;

	public HomePresenterCompl(Context context, IHomeView homeView) {
		this.context = context;
		this.homeView = homeView;
	}

	@Override
	public void loadDatas() {
		String[] countries = context.getResources().getStringArray(R.array.countries);
		datas = new ArrayList<>();
		for (String item:countries){
			datas.add(item);
		}

		Handler handler = new Handler(Looper.getMainLooper());
		handler.postDelayed(new Runnable() {
			@Override
			public void run() {
				homeView.onGetDataList(datas);
			}
		},2000);
	}

	@Override
	public void onItemClick(int position) {
		homeView.toast(datas.get(position));
	}
}
