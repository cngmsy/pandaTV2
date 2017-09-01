package com.jiyun.qcloud.dashixummoban.ui.china;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.gson.Gson;
import com.jcodecraeer.xrecyclerview.XRecyclerView;
import com.jiyun.qcloud.dashixummoban.R;
import com.jiyun.qcloud.dashixummoban.adapter.AdapterXrcychina;
import com.jiyun.qcloud.dashixummoban.base.BaseFragment;
import com.jiyun.qcloud.dashixummoban.entity.china.ChinaXiangqing;
import com.jiyun.qcloud.dashixummoban.entity.china.ChinaZhibo;
import com.jiyun.qcloud.dashixummoban.entity.china.JiekouChina;
import com.jiyun.qcloud.dashixummoban.modle.net.Okhttpdanli;

import java.util.ArrayList;
import java.util.List;


import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import fm.jiecao.jcvideoplayer_lib.JCVideoPlayer;

import static android.R.attr.path;
import static com.jiyun.qcloud.dashixummoban.R.id.videocontroller1;

/**
 * Created by KING on 2017/8/24 20:56
 * 邮箱:992767879@qq.com
 */

public class ChinaFragments extends BaseFragment implements ChinasContract.View,JiekouChina {
    @BindView(R.id.xrecychina)
    XRecyclerView xrecychina;
    Unbinder unbinder;
    private String url;
    private ChinasContract.Presenter presenter;
    private List<ChinaXiangqing.LiveBean> xiangqingList = new ArrayList<>();
    private AdapterXrcychina adapterXrcychina;
    private String flv1;
    @Override
    protected int getLayoutRes() {
        return R.layout.fragment_xiangqing;
    }

    public ChinaFragments(String url) {
        this.url = url;
    }

    @Override
    protected void initData() {
        presenter = new ChinasPresenter(this);
        if (presenter != null) {
            presenter.stare();
        }
        adapterXrcychina.notifyDataSetChanged();
    }

    @Override
    protected void initView(View view) {
        adapterXrcychina = new AdapterXrcychina(xiangqingList,getActivity(),this);
        LinearLayoutManager llm=new LinearLayoutManager(getActivity());
        xrecychina.setLayoutManager(llm);
        xrecychina.setAdapter(adapterXrcychina);
    }
    @Override
    public void setBundle(Bundle bundle) {

    }
    @Override
    public void showFragmentData(ChinaXiangqing chinaxiaqing) {
       List<ChinaXiangqing.LiveBean> live = chinaxiaqing.getLive();
        xiangqingList.addAll(live);
        adapterXrcychina.notifyDataSetChanged();
    }
    @Override
    public void setPresenter(ChinasContract.Presenter presenter) {
        this.presenter = presenter;
        presenter.getUrl(url);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // TODO: inflate a fragment view
        View rootView = super.onCreateView(inflater, container, savedInstanceState);
        unbinder = ButterKnife.bind(this, rootView);
        return rootView;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
    @Override
    public void shipinbofang(String a, final JCVideoPlayer ss) {

        final String u = "http://vdn.live.cntv.cn/api2/live.do?channel=pa://cctv_p2p_hd"+a+"&client=androidapp";
        Okhttpdanli.getIntence().getok(u, new Okhttpdanli.Calla() {
            @Override
            public void chenggong(String q) {
                Gson gson=new Gson();
                ChinaZhibo chinaZhibo = gson.fromJson(q, ChinaZhibo.class);
                if(chinaZhibo.getHls_url().getHls1()!=null){
                    flv1 = chinaZhibo.getHls_url().getHls1();
                }else if(chinaZhibo.getHls_url().getHls2()!=null){
                    flv1 = chinaZhibo.getHls_url().getHls2();
                }else if(chinaZhibo.getHls_url().getHls3()!=null){
                    flv1 = chinaZhibo.getHls_url().getHls3();
                }else if(chinaZhibo.getHls_url().getHls4()!=null){
                    flv1 = chinaZhibo.getHls_url().getHls4();
                }else if(chinaZhibo.getHls_url().getHls5()!=null){
                    flv1 = chinaZhibo.getHls_url().getHls5();
                }else if(chinaZhibo.getHls_url().getHls6()!=null){
                    flv1 = chinaZhibo.getHls_url().getHls6();
                }
                ss.setUp(flv1,"");

            }
            @Override
            public void shibai(String w) {

            }
        });

    }
}
