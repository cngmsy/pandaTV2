package com.jiyun.qcloud.dashixummoban.activity.hudong;

import com.jiyun.qcloud.dashixummoban.entity.ShoyeHudongBean;
import com.jiyun.qcloud.dashixummoban.modle.dataModel.IPandaHomeModel;
import com.jiyun.qcloud.dashixummoban.modle.dataModel.PandaHomeModelImpl;
import com.jiyun.qcloud.dashixummoban.modle.net.callback.NetWorkCallBack;

import java.util.Map;

/**
 * Created by Administrator on 2017/8/23.
 */
//互动页面的P层
public class HuDongPresenter  implements HuDong.Presenter{
    //持有view层对象
    HuDong.View view;
    //持有model层对象
    IPandaHomeModel model;

    public HuDongPresenter(HuDong.View view) {
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
        view.showProgress();
        model.loadHuDongList(new NetWorkCallBack<ShoyeHudongBean>() {
            @Override
            public void onSuccess(ShoyeHudongBean shoyeHudongBean) {
                view.showHudongList(shoyeHudongBean);
                view.dimissProgress();
            }

            @Override
            public void onError(int errorCode, String errorMsg) {
                view.showMessage(errorMsg);
                view.dimissProgress();
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
