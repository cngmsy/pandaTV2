package com.jiyun.qcloud.dashixummoban.ui.live.jingcaifragment;

import com.jiyun.qcloud.dashixummoban.entity.PandaJingcai;
import com.jiyun.qcloud.dashixummoban.entity.Pandalivedetails;
import com.jiyun.qcloud.dashixummoban.entity.PandanShiJiao;
import com.jiyun.qcloud.dashixummoban.modle.jingcaiModel.IJingCaiModel;
import com.jiyun.qcloud.dashixummoban.modle.jingcaiModel.PandaJingcaiModelImpl;
import com.jiyun.qcloud.dashixummoban.modle.net.callback.NetWorkCallBack;

import java.util.Map;

/**
 * Created by ASUS on 2017/8/24.
 */

public class JingCaiPresenter implements JingCaiContract.Presenter{

    private JingCaiContract.View jingcaiView;
    private IJingCaiModel iJingCaiModel;

    public JingCaiPresenter(JingCaiContract.View jingcaiView) {
        this.jingcaiView = jingcaiView;
        jingcaiView.setPresenter(this);
        this.iJingCaiModel = new PandaJingcaiModelImpl();
    }

    @Override
    public void startshijiao() {
        jingcaiView.showProgress();
        iJingCaiModel.loadShiJiaoList(new NetWorkCallBack<PandanShiJiao>() {
            @Override
            public void onSuccess(PandanShiJiao pandanShiJiao) {
                jingcaiView.showShiJiaoListData(pandanShiJiao);
                jingcaiView.dimissProgress();
            }

            @Override
            public void onError(int errorCode, String errorMsg) {
                jingcaiView.showMessage(errorMsg);
                jingcaiView.dimissProgress();
            }

            @Override
            public void onFail(String netOff) {

            }
        });
    }

    @Override
    public void second(String url) {
        jingcaiView.showProgress();
        iJingCaiModel.loadJingcaipagerListSecond(new NetWorkCallBack<Pandalivedetails>() {
            @Override
            public void onSuccess(Pandalivedetails pandalivedetails) {
                jingcaiView.showJingCaiListDataSecond(pandalivedetails);
                jingcaiView.dimissProgress();
            }

            @Override
            public void onError(int errorCode, String errorMsg) {
                jingcaiView.showMessage(errorMsg);
                jingcaiView.dimissProgress();
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

    @Override
    public void start() {

    }

    @Override
    public void startmap1(Map<String, String> map) {
        jingcaiView.showProgress();
        iJingCaiModel.loadJingcaipagerList1(new NetWorkCallBack<PandaJingcai>() {
            @Override
            public void onSuccess(PandaJingcai pandaJingcai) {
                jingcaiView.showJingCaiListData(pandaJingcai);
                jingcaiView.dimissProgress();
            }

            @Override
            public void onError(int errorCode, String errorMsg) {
                jingcaiView.showMessage(errorMsg);
                jingcaiView.dimissProgress();
            }

            @Override
            public void onFail(String netOff) {

            }
        },map);
    }


    @Override
    public void startmap2(Map<String, String> map) {
        jingcaiView.showProgress();
        iJingCaiModel.loadJingcaipagerList2(new NetWorkCallBack<PandaJingcai>() {
            @Override
            public void onSuccess(PandaJingcai pandaJingcai) {
                jingcaiView.showJingCaiListData(pandaJingcai);
                jingcaiView.dimissProgress();
            }

            @Override
            public void onError(int errorCode, String errorMsg) {
                jingcaiView.showMessage(errorMsg);
                jingcaiView.dimissProgress();
            }

            @Override
            public void onFail(String netOff) {

            }
        },map);
    }

    @Override
    public void startmap3(Map<String, String> map) {
        jingcaiView.showProgress();
        iJingCaiModel.loadJingcaipagerList3(new NetWorkCallBack<PandaJingcai>() {
            @Override
            public void onSuccess(PandaJingcai pandaJingcai) {
                jingcaiView.showJingCaiListData(pandaJingcai);
                jingcaiView.dimissProgress();
            }

            @Override
            public void onError(int errorCode, String errorMsg) {
                jingcaiView.showMessage(errorMsg);
                jingcaiView.dimissProgress();
            }

            @Override
            public void onFail(String netOff) {

            }
        },map);
    }

    @Override
    public void startmap4(Map<String, String> map) {
        jingcaiView.showProgress();
        iJingCaiModel.loadJingcaipagerList4(new NetWorkCallBack<PandaJingcai>() {
            @Override
            public void onSuccess(PandaJingcai pandaJingcai) {
                jingcaiView.showJingCaiListData(pandaJingcai);
                jingcaiView.dimissProgress();
            }

            @Override
            public void onError(int errorCode, String errorMsg) {
                jingcaiView.showMessage(errorMsg);
                jingcaiView.dimissProgress();
            }

            @Override
            public void onFail(String netOff) {

            }
        },map);
    }

    @Override
    public void startmap5(Map<String, String> map) {
        jingcaiView.showProgress();
        iJingCaiModel.loadJingcaipagerList5(new NetWorkCallBack<PandaJingcai>() {
            @Override
            public void onSuccess(PandaJingcai pandaJingcai) {
                jingcaiView.showJingCaiListData(pandaJingcai);
                jingcaiView.dimissProgress();
            }

            @Override
            public void onError(int errorCode, String errorMsg) {
                jingcaiView.showMessage(errorMsg);
                jingcaiView.dimissProgress();
            }

            @Override
            public void onFail(String netOff) {

            }
        },map);
    }

    @Override
    public void startmap6(Map<String, String> map) {
        jingcaiView.showProgress();
        iJingCaiModel.loadJingcaipagerList6(new NetWorkCallBack<PandaJingcai>() {
            @Override
            public void onSuccess(PandaJingcai pandaJingcai) {
                jingcaiView.showJingCaiListData(pandaJingcai);
                jingcaiView.dimissProgress();
            }

            @Override
            public void onError(int errorCode, String errorMsg) {
                jingcaiView.showMessage(errorMsg);
                jingcaiView.dimissProgress();
            }

            @Override
            public void onFail(String netOff) {

            }
        },map);
    }

    @Override
    public void startmap7(Map<String, String> map) {
        jingcaiView.showProgress();
        iJingCaiModel.loadJingcaipagerList7(new NetWorkCallBack<PandaJingcai>() {
            @Override
            public void onSuccess(PandaJingcai pandaJingcai) {
                jingcaiView.showJingCaiListData(pandaJingcai);
                jingcaiView.dimissProgress();
            }

            @Override
            public void onError(int errorCode, String errorMsg) {
                jingcaiView.showMessage(errorMsg);
                jingcaiView.dimissProgress();
            }

            @Override
            public void onFail(String netOff) {

            }
        },map);
    }

    @Override
    public void startmap8(Map<String, String> map) {
        jingcaiView.showProgress();
        iJingCaiModel.loadJingcaipagerList8(new NetWorkCallBack<PandaJingcai>() {
            @Override
            public void onSuccess(PandaJingcai pandaJingcai) {
                jingcaiView.showJingCaiListData(pandaJingcai);
                jingcaiView.dimissProgress();
            }

            @Override
            public void onError(int errorCode, String errorMsg) {
                jingcaiView.showMessage(errorMsg);
                jingcaiView.dimissProgress();
            }

            @Override
            public void onFail(String netOff) {

            }
        },map);
    }
}
