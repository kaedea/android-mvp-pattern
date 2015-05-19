package me.kaede.mvp.login.model;

/**
 * Created by kaede on 2015/5/18.
 */
public class User {
	String name;
	String passwd;

	public User(String name, String passwd) {
		this.name = name;
		this.passwd = passwd;
	}

	public String getName() {
		return name;
	}

	public String getPasswd() {
		return passwd;
	}
}
