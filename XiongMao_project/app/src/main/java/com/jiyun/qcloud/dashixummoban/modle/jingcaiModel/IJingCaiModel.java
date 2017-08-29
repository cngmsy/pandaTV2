package com.jiyun.qcloud.dashixummoban.modle.jingcaiModel;

import com.jiyun.qcloud.dashixummoban.entity.PandaJingcai;
import com.jiyun.qcloud.dashixummoban.entity.Pandalivedetails;
import com.jiyun.qcloud.dashixummoban.entity.PandanShiJiao;
import com.jiyun.qcloud.dashixummoban.modle.net.callback.NetWorkCallBack;

import java.util.Map;

/**
 * Created by ASUS on 2017/8/24.
 */

public interface IJingCaiModel {
    void loadJingcaipagerList1(NetWorkCallBack<PandaJingcai> callBack, Map<String,String> map);
    void loadJingcaipagerList2(NetWorkCallBack<PandaJingcai> callBack, Map<String,String> map);
    void loadJingcaipagerList3(NetWorkCallBack<PandaJingcai> callBack, Map<String,String> map);
    void loadJingcaipagerList4(NetWorkCallBack<PandaJingcai> callBack, Map<String,String> map);
    void loadJingcaipagerList5(NetWorkCallBack<PandaJingcai> callBack, Map<String,String> map);
    void loadJingcaipagerList6(NetWorkCallBack<PandaJingcai> callBack, Map<String,String> map);
    void loadJingcaipagerList7(NetWorkCallBack<PandaJingcai> callBack, Map<String,String> map);
    void loadJingcaipagerList8(NetWorkCallBack<PandaJingcai> callBack, Map<String,String> map);

    void loadJingcaipagerListSecond(NetWorkCallBack<Pandalivedetails> callBack,String url);
    void loadShiJiaoList(NetWorkCallBack<PandanShiJiao> callBack);

}
