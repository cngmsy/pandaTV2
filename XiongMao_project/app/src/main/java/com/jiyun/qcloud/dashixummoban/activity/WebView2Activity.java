package com.jiyun.qcloud.dashixummoban.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.text.Html;
import android.text.method.ScrollingMovementMethod;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.jiyun.qcloud.dashixummoban.R;
import com.jiyun.qcloud.dashixummoban.adapter.FPAdapter;
import com.jiyun.qcloud.dashixummoban.base.BaseActivity;
import com.jiyun.qcloud.dashixummoban.entity.Web2Entity1;
import com.jiyun.qcloud.dashixummoban.entity.Web2Entity2;
import com.jiyun.qcloud.dashixummoban.entity.Web2Entity3;
import com.jiyun.qcloud.dashixummoban.ui.web2.Web2Contract;
import com.jiyun.qcloud.dashixummoban.ui.web2.Web2Fragment1;
import com.jiyun.qcloud.dashixummoban.ui.web2.Web2Fragment2;
import com.jiyun.qcloud.dashixummoban.ui.web2.Web2Presenter;
import com.jiyun.qcloud.dashixummoban.ui.web2.imageloder.MyTagHandler;
import com.jiyun.qcloud.dashixummoban.ui.web2.imageloder.URLImageParser;
import com.zhy.autolayout.AutoLinearLayout;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import fm.jiecao.jcvideoplayer_lib.JCVideoPlayer;

//webView的页面 如果要使用直接Intent传来一个名字为url的地址就可以
public class WebView2Activity extends BaseActivity implements Web2Contract.view, View.OnClickListener {

    @BindView(R.id.videocontroller1)
    JCVideoPlayer videocontroller1;
    @BindView(R.id.web2_jieshao)
    TextView web2Jieshao;
    @BindView(R.id.web2_lin1)
    AutoLinearLayout web2Lin1;
    @BindView(R.id.web2_title2)
    TextView web2Title2;
    @BindView(R.id.web2_timer2)
    TextView web2Timer2;
    @BindView(R.id.web2_lin2)
    AutoLinearLayout web2Lin2;
    @BindView(R.id.web2_content)
    TextView web2Content;
    @BindView(R.id.web2_relativeLayout)
    RelativeLayout web2RelativeLayout;
    @BindView(R.id.web2_relativeLayout2)
    RelativeLayout web2RelativeLayout2;
    @BindView(R.id.web2_bt)
    Button web2Bt;
    @BindView(R.id.web2_tab)
    TabLayout web2Tab;
    @BindView(R.id.web2_pager)
    ViewPager web2Pager;
    private ArrayList<Web2Entity1.VideoBean> list = new ArrayList<>();
    @BindView(R.id.web2_return)
    ImageView web2Return;
    @BindView(R.id.web2_title)
    TextView web2Title;
    @BindView(R.id.web2_sc)
    Button web2Sc;
    @BindView(R.id.web2_fx)
    Button web2Fx;
    private int i = 1;
    private int a = 0;
    private int b = 1;
    private List<String> listname = new ArrayList<>();
    private List<Fragment> listfragment = new ArrayList<>();
    private Web2Contract.presenter presenter;
    private FPAdapter fpAdapter;
    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case 1:
                    fpAdapter.notifyDataSetChanged();
                    break;
            }
        }
    };
    private Web2Fragment1 web2Fragment1;
    private Web2Fragment2 web2Fragment2;
    private String id;


    //点击事件
    @Override
    protected void initData() {
        web2Bt.setOnClickListener(this);
        web2Return.setOnClickListener(this);
    }

    @Override
    protected void initView() {
        web2Fragment1 = new Web2Fragment1();
        web2Fragment2 = new Web2Fragment2();
        Glide.with(videocontroller1.getContext()).load(R.drawable._no_img).into(videocontroller1.ivThumb);
        Intent intent = getIntent();
        id = intent.getStringExtra("id");
        String title = intent.getStringExtra("title");
        if (!title.equals("")) {
            web2Title.setText(title);
            Map<String, String> map = new HashMap<>();
            map.put("vsid", id);
            map.put("n", "7");
            map.put("serviceId", "panda");
            map.put("o", "desc");
            map.put("of", "time");
            map.put("p", i + "");
            presenter = new Web2Presenter(this);
            presenter.threed(map);
            fpAdapter = new FPAdapter(getSupportFragmentManager(), listname, listfragment);
            web2Pager.setAdapter(fpAdapter);
            web2Tab.setupWithViewPager(web2Pager);
            web2Lin2.setVisibility(View.GONE);
        } else {
            Map<String, String> map = new HashMap<>();
            map.put("id", id);
            map.put("serviceId", "panda");
            presenter = new Web2Presenter(this);
            presenter.four(map);
            web2Lin1.setVisibility(View.GONE);
            web2Jieshao.setVisibility(View.GONE);
        }

        web2Fragment1.setIweb2fragment(new Web2Fragment1.Iweb2fragment() {
            @Override
            public void linster(int poss, String vid) {
                presenter.second(vid);
            }
        });
        web2Fragment2.setIweb2fragment2(new Web2Fragment2.Iweb2fragment2() {
            @Override
            public void linster(int poss, String vid) {
                presenter.second(vid);
            }
        });
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_web_view2;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }

    @Override
    public void showWeb2list1(Web2Entity1 web2entity1) {
        list.clear();
        list.addAll(web2entity1.getVideo());
        Log.e("BBBBBBB", list.size() + "");
        if (list.size() > 0) {
            if (!web2entity1.getVideoset().get_$0().getFl().equals("")) {
                listname.clear();
                listfragment.clear();
                listname.add("高清完整");
                listname.add("精彩看点");
                Bundle bundle = new Bundle();
                bundle.putParcelableArrayList("A", list);
                bundle.putString("B", id);
                web2Fragment1.setArguments(bundle);
                web2Fragment2.setArguments(bundle);
                listfragment.add(web2Fragment1);
                listfragment.add(web2Fragment2);
                handler.sendEmptyMessage(1);
            } else {
                listname.clear();
                listfragment.clear();
                listname.add("高清完整");
                Bundle bundle = new Bundle();
                bundle.putParcelableArrayList("A", list);
                bundle.putString("B", id);
                web2Fragment1.setArguments(bundle);
                listfragment.add(web2Fragment1);
                handler.sendEmptyMessage(1);
            }
        }
        if (!list.get(a).getVid().equals("")) {
            presenter.second(list.get(a).getVid());
        }

        web2Jieshao.setText(web2entity1.getVideoset().get_$0().getDesc());
    }

    @Override
    public void showWeb2list2(Web2Entity2 web2entity2) {
        String url = web2entity2.getVideo().getChapters().get(0).getUrl();
        Log.e("AAAAA", url);
        videocontroller1.setUp(url, "视频/MP3标题");
    }

    @Override
    public void showWeb2list3(Web2Entity3 list3) {
        web2Timer2.setText(list3.getSource() + "     " + list3.getPubtime());
        web2Title2.setText(list3.getTitle());

        web2Content.setMovementMethod(ScrollingMovementMethod.getInstance());
        MyTagHandler myTagHandler = new MyTagHandler(this);
        web2Content.setText(Html.fromHtml(list3.getContent(), new URLImageParser(web2Content, this), myTagHandler));
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
    protected void onDestroy() {
        super.onDestroy();
        JCVideoPlayer.releaseAllVideos();
    }

    @Override
    protected void onPause() {
        super.onPause();
        JCVideoPlayer.releaseAllVideos();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.web2_bt:
                b++;
                if (b % 2 == 0) {
                    web2Bt.setBackgroundResource(R.drawable.com_facebook_tooltip_blue_bottomnub);
                    web2Jieshao.setVisibility(View.GONE);
                } else {
                    web2Bt.setBackgroundResource(R.drawable.com_facebook_tooltip_blue_topnub);
                    web2Jieshao.setVisibility(View.VISIBLE);
                }
                break;
            case R.id.web2_return:
                finish();
                break;
        }
    }

}
