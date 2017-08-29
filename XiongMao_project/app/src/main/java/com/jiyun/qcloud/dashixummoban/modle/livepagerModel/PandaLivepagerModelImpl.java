package com.jiyun.qcloud.dashixummoban.modle.livepagerModel;

import com.jiyun.qcloud.dashixummoban.config.Urls;
import com.jiyun.qcloud.dashixummoban.entity.PandaLivepager;
import com.jiyun.qcloud.dashixummoban.modle.net.callback.NetWorkCallBack;

/**
 * Created by ASUS on 2017/8/24.
 */

public class PandaLivepagerModelImpl implements IPandaLivepagerModel{
    @Override
    public void loadLivepagerList(NetWorkCallBack<PandaLivepager> callBack) {
        iHttp.get(Urls.PANDALIVETAB,null,callBack);
    }
}
