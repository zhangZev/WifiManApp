package com.wanzhong.core.frag;

import android.os.AsyncTask;
import android.os.Handler;
import android.os.Message;
import android.text.Html;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;

import com.wanzhong.common.po.BasePo;
import com.wanzhong.core.BaseApp;
import com.wanzhong.core.R;
import com.wanzhong.core.adapter.BasePageAdapter;
import com.wanzhong.core.utils.CommonUtil;

import java.util.List;

import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;


/**
 * RecyclerView分页基类，支持自动加载分页和下拉刷新
 * */
public abstract class BaseListFragment extends BaseFragment implements SwipeRefreshLayout.OnRefreshListener {

	//@BindView(R2.id.recycler_view)
	protected RecyclerView mViewList;
	//@BindView(R2.id.empty_propt)
	protected View mEmptyTips;
	//@BindView(R2.id.empty_propt_img)
	protected ImageView mEmptyTipImg;
	//@BindView(R2.id.empty_propt_text)
	protected TextView mEmptyTipText;
	//@BindView(R2.id.btn_refresh)
	protected View mBtnRefresh;
	protected BasePageAdapter mAdapter;
	//@BindView(R2.id.swipe_refresh_widget)
	protected SwipeRefreshLayout mSwipeRefreshLayout;

	public int getLayoutId(){
		return com.wanzhong.core.R.layout.list_normal;
	}


	protected void initView(View view) {
		super.initView(view);
		mViewList = view.findViewById(R.id.recycler_view);
		DefaultItemAnimator defaultItemAnimator = new DefaultItemAnimator();
		defaultItemAnimator.setAddDuration(1000);
		defaultItemAnimator.setRemoveDuration(1000);
		mViewList.setItemAnimator(defaultItemAnimator);
		mEmptyTips = view.findViewById(R.id.empty_propt);
		mEmptyTipImg = view.findViewById(R.id.empty_propt_img);
		mEmptyTipImg.setBackgroundResource(R.drawable.trans);
		mEmptyTipText = view.findViewById(R.id.empty_propt_text);
		mBtnRefresh = view.findViewById(R.id.btn_refresh);
		mBtnRefresh.setVisibility(View.INVISIBLE);
		mSwipeRefreshLayout = view.findViewById(R.id.swipe_refresh_widget);
		initLeftListener();
		//mViewList = (RecyclerView) root.findViewById(R.id.recycler_view);

		mViewList.setLayoutManager(initLayoutManager());
		mAdapter = initAdapter();
		mAdapter.setLoadMoreEnabled(loadMoreEnabled());
		mAdapter.init(mViewList);
		mViewList.setItemAnimator(new DefaultItemAnimator());
		final RecyclerView.ItemDecoration itemDecoration = getItemDecoration();
		if(itemDecoration != null){
			mViewList.addItemDecoration(itemDecoration);
		}

		
		//mEmptyTips = root.findViewById(R.id.empty_propt);
		//mEmptyTipImg = (TextView)root.findViewById(R.id.empty_propt_img);
		//mEmptyTipText = (TextView)root.findViewById(R.id.empty_propt_text);
		//mBtnRefresh = root.findViewById(R.id.btn_refresh);
		mBtnRefresh.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				if(CommonUtil.isNetworkConnected(mViewList.getContext())){
					mSwipeRefreshLayout.setRefreshing(true);
					requestData(0,false);
				} else {
					BaseApp.getInstance().toast(R.string.network_not_connection);
				}

			}
		});
		
		mEmptyTips.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				if(CommonUtil.isNetworkConnected(mViewList.getContext())){
					mSwipeRefreshLayout.setRefreshing(true);
					requestData(0,false);
				} else {
					CommonUtil.toastUser(mViewList.getContext(), R.string.network_not_connection);
				}
				
			}
		});
		
		mAdapter.setPagingableListener(new BasePageAdapter.Pagingable() {
			
			@Override
			public void onLoadMoreItems() {
				if(mAdapter.hasMoreItems()){
					requestData(getCurrentPage() + 1 , false);
				} else {
					mAdapter.onFinishLoading(false);
				}
			}
		});
		
		//TitleBarMovableTouchListener touchListener = new TitleBarMovableTouchListener(this.getActivity().findViewById(R.id.activity_title));
		//mViewList.setOnTouchListener(touchListener);
		//mSwipeRefreshLayout = (SwipeRefreshLayout)root.findViewById(R.id.swipe_refresh_widget);
		mSwipeRefreshLayout.setOnRefreshListener(this);
		mSwipeRefreshLayout.setEnabled(isSwipeRefreshLayoutEnabled());
		mSwipeRefreshLayout.setColorSchemeResources(R.color.swipe_refrsh_color1, R.color.swipe_refrsh_color2, R.color.swipe_refrsh_color3,
				R.color.swipe_refrsh_color4);
		mViewList.setAdapter(mAdapter);
		if(reqDataOnCreate()){
			mHandler.sendEmptyMessageDelayed(MSG_REQUEST_DATA, FIRST_INIT_DELAY);
		}
		
		
	}

	protected boolean canShowEmpty(){
		return true;
	}
	public void showEmpty(){
		if(!canShowEmpty()){
			return;
		}
		mViewList.setVisibility(View.GONE);
		if(!CommonUtil.isNetworkConnected(mViewList.getContext())){
			mEmptyTipImg.setImageResource(R.drawable.loadwebview_error_no_net_bg);
			mEmptyTipText.setText(Html.fromHtml("无网络请检查网络设置..."));
		} else if(isDataGotSucc()){
			mEmptyTipImg.setImageResource(getNoDataImgRes());
			mEmptyTipText.setText(getNoDataTip());
		} else {
			mEmptyTipImg.setImageResource(getNoDataImgRes());
			mEmptyTipText.setText(getNoDataTip());
		}
		mEmptyTips.setVisibility(View.VISIBLE);
	}
	public int getNoDataImgRes(){
		return R.drawable.loadwebview_no_data_tv_bg;
	}
	public String getNoDataTip(){
		return "这里什么都没有哦...";
	}

	
	public void hideEmpty(){
		mViewList.setVisibility(View.VISIBLE);
		mEmptyTips.setVisibility(View.GONE);
	}
	
	protected void requestData(int start, boolean showloading) {
		initNetTask(start);
		hideEmpty();
		if (showloading) {
			BaseApp.getInstance().showLoading(true);
		}
	}

	/**
	 * 解析Json，得到List,在子线程中运行
	 * */
	protected abstract List<? extends BasePo> convertToBeanList(String json);

	protected RecyclerView.LayoutManager initLayoutManager() {
		LinearLayoutManager layoutManager = new LinearLayoutManager(
				mViewList.getContext());
		layoutManager.setOrientation(getOrientation());
		return layoutManager;
	}

	protected int getOrientation(){
		return  RecyclerView.VERTICAL;
	}

	protected boolean loadMoreEnabled(){
		return true;
	}
	/**
	 * 初始化Adapter
	 * */
	protected abstract BasePageAdapter initAdapter();
	
	/**
	 * 返回是否要下拉刷
	 * */
	protected abstract boolean isSwipeRefreshLayoutEnabled();

	/**
	 * 返回每一页的数量
	 * */
	protected int getSizeInPage(){
		return 10;
	}
	
	/**
	 * 获取ConnectTask并执行网络请求
	 * */
	protected abstract void initNetTask(int page);

	protected boolean isDataGotSucc(){
		return false;
	}
	public RecyclerView.ItemDecoration getItemDecoration(){
		DividerItemDecoration itemDecoration = new DividerItemDecoration(mViewList.getContext(),LinearLayoutManager.VERTICAL);
		itemDecoration.setDrawable(ContextCompat.getDrawable(getContext(),R.drawable.normal_list_item_decoration));
		return itemDecoration;
	}
	public boolean reqDataOnCreate(){
		return true;
	}



    protected static final int MSG_REQUEST_DATA = 1;
	private static final long FIRST_INIT_DELAY = 50;
	protected static final int MSG_TIP_RESULT_ERR = 2;
	protected  Handler mHandler = new Handler(){

		@Override
		public void handleMessage(Message msg) {
			// TODO Auto-generated method stub
			super.handleMessage(msg);
			switch(msg.what){
				case MSG_REQUEST_DATA :{
					mSwipeRefreshLayout.setRefreshing(true);

					requestData(getCurrentPage() ,false);
					break;
				}
				case MSG_TIP_RESULT_ERR :{
					if(msg.obj != null && msg.obj instanceof String){
						final String errTip = (String) msg.obj;
						BaseApp.getInstance().toast(errTip);
						
					}
					
					break;
				}
			}
		}
	};
	private int getCurrentPage(){
		if(mAdapter.getItems() == null || mAdapter.getItems().size() == 0){
			return 0;
		}
		return mAdapter.getItems().size() % getSizeInPage() == 0 ? mAdapter.getItems().size() / getSizeInPage() - 1 : mAdapter.getItems().size() / getSizeInPage();
	}
	@Override
	public void onDestroy() {
		super.onDestroy();
		
	}
	
	@Override
	public void onRefresh() {
		if(CommonUtil.isNetworkConnected(mViewList.getContext())){
			reloadData();
		} else {
			BaseApp.getInstance().toast(R.string.network_not_connection);
			mSwipeRefreshLayout.setRefreshing(false);
		}
	}
	
	public void reloadData(){
		reloadData(false);
	}
	public void reloadData(boolean showloading) {


		if (mAdapter != null) {
			mAdapter.clearData();
			mAdapter.notifyDataSetChanged();
		}
		requestData(0, false);
	}

	public void reloadWithUi(boolean showloading) {
		if (mViewList.getContext() != null) {
			if (CommonUtil.isNetworkConnected(mViewList.getContext())) {
				mSwipeRefreshLayout.setRefreshing(true);
				reloadData();
			} else {
				BaseApp.getInstance().toast(R.string.network_not_connection);
			}
		}

	}



	private class GetBeanListTask extends AsyncTask {

		@Override
		protected Object doInBackground(Object... params) {
			// TODO Auto-generated method stub
			return convertToBeanList(params[0].toString());
		}

		@Override
		protected void onPostExecute(Object result) {
			// TODO Auto-generated method stub
			super.onPostExecute(result);
			onBeanListGot(result == null ? null : (List<BasePo>)result);
		}
	}

	protected void onBeanListGot(List<? extends  BasePo> listResult){
		BaseApp.getInstance().showLoading(false);
		mSwipeRefreshLayout.setRefreshing(false);
		hideEmpty();
		if(listResult == null){
			mAdapter.onFinishLoading(true);
			checkShowEmpty(mAdapter);
			return;
		}
		
		
		List items = mAdapter.getItems();
		final int startIndex = (items == null || items.size() == 0) ? (mAdapter.getHeaderEnabled() ? 1 : 0) : mAdapter.getItemCount() - 1;

		mAdapter.addItems(listResult);
		if(listResult.size() < getSizeInPage()){
			mAdapter.onFinishLoading(false);
		} else {
			mAdapter.onFinishLoading(true);
		}
		checkShowEmpty(mAdapter);
		if(listResult == null || listResult.size() == 0){
			return;
		}
		/*if(startIndex > 0){
			mAdapter.notifyItemChanged(startIndex);
		}*/
		//mAdapter.notifyItemRangeInserted(startIndex,listResult.size());
		//mViewList.scrollToPosition(startIndex);
		mAdapter.notifyDataSetChanged();

	}

	protected void checkShowEmpty(BasePageAdapter adapter){
		final List items = adapter.getItems();
		if(items == null || items.size() == 0){
			showEmpty();
		}
	}
	
	
}
