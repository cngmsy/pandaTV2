package com.jiyun.qcloud.dashixummoban.ui.china;

import com.jiyun.qcloud.dashixummoban.base.china.IBaseChinaPresenter;
import com.jiyun.qcloud.dashixummoban.entity.china.ChinaDiming;
import com.jiyun.qcloud.dashixummoban.modle.chinaModel.IpandaChinaModel;
import com.jiyun.qcloud.dashixummoban.modle.chinaModel.PandChinaMoblImpl;
import com.jiyun.qcloud.dashixummoban.modle.net.callback.NetWorkCallBack;

/**
 * Created by KING on 2017/8/24 08:25
 * 邮箱:992767879@qq.com
 */

public class ChinaPresenter implements ChinaContract.Presenter1 {
    private ChinaContract.View chinaview;
    private IpandaChinaModel chinaModel;

    public ChinaPresenter(ChinaContract.View chinaview) {
        this.chinaview = chinaview;
        chinaview.setPresenter(this);
        this.chinaModel=new PandChinaMoblImpl();
    }

    @Override
    public void stare(){
        chinaModel.loadChinaList(new NetWorkCallBack<ChinaDiming>() {
            @Override
            public void onSuccess(ChinaDiming chinaDiming) {
                chinaview.showHomeListData(chinaDiming);
            }

            @Override
            public void onError(int errorCode, String errorMsg) {

            }

            @Override
            public void onFail(String netOff) {

            }
        });
    }

}
