package cn.icanfitness.ican.app.common;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.wanzhong.common.util.StringUtil;
import com.wanzhong.core.BaseActivity;
import com.wanzhong.core.BaseApp;
import com.wanzhong.core.utils.FieldCheckUtils;
import com.wanzhong.data.net.BaseSubscriber;
import com.wanzhong.data.net.RetrofitProvider;
import com.wanzhong.data.po.ComRespPo;

import androidx.annotation.Nullable;

import com.wanzhong.core.BaseActivity;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * A login screen that offers login .
 */
public class ResetPwdActivityStep1 extends BaseActivity implements OnClickListener, TextWatcher {


    // UI references.
    private EditText mEditLoginId;
    private EditText mEditCode;
    private TextView mBtnSendCode;
    private View mBtnSubmit;
    public static void start(Context context){
        Intent intent = new Intent(context, ResetPwdActivityStep1.class);
        context.startActivity(intent);
    }
    @Override
    protected int getThemeId(){
        return com.wanzhong.core.R.style.MultiThemeMain;
    }
    @Override
    protected boolean isStatusBarDarkFont() {
        return false;
    }
    @Override
    protected int getLayoutId() {
        return R.layout.activity_reset_pwd_step1;
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
        mBtnSubmit = (Button) findViewById(R.id.btn_submit);
        mEditCode = findViewById(R.id.et_code);
        mBtnSendCode = findViewById(R.id.btn_send_code);
        mBtnSubmit.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                attemptSubmit();
            }
        });
        mBtnSendCode.setOnClickListener(this);
        mEditLoginId.addTextChangedListener(this);
        mEditCode.addTextChangedListener(this);



    }

    /**
     * Attempts to sign in or register the account specified by the login form.
     * If there are form errors (invalid email, missing fields, etc.), the
     * errors are presented and no actual login attempt is made.
     */
    private void attemptSubmit() {
        String loginId = mEditLoginId.getText().toString();
        String code =  mEditCode.getText().toString();

        if(!FieldCheckUtils.isValidLoginId(loginId)){
            AppCommon.getInstance().toast(R.string.prompt_loginid_err);
            mEditLoginId.requestFocus();
            return;
        }
        if(StringUtil.isNullOrSpace(code)){
            AppCommon.getInstance().toast(R.string.prompt_msg_code);
            mEditCode.requestFocus();
            return;
        }
        ResetPwdActivityStep2.start(this,loginId,code);


    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        if(id == R.id.btn_send_code){
            final String phone = mEditLoginId.getText() == null ? "" : mEditLoginId.getText().toString();

            if(!FieldCheckUtils.isPhoneNum(phone)){
                AppCommon.getInstance().toast(R.string.prompt_loginid_err);
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

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {

    }

    @Override
    public void afterTextChanged(Editable s) {
        final String loginId = mEditLoginId.getText().toString();
        //final String pwd = mEditPwd.getText().toString();
       // final String pwdAgain = mEditPwdAgain.getText().toString();
        final String msgCode = mEditCode.getText().toString();

//        mBtnSubmit.setEnabled(FieldCheckUtils.isValidLoginId(loginId) && FieldCheckUtils.isValidPassword(pwd)
//            && pwd.equals(pwdAgain) && StringUtil.isNotNullAndSpace(msgCode));
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

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == 123 && resultCode == RESULT_OK){
            setResult(RESULT_OK);
            finish();
        }
    }
}

