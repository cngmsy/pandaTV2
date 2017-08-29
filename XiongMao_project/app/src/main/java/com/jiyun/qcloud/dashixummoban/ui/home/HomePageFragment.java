package com.jiyun.qcloud.dashixummoban.ui.home;

import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.jcodecraeer.xrecyclerview.XRecyclerView;
import com.jiyun.qcloud.dashixummoban.R;
import com.jiyun.qcloud.dashixummoban.activity.hudong.HuDongPresenter;
import com.jiyun.qcloud.dashixummoban.adapter.shoye.ShoyeXRecyclerAdapter;
import com.jiyun.qcloud.dashixummoban.base.BaseFragment;
import com.jiyun.qcloud.dashixummoban.entity.PandaHome;
import com.jiyun.qcloud.dashixummoban.entity.shoye.GunGunBean;
import com.jiyun.qcloud.dashixummoban.entity.shoye.JingCaiYiKe;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import fm.jiecao.jcvideoplayer_lib.JCVideoPlayer;

import static android.R.attr.data;
import static android.R.id.list;
import static java.util.Collections.addAll;

/**
 * Created by chj on 2017/8/20.
 */

//熊猫首页  recycler多布局  杜智宏
public class HomePageFragment extends BaseFragment implements HomeContract.Presenter,HomeContract.View{
    Handler handler=new Handler();
    @BindView(R.id.shouye_xrecycler)
    XRecyclerView shouyeXrecycler;
    Unbinder unbinder;
    HomeContract.Presenter presenter;
    private ShoyeXRecyclerAdapter shoyeXRecyclerAdapter;
    private FragmentActivity activity;
    List<Object>listdata=new ArrayList<>();

    @Override
    protected int getLayoutRes() {
        return R.layout.fragment_home;
    }

    @Override
    protected void initData() {
        presenter.start();
    }

    @Override
    protected void initView(View view) {
         activity = getActivity();
        shouyeXrecycler.setRefreshProgressStyle(5);//刷新样式
        //设置刷新时间
        shouyeXrecycler.setLoadingListener(new XRecyclerView.LoadingListener() {
            @Override
            public void onRefresh() {
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        shouyeXrecycler.refreshComplete();
                    }
                },1500);


            }

            @Override
            public void onLoadMore() {
                shouyeXrecycler.loadMoreComplete();
            }
        });

    }

    @Override
    public void setBundle(Bundle bundle) {

    }


    @Override
    public void showProgress() {

    }

    @Override
    public void dimissProgress() {

    }

    @Override
    public void showMessage(String msg) {

    }

    @Override
    public void setPresenter(HomeContract.Presenter presenter) {
        this.presenter=presenter;
    }

    @Override
    public void start() {

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

    @Override
    public void showHomeListData(PandaHome pandaHome, JingCaiYiKe jingCaiYiKe, GunGunBean gunGunBean) {
        PandaHome.DataBean data = pandaHome.getData();
        //轮播图
            listdata.add(data.getBigImg());
        //播报
        listdata.add(data.getPandaeye());
        //直播秀场
        listdata.add(data.getPandalive());
        //精彩一刻
        listdata.add(data.getCctv());
        //滚滚视频
        List<PandaHome.DataBean.ListBeanXX> list = data.getList();
        PandaHome.DataBean.ListBeanXX listBeanXX = list.get(0);
        listdata.add(listBeanXX);
        //直播中国
        listdata.add(data.getChinalive());

        //主页的数据储存完之后再将精彩一刻的二级请求对象的集合发过去
        List<JingCaiYiKe.ListBean> jingCaiYiKeList = jingCaiYiKe.getList();
        //最后在把滚滚数据的二级请求集合发过去
        List<GunGunBean.ListBean> gunGunBeanList = gunGunBean.getList();
        //设置首页适配器
        shoyeXRecyclerAdapter = new ShoyeXRecyclerAdapter(activity,listdata,jingCaiYiKeList,gunGunBeanList);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(activity);
        shouyeXrecycler.setLayoutManager(linearLayoutManager);
        shouyeXrecycler.setAdapter(shoyeXRecyclerAdapter);




        shoyeXRecyclerAdapter.notifyDataSetChanged();
    }

    @Override
    public void playVideo() {

    }

    @Override
    public void loadWebView() {

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
}
