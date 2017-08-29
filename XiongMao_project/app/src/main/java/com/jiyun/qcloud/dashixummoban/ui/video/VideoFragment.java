package com.jiyun.qcloud.dashixummoban.ui.video;


import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.jcodecraeer.xrecyclerview.XRecyclerView;
import com.jiyun.qcloud.dashixummoban.R;
import com.jiyun.qcloud.dashixummoban.activity.WebView2Activity;
import com.jiyun.qcloud.dashixummoban.adapter.VideoAdapter;
import com.jiyun.qcloud.dashixummoban.base.BaseFragment;
import com.jiyun.qcloud.dashixummoban.entity.VideoEntity;
import com.jiyun.qcloud.dashixummoban.ui.web2.VideoActivity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;


/**
 * A simple {@link Fragment} subclass.
 */
//这个是滚滚视频Fragment
public class VideoFragment extends BaseFragment implements VideoContract.view, XRecyclerView.LoadingListener, View.OnClickListener {
    @BindView(R.id.video_xrecycler)
    XRecyclerView videoXrecycler;
    private List<VideoEntity.ListBean> list = new ArrayList<>();
    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case 1:
                    videoAdapter.notifyDataSetChanged();
                    break;
            }
        }
    };
    Unbinder unbinder;
    private VideoAdapter videoAdapter;
    private VideoContract.presenter presenter;
    private ImageView head_picture;
    private TextView headview_title;

    @Override
    protected int getLayoutRes() {
        return R.layout.fragment_video;
    }

    //Item点击事件
    @Override
    protected void initData() {
        videoAdapter.setItem(new VideoAdapter.videoItem() {
            @Override
            public void Linsert(int poss) {
                Intent intent = new Intent(getActivity(), WebView2Activity.class);
                intent.putExtra("title", list.get(poss).getTitle());
                intent.putExtra("id", list.get(poss).getId());
                startActivity(intent);
            }
        });
        head_picture.setOnClickListener(this);
    }

    @Override
    protected void initView(View view) {
        presenter = new VideoPresenter(this);
//http://api.cntv.cn/apicommon/index?path=iphoneInterface/general/getArticleAndVideoListInfo.json&primary_id=PAGE1422435191506336&serviceId=panda&pageSize=6&page=3
        View inflate1 = LayoutInflater.from(getActivity()).inflate(R.layout.headview, null);
        head_picture = inflate1.findViewById(R.id.headview_picture);
        headview_title = inflate1.findViewById(R.id.headview_title);
        head_picture.setImageResource(R.mipmap.ic_launcher);
        videoXrecycler.setLayoutManager(new LinearLayoutManager(getActivity()));
        videoAdapter = new VideoAdapter(getActivity(), list);
        videoXrecycler.setAdapter(videoAdapter);
        videoXrecycler.addHeaderView(inflate1);
        presenter.start();
        Map<String, String> map = new HashMap();
        map.put("", "");
        presenter.threed(map);
        videoXrecycler.setLoadingListener(this);
        videoXrecycler.setLoadingMoreEnabled(false);
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
    public void showVideoList(List<VideoEntity.ListBean> list1) {
        list.clear();
        list.addAll(list1);
        handler.sendEmptyMessage(1);
    }

    @Override
    public void showVideoListPivture(final List<VideoEntity.BigImgBean> list) {
        if (list.size() > 0) {
            headview_title.setText(list.get(0).getTitle());
            Glide.with(getContext()).load(list.get(0).getImage()).into(head_picture);
            videoXrecycler.refreshComplete();
            head_picture.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(getActivity(), VideoActivity.class);
                    intent.putExtra("pid", list.get(0).getPid());
                    startActivity(intent);
                }
            });
        }
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
    public void setPresenter(VideoContract.presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void onRefresh() {
        presenter.start();
    }

    @Override
    public void onLoadMore() {

    }

    @Override
    public void onClick(View view) {
//        Intent intent = new Intent(getActivity(), WebView2Activity.class);
//        intent.putExtra("pid", list.get(0).getTitle());
//        startActivity(intent);
    }

}
