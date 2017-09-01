package com.jiyun.qcloud.dashixummoban.ui.web2;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jcodecraeer.xrecyclerview.XRecyclerView;
import com.jiyun.qcloud.dashixummoban.R;
import com.jiyun.qcloud.dashixummoban.adapter.Web2Adapter;
import com.jiyun.qcloud.dashixummoban.base.BaseFragment;
import com.jiyun.qcloud.dashixummoban.entity.Web2Entity1;
import com.jiyun.qcloud.dashixummoban.entity.Web2Entity2;
import com.jiyun.qcloud.dashixummoban.entity.Web2Entity3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by 王晓亮 on 2017/8/27.
 */

public class Web2Fragment2 extends BaseFragment implements Web2Contract.view {
    @BindView(R.id.video_xrecycler)
    XRecyclerView videoXrecycler;
    Unbinder unbinder;
    private Web2Fragment2.Iweb2fragment2 iweb2fragment;
    private Web2Contract.presenter presenter;
    private String id;
    private Map<String, String> map;
    private int i = 1;

    public void setIweb2fragment2(Web2Fragment2.Iweb2fragment2 iweb2fragment) {
        this.iweb2fragment = iweb2fragment;
    }

    private List<Web2Entity1.VideoBean> list = new ArrayList<>();
    private Web2Adapter web2Adapter;
    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case 1:
                    web2Adapter.notifyDataSetChanged();
                    break;
            }
        }
    };

    @Override
    protected int getLayoutRes() {
        return R.layout.fragment_video;
    }

    @Override
    protected void initData() {
        web2Adapter.setiWeb2Adapterjiekou(new Web2Adapter.IWeb2Adapterjiekou() {
            @Override
            public void Linster(int poss) {
                iweb2fragment.linster(poss,list.get(poss).getVid());
            }
        });
        videoXrecycler.setLoadingListener(new XRecyclerView.LoadingListener() {
            @Override
            public void onRefresh() {
                i = 1;
                if (list.size() > 0) {
                    list.clear();
                }
                presenter.threed(map);
            }

            @Override
            public void onLoadMore() {
                videoXrecycler.loadMoreComplete();
            }
        });
    }

    @Override
    protected void initView(View view) {
        Bundle arguments = getArguments();
        id = arguments.getString("B");
        handler.sendEmptyMessage(1);
        presenter = new Web2Presenter(this);
        videoXrecycler.setLayoutManager(new LinearLayoutManager(getActivity()));
        web2Adapter = new Web2Adapter(getActivity(), list);
        videoXrecycler.setAdapter(web2Adapter);
        map = new HashMap<>();
        map.put("vsid", "VSET100237714751");
        map.put("serviceId", "panda");
        map.put("em", "2");
        map.put("n", "10");
        map.put("p", i + "");
        presenter.threed(map);
        //videoXrecycler.setrefr

    }

    @Override
    public void setBundle(Bundle bundle) {

    }

    @Override
    public void showWeb2list1(Web2Entity1 list1) {
        List<Web2Entity1.VideoBean> video = list1.getVideo();
        if (video.size() > 0) {
            list.addAll(video);
            handler.sendEmptyMessage(1);
        }
    }

    @Override
    public void showWeb2list2(Web2Entity2 list2) {
    }

    @Override
    public void showWeb2list3(Web2Entity3 list3) {

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
    public void setPresenter(Web2Contract.presenter presenter) {
        this.presenter = presenter;
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

    public interface Iweb2fragment2 {
        void linster(int poss,String vid);
    }
}
