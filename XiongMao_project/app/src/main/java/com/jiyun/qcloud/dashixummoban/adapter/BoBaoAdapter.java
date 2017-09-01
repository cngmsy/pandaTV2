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
import com.jiyun.qcloud.dashixummoban.entity.BoBaoEntity2;
import com.jiyun.qcloud.dashixummoban.entity.VideoEntity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 王晓亮 on 2017/8/23.
 */

public class BoBaoAdapter extends RecyclerView.Adapter<BoBaoAdapter.MyHolder> implements View.OnClickListener {
    private List<BoBaoEntity2.ListBean> list = new ArrayList<>();
    private Context context;
    private BoBaoAdapter.bobaoItem item;

    public void setItem(bobaoItem item) {
        this.item = item;
    }

    public BoBaoAdapter(List<BoBaoEntity2.ListBean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @Override
    public BoBaoAdapter.MyHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.bobao_item, null);
        inflate.setOnClickListener(this);
        return new BoBaoAdapter.MyHolder(inflate);
    }

    @Override
    public void onBindViewHolder(BoBaoAdapter.MyHolder holder, int position) {
        holder.name.setText(list.get(position).getTitle());
        holder.content.setText(list.get(position).getFocus_date() + "");
        Glide.with(holder.iv.getContext()).load(list.get(position).getPicurl()).into(holder.iv);
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

        public MyHolder(View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.bobao_item_name);
            content = itemView.findViewById(R.id.bobao_item_content);
            iv = itemView.findViewById(R.id.bobao_item_iv);
        }
    }

    public interface bobaoItem {
        void Linsert(int poss);
    }
}
