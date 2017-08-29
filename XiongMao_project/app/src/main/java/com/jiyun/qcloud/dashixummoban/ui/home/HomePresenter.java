package com.jiyun.qcloud.dashixummoban.ui.home;


import com.jiyun.qcloud.dashixummoban.entity.PandaHome;
import com.jiyun.qcloud.dashixummoban.modle.dataModel.IPandaHomeModel;
import com.jiyun.qcloud.dashixummoban.modle.dataModel.PandaHomeModelImpl;
import com.jiyun.qcloud.dashixummoban.modle.net.callback.NetWorkCallBack;

import java.util.Map;

/**
 * Created by xingge on 2017/7/26.
 */

public class HomePresenter implements HomeContract.Presenter {

    private HomeContract.View homeView;
    private IPandaHomeModel homeModel;
    /*
       在构造方法里面做了什么事情;   初始化了HomeView  这时候的homeView相当于HomePageFragent
       同时在这个构造方法中有初始化了homeModel   HomeModel里面就是网络请求后从服务器返回的bean结果
     */
    public HomePresenter(HomeContract.View homeView){
        this.homeView = homeView;
        homeView.setPresenter(this);
        this.homeModel = new PandaHomeModelImpl();
    }

    @Override
    public void start() {
        homeView.showProgress();
        homeModel.loadHomeList(new NetWorkCallBack<PandaHome>() {
            @Override
            public void onSuccess(PandaHome pandaHome) {
                homeView.showHomeListData(pandaHome);
                homeView.dimissProgress();
            }

            @Override
            public void onError(int errorCode, String errorMsg) {
                homeView.showMessage(errorMsg);
                homeView.dimissProgress();
            }

            @Override
            public void onFail(String netOff) {

            }
        });
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
