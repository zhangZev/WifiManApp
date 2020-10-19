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
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import androidx.viewpager.widget.ViewPager;

public class WzRecyclerView extends RecyclerView {

    private int mTouchSlop;


    public WzRecyclerView(@NonNull Context context) {
        super(context);
        final ViewConfiguration vc = ViewConfiguration.get(context);
        mTouchSlop = vc.getScaledTouchSlop();
    }

    public WzRecyclerView(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        final ViewConfiguration vc = ViewConfiguration.get(context);
        mTouchSlop = vc.getScaledTouchSlop();

    }

    public WzRecyclerView(@NonNull Context context, @Nullable AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
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
                findScrollView(this).requestDisallowInterceptTouchEvent(false);
                //findSwipeRefreshLayout(this).requestDisallowInterceptTouchEvent(false);

                Log.e("motion_event","down   x==y  "+move_x+" ==== "+move_y);
                break;
            case MotionEvent.ACTION_MOVE:
                int y = (int) e.getY();
                int x = (int) e.getX();
                if(Math.abs(y-move_y)>mTouchSlop&&Math.abs(x-move_x)<mTouchSlop*2){
                    findScrollView(this).requestDisallowInterceptTouchEvent(false);
                    //findSwipeRefreshLayout(this).requestDisallowInterceptTouchEvent(false);

                    Log.e("motion_event","============================");
                }else {
                    findScrollView(this).requestDisallowInterceptTouchEvent(true);
                   // findSwipeRefreshLayout(this).requestDisallowInterceptTouchEvent(true);
                    Log.e("motion_event","-------------------------"+findScrollView(this));
                }
                break;
            case MotionEvent.ACTION_UP:
                Log.e("motion_event","up   x==y  "+move_x+" ==== "+move_y);
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

    private ViewParent findSwipeRefreshLayout(ViewParent view){
        final ViewParent parent = view.getParent();
        if(parent == null || parent instanceof SwipeRefreshLayout){
            return parent;
        }
        return findSwipeRefreshLayout(parent);
    }

}
