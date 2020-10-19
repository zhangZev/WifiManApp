package cn.icanfitness.ican.app.common;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.webkit.URLUtil;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.lzy.imagepicker.ImagePicker;
import com.lzy.imagepicker.bean.ImageItem;
import com.lzy.imagepicker.ui.ImagePreviewActivity;
import com.lzy.imagepicker.view.SuperCheckBox;
import com.wanzhong.core.BaseApp;
import com.wanzhong.data.utils.ImgUploadUtil;

import java.util.ArrayList;
import java.util.List;

import androidx.viewpager.widget.ViewPager;

public class ImgPreviewActivity extends ImagePreviewActivity {

    private TextView mTvName;

    public static void startPreview(Context context, String pic){
        final List<String> pics = new ArrayList<>();
        if(pic != null){
            pics.add(pic);
        }
        startPreview(context,pics,0);
    }
    public static void startPreview(Context context, List<String> pics,int position){
        if(pics == null || pics.size() == 0){
            BaseApp.getInstance().toast(R.string.no_img_preview);
            return;
        }
        ArrayList<ImageItem> imageItems = new ArrayList<ImageItem>();
        for(String pic : pics){
            if (!pic.startsWith("/") && !URLUtil.isValidUrl(pic)) {
                pic = ImgUploadUtil.getInstance().getImgUrl(pic);
            }
            final ImageItem imageItem = new ImageItem();
            imageItem.path = pic;
            imageItems.add(imageItem);
        }
        Intent intent = new Intent(context, ImgPreviewActivity.class);
        intent.putExtra(ImagePicker.EXTRA_IMAGE_ITEMS,imageItems);
        intent.putExtra(ImagePicker.EXTRA_FROM_ITEMS,true);
        intent.putExtra(ImagePicker.EXTRA_SELECTED_IMAGE_POSITION,position);
        context.startActivity(intent);
    }
    public static void startPreview(Context context, ArrayList<ImageItem> imageItems){
        if(imageItems == null || imageItems.size() == 0){
            BaseApp.getInstance().toast(R.string.no_img_preview);
            return;
        }
        for(ImageItem item : imageItems){
            if (!item.path.startsWith("/") && !URLUtil.isValidUrl(item.path)) {
                item.path = ImgUploadUtil.getInstance().getImgUrl(item.path);
            }
        }
        Intent intent = new Intent(context, ImgPreviewActivity.class);
        intent.putExtra(ImagePicker.EXTRA_IMAGE_ITEMS,imageItems);
        intent.putExtra(ImagePicker.EXTRA_FROM_ITEMS,true);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        findViewById(com.lzy.imagepicker.R.id.btn_ok).setVisibility(View.GONE);
        findViewById(R.id.cb_check).setVisibility(View.GONE);
        SuperCheckBox cbOrigin = (SuperCheckBox) findViewById(com.lzy.imagepicker.R.id.cb_origin);
        cbOrigin.setVisibility(View.GONE);
        RelativeLayout viewParent  = (RelativeLayout)cbOrigin.getParent();
        RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
        params.addRule(RelativeLayout.CENTER_IN_PARENT);
        mTvName = new TextView(this);
        mTvName.setSingleLine(true);
        viewParent.addView(mTvName,params);
        mTvName.setTextColor(Color.WHITE);
        mViewPager.addOnPageChangeListener(new ViewPager.SimpleOnPageChangeListener() {
            @Override
            public void onPageSelected(int position) {
                mCurrentPosition = position;
                setImgName();
            }
        });

        setImgName();
    }

    private void setImgName(){
        ImageItem item = mImageItems.get(mCurrentPosition);
        mTvName.setText(item.name);
    }
}
