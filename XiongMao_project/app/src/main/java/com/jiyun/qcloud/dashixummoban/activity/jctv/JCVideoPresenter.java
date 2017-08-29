package com.jiyun.qcloud.dashixummoban.activity.jctv;

import com.jiyun.qcloud.dashixummoban.entity.ShoyeHudongBean;
import com.jiyun.qcloud.dashixummoban.entity.shoye.GunGunBean;
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
    public void second(String url) {

    }

    @Override
    public void threed(Map<String, String> map) {

    }

    @Override
    public void four(Map<String, String> map) {

    }
}
