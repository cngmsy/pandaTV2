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
    public static final String PANDALIVE = BASEURL+"PAGE14501769230331752/index.json";
    //列表
    public static final String PAGELIST = BASEURL+"PAGE14501786751053212/index.json";
    //首页互动
    public static final String HOMEHUDONG = BASEURL+"PAGE14501767715521482/index.json";


    public static final String PAGEINFOLIST = "http://101.200.142.201/MyListLoadAuto/listload";
    //获取图片验证码
    public static final String IMGCODE = "http://reg.cntv.cn/simple/verificationCode.action";
    //邮箱注册
    public static final String EMAILREGISTER = "https://reg.cntv.cn/api/register.action";
    public static final String CHINADIMING = BASEURL+"PAGE14501775094142282/index.json";
}
