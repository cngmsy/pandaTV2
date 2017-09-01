package com.jiyun.qcloud.dashixummoban.ui.bobao;

import com.jiyun.qcloud.dashixummoban.entity.BoBaoEntity1;
import com.jiyun.qcloud.dashixummoban.entity.BoBaoEntity2;
import com.jiyun.qcloud.dashixummoban.modle.dataModel.bobao.BoBaoModelImpl;
import com.jiyun.qcloud.dashixummoban.modle.dataModel.bobao.IBobaoModel;
import com.jiyun.qcloud.dashixummoban.modle.net.callback.NetWorkCallBack;

import java.util.Map;

/**
 * Created by 王晓亮 on 2017/8/24.
 */

public class BoBAoPresenter implements BoBaoContract.presenter {
    private BoBaoContract.view view;
    private IBobaoModel model;

    public BoBAoPresenter(BoBaoContract.view view) {
        this.view = view;
        view.setPresenter(this);
        model = new BoBaoModelImpl();
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
        model.loadBoBaolist(new NetWorkCallBack<BoBaoEntity1>() {
            @Override
            public void onSuccess(BoBaoEntity1 boBaoEntity1) {
                view.showBoBaolist(boBaoEntity1);
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
        model.loadBoBaolist2(new NetWorkCallBack<BoBaoEntity2>() {
            @Override
            public void onSuccess(BoBaoEntity2 boBaoEntity2) {
                view.showBoBaolist2(boBaoEntity2.getList());
            }

            @Override
            public void onError(int errorCode, String errorMsg) {

            }

            @Override
            public void onFail(String netOff) {

            }
        }, url);
    }

    @Override
    public void threed(Map<String, String> map) {
//        model.loadBoBaolist2(new NetWorkCallBack<BoBaoEntity2>() {
//            @Override
//            public void onSuccess(BoBaoEntity2 boBaoEntity2) {
//                view.showBoBaolist2(boBaoEntity2.getList());
//            }
//
//            @Override
//            public void onError(int errorCode, String errorMsg) {
//
//            }
//
//            @Override
//            public void onFail(String netOff) {
//
//            }
//        }, map);
    }

    @Override
    public void four(Map<String, String> map) {

    }


}
