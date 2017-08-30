package com.jiyun.qcloud.dashixummoban.activity.jctv;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.graphics.drawable.BitmapDrawable;
import android.media.AudioManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import com.jiyun.qcloud.dashixummoban.R;
import com.jiyun.qcloud.dashixummoban.base.BaseActivity;
import com.jiyun.qcloud.dashixummoban.entity.Pandalivedetails;
import com.jiyun.qcloud.dashixummoban.entity.shoye.HomeJCBean;
import com.umeng.socialize.ShareAction;
import com.umeng.socialize.bean.SHARE_MEDIA;
import com.umeng.socialize.media.UMImage;
import com.umeng.socialize.media.UMVideo;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static com.jiyun.qcloud.dashixummoban.R.id.videoView_length;

//自定义的videoview视频播放 杜智宏
public class JCVideoActivity extends BaseActivity implements JCVideo.View {
    JCVideo.Presenter presenter;
    @BindView(R.id.videoView)
    fullScreen videoView;
    @BindView(R.id.action)
    ImageView action;
    @BindView(R.id.nowtime)
    TextView nowtime;
    @BindView(videoView_length)
    SeekBar videoViewLength;
    @BindView(R.id.alltime)
    TextView alltime;
    @BindView(R.id.liear)
    LinearLayout liear;
    @BindView(R.id.relat)
    RelativeLayout relat;
    @BindView(R.id.fu)
    RelativeLayout fu;
    @BindView(R.id.chongbo)
    ImageView chongbo;
    @BindView(R.id.zi)
    TextView zi;
    private static final int UPDATAUI = 1;
    @BindView(R.id.jc_title)
    TextView jcTitle;
    @BindView(R.id.jv_return)
    ImageView jvReturn;
    @BindView(R.id.jc_fengxiang)
    ImageView jcFengxiang;
    @BindView(R.id.jc_shoucang)
    ImageView jcShoucang;
    private ViewGroup.LayoutParams mVideoViewLayoutParams;
    private int i;
    private int s;
    Handler handler = new Handler();
    private PopupWindow popupWindow;

    //亮度音量用到的
    float lastx = 0;
    float lasty = 0;
    AudioManager am;
    private int height;
    private float mBrightness;
    boolean boo = false;
    int threshold = 1;
    private int width;
    private String url;
    private String title;

    @Override
    protected void initData() {
        Intent intent = getIntent();
        String mp4 = intent.getStringExtra("mp4");
        String title = intent.getStringExtra("title");
        String url = intent.getStringExtra("url");
        String titles = intent.getStringExtra("titles");
        new JCVideoPresenter(mp4, this);

        if(url==null){
            jcTitle.setText(title);
            presenter.start();
        }else {
            jcTitle.setText(titles);
            presenter.second(url);
        }
    }

    @Override
    protected void initView() {

        //获取系统类
        am = (AudioManager) getSystemService(Context.AUDIO_SERVICE);
        //获取到屏幕的宽高 调节音量时用
        WindowManager wm = this.getWindowManager();
        width = wm.getDefaultDisplay().getWidth();
        height = wm.getDefaultDisplay().getHeight();

        int progress = videoViewLength.getProgress();
        videoView.seekTo(progress);
        chongbo.setVisibility(View.GONE);
        zi.setVisibility(View.GONE);
        //获取seekbar的拖动
        setListener();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_jcvideo;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
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
    public void setPresenter(JCVideo.Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void showHudongList(HomeJCBean homeJCBean) {
//        Log.e("hoasndasndasd",homeJCBean.getTitle());
         title = homeJCBean.getTitle();

        HomeJCBean.VideoBean video = homeJCBean.getVideo();
        List<HomeJCBean.VideoBean.ChaptersBean> chapters = video.getChapters();
        HomeJCBean.VideoBean.ChaptersBean chaptersBean = chapters.get(0);
        url = chaptersBean.getUrl();
        videoView.setVideoURI(Uri.parse(url));

    }

    @Override
    public void videodetails(Pandalivedetails pandalivedetails) {
        List<Pandalivedetails.VideoBean.ChaptersBean> chapters = pandalivedetails.getVideo().getChapters();
        for (int i = 0; i < chapters.size(); i++) {
            String url = chapters.get(i).getUrl();
            videoView.setVideoURI(Uri.parse(url));
        }
    }

    @Override
    public void playVideo() {

    }

    @Override
    public void loadWebView() {

    }

    @OnClick({R.id.action, R.id.fu, R.id.chongbo, R.id.jv_return, R.id.jc_fengxiang, R.id.jc_shoucang})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.action:

                if (videoView.isPlaying()) {
                    videoView.pause();
                    action.setImageResource(R.drawable.home_play_icon);
                    UIhandler.removeMessages(UPDATAUI);

                } else {
                    videoView.start();
                    action.setImageResource(R.drawable.pla_pause);
                    //当视频播放4秒之后将上下的标题隐藏起来
//                    handler.postDelayed(new Runnable() {
//                        @Override
//                        public void run() {
//                            liear.setVisibility(View.INVISIBLE);
//                            relat.setVisibility(View.INVISIBLE);
//                        }
//                    }, 4000);
                    UIhandler.sendEmptyMessage(UPDATAUI);
                }
                break;
            case R.id.fu:
                i++;
                if (i % 2 == 0) {
                    liear.setVisibility(View.VISIBLE);
                    relat.setVisibility(View.VISIBLE);
                } else {
                    liear.setVisibility(View.INVISIBLE);
                    relat.setVisibility(View.INVISIBLE);
                }

                break;
            //点击重播键重播 并将其隐藏
            case R.id.chongbo:
                chongbo.setVisibility(View.GONE);
                zi.setVisibility(View.GONE);
                videoView.start();
                break;
            //点击返回键退出
            case R.id.jv_return:
                finish();
                break;
            //分享
            case R.id.jc_fengxiang:
                //弹出分享popuwindow
                        //自定义的popupwindow item布局
                                View inflate = LayoutInflater.from(JCVideoActivity.this).inflate(R.layout.jc_item_popuwindow, null);
                                 popupWindow = new PopupWindow(inflate, ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
                                popupWindow.setFocusable(true);
                                popupWindow.setBackgroundDrawable(new BitmapDrawable());
                                //相对于父布局
                                popupWindow.showAtLocation(fu, Gravity.BOTTOM,0,0);
                        ImageView  jc_return = inflate.findViewById(R.id.jc_popu_return);
                    ImageView  jc_qq = inflate.findViewById(R.id.jc_popu_qq);
                    jc_return.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                popupWindow.dismiss();
                            }
                        });
                jc_qq.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        UMVideo video = new UMVideo(url);
                        video.setTitle(title);//视频的标题
                        UMImage umImage = new UMImage(JCVideoActivity.this, "http://p1.img.cctvpic.com/photoworkspace/2017/08/27/2017082713192092562.jpg");
                        video.setThumb(umImage);//视频的缩略图
                        video.setDescription("熊猫平台");//视频的描述
                        new ShareAction(JCVideoActivity.this)
                                .withText("熊猫平台")
                                .withMedia(video)
                                .setPlatform(SHARE_MEDIA.QQ)//传入平台
                                .share();
                    }
                });

                break;
            //收藏
            case R.id.jc_shoucang:
                s++;
                if (s % 2 == 0) {
                    jcShoucang.setImageResource(R.drawable.play_fullsrcee_collect);
                    Toast.makeText(this, "已取消收藏", Toast.LENGTH_SHORT).show();
                } else {
                    jcShoucang.setImageResource(R.drawable.play_fullsrcee_collect_true);
                    Toast.makeText(this, "已收藏,请到我的收藏中查看", Toast.LENGTH_SHORT).show();
                 }
                break;
        }
    }

    //格式化时间
    private void updataTextView(TextView textView, int millisecond) {
        int second = millisecond / 1000;
        int hh = second / 3600;
        int mm = second % 3600 / 60;
        int ss = second % 60;
        String str = null;
        if (hh != 0) {
            str = String.format("%02d:%02d:%02d", hh, mm, ss);
        } else {
            str = String.format("%02d:%02d", mm, ss);
        }
        textView.setText(str);
    }

    //更新进度条的
    private Handler UIhandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if (msg.what == UPDATAUI) {
                //获取视频播放时间和总时间
                int currentPosition = videoView.getCurrentPosition();
                int duration = videoView.getDuration();
                //格式化视频播放时间
                updataTextView(nowtime, currentPosition);
                updataTextView(alltime, duration);

                videoViewLength.setMax(duration);
                videoViewLength.setProgress(currentPosition);
            }
            UIhandler.sendEmptyMessageDelayed(UPDATAUI, 100);
        }
    };

    //视频正在播放时过4秒钟用户如果不操作页面 让上下的标题栏消失
    Handler Linearhandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if (videoView.isPlaying()) {
                liear.setVisibility(View.INVISIBLE);
                relat.setVisibility(View.INVISIBLE);

            }
            Linearhandler.sendEmptyMessage(4000);
        }
    };

    private void setListener() {
        //视频块进
        videoViewLength.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                //当视频播放完毕之后显示重播按钮
//                Log.e("iiiii",i+"");
                if (i > 0 && i == seekBar.getMax()) {
                    chongbo.setVisibility(View.VISIBLE);
                    zi.setVisibility(View.VISIBLE);
                }else {
                    chongbo.setVisibility(View.GONE);
                    zi.setVisibility(View.GONE);
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                int progress = seekBar.getProgress();
                videoView.seekTo(progress);
                if (!videoView.isPlaying()) {
                    videoView.start();
                }
            }
        });

        videoView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                float y = motionEvent.getY();
                float x = motionEvent.getX();
                switch (motionEvent.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        lastx = x;
                        lasty = y;
                        Log.e("yyyyyy", lasty + "");
                        break;
                    case MotionEvent.ACTION_MOVE:

                        float detlax = x - lastx;
                        float detlay = y - lasty;
//                        Log.e("y",lasty+"");
//                        Log.e("yy",y+"");
                        Log.e("滑动距离", detlay + "");
                        float absdetlax = Math.abs(detlax);
                        float absdetlay = Math.abs(detlay);
                        if (absdetlax > threshold && absdetlay > threshold) {
                            if (absdetlax < absdetlay) {
                                boo = true;
                            } else {
                                boo = true;
                            }

                        } else if (absdetlax < threshold && absdetlay > threshold) {
                            boo = true;
                        } else if (absdetlax > threshold && absdetlay < threshold) {
                            boo = false;
                        }
                        if (boo) {

                            if (x < width / 2) {
                                if (detlay > threshold) {
                                    Log.e("xxx", "降低亮度");
                                } else {
                                    Log.e("xxx", "升高亮度");
                                }
                                liangdu(-detlay);

                            } else {
                                if (detlay > threshold) {
                                    Log.e("uuuu", "减小声音");
                                } else {
                                    Log.e("uuuu", "升高声音");
                                }
                                yingliang(-detlay);
                            }

                        } else {

                        }
                        lastx = x;
                        lasty = y;
                        break;
                    case MotionEvent.ACTION_UP:
                        break;
                }
                return true;
            }
        });
    }
//调节音量的方法
    private void yingliang(float detlay) {
        Log.e("xxxxx","666666666");
        //获取系统最大音量
        int max = am.getStreamMaxVolume(AudioManager.STREAM_MUSIC);
        //获取当前音量
        int streamVolume = am.getStreamVolume(AudioManager.STREAM_MUSIC);
        int index = (int) (detlay / height * max * 3);
        int volume = Math.max(streamVolume + index, 0);
        am.setStreamVolume(AudioManager.STREAM_MUSIC, volume, 0);

    }
    //调节系统亮度的方法
    private void liangdu(float detlay) {
//        Log.e("亮度值", detlay + "");
        WindowManager.LayoutParams attributes = getWindow().getAttributes();
        mBrightness = attributes.screenBrightness;
        float index = detlay / height / 3;
        mBrightness += index;
        if (mBrightness > 1.0f) {
            mBrightness = 1.0f;
        }
        if (mBrightness < 0.01f) {
            mBrightness = 0.01f;
        }
        attributes.screenBrightness = mBrightness;
        getWindow().setAttributes(attributes);
    }

    @Override
    protected void onResume() {
        /**
         * 设置为横屏
         */
        if (getRequestedOrientation() != ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE) {
            setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        }

        super.onResume();
    }

    @Override
    protected void onPause() {

        super.onPause();
        UIhandler.removeMessages(UPDATAUI);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        UIhandler.sendEmptyMessage(UPDATAUI);
    }

    //真正的沉浸式模式
    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        if (hasFocus && Build.VERSION.SDK_INT >= 19) {
            View decorView = getWindow().getDecorView();
            decorView.setSystemUiVisibility(
                    View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                            | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                            | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                            | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                            | View.SYSTEM_UI_FLAG_FULLSCREEN
                            | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);
        }

    }


}
