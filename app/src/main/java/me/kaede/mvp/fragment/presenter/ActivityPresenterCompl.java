package me.kaede.mvp.fragment.presenter;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import de.greenrobot.event.EventBus;
import me.kaede.mvp.R;
import me.kaede.mvp.fragment.event.FragmentGetDatasEvent;
import me.kaede.mvp.fragment.event.FragmentToastEvent;
import me.kaede.mvp.fragment.view.IFragmentView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by kaede on 2015/5/19.
 */
public class ActivityPresenterCompl implements IActivityPresenter {
	Context context;

	public ActivityPresenterCompl(Context context) {
		this.context = context;
	}

	@Override
	public void loadDatas() {

		String[] countries = context.getResources().getStringArray(R.array.countries);
		final List<String> datas = new ArrayList<>();
		Collections.addAll(datas, countries);

		Handler handler = new Handler(Looper.getMainLooper());
		handler.postDelayed(new Runnable() {
			@Override
			public void run() {
				FragmentGetDatasEvent getDatasEvent = new FragmentGetDatasEvent(datas);
				EventBus.getDefault().post(getDatasEvent);
			}
		}, 2000);
	}

}
