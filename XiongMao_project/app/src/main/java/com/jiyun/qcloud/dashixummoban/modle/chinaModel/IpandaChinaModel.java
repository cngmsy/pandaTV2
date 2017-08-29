package com.jiyun.qcloud.dashixummoban.modle.chinaModel;

import com.jiyun.qcloud.dashixummoban.entity.china.ChinaDiming;
import com.jiyun.qcloud.dashixummoban.entity.china.ChinaXiangqing;
import com.jiyun.qcloud.dashixummoban.modle.dataModel.BaseModel;
import com.jiyun.qcloud.dashixummoban.modle.net.callback.NetWorkCallBack;

/**
 * Created by KING on 2017/8/24 08:15
 * 邮箱:992767879@qq.com
 */

public interface IpandaChinaModel extends BaseModel {
    void loadChinaList(NetWorkCallBack<ChinaDiming> callBack);
    void getFragmentData(String url, NetWorkCallBack<ChinaXiangqing> callBack);
}
