package com.jiyun.qcloud.dashixummoban.ui.live;


import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.View;

import com.jiyun.qcloud.dashixummoban.R;
import com.jiyun.qcloud.dashixummoban.base.BaseFragment;
import com.jiyun.qcloud.dashixummoban.customview.IndexViewPager;
import com.jiyun.qcloud.dashixummoban.entity.PandaLivepager;
import com.jiyun.qcloud.dashixummoban.ui.live.livepagerfragment.LivepagerContract;
import com.jiyun.qcloud.dashixummoban.ui.live.livepagerfragment.LivepagerPresenter;
import com.orhanobut.logger.Logger;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.Unbinder;

/**
 * Created by chj on 2017/8/20.
 */

public class LivePageFragment extends BaseFragment implements LivepagerContract.view {


    @BindView(R.id.livepager_tablayout)
    TabLayout livepagerTablayout;
    @BindView(R.id.livepager_viewpager)
    IndexViewPager livepagerViewpager;
    Unbinder unbinder;
    private LivepagerContract.Presenter presenter;
    private List<Fragment> list = new ArrayList<>();
    private List<String> listtitle = new ArrayList<String>();

    @Override
    protected int getLayoutRes() {
        return R.layout.fragment_livepager;
    }

    @Override
    protected void initData() {
        presenter = new LivepagerPresenter(this);
        presenter.start();
    }

    @Override
    protected void initView(View view) {
        livepagerTablayout.setSelectedTabIndicatorColor(Color.BLUE);
    }

    @Override
    public void setBundle(Bundle bundle) {

    }

    @Override
    public void showLivepagerListData(PandaLivepager pandaLivepager) {

        List<PandaLivepager.TablistBean> tablist = pandaLivepager.getTablist();
        Logger.d("tablist:" + tablist.size() + "");

        for (int i = 0; i < tablist.size(); i++) {
            listtitle.add(tablist.get(i).getTitle());
        }
        list.add(new LiveFragment());
        list.add(new JingCaiFragment());
        list.add(new DangXiongFragment());
        list.add(new ChaoMengFragment());
        list.add(new DangAnFragment());
        list.add(new TopFragment());
        list.add(new NaXieFragment());
        list.add(new TeBieFragment());
        list.add(new YuanChuangFragment());
        Logger.d("list:" + list.size() + "");

        livepagerViewpager.setAdapter(new FragmentPagerAdapter(getFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                return list.get(position);
            }

            @Override
            public int getCount() {
                return list.size();
            }

            @Override
            public CharSequence getPageTitle(int position) {
                return listtitle.get(position);
            }
        });
        livepagerTablayout.setupWithViewPager(livepagerViewpager);
    }

    @Override
    public void playVideo() {

    }

    @Override
    public void loadWebView() {

    }

    @Override
    public void showProgress() {

    }

    @Override
    public void dimissProgress() {

    }

    @Override
    public void showMessage(String msg) {

    }

    @Override
    public void setPresenter(LivepagerContract.Presenter presenter) {
        this.presenter = presenter;
    }
}
