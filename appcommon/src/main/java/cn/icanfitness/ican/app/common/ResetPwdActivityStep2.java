package cn.icanfitness.ican.app.common;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

import com.wanzhong.core.BaseActivity;
import com.wanzhong.core.utils.FieldCheckUtils;


/**
 * A login screen that offers login .
 */
public class ResetPwdActivityStep2 extends BaseActivity {


    // UI references.
    private EditText mEditPwd;
    private EditText mEditPwdAgain;
    private View mBtnSubmit;
    private String mPhone,mCode;
    public static void start(Activity context, String phone, String code){
        Intent intent = new Intent(context, ResetPwdActivityStep2.class);
        intent.putExtra("phone",phone);
        intent.putExtra("code",code);
        context.startActivityForResult(intent,123);
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
        return R.layout.activity_reset_pwd_step2;
    }

    @Override
    protected void initData() {
        super.initData();
    }

    @Override
    protected void initView() {
        super.initView();
        // Set up the login form.
        mPhone = getIntent().getStringExtra("phone");
        mCode = getIntent().getStringExtra("code");
        mEditPwd = (EditText) findViewById(R.id.et_pwd);
        mBtnSubmit = (Button) findViewById(R.id.btn_submit);
        mEditPwdAgain = findViewById(R.id.et_pwd_again);
        mBtnSubmit.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                attemptSubmit();
            }
        });
    }

    /**
     * Attempts to sign in or register the account specified by the login form.
     * If there are form errors (invalid email, missing fields, etc.), the
     * errors are presented and no actual login attempt is made.
     */
    private void attemptSubmit() {
        String password = mEditPwd.getText().toString();
        String passwordAgain = mEditPwdAgain.getText().toString();
        if(!FieldCheckUtils.isValidPassword(password)){
            AppCommon.getInstance().toast(R.string.error_invalid_password);
            mEditPwd.requestFocus();
            return;
        }
        if(!password.equals(passwordAgain)){
            AppCommon.getInstance().toast("两次输入密码不一致，请重新输入");
            mEditPwd.requestFocus();
            return;
        }

        setResult(RESULT_OK);
        finish();

        // Store values at the time of the login attempt.
        /*String password = mEditPwd.getText().toString();
        final ForgetPwdPo po = new ForgetPwdPo();
        po.passwd = password;
        //TODO chenxian

        RetrofitProvider.getCommApiInstance().forgetPwd(loginId, MD5.md5(MD5.md5(password)),mEditCode.getText().toString())
                .subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
                .subscribe(new BaseSubscriber<ComRespPo>(true) {
                    @Override
                    public void onNext(ComRespPo retPo) {
                        //CommonUtil.toastUser(ResetPwdActivity.this,"login Info "+retPo);
                        if(retPo == null || retPo.isResultErr()){
                            CommonUtil.toastUser(ResetPwdActivityStep2.this,retPo.getRetMsg());
                        } else {
                            CommonUtil.toastUser(ResetPwdActivityStep2.this,"找回密码成功，请登录");
                            setResult(RESULT_OK);
                            finish();
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        super.onError(e);
                        android.util.Log.e("test","====regist err "+e);
                    }

                });*/

    }



}

