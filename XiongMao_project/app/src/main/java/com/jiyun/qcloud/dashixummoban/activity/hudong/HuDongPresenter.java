package com.jiyun.qcloud.dashixummoban.activity.hudong;

import com.google.gson.Gson;
import com.jiyun.qcloud.dashixummoban.base.IBasePresenter;
import com.jiyun.qcloud.dashixummoban.base.IBaseView;
import com.jiyun.qcloud.dashixummoban.entity.PandaHome;
import com.jiyun.qcloud.dashixummoban.entity.ShoyeHudongBean;
import com.jiyun.qcloud.dashixummoban.modle.dataModel.IPandaHomeModel;
import com.jiyun.qcloud.dashixummoban.modle.dataModel.PandaHomeModelImpl;
import com.jiyun.qcloud.dashixummoban.modle.net.callback.NetWorkCallBack;

import java.util.List;

/**
 * Created by Administrator on 2017/8/23.
 */
//互动页面的P层
public class HuDongPresenter  implements HuDong.Presenter{
    //持有view层对象
    HuDong.View view;
    //持有model层对象
    IPandaHomeModel model;

    public HuDongPresenter(HuDong.View view) {
        this.view = view;
        view.setPresenter(this);
        this.model=new PandaHomeModelImpl();
    }

    @Override
    public void start() {
        view.showProgress();
        model.loadHuDongList(new NetWorkCallBack<ShoyeHudongBean>() {
            @Override
            public void onSuccess(ShoyeHudongBean shoyeHudongBean) {
                view.showHudongList(shoyeHudongBean);
                view.dimissProgress();
            }

            @Override
            public void onError(int errorCode, String errorMsg) {
                view.showMessage(errorMsg);
                view.dimissProgress();
            }

            @Override
            public void onFail(String netOff) {

            }
        });
    }
}
