package com.jiyun.qcloud.dashixummoban.modle.dataModel.video;

import com.jiyun.qcloud.dashixummoban.config.Urls;
import com.jiyun.qcloud.dashixummoban.entity.VideoEntity;
import com.jiyun.qcloud.dashixummoban.modle.net.callback.NetWorkCallBack;

import butterknife.internal.Utils;

/**
 * Created by 王晓亮 on 2017/8/23.
 */

public class VideoModelImpl implements IVideoModel {
    @Override
    public void loadHomeList(NetWorkCallBack<VideoEntity> callback) {
        iHttp.get(Urls.GUNGUNVIDEO, null, callback);
    }
}
