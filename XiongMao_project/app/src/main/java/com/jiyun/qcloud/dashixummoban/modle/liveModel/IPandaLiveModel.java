package com.jiyun.qcloud.dashixummoban.modle.liveModel;


import com.jiyun.qcloud.dashixummoban.entity.PandaLive;
import com.jiyun.qcloud.dashixummoban.entity.PandaLiveVideo;
import com.jiyun.qcloud.dashixummoban.modle.dataModel.BaseModel;
import com.jiyun.qcloud.dashixummoban.modle.net.callback.NetWorkCallBack;

/**
 * Created by ASUS on 2017/8/23.
 */

public interface IPandaLiveModel extends BaseModel {
    void loadLiveList(NetWorkCallBack<PandaLive> callBack);
    void loadLiveListSecond(NetWorkCallBack<PandaLiveVideo> callBack,String url);
}
