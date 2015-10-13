package me.kaede.mvp.eventbus.presenter;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import de.greenrobot.event.EventBus;
import me.kaede.mvp.R;
import me.kaede.mvp.eventbus.event.GetDatasEvent;
import me.kaede.mvp.eventbus.event.ToastEvent;
import me.kaede.mvp.eventbus.view.IHomeView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by kaede on 2015/5/19.
 */
public class EventBusPresenterCompl implements IEventBusPresenter {
	List<String> datas;
	Context context;
	IHomeView homeView;

	public EventBusPresenterCompl(Context context, IHomeView homeView) {
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
				GetDatasEvent getDatasEvent = new GetDatasEvent(datas);
				EventBus.getDefault().post(getDatasEvent);
			}
		},2000);
	}

	@Override
	public void onItemClick(int position) {
		ToastEvent toastEvent = new ToastEvent(datas.get(position));
		EventBus.getDefault().post(toastEvent);
	}
}
