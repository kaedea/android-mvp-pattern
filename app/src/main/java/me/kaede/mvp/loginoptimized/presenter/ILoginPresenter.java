package me.kaede.mvp.loginoptimized.presenter;

/**
 * Created by kaede on 2015/10/12.
 */
public interface ILoginPresenter {
	void clear();
	void doLogin(String name, String passwd);
	void setProgressBarVisiblity(int visiblity);
	void onDestroy();
}
