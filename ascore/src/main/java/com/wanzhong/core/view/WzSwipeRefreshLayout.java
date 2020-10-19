package com.wanzhong.core.view;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import android.view.ViewParent;
import android.widget.ScrollView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.widget.NestedScrollView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import androidx.viewpager.widget.ViewPager;

public class WzSwipeRefreshLayout extends SwipeRefreshLayout {

    private int mTouchSlop;
    public WzSwipeRefreshLayout(@NonNull Context context) {
        super(context);
        final ViewConfiguration vc = ViewConfiguration.get(context);
        mTouchSlop = vc.getScaledTouchSlop();
    }

    public WzSwipeRefreshLayout(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        final ViewConfiguration vc = ViewConfiguration.get(context);
        mTouchSlop = vc.getScaledTouchSlop();
    }
    int move_x,move_y;
    @Override
    public boolean onTouchEvent(MotionEvent e) {
        switch (e.getAction()){

            case MotionEvent.ACTION_DOWN:
                move_x = (int) e.getX();
                move_y = (int) e.getY();
                findScrollView(this).requestDisallowInterceptTouchEvent(true);
                //findSwipeRefreshLayout(this).requestDisallowInterceptTouchEvent(false);

                Log.e("WZ","down   x==y  "+move_x+" ==== "+move_y);
                break;
            case MotionEvent.ACTION_MOVE:
                int y = (int) e.getY();
                int x = (int) e.getX();
                if(Math.abs(y-move_y)>mTouchSlop&&Math.abs(x-move_x)<mTouchSlop*2){
                    findScrollView(this).requestDisallowInterceptTouchEvent(false);
                    //findSwipeRefreshLayout(this).requestDisallowInterceptTouchEvent(false);

                    Log.e("WZ","============================");
                }else {
                    findScrollView(this).requestDisallowInterceptTouchEvent(true);
                    // findSwipeRefreshLayout(this).requestDisallowInterceptTouchEvent(true);
                    Log.e("WZ","-------------------------"+findScrollView(this));
                }
                break;
            case MotionEvent.ACTION_UP:
                Log.e("WZ","up   x==y  "+move_x+" ==== "+move_y);
                break;
        }
        return super.onTouchEvent(e);
    }

    private ViewParent findScrollView(ViewParent view){
        final ViewParent parent = view.getParent();
        if(parent == null || parent instanceof NestedScrollView || parent instanceof ScrollView || parent instanceof ViewPager){
            return parent;
        }
        return findScrollView(parent);
    }
}
