package com.wanzhong.core;

import android.content.Context;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.gyf.barlibrary.ImmersionBar;
import com.wanzhong.core.dialog.LoadingDialog;

import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.appcompat.widget.Toolbar;
import butterknife.ButterKnife;



/**
 * 开发者: ZhangZev
 * 时间: 2018/12/6 10:11
 * 描述：Activity基类
 */

public abstract class BaseActivity extends CoreBaseActivity {

    private InputMethodManager mInputMethodManager;
    public LoadingDialog loadingDialog;//加载框

    //@BindView(R2.id.base_view)
    protected View baseView;//状态栏
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
    //@BindView(R2.id.img_left_tvright)
    protected ImageView mTitleLeftRightImage;//右边按钮


    //@BindView(R2.id.rl_search)
    protected RelativeLayout mSearchView;//带搜索框和右边按钮的
    //@BindView(R2.id.search_edit)
    protected AppCompatEditText mSearchEdittext;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(getLayoutId());
        //绑定控件
        //ButterKnife.bind(this);
        baseView = findViewById(R.id.base_view);
        toolbar = findViewById(R.id.toolbar);
        ll_right = findViewById(R.id.ll_right);
        mTitleLeftImg = findViewById(R.id.img_left);
        mTitleTv = findViewById(R.id.tv_title);
        mTitleRightTv = findViewById(R.id.tv_right);
        mTitleRightImg = findViewById(R.id.img_right);
        mTitleLeftRightImage = findViewById(R.id.img_left_tvright);
        mSearchView = findViewById(R.id.rl_search);
        mSearchEdittext = findViewById(R.id.search_edit);
        ButterKnife.bind(this);
        //初始化沉浸式
        if (isImmersionBarEnabled()) {
            initImmersionBar();
        }
        //view与数据绑定
        initView();
        //初始化数据
        initData();

        //设置监听
        setListener();

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
                    onBackPressed();
                }
            });
        }
    }


    @Override
    public void setTitle(CharSequence title) {
        super.setTitle(title);
        mTitleTv.setVisibility(View.VISIBLE);
        if (mTitleTv != null) {
            mTitleTv.setText(title);
        }
    }

    @Override
    public void setTitle(int titleId) {
        super.setTitle(titleId);
        mTitleTv.setVisibility(View.VISIBLE);
        if (mTitleTv != null) {
            mTitleTv.setText(getString(titleId));
        }
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

    /**
     * @param text
     * @param rightImage 图片
     * @param isRight    是否在最右边
     */
    protected void showRightInfo(String text, int rightImage, boolean isRight) {
        if (isRight) {
            mTitleRightTv.setVisibility(View.VISIBLE);
            mTitleRightImg.setVisibility(View.VISIBLE);
            mTitleLeftRightImage.setVisibility(View.GONE);
            mTitleRightTv.setPadding(10, 0, 10, 0);
            mTitleRightImg.setPadding(0, 0, 10, 0);
            mTitleRightTv.setText(text);
            mTitleRightImg.setImageResource(rightImage);
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
     * 设置搜索不显示光标
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
     * 子类设置布局Id
     *
     * @return the layout id
     */
    protected abstract int getLayoutId();

    protected void initImmersionBar() {
        ImmersionBar.with(this).statusBarDarkFont(isStatusBarDarkFont()).init();
        ImmersionBar.setTitleBar(this, toolbar);
        //在BaseActivity里初始化
        //ImmersionBar.with(this).navigationBarColor(R.color.colorPrimary).init();
    }

    /**
     * 底部输入框与软键盘问题
     *
     * @param isKey
     */
    protected void setKeyBoard(boolean isKey) {
        ImmersionBar.with(this).keyboardEnable(isKey).init();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        /*if (isImmersionBarEnabled()) {
            ImmersionBar.with(this).init();
        }*/
    }

    protected void initData() {
        final CharSequence title = getTitle();
        if(title != null){
            setTitle(title);
        }
    }

    protected void initView() {
    }

    protected void setListener() {
    }

    /**
     * 加载框 显示隐藏
     *
     * @param show true显示、false隐藏
     */
    public void showOrHide(boolean show) {
        if (show) {
            loadingDialog = new LoadingDialog(this);
            loadingDialog.show();
        } else {
            if (loadingDialog != null) {
                loadingDialog.dismiss();
            }
        }
    }


    /**
     * 是否可以使用沉浸式
     * Is immersion bar enabled boolean.
     *
     * @return the boolean
     */
    protected boolean isImmersionBarEnabled() {
        return true;
    }

    @Override
    public void finish() {
        super.finish();
        hideSoftKeyBoard();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mInputMethodManager = null;
        if (isImmersionBarEnabled()) {
            ImmersionBar.with(this).destroy();
        }
    }


    public void hideSoftKeyBoard() {
        View localView = getCurrentFocus();
        if (this.mInputMethodManager == null) {
            this.mInputMethodManager = ((InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE));
        }
        if ((localView != null) && (this.mInputMethodManager != null)) {
            this.mInputMethodManager.hideSoftInputFromWindow(localView.getWindowToken(), 2);
        }
    }
}
