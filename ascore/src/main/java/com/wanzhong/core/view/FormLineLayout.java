package com.wanzhong.core.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.Gravity;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.wanzhong.core.R;

import androidx.annotation.Nullable;

public class FormLineLayout extends LinearLayout {

    protected TextView mTitle;
    public FormLineLayout(Context context) {
        super(context);
        addTitleView(null,-1);
    }

    public FormLineLayout(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        addTitleView(attrs,-1);
    }

    public FormLineLayout(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        addTitleView(attrs,defStyleAttr);
    }

    public FormLineLayout(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        addTitleView(attrs,defStyleAttr);
    }

    protected void addTitleView(AttributeSet attrs, int defStyleAttr){
        setGravity(Gravity.CENTER|Gravity.LEFT);
        mTitle = new TextView(getContext());
        mTitle.setTextColor(getContext().getResources().getColor(R.color.text_color_dark));
        mTitle.setTextSize(TypedValue.COMPLEX_UNIT_SP,14);

        TypedArray typedArray = getContext().getTheme().obtainStyledAttributes(attrs,R.styleable.FormLineLayout,defStyleAttr,0);
        boolean isRequired = typedArray.getBoolean(R.styleable.FormLineLayout_isRequired,false);
        int leftImg = isRequired ? R.drawable.icon_required_h : R.drawable.icon_required_n;
        mTitle.setCompoundDrawablesWithIntrinsicBounds(getResources().getDrawable(leftImg),null,null,null);
        String title = typedArray.getString(R.styleable.FormLineLayout_title);
        int titleMinSize = typedArray.getInteger(R.styleable.FormLineLayout_titleMinEms,0);

        mTitle.setText(title);
        mTitle.setMinEms(titleMinSize);
        addView(mTitle,0);

    }

    public void setTitle(String title){
        if(mTitle == null){
            return;
        }
        mTitle.setText(title);
    }

}
