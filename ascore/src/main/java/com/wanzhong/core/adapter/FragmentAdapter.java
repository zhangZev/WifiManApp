package com.wanzhong.core.adapter;

import java.util.List;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

public class FragmentAdapter extends FragmentStatePagerAdapter {
    private List<Fragment> mFrags;
    private String[] mTitles;
    public FragmentAdapter(FragmentManager fm, List<Fragment> frags, String[] titles){
        super(fm);
        mFrags = frags;
        mTitles = titles;
    }
    @Override
    public Fragment getItem(int i) {
        return mFrags.size() > i ? mFrags.get(i) : null;
    }

    @Override
    public int getCount() {
        return mFrags == null ? 0 : mFrags.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return mTitles != null && mTitles.length > position ? mTitles[position] : "";
    }
}
