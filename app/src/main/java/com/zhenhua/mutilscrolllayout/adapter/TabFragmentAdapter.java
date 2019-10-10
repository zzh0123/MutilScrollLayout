package com.zhenhua.mutilscrolllayout.adapter;

import android.content.Context;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import java.util.List;

/**
 * @Description:
 * @Author: zzh
 * @CreateDate: 2019-10-07 12:09
 */
public class TabFragmentAdapter extends FragmentPagerAdapter {

    private Context context;
    private List<Fragment> fragmentList;
    private String[] titleArr;

    public TabFragmentAdapter(List<Fragment> fragmentList, String[] titleArr, FragmentManager fm, Context context) {
        super(fm);
        this.context = context;
        this.fragmentList = fragmentList;
        this.titleArr = titleArr;
    }

    @Override
    public Fragment getItem(int position) {
        return fragmentList.get(position);
    }

    @Override
    public int getCount() {
        return fragmentList.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return titleArr[position];
    }

}
