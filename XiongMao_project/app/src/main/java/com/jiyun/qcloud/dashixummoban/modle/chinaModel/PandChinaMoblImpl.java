package com.jiyun.qcloud.dashixummoban.modle.chinaModel;

import com.jiyun.qcloud.dashixummoban.config.Urls;
import com.jiyun.qcloud.dashixummoban.entity.china.ChinaDiming;
import com.jiyun.qcloud.dashixummoban.entity.china.ChinaXiangqing;
import com.jiyun.qcloud.dashixummoban.modle.net.callback.NetWorkCallBack;

/**
 * Created by KING on 2017/8/24 08:15
 * 邮箱:992767879@qq.com
 */

public class PandChinaMoblImpl implements IpandaChinaModel {
    @Override
    public void loadChinaList(NetWorkCallBack<ChinaDiming> callBack) {
        iHttp.get(Urls.CHINADIMING,null,callBack);
    }

    @Override
    public void getFragmentData(String url, NetWorkCallBack<ChinaXiangqing> callBack) {
        iHttp.get(url,null,callBack);

    }
}
