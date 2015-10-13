package me.kaede.mvp.home.presenter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import me.kaede.mvp.R;
import me.kaede.mvp.home.util.ActivityHolder;
import me.kaede.mvp.home.view.IHomeView;
import me.kaede.mvp.login.LoginActivity;
import me.kaede.mvp.outteradapter.AdapterActivityA;
import me.kaede.mvp.outteradapter.AdapterActivityB;

import java.util.*;

/**
 * Created by kaede on 2015/5/19.
 */
public class HomePresenterCompl implements IHomePresenter {
	public static ActivityHolder activityHolder;
	static {
		activityHolder = new ActivityHolder();
		activityHolder.addActivity("Simple MVP with Login",LoginActivity.class);
		activityHolder.addActivity("MVP in Adapter A", AdapterActivityA.class);
		activityHolder.addActivity("MVP in Adapter B", AdapterActivityB.class);
	}
	Context context;
	IHomeView homeView;

	public HomePresenterCompl(Context context, IHomeView homeView) {
		this.context = context;
		this.homeView = homeView;
	}

	@Override
	public void loadDatas() {

		Handler handler = new Handler(Looper.getMainLooper());
		handler.postDelayed(new Runnable() {
			@Override
			public void run() {
				homeView.onGetDataList(activityHolder.getNameList());
			}
		},2000);
	}

	@Override
	public void onItemClick(int position) {
		Class activity = activityHolder.getActivity(activityHolder.getNameList().get(position));
		if (activity!=null){
			context.startActivity(new Intent(context, activity));
		}
	}
}
