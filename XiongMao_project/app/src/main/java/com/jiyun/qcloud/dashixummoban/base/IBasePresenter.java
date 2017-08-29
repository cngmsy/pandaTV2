package com.jiyun.qcloud.dashixummoban.base;

import java.util.Map;

/**
 * Created by xingge on 2017/7/11.
 */

public interface IBasePresenter {
    void start();

    void second(String url);

    void threed(Map<String, String> map);

    void four(Map<String, String> map);
}
