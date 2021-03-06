package com.wanzhong.core.view;

import android.content.Context;
import android.content.res.ColorStateList;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;

import com.wanzhong.core.BaseApp;
import com.wanzhong.core.R;
import com.wanzhong.core.interfaces.CommImgTvViewData;
import com.wanzhong.core.view.bottombar.UIUtils;

/**
 * 左边图片，右边3行文字通用View
 */
public class CommImgTvViewWithP extends FrameLayout {

    public enum IMG_SHOW_WAY {NORMAL, CIRCLE, ROUND_CORNOR}

    ;

    CardView mImageLayout;
    ImageView mImageView;
    ImageView mImageLeftTopCover;
    TextView mTvLine1;
    TextView mTvLine2;
    TextView mTvLine3;
    TextView mTvLine4;
    TextView mTvLine5;
    TextView mTvLine6;
    private int mImgWidth;
    private int mImgHeight;

    private IMG_SHOW_WAY mImgShowWay = IMG_SHOW_WAY.ROUND_CORNOR;

    private int mDefaultImgRes = R.drawable.img_default_car_list;

    public void setImgShowWay(IMG_SHOW_WAY way) {
        mImgShowWay = way;
    }

    public void setDefaultImg(int defaultImg) {
        mDefaultImgRes = defaultImg;
    }

    public CommImgTvViewWithP(@NonNull Context context) {
        super(context);
        initViews();
    }

    public CommImgTvViewWithP(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initViews();
    }

    public CommImgTvViewWithP(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initViews();
    }

    public CommImgTvViewWithP(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        initViews();
    }

    private void initViews() {
        inflate(getContext(), R.layout.item_view_img_tv_cars, this);
        mImgWidth = getResources().getDimensionPixelOffset(R.dimen.comm_img_tv_img_width);
        mImgHeight = getResources().getDimensionPixelOffset(R.dimen.comm_img_tv_img_height);
        mImageView = findViewById(R.id.img);
        //ConstraintLayout.LayoutParams params = (ConstraintLayout.LayoutParams)mImageView.getLayoutParams();
        mImageLayout = findViewById(R.id.layout_img);
        mImageLeftTopCover = findViewById(R.id.img_left_top_cover);
        mTvLine1 = findViewById(R.id.tv_info_line1);
        mTvLine2 = findViewById(R.id.tv_info_line2);
        mTvLine4 = findViewById(R.id.tv_info_line4);
        mTvLine5 = findViewById(R.id.tv_info_line5);
        mTvLine6 = findViewById(R.id.tv_info_line6);
        mTvLine3 = findViewById(R.id.tv_info_line3);
    }

    public void setLine1TextSize(int sp) {
        mTvLine1.setTextSize(TypedValue.COMPLEX_UNIT_SP, sp);
    }

    public void setLine1TextColor(ColorStateList color) {
        mTvLine1.setTextColor(color);
    }

    public void setLine2TextSize(int sp) {
        mTvLine2.setTextSize(TypedValue.COMPLEX_UNIT_SP, sp);
    }

    public void setLine2TextColor(ColorStateList color) {
        mTvLine2.setTextColor(color);
    }

    public void setLine3TextSize(int sp) {
        mTvLine3.setTextSize(TypedValue.COMPLEX_UNIT_SP, sp);
    }

    public void setLine3TextColor(ColorStateList color) {
        mTvLine3.setTextColor(color);
    }

    public void showImg(boolean show) {
        final LinearLayout.LayoutParams params = (LinearLayout.LayoutParams)mImageLayout.getLayoutParams();
        if (show) {
            params.width = mImgWidth;
            params.height = mImgHeight;
        } else {
            params.width = 0;
            //params.height = ConstraintLayout.LayoutParams.WRAP_CONTENT;
            //params.rightMargin = 0;
        }
        mImageLayout.setLayoutParams(params);
    }

    public void setImageSize(int width, int height) {
        mImgWidth = width;
        mImgHeight = height;
        /*final ConstraintLayout.LayoutParams params = (ConstraintLayout.LayoutParams)mImageView.getLayoutParams();
        params.width = width;
        params.height = height;
        mImageView.setLayoutParams(params);*/
    }

    public void updateData(CommImgTvViewData data) {
        if (data == null) {
            return;
        }
        mTvLine1.setText(data.getLine1Text());
        mTvLine2.setText(data.getLine2Text());
        mTvLine3.setText(data.getLine3Text());
        if(!TextUtils.isEmpty(data.getLine4Text())){
            mTvLine4.setVisibility(VISIBLE);
            mTvLine4.setText(data.getLine4Text());
        }else {
            mTvLine4.setVisibility(INVISIBLE);
        }
        if(!TextUtils.isEmpty(data.getLine5Text())){
            mTvLine5.setVisibility(VISIBLE);
            mTvLine5.setText(data.getLine5Text());
        }else {
            mTvLine5.setVisibility(INVISIBLE);
        }
        if(!TextUtils.isEmpty(data.getLine6Text())){
            mTvLine6.setVisibility(VISIBLE);
            mTvLine6.setText(data.getLine6Text());
        }else {
            mTvLine6.setVisibility(GONE);
        }
        showImg(data.showImg());
        if (data.showImg()) {
            if (mImgShowWay == IMG_SHOW_WAY.NORMAL) {
                mImageLayout.setRadius(0);
                BaseApp.getInstance().setImg(getContext(), mImageView, data.getImagePath(), mDefaultImgRes);
            } else if (mImgShowWay == IMG_SHOW_WAY.CIRCLE) {
                mImageLayout.setRadius(0);
                BaseApp.getInstance().setImgCircle(getContext(), mImageView, data.getImagePath(), mDefaultImgRes);
            } else if (mImgShowWay == IMG_SHOW_WAY.ROUND_CORNOR) {
                mImageView.setTag(data.getImagePath());
                mImageLayout.setRadius(UIUtils.dip2Px(getContext(), 5));
                BaseApp.getInstance().setImgWithBad(getContext(), mImageView, data.getImagePath(), mDefaultImgRes);
            }
        } else {
            mImageView.setImageResource(R.drawable.trans);
        }
    }

    public ImageView getLeftImageView() {
        return mImageView;
    }

    public void showLine1(boolean show) {
        mTvLine1.setVisibility(show ? VISIBLE : GONE);
    }

    public void showLine2(boolean show) {
        mTvLine2.setVisibility(show ? VISIBLE : GONE);
    }

    public void showLine3(boolean show) {
        mTvLine3.setVisibility(show ? VISIBLE : GONE);
    }

    public void setLine1MaxLine(int maxLine) {
        mTvLine1.setMaxLines(maxLine);
    }

    public ImageView setImageLeftTopCover() {
        return mImageLeftTopCover;
    }

    public void setImageLeftTopCover(int resId) {
        if (resId >= 0) {
            mImageLeftTopCover.setImageResource(resId);
        } else {
            mImageLeftTopCover.setImageDrawable(null);
        }
    }
}
