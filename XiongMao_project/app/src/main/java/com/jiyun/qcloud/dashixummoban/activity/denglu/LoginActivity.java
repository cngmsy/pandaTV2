package com.jiyun.qcloud.dashixummoban.activity.denglu;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.jiyun.qcloud.dashixummoban.R;
import com.jiyun.qcloud.dashixummoban.activity.denglu.shezhi.SheZhiActivity;
import com.zhy.autolayout.AutoRelativeLayout;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

//登录页面 杜智宏
public class LoginActivity extends AppCompatActivity {

    @BindView(R.id.shezhi)
    AutoRelativeLayout shezhi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.shezhi)
    public void onViewClicked() {
        Intent intent = new Intent(LoginActivity.this, SheZhiActivity.class);
        startActivity(intent);
    }
}
