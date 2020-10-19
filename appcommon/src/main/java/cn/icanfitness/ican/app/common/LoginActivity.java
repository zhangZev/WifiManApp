package cn.icanfitness.ican.app.common;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.Html;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;


import androidx.annotation.Nullable;

import com.wanzhong.common.util.StringUtil;
import com.wanzhong.common.util.SysContants;
import com.wanzhong.core.BaseActivity;
import com.wanzhong.core.utils.BaseConsts;
import com.wanzhong.core.utils.CommonUtil;
import com.wanzhong.core.utils.FieldCheckUtils;
import com.wanzhong.core.utils.MD5;
import com.wanzhong.core.utils.SPUtil;
import com.wanzhong.data.net.BaseSubscriber;
import com.wanzhong.data.net.RetrofitProvider;
import com.wanzhong.data.po.ComResDataPo;
import com.wanzhong.data.po.CustomerBasePo;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
/**
 * A login screen that offers login .
 */
public class LoginActivity extends BaseActivity implements OnClickListener, TextWatcher {


    // UI references.
    protected EditText mEditLoginId;
    protected EditText mEditPwd;
    private CheckBox mCheckBoxRemember;
    protected View mBtnLogin;
    private Class classAfterLogin;
    protected String mRemembedPwd;
    private TextView mTvAgreement;
    public static void start(Context context, Class jumpToClass, boolean clearActivitys){
        Intent intent = new Intent(context,LoginActivity.class);
        intent.putExtra("jumpToClass",jumpToClass);
        if(clearActivitys){
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        }
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
        return R.layout.activity_login;
    }

    @Override
    protected void initData() {
        super.initData();
        classAfterLogin = (Class)getIntent().getSerializableExtra("jumpToClass");
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

    }

    @Override
    protected void initView() {
        super.initView();
        setTitle(R.string.login);
        // Set up the login form.
        mEditLoginId = (EditText) findViewById(R.id.et_loginid);
        mEditPwd = (EditText) findViewById(R.id.et_pwd);
        mEditPwd.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView textView, int id, KeyEvent keyEvent) {
                if (id == EditorInfo.IME_ACTION_DONE || id == EditorInfo.IME_NULL) {
                    attemptLogin();
                    return true;
                }
                return false;
            }
        });
        mEditLoginId.addTextChangedListener(this);
        mEditPwd.addTextChangedListener(this);
        mBtnLogin = (Button) findViewById(R.id.btn_login);
        mBtnLogin.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                attemptLogin();
            }
        });

        mTvAgreement  = findViewById(R.id.tv_user_agreement);
        mTvAgreement.setText(Html.fromHtml("登录即表示同意<font color='#24a3ff'>《万众汽车使用协议》</font>"));
        mTvAgreement.setOnClickListener(this);
        //Beta.checkUpgrade(false,false);
        //AppCommonUtils.getInstance().updateApp(true);
        findViewById(R.id.btn_forget_pwd).setOnClickListener(this);
        findViewById(R.id.btn_regist).setOnClickListener(this);
        mCheckBoxRemember = findViewById(R.id.checkbox_remember);

        final String loginId = (String) SPUtil.getInstant(this).get(BaseConsts.Pref.LOGIN_NAME,SysContants.CHAR_EMPTY);
        mRemembedPwd = (String) SPUtil.getInstant(this).get(BaseConsts.Pref.LOGIN_PWD, SysContants.CHAR_EMPTY);
        final int pwdSize = (int)SPUtil.getInstant(this).get(BaseConsts.Pref.LOGIN_PWD_SIZE,0);
        mEditLoginId.setText(loginId);
        if(pwdSize > 0 ){
            StringBuffer sb = new StringBuffer();
            for(int i = 0 ; i < pwdSize ; i++){
                sb.append("^");
            }
            mEditPwd.setText(sb);
        }
        if(StringUtil.isNotNullAndSpace(loginId) && StringUtil.isNotNullAndSpace(mRemembedPwd)){
            mCheckBoxRemember.setChecked(true);
        }
        if(StringUtil.isNotNullAndSpace(mRemembedPwd)){
            mEditPwd.setOnFocusChangeListener(new View.OnFocusChangeListener() {
                @Override
                public void onFocusChange(View v, boolean hasFocus) {
                    if(hasFocus && StringUtil.isNotNullAndSpace(mRemembedPwd)){
                        mEditPwd.setText(SysContants.CHAR_EMPTY);
                        mRemembedPwd = SysContants.CHAR_EMPTY;
                    }
                }
            });
        }
    }
    @Override
    public  void initLeftListener(){

    }

    protected boolean isLocalPwd = false;
    /**
     * Attempts to sign in or register the account specified by the login form.
     * If there are form errors (invalid email, missing fields, etc.), the
     * errors are presented and no actual login attempt is made.
     */
    protected void attemptLogin() {
        //BaseApp.getInstance().toast("检测个升级，热更新可以啊");
        /*Beta.checkUpgrade(true,false);
        if(true){
            *//*Intent intent = new Intent(this,TestActivity.class);
            startActivity(intent);*//*
            long s = System.currentTimeMillis();
            PatchUtil pathUtils = new PatchUtil();
            Toast.makeText(this,"diff ",Toast.LENGTH_SHORT).show();
            //pathUtils.diff(pathUtils.old,pathUtils.newp,pathUtils.patch);
            pathUtils.patch(pathUtils.old,pathUtils.tmp,pathUtils.patch);
            long s1 = System.currentTimeMillis();
            CommonUtil.err("================diff===========diff success"+(s1-s));
            return;
        }*/

        // Reset errors.
        mEditLoginId.setError(null);
        mEditPwd.setError(null);

        // Store values at the time of the login attempt.
        String loginId = mEditLoginId.getText().toString();
        String password = mEditPwd.getText().toString();
        if(!FieldCheckUtils.isValidLoginId(loginId)){
            AppCommon.getInstance().toast(R.string.prompt_loginid_err);
            mEditLoginId.requestFocus();
            return;
        }
        if(!FieldCheckUtils.isValidPassword(password)){
            AppCommon.getInstance().toast(R.string.error_invalid_password);
            mEditPwd.requestFocus();
            return;
        }
        //mBtnLogin.setEnabled(FieldCheckUtils.isValidLoginId(loginId) && FieldCheckUtils.isValidPassword(pwd));
      /*  String userType = null;
        if(AppCommonConfig.isClientSaas()){
            userType = SysContants.CHAR_0;
        } else if(AppCommonConfig.isClientAdmin()){
            userType = SysContants.CHAR_9;
        }*/
        isLocalPwd = false;
        if(StringUtil.isNullOrSpace(mRemembedPwd)){
            mRemembedPwd = MD5.md5(MD5.md5(password));
            isLocalPwd = true;

        }
        login(loginId,mRemembedPwd,password.length());


    }
    protected void login(String loginId,String pwd,int pwdLenght){
        RetrofitProvider.getCommApiInstance().login(loginId,pwd)
                .subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
                .subscribe(new BaseSubscriber<ComResDataPo<CustomerBasePo>>(true) {
                    @Override
                    public void onNext(ComResDataPo<CustomerBasePo> loginInfo) {
                        super.onNext(loginInfo);
                        onLoginResultGot(loginId,pwd,pwdLenght,loginInfo);
                    }

                    @Override
                    public void onError(Throwable e) {
                        super.onError(e);
                        if(isLocalPwd){
                            mRemembedPwd = SysContants.CHAR_EMPTY;
                        }
                    }

                });
    }

    protected void onLoginResultGot(String loginId,String pwd,int pwdLenght,ComResDataPo<CustomerBasePo> loginInfo){
        final boolean checked = mCheckBoxRemember.isChecked();

        if(loginInfo == null || loginInfo.getData() == null){
            CommonUtil.toastUser(LoginActivity.this,loginInfo.getRetMsg());
        } else {
            if(!loginInfo.isResultOk()){
                CommonUtil.toastUser(LoginActivity.this,loginInfo.getRetMsg());
                return;
            }
            SPUtil.getInstant(LoginActivity.this).save(BaseConsts.Pref.LOGIN_NAME,checked ? loginId : SysContants.CHAR_EMPTY);
            SPUtil.getInstant(LoginActivity.this).save(BaseConsts.Pref.LOGIN_PWD,checked ? pwd : SysContants.CHAR_EMPTY);
            SPUtil.getInstant(LoginActivity.this).save(BaseConsts.Pref.LOGIN_PWD_SIZE,checked ? pwdLenght : 0);
            ((AppCommon)AppCommon.getInstance()).setLogin(loginInfo.getData());
            //loginInfo.saveToFile(LoginActivity.this, BaseConsts.Pref.USER_INFO);
            if(classAfterLogin != null){
                Intent intent = new Intent(LoginActivity.this,classAfterLogin);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(intent);
            } else {
                CommonUtil.toastUser(LoginActivity.this,R.string.login_succ);
            }
        }
        if(isLocalPwd){
            mRemembedPwd = SysContants.CHAR_EMPTY;
        }
    }



    @Override
    public void onClick(View v) {
        int id = v.getId();
        if(id == R.id.btn_forget_pwd){
            ResetPwdActivityStep1.start(this);
        } else if(id == R.id.btn_regist){
            RegistActivity.start(this);

        } else if(id == R.id.tv_user_agreement){
            AppCommon.getInstance().toast("用户协议");
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
        final String pwd = mEditPwd.getText().toString();

        //mBtnLogin.setEnabled(FieldCheckUtils.isValidLoginId(loginId) && FieldCheckUtils.isValidPassword(pwd));
        mBtnLogin.setEnabled(/*FieldCheckUtils.isValidLoginId(loginId) && FieldCheckUtils.isValidPassword(pwd)*/true);
    }
}

