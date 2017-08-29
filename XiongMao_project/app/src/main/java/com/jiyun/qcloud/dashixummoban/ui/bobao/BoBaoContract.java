package com.jiyun.qcloud.dashixummoban.ui.bobao;

import com.jiyun.qcloud.dashixummoban.base.IBasePresenter;
import com.jiyun.qcloud.dashixummoban.base.IBaseView;
import com.jiyun.qcloud.dashixummoban.entity.BoBaoEntity1;
import com.jiyun.qcloud.dashixummoban.entity.BoBaoEntity2;

import java.util.List;

/**
 * Created by 王晓亮 on 2017/8/24.
 */

public class BoBaoContract {
    interface view extends IBaseView<presenter> {
        void showBoBaolist(BoBaoEntity1 boBaoEntity1);

        void showBoBaolist2(List<BoBaoEntity2.ListBean> list);
    }

    interface presenter extends IBasePresenter {
    }

    ;
}
