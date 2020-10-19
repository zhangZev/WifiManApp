package com.wanzhong.core.adapter;

import android.view.View;
import android.view.ViewGroup;

import com.wanzhong.core.view.PageAdapterLoadingView;

import java.util.ArrayList;
import java.util.List;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


/**
 * RecyclerView 分页的BaseAdapter
 * */
public abstract class BasePageAdapter<TYPE> extends RecyclerView.Adapter {
	private static final int TYPE_HEADER = 1001;
	private static final int TYPE_ITEM = 1222;
	public interface Pagingable {
		void onLoadMoreItems();
	}
	public BasePageAdapter(){
		super();
	}
	public BasePageAdapter(boolean headerEnabled){
		super();
		setHeaderEnabled(headerEnabled);

	}

	
	private boolean isLoading;
	private boolean hasMoreItems;
	private Pagingable pagingableListener;
	protected boolean mLoadmoreEnabled;
	protected PageAdapterLoadingView loadingView;

	private LinearLayoutManager mLayoutManger;
	private boolean mHeaderEnabled = false;
	protected void setHeaderEnabled(boolean enabled){
		mHeaderEnabled = enabled;
	}
	public boolean getHeaderEnabled(){
		return mHeaderEnabled;
	}
    public boolean isLoading() {
		return this.isLoading;
	}

	public void setIsLoading(boolean isLoading) {
		this.isLoading = isLoading;
		if(isLoading){
			loadingView.loading();
		} else {
			loadingView.hide();	
		}
	}
	
	public void setPagingableListener(Pagingable pagingableListener) {
		this.pagingableListener = pagingableListener;
	}
	public void setNoMoreText(String text){
    	if(loadingView != null){
			loadingView.setNoMoreText(text);
		}
	}

	public void setHasMoreItems(boolean hasMoreItems) {
		this.hasMoreItems = hasMoreItems;
		if(hasMoreItems){
			loadingView.loadMore();
		} else {
			loadingView.loadFinished();
		}
	}

	public boolean hasMoreItems() {
		return this.hasMoreItems;
	}


	public void setLoadMoreEnabled(boolean enabled){
    	mLoadmoreEnabled =  enabled;
	}
	public boolean isLoadMoreEnabled(){
		return mLoadmoreEnabled;
	}
	public void onFinishLoading(boolean hasMoreItems) {
		setIsLoading(false);
		setHasMoreItems(hasMoreItems);
	}
	
	public void init(RecyclerView recyclerView) {
		loadingView = new PageAdapterLoadingView(recyclerView.getContext());
		isLoading = false;
		if (recyclerView.getLayoutManager() != null && recyclerView.getLayoutManager() instanceof LinearLayoutManager){
			mLayoutManger = (LinearLayoutManager)recyclerView.getLayoutManager();
		}
	
		PagingableScrollListener scrollListener = new PagingableScrollListener();
		recyclerView.setOnScrollListener(scrollListener);
	}


	private int mScrollState = RecyclerView.SCROLL_STATE_IDLE;
	public class PagingableScrollListener extends RecyclerView.OnScrollListener {
		
		@Override
		public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
			super.onScrolled(recyclerView, dx, dy);
			if(mLayoutManger == null || getItems() == null || getItems().size() == 0 || !mLoadmoreEnabled){
				return;
			}
			final int visibleItemCount = mLayoutManger.getChildCount();
			final int totalItemCount = mLayoutManger.getItemCount();
			final int pastVisiblesItems = mLayoutManger.findFirstVisibleItemPosition();
            if (!isLoading && hasMoreItems && ((visibleItemCount+pastVisiblesItems) >= totalItemCount)) {
                if (pagingableListener != null) {
                	setIsLoading(true);
                    pagingableListener.onLoadMoreItems();
                }

            }
		}

		@Override
		public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
			super.onScrollStateChanged(recyclerView, newState);
			mScrollState = newState;
		}
		
	}
	public int getScrollState(){
		return mScrollState;
	}
	
	protected class FooterViewHolder extends
	RecyclerView.ViewHolder {
		private View loadingView;
		public FooterViewHolder(View root) {
			super(root);
			// TODO Auto-generated constructor stub
			loadingView = root;
		}
	}
	
	
	protected List<TYPE> mItems;
	public void setItems(List<TYPE> items){
		mItems = items;
	}
	public void addItems(List<TYPE> items){
		if(mItems == null){
			mItems = new ArrayList<>();
		}
		mItems.addAll(items);
	}

	public void updateItem(int position ,TYPE item){
		if(position >= 0 && mItems != null && position < mItems.size()){
			mItems.set(position,item);
			notifyItemChanged(position);

		}
	}
	
	public List<TYPE> getItems(){
		return mItems;
	}

	@Override
	public int getItemViewType(int position) {
		if(mHeaderEnabled && position == 0){
			return TYPE_HEADER;
		}
		if(mHeaderEnabled && position == mItems.size() + 1){
			return RecyclerView.INVALID_TYPE;
		}
		if(!mHeaderEnabled && position == mItems.size()){
			return RecyclerView.INVALID_TYPE;
		}
		return TYPE_ITEM;//super.getItemViewType(position);
	}
	

	public void clearData() {
		// TODO Auto-generated method stub
		if(mItems != null){
			loadingView.hide();
			mItems.clear();
			int count = mItems.size();
			if(count > 0){
				notifyItemRangeRemoved(0,count);
			}
		}
		
	}
	
	@Override
	public int getItemCount() {
		// TODO Auto-generated method stub
		return mItems == null ? (mHeaderEnabled ? 1 : 0) : mItems.size() + (mLoadmoreEnabled ? 1 : 0) +(mHeaderEnabled ? 1 : 0);
		//1 is for loadingView
	}
	
	@Override
	public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {

		if(viewType == RecyclerView.INVALID_TYPE){
			return new FooterViewHolder(loadingView);
		} else if(viewType == TYPE_HEADER){
			return initHeaderViewHolder(viewGroup,viewType);
		}
		return initViewHolder(viewGroup,viewType);
	}
	@Override
	public void onBindViewHolder(
			RecyclerView.ViewHolder viewHoder, int position) {
		doBindViewHolder(viewHoder, mHeaderEnabled ? position - 1: position);
	}
	protected abstract RecyclerView.ViewHolder initViewHolder(ViewGroup viewGroup, int viewType);
	protected RecyclerView.ViewHolder initHeaderViewHolder(ViewGroup viewGroup, int viewType){
		return null;
	}
	public abstract void doBindViewHolder(RecyclerView.ViewHolder viewHoder, int position);
	
	
}
