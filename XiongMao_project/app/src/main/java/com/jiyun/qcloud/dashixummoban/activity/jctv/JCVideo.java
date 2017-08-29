package com.jiyun.qcloud.dashixummoban.activity.jctv;

import com.jiyun.qcloud.dashixummoban.base.IBasePresenter;
import com.jiyun.qcloud.dashixummoban.base.IBaseView;
import com.jiyun.qcloud.dashixummoban.entity.ShoyeHudongBean;
import com.jiyun.qcloud.dashixummoban.entity.shoye.HomeJCBean;

/**
 * Created by Administrator on 2017/8/25.
 */


public class JCVideo {
    interface View extends IBaseView<Presenter>{
        void showHudongList(HomeJCBean homeJCBean);
        void playVideo();
        void loadWebView();
    }
    interface Presenter extends IBasePresenter {}
}
