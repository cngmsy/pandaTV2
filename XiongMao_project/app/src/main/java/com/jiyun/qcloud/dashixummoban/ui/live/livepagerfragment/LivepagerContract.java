package com.jiyun.qcloud.dashixummoban.ui.live.livepagerfragment;

import com.jiyun.qcloud.dashixummoban.base.IBasePresenter;
import com.jiyun.qcloud.dashixummoban.base.IBaseView;
import com.jiyun.qcloud.dashixummoban.entity.PandaLivepager;

/**
 * Created by ASUS on 2017/8/24.
 */

public class LivepagerContract {

    public interface view extends IBaseView<Presenter>{
        void showLivepagerListData(PandaLivepager pandaLivepager);
        void playVideo();
        void loadWebView();
    }
    public interface Presenter extends IBasePresenter{

    }
}
