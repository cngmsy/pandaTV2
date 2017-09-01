package com.jiyun.qcloud.dashixummoban.modle.liveModel;

import com.jiyun.qcloud.dashixummoban.config.Urls;
import com.jiyun.qcloud.dashixummoban.entity.PandaLive;
import com.jiyun.qcloud.dashixummoban.entity.PandaLiveVideo;
import com.jiyun.qcloud.dashixummoban.modle.net.callback.NetWorkCallBack;

/**
 * Created by ASUS on 2017/8/24.
 */

public class PandaLiveModelImpl implements IPandaLiveModel{
    @Override
    public void loadLiveList(NetWorkCallBack<PandaLive> callBack) {
        iHttp.get(Urls.PANDALIVE,null,callBack);
    }

    @Override
    public void loadLiveListSecond(NetWorkCallBack<PandaLiveVideo> callBack, String url) {
        iHttp.get(Urls.ZHIBO+url,null,callBack);
    }
}
