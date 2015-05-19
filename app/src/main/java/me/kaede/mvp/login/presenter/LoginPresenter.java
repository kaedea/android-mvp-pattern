package me.kaede.mvp.login.presenter;

import android.os.Handler;
import android.os.Looper;
import me.kaede.mvp.login.model.User;
import me.kaede.mvp.login.view.ILoginView;

/**
 * Created by kaede on 2015/5/18.
 */
public class LoginPresenter {
	ILoginView iLoginView;
	User       user;
	Handler    handler;

	public LoginPresenter(ILoginView iLoginView) {
		this.iLoginView = iLoginView;
		initUser();
		handler = new Handler(Looper.getMainLooper());
	}

	public void clear() {
		iLoginView.clearText();
	}

	public void doLogin(String name, String passwd) {
		Boolean bool = true;
		if (name==null||passwd==null||!name.equals(user.getName())||!passwd.equals(user.getPasswd())){
			bool = false;
		}
		final Boolean result = bool;
		handler.postDelayed(new Runnable() {
			@Override
			public void run() {
				iLoginView.OnLoginResult(result);
			}
		}, 3000);

	}

	private void initUser(){
		user = new User("mvp","mvp");
	}
}
