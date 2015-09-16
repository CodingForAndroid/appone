package com.bczm.widgetcollections.ui.adapter;

import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AbsListView.RecyclerListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.ListView;
import com.bczm.widgetcollections.ui.holder.BaseHolder;
import com.bczm.widgetcollections.ui.holder.MoreHolder;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lipan on 2014/6/8.
 */
public abstract class DefaultAdapter<Data> extends BaseAdapter implements RecyclerListener, OnItemClickListener {
	public static final int MORE_VIEW_TYPE = 0;
	public static final int ITEM_VIEW_TYPE = 1;

	protected AbsListView mListView;//和该adapter关联的listView
	private List<BaseHolder> mDisplayedHolders;//用于记录所有显示的holder
	private List<Data> mDatas;//adapter的数据集

	public DefaultAdapter(AbsListView listView, List<Data> datas) {
		mDisplayedHolders = new ArrayList<BaseHolder>();
		mListView = listView;
		if (null != listView) {
			//设置
			listView.setRecyclerListener(this);
			listView.setOnItemClickListener(this);
		}
		setData(datas);
	}

	@Override
	public void onMovedToScrapHeap(View view) {
		if (null != view) {
			Object tag = view.getTag();
			if (tag instanceof BaseHolder) {
				BaseHolder holder = (BaseHolder) tag;
				synchronized (mDisplayedHolders) {
					mDisplayedHolders.remove(holder);
				}
				holder.recycle();
			}
		}
	}

	public List<BaseHolder> getDisplayedHolders() {
		synchronized (mDisplayedHolders) {
			return new ArrayList<BaseHolder>(mDisplayedHolders);
		}
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	public void setData(List<Data> datas) {
		mDatas = datas;
	}

	public List<Data> getData() {
		return mDatas;
	}

	@Override
	public int getCount() {
		if (mDatas != null) {
			return mDatas.size() + 1;// 加1是为了最后加载更多的布局
		}
		return 0;
	}

	@Override
	public Data getItem(int position) {
		if (mDatas != null && position < mDatas.size()) {
			return mDatas.get(position);
		}
		return null;
	}

	public int getHeaderViewCount() {
		int count = 0;
		if (mListView != null && mListView instanceof ListView) {
			ListView listView = (ListView) mListView;
			count = listView.getHeaderViewsCount();
		}
		return count;
	}

	@Override
	public int getViewTypeCount() {
		return super.getViewTypeCount() + 1;// 加1是为了最后加载更多的布局
	}

	@Override
	public int getItemViewType(int position) {
		if (position == getCount() - 1) {
			return MORE_VIEW_TYPE;// 加载更多的布局
		} else {
			return getItemViewTypeInner(position);
		}
	}

	public int getItemViewTypeInner(int position) {
		return ITEM_VIEW_TYPE;// 普通item的布局
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		BaseHolder<Data> holder;
		if (convertView != null && convertView.getTag() instanceof BaseHolder) {
			holder = (BaseHolder<Data>) convertView.getTag();
		} else {
			if (getItemViewType(position) == MORE_VIEW_TYPE) {
				holder = getMoreHolder();
			} else {
				holder = getHolder();
				holder.setData(mDatas.get(position));
			}
		}
		mDisplayedHolders.add(holder);
		return holder.getRootView();
	}

	protected abstract BaseHolder getHolder();

	public BaseHolder getMoreHolder() {
		return new MoreHolder(this, hasMore());
	}

	public int loadMore() {
		List<Data> datas = onLoadMore();
		if (datas == null) {
			return MoreHolder.ERROR;
		}
		if (getData() != null) {
			getData().addAll(datas);
		} else {
			setData(datas);
		}
		if (datas.size() < 20) {
			return MoreHolder.NO_MORE;
		} else {
			return MoreHolder.HAS_MORE;
		}
	}

	public List<Data> onLoadMore() {
		return null;
	}

	public boolean hasMore() {
		return true;
	}

	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
		position = position - getHeaderViewCount();// 此时的position是加上了header的
		onItemClickInner(position);
	}

	public void onItemClickInner(int position) {

	}
}
