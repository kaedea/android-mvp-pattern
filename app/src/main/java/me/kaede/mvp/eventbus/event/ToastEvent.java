package me.kaede.mvp.eventbus.event;

import java.util.List;

/**
 * Created by kaede on 2015/10/13.
 */
public class ToastEvent {
	String msg;

	public ToastEvent(String msg) {
		this.msg = msg;
	}

	public String getMessage() {
		return msg;
	}
}
