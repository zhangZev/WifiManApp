/*
package cn.icanfitness.ican.app.common.frag;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import cn.icanfitness.ican.app.common.R;
import cn.icanfitness.ican.app.common.po.SimpleSingleChooseItemPo;
import cn.icanfitness.ican.core.frag.BaseFragment;

public class AreaChooseFrag extends BaseFragment {

    */
/**省*//*

    private SimpleSingleChooseItemPo mProvince;
    */
/**市*//*

    private SimpleSingleChooseItemPo mCity;
    */
/**县*//*

    private SimpleSingleChooseItemPo mArea;
    */
/**乡*//*

    private SimpleSingleChooseItemPo mStreets;

    TextView tv_province;
    TextView tv_city;
    TextView tv_area;
    TextView tv_street;

    */
/**是否显示顶部不限,getLevel() == 1 时不会显示*//*

    private boolean mShowAll = false;

    private AreaChooseItemFrag mAreaChooseFrag;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_location_choose;
    }

    @Override
    protected void initView(View view) {
        super.initView(view);
        setTitle("选择门店地址");
        if(getIntent() != null && getIntent().hasExtra("showAll")){
            mShowAll = getIntent().getBooleanExtra("showAll",false);
        }

        tv_province = view.findViewById(R.id.tv_province);
        tv_city = view.findViewById(R.id.tv_city);
        tv_area = view.findViewById(R.id.tv_area);
        tv_street = findViewById(R.id.tv_street);

        mAreaChooseFrag = new AreaChooseItemFrag();
        Bundle intent = new Bundle();
        intent.putBoolean("showAll",mShowAll);
        getSupportFragmentManager().beginTransaction().add(R.id.layout_province, mAreaChooseFrag).commit();

        mAreaChooseFrag.setItemOnClickListener(mProvinceItemClickListener);
    }

    @Override
    protected boolean isStatusBarDarkFont() {
        return true;
    }

}
*/
