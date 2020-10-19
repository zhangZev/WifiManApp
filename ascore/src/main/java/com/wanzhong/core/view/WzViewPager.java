package com.wanzhong.core.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewpager.widget.ViewPager;

public class WzViewPager extends ViewPager {

    //是否可以进行滑动
    private boolean isSlide = false;
    public void setSlide(boolean slide) {
        isSlide = slide;
    }

    public WzViewPager(@NonNull Context context) {
        super(context);
    }

    public WzViewPager(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        return isSlide;
    }
}
