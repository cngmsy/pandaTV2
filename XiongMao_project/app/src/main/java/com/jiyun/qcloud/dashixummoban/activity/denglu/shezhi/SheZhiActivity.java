package com.jiyun.qcloud.dashixummoban.activity.denglu.shezhi;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.jiyun.qcloud.dashixummoban.R;
import com.jiyun.qcloud.dashixummoban.modle.cache.GlideCacheUtil;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class SheZhiActivity extends AppCompatActivity {

    @BindView(R.id.shezhi_delete)
    ImageView shezhiDelete;
    @BindView(R.id.glide_huancun)
    TextView glideHuancun;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_she_zhi);
        ButterKnife.bind(this);
        //通过工具类获取到glide的缓存
        String cacheSize = GlideCacheUtil.getInstance().getCacheSize(SheZhiActivity.this);
//        Toast.makeText(this,cacheSize, Toast.LENGTH_SHORT).show();
        glideHuancun.setText(cacheSize);

    }

    //点击清除缓存的按钮 清除缓存

    @OnClick(R.id.shezhi_delete)
    public void onViewClicked() {
        AlertDialog.Builder builder = new AlertDialog.Builder(SheZhiActivity.this);
        builder.setTitle("提示");
        builder.setMessage("是否清除全部缓存");
        builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                //调用glide工具类的方法 清除图片全部缓存
                GlideCacheUtil.getInstance().clearImageAllCache(SheZhiActivity.this);
                glideHuancun.setText("0.00M");
            }
        });
        builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        });
        builder.show();

    }
}