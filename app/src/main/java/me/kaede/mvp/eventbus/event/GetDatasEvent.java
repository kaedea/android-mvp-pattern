package me.kaede.mvp.eventbus.event;

import java.util.List;

/**
 * Created by kaede on 2015/10/13.
 */
public class GetDatasEvent {
	List<String> datas;

	public GetDatasEvent(List<String> datas) {
		this.datas = datas;
	}

	public List<String> getDatas() {
		return datas;
	}
}
