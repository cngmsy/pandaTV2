package com.jiyun.qcloud.dashixummoban.ui.live;

import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jiyun.qcloud.dashixummoban.R;
import com.jiyun.qcloud.dashixummoban.base.BaseFragment;
import com.jiyun.qcloud.dashixummoban.entity.PandaLivepager;
import com.jiyun.qcloud.dashixummoban.ui.live.livepagerfragment.LivepagerContract;
import com.jiyun.qcloud.dashixummoban.ui.live.livepagerfragment.LivepagerPresenter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by chj on 2017/8/20.
 */

public class LivePageFragment extends BaseFragment implements LivepagerContract.view{
    @BindView(R.id.livepager_tablayout)
    TabLayout livepagerTablayout;
    @BindView(R.id.livepager_viewpager)
    ViewPager livepagerViewpager;
    Unbinder unbinder;
    private LivepagerContract.Presenter presenter;
    private List<Fragment>  list = new ArrayList<>();
    private List<String> listtitle = new ArrayList<String>();

    @Override
    protected int getLayoutRes() {
        return R.layout.fragment_livepager;
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initView(View view) {

        livepagerTablayout.setSelectedTabIndicatorColor(Color.BLUE);

        list.add(new LiveFragment());
        list.add(new JingCaiFragment());
        list.add(new DangXiongFragment());
        list.add(new ChaoMengFragment());
        list.add(new DangAnFragment());
        list.add(new TopFragment());
        list.add(new NaXieFragment());
        list.add(new TeBieFragment());
        list.add(new YuanChuangFragment());

        presenter=new LivepagerPresenter(this);
        presenter.start();
    }

    @Override
    public void setBundle(Bundle bundle) {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // TODO: inflate a fragment view
        View rootView = super.onCreateView(inflater, container, savedInstanceState);
        unbinder = ButterKnife.bind(this, rootView);
        return rootView;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @Override
    public void showLivepagerListData(PandaLivepager pandaLivepager) {

        List<PandaLivepager.TablistBean> tablist = pandaLivepager.getTablist();
        Log.e("tablist:",tablist.size()+"");

        for (int i = 0; i < tablist.size(); i++) {
            listtitle.add(tablist.get(i).getTitle());
        }
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

    }
}
