package com.jiyun.qcloud.dashixummoban.adapter;

import android.content.Context;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.jiyun.qcloud.dashixummoban.R;
import com.jiyun.qcloud.dashixummoban.entity.VideoEntity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 王晓亮 on 2017/8/23.
 */

public class VideoAdapter extends RecyclerView.Adapter<VideoAdapter.MyHolder> implements View.OnClickListener {
    private List<VideoEntity.ListBean> list = new ArrayList<>();
    private Context context;
    private videoItem item;

    public void setItem(videoItem item) {
        this.item = item;
    }

    public VideoAdapter(FragmentActivity context, List<VideoEntity.ListBean> list) {
        this.list = list;
        this.context = context;
    }

    @Override
    public MyHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.video_item, null);
        inflate.setOnClickListener(this);
        return new MyHolder(inflate);
    }

    @Override
    public void onBindViewHolder(MyHolder holder, int position) {
        holder.name.setText(list.get(position).getTitle());
        holder.content.setText(list.get(position).getBrief());
        Glide.with(holder.iv.getContext()).load(list.get(position).getImage()).into(holder.iv);
        holder.timer.setText(list.get(position).getVideoLength());
        holder.itemView.setTag(position);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    @Override
    public void onClick(View view) {
        Integer tag = (Integer) view.getTag();
        if (item != null) {
            item.Linsert(tag);
        }
    }

    class MyHolder extends RecyclerView.ViewHolder {
        private TextView name;
        private TextView content;
        private ImageView iv;
        private TextView timer;

        public MyHolder(View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.video_item_name);
            content = itemView.findViewById(R.id.video_item_content);
            iv = itemView.findViewById(R.id.video_item_iv);
            timer = itemView.findViewById(R.id.video_item_timer);
        }
    }

    public interface videoItem {
        void Linsert(int poss);
    }
}
