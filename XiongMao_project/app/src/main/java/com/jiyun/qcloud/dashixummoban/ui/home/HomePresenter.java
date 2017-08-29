package com.jiyun.qcloud.dashixummoban.ui.home;


<<<<<<< HEAD
import java.util.Map;
=======
import com.jiyun.qcloud.dashixummoban.entity.PandaHome;
import com.jiyun.qcloud.dashixummoban.entity.shoye.GunGunBean;
import com.jiyun.qcloud.dashixummoban.entity.shoye.JingCaiYiKe;
import com.jiyun.qcloud.dashixummoban.modle.dataModel.IPandaHomeModel;
import com.jiyun.qcloud.dashixummoban.modle.dataModel.PandaHomeModelImpl;
import com.jiyun.qcloud.dashixummoban.modle.net.callback.NetWorkCallBack;
>>>>>>> 877f4f683c6590ac372351468317b5a7776d726f


import java.util.Map;
import fm.jiecao.jcvideoplayer_lib.JCVideoPlayer;

/**
 * Created by xingge on 2017/7/26.
 */

public class HomePresenter implements HomeContract.Presenter {

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
<<<<<<< HEAD

    }

    @Override
    public void startshijiao() {

=======
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
>>>>>>> 877f4f683c6590ac372351468317b5a7776d726f
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
