package com.jiyun.qcloud.dashixummoban.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.jiyun.qcloud.dashixummoban.base.BaseFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by KING on 2017/8/24 20:57
 * 邮箱:992767879@qq.com
 */

public class AdapterFarmentChina extends FragmentPagerAdapter {
    private List<String> tab;
    private List<BaseFragment> framentlist;

    public AdapterFarmentChina(FragmentManager fm, List<String> tab, List<BaseFragment> framentlist) {
        super(fm);
        this.tab = tab;
        this.framentlist = framentlist;
    }

    @Override
    public Fragment getItem(int position) {
        return framentlist.get(position);
    }

    @Override
    public int getCount() {
        return framentlist.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return tab.get(position);
    }
    public  void shaxin(List<String> tab){
        this.tab=tab;
    }
}
