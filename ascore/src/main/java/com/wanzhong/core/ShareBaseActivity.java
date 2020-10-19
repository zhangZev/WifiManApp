/*
package com.wanzhong.core;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;

import com.wanzhong.common.util.StringUtil;
import com.wanzhong.common.util.SysContants;
import com.wanzhong.core.entity.ShareContent;
import com.wanzhong.core.utils.BaseConsts;
import com.wanzhong.core.utils.WechatShareManager;

import androidx.fragment.app.Fragment;

import static com.wanzhong.core.utils.WechatShareManager.WECHAT_SHARE_TYPE_FRENDS;
import static com.wanzhong.core.utils.WechatShareManager.WECHAT_SHARE_TYPE_TALK;

public class ShareBaseActivity extends BaseActivity implements WechatShareManager.dismissDialog, View.OnClickListener {


    private WechatShareManager mSahreManager;

    protected ShareContent mShareContent;
    protected View llBottom;
    protected ImageView img_icon;
    protected EditText et_title;
    protected ImageView img_edit;

    public static void start(Activity activity, ShareContent shareContent){
        if(shareContent == null){
            BaseApp.getInstance().toast("分享内容获取失败");
            return;
        }
        Intent intent = new Intent(activity,ShareBaseActivity.class);
        intent.putExtra(BaseConsts.EXT_DATA,shareContent);
        activity.startActivity(intent);
    }
    public static void start(Fragment fragment, ShareContent shareContent){
        if(shareContent == null){
            BaseApp.getInstance().toast("分享内容获取失败");
            return;
        }
        Intent intent = new Intent(fragment.getContext(),ShareBaseActivity.class);
        intent.putExtra(BaseConsts.EXT_DATA,shareContent);
        fragment.startActivity(intent);
    }
    @Override
    protected int getLayoutId() {
        return R.layout.activity_share_base;
    }
    protected boolean setDefaultActivityBg(){
        return false;
    }

    @Override
    protected void initView() {
        super.initView();
        toolbar.setVisibility(View.GONE);
        if(getIntent().hasExtra(BaseConsts.EXT_DATA)){
            mShareContent = (ShareContent)getIntent().getSerializableExtra(BaseConsts.EXT_DATA);
            updateContentShow();
        }
        mSahreManager = WechatShareManager.getInstance(this);
        //bitmap_share = BitmapFactory.decodeResource(getResources(),R.drawable.share_thumb_default);
        llBottom = findViewById(R.id.llBottom);
        img_icon = findViewById(R.id.img_icon);
        et_title = findViewById(R.id.et_title);
        img_edit = findViewById(R.id.img_edit);
        findViewById(R.id.img_edit).setOnClickListener(this);
        findViewById(R.id.flBack).setOnClickListener(this);
        findViewById(R.id.tv_cancle).setOnClickListener(this);
        findViewById(R.id.rl_share_wechat).setOnClickListener(this);
        findViewById(R.id.rl_share_wechat_circle).setOnClickListener(this);
        llBottom.setOnClickListener(this);
    }

    public void updateContentShow(){
        if(mShareContent == null){
            return;
        }
        if(mShareContent.getBitmap() != null && !mShareContent.getBitmap().isRecycled()){
            img_icon.setImageBitmap(mShareContent.getBitmap());
        } else if(mShareContent.getPictureResource() > 0){
            img_icon.setImageResource(mShareContent.getPictureResource());
        } else {
            img_icon.setImageResource(R.drawable.share_thumb_default);
        }
        et_title.setText(mShareContent.getTitle());
    }
    @Override
    protected void initData() {
        super.initData();
    }

    @Override
    protected void setListener() {
        super.setListener();
        mSahreManager.setmDismissListener(this);
    }

    protected String mShareType;
    public void onClick(View v) {
        final int id = v.getId();
        if(id == R.id.flBack || id == R.id.tv_cancle){
            onBackPressed();
        } else if(id == R.id.rl_share_wechat || id == R.id.rl_share_wechat_circle){
            final String title = et_title.getText().toString();
            if(StringUtil.isNullOrSpace(title.trim())){
                BaseApp.getInstance().toast("分享标题不能为空");
                return;
            }
            mShareContent.setTitle(title);
            showOrHide(true);
            int shareType = WECHAT_SHARE_TYPE_TALK;
            mShareType = SysContants.CHAR_0;
            if(id == R.id.rl_share_wechat_circle){
                shareType = WECHAT_SHARE_TYPE_FRENDS;
                mShareType = SysContants.CHAR_1;
            }
            mSahreManager.shareByWebchat(mShareContent, shareType);
        } else if(id == R.id.img_edit){
            img_edit.setVisibility(View.GONE);
            et_title.setEnabled(true);
            if(et_title.getText().length() > 0){
                et_title.setSelection(et_title.getText().length() );

            }
            et_title.postDelayed(new Runnable() {
                @Override
                public void run() {
                    et_title.requestFocus();
                    InputMethodManager manager = ((InputMethodManager)ShareBaseActivity.this.getSystemService(Context.INPUT_METHOD_SERVICE));
                    if (manager != null) manager.showSoftInput(et_title, 0);
                }
            }, 300);
        }
    }

    protected void shareDismiss() {
        showOrHide(false);
        finish();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if(mShareContent != null && mShareContent.getBitmap() != null && !mShareContent.getBitmap().isRecycled()){
            mShareContent.getBitmap().recycle();
        }
    }

    */
/**
     * 分享回调
     *//*

    @Override
    public void finshAndDis() {
        shareDismiss();
    }
}
*/
