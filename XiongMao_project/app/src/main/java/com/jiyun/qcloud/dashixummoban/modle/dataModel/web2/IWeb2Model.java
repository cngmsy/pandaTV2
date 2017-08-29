package com.jiyun.qcloud.dashixummoban.modle.dataModel.web2;

import com.jiyun.qcloud.dashixummoban.entity.Web2Entity1;
import com.jiyun.qcloud.dashixummoban.entity.Web2Entity2;
import com.jiyun.qcloud.dashixummoban.entity.Web2Entity3;
import com.jiyun.qcloud.dashixummoban.modle.dataModel.BaseModel;
import com.jiyun.qcloud.dashixummoban.modle.net.callback.NetWorkCallBack;

import java.util.Map;

/**
 * Created by 王晓亮 on 2017/8/24.
 */

public interface IWeb2Model extends BaseModel {
    //  void loadWeb2
    void loadWeb2list1(NetWorkCallBack<Web2Entity1> callBack, Map<String, String> map);

    void loadWeb2list2(NetWorkCallBack<Web2Entity2> callBack, String url);

    void loadWeb2list3(NetWorkCallBack<Web2Entity3> callBack, Map<String, String> map);
}
