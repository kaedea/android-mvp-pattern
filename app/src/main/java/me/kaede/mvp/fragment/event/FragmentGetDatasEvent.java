package me.kaede.mvp.fragment.event;

import java.util.List;

/**
 * Created by kaede on 2015/10/13.
 */
public class FragmentGetDatasEvent {
	List<String> datas;

	public FragmentGetDatasEvent(List<String> datas) {
		this.datas = datas;
	}

	public List<String> getDatas() {
		return datas;
	}
}
