package com.jiyun.qcloud.dashixummoban.ui.live.livefragment;

import com.jiyun.qcloud.dashixummoban.entity.PandaLive;
import com.jiyun.qcloud.dashixummoban.entity.PandaLiveVideo;
import com.jiyun.qcloud.dashixummoban.modle.liveModel.IPandaLiveModel;
import com.jiyun.qcloud.dashixummoban.modle.liveModel.PandaLiveModelImpl;
import com.jiyun.qcloud.dashixummoban.modle.net.callback.NetWorkCallBack;

import java.util.Map;

/**
 * Created by ASUS on 2017/8/23.
 */

public class LivePresenter implements LiveContract.Presenter {

    private LiveContract.View liveView;
    private IPandaLiveModel iPandaLiveModel;

    public LivePresenter(LiveContract.View liveView) {
        this.liveView = liveView;
        liveView.setPresenter(this);
        this.iPandaLiveModel = new PandaLiveModelImpl();
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
        liveView.showProgress();
        iPandaLiveModel.loadLiveList(new NetWorkCallBack<PandaLive>() {
            @Override
            public void onSuccess(PandaLive pandaLive) {
                liveView.showLiveListData(pandaLive);
                liveView.dimissProgress();
            }

            @Override
            public void onError(int errorCode, String errorMsg) {
                liveView.showMessage(errorMsg);
                liveView.dimissProgress();
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
        liveView.showProgress();
        iPandaLiveModel.loadLiveListSecond(new NetWorkCallBack<PandaLiveVideo>() {
            @Override
            public void onSuccess(PandaLiveVideo pandaLiveVideo) {
                liveView.showLiveListDataSecond(pandaLiveVideo);
                liveView.showProgress();
            }

            @Override
            public void onError(int errorCode, String errorMsg) {
                liveView.showMessage(errorMsg);
                liveView.dimissProgress();
            }

            @Override
            public void onFail(String netOff) {

            }
        },url);
    }

    @Override
    public void threed(Map<String, String> map) {

    }

    @Override
    public void four(Map<String, String> map) {

    }
}
