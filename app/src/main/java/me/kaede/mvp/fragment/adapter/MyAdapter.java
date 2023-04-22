package me.kaede.mvp.fragment.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import me.kaede.mvp.R;
import me.kaede.mvp.fragment.presenter.IFragmentPresenter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by kaede on 2015/10/15.
 */
public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {
	List<String> datas;
	IFragmentPresenter iFragmentPresenter;

	public MyAdapter(IFragmentPresenter iFragmentPresenter) {
		this.iFragmentPresenter = iFragmentPresenter;
		this.datas = new ArrayList<>();
	}

	public void setDatas(List<String> datas){
		if (datas != null && datas.size() > 0){
			this.datas.clear();
			this.datas.addAll(datas);
			notifyDataSetChanged();
		}
	}

	public String getItem( int position){
		return datas.get(position);
	}


	@Override
	public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
		View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_recycleview, parent, false);
		ViewHolder vh = new ViewHolder(v);
		return vh;
	}

	@Override
	public void onBindViewHolder(ViewHolder holder, final int position) {
		holder.mTextView.setText(datas.get(position));
		holder.itemView.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				iFragmentPresenter.onItemClick(position);
			}
		});
	}

	@Override
	public int getItemCount() {
		return datas.size();
	}

	public class ViewHolder extends RecyclerView.ViewHolder {
		public TextView mTextView;
		public ViewHolder(View v) {
			super(v);
			mTextView = (TextView) v.findViewById(R.id.tv_recyclerview_item);
		}
	}
}


