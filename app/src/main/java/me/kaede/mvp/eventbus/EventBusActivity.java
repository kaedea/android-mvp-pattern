package me.kaede.mvp.eventbus;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.*;

import androidx.appcompat.app.AppCompatActivity;

import de.greenrobot.event.EventBus;
import me.kaede.mvp.R;
import me.kaede.mvp.eventbus.event.GetDatasEvent;
import me.kaede.mvp.eventbus.event.ToastEvent;
import me.kaede.mvp.eventbus.presenter.EventBusPresenterCompl;
import me.kaede.mvp.eventbus.presenter.IEventBusPresenter;
import me.kaede.mvp.eventbus.view.IEventBusView;

import java.util.ArrayList;
import java.util.List;

public class EventBusActivity extends AppCompatActivity implements AdapterView.OnItemClickListener,IEventBusView {

	private IEventBusPresenter iEventBusPresenter;
	List<String> datas = new ArrayList<>();
	private BaseAdapter adapter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_home);
		//register
		EventBus.getDefault().register(this);

		//find view
		ListView listView = (ListView) this.findViewById(R.id.list_home);

		//set listener
		listView.setOnItemClickListener(this);

		//init
		View loadingView = LayoutInflater.from(this).inflate(R.layout.item_empty_view, null);
		ViewGroup viewGroup = (ViewGroup) this.findViewById(R.id.layout_home);
		RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT,RelativeLayout.LayoutParams.MATCH_PARENT);
		layoutParams.addRule(RelativeLayout.CENTER_IN_PARENT);
		viewGroup.addView(loadingView, layoutParams);
		listView.setEmptyView(loadingView);
		adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, datas);
		listView.setAdapter(adapter);
		iEventBusPresenter = new EventBusPresenterCompl(this);
	}

	@Override
	protected void onResume() {
		super.onResume();
		iEventBusPresenter.loadDatas();
	}

	@Override
	protected void onDestroy() {
		super.onDestroy();
		EventBus.getDefault().unregister(this);
	}

	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
		iEventBusPresenter.onItemClick(position);
	}

	@Override
	public Activity getActivity() {
		return this;
	}

	// EventBus Subscribe
	public void onEvent(ToastEvent toastEvent){
		if (toastEvent!=null&&toastEvent.getMessage()!=null){
			Toast.makeText(this,toastEvent.getMessage(),Toast.LENGTH_SHORT).show();
		}
	}

	// EventBus Subscribe
	public void onEvent(GetDatasEvent getDatasEvent){
		if (getDatasEvent!=null && getDatasEvent.getDatas()!=null && getDatasEvent.getDatas().size()>0){
			this.datas.clear();
			this.datas.addAll(getDatasEvent.getDatas());
			adapter.notifyDataSetChanged();
		}
	}

}
