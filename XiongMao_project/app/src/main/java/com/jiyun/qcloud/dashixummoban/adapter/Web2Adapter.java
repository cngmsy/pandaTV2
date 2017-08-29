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
import com.jiyun.qcloud.dashixummoban.entity.Web2Entity1;

import java.util.List;

/**
 * Created by 王晓亮 on 2017/8/27.
 */

public class Web2Adapter extends RecyclerView.Adapter<Web2Adapter.MyHolder> implements View.OnClickListener {
    private Context context;
    private List<Web2Entity1.VideoBean> list;
    private IWeb2Adapterjiekou iWeb2Adapterjiekou;

    public void setiWeb2Adapterjiekou(IWeb2Adapterjiekou iWeb2Adapterjiekou) {
        this.iWeb2Adapterjiekou = iWeb2Adapterjiekou;
    }

    public Web2Adapter(FragmentActivity activity, List<Web2Entity1.VideoBean> list) {
        this.list = list;
        this.context = activity;
    }

    @Override
    public MyHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.video_item, null);
        inflate.setOnClickListener(this);
        return new MyHolder(inflate);
    }

    @Override
    public void onBindViewHolder(MyHolder holder, int position) {
        holder.textView.setText(list.get(position).getLen());
        holder.textView2.setText(list.get(position).getT());
        Glide.with(holder.imageView.getContext()).load(list.get(position).getImg()).into(holder.imageView);
        holder.itemView.setTag(position);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    @Override
    public void onClick(View view) {
        Integer tag = (Integer) view.getTag();
        if (iWeb2Adapterjiekou != null) {
            iWeb2Adapterjiekou.Linster(tag);
        }
    }

    class MyHolder extends RecyclerView.ViewHolder {
        private ImageView imageView;
        private TextView textView;
        private TextView textView2;

        public MyHolder(View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.video_item_iv);
            textView = itemView.findViewById(R.id.video_item_timer);
            textView2 = itemView.findViewById(R.id.video_item_content);
        }
    }

    public interface IWeb2Adapterjiekou {
        void Linster(int poss);
    }
}
