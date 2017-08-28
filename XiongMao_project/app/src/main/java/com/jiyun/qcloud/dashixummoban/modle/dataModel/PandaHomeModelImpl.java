package com.jiyun.qcloud.dashixummoban.modle.dataModel;


import com.jiyun.qcloud.dashixummoban.config.Urls;
import com.jiyun.qcloud.dashixummoban.entity.PandaHome;
import com.jiyun.qcloud.dashixummoban.entity.ShoyeHudongBean;
import com.jiyun.qcloud.dashixummoban.entity.shoye.GunGunBean;
import com.jiyun.qcloud.dashixummoban.entity.shoye.HomeJCBean;
import com.jiyun.qcloud.dashixummoban.entity.shoye.JingCaiYiKe;
import com.jiyun.qcloud.dashixummoban.modle.net.callback.NetWorkCallBack;
import com.orhanobut.logger.Logger;

import static com.jiyun.qcloud.dashixummoban.config.Urls.PANDAHOME_GUNGUNSHIPING;
import static com.jiyun.qcloud.dashixummoban.config.Urls.PANDAHOME_JINGCAI;

/**
 * Created by xingge on 2017/7/26.
 */

public class PandaHomeModelImpl implements IPandaHomeModel {


//首页的数据
    @Override
    public void loadHomeList(NetWorkCallBack<PandaHome> callback) {
        iHttp.get(Urls.PANDAHOME,null,callback);
    }

//首页互动数据
    @Override
    public void loadHuDongList(NetWorkCallBack<ShoyeHudongBean> callback) {
        iHttp.get(Urls.HOMEHUDONG,null,callback);
    }

    //首页数据的精彩一刻二级数据
    @Override
    public void loadHuDongList_JingCaiYiKe(NetWorkCallBack<JingCaiYiKe> callback) {
        iHttp.get(PANDAHOME_JINGCAI,null,callback);
    }
    //首页数据的滚滚视频二级数据
    @Override
    public void loadHuDongList_GunGunShiPing(NetWorkCallBack<GunGunBean> callback) {
        iHttp.get(PANDAHOME_GUNGUNSHIPING ,null,callback);
    }

    @Override
    public void HomeJCVideo(String url, NetWorkCallBack<HomeJCBean> callback) {
        iHttp.get(url ,null,callback);
    }

}
