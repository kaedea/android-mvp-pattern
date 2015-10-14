package me.kaede.mvp.fragment.presenter;

import android.os.Handler;
import android.os.Looper;
import de.greenrobot.event.EventBus;
import me.kaede.mvp.R;
import me.kaede.mvp.fragment.event.FragmentGetDatasEvent;
import me.kaede.mvp.fragment.event.FragmentToastEvent;
import me.kaede.mvp.fragment.view.IFragmentView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by kaede on 2015/5/19.
 */
public class FragmentPresenterCompl implements IFragmentPresenter {
	IFragmentView iFragmentView;

	public FragmentPresenterCompl(IFragmentView iFragmentView) {
		this.iFragmentView = iFragmentView;
	}



	@Override
	public void onItemClick(int position) {
		iFragmentView.onItemClick(position);
	}
}
