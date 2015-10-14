package me.kaede.mvp.fragment;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import me.kaede.mvp.R;
import me.kaede.mvp.fragment.presenter.ActivityPresenterCompl;
import me.kaede.mvp.fragment.presenter.IActivityPresenter;

public class FragmentsActivity extends AppCompatActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_fragments);
		Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
		setSupportActionBar(toolbar);

		TabLayout tabLayout = (TabLayout) this.findViewById(R.id.tablayout_fragments);
		ViewPager viewPager = (ViewPager) this.findViewById(R.id.viewpager_fragments);
		viewPager.setAdapter(new MyAdapter(getSupportFragmentManager()));
		viewPager.setOffscreenPageLimit(3);
		tabLayout.setupWithViewPager(viewPager);

		IActivityPresenter iActivityPresenter = new ActivityPresenterCompl(this);
		iActivityPresenter.loadDatas();
	}

	public class MyAdapter extends FragmentStatePagerAdapter {
		public String[] pagers = new String[]{"FragmentA","FragmentB","FragmentC"};
		public MyAdapter(FragmentManager fm) {
			super(fm);
		}

		@Override
		public Fragment getItem(int position) {
			return DemoFragment.newInstance(position);
		}

		@Override
		public int getCount() {
			return pagers.length;
		}

		@Override
		public CharSequence getPageTitle(int position) {
			return pagers[position];
		}
	}

}
