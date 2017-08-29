package com.jiyun.qcloud.dashixummoban.modle.dataModel.bobao;

import com.jiyun.qcloud.dashixummoban.entity.BoBaoEntity1;
import com.jiyun.qcloud.dashixummoban.entity.BoBaoEntity2;
import com.jiyun.qcloud.dashixummoban.entity.VideoEntity;
import com.jiyun.qcloud.dashixummoban.modle.dataModel.BaseModel;
import com.jiyun.qcloud.dashixummoban.modle.net.callback.NetWorkCallBack;

/**
 * Created by 王晓亮 on 2017/8/24.
 */

public interface IBobaoModel extends BaseModel {
    void loadBoBaolist(NetWorkCallBack<BoBaoEntity1> callback);

    void loadBoBaolist2(NetWorkCallBack<BoBaoEntity2> callback,String url);
}
