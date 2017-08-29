package com.jiyun.qcloud.dashixummoban.ui.web2;

import com.jiyun.qcloud.dashixummoban.base.IBasePresenter;
import com.jiyun.qcloud.dashixummoban.base.IBaseView;
import com.jiyun.qcloud.dashixummoban.entity.Web2Entity1;
import com.jiyun.qcloud.dashixummoban.entity.Web2Entity2;
import com.jiyun.qcloud.dashixummoban.entity.Web2Entity3;

import java.util.List;

/**
 * Created by 王晓亮 on 2017/8/24.
 */

public class Web2Contract {
    public interface view extends IBaseView<presenter> {
        void showWeb2list1(Web2Entity1 list1);

        void showWeb2list2(Web2Entity2 list2);
        void showWeb2list3(Web2Entity3 list3);
    }

    public interface presenter extends IBasePresenter {
    }
}
