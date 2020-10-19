package com.wanzhong.core.frag;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.gyf.barlibrary.ImmersionBar;
import com.gyf.barlibrary.SimpleImmersionFragment;
import com.wanzhong.common.util.StringUtil;
import com.wanzhong.core.R;
import com.wanzhong.core.dialog.LoadingDialog;
import com.wanzhong.core.utils.BaseConsts;

import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.appcompat.widget.Toolbar;


/**
 * 开发者: ZhangZev
 * 时间: 2018/12/6 10:12
 * 描述：Fragment基类
 */

public abstract class BaseFragment extends SimpleImmersionFragment {

    protected LoadingDialog loadingDialog;
    protected Activity mActivity;
    protected View mRootView;

    //protected Unbinder unbinder;

    //@BindView(R2.id.base_view)
    View baseView;//状态栏

    //@BindView(R2.id.toolbar)
    protected Toolbar toolbar;
    // @BindView(R2.id.ll_right)
    protected LinearLayout ll_right;
    //@BindView(R2.id.img_left)
    protected ImageView mTitleLeftImg;//左边按钮
    //@BindView(R2.id.tv_title)
    protected TextView mTitleTv;//标题
    //@BindView(R2.id.tv_right)
    protected TextView mTitleRightTv;//标题
    //@BindView(R2.id.img_right)
    protected ImageView mTitleRightImg;//右边按钮
    //@BindView(R2.id.tv_lefttitle)
    TextView mLeftTitle;//左边标题


    //@BindView(R2.id.rl_search)
    protected RelativeLayout mSearchView;//带搜索框和右边按钮的
    //@BindView(R2.id.search_edit)
    protected AppCompatEditText mSearchEdittext;
    //@BindView(R2.id.img_left_tvright)
    protected ImageView mTitleLeftRightImage;//右边按钮


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mActivity = (Activity) context;
    }

    public Context getFragContext() {
        if (mRootView != null) {
            return mRootView.getContext();
        }
        return getContext();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mRootView = inflater.inflate(getLayoutId(), container, false);
        //unbinder = ButterKnife.bind(this, mRootView);
        baseView = mRootView.findViewById(R.id.base_view);
        toolbar = mRootView.findViewById(R.id.toolbar);
        ll_right = mRootView.findViewById(R.id.ll_right);
        mTitleLeftImg = mRootView.findViewById(R.id.img_left);
        mTitleTv = mRootView.findViewById(R.id.tv_title);
        mTitleRightTv = mRootView.findViewById(R.id.tv_right);
        mTitleRightImg = mRootView.findViewById(R.id.img_right);
        mTitleLeftRightImage = mRootView.findViewById(R.id.img_left_tvright);
        mSearchView = mRootView.findViewById(R.id.rl_search);
        mSearchEdittext = mRootView.findViewById(R.id.search_edit);
        if (getArguments() != null && getArguments().containsKey(BaseConsts.EXT_TITLE)) {
            setTitle(getArguments().getString(BaseConsts.EXT_TITLE));
        }
        return mRootView;
    }


    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        if (immersionBarEnabled()) {
            ImmersionBar.setTitleBar(mActivity, toolbar);
        }

        initView(view);
        initData();
        setListener();
        // testHeight(toolbar);
    }


    private void testHeight(View view) {
        final ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams.height == ViewGroup.LayoutParams.WRAP_CONTENT ||
                layoutParams.height == ViewGroup.LayoutParams.MATCH_PARENT) {
            view.post(new Runnable() {
                @Override
                public void run() {
                    layoutParams.height = view.getHeight() + ImmersionBar.getStatusBarHeight(mActivity);
                    view.setPadding(view.getPaddingLeft(),
                            view.getPaddingTop() + ImmersionBar.getStatusBarHeight(mActivity),
                            view.getPaddingRight(),
                            view.getPaddingBottom());
                }
            });
        } else {
            layoutParams.height += ImmersionBar.getStatusBarHeight(mActivity);
            Log.e("cx", layoutParams + " ====  " + layoutParams.height + " ============== " + view.getPaddingTop() + "===" + ImmersionBar.getStatusBarHeight(mActivity));

            view.setPadding(view.getPaddingLeft(), view.getPaddingTop() + ImmersionBar.getStatusBarHeight(mActivity),
                    view.getPaddingRight(), view.getPaddingBottom());
        }
    }
  /*  @Override
    public void onHiddenChanged(boolean hidden) {
        super.onHiddenChanged(hidden);
        if (!hidden)
            ImmersionBar.with(this).init();
    }*/


    /**
     * Gets layout id.
     *
     * @return the layout id
     */
    protected abstract int getLayoutId();


    /**
     * 加载框 显示隐藏
     *
     * @param show true显示、false隐藏
     */
    protected void showOrHide(boolean show) {
        if (getActivity().isFinishing()) {
            return;
        }
        if (show) {
            loadingDialog = new LoadingDialog(getActivity());
            if (!loadingDialog.isShowing()) {
                if (loadingDialog != null && !getActivity().isFinishing()) {
                    loadingDialog.show();
                }
            }
        } else {
            if (loadingDialog != null) {
                loadingDialog.dismiss();
            }
        }
    }

    @Override
    public void onPause() {
        super.onPause();
        if (loadingDialog != null) {
            loadingDialog.dismiss();
            loadingDialog = null;
        }
    }

    @Override
    public void initImmersionBar() {
        Log.e("cx", "===-------initImmersionBar-------===" + mActivity + " ====  " + toolbar);
        if (immersionBarEnabled()) {
            ImmersionBar.with(this).statusBarDarkFont(isStatusBarDarkFont()).init();
        }

    }

    protected boolean isStatusBarDarkFont() {
        return false;
    }


    /**
     * 初始化导航左边按钮
     */
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

    protected void setLeftTitle(String title) {
        if (mLeftTitle != null) {
            mLeftTitle.setVisibility(View.VISIBLE);
            mLeftTitle.setText(title);
        }
    }

    protected void setTitle(String title) {
        mTitleTv.setVisibility(View.VISIBLE);
        if (mTitleTv != null) {
            mTitleTv.setText(title);
        }
    }

    /**
     * 设置搜索不显示光标
     *
     * @param isShow true 显示
     */
    protected void setSearchView(boolean isShow) {
        if (isShow) {
            setSearchEditView(isShow);
        } else {
            mSearchView.setVisibility(View.VISIBLE);
            mSearchEdittext.setCursorVisible(isShow);
            mSearchEdittext.setFocusable(isShow);
            mSearchEdittext.setFocusableInTouchMode(isShow);
        }
    }

    private void setSearchEditView(boolean isShow) {
        mSearchView.setVisibility(View.VISIBLE);
        mSearchEdittext.setFocusable(isShow);
        mSearchEdittext.setCursorVisible(isShow);
        mSearchEdittext.setFocusableInTouchMode(isShow);
        mSearchEdittext.requestFocus();
    }

    /**
     * 右边菜单设置
     *
     * @param textIsShow 是否显示文本（true 显示则按钮不显示）
     * @param text       显示文本信息
     * @param rightImage 显示右侧图标按钮
     */
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

    protected void showRightInfo(String text, int rightImage) {
        if (StringUtil.isNotNullAndSpace(text)) {
            mTitleRightTv.setVisibility(View.VISIBLE);
            mTitleRightTv.setPadding(10, 0, 10, 0);
            mTitleRightTv.setText(text);
        } else {
            mTitleRightTv.setVisibility(View.GONE);
        }
        if (rightImage > 0) {
            mTitleRightImg.setVisibility(View.VISIBLE);
            mTitleRightImg.setPadding(0, 0, 10, 0);
            mTitleRightImg.setImageResource(rightImage);
        } else {
            mTitleRightImg.setVisibility(View.GONE);
        }

    }

    /**
     * @param text
     * @param rightImage 图片
     * @param isRight    是否在最右边
     */
    protected void showRightInfo(String text, int rightImage, boolean isRight) {
        if (isRight) {
            showRightInfo(text, rightImage);
        } else {
            LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(mTitleRightTv.getLayoutParams());
            lp.setMargins(-12, 0, 0, 0);
            mTitleRightTv.setLayoutParams(lp);
            mTitleRightTv.setVisibility(View.VISIBLE);
            mTitleLeftRightImage.setVisibility(View.VISIBLE);
            mTitleRightImg.setVisibility(View.GONE);
            mTitleRightTv.setText(text);
            mTitleLeftRightImage.setImageResource(rightImage);
        }
    }

    /**
     * 初始化数据
     */
    protected void initData() {
    }

    /**
     * view与数据绑定
     */
    protected void initView(View view) {

    }

    /**
     * 设置监听
     */
    protected void setListener() {

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        loadingDialog = null;
    }
}
