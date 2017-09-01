package com.jiyun.qcloud.dashixummoban.ui.live;

import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.jiyun.qcloud.dashixummoban.R;
import com.jiyun.qcloud.dashixummoban.base.BaseFragment;
import com.jiyun.qcloud.dashixummoban.entity.PandaLive;
import com.jiyun.qcloud.dashixummoban.entity.PandaLiveVideo;
import com.jiyun.qcloud.dashixummoban.entity.PandanShiJiao;
import com.jiyun.qcloud.dashixummoban.ui.live.livefragment.LiveContract;
import com.jiyun.qcloud.dashixummoban.ui.live.livefragment.LivePresenter;
import com.jiyun.qcloud.dashixummoban.ui.live.qiehuanfragment.BianKanFragment;
import com.jiyun.qcloud.dashixummoban.ui.live.qiehuanfragment.ShiJiaoFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.Unbinder;
import de.greenrobot.event.EventBus;
import de.greenrobot.event.Subscribe;
import de.greenrobot.event.ThreadMode;
import io.vov.vitamio.widget.MediaController;

/**
 * Created by ASUS on 2017/8/23.
 */

public class LiveFragment extends BaseFragment implements LiveContract.View {

    @BindView(R.id.tv_live_title)
    TextView tvLiveTitle;
    @BindView(R.id.tv_livepager_brief)
    TextView tvLivepagerBrief;
    @BindView(R.id.live_tablayout)
    TabLayout liveTablayout;
    @BindView(R.id.live_viewpager)
    ViewPager liveViewpager;
    Unbinder unbinder;
    @BindView(R.id.image_live_sanjiao_up)
    ImageView imageLiveSanjiaoUp;
    @BindView(R.id.image_live_sanjiao_down)
    ImageView imageLiveSanjiaoDown;
    @BindView(R.id.vitamio_videoview)
    io.vov.vitamio.widget.VideoView vitamioVideoview;
    private LiveContract.Presenter presenter;
    private List<String> listtitle = new ArrayList<>();
    private List<Fragment> listfragment = new ArrayList<>();

    @Override
    protected int getLayoutRes() {
        return R.layout.fragment_live;
    }

    @Override
    protected void initData() {
        presenter = new LivePresenter(this);
        presenter.start();

        listener();
    }

    private void listener() {
        imageLiveSanjiaoUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (tvLivepagerBrief.isShown()) {
                    imageLiveSanjiaoUp.setVisibility(View.GONE);
                    imageLiveSanjiaoDown.setVisibility(View.VISIBLE);
                    tvLivepagerBrief.setVisibility(View.GONE);
                }
            }
        });
        imageLiveSanjiaoDown.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!tvLivepagerBrief.isShown()) {
                    imageLiveSanjiaoUp.setVisibility(View.VISIBLE);
                    imageLiveSanjiaoDown.setVisibility(View.GONE);
                    tvLivepagerBrief.setVisibility(View.VISIBLE);
                }
            }
        });
    }

    @Override
    protected void initView(View view) {

        EventBus.getDefault().register(this);

        liveTablayout.setSelectedTabIndicatorColor(Color.BLUE);

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
    public void setPresenter(LiveContract.Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void showLiveListData(PandaLive pandaLive) {

        String title = pandaLive.getLive().get(0).getTitle();
        tvLiveTitle.setText("[正在直播]" + title);
        tvLivepagerBrief.setText(pandaLive.getLive().get(0).getBrief());

        if (listtitle.size() < 2) {
            listtitle.add(pandaLive.getBookmark().getMultiple().get(0).getTitle());
            listtitle.add(pandaLive.getBookmark().getWatchTalk().get(0).getTitle());

            listfragment.add(new ShiJiaoFragment());
            listfragment.add(new BianKanFragment());
            liveViewpager.setAdapter(new FragmentPagerAdapter(getFragmentManager()) {
                @Override
                public Fragment getItem(int position) {
                    return listfragment.get(position);
                }

                @Override
                public int getCount() {
                    return listfragment.size();
                }

                @Override
                public CharSequence getPageTitle(int position) {
                    return listtitle.get(position);
                }
            });
            liveTablayout.setupWithViewPager(liveViewpager);
        }
    }

    @Override
    public void showLiveListDataSecond(PandaLiveVideo pandaLiveVideo) {
        String flv1 = pandaLiveVideo.getFlv_url().getFlv2();
        Log.e("flv1",flv1);

        if(!flv1.equals("")){
            vitamioVideoview.setVideoURI(Uri.parse(flv1));
            MediaController mediaController = new MediaController(getActivity());
            mediaController.show(3000);
            vitamioVideoview.setMediaController(mediaController);
        }
    }

    @Override
    public void playVideo() {

    }

    @Override
    public void loadWebView() {

    }

//   @Override
//    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
//        // TODO: inflate a fragment view
//        View rootView = super.onCreateView(inflater, container, savedInstanceState);
//        unbinder = ButterKnife.bind(this, rootView);
//        return rootView;
//    }
//
//    @Override
//    public void onDestroyView() {
//        super.onDestroyView();
//        unbinder.unbind();
//    }

    @Subscribe(threadMode = ThreadMode.MainThread)
    public void onEventMessage(PandanShiJiao.ListBean listBean){
        Log.e("listBean.getId():",listBean.getId());
        presenter.second(listBean.getId());
    }

    @Override
    public void onPause() {
        super.onPause();
        EventBus.getDefault().unregister(this);
    }

    @Override
    public void onStop() {
        super.onStop();
        EventBus.getDefault().unregister(this);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }
}
