package com.jiyun.qcloud.dashixummoban.ui.web2;

import com.jiyun.qcloud.dashixummoban.entity.Web2Entity3;
import com.jiyun.qcloud.dashixummoban.modle.dataModel.web2.Web2ModelImpl;
import com.jiyun.qcloud.dashixummoban.modle.net.callback.NetWorkCallBack;
import com.jiyun.qcloud.dashixummoban.entity.Web2Entity1;
import com.jiyun.qcloud.dashixummoban.entity.Web2Entity2;

import java.util.Map;

/**
 * Created by 王晓亮 on 2017/8/24.
 */

public class Web2Presenter implements Web2Contract.presenter {
    private Web2Contract.view view;
    private Web2ModelImpl model;

    public Web2Presenter(Web2Contract.view view) {
        this.view = view;
        view.setPresenter(this);
        model = new Web2ModelImpl();
    }

    @Override
    public void start() {

    }

    @Override
    public void second(String url) {
        model.loadWeb2list2(new NetWorkCallBack<Web2Entity2>() {
            @Override
            public void onSuccess(Web2Entity2 web2Entity2) {
                view.showWeb2list2(web2Entity2);
            }

            @Override
            public void onError(int errorCode, String errorMsg) {

            }

            @Override
            public void onFail(String netOff) {

            }
        }, url);
    }

    @Override
    public void threed(Map<String, String> map) {
        model.loadWeb2list1(new NetWorkCallBack<Web2Entity1>() {
            @Override
            public void onSuccess(Web2Entity1 web2Entity1) {
                view.showWeb2list1(web2Entity1);
            }

            @Override
            public void onError(int errorCode, String errorMsg) {

            }

            @Override
            public void onFail(String netOff) {

            }
        }, map);
    }

    @Override
    public void four(Map<String, String> map) {
        model.loadWeb2list3(new NetWorkCallBack<Web2Entity3>() {
            @Override
            public void onSuccess(Web2Entity3 web2Entity3) {
                view.showWeb2list3(web2Entity3);
            }

            @Override
            public void onError(int errorCode, String errorMsg) {

            }

            @Override
            public void onFail(String netOff) {

            }
        }, map);
    }


}
