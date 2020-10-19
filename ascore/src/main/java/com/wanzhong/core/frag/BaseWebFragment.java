package com.wanzhong.core.frag;

import android.content.Intent;


/**
 * 开发者: ZhangZev
 * 时间: 2018/12/6 10:12
 * 描述：WebFragment基类,多了JS接口
 */

public abstract class BaseWebFragment extends BaseFragment {

    public abstract void onBackPressed();
    //protected LoadingDialog loadingDialog;
    //protected Activity mActivity;
    //protected View mRootView;

   // private Unbinder unbinder;



   /* @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mActivity = (Activity) context;
    }*/

   /* @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mRootView = inflater.inflate(getLayoutId(), container, false);
        return mRootView;
    }*/

/*
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        //unbinder = ButterKnife.bind(this, view);
        *//*toolbar = view.findViewById(R.id.toolbar);
        mTitleLeftImg = view.findViewById(R.id.img_left);
        mTitleTv = view.findViewById(R.id.tv_title);
        mTitleRightTv = view.findViewById(R.id.tv_right);
        mTitleRightImg = view.findViewById(R.id.img_right);
        ImmersionBar.setTitleBar(mActivity, toolbar);*//*
        initData();
        initView();
        setListener();
    }*/

   /* @Override
    public void onDestroy() {
        super.onDestroy();
        //unbinder.unbind();
    }*/

    /**
     * Gets layout id.
     *
     * @return the layout id
     *//*
    protected abstract int getLayoutId();


   // public abstract JsInterface getJsInterface();


    *//**
     * 加载框 显示隐藏
     *
     * @param show true显示、false隐藏
     *//*
    protected void showOrHide(boolean show) {
        if (show) {
            if (loadingDialog==null) {
                loadingDialog = new LoadingDialog(getContext());
            }
            loadingDialog.show();
        } else {
            if (loadingDialog != null) {
                loadingDialog.dismiss();
            }
        }
    }

    @Override
    public void initImmersionBar() {
        ImmersionBar.with(this).init();
    }


    *//**
     * 初始化导航左边按钮
     *//*
    protected void initLeftListener() {
        if (mTitleLeftImg != null) {
            mTitleLeftImg.setVisibility(View.VISIBLE);
            mTitleLeftImg.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    getActivity().onBackPressed();
                }
            });
        }
    }

    *//*protected void setTitle(String title) {
        CommonUtil.err(mTitleTv+  " settitle "+title);
        if (mTitleTv != null) {
            mTitleTv.setText(title);
        }
    }*//*

    *//**
     * 右边菜单设置
     *
     * @param textIsShow 是否显示文本（true 显示则按钮不显示）
     * @param text       显示文本信息
     * @param rightImage 显示右侧图标按钮
     *//*
    protected void setRightInfo(boolean textIsShow, String text, int rightImage) {
        mTitleRightTv.setVisibility(View.GONE);
        mTitleRightImg.setVisibility(View.GONE);
        if (textIsShow) {
            //显示文字
            mTitleRightTv.setText(text);
            mTitleRightTv.setVisibility(View.VISIBLE);
        } else {
            mTitleRightImg.setVisibility(View.VISIBLE);
            mTitleRightImg.setImageResource(rightImage);
        }
    }

    *//**
     * 初始化数据
     *//*
    protected void initData() {

    }

    *//**
     * view与数据绑定
     *//*
    protected void initView() {

    }

    *//**
     * 设置监听
     *//*
    protected void setListener() {

    }*/
    public abstract void onNewIntent(Intent intent);

    public abstract void urlBackClicked();

}
