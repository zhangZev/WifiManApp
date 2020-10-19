package com.wanzhong.core.view;

import android.content.Context;
import android.graphics.Color;
import android.text.Html;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.wanzhong.common.util.SysContants;
import com.wanzhong.core.BaseApp;
import com.wanzhong.core.R;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatTextView;

public class RadioCheckLayout extends LinearLayout implements View.OnClickListener {

    public static final int MODE_SINGLE_SELECT = 1;
    public static final int MODE_MUTI_SELECT = 2;
    public static final int MODE_SINGLE_CLICK = 3;
    /**多选 第一个是全部。全部时其他的不选中*/
    public static final int MODE_MUTI_SELECT_FIRST_ALL = 4;
    private int mMode = MODE_SINGLE_SELECT;
    private String[] mDatas;
    private int mCountInLine;
    /**垂直外边距*/
    private int mItemMarginVer;
    /**水平外边距*/
    private int mItemMarginHor;
    /**垂直内边距*/
    private int mItemPaddingVer;
    /**文字颜色（普通）*/
    private int mTextColorN;
    /**文字颜色（已选中）*/
    private int mTextColorH;
    /**背景图片（普通）*/
    private int mBgResN;
    /**背景图片（已选中）*/
    private int mBgResH;

    private int mViewWidth = BaseApp.getInstance().mScreenWidth;

    private int mViewLeftRightMarginCount = -1;
    private boolean mLastWrapContent = false;
    public void setLastWrapContent(boolean wrapContent){
        mLastWrapContent = wrapContent;
    }
    public void setSelectMode(int mode){
        mMode = mode;
    }
    public RadioCheckLayout(Context context) {
        super(context);
        init();
    }

    public RadioCheckLayout(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public RadioCheckLayout(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    public RadioCheckLayout(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init();
    }

    protected void init(){
        setOrientation(VERTICAL);
    }
    public void config(int countInLine,int itemMarginVer,int itemMarginHor,int itemPaddingVer,String textColorN,String textColorH,int bgResN,int bgResH){
        mCountInLine = countInLine;
        mItemMarginVer = itemMarginVer;
        mItemMarginHor = itemMarginHor;
        mItemPaddingVer = itemPaddingVer;
        mTextColorN = Color.parseColor(textColorN);
        mTextColorH = Color.parseColor(textColorH);
        mBgResN = bgResN;
        mBgResH = bgResH;
    }

    /**设置宽度，必须在setData()之前调用才生效*/
    public void setViewWidth(int width){
        mViewWidth = width;
    }
    /**设置RadioCheckLayout左右边距的和*/
    public void setViewLeftRightMarginCount(int marginCount){
        mViewLeftRightMarginCount = marginCount;
    }
    public void updateText(String text,int index){
        mDatas[index] = text;
        TextView tv = findViewWithTag(index);
        setText(tv,text);
    }
    public String getText(int index){
        if(mDatas != null && index >= 0 && index < mDatas.length){
            return mDatas[index];
        }
        return SysContants.CHAR_EMPTY;
    }

    private void setText(TextView tv,String text){
        if(tv != null){
            if(text == null){
                tv.setText(null);
            }
            tv.setText(Html.fromHtml(text));
        }
    }
    public void setData(String[] data,int selectIndex){

        if(data == null || data.length == 0){
            mDatas = data;
            removeAllViews();
        } else {
           /* if(!mMutiSelectMode && (selectIndex < 0 || selectIndex >= data.length)){
                //单选模式纠错
                selectIndex = 0;
            }*/
            if(mDatas != null && mDatas.length == data.length){
                mDatas = data;
                for(int i = 0 ; i < mDatas.length ; i++){
                    //只更新文字，选中状态不更新
                    final TextView tv = findViewWithTag(i);
                    setText(tv,mDatas[i]);
                }
                if(selectIndex >= 0){
                    setSelect(selectIndex,false);
                }
            } else {
                mDatas = data;
                addViewsByDatas();
                //设置默认选中，不回调
                if(selectIndex >= 0){
                    setSelect(selectIndex,false);
                }
            }
        }

    }




    private void addViewsByDatas(){
        removeAllViews();
        if(mDatas == null || mDatas.length == 0){
            return;
        }

        if(mViewLeftRightMarginCount == -1){
            mViewLeftRightMarginCount = mItemMarginHor * 2;
            //默认和mItemMarginHor一致
        }
        int itemWidth = (mViewWidth - mItemMarginHor * (mCountInLine * 2 ) - mViewLeftRightMarginCount) / mCountInLine;


        //记录当前子LinearLayout
        LinearLayout currentChildLinear = null;
        for(int i = 0 ; i < mDatas.length ; i++){

            AppCompatTextView tv = new AppCompatTextView(getContext());
            tv.setMaxLines(2);
            tv.setMinLines(1);
            tv.setPadding(3,3,3,3);
            tv.setGravity(Gravity.CENTER);
            tv.setTextColor(mTextColorN);
            tv.setBackgroundResource(mBgResN);
            tv.setTag(i);
            tv.setTag(R.id.radio_check_layout_select_state,false);

            tv.setOnClickListener(this);
            tv.setTextSize(TypedValue.COMPLEX_UNIT_SP,12);
            tv.measure(0,0);
            //tv.setHeight(tv.getMeasuredHeight() + mItemPaddingVer * 2);
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(itemWidth, LayoutParams.MATCH_PARENT);
            if(mLastWrapContent && i == mDatas.length - 1/*i == mDatas.length - 1 && mDatas.length % mCountInLine == mCountInLine - 1 && mCountInLine > 2 && mDatas[mDatas.length - 1].length() > 5*/){
                //最后一排不足时处理
                tv.setPadding(mItemPaddingVer * 2,mItemPaddingVer ,mItemPaddingVer * 2,mItemPaddingVer );
                params.width = LayoutParams.WRAP_CONTENT;
            } else {
              //  params.weight = 1;
            }
            params.leftMargin = mItemMarginHor;
            params.rightMargin = mItemMarginHor;
            params.topMargin = mItemMarginVer;
            params.bottomMargin = mItemMarginVer;

            if(i % mCountInLine == 0){
                //需要添加横线LinearLayout
                currentChildLinear = new LinearLayout(getContext());
                currentChildLinear.setOrientation(HORIZONTAL);
                final LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(LayoutParams.MATCH_PARENT, tv.getMeasuredHeight() + mItemPaddingVer * 2 + mItemMarginVer * 2);
                addView(currentChildLinear,layoutParams);
            }
            currentChildLinear.addView(tv,params);
            setText(tv,mDatas[i]);

        }
    }

    public void setSelect(int index,boolean callListener){
        if(index < 0 || index >= mDatas.length){
            return;
        }
        if(mMode == MODE_MUTI_SELECT || mMode == MODE_MUTI_SELECT_FIRST_ALL){
            setMutiSelect(index,callListener);
        } else if(mMode == MODE_SINGLE_SELECT) {
            setSingleSelect(index,callListener);
        } else if(mMode == MODE_SINGLE_CLICK){
            setSingleClick(index,callListener);
        }
    }
    public void realSetSelect(int index, boolean callListener){
        if(mDatas != null && index < 0 || index >= mDatas.length){
            return;
        }
        if(!isSelected(index)){
            setSelect(index,callListener);
        }
    }
    private void setSingleSelect(int index,boolean callListener){
        List<TextView> selectedTvs = findSelectedTvs();
        TextView tv = findViewWithTag(index);
        if(selectedTvs != null && selectedTvs.size() >= 1){
            if(selectedTvs.get(0) == tv){
                //单选已经选中，无需操作
                if(mOnItemSelectedListener != null && callListener){
                    mOnItemSelectedListener.onItemSelected(tv,index);
                }
                return;
            }
            unSelectView(selectedTvs.get(0));
        }
        selectView(tv);
        if(mOnItemSelectedListener != null && callListener){
            mOnItemSelectedListener.onItemSelected(tv,index);
        }
    }

    public void unselectAll(){
        List<TextView> selectedTvs = findSelectedTvs();
        if(selectedTvs != null && selectedTvs.size() > 0){
            for(TextView tv : selectedTvs){
                unSelectView(tv);
            }
        }
    }

    private void setMutiSelect(int index,boolean callListener){
        if(index < 0 || index >= mDatas.length){
            return;
        }
        TextView tv = findViewWithTag(index);
        boolean changeSelect = true;
        if(mMode == MODE_MUTI_SELECT_FIRST_ALL){
            //第一个是全选，需要特殊处理
            if(index == 0){
                if((boolean)tv.getTag(R.id.radio_check_layout_select_state)){
                    //"全部"已被选中，点击"全部"不作修改
                    changeSelect = false;
                } else {
                    //点击“全部”，其他的都不选中
                    List<TextView> selectedTvs = findSelectedTvs();
                    for(TextView item : selectedTvs){
                        unSelectView(item);
                    }
                }
            } else {
                int selectedCount = findSelectedTvs().size();
                if((boolean)tv.getTag(R.id.radio_check_layout_select_state)){
                    selectedCount -= 1;
                } else {
                    selectedCount += 1;
                }
                if(selectedCount > 0){
                    unSelectView(findViewWithTag(0));
                } else {
                    selectView(findViewWithTag(0));
                }
            }
        }
        if(!changeSelect){
            return;
        }
        if((boolean)tv.getTag(R.id.radio_check_layout_select_state)){
            //设置为未选中
            unSelectView(tv);
        } else {
            //设置为选中
            selectView(tv);
        }

        if(mOnItemSelectedListener != null && callListener){
            List<TextView> selectedTvs = findSelectedTvs();
            int[] selectedPostions = new int[selectedTvs.size()];
            for(int i = 0 ; i < selectedTvs.size() ; i++){
                selectedPostions[i] = (int)selectedTvs.get(i).getTag();
            }
            mOnItemSelectedListener.onMutiItemSelected(selectedPostions);
        }
    }

    private void setSingleClick(int index,boolean callListener){
        TextView tv = findViewWithTag(index);
        if(mOnItemSelectedListener != null && callListener){
            mOnItemSelectedListener.onItemSelected(tv,index);
        }
    }


    /**获取已选中的Item*/
    private List<TextView> findSelectedTvs(){
        final List<TextView> selected = new ArrayList<>();
        if(mDatas == null || mDatas.length == 0){
            return selected;
        }
        for(int i = 0 ; i < mDatas.length ; i++){
            TextView tv = findViewWithTag(i);
            if(tv != null && (boolean)tv.getTag(R.id.radio_check_layout_select_state)){
                selected.add(tv);
            }
        }
        return selected;
    }
    /**获取已选择的下标*/
    public List<Integer> findSelectedIndexs(){
        final List<Integer> selectedIndex = new ArrayList<>();
        if(mDatas == null || mDatas.length == 0){
            return selectedIndex;
        }
        for(int i = 0 ; i < mDatas.length ; i++){
            TextView tv = findViewWithTag(i);
            if(tv != null && (boolean)tv.getTag(R.id.radio_check_layout_select_state)){
                selectedIndex.add(i);
            }
        }
        return selectedIndex;
    }
    @Override
    public void onClick(View v) {
        final int index = (Integer) v.getTag();
        setSelect(index,true);

    }

    private void selectView(TextView tv){
        if(tv == null){
            return;
        }
        tv.setTextColor(mTextColorH);
        tv.setBackgroundResource(mBgResH);
        tv.setTag(R.id.radio_check_layout_select_state,true);
    }
    private void unSelectView(TextView tv){
        if(tv == null){
            return;
        }
        tv.setTextColor(mTextColorN);
        tv.setBackgroundResource(mBgResN);
        tv.setTag(R.id.radio_check_layout_select_state,false);
    }

    public boolean isSelected(int index){
        final TextView tv = findViewWithTag(index);
        return (boolean)tv.getTag(R.id.radio_check_layout_select_state);
    }
    private OnItemSelectedListener mOnItemSelectedListener;
    public void setOnItemSelectedListener(OnItemSelectedListener listener){
        mOnItemSelectedListener = listener;
    }
    public interface OnItemSelectedListener{
        public void onItemSelected(View view,int index);
        public void onMutiItemSelected(int[] positions);
    }

}
