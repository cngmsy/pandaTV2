package com.jiyun.qcloud.dashixummoban.ui.bobao;


import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.jcodecraeer.xrecyclerview.XRecyclerView;
import com.jiyun.qcloud.dashixummoban.R;
import com.jiyun.qcloud.dashixummoban.activity.WebView2Activity;
import com.jiyun.qcloud.dashixummoban.adapter.BoBaoAdapter;
import com.jiyun.qcloud.dashixummoban.base.BaseFragment;
import com.jiyun.qcloud.dashixummoban.entity.BoBaoEntity1;
import com.jiyun.qcloud.dashixummoban.entity.BoBaoEntity2;
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
//这个是熊猫播报Fragment
public class BobaoFragment extends BaseFragment implements BoBaoContract.view, XRecyclerView.LoadingListener{
    @BindView(R.id.bobao_xrecycler)
    XRecyclerView bobaoXrecycler;
    Unbinder unbinder;
    private int i = 3;
    private List<BoBaoEntity2.ListBean> list = new ArrayList<>();
    private BoBaoContract.presenter presenter;
    private BoBaoAdapter boBaoAdapter;
    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case 1:
                    boBaoAdapter.notifyDataSetChanged();
                    break;
            }
        }
    };
    private ImageView headview_picture;
    private TextView headview_title;

    @Override
    protected int getLayoutRes() {
        return R.layout.fragment_bobao;
    }

    @Override
    protected void initData() {
        boBaoAdapter.setItem(new BoBaoAdapter.bobaoItem() {
            @Override
            public void Linsert(int poss) {
                Intent intent = new Intent(getActivity(), WebView2Activity.class);
                intent.putExtra("id", list.get(poss).getId());
                intent.putExtra("title", "");
                intent.putExtra("url", list.get(poss).getUrl());
                startActivity(intent);
            }
        });

    }

    @Override
    protected void initView(View view) {
        presenter = new BoBAoPresenter(this);
        presenter.start();
        Map<String, String> map = new HashMap();
        map.put("path", "iphoneInterface/general/getArticleAndVideoListInfo.json&primary_id=PAGE142243519150633");
        map.put("serviceId", "panda");
        map.put("pageSize", "6");
        map.put("page", i + "");

        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.headview, null);
        headview_picture = inflate.findViewById(R.id.headview_picture);
        headview_title = inflate.findViewById(R.id.headview_title);
        bobaoXrecycler.setLayoutManager(new LinearLayoutManager(getActivity()));
        boBaoAdapter = new BoBaoAdapter(list, getActivity());
        bobaoXrecycler.setAdapter(boBaoAdapter);
        bobaoXrecycler.addHeaderView(inflate);
        bobaoXrecycler.setLoadingListener(this);
        presenter.second(i + "");
    }

    @Override
    public void setBundle(Bundle bundle) {

    }

    @Override
    public void showBoBaolist(final BoBaoEntity1 boBaoEntity1) {

        //http://api.cntv.cn/apicommon/index?path=iphoneInterface/general/getArticleAndVideoListInfo.json&primary_id=PAGE1422435191506336&serviceId=panda&pageSize=6&page=3
        //  presenter.second(boBaoEntity1.getData().getListurl());
        headview_title.setText(boBaoEntity1.getData().getBigImg().get(0).getTitle());
        Glide.with(headview_picture.getContext()).load(boBaoEntity1.getData().getBigImg().get(0).getImage()).into(headview_picture);
        headview_picture.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), VideoActivity.class);
                intent.putExtra("pid", boBaoEntity1.getData().getBigImg().get(0).getPid());
                startActivity(intent);
            }
        });
    }

    @Override
    public void showBoBaolist2(List<BoBaoEntity2.ListBean> list1) {
        list.addAll(list1);
        handler.sendEmptyMessage(1);
        bobaoXrecycler.refreshComplete();
        bobaoXrecycler.loadMoreComplete();
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
    public void setPresenter(BoBaoContract.presenter presenter) {
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

    @Override
    public void onRefresh() {
        list.clear();
        i = 3;
        presenter.second(i + "");
    }

    @Override
    public void onLoadMore() {
        Log.e("AAAAAAAAAAAAAAAAAAAAA", "CCCCCCCCCCCCCCCCCCC");
        i++;
        presenter.second(i + "");
    }

}
