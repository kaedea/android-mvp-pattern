package me.kaede.mvp.login.presenter;

import me.kaede.mvp.login.view.IProgressBarView;

/**
 * Created by kaede on 2015/5/18.
 */
public class ProgressBarPresenter {
	IProgressBarView iProgressBarView;

	public ProgressBarPresenter(IProgressBarView iProgressBarView) {
		this.iProgressBarView = iProgressBarView;
	}

	public void setProgressBarVisiblity(int visiblity){
		iProgressBarView.setProgressBarVisibility(visiblity);
	}
}
