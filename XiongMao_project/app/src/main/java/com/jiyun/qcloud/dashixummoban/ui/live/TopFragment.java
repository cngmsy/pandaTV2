package com.jiyun.qcloud.dashixummoban.ui.live;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.jcodecraeer.xrecyclerview.XRecyclerView;
import com.jiyun.qcloud.dashixummoban.R;
import com.jiyun.qcloud.dashixummoban.adapter.JingCaiAdapter;
import com.jiyun.qcloud.dashixummoban.base.BaseFragment;
import com.jiyun.qcloud.dashixummoban.entity.PandaJingcai;
import com.jiyun.qcloud.dashixummoban.entity.Pandalivedetails;
import com.jiyun.qcloud.dashixummoban.entity.PandanShiJiao;
import com.jiyun.qcloud.dashixummoban.pandaliveactivity.PandaLiveActivity;
import com.jiyun.qcloud.dashixummoban.ui.live.jingcaifragment.JingCaiContract;
import com.jiyun.qcloud.dashixummoban.ui.live.jingcaifragment.JingCaiPresenter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by ASUS on 2017/8/24.
 */

public class TopFragment extends BaseFragment implements JingCaiContract.View{

    @BindView(R.id.jingcai_recycle)
    XRecyclerView jingcaiRecycle;
    Unbinder unbinder;
    private JingCaiContract.Presenter presenter;
    private List<PandaJingcai.VideoBean> list = new ArrayList<>();
    private List<Pandalivedetails.VideoBean.ChaptersBean> lists = new ArrayList<>();
    private List<String> listvid = new ArrayList<>();
    private JingCaiAdapter jingCaiAdapter;
    private Map<String,String> map= new HashMap<>();
    int i = 1;
    int x = 1;
    int y = 1;

    @Override
    protected int getLayoutRes() {
        return R.layout.fragment_jingcai;
    }

    @Override
    protected void initData() {
        map.put("vsid","VSET100167216881");
        map.put("n","7");
        map.put("serviceId","panda");
        map.put("o","desc");
        map.put("of","time");
        map.put("p","1");

        presenter = new JingCaiPresenter(this);
        presenter.startmap5(map);

        Listener();
    }

    private void Listener() {
        jingCaiAdapter.setOnButtonClickListener(new JingCaiAdapter.ButtonClick() {
            @Override
            public void buttonclick(int position, View view) {
                Intent intent = new Intent(getActivity(), PandaLiveActivity.class);
                intent.putExtra("url",listvid.get(position));
                startActivity(intent);
            }
        });

        jingcaiRecycle.setLoadingListener(new XRecyclerView.LoadingListener() {
            @Override
            public void onRefresh() {
                list.clear();
                i = 1;
                x = 1;
                y = 1;
                presenter.startmap1(map);
                jingcaiRecycle.refreshComplete();
            }
            @Override
            public void onLoadMore() {

                x++;
                y++;

                i++;
                Toast.makeText(getActivity(), "加载更多。。。。。", Toast.LENGTH_SHORT).show();
                map.put("p",i+"");
                Log.e("i---:",i+"");
                presenter.startmap1(map);
                jingcaiRecycle.loadMoreComplete();
            }
        });
    }

    @Override
    protected void initView(View view) {

        LinearLayoutManager manager = new LinearLayoutManager(getActivity());
        jingcaiRecycle.setLayoutManager(manager);

        jingCaiAdapter = new JingCaiAdapter(getActivity(),list,lists);
        jingcaiRecycle.setAdapter(jingCaiAdapter);
    }

    @Override
    public void setBundle(Bundle bundle) {

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
    public void showJingCaiListData(PandaJingcai pandaJingcai) {

        if(x==y){
            List<PandaJingcai.VideoBean> video =  pandaJingcai.getVideo();
            list.addAll(video);
            for (int i = 0; i < video.size(); i++) {
                String vid = video.get(i).getVid();
                listvid.add(vid);
            }
            jingCaiAdapter.notifyDataSetChanged();
        }
        Log.e("i:",i+"");
        Log.e("list.size:",list.size()+"");
    }

    @Override
    public void showShiJiaoListData(PandanShiJiao pandanShiJiao) {

    }

    @Override
    public void showJingCaiListDataSecond(Pandalivedetails pandalivedetails) {

    }


    @Override
    public void playVideo() {

    }

    @Override
    public void loadWebView() {

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
    public void setPresenter(JingCaiContract.Presenter presenter) {

    }
    @Override
    public void onPause() {
        super.onPause();
        y--;
    }
}
