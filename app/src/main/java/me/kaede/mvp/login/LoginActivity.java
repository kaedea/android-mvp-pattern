package me.kaede.mvp.login;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import me.kaede.mvp.R;
import me.kaede.mvp.login.presenter.ILoginPresenter;
import me.kaede.mvp.login.presenter.LoginPresenterCompl;
import me.kaede.mvp.login.view.ILoginView;


public class LoginActivity extends AppCompatActivity implements ILoginView, View.OnClickListener {

	private EditText editUser;
	private EditText editPass;
	private Button   btnLogin;
	private Button   btnClear;
	ILoginPresenter loginPresenter;
	private ProgressBar progressBar;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_login);

		//find view
		editUser = (EditText) this.findViewById(R.id.et_login_username);
		editPass = (EditText) this.findViewById(R.id.et_login_password);
		btnLogin = (Button) this.findViewById(R.id.btn_login_login);
		btnClear = (Button) this.findViewById(R.id.btn_login_clear);
		progressBar = (ProgressBar) this.findViewById(R.id.progress_login);

		//set listener
		btnLogin.setOnClickListener(this);
		btnClear.setOnClickListener(this);

		//init
		loginPresenter = new LoginPresenterCompl(this);
		loginPresenter.setProgressBarVisiblity(View.INVISIBLE);
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()){
			case R.id.btn_login_clear:
				loginPresenter.clear();
				break;
			case R.id.btn_login_login:
				loginPresenter.setProgressBarVisiblity(View.VISIBLE);
				btnLogin.setEnabled(false);
				btnClear.setEnabled(false);
				loginPresenter.doLogin(editUser.getText().toString(), editPass.getText().toString());
				break;
		}
	}

	@Override
	public void onClearText() {
		editUser.setText("");
		editPass.setText("");
	}

	@Override
	public void onLoginResult(Boolean result, int code) {
		loginPresenter.setProgressBarVisiblity(View.INVISIBLE);
		btnLogin.setEnabled(true);
		btnClear.setEnabled(true);
		if (result){
			Toast.makeText(this,"Login Success",Toast.LENGTH_SHORT).show();
		}
		else
			Toast.makeText(this,"Login Fail, code = " + code,Toast.LENGTH_SHORT).show();
	}

	@Override
	protected void onDestroy() {
		super.onDestroy();
	}

	@Override
	public void onSetProgressBarVisibility(int visibility) {
		progressBar.setVisibility(visibility);
	}
	
}
