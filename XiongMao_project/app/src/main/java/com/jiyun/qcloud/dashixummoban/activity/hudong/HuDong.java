package com.jiyun.qcloud.dashixummoban.activity.hudong;

import com.jiyun.qcloud.dashixummoban.base.IBasePresenter;
import com.jiyun.qcloud.dashixummoban.base.IBaseView;
import com.jiyun.qcloud.dashixummoban.entity.ShoyeHudongBean;

/**
 * Created by Administrator on 2017/8/23.
 */
//互动也面的协议
public class HuDong {
    interface View extends IBaseView<Presenter>{
        void showHudongList(ShoyeHudongBean shoyeHudongBean);
        void playVideo();
        void loadWebView();
    }
    interface Presenter extends IBasePresenter{}
}
