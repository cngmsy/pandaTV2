package com.jiyun.qcloud.dashixummoban.modle.dataModel.video;

import com.jiyun.qcloud.dashixummoban.entity.PandaHome;
import com.jiyun.qcloud.dashixummoban.entity.VideoEntity;
import com.jiyun.qcloud.dashixummoban.modle.dataModel.BaseModel;
import com.jiyun.qcloud.dashixummoban.modle.net.callback.NetWorkCallBack;

/**
 * Created by 王晓亮 on 2017/8/23.
 */

public interface IVideoModel extends BaseModel{
    void loadHomeList(NetWorkCallBack<VideoEntity> callback);
}
