package com.jiyun.qcloud.dashixummoban.pandaliveactivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.VideoView;

import com.jiyun.qcloud.dashixummoban.R;
import com.jiyun.qcloud.dashixummoban.base.BaseActivity;
import com.jiyun.qcloud.dashixummoban.entity.PandaJingcai;
import com.jiyun.qcloud.dashixummoban.entity.Pandalivedetails;
import com.jiyun.qcloud.dashixummoban.entity.PandanShiJiao;
import com.jiyun.qcloud.dashixummoban.ui.live.jingcaifragment.JingCaiContract;
import com.jiyun.qcloud.dashixummoban.ui.live.jingcaifragment.JingCaiPresenter;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class PandaLiveActivity extends BaseActivity implements JingCaiContract.View{

    private JingCaiContract.Presenter presenter;
    @BindView(R.id.videoview)
    VideoView videoview;

    @Override
    protected void initData() {
        Intent intent = getIntent();
        String url = intent.getStringExtra("url");
        presenter = new JingCaiPresenter(this);
        presenter.second(url);
    }

    @Override
    protected void initView() {

    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_panda_live;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }

    @Override
    public void showJingCaiListData(PandaJingcai pandaJingcai) {

    }

    @Override
    public void showShiJiaoListData(PandanShiJiao pandanShiJiao) {

    }

    @Override
    public void showJingCaiListDataSecond(Pandalivedetails pandalivedetails) {
        List<Pandalivedetails.VideoBean.ChaptersBean> chapters = pandalivedetails.getVideo().getChapters();
        for (int i = 0; i < chapters.size(); i++) {
            String url = chapters.get(i).getUrl();
            videoview.setVideoURI(Uri.parse(url));
            videoview.start();
        }
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
