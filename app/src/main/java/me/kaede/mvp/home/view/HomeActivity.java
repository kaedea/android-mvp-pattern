package me.kaede.mvp.home.view;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.*;
import android.widget.*;
import me.kaede.mvp.R;
import me.kaede.mvp.home.presenter.HomePresenterCompl;
import me.kaede.mvp.home.presenter.IHomePresenter;

import java.util.List;

public class HomeActivity extends ActionBarActivity implements AdapterView.OnItemClickListener,IHomeView {

	private ListView listView;
	private IHomePresenter homePresenter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_home);

		//find view
		listView = (ListView) this.findViewById(R.id.list_home);

		//set listener
		listView.setOnItemClickListener(this);

		//init
		View loadingView = LayoutInflater.from(this).inflate(R.layout.item_loading, null);
		ViewGroup viewGroup = (ViewGroup) this.findViewById(R.id.layout_home);
		RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT,RelativeLayout.LayoutParams.MATCH_PARENT);
		layoutParams.addRule(RelativeLayout.CENTER_IN_PARENT);
		viewGroup.addView(loadingView, layoutParams);
		listView.setEmptyView(loadingView);
		homePresenter = new HomePresenterCompl(this,this);
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
		BaseAdapter adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, datas);
		listView.setAdapter(adapter);
	}

	@Override
	public void toast(String msg) {
		Toast.makeText(this,msg,Toast.LENGTH_SHORT).show();
	}


	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.menu_main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		int id = item.getItemId();

		//noinspection SimplifiableIfStatement
		if (id == R.id.action_github) {
			Intent intent = new Intent(Intent.ACTION_VIEW);
			intent.setData(Uri.parse("https://github.com/kaedea/"));
			startActivity(intent);
			return true;
		}

		return super.onOptionsItemSelected(item);
	}
}
