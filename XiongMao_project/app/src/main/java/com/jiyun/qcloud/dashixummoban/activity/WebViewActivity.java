package com.jiyun.qcloud.dashixummoban.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.jiyun.qcloud.dashixummoban.R;
import com.jiyun.qcloud.dashixummoban.base.BaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

//webView的页面 如果要使用直接Intent传来一个名字为url的地址就可以
public class WebViewActivity extends BaseActivity {


    @BindView(R.id.web_return)
    ImageView webReturn;
    @BindView(R.id.web_title)
    TextView webTitle;
    @BindView(R.id.web_share)
    ImageView webShare;
    @BindView(R.id.web_webview)
    WebView webWebview;

    @Override
    protected void initData() {
        //获取传递过来的数据
        Intent intent = getIntent();
        String title = intent.getStringExtra("title");
        if (!title.equals("")){
            webTitle.setText(title);
        }
        String url = intent.getStringExtra("url");

        WebSettings webSettings = webWebview.getSettings();
        //设置WebView属性，能够执行Javascript脚本
        webSettings.setJavaScriptEnabled(true);
        //设置可以访问文件
        webSettings.setAllowFileAccess(true);
        //设置支持缩放
        webSettings.setBuiltInZoomControls(true);
        //加载需要显示的网页
        webWebview.loadUrl(url);
        //设置Web视图
        webWebview.setWebViewClient(new webViewClient());


    }

    //    设置回退
//    覆盖Activity类的onKeyDown(int keyCoder,KeyEvent event)方法
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if ((keyCode == KeyEvent.KEYCODE_BACK) && webWebview.canGoBack()) {
            webWebview.goBack(); //goBack()表示返回WebView的上一页面
            return true;
        }
        finish();//结束退出程序
        return false;
    }

    //Web视图
    private class webViewClient extends WebViewClient {
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            view.loadUrl(url);
            return true;
        }
    }

    @Override
    protected void initView() {

    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_web_view;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }

    @OnClick({R.id.web_return, R.id.web_share})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.web_return:
                Toast.makeText(this, "返回", Toast.LENGTH_SHORT).show();
                break;
            case R.id.web_share:
                Toast.makeText(this, "分享", Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
