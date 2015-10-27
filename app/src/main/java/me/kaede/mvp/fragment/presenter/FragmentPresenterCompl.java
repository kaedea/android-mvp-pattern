package me.kaede.mvp.fragment.presenter;

import me.kaede.mvp.fragment.view.IFragmentView;

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
