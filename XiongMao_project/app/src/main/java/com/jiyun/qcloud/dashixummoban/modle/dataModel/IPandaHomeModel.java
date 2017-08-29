package com.jiyun.qcloud.dashixummoban.modle.dataModel;


import com.jiyun.qcloud.dashixummoban.entity.PandaHome;
import com.jiyun.qcloud.dashixummoban.entity.ShoyeHudongBean;
import com.jiyun.qcloud.dashixummoban.entity.shoye.GunGunBean;
import com.jiyun.qcloud.dashixummoban.entity.shoye.HomeJCBean;
import com.jiyun.qcloud.dashixummoban.entity.shoye.JingCaiYiKe;
import com.jiyun.qcloud.dashixummoban.modle.net.callback.NetWorkCallBack;

/**
 * Created by xingge on 2017/7/26.
 */

public interface IPandaHomeModel extends BaseModel {
<<<<<<< HEAD
=======
    //获取首页的数据
>>>>>>> 877f4f683c6590ac372351468317b5a7776d726f
    void loadHomeList(NetWorkCallBack<PandaHome> callback);
    //获取首页互动的数据
    void loadHuDongList(NetWorkCallBack<ShoyeHudongBean> callback);
    //获取精彩一刻的二级数据
    void loadHuDongList_JingCaiYiKe(NetWorkCallBack<JingCaiYiKe> callback);
    //获取滚滚数据的二级数据
    void loadHuDongList_GunGunShiPing(NetWorkCallBack<GunGunBean> callback);
    //首页头跳转到JC视频之后的解析
    void HomeJCVideo(String url,NetWorkCallBack<HomeJCBean> callback);
}
