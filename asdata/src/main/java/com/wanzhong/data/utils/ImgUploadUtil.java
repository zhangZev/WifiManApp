package com.wanzhong.data.utils;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.ThumbnailUtils;
import android.os.Environment;

import com.lzy.imagepicker.ImagePicker;
import com.lzy.imagepicker.bean.ImageItem;
import com.lzy.imagepicker.ui.ImageGridActivity;
import com.lzy.imagepicker.view.CropImageView;
import com.wanzhong.common.util.SysContants;
import com.wanzhong.core.BaseApp;
import com.wanzhong.core.utils.CommonUtil;
import com.wanzhong.data.R;
import com.wanzhong.data.net.RetrofitProvider;
import com.wanzhong.data.po.ComResDataListPagePo;
import com.wanzhong.data.po.FileUploadRespPo;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;

import id.zelory.compressor.Compressor;
import io.reactivex.Flowable;
import okhttp3.MediaType;
import okhttp3.RequestBody;

import static com.wanzhong.core.utils.BaseConsts.Intent.IMAGE_PICKER;

public class ImgUploadUtil {
    private static final MediaType MEDIA_TYPE_FORM = MediaType.parse("multipart/form-data;charset=UTF-8");

    private static ImgUploadUtil mImgUploadUtil;
    private boolean mIsPicking = false;
    /**已选择的图片*/
    private List<ImageItem> mPickedImgs = new ArrayList<ImageItem>();

    private ImgUploadUtil(){

    }

    public static ImgUploadUtil getInstance(){
        if(mImgUploadUtil == null){
            mImgUploadUtil = new ImgUploadUtil();
        }
        return mImgUploadUtil;
    }

    public void pickImages(Activity activity){
        pickImages(activity,9,false);
    }
    public void pickImages(Activity activity,int pickCount,boolean crop){
        if(mIsPicking){
            BaseApp.getInstance().toast(R.string.tip_img_picking);
            return;
        }
        onImagePickStart();
        Intent intent = new Intent();
        ImagePicker imagePicker = ImagePicker.getInstance();
        if(pickCount == 1){
            imagePicker.setMultiMode(false);
        } else {
            imagePicker.setMultiMode(true);
        }
        imagePicker.setSelectLimit(pickCount);
        imagePicker.setCrop(crop);
        if(crop){
            imagePicker.setStyle(CropImageView.Style.RECTANGLE);  //裁剪框的形状
        }
        intent.setClass(activity, ImageGridActivity.class);
        activity.startActivityForResult(intent, IMAGE_PICKER);

    }

    public void takePicktureOnly(Activity activity,int pickCount,boolean crop){
        if(mIsPicking){
            BaseApp.getInstance().toast(R.string.tip_img_picking);
            return;
        }
        onImagePickStart();
        Intent intent = new Intent();
        ImagePicker imagePicker = ImagePicker.getInstance();
        if(pickCount == 1){
            imagePicker.setMultiMode(false);
        } else {
            imagePicker.setMultiMode(true);
        }
        imagePicker.setSelectLimit(pickCount);
        imagePicker.setCrop(crop);
        if(crop){
            imagePicker.setStyle(CropImageView.Style.RECTANGLE);  //裁剪框的形状
        }
        intent.setClass(activity, ImageGridActivity.class);
        intent.putExtra(ImageGridActivity.EXTRAS_TAKE_PICKERS,true);
        activity.startActivityForResult(intent, IMAGE_PICKER);

    }




    public Flowable<ComResDataListPagePo<FileUploadRespPo>> compressAndUpload(int requestCode, int resultCode, Intent data){
        if(requestCode == IMAGE_PICKER){
            if (resultCode == ImagePicker.RESULT_CODE_ITEMS ) {
                if(data != null && data.getSerializableExtra(ImagePicker.EXTRA_RESULT_ITEMS) != null) {
                    mPickedImgs = (ArrayList<ImageItem>) data.getSerializableExtra
                            (ImagePicker.EXTRA_RESULT_ITEMS);
                }
            }
            return Flowable.defer(new Callable<Flowable<ComResDataListPagePo<FileUploadRespPo>>>() {
                @Override
                public Flowable<ComResDataListPagePo<FileUploadRespPo>> call() {
                    try {
                        return Flowable.just(doCompressAndUpload());
                    } catch (Exception e) {
                        onImageUploadFinished();
                        return Flowable.error(e);
                    }
                }
            });
        }
        return null;
    }

    private ThumbnailData mThumbnailData;
    public Flowable<ComResDataListPagePo<FileUploadRespPo>> compressAndUpload(String[] imgs,ThumbnailData thumbnailData){
        mPickedImgs = new ArrayList<>();
        mThumbnailData = thumbnailData;
        if(imgs != null){
            for (int i = 0 ; i < imgs.length ; i++){
                final ImageItem item = new ImageItem();
                item.path = imgs[i];
                mPickedImgs.add(item);
            }
        }
        return Flowable.defer(new Callable<Flowable<ComResDataListPagePo<FileUploadRespPo>>>() {
            @Override
            public Flowable<ComResDataListPagePo<FileUploadRespPo>> call() {
                try {
                    return Flowable.just(doCompressAndUpload());
                } catch (Exception e) {
                    e.printStackTrace();
                    onImageUploadFinished();
                    return Flowable.error(e);
                }
            }
        });
    }


    public Flowable<List<String>> compressImgs(int requestCode, int resultCode, Intent data){
        if(requestCode == IMAGE_PICKER){
            if (resultCode == ImagePicker.RESULT_CODE_ITEMS ) {
                if(data != null && data.getSerializableExtra(ImagePicker.EXTRA_RESULT_ITEMS) != null) {
                    mPickedImgs = (ArrayList<ImageItem>) data.getSerializableExtra
                            (ImagePicker.EXTRA_RESULT_ITEMS);
                }
            }
            return Flowable.defer(new Callable<Flowable<List<String>>>() {
                @Override
                public Flowable<List<String>> call() {
                    try {
                        BaseApp.getInstance().showLoading(true);
                        final Flowable<List<String>> ret = Flowable.just(doCompressImgs());
                        onImageUploadFinished();
                        return ret;
                    } catch (Exception e) {
                        onImageUploadFinished();
                        return Flowable.error(e);
                    }
                }
            });
        }
        return null;
    }


    public Flowable<ComResDataListPagePo<FileUploadRespPo>> uploadImgs(List<String> imgs){
        return Flowable.defer(new Callable<Flowable<ComResDataListPagePo<FileUploadRespPo>>>() {
            @Override
            public Flowable<ComResDataListPagePo<FileUploadRespPo>> call() {
                try {
                    BaseApp.getInstance().showLoading(true);
                    final Flowable<ComResDataListPagePo<FileUploadRespPo>> ret = Flowable.just(doUpload(imgs));;
                    onImageUploadFinished();
                    return ret;
                } catch (Exception e) {
                    onImageUploadFinished();
                    return Flowable.error(e);
                }
            }
        });
    }


    private ComResDataListPagePo<FileUploadRespPo> doCompressAndUpload() throws  Exception{
        BaseApp.getInstance().showLoading(true);
        final List<String> imgs = doCompressImgs();
        final ComResDataListPagePo<FileUploadRespPo> ret = doUpload(imgs);
        onImageUploadFinished();
        return ret;

    }
    public static final String mBasePath = Environment.getExternalStorageDirectory() + File.separator + ".wzcg" ;

    private List<String> doCompressImgs() throws  Exception{
        final List<String> compressedImgs = new ArrayList<>();
        if(mPickedImgs == null || mPickedImgs.size() == 0){
            return compressedImgs;
        }
        final Compressor compressor = new Compressor(BaseApp.getInstance().getApplicationContext());
      /*  compressor.setQuality(75);
        compressor.setCompressFormat(Bitmap.CompressFormat.WEBP);*/
        File file = new File(mBasePath);
        if(!file.exists()){
            file.mkdirs();
        }
        compressor.setDestinationDirectoryPath(mBasePath);
        /**已压缩的图片*/
        for(ImageItem  item : mPickedImgs){

            final File fileItem = new File(item.path);

            String compressedPath = compressor.compressToFile(fileItem).getAbsolutePath();
            if(mThumbnailData != null && mThumbnailData.thumbNames != null && mThumbnailData.getThumbNames().containsKey(fileItem.getName())
                && mThumbnailData.width > 0 && mThumbnailData.height > 0){
                Bitmap bitmap = BitmapFactory.decodeFile(compressedPath);
                Bitmap thunbnail =  ThumbnailUtils.extractThumbnail(bitmap,mThumbnailData.width,mThumbnailData.height);
                if(!bitmap.isRecycled()){
                    bitmap.recycle();

                }
                bitmap = null;
                File compressedFile = new File(compressedPath);
                if(compressedFile.exists()){
                    compressedFile.delete();
                }
                saveBitmap(compressedFile.getAbsolutePath(),thunbnail);
                if(!thunbnail.isRecycled()){
                    thunbnail.recycle();
                }
                thunbnail = null;
            }
            compressedImgs.add(compressedPath);
            if(mPickedImgs.size() == compressedImgs.size()){

                return compressedImgs;
            }
        }
        return compressedImgs;
    }

    public  void saveBitmap(String bitName, Bitmap mBitmap) {
        File f = new File(bitName);
        try {
            f.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
        FileOutputStream fOut = null;
        try {
            fOut = new FileOutputStream(f);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        if(bitName.toLowerCase().contains(".png")){
            mBitmap.compress(Bitmap.CompressFormat.PNG, 85, fOut);
        } else {
            mBitmap.compress(Bitmap.CompressFormat.JPEG, 85, fOut);
        }
        try {
            fOut.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            fOut.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private ComResDataListPagePo<FileUploadRespPo> doUpload(List<String> imgs) throws  Exception{
        if(imgs == null || imgs.size() == 0){
            final ComResDataListPagePo<FileUploadRespPo> po = new ComResDataListPagePo<FileUploadRespPo>();
            //po.setRetCode(SysContants.RET_CODE_SYSERR);
            //po.setRetMsg(BaseApp.getInstance().getApplicationContext().getResources().getString(R.string.no_img_picked));
            return po;
        }
        Map<String, RequestBody> map = new HashMap<String, RequestBody>();
        for (int i = 0 ; i < imgs.size() ;i++){
            final File file = new File(imgs.get(i));
            RequestBody body = RequestBody.create(MEDIA_TYPE_FORM, file);
            map.put("files"+i + "\"; filename=\"" + file.getName(), body);
        }
        final ComResDataListPagePo<FileUploadRespPo> response = RetrofitProvider.getApiInstance().uploadFile(map).execute().body();
        return response;
    }


    /*private ComResDataListPagePo<FileUploadRespPo> compressAndUpload() throws  Exception{
        if(mPickedImgs == null || mPickedImgs.size() == 0){
            final ComResDataListPagePo<FileUploadRespPo> po = new ComResDataListPagePo<FileUploadRespPo>();
            po.setRetCode(SysContants.RET_CODE_SYSERR);
            po.setRetMsg(BaseApp.getInstance().getApplicationContext().getResources().getString(R.string.no_img_picked));
            onImageUploadFinished();
            return po;
        }
        BaseApp.getInstance().showLoading(true);
        final Compressor compressor = new Compressor(BaseApp.getInstance().getApplicationContext());
        *//**已压缩的图片*//*
        List<File> compressedImgs = new ArrayList<File>();
        for(ImageItem  item : mPickedImgs){
            CommonUtil.err("item  "+item.path);
            compressedImgs.add(compressor.compressToFile(new File(item.path)));
            if(mPickedImgs.size() == compressedImgs.size()){
                //全部压缩完成，上传
                Map<String, RequestBody> map = new HashMap<String, RequestBody>();
                for (int i = 0 ; i < compressedImgs.size() ;i++){
                    final File file = compressedImgs.get(i);
                    RequestBody body = RequestBody.create(MEDIA_TYPE_FORM, file);
                    map.put("files"+i + "\"; filename=\"" + file.getName(), body);
                }
                final ComResDataListPagePo<FileUploadRespPo> response = RetrofitProvider.getApiInstance().uploadFile(map).execute().body();
                onImageUploadFinished();
                return response;
            }
        }
        onImageUploadFinished();
        return null;
    }*/


    private void onImagePickStart(){
        mIsPicking = true;
        mPickedImgs.clear();

    }

    public void onImageUploadFinished(){
        mPickedImgs.clear();
        mIsPicking = false;
        BaseApp.getInstance().showLoading(false);
    }

    public String getImgUrl(String fileId){
        /*return BaseApp.getInstance().getApplicationContext().getString(R.string.base_url) +"/common/queryFile?keyId="
                +fileId+ "&tokenId=" + BaseApp.getInstance().getToken()
                + "&userId=" + BaseApp.getInstance().getUserId();*/
        return fileId;
    }

    public static class ThumbnailData {
        Map<String,Integer> thumbNames;
        int width;
        int height;

        public Map<String, Integer> getThumbNames() {
            return thumbNames;
        }

        public void setThumbNames(Map<String, Integer> thumbNames) {
            this.thumbNames = thumbNames;
        }

        public int getWidth() {
            return width;
        }

        public void setWidth(int width) {
            this.width = width;
        }

        public int getHeight() {
            return height;
        }

        public void setHeight(int height) {
            this.height = height;
        }
    }


}
