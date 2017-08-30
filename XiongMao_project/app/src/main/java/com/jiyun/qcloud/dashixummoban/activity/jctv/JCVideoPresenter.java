package com.jiyun.qcloud.dashixummoban.activity.jctv;

import com.jiyun.qcloud.dashixummoban.entity.Pandalivedetails;
import com.jiyun.qcloud.dashixummoban.entity.shoye.HomeJCBean;
import com.jiyun.qcloud.dashixummoban.modle.dataModel.IPandaHomeModel;
import com.jiyun.qcloud.dashixummoban.modle.dataModel.PandaHomeModelImpl;
import com.jiyun.qcloud.dashixummoban.modle.net.callback.NetWorkCallBack;

import java.util.Map;

/**
 * Created by Administrator on 2017/8/25.
 */

public class JCVideoPresenter implements JCVideo.Presenter {

    private JCVideo.View view;
    private IPandaHomeModel model;
    String url;

    public JCVideoPresenter(String url,JCVideo.View view) {
        this.url=url;
        this.view = view;
        view.setPresenter(this);
        this.model=new PandaHomeModelImpl();
    }

    @Override
    public void startmap1(Map<String, String> map) {

    }

    @Override
    public void startmap2(Map<String, String> map) {

    }

    @Override
    public void startmap3(Map<String, String> map) {

    }

    @Override
    public void startmap4(Map<String, String> map) {

    }

    @Override
    public void startmap5(Map<String, String> map) {

    }

    @Override
    public void startmap6(Map<String, String> map) {

    }

    @Override
    public void startmap7(Map<String, String> map) {

    }

    @Override
    public void startmap8(Map<String, String> map) {

    }

    @Override
    public void start() {
        model.HomeJCVideo(url, new NetWorkCallBack<HomeJCBean>() {
            @Override
            public void onSuccess(HomeJCBean homeJCBean) {
                view.showHudongList(homeJCBean);
            }

            @Override
            public void onError(int errorCode, String errorMsg) {

            }

            @Override
            public void onFail(String netOff) {

            }
        });

    }

    @Override
    public void startshijiao() {

    }

    @Override
    public void second(String url) {
        model.videodetails(url, new NetWorkCallBack<Pandalivedetails>() {
            @Override
            public void onSuccess(Pandalivedetails pandalivedetails) {
                view.videodetails(pandalivedetails);
            }

            @Override
            public void onError(int errorCode, String errorMsg) {

            }

            @Override
            public void onFail(String netOff) {

            }
        });
    }

    @Override
    public void threed(Map<String, String> map) {

    }

    @Override
    public void four(Map<String, String> map) {

    }
}
