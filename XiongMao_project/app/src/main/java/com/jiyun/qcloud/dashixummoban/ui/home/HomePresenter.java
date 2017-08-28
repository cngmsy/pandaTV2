package com.jiyun.qcloud.dashixummoban.ui.home;


import com.jiyun.qcloud.dashixummoban.entity.PandaHome;
import com.jiyun.qcloud.dashixummoban.entity.shoye.GunGunBean;
import com.jiyun.qcloud.dashixummoban.entity.shoye.JingCaiYiKe;
import com.jiyun.qcloud.dashixummoban.modle.dataModel.IPandaHomeModel;
import com.jiyun.qcloud.dashixummoban.modle.dataModel.PandaHomeModelImpl;
import com.jiyun.qcloud.dashixummoban.modle.net.callback.NetWorkCallBack;

import fm.jiecao.jcvideoplayer_lib.JCVideoPlayer;

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
            public void onSuccess(final PandaHome pandaHome) {
                //请求成功后再次请求一下精彩一刻的数据
                homeModel.loadHuDongList_JingCaiYiKe(new NetWorkCallBack<JingCaiYiKe>() {
                    @Override
                    public void onSuccess(final JingCaiYiKe jingCaiYiKe) {
                      homeModel.loadHuDongList_GunGunShiPing(new NetWorkCallBack<GunGunBean>() {
                          @Override
                          public void onSuccess(GunGunBean gunGunBean) {
                              homeView.showHomeListData(pandaHome,jingCaiYiKe,gunGunBean);
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
                    public void onError(int errorCode, String errorMsg) {

                    }

                    @Override
                    public void onFail(String netOff) {

                    }
                });
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
}
