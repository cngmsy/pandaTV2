package com.jiyun.qcloud.dashixummoban.activity.hudong;

import android.os.Bundle;
import android.os.Handler;
import android.support.v7.widget.LinearLayoutManager;
import android.widget.ImageView;

import com.jcodecraeer.xrecyclerview.XRecyclerView;
import com.jiyun.qcloud.dashixummoban.R;
import com.jiyun.qcloud.dashixummoban.adapter.HuDongRecyclerAdapter;
import com.jiyun.qcloud.dashixummoban.base.BaseActivity;
import com.jiyun.qcloud.dashixummoban.entity.ShoyeHudongBean;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class HuDongActivity extends BaseActivity implements HuDong.Presenter, HuDong.View {

    HuDong.Presenter presenter;
    List<ShoyeHudongBean.InteractiveBean> listdata = new ArrayList<>();
    @BindView(R.id.hudong_xrecycler)
    XRecyclerView hudongXrecycler;
    Handler handler = new Handler();
    @BindView(R.id.hudong_return)
    ImageView hudongReturn;
    private HuDongRecyclerAdapter huDongRecyclerAdapter;

    @Override
    protected void initData() {
        new HuDongPresenter(this);
        presenter.start();
    }

    @Override
    protected void initView() {
        //设置适配器
        huDongRecyclerAdapter = new HuDongRecyclerAdapter(this, listdata);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(HuDongActivity.this);
        hudongXrecycler.setLayoutManager(linearLayoutManager);
        hudongXrecycler.setAdapter(huDongRecyclerAdapter);

        hudongXrecycler.setRefreshProgressStyle(3);//刷新样式
        //设置刷新时间
        hudongXrecycler.setLoadingListener(new XRecyclerView.LoadingListener() {
            @Override
            public void onRefresh() {
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        hudongXrecycler.refreshComplete();
                    }
                }, 1500);


            }

            @Override
            public void onLoadMore() {
                hudongXrecycler.loadMoreComplete();
            }
        });
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_hu_dong;
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
    public void setPresenter(HuDong.Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void start() {

    }

    @Override
    public void second(String url) {

    }

    @Override
    public void threed(Map<String, String> map) {

    }

    @Override
    public void four(Map<String, String> map) {

    }

    @Override
    public void showHudongList(ShoyeHudongBean shoyeHudongBean) {
        //将list集合赋值
        listdata.addAll(shoyeHudongBean.getInteractive());
        huDongRecyclerAdapter.notifyDataSetChanged();

    }

    @Override
    public void playVideo() {

    }

    @Override
    public void loadWebView() {

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }

    @OnClick(R.id.hudong_return)
    public void onViewClicked() {
        finish();
    }
}
