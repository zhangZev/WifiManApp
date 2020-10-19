package com.wanzhong.core.dialog;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.util.TypedValue;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.wanzhong.core.BaseApp;
import com.wanzhong.core.R;
import com.wanzhong.core.view.bottombar.UIUtils;

public class DropDownListPopupFullScreen extends DropDownListPopup {
    public DropDownListPopupFullScreen(Context context) {
        super(context);
    }

    public PopupWindow setData(Context context, String[] datas, int selectPosition){
        setBackgroundDrawable(new ColorDrawable(Color.parseColor("#ffffffff")));
        if(linearLayout == null){
            linearLayout = new LinearLayout(context);
            //linearLayout.setBackgroundResource(R.drawable.drop_down_list_popup_bg);
            linearLayout.setOrientation(LinearLayout.VERTICAL);
            setContentView(linearLayout);
        }
        final int itemPaddingHor = UIUtils.dip2Px(context,10);
        final int itemPaddingVer = UIUtils.dip2Px(context,16);
        if(datas == null || datas.length > 0){
            for(int i = 0 ; i < datas.length ;i++){
                TextView tv = new TextView(context);
                tv.setTextSize(TypedValue.COMPLEX_UNIT_SP,13);
                tv.setTextColor(mTextColorN);
                tv.setTag(i);
                tv.setTag(R.id.radio_check_layout_select_state,false);
                tv.setOnClickListener(this);
                tv.setText(datas[i]);
                tv.setBackgroundResource(R.drawable.drop_down_list_popup_divider);
                /*if(i < datas.length - 1){
                    tv.setBackgroundResource(R.drawable.drop_down_list_popup_divider);
                } else {
                    tv.setBackgroundResource(R.drawable.item_background_material);
                }*/
                tv.setPadding(itemPaddingVer,itemPaddingHor,itemPaddingVer,itemPaddingHor);
                final LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(BaseApp.getInstance().mScreenWidth,LinearLayout.LayoutParams.WRAP_CONTENT);
                linearLayout.addView(tv,params);
            }
            setSelect(selectPosition);
        }
        return this;
    }
    @Override
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
                    tv.setCompoundDrawablesWithIntrinsicBounds(null,null,linearLayout.getResources().getDrawable(R.drawable.icon_drop_down_item_selected),null);
                } else {
                    tv.setTextColor(mTextColorN);
                    tv.setTag(R.id.radio_check_layout_select_state,false);
                    tv.setCompoundDrawablesWithIntrinsicBounds(null,null,null,null);

                }
            }
        }
    }

    @Override
    public void showAsDropDown(View achor){
        this.setOutsideTouchable(true);
        achor.measure(0,0);
        final int auchorWidth = achor.getMeasuredWidth();
        final int popupWidth = getMesuredWidth();
        showAsDropDown(achor,0 ,1);
    }
}
