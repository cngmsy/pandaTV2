package com.jiyun.qcloud.dashixummoban.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.jiyun.qcloud.dashixummoban.R;
import com.jiyun.qcloud.dashixummoban.entity.PandanShiJiao;

import java.util.List;

/**
 * Created by ASUS on 2017/8/25.
 */
public class ShiJiaoAdapter extends BaseAdapter {

    private Context context;
    private List<PandanShiJiao.ListBean> list;
    private ViewHolder holder;

    public ShiJiaoAdapter(Context context, List<PandanShiJiao.ListBean> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup viewGroup) {
        if (convertView == null) {
            holder = new ViewHolder();
            convertView = View.inflate(context, R.layout.item_grid, null);
            holder.image_live_grid = (ImageView) convertView.findViewById(R.id.image_live_grid);
            holder.tv_live_grid = (TextView) convertView.findViewById(R.id.tv_live_grid);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        holder.tv_live_grid.setText(list.get(position).getTitle());
        Glide.with(context).load(list.get(position).getImage()).into(holder.image_live_grid);

        return convertView;
    }

    class ViewHolder {
        ImageView image_live_grid;
        TextView tv_live_grid;
    }

}


