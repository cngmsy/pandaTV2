package com.jiyun.qcloud.dashixummoban.ui.web2;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.util.Log;
import android.widget.RelativeLayout;

import com.jiyun.qcloud.dashixummoban.R;
import com.jiyun.qcloud.dashixummoban.base.BaseActivity;
import com.jiyun.qcloud.dashixummoban.entity.Web2Entity1;
import com.jiyun.qcloud.dashixummoban.entity.Web2Entity2;
import com.jiyun.qcloud.dashixummoban.entity.Web2Entity3;

import butterknife.BindView;
import butterknife.ButterKnife;
import fm.jiecao.jcvideoplayer_lib.JCVideoPlayer;

public class VideoActivity extends BaseActivity implements Web2Contract.view {
    @BindView(R.id.videoactivity_jc)
    JCVideoPlayer videoactivityJc;
    @BindView(R.id.activity_video)
    RelativeLayout activityVideo;
    private Web2Contract.presenter presenter;

    @Override
    protected void initData() {

    }

    @Override
    protected void initView() {
        Intent intent = getIntent();
        String stringExtra = intent.getStringExtra("pid");
        presenter = new Web2Presenter(this);
        presenter.second(stringExtra);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_video;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }

    @Override
    public void showWeb2list1(Web2Entity1 list1) {

    }

    @Override
    public void showWeb2list2(Web2Entity2 list2) {
        String url = list2.getVideo().getChapters().get(0).getUrl();
        Log.e("AAAAA", url);
        videoactivityJc.setUpForFullscreen(url, "视频/MP3标题");
    }

    @Override
    public void showWeb2list3(Web2Entity3 list3) {

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
    public void setPresenter(Web2Contract.presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    protected void onPause() {
        super.onPause();
        JCVideoPlayer.releaseAllVideos();
    }

    @Override
    protected void onResume() {
        /**
         * 设置为横屏
         */
        if (getRequestedOrientation() != ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE) {
            setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        }
        super.onResume();
    }
}
