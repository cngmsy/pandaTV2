package com.jiyun.qcloud.dashixummoban.ui.china;

import com.jiyun.qcloud.dashixummoban.base.china.IBaseChinaPresenter;
import com.jiyun.qcloud.dashixummoban.base.china.IBaseChinaView;
import com.jiyun.qcloud.dashixummoban.entity.PandaHome;
import com.jiyun.qcloud.dashixummoban.entity.china.ChinaDiming;


/**
 * Created by KING on 2017/8/24 08:25
 * 邮箱:992767879@qq.com
 */

public class ChinaContract {
    interface View extends IBaseChinaView<Presenter1>{
        void showHomeListData(ChinaDiming chinaDiming);
    }
    interface Presenter1 extends IBaseChinaPresenter{

    }
}
