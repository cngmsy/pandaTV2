package com.jiyun.qcloud.dashixummoban.modle.livepagerModel;

import com.jiyun.qcloud.dashixummoban.entity.PandaLivepager;
import com.jiyun.qcloud.dashixummoban.modle.dataModel.BaseModel;
import com.jiyun.qcloud.dashixummoban.modle.net.callback.NetWorkCallBack;

/**
 * Created by ASUS on 2017/8/24.
 */

public interface IPandaLivepagerModel extends BaseModel{
    void loadLivepagerList(NetWorkCallBack<PandaLivepager> callBack);
}
