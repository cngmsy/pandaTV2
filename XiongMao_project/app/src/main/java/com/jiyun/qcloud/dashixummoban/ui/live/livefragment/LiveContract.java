package com.jiyun.qcloud.dashixummoban.ui.live.livefragment;

import com.jiyun.qcloud.dashixummoban.base.IBasePresenter;
import com.jiyun.qcloud.dashixummoban.base.IBaseView;
import com.jiyun.qcloud.dashixummoban.entity.PandaLive;
import com.jiyun.qcloud.dashixummoban.entity.PandaLiveVideo;

/**
 * Created by ASUS on 2017/8/23.
 */

public class LiveContract {

    public interface View extends IBaseView<Presenter>{
        void showLiveListData(PandaLive pandaLive);
        void showLiveListDataSecond(PandaLiveVideo pandaLiveVideo);
        void playVideo();
        void loadWebView();
    }
    public interface Presenter extends IBasePresenter{
        void second(String url);
    }
}
