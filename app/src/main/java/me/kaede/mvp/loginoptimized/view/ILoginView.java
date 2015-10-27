package me.kaede.mvp.loginoptimized.view;

/**
 * Created by kaede on 2015/5/18.
 */
public interface ILoginView {
	public void onClearText();
	public void onLoginResult(Boolean result, int code);
	public void onSetProgressBarVisibility(int visibility);
}
