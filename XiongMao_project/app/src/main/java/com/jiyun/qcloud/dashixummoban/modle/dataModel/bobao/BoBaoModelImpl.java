package com.jiyun.qcloud.dashixummoban.modle.dataModel.bobao;

import com.jiyun.qcloud.dashixummoban.config.Urls;
import com.jiyun.qcloud.dashixummoban.entity.BoBaoEntity1;
import com.jiyun.qcloud.dashixummoban.entity.BoBaoEntity2;
import com.jiyun.qcloud.dashixummoban.modle.net.callback.NetWorkCallBack;

/**
 * Created by 王晓亮 on 2017/8/24.
 */

public class BoBaoModelImpl implements IBobaoModel {
    @Override
    public void loadBoBaolist(NetWorkCallBack<BoBaoEntity1> callback) {
        iHttp.get(Urls.PANDABOBAO, null, callback);
    }

    @Override
    public void loadBoBaolist2(NetWorkCallBack<BoBaoEntity2> callback, String url) {
        iHttp.get(Urls.PANDABOBAO2+url, null, callback);
    }
}
