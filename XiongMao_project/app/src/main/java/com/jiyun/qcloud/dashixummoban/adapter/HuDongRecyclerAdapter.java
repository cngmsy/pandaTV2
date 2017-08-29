package com.jiyun.qcloud.dashixummoban.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.jiyun.qcloud.dashixummoban.R;
import com.jiyun.qcloud.dashixummoban.activity.WebViewActivity;
import com.jiyun.qcloud.dashixummoban.activity.hudong.HuDongActivity;
import com.jiyun.qcloud.dashixummoban.entity.ShoyeHudongBean;

import java.util.List;

/**
 * Created by Administrator on 2017/8/24.
 */

//这个是首页互动的Adapter
public class HuDongRecyclerAdapter extends RecyclerView.Adapter<HuDongRecyclerAdapter.MyHolder>{
    List<ShoyeHudongBean.InteractiveBean> listdata;
    Context context;
    public HuDongRecyclerAdapter(HuDongActivity huDongActivity, List<ShoyeHudongBean.InteractiveBean> listdata) {
    this.listdata=listdata;
        context=huDongActivity;
    }

    @Override
    public HuDongRecyclerAdapter.MyHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.item_hudong_recycler, parent, false);
        MyHolder myHolder = new MyHolder(inflate);
        return myHolder;
    }

    @Override
    public void onBindViewHolder(HuDongRecyclerAdapter.MyHolder holder, int position) {
        final ShoyeHudongBean.InteractiveBean interactiveBean = listdata.get(position);
        holder.text.setText(interactiveBean.getTitle());
        Glide.with(context).load(interactiveBean.getImage()).into(holder.image);
        //设置点击事件
        holder.itemView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, WebViewActivity.class);
                intent.putExtra("url",interactiveBean.getUrl());
                intent.putExtra("title",interactiveBean.getTitle());
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return listdata.size();
    }

    public class MyHolder extends RecyclerView.ViewHolder {
        private  View itemView1;
        ImageView image;
        TextView text;
        public MyHolder(View itemView) {
            super(itemView);
             itemView1 = itemView;
            image = itemView.findViewById(R.id.item_hudong_image);
             text = itemView.findViewById(R.id.item_hudong_text);
        }
    }
}
