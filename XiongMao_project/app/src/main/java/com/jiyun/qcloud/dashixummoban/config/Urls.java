package com.jiyun.qcloud.dashixummoban.config;

/**
 * Created by xingge on 2017/7/11.
 * 相关参数
 */

public class Urls {

    //服务器地址
    private static final String BASEURL = "http://www.ipanda.com/kehuduan/";

    //首页

    public static final String PANDAHOME = BASEURL+"shouye/index.json";
    //获取精彩一刻的二级数据
    public static final String PANDAHOME_JINGCAI = BASEURL+"shipinliebieye/jingcaiyike/index.json";
    //首页数据的滚滚视频二级数据
    public static final String PANDAHOME_GUNGUNSHIPING = BASEURL+"shipinliebieye/video/index.json";

    //熊猫直播
    public static final String PANDALIVE = BASEURL + "PAGE14501769230331752/index.json";
    //列表

    public static final String PAGELIST = BASEURL+"PAGE14501786751053212/index.json";
    //首页互动
    public static final String HOMEHUDONG = BASEURL+"PAGE14501767715521482/index.json";


    public static final String PAGEINFOLIST = "http://101.200.142.201/MyListLoadAuto/listload";
    //获取图片验证码
    public static final String IMGCODE = "http://reg.cntv.cn/simple/verificationCode.action";
    //邮箱注册
    public static final String EMAILREGISTER = "https://reg.cntv.cn/api/register.action";
    //滚滚视频
    public static final String GUNGUNVIDEO = "http://www.ipanda.com/kehuduan/video/index.json";
    //熊猫播报
    public static final String PANDABOBAO = "http://www.ipanda.com/kehuduan/news/index.json";
    public static final String PANDABOBAO2="http://api.cntv.cn/apicommon/index?path=iphoneInterface/general/getArticleAndVideoListInfo.json&primary_id=PAGE1422435191506336&serviceId=panda&pageSize=8&page=";
    //拼接
    public static final String PINJIE = "http://api.cntv.cn/video/videolistById";
    //视频拼接
    public static final String PINJIE3 = "http://115.182.9.189/api/getVideoInfoForCBox.do?pid=";

    //播报跳转
    public static final String BOBAOXIANGQING="http://api.cntv.cn/article/contentinfo";
    public static final String CHINADIMING = BASEURL+"PAGE14501775094142282/index.json";
}
