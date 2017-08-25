package com.jiyun.qcloud.dashixummoban.ui.china;

import com.jiyun.qcloud.dashixummoban.entity.china.ChinaXiangqing;
import com.jiyun.qcloud.dashixummoban.modle.chinaModel.IpandaChinaModel;
import com.jiyun.qcloud.dashixummoban.modle.chinaModel.PandChinaMoblImpl;
import com.jiyun.qcloud.dashixummoban.modle.net.callback.NetWorkCallBack;

import static android.R.attr.x;

/**
 * Created by KING on 2017/8/24 21:27
 * 邮箱:992767879@qq.com
 */

public class ChinasPresenter implements ChinasContract.Presenter{
   private String url;
    private ChinasContract.View chinaview;
    private IpandaChinaModel chinaModel;

    public ChinasPresenter(ChinasContract.View chinaview) {
        this.chinaview = chinaview;
        chinaview.setPresenter(this);
        this.chinaModel=new PandChinaMoblImpl();
    }
    @Override
    public String getUrl(String url) {
        this.url=url;
        return url;
    }

    @Override
    public void stare() {
        chinaModel.getFragmentData(url, new NetWorkCallBack<ChinaXiangqing>() {
            @Override
            public void onSuccess(ChinaXiangqing chinaXiangqing) {
                chinaview.showFragmentData(chinaXiangqing);
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
