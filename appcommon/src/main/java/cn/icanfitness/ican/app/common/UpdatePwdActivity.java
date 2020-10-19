package cn.icanfitness.ican.app.common;

import android.content.Context;
import android.content.Intent;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

import com.wanzhong.core.BaseActivity;
import com.wanzhong.core.utils.FieldCheckUtils;


public class UpdatePwdActivity extends BaseActivity implements  TextWatcher {


    // UI references.
    protected EditText mEditOldPwd;
    protected EditText mEditPwd;
    protected EditText mEditPwdAgain;
    private View mBtnSubmit;
    public static void start(Context context){
        Intent intent = new Intent(context, UpdatePwdActivity.class);
        context.startActivity(intent);
    }
    @Override
    protected int getThemeId(){
        return R.style.MultiThemeMain;
    }
    @Override
    protected boolean isStatusBarDarkFont() {
        return true;
    }
    @Override
    protected int getLayoutId() {
        return R.layout.activity_update_pwd;
    }

    @Override
    protected void initData() {
        super.initData();
    }

    @Override
    protected void initView() {
        super.initView();
        // Set up the login form.
        mEditPwd = (EditText) findViewById(R.id.et_pwd);
        mBtnSubmit = (Button) findViewById(R.id.btn_submit);
        mEditOldPwd = findViewById(R.id.et_old_pwd);
        mEditPwdAgain = findViewById(R.id.et_pwd_again);
        mBtnSubmit.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                attemptSubmit();
            }
        });
        mEditPwd.addTextChangedListener(this);
        mEditPwdAgain.addTextChangedListener(this);
        mEditOldPwd.addTextChangedListener(this);

       // setRightInfo(true,"取消",-1);
        mTitleRightTv.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    /**
     * Attempts to sign in or register the account specified by the login form.
     * If there are form errors (invalid email, missing fields, etc.), the
     * errors are presented and no actual login attempt is made.
     */
    protected void attemptSubmit() {

        // Store values at the time of the login attempt.
        final String pwdOld = mEditOldPwd.getText().toString();
        final String pwd = mEditPwd.getText().toString();

        /*RetrofitProvider.getMineApisInstance().updatePwd(MD5.md5(MD5.md5(pwdOld)),MD5.md5(MD5.md5(pwd)))
                .subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
                .subscribe(new BaseSubscriber<ComRespPo>(true) {
                    @Override
                    public void onNext(ComRespPo retPo) {
                        super.onNext(retPo);
                        if(retPo == null || retPo.isResultErr()){
                            CommonUtil.toastUser(UpdatePwdActivity.this,retPo.getRetMsg());
                        } else {
                            CommonUtil.toastUser(UpdatePwdActivity.this,"修改密码成功");
                            AppCommon.getInstance().setLogOut();
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        super.onError(e);
                    }

                });*/

    }


    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {

    }

    @Override
    public void afterTextChanged(Editable s) {
        final String pwdOld = mEditOldPwd.getText().toString();
        final String pwd = mEditPwd.getText().toString();
        final String pwdAgain = mEditPwdAgain.getText().toString();

        mBtnSubmit.setEnabled(FieldCheckUtils.isValidPassword(pwdOld) && FieldCheckUtils.isValidPassword(pwd)
            && pwd.equals(pwdAgain) );
    }



}

