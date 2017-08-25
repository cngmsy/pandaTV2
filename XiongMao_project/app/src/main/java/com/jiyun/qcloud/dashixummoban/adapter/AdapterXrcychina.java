package com.jiyun.qcloud.dashixummoban.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.jiyun.qcloud.dashixummoban.R;
import com.jiyun.qcloud.dashixummoban.entity.china.ChinaXiangqing;

import java.util.List;

import fm.jiecao.jcvideoplayer_lib.JCVideoPlayer;

/**
 * Created by KING on 2017/8/24 21:58
 * 邮箱:992767879@qq.com
 */

public class AdapterXrcychina extends RecyclerView.Adapter {
    private List<ChinaXiangqing.LiveBean> xiangqingList;
    private Context context;
    private boolean a=true;
    private Neibulei holder1;

    public AdapterXrcychina(List<ChinaXiangqing.LiveBean> xiangqingList, Context context) {
        this.xiangqingList = xiangqingList;
        this.context = context;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View inflate = LinearLayout.inflate(context, R.layout.item_xrcychina, null);
        return new Neibulei(inflate);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        holder1 = (Neibulei) holder;
        holder1.videocontroller1.setUp(xiangqingList.get(position).getImage(),"");
        Glide.with(context).asBitmap().load(xiangqingList.get(position).getImage()).into(holder1.videocontroller1.ivThumb);
        holder1.zhengzaizhibochina.setText("[正在直播]"+xiangqingList.get(position).getTitle());
        holder1.xianshineirong1.setImageResource(R.drawable.com_facebook_tooltip_blue_bottomnub);
        holder1.xiangqingneirong.setText(xiangqingList.get(position).getBrief());
        holder1.xiangqingneirong.setVisibility(View.GONE);
        holder1.xianshineirong1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(a){
                    holder1.xianshineirong1.setImageResource(R.drawable.com_facebook_tooltip_blue_topnub);
                    holder1.xiangqingneirong.setVisibility(View.VISIBLE);
                    a=false;
                }else{
                    holder1.xiangqingneirong.setVisibility(View.GONE);
                    holder1.xianshineirong1.setImageResource(R.drawable.com_facebook_tooltip_blue_bottomnub);
                    a=true;
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return xiangqingList.size();
    }

    private class Neibulei extends RecyclerView.ViewHolder {
        private JCVideoPlayer videocontroller1;
        private TextView zhengzaizhibochina;
        private ImageView xianshineirong1;
        private TextView xiangqingneirong;
        public Neibulei(View itemView) {
            super(itemView);
            videocontroller1=itemView.findViewById(R.id.videocontroller1);
            zhengzaizhibochina=itemView.findViewById(R.id.zhengzaizhibochina);
            xianshineirong1=itemView.findViewById(R.id.xianshineirong);
            xiangqingneirong=itemView.findViewById(R.id.neirongjianjie);
        }
    }
}
