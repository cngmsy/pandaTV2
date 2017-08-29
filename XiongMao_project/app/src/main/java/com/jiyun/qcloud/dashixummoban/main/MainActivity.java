package com.jiyun.qcloud.dashixummoban.main;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.view.KeyEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.jiyun.qcloud.dashixummoban.R;
import com.jiyun.qcloud.dashixummoban.activity.denglu.LoginActivity;
import com.jiyun.qcloud.dashixummoban.activity.hudong.HuDongActivity;
import com.jiyun.qcloud.dashixummoban.app.App;
import com.jiyun.qcloud.dashixummoban.base.BaseActivity;
import com.jiyun.qcloud.dashixummoban.base.BaseFragment;
import com.jiyun.qcloud.dashixummoban.manager.ActivityCollector;
import com.jiyun.qcloud.dashixummoban.manager.FragmentMager;
import com.jiyun.qcloud.dashixummoban.ui.bobao.BobaoFragment;
import com.jiyun.qcloud.dashixummoban.ui.china.ChinaFragment;
import com.jiyun.qcloud.dashixummoban.ui.china.ChinaPresenter;
import com.jiyun.qcloud.dashixummoban.ui.home.HomePageFragment;
import com.jiyun.qcloud.dashixummoban.ui.live.LivePageFragment;
import com.jiyun.qcloud.dashixummoban.ui.live.livepagerfragment.LivepagerPresenter;
import com.jiyun.qcloud.dashixummoban.ui.video.VideoFragment;
import com.orhanobut.logger.Logger;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import util.UpdateAppUtils;


/**
 * Created by chj on 2017/8/20.
 */

public class MainActivity extends BaseActivity {


    @BindView(R.id.iconImg)
    ImageView iconImg;
    @BindView(R.id.personImg)
    ImageView personImg;
    @BindView(R.id.titleTv)
    TextView titleTv;
    @BindView(R.id.hudongImg)
    ImageView hudongImg;
    @BindView(R.id.container)
    FrameLayout container;
    @BindView(R.id.homePage)
    RadioButton homePage;
    @BindView(R.id.homePandaLive)
    RadioButton homePandaLive;
    @BindView(R.id.homeRollVideo)
    RadioButton homeRollVideo;
    @BindView(R.id.homePandaBroadcast)
    RadioButton homePandaBroadcast;
    @BindView(R.id.homeLiveChina)
    RadioButton homeLiveChina;
    @BindView(R.id.homeBottomGroup)
    RadioGroup homeBottomGroup;
    @BindView(R.id.textView2)
    TextView textView2;
    private FragmentManager fragmentManager;
    private long mExitTime;

    @Override
    protected void initData() {

        fragmentManager = App.mBaseActivity.getSupportFragmentManager();
        HomePageFragment homeFragment = (HomePageFragment) FragmentMager.getInstance().start(R.id.container, HomePageFragment.class, false).build();
        //presenter在这里初始化
        new HomePresenter(homeFragment);
    }

    @Override
    protected void initView() {
        textView2.setVisibility(View.INVISIBLE);

        UpdateAppUtils.from(this)
                .serverVersionCode(2)  //服务器versionCode
                .serverVersionName("2.0") //服务器versionName
                .apkPath("http://123.206.14.104:8080/FileUploadDemo/files/wxl.apk") //最新apk下载地址
                .update();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;

    }

    @OnClick({R.id.homePage, R.id.homePandaLive, R.id.homeRollVideo, R.id.homePandaBroadcast, R.id.homeLiveChina, R.id.homeBottomGroup,R.id.personImg,R.id.hudongImg})

    public void onClicks(View view) {
        switch (view.getId()) {
            case R.id.homePage:
                //首页
                iconImg.setVisibility(View.VISIBLE);
                textView2.setVisibility(View.INVISIBLE);
                hudongImg.setVisibility(View.VISIBLE);

                FragmentMager.getInstance().start(R.id.container, HomePageFragment.class, false).build();
                Logger.d("22222");
                break;
            case R.id.homePandaLive:
                //熊猫直播
<<<<<<< HEAD
                LivePageFragment build = (LivePageFragment) FragmentMager.getInstance().start(R.id.container, LivePageFragment.class, false).build();
                new LivepagerPresenter(build);
=======
                iconImg.setVisibility(View.INVISIBLE);
                textView2.setVisibility(View.VISIBLE);
                hudongImg.setVisibility(View.INVISIBLE);
                textView2.setText("熊猫直播");
                FragmentMager.getInstance().start(R.id.container, LivePageFragment.class, false).build();
>>>>>>> 877f4f683c6590ac372351468317b5a7776d726f
                break;
            case R.id.homeRollVideo:
                //滚滚视频
                iconImg.setVisibility(View.INVISIBLE);
                textView2.setVisibility(View.VISIBLE);
                hudongImg.setVisibility(View.INVISIBLE);
                textView2.setText("滚滚视频");
                FragmentMager.getInstance().start(R.id.container, VideoFragment.class, false).build();
                break;
            case R.id.homePandaBroadcast:
                //熊猫播报
                iconImg.setVisibility(View.INVISIBLE);
                textView2.setVisibility(View.VISIBLE);
                hudongImg.setVisibility(View.INVISIBLE);
                textView2.setText("熊猫播报");
                FragmentMager.getInstance().start(R.id.container, BobaoFragment.class, false).build();
                break;
            case R.id.homeLiveChina:
                //直播中国
                iconImg.setVisibility(View.INVISIBLE);
                textView2.setVisibility(View.VISIBLE);
                hudongImg.setVisibility(View.INVISIBLE);
                textView2.setText("直播中国");
                ChinaFragment build = (ChinaFragment) FragmentMager.getInstance().start(R.id.container, ChinaFragment.class, false).build();
                new ChinaPresenter(build);
                break;
            case R.id.homeBottomGroup:
                break;
            //点击登录
            case R.id.personImg:
                Intent intent = new Intent(MainActivity.this, LoginActivity.class);
                startActivity(intent);
                break;
            //点击跳到互动页面
            case R.id.hudongImg:
                Intent intent1 = new Intent(MainActivity.this, HuDongActivity.class);
                startActivity(intent1);
                break;
        }
    }


    /**
     * 自定义回退栈管理；
     * 获取栈顶的fragment的名字，判断名字是否和主页的名字是否一样，
     * 如果一样就退出应用，如果不是就回退上一个fragment；
     * <p>
     * onBackPressed()与onKeyDown
     */
    @Override
    public void onBackPressed() {
        String simpleName = fragmentManager.getBackStackEntryAt(fragmentManager.getBackStackEntryCount() - 1).getName();
        if ("HomePageFragment".equals(simpleName) ||
                "LivePageFragment".equals(simpleName) ||
                "VideoFragment".equals(simpleName) ||
                "BobaoFragment".equals(simpleName) ||
                "ChinaFragment".equals(simpleName)
                ) {
            finish();
        } else {
            if (fragmentManager.getBackStackEntryCount() > 1) {
                fragmentManager.popBackStackImmediate();//
                String name = fragmentManager.getBackStackEntryAt(fragmentManager.getBackStackEntryCount() - 1).getName();
                App.lastfragment = (BaseFragment) fragmentManager.findFragmentByTag(name);
            }
        }
    }

    /**
     * 双击退出
     *
     * @param keyCode
     * @param event
     * @return
     */
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        String name = fragmentManager.getBackStackEntryAt(fragmentManager.getBackStackEntryCount() - 1).getName();
        if ("HomePageFragment".equals(name) ||
                "LivePageFragment".equals(name) ||
                "VideoFragment".equals(name) ||
                "BobaoFragment".equals(name) ||
                "ChinaFragment".equals(name)
                ) {
            if (keyCode == KeyEvent.KEYCODE_BACK) {//back键被按下了
                if ((System.currentTimeMillis() - mExitTime) > 2000) {//第二次点击判断是否在两秒内完成，是的话Finish掉（退出）
                    Toast.makeText(this, "再按一次退出程序", Toast.LENGTH_SHORT).show();
                    mExitTime = System.currentTimeMillis();
                } else {
                    ActivityCollector.getInstance().exit(App.mBaseActivity);
                }
                return true;
            }
        }
        return super.onKeyDown(keyCode, event);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }

}




