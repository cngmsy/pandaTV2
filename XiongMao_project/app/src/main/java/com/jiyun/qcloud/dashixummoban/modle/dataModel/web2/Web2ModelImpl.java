package com.jiyun.qcloud.dashixummoban.modle.dataModel.web2;

import com.jiyun.qcloud.dashixummoban.config.Urls;
import com.jiyun.qcloud.dashixummoban.entity.Web2Entity1;
import com.jiyun.qcloud.dashixummoban.entity.Web2Entity2;
import com.jiyun.qcloud.dashixummoban.entity.Web2Entity3;
import com.jiyun.qcloud.dashixummoban.modle.net.callback.NetWorkCallBack;

import java.util.Map;

/**
 * Created by 王晓亮 on 2017/8/24.
 */

public class Web2ModelImpl implements IWeb2Model {

    @Override
    public void loadWeb2list2(NetWorkCallBack<Web2Entity2> callBack, String url) {
        iHttp.get(Urls.PINJIE3 + url, null, callBack);
    }

    @Override
    public void loadWeb2list1(NetWorkCallBack<Web2Entity1> callBack, Map<String, String> map) {
        iHttp.get(Urls.PINJIE, map, callBack);
    }

    public void loadWeb2list3(NetWorkCallBack<Web2Entity3> callBack, Map<String, String> map) {
        iHttp.get(Urls.BOBAOXIANGQING, map, callBack);
    }
}
