package me.kaede.mvp.eventbus;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.*;
import android.widget.*;
import de.greenrobot.event.EventBus;
import me.kaede.mvp.R;
import me.kaede.mvp.eventbus.event.GetDatasEvent;
import me.kaede.mvp.eventbus.event.ToastEvent;
import me.kaede.mvp.eventbus.presenter.EventBusPresenterCompl;
import me.kaede.mvp.eventbus.presenter.IEventBusPresenter;
import me.kaede.mvp.eventbus.view.IHomeView;

import java.util.ArrayList;
import java.util.List;

public class EventBusActivity extends ActionBarActivity implements AdapterView.OnItemClickListener,IHomeView {

	private ListView listView;
	private IEventBusPresenter homePresenter;
	List<String> datas = new ArrayList<>();
	private BaseAdapter adapter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_home);
		//register
		EventBus.getDefault().register(this);

		//find view
		listView = (ListView) this.findViewById(R.id.list_home);

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
		homePresenter = new EventBusPresenterCompl(this,this);
	}

	@Override
	protected void onResume() {
		super.onResume();
		homePresenter.loadDatas();
	}

	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
		homePresenter.onItemClick(position);
	}

	@Override
	public void onGetDataList(List<String> datas) {
		if (datas!=null&&datas.size()>0){
			this.datas.clear();
			this.datas.addAll(datas);
			adapter.notifyDataSetChanged();
		}
	}

	@Override
	public void toast(String msg) {
		Toast.makeText(this,msg,Toast.LENGTH_SHORT).show();
	}

	public void onEvent(ToastEvent toastEvent){
		if (toastEvent!=null&&toastEvent.getMessage()!=null){
			Toast.makeText(this,toastEvent.getMessage(),Toast.LENGTH_SHORT).show();
		}
	}

	public void onEvent(GetDatasEvent getDatasEvent){
		if (getDatasEvent!=null && getDatasEvent.getDatas()!=null && getDatasEvent.getDatas().size()>0){
			this.datas.clear();
			this.datas.addAll(getDatasEvent.getDatas());
			adapter.notifyDataSetChanged();
		}
	}

}
