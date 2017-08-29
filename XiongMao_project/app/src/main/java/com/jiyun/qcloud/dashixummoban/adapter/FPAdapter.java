package com.jiyun.qcloud.dashixummoban.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * Created by 王晓亮 on 2017/8/27.
 */

public class FPAdapter extends FragmentPagerAdapter {
    private List<String> listname;
    private List<Fragment> listfragment;

    public FPAdapter(FragmentManager fm, List<String> listname, List<Fragment> listfragment) {
        super(fm);
        this.listfragment = listfragment;
        this.listname = listname;
    }

    @Override
    public Fragment getItem(int position) {
        return listfragment.get(position);
    }

    @Override
    public int getCount() {
        return listfragment.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return listname.get(position);
    }
}
