package com.jiyun.qcloud.dashixummoban.ui.china;

import com.jiyun.qcloud.dashixummoban.base.china.IBaseChinaPresenter;
import com.jiyun.qcloud.dashixummoban.base.china.IBaseChinaView;
import com.jiyun.qcloud.dashixummoban.entity.china.ChinaDiming;
import com.jiyun.qcloud.dashixummoban.entity.china.ChinaXiangqing;

/**
 * Created by KING on 2017/8/24 21:26
 * 邮箱:992767879@qq.com
 */

public class ChinasContract {
    interface View extends IBaseChinaView<ChinasContract.Presenter> {
        void showFragmentData(ChinaXiangqing chinaxiaqing);
    }
    interface Presenter extends IBaseChinaPresenter {
        String getUrl(String url);
    }
}
