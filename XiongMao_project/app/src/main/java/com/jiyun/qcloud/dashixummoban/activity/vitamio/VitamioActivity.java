package com.jiyun.qcloud.dashixummoban.activity.vitamio;

import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;

import com.jiyun.qcloud.dashixummoban.R;

import io.vov.vitamio.MediaPlayer;
import io.vov.vitamio.widget.MediaController;
import io.vov.vitamio.widget.VideoView;


//这是vitamio万能播放器 因为普通的videoview不支持flv视频格式
public class VitamioActivity extends AppCompatActivity {
    String mVideoPath = "http://3811.liveplay.myqcloud.com/live/flv/3811_channel1709.flv";
    private VideoView mVideoView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_vitamio);
        initView();
        initVideoSettings();
    }

    private void initView() {
        mVideoView = (VideoView) findViewById(R.id.vitamio);
    }
    private void initVideoSettings()
    {      //设置控制器，该controller可以自定义
        mVideoView.setMediaController(new MediaController(VitamioActivity.this));
        //获取焦点
        mVideoView.requestFocus();
        //设置缓冲大小
        mVideoView.setBufferSize(1024 * 1024);
        //设置色彩格式
        mVideoView.setVideoChroma(MediaPlayer.VIDEOCHROMA_RGB565);
        //设置播放路径，这里使用的是url，也可以改成本地的视频
        mVideoView.setVideoPath(mVideoPath);
        //设置一个监听
        mVideoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {

            @Override

            public void onPrepared(MediaPlayer mediaPlayer) {


                mediaPlayer.setPlaybackSpeed(1.0f);
                mVideoView.start();

            }

        });
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
