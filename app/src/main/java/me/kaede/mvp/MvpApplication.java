package me.kaede.mvp;

import android.app.Application;
import android.content.Context;
import com.squareup.leakcanary.LeakCanary;
import com.squareup.leakcanary.RefWatcher;

/**
 * Created by kaede on 2015/10/26.
 */
public class MvpApplication extends Application {

	public static RefWatcher getReWatcher(Context context){
		MvpApplication application = (MvpApplication) context.getApplicationContext();
		return application.getRefWatcher();
	}

	private RefWatcher refWatcher;

	public RefWatcher getRefWatcher() {
		return refWatcher;
	}

	@Override
	public void onCreate() {
		super.onCreate();

		refWatcher = LeakCanary.install(this);
	}
}
