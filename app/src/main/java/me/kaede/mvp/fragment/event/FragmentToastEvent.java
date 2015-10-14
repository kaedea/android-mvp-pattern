package me.kaede.mvp.fragment.event;

/**
 * Created by kaede on 2015/10/13.
 */
public class FragmentToastEvent {
	int position;

	public FragmentToastEvent(int position) {
		this.position = position;
	}

	public int getPosition() {
		return position;
	}
}
