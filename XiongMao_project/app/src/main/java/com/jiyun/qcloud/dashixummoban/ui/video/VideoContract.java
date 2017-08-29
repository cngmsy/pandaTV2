package com.jiyun.qcloud.dashixummoban.ui.video;

import com.jiyun.qcloud.dashixummoban.base.IBasePresenter;
import com.jiyun.qcloud.dashixummoban.base.IBaseView;
import com.jiyun.qcloud.dashixummoban.entity.VideoEntity;

import java.util.List;

/**
 * Created by 王晓亮 on 2017/8/24.
 */

public class VideoContract {
    interface view extends IBaseView<presenter> {
        void showVideoList(List<VideoEntity.ListBean> list);

        void showVideoListPivture(List<VideoEntity.BigImgBean> list);
    }

    interface presenter extends IBasePresenter {
    }

    ;
}
