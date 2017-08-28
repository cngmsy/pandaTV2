package com.jiyun.qcloud.dashixummoban.ui.home;

import com.jiyun.qcloud.dashixummoban.base.IBasePresenter;
import com.jiyun.qcloud.dashixummoban.base.IBaseView;
import com.jiyun.qcloud.dashixummoban.entity.PandaHome;
import com.jiyun.qcloud.dashixummoban.entity.shoye.GunGunBean;
import com.jiyun.qcloud.dashixummoban.entity.shoye.JingCaiYiKe;

/**
 * Created by chj on 2017/8/21.
 * 这是难点
 */

public class HomeContract {

    interface View extends IBaseView<Presenter> {
        void showHomeListData(PandaHome pandaHome, JingCaiYiKe jingCaiYiKe, GunGunBean gunGunBean);
        void playVideo();
        void loadWebView();
    }

    interface Presenter extends IBasePresenter {}
}
