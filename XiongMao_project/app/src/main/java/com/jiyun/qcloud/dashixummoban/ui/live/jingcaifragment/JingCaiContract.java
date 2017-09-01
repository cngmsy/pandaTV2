package com.jiyun.qcloud.dashixummoban.ui.live.jingcaifragment;

import com.jiyun.qcloud.dashixummoban.base.IBasePresenter;
import com.jiyun.qcloud.dashixummoban.base.IBaseView;
import com.jiyun.qcloud.dashixummoban.entity.PandaJingcai;
import com.jiyun.qcloud.dashixummoban.entity.Pandalivedetails;
import com.jiyun.qcloud.dashixummoban.entity.PandanShiJiao;

/**
 * Created by ASUS on 2017/8/24.
 */

public class JingCaiContract {

    public interface View extends IBaseView<Presenter>{
        void showJingCaiListData(PandaJingcai pandaJingcai);
        void showShiJiaoListData(PandanShiJiao pandanShiJiao);
        void showJingCaiListDataSecond(Pandalivedetails pandalivedetails);
        void playVideo();
        void loadWebView();
    }
    public interface Presenter extends IBasePresenter{
        void second(String url);
    }
}
