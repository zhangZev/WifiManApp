/*
package com.wanzhong.core.webview;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.widget.LinearLayout;

import com.tencent.smtt.sdk.WebChromeClient;
import com.tencent.smtt.sdk.WebSettings;
import com.tencent.smtt.sdk.WebView;
import com.tencent.smtt.sdk.WebViewClient;
import com.wanzhong.common.util.StringUtil;
import com.wanzhong.core.BaseActivity;
import com.wanzhong.core.BaseApp;
import com.wanzhong.core.R;
import com.wanzhong.core.utils.BaseConsts;
import com.wanzhong.core.utils.CommonUtil;
import com.wanzhong.core.view.bottombar.UIUtils;


*/
/**
 * 开发者: ZhangZev
 * 时间: 2019/3/4
 * 描述：
 *//*

public class SuperWebWithTitleActivity extends BaseActivity {

    //@BindView(R2.id.superWebview)
    WebView superWebview;

    public static void start(Context context, String url,String title){
        start(context,url,title,false);
    }
    protected boolean isStatusBarDarkFont(){
        return true;
    }
    protected int getThemeId(){
        return R.style.MultiThemeWhite;
    }

    public static void start(Context context, String url,String title,boolean neetToken){
        Intent intent = new Intent();
        intent.setClass(context, SuperWebWithTitleActivity.class);
        if(neetToken){
            String token = BaseApp.getInstance().getToken();
            url += token;
        }
        intent.putExtra("startUrl", url);
        if(StringUtil.isNotNullAndSpace(title)){
            intent.putExtra("title", title);
        }
        context.startActivity(intent);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_titlesuperwebview;
    }

    @Override
    protected void initView() {
        super.initView();
        superWebview = findViewById(R.id.superWebview);
        initLeftListener();
        //支持javascript
        superWebview.getSettings().setJavaScriptEnabled(true);
        //自适应屏幕
        WebSettings webSetting = superWebview.getSettings();
        webSetting.setLoadWithOverviewMode(true);
        String title = null;
        if(getIntent() != null && getIntent().hasExtra("title")){
            title = getIntent().getStringExtra("title");
        }
        if(StringUtil.isNotNullAndSpace(title)){
            setTitle(title);
        } else {
            superWebview.setWebChromeClient(new MyWebChromeClient());
        }
        webSetting.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.SINGLE_COLUMN);
        //此方法不支持4.4以后
        webSetting.setUseWideViewPort(true);
        webSetting.setJavaScriptEnabled(true);
        webSetting.setDomStorageEnabled(true);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            webSetting.setMixedContentMode(android.webkit.WebSettings.MIXED_CONTENT_ALWAYS_ALLOW);
        }
        superWebview.setWebViewClient(new MyWebViewClient());

        String url = getIntent().getStringExtra("startUrl");
        superWebview.loadUrl(url);
    }

    private class MyWebChromeClient extends WebChromeClient {
        @Override
        public void onReceivedTitle(WebView webView, String s) {
            super.onReceivedTitle(webView, s);
            setTitle(s);
        }
    }


    private class MyWebViewClient extends WebViewClient {

        @Override
        public void onPageFinished(WebView view, String url) {
            super.onPageFinished(view, url);
            //  html加载完成之后，调用js的方法
            imgReset();

        }

        @Override
        public void onLoadResource(WebView webView, String s) {
            super.onLoadResource(webView, s);
        }

        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            if(StringUtil.isNotNullAndSpace(url) && (!url.startsWith("http:") && !url.startsWith("https:"))){
                try{
                    Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                    view.getContext().startActivity(intent);
                } catch(Exception e){

                }
            } else {

                if(url.startsWith(getResources().getString(R.string.web_base_url)+BaseConsts.WebPath.WEIDIAN_INDEX)){
                    //toolbar.setVisibility(View.VISIBLE);
                    showToolBar(true);
                } else {
                    //toolbar.setVisibility(View.GONE);
                    showToolBar(false);
                }
                view.loadUrl(url);
            }

            return true;
        }
    }
    private int mToolBarHeight = -1 ;
    private void showToolBar(boolean show){
        LinearLayout.LayoutParams params = (LinearLayout.LayoutParams)toolbar.getLayoutParams();
        if(mToolBarHeight == -1 && params.height > 0){
            mToolBarHeight = params.height;
        }
        if(show){
            params.height = mToolBarHeight;
        } else {
            params.height = mToolBarHeight - UIUtils.dip2Px(this,45);
        }
        toolbar.setLayoutParams(params);
    }

    private void imgReset() {
       */
/* String width = String.valueOf(BaseApp.getInstance().mScreenWidth);
        superWebview.loadUrl("javascript:(function(){"
                + "var objs = document.getElementsByTagName('img'); "
                + "for(var i=0;i<objs.length;i++)  " + "{"
                + "var img = objs[i];   "
                + "    img.style.width = "+width+";"
                + "    img.style.height = 'auto';   "
                + "}" + "})()");*//*

    }
}
*/
