package com.jiyun.qcloud.dashixummoban.modle.jingcaiModel;

import com.jiyun.qcloud.dashixummoban.config.Urls;
import com.jiyun.qcloud.dashixummoban.entity.PandaJingcai;
import com.jiyun.qcloud.dashixummoban.entity.Pandalivedetails;
import com.jiyun.qcloud.dashixummoban.entity.PandanShiJiao;
import com.jiyun.qcloud.dashixummoban.modle.net.callback.NetWorkCallBack;

import java.util.Map;

import static com.jiyun.qcloud.dashixummoban.modle.dataModel.BaseModel.iHttp;

/**
 * Created by ASUS on 2017/8/24.
 */

public class PandaJingcaiModelImpl implements IJingCaiModel{

    @Override
    public void loadJingcaipagerList1(NetWorkCallBack<PandaJingcai> callBack, Map<String, String> map) {
        iHttp.get(Urls.JINGCAI,map,callBack);
    }

    @Override
    public void loadJingcaipagerList2(NetWorkCallBack<PandaJingcai> callBack, Map<String, String> map) {
        iHttp.get(Urls.DANGXIONG,null,callBack);
    }

    @Override
    public void loadJingcaipagerList3(NetWorkCallBack<PandaJingcai> callBack, Map<String, String> map) {
        iHttp.get(Urls.CHAOMENG,null,callBack);
    }

    @Override
    public void loadJingcaipagerList4(NetWorkCallBack<PandaJingcai> callBack, Map<String, String> map) {
        iHttp.get(Urls.DANGAN,null,callBack);
    }

    @Override
    public void loadJingcaipagerList5(NetWorkCallBack<PandaJingcai> callBack, Map<String, String> map) {
        iHttp.get(Urls.TOP,null,callBack);
    }

    @Override
    public void loadJingcaipagerList6(NetWorkCallBack<PandaJingcai> callBack, Map<String, String> map) {
        iHttp.get(Urls.NAXIE,null,callBack);
    }

    @Override
    public void loadJingcaipagerList7(NetWorkCallBack<PandaJingcai> callBack, Map<String, String> map) {
        iHttp.get(Urls.TEBIE,null,callBack);
    }

    @Override
    public void loadJingcaipagerList8(NetWorkCallBack<PandaJingcai> callBack, Map<String, String> map) {
        iHttp.get(Urls.YUANCHUANG,null,callBack);
    }

    @Override
    public void loadJingcaipagerListSecond(NetWorkCallBack<Pandalivedetails> callBack, String url) {
        iHttp.get(Urls.VIDEOPLAY+url,null,callBack);
    }

    @Override
    public void loadShiJiaoList(NetWorkCallBack<PandanShiJiao> callBack) {
        iHttp.get(Urls.PANDALIVEMULTI,null,callBack);
    }
}
