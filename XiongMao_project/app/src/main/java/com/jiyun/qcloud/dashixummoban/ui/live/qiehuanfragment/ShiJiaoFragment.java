package com.jiyun.qcloud.dashixummoban.ui.live.qiehuanfragment;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;

import com.jiyun.qcloud.dashixummoban.R;
import com.jiyun.qcloud.dashixummoban.adapter.ShiJiaoAdapter;
import com.jiyun.qcloud.dashixummoban.base.BaseFragment;
import com.jiyun.qcloud.dashixummoban.customview.MyGridView;
import com.jiyun.qcloud.dashixummoban.entity.PandaJingcai;
import com.jiyun.qcloud.dashixummoban.entity.Pandalivedetails;
import com.jiyun.qcloud.dashixummoban.entity.PandanShiJiao;
import com.jiyun.qcloud.dashixummoban.ui.live.jingcaifragment.JingCaiContract;
import com.jiyun.qcloud.dashixummoban.ui.live.jingcaifragment.JingCaiPresenter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.Unbinder;
import de.greenrobot.event.EventBus;

/**
 * Created by ASUS on 2017/8/25.
 */

public class ShiJiaoFragment extends BaseFragment implements JingCaiContract.View {

    @BindView(R.id.shijiao_gridview)
    MyGridView shijiaoGridview;
    Unbinder unbinder;
    private JingCaiContract.Presenter presenter;
    private List<PandanShiJiao.ListBean> list = new ArrayList<>();
    private ShiJiaoAdapter shiJiaoAdapter;

    @Override
    protected int getLayoutRes() {
        return R.layout.fragment_shijiao;
    }

    @Override
    protected void initData() {
        presenter = new JingCaiPresenter(this);
        presenter.startshijiao();

        shijiaoGridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                EventBus.getDefault().post(list.get(i));
            }
        });
    }

    @Override
    protected void initView(View view) {

        shiJiaoAdapter = new ShiJiaoAdapter(getActivity(), list);
        shijiaoGridview.setAdapter(shiJiaoAdapter);
    }

    @Override
    public void setBundle(final Bundle bundle) {

    }

    @Override
    public void showJingCaiListData(PandaJingcai pandaJingcai) {

    }

    @Override
    public void showShiJiaoListData(PandanShiJiao pandanShiJiao) {
        List<PandanShiJiao.ListBean> listBeen = pandanShiJiao.getList();
        list.addAll(listBeen);
        shiJiaoAdapter.notifyDataSetChanged();
    }

    @Override
    public void showJingCaiListDataSecond(Pandalivedetails pandalivedetails) {

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
    public void setPresenter(JingCaiContract.Presenter presenter) {

    }
}
