package com.wanzhong.core.dialog;

import android.content.Context;
import android.util.TypedValue;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.wanzhong.core.R;
import com.wanzhong.core.view.bottombar.UIUtils;

public class DropDownListPopup extends PopupWindow implements View.OnClickListener {

    protected int mTextColorN;
    protected int mTextColorH;
    LinearLayout linearLayout;
    public DropDownListPopup(Context context) {
        super(context);
        mTextColorN = context.getResources().getColor(R.color.text_color_dark);
        mTextColorH = context.getResources().getColor(R.color.color_app_main);
    }

    public PopupWindow setData(Context context,String[] datas,int selectPosition){
        setBackgroundDrawable(context.getResources().getDrawable(R.drawable.drop_down_list_popup_bg));
        if(linearLayout == null){
            linearLayout = new LinearLayout(context);
            //linearLayout.setBackgroundResource(R.drawable.drop_down_list_popup_bg);
            linearLayout.setOrientation(LinearLayout.VERTICAL);
            setContentView(linearLayout);
        }
        final int itemPadding = UIUtils.dip2Px(context,10);
        if(datas == null || datas.length > 0){
            for(int i = 0 ; i < datas.length ;i++){
                TextView tv = new TextView(context);
                tv.setTextSize(TypedValue.COMPLEX_UNIT_SP,13);
                tv.setTextColor(mTextColorN);
                tv.setTag(i);
                tv.setTag(R.id.radio_check_layout_select_state,false);
                tv.setOnClickListener(this);
                tv.setText(datas[i]);
                if(i < datas.length - 1){
                    tv.setBackgroundResource(R.drawable.drop_down_list_popup_divider);
                } else {
                    tv.setBackgroundResource(R.drawable.item_background_material);
                }
                tv.setPadding(itemPadding,itemPadding,itemPadding,itemPadding);
                linearLayout.addView(tv);
            }
            setSelect(selectPosition);
        }
        return this;
    }

    public int getMesuredWidth(){
        linearLayout.measure(0,0);
        return linearLayout.getMeasuredWidth();
    }

    protected void setSelect(int position){
        if(linearLayout == null){
            return;
        }
        for(int i = 0; i < linearLayout.getChildCount() ; i++){
            if(linearLayout.getChildAt(i) instanceof  TextView){
                final TextView tv = (TextView)linearLayout.getChildAt(i);
                if((int)tv.getTag() == position){
                    tv.setTextColor(mTextColorH);
                    tv.setTag(R.id.radio_check_layout_select_state,true);
                } else {
                    tv.setTextColor(mTextColorN);
                    tv.setTag(R.id.radio_check_layout_select_state,false);
                }
            }
        }
    }

    @Override
    public void onClick(View v) {
        final int postion = (int)v.getTag();
        setSelect(postion);
        if(mOnDropDownPopupItemClickListener != null){
            mOnDropDownPopupItemClickListener.onDropDwonPopupItemClicked(postion);
        }
        dismiss();
    }

    private OnDropDownPopupItemClickListener mOnDropDownPopupItemClickListener;
    public void setOnDropDownPopupItemClickListener(OnDropDownPopupItemClickListener listener){
        mOnDropDownPopupItemClickListener = listener;
    }
    public interface OnDropDownPopupItemClickListener{
        public void onDropDwonPopupItemClicked(int position);
    }

    public void showAsDropDown(View achor){
        this.setOutsideTouchable(true);
        achor.measure(0,0);
        final int auchorWidth = achor.getMeasuredWidth();
        final int popupWidth = getMesuredWidth();
        if(auchorWidth >= popupWidth){
            showAsDropDown(achor,(auchorWidth - popupWidth) / 2 ,-UIUtils.dip2Px(achor.getContext(),8));
        } else {
            showAsDropDown(achor, (auchorWidth - popupWidth)  ,-UIUtils.dip2Px(achor.getContext(),8));
        }
    }
}
