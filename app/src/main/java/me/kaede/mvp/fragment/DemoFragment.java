package me.kaede.mvp.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.*;
import de.greenrobot.event.EventBus;
import me.kaede.mvp.R;
import me.kaede.mvp.fragment.event.FragmentGetDatasEvent;
import me.kaede.mvp.fragment.event.FragmentToastEvent;
import me.kaede.mvp.fragment.presenter.FragmentPresenterCompl;
import me.kaede.mvp.fragment.presenter.IFragmentPresenter;
import me.kaede.mvp.fragment.view.IFragmentView;

import java.util.ArrayList;
import java.util.List;


public class DemoFragment extends Fragment implements IFragmentView,AdapterView.OnItemClickListener {
	private static final String BUNDLE_INDEX = "BUNDLE_INDEX";

	private int index;

	private IFragmentPresenter iFragmentPresenter;
	List<String> datas = new ArrayList<>();
	private BaseAdapter adapter;


	public static DemoFragment newInstance(int index) {
		DemoFragment fragment = new DemoFragment();
		Bundle args = new Bundle();
		args.putInt(BUNDLE_INDEX, index);
		fragment.setArguments(args);
		return fragment;
	}


	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		if (getArguments() != null) {
			index = getArguments().getInt(BUNDLE_INDEX);
		}
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
	                         Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.fragment_demo, container, false);

		//register
		EventBus.getDefault().register(this);

		//find view
		ListView listView = (ListView) view.findViewById(R.id.list_home);

		//set listener
		listView.setOnItemClickListener(this);

		//init
		View loadingView = LayoutInflater.from(getActivity()).inflate(R.layout.item_empty_view, null);
		ViewGroup viewGroup = (ViewGroup) view.findViewById(R.id.layout_home);
		RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT,RelativeLayout.LayoutParams.MATCH_PARENT);
		layoutParams.addRule(RelativeLayout.CENTER_IN_PARENT);
		viewGroup.addView(loadingView, layoutParams);
		listView.setEmptyView(loadingView);
		adapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, datas);
		listView.setAdapter(adapter);
		iFragmentPresenter = new FragmentPresenterCompl(this);

		return view;
	}

	@Override
	public void onDestroy() {
		super.onDestroy();
		EventBus.getDefault().unregister(this);
	}

	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
		iFragmentPresenter.onItemClick(position);
	}

	@Override
	public void onItemClick(int position) {
		Toast.makeText(getActivity(),"Tab "+index+" : "+(String)adapter.getItem(position),Toast.LENGTH_SHORT).show();
	}

	// EventBus Subscribe
	public void onEvent(FragmentGetDatasEvent getDatasEvent){
		if (getDatasEvent!=null && getDatasEvent.getDatas()!=null && getDatasEvent.getDatas().size()>0){
			this.datas.clear();
			this.datas.addAll(getDatasEvent.getDatas());
			adapter.notifyDataSetChanged();
		}
	}
}
