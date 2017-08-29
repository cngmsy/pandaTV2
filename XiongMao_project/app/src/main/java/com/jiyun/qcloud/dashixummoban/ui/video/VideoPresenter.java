package com.jiyun.qcloud.dashixummoban.ui.video;

import com.jiyun.qcloud.dashixummoban.entity.VideoEntity;
import com.jiyun.qcloud.dashixummoban.modle.dataModel.video.IVideoModel;
import com.jiyun.qcloud.dashixummoban.modle.dataModel.video.VideoModelImpl;
import com.jiyun.qcloud.dashixummoban.modle.net.callback.NetWorkCallBack;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by 王晓亮 on 2017/8/24.
 */

public class VideoPresenter implements VideoContract.presenter {
    private VideoContract.view view;
    private IVideoModel model;

    public VideoPresenter(VideoContract.view view) {
        this.view = view;
        view.setPresenter(this);
        model = new VideoModelImpl();
    }

    @Override
    public void start() {
        model.loadHomeList(new NetWorkCallBack<VideoEntity>() {
            @Override
            public void onSuccess(VideoEntity videoEntity) {
                List<VideoEntity.ListBean> list = new ArrayList<VideoEntity.ListBean>();

                for (int i = 0; i < videoEntity.getList().size(); i++) {
                    list.add(videoEntity.getList().get(i));
                }
                view.showVideoList(list);
                view.showVideoListPivture(videoEntity.getBigImg());
            }

            @Override
            public void onError(int errorCode, String errorMsg) {

            }

            @Override
            public void onFail(String netOff) {

            }
        });
    }

    @Override
    public void second(String url) {

    }

    @Override
    public void threed(Map<String, String> map) {

    }

    @Override
    public void four(Map<String, String> map) {

    }

}
