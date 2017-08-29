package com.jiyun.qcloud.dashixummoban.modle.net;

import android.os.Handler;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by KING on 2017/8/26 11:41
 * 邮箱:992767879@qq.com
 */

public class Okhttpdanli {
        private static Okhttpdanli okhttputil;
        private final OkHttpClient build;
        //接口

        public interface Calla{
            void chenggong(String q);
            void shibai(String w);
        }
        //暴露一个公共的方法，在方法中传递参数接口，发返回的结果方法到接口的方法中

        public Okhttpdanli(){
            build = new OkHttpClient.Builder().build();
        }
        public static Okhttpdanli getIntence(){
            if(okhttputil==null){
                synchronized (Okhttpdanli.class){
                    if(okhttputil==null){
                        okhttputil=new Okhttpdanli();
                    }
                }
            }
            return okhttputil;
        }
        Handler handler= new Handler();
        public void getok(String url, final Calla calla){
            Request build1 = new Request.Builder().url(url).build();
            build.newCall(build1).enqueue(new Callback() {

                private String string;

                @Override
                public void onFailure(Call call, IOException e) {
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            calla.shibai("请求失败");
                        }
                    });

                }
                @Override
                public void onResponse(Call call, final Response response) throws IOException {
                    string = response.body().string();
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            calla.chenggong(string);
                        }
                    });
                }
            });
    }
}
