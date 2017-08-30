package com.jiyun.qcloud.dashixummoban.ui.live.livepagerfragment;

import com.jiyun.qcloud.dashixummoban.entity.PandaLivepager;
import com.jiyun.qcloud.dashixummoban.modle.livepagerModel.IPandaLivepagerModel;
import com.jiyun.qcloud.dashixummoban.modle.livepagerModel.PandaLivepagerModelImpl;
import com.jiyun.qcloud.dashixummoban.modle.net.callback.NetWorkCallBack;

import java.util.Map;

/**
 * Created by ASUS on 2017/8/24.
 */

public class LivepagerPresenter implements LivepagerContract.Presenter{

    private LivepagerContract.view livepagerView;
    private IPandaLivepagerModel iPandaLivepagerModel;

    public LivepagerPresenter(LivepagerContract.view livepagerView) {
        this.livepagerView = livepagerView;
        livepagerView.setPresenter(this);
        this.iPandaLivepagerModel = new PandaLivepagerModelImpl();
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
        livepagerView.showProgress();
        iPandaLivepagerModel.loadLivepagerList(new NetWorkCallBack<PandaLivepager>() {
            @Override
            public void onSuccess(PandaLivepager pandaLivepager) {
                livepagerView.showLivepagerListData(pandaLivepager);
                livepagerView.dimissProgress();
            }

            @Override
            public void onError(int errorCode, String errorMsg) {
                livepagerView.showMessage(errorMsg);
                livepagerView.dimissProgress();
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

    }

    @Override
    public void threed(Map<String, String> map) {

    }

    @Override
    public void four(Map<String, String> map) {

    }


}
