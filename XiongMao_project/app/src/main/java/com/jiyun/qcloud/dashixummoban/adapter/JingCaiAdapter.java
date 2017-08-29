package com.jiyun.qcloud.dashixummoban.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.jiyun.qcloud.dashixummoban.R;
import com.jiyun.qcloud.dashixummoban.entity.PandaJingcai;
import com.jiyun.qcloud.dashixummoban.entity.Pandalivedetails;

import java.util.List;

/**
 * Created by ASUS on 2017/8/24.
 */

public class JingCaiAdapter extends RecyclerView.Adapter {

    private Context context;
    private List<PandaJingcai.VideoBean> list;
    private List<Pandalivedetails.VideoBean.ChaptersBean> lists;
    private ButtonClick mButtonClick;

    public JingCaiAdapter(Context context, List<PandaJingcai.VideoBean> list, List<Pandalivedetails.VideoBean.ChaptersBean> lists) {
        this.context = context;
        this.list = list;
        this.lists = lists;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.item_jingcai, parent, false);
        MyHolder myHolder = new MyHolder(inflate);
        return myHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
        MyHolder holder1 = (MyHolder) holder;
        holder1.jingcai_item_content.setText(list.get(position).getPtime());
        holder1.jingcai_item_name.setText(list.get(position).getT());
        Glide.with(context).load(list.get(position).getImg()).into(holder1.jingcai_item_image);

        holder1.view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mButtonClick.buttonclick(position,view);
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class MyHolder extends RecyclerView.ViewHolder{

        private final ImageView jingcai_item_image;
        private final TextView jingcai_item_content;
        private final TextView jingcai_item_name;
        private final View view;

        public MyHolder(View itemView) {
            super(itemView);

            view = itemView;
            jingcai_item_image = itemView.findViewById(R.id.jingcai_item_image);
            jingcai_item_content = itemView.findViewById(R.id.jingcai_item_content);
            jingcai_item_name = itemView.findViewById(R.id.jingcai_item_name);

        }
    }

    public void setOnButtonClickListener(ButtonClick buttonClick){
        this.mButtonClick = buttonClick;
    }

    public interface ButtonClick{
        void buttonclick(int position, View view);
    }
}
