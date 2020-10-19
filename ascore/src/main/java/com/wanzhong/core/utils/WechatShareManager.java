/*
package com.wanzhong.core.utils;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import com.tencent.mm.opensdk.modelbase.BaseResp;
import com.tencent.mm.opensdk.modelmsg.SendMessageToWX;
import com.tencent.mm.opensdk.modelmsg.WXImageObject;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.opensdk.modelmsg.WXTextObject;
import com.tencent.mm.opensdk.modelmsg.WXVideoObject;
import com.tencent.mm.opensdk.modelmsg.WXWebpageObject;
import com.tencent.mm.opensdk.openapi.IWXAPI;
import com.tencent.mm.opensdk.openapi.WXAPIFactory;
import com.tencent.mm.opensdk.utils.Log;
import com.wanzhong.core.R;
import com.wanzhong.core.entity.ShareContent;
import com.wanzhong.core.entity.ShareContentBitMap;
import com.wanzhong.core.entity.ShareContentPicture;
import com.wanzhong.core.entity.ShareContentText;
import com.wanzhong.core.entity.ShareContentVideo;
import com.wanzhong.core.entity.ShareContentWebpage;
import com.wanzhong.core.view.toasty.Toasty;

import java.io.ByteArrayOutputStream;

*/
/**
 * 实现微信分享功能的核心类
 *
 * @author zxw
 *//*

public class WechatShareManager {

    public static final int THUMB_SIZE = 150;

    public static final int WECHAT_SHARE_WAY_TEXT = 1;   //文字
    public static final int WECHAT_SHARE_WAY_PICTURE = 2; //图片
    public static final int WECHAT_SHARE_WAY_WEBPAGE = 3;  //链接
    public static final int WECHAT_SHARE_WAY_VIDEO = 4; //视频
    public static final int WECHAT_SHARE_TYPE_TALK = SendMessageToWX.Req.WXSceneSession;  //会话
    public static final int WECHAT_SHARE_TYPE_FRENDS = SendMessageToWX.Req.WXSceneTimeline; //朋友圈

    private static WechatShareManager mInstance;
    private ShareContent mShareContentText, mShareContentPicture, mShareContentWebpag, mShareContentVideo, mShareContentBitmap;
    private IWXAPI mWXApi;
    private Activity mContext;
    private dismissDialog mDismissListener;

    public IWXAPI getmWXApi() {
        return mWXApi;
    }

    private WechatShareManager(Activity context) {
        this.mContext = context;
        //初始化数据
        //初始化微信分享代码
        initWechatShare(context);
    }

    */
/**
     * 获取WeixinShareManager实例
     * 非线程安全，请在UI线程中操作
     *
     * @return
     *//*

    public static WechatShareManager getInstance(Activity context) {
        if (mInstance == null) {
            mInstance = new WechatShareManager(context);
        }
        return mInstance;
    }

    private void initWechatShare(Context context) {
        if (mWXApi == null) {
            mWXApi = WXAPIFactory.createWXAPI(context, BaseConsts.WX_APPID, true);
        }
        mWXApi.registerApp(BaseConsts.WX_APPID);
    }

    public void setmDismissListener(dismissDialog mDismissListener) {
        this.mDismissListener = mDismissListener;
    }

    */
/**
     * 通过微信分享
     *
     * @param shareContent 分享的方式（文本、图片、链接）
     * @param shareType    分享的类型（朋友圈，会话）
     *//*

    public void shareByWebchat(ShareContent shareContent, int shareType) {
        switch (shareContent.getShareWay()) {
            case WECHAT_SHARE_WAY_TEXT:
                shareText(shareContent, shareType);
                break;
            case WECHAT_SHARE_WAY_PICTURE:
                sharePicture(shareContent, shareType);
                break;
            case WECHAT_SHARE_WAY_WEBPAGE:
                shareWebPage(shareContent, shareType);
                break;
            case WECHAT_SHARE_WAY_VIDEO:
                shareVideo(shareContent, shareType);
                break;
        }
    }


    */
/*
     * 获取文本分享对象
     *//*

    public ShareContent getShareContentText(String content) {
        if (mShareContentText == null) {
            mShareContentText = new ShareContentText(content);
        }
        return (ShareContentText) mShareContentText;
    }


    public ShareContentBitMap getmShareContentBitmap(Bitmap bitmap) {
        mShareContentBitmap = new ShareContentBitMap(bitmap);
        return (ShareContentBitMap) mShareContentBitmap;
    }


    */
/*
     * 获取图片分享对象
     *//*

    public ShareContent getShareContentPicture(int pictureResource) {
        if (mShareContentPicture == null) {
            mShareContentPicture = new ShareContentPicture(pictureResource);
        }
        return (ShareContentPicture) mShareContentPicture;
    }


    */
/*
     * 获取网页分享对象
     *//*

    public ShareContent getShareContentWebpag(String title, String content, String url, int pictureResource, Bitmap bitmap) {
        if (mShareContentWebpag == null) {
            mShareContentWebpag = new ShareContentWebpage(null, title, content, url, pictureResource, bitmap);
        }
        return (ShareContentWebpage) mShareContentWebpag;
    }

    public ShareContent createShareContentWebpag(String keyId, String title, String content, String url, int pictureResource, Bitmap bitmap) {
        mShareContentWebpag = new ShareContentWebpage(keyId, title, content, url, pictureResource, bitmap);
        return (ShareContentWebpage) mShareContentWebpag;
    }


    */
/*
     * 获取视频分享内容
     *//*

    public ShareContent getShareContentVideo(String url) {
        if (mShareContentVideo == null) {
            mShareContentVideo = new ShareContentVideo(url);
        }
        return (ShareContentVideo) mShareContentVideo;
    }

    */
/*
     * 分享文字
     *//*

    private void shareText(ShareContent shareContent, int shareType) {
        String text = shareContent.getContent();
        //初始化一个WXTextObject对象
        WXTextObject textObj = new WXTextObject();
        textObj.text = text;
        //用WXTextObject对象初始化一个WXMediaMessage对象
        WXMediaMessage msg = new WXMediaMessage();
        msg.mediaObject = textObj;
        msg.description = text;
        //构造一个Req
        SendMessageToWX.Req req = new SendMessageToWX.Req();
        //transaction字段用于唯一标识一个请求
        req.transaction = buildTransaction("textshare");
        req.message = msg;
        //发送的目标场景， 可以选择发送到会话 WXSceneSession 或者朋友圈 WXSceneTimeline。 默认发送到会话。
        req.scene = shareType;
        mWXApi.sendReq(req);
        if (mDismissListener != null) {
            mDismissListener.finshAndDis();
        }
    }

    */
/*
     * 分享图片
     *//*

    private void sharePicture(ShareContent shareContent, int shareType) {
        Bitmap bitmap = shareContent.getBitmap();
        WXImageObject imgObj = new WXImageObject(bitmap);

        WXMediaMessage msg = new WXMediaMessage();
        msg.mediaObject = imgObj;

        Bitmap thumbBitmap = Bitmap.createScaledBitmap(bitmap, THUMB_SIZE, THUMB_SIZE, true);
        bitmap.recycle();
        msg.setThumbImage(thumbBitmap);
        thumbBitmap.recycle();
        SendMessageToWX.Req req = new SendMessageToWX.Req();
        req.transaction = buildTransaction("imgshareappdata");
        req.message = msg;
        req.scene = shareType;
        mWXApi.sendReq(req);
        if (mDismissListener != null) {
            mDismissListener.finshAndDis();
        }
    }


    */
/* private byte[] getBitmapData(Bitmap bitmap){
         byte[] retBitmap = null;
         try {
             ByteArrayOutputStream var2 = new ByteArrayOutputStream();
             bitmap.compress(Bitmap.CompressFormat.PNG, 85, var2);
             retBitmap = var2.toByteArray();
             var2.close();
         } catch (Exception var3) {
             Log.e("MicroMsg.SDK.WXMediaMessage", "setThumbImage exception:" + var3.getMessage());
         }
         return retBitmap;
     }*//*

    */
/*
     * 分享链接
     *//*

    private void shareWebPage(ShareContent shareContent, int shareType) {
        WXWebpageObject webpage = new WXWebpageObject();
        webpage.webpageUrl = shareContent.getURL();
        WXMediaMessage msg = new WXMediaMessage(webpage);
        msg.title = shareContent.getTitle();
        msg.description = shareContent.getContent();

        if (shareContent.getBitmap() != null) {
            msg.thumbData = getThumbData(shareContent.getBitmap());
        } else {
            Bitmap thumb = BitmapFactory.decodeResource(mContext.getResources(), shareContent.getPictureResource() > 0 ? shareContent.getPictureResource() : R.drawable.share_thumb_default);
            if (thumb == null) {
                Toasty.info(mContext, "图片不能为空").show();
            } else {
                msg.setThumbImage(thumb);
                thumb.recycle();
            }
        }

        SendMessageToWX.Req req = new SendMessageToWX.Req();
        req.transaction = buildTransaction("webpage");
        req.message = msg;
        req.scene = shareType;
        mWXApi.sendReq(req);
        if (mDismissListener != null) {
            mDismissListener.finshAndDis();
        }
    }

    */
/*
     * 分享视频
     *//*

    private void shareVideo(ShareContent shareContent, int shareType) {
        WXVideoObject video = new WXVideoObject();
        video.videoUrl = shareContent.getURL();

        WXMediaMessage msg = new WXMediaMessage(video);
        msg.title = shareContent.getTitle();
        msg.description = shareContent.getContent();
        Bitmap thumb = BitmapFactory.decodeResource(mContext.getResources(), R.drawable.share_thumb_default);
//		BitmapFactory.decodeStream(new URL(video.videoUrl).openStream());
        */
/**
         * 测试过程中会出现这种情况，会有个别手机会出现调不起微信客户端的情况。造成这种情况的原因是微信对缩略图的大小、title、description等参数的大小做了限制，所以有可能是大小超过了默认的范围。
         * 一般情况下缩略图超出比较常见。Title、description都是文本，一般不会超过。
         *//*

        Bitmap thumbBitmap = Bitmap.createScaledBitmap(thumb, THUMB_SIZE, THUMB_SIZE, true);
        thumb.recycle();
        msg.setThumbImage(thumbBitmap);
        thumbBitmap.recycle();
        SendMessageToWX.Req req = new SendMessageToWX.Req();
        req.transaction = buildTransaction("video");
        req.message = msg;
        req.scene = shareType;
        mWXApi.sendReq(req);
        if (mDismissListener != null) {
            mDismissListener.finshAndDis();
        }
    }

    private String buildTransaction(final String type) {
        return (type == null) ? String.valueOf(System.currentTimeMillis()) : type + System.currentTimeMillis();
    }

    public interface dismissDialog {
        void finshAndDis();
    }

    public void setResult(BaseResp resp) {
        String result = null;
        switch (resp.errCode) {
            case BaseResp.ErrCode.ERR_OK: {
                result = "分享成功";
                if (mWxShareListener != null) {
                    mWxShareListener.onShareSucc();
                }
            }
            break;
            case BaseResp.ErrCode.ERR_USER_CANCEL:
                result = "分享取消";
                if (mWxShareListener != null) {
                    mWxShareListener.onShareFaild();
                }
                break;
            case BaseResp.ErrCode.ERR_AUTH_DENIED:
                result = "分享被拒绝";
                if (mWxShareListener != null) {
                    mWxShareListener.onShareFaild();
                }
                break;
            default:
                result = "分享返回";
                if (mWxShareListener != null) {
                    mWxShareListener.onShareFaild();
                }
                break;
        }
        */
/*if(result != null){
            BaseApp.getInstance().toast(result);
        }*//*

    }

    public void setWxShareListener(WxShareListener listener) {
        mWxShareListener = listener;
    }

    private WxShareListener mWxShareListener;

    public interface WxShareListener {
        public void onShareSucc();

        public void onShareFaild();
    }

    private byte[] getThumbData(Bitmap var1) {
        byte[] data = null;
        try {
            ByteArrayOutputStream var2 = new ByteArrayOutputStream();
            var1.compress(Bitmap.CompressFormat.PNG, 85, var2);
            data = var2.toByteArray();
            var2.close();
        } catch (Exception var3) {
            Log.e("MicroMsg.SDK.WXMediaMessage", "setThumbImage exception:" + var3.getMessage());
        }
        return data;
    }

}
*/
