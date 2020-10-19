package cn.icanfitness.ican.app.common;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.text.Html;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.wanzhong.common.po.ComRequestPo;
import com.wanzhong.common.util.StringUtil;
import com.wanzhong.core.BaseActivity;
import com.wanzhong.core.BaseApp;
import com.wanzhong.core.utils.FieldCheckUtils;
import com.wanzhong.data.net.BaseSubscriber;
import com.wanzhong.data.net.RetrofitProvider;
import com.wanzhong.data.po.ComRespPo;


import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * A login screen that offers login .
 */
public class RegistActivity extends BaseActivity implements OnClickListener {


    // UI references.
    private EditText mEditLoginId;
    private EditText mEditPwd;
    private EditText mEditCode;
    private TextView mBtnSendCode;
    private EditText mEditNickName;
    private TextView mTvUserAgreement;
    private View mBtnSubmit;
    public static void start(Context context){
        Intent intent = new Intent(context, RegistActivity.class);
        context.startActivity(intent);
    }
    @Override
    protected int getThemeId(){
        return R.style.MultiThemeMain;
    }
    @Override
    protected boolean isStatusBarDarkFont() {
        return false;
    }
    @Override
    protected int getLayoutId() {
        return R.layout.activity_regist;
    }

    @Override
    protected void initData() {
        super.initData();
    }

    @Override
    protected void initView() {
        super.initView();
        // Set up the login form.
        mEditLoginId = (EditText) findViewById(R.id.et_loginid);
        mEditPwd = (EditText) findViewById(R.id.et_pwd);
        mBtnSubmit = (Button) findViewById(R.id.btn_submit);
        mEditCode = findViewById(R.id.et_code);
        mBtnSendCode = findViewById(R.id.btn_send_code);
        mEditNickName = findViewById(R.id.et_nick);
        mTvUserAgreement = findViewById(R.id.tv_user_agreement);
        mTvUserAgreement.setText(Html.fromHtml("注册即视为同意<font color='#ba222f'>《乾信拍服务协议》</font>"));
        mBtnSubmit.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                attemptSubmit();
            }
        });
        mBtnSendCode.setOnClickListener(this);
    }

    /**
     * Attempts to sign in or register the account specified by the login form.
     * If there are form errors (invalid email, missing fields, etc.), the
     * errors are presented and no actual login attempt is made.
     */
    private void attemptSubmit() {

        // Store values at the time of the login attempt.
        String loginId = mEditLoginId.getText().toString();
        String code =  mEditCode.getText().toString();
        String nick =  mEditNickName.getText().toString();
        String password = mEditPwd.getText().toString();
        final ComRequestPo po = null;
        //TODO chenxian

        if(!FieldCheckUtils.isPhoneNum(loginId)){
            BaseApp.getInstance().toast(R.string.prompt_loginid);
            mEditLoginId.requestFocus();
            return;
        }

        if(StringUtil.isNullOrSpace(code)){
            AppCommon.getInstance().toast(R.string.prompt_msg_code);
            mEditCode.requestFocus();
            return;
        }
        if(StringUtil.isNullOrSpace(nick)){
            AppCommon.getInstance().toast(R.string.prompt_nick_err);
            mEditNickName.requestFocus();
            return;
        }
        if(!FieldCheckUtils.isValidPassword(password)){
            AppCommon.getInstance().toast(R.string.error_invalid_password);
            mEditPwd.requestFocus();
            return;
        }
        /*RetrofitProvider.getCommApiInstance().register(po.toRequestBody())
                .subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
                .subscribe(new BaseSubscriber<BasePo>(true) {
                    @Override
                    public void onNext(BasePo retPo) {
                       // CommonUtil.toastUser(RegistActivity.this,"setImageLeftTopCover "+retPo);
                        if(retPo == null){
                            CommonUtil.toastUser(RegistActivity.this,R.string.login_fail);
                        } else {
                            CommonUtil.toastUser(RegistActivity.this,R.string.login_succ);
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        super.onError(e);
                        android.util.Log.e("test","====regist err "+e);
                    }

                });*/

    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        if(id == R.id.btn_send_code){
            final String phone = mEditLoginId.getText() == null ? "" : mEditLoginId.getText().toString();

            if(!FieldCheckUtils.isPhoneNum(phone)){
                BaseApp.getInstance().toast(R.string.prompt_loginid);
                mEditLoginId.requestFocus();
                return;
            }
            RetrofitProvider.getCommApiInstance().getVerCode(phone)
                    .subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
                    .subscribe(new BaseSubscriber<ComRespPo>(true) {
                        @Override
                        public void onNext(ComRespPo respPo) {
                            super.onNext(respPo);
                            if(!respPo.isResultOk()){
                                AppCommon.getInstance().toast(respPo.getRetMsg());
                            } else {
                                BaseApp.getInstance().toast(R.string.msg_code_sent_succeed);
                                mHandler.sendEmptyMessage(MSG_SECOND_CHECK);
                            }

                        }

                        @Override
                        public void onError(Throwable e) {
                            super.onError(e);
                            BaseApp.getInstance().toast(R.string.msg_code_sent_failed);
                        }

                    });
        }
    }

    private int mWaitSecond = 60;
    private static final int MSG_SECOND_CHECK =1;
    private Handler mHandler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what){
                case MSG_SECOND_CHECK:{
                    if(mWaitSecond > 0){
                        try{
                            mBtnSendCode.setEnabled(false);
                            mBtnSendCode.setText(getString(R.string.msg_get_code_wait,mWaitSecond--));
                            mHandler.sendEmptyMessageDelayed(MSG_SECOND_CHECK, 1000);
                        } catch(Exception e){

                        }
                    } else {
                        mBtnSendCode.setEnabled(true);
                        mBtnSendCode.setText(getString(R.string.msg_send_code));
                    }

                    break;
                }
            }
        }
    };

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if(mHandler.hasMessages(MSG_SECOND_CHECK)){
            mHandler.removeMessages(MSG_SECOND_CHECK);
        }

    }

}

