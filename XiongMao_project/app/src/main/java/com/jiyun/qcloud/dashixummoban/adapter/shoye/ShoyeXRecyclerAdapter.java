package com.jiyun.qcloud.dashixummoban.adapter.shoye;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.jiyun.qcloud.dashixummoban.R;
import com.jiyun.qcloud.dashixummoban.activity.jctv.JCVideoActivity;
import com.jiyun.qcloud.dashixummoban.activity.vitamio.VitamioActivity;
import com.jiyun.qcloud.dashixummoban.base.BaseActivity;
import com.jiyun.qcloud.dashixummoban.entity.PandaHome;
import com.jiyun.qcloud.dashixummoban.entity.shoye.GunGunBean;
import com.jiyun.qcloud.dashixummoban.entity.shoye.JingCaiYiKe;
import com.jiyun.qcloud.dashixummoban.view.MyGridView;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.loader.ImageLoader;


import java.util.ArrayList;
import java.util.List;

import static android.R.id.text1;


/**
 * Created by Administrator on 2017/8/24.
 */

public class ShoyeXRecyclerAdapter extends RecyclerView.Adapter{
    List<Object> listdata;
    Context context;
    private final int BIGIMAGE=0;//轮播图
    private final int BOBAO=1;//熊猫播报
    private final int XIUCHANG=2;//直播秀场
    private final int JINGCAI=3;//精彩一刻
    private final int GUNGUN=4;//滚滚视频
    private final int CHINA=5;//直播中国
    private List<GunGunBean.ListBean> list;
    List<JingCaiYiKe.ListBean> jingCaiYiKeList;
    List<GunGunBean.ListBean> gunGunBeanList;
    private PandaHome.DataBean.BigImgBean bigImgBeanlei;

    public ShoyeXRecyclerAdapter(FragmentActivity activity, List<Object> listdata, List<JingCaiYiKe.ListBean> jingCaiYiKeList, List<GunGunBean.ListBean> gunGunBeanList) {
        this.listdata=listdata;
        //这个是穿过来的精彩一刻的数据
        this.jingCaiYiKeList=jingCaiYiKeList;
        //这是传过来的滚滚视频的数据
        this.gunGunBeanList=gunGunBeanList;
        context=activity;
    }

    @Override
    public int getItemViewType(int position) {
        Object o = listdata.get(position);
        if (o instanceof PandaHome.DataBean.BigImgBean){
            return BIGIMAGE;
        }else if(o instanceof PandaHome.DataBean.PandaeyeBean){
            return BOBAO;
        }else if (o instanceof PandaHome.DataBean.PandaliveBean){
            return XIUCHANG;
        }else if (o instanceof PandaHome.DataBean.CctvBean){
            return JINGCAI;
        }else if (o instanceof PandaHome.DataBean.ListBeanXX){
            return GUNGUN;
        }else if (o instanceof PandaHome.DataBean.ChinaliveBean) {
            return CHINA;
        }

        return super.getItemViewType(position);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        RecyclerView.ViewHolder holder=null;
        switch (viewType){
            case BIGIMAGE:
                View inflate1 = LayoutInflater.from(context).inflate(R.layout.item_shoye_recycler1, parent, false);
                holder=new BigImageHolder(inflate1);
                break;
            case BOBAO:
                View inflate2 = LayoutInflater.from(context).inflate(R.layout.item_shoye_recycler2, parent, false);
                holder=new BobaoHolder(inflate2);
                break;
            case XIUCHANG:
                View inflate3 = LayoutInflater.from(context).inflate(R.layout.item_shoye_recycler3, parent, false);
                holder=new XiuchangHolder(inflate3);
                break;
            case JINGCAI:
                View inflate4 = LayoutInflater.from(context).inflate(R.layout.item_shoye_recycler4, parent, false);
                holder=new JingcaiHolder(inflate4);
                break;
            case GUNGUN:
                View inflate5 = LayoutInflater.from(context).inflate(R.layout.item_shoye_recycler5, parent, false);
                holder=new GungunHolder(inflate5);
                break;
            case CHINA:
                View inflate6 = LayoutInflater.from(context).inflate(R.layout.item_shoye_recycler6, parent, false);
                holder=new ChinaHolder(inflate6);
                break;

        }
        return holder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
        int itemViewType = getItemViewType(position);
        switch (itemViewType){
            //轮播图
            case BIGIMAGE:
                List<PandaHome.DataBean.BigImgBean> bigImg = (List<PandaHome.DataBean.BigImgBean>) listdata.get(position);
                 bigImgBeanlei = bigImg.get(position);
                String pid = bigImgBeanlei.getPid();
                Log.e("pidpid",pid);
                BigImageHolder bigImageHolder= (BigImageHolder) holder;
                List<String>listimage=new ArrayList<>();
                List<String>listtitle=new ArrayList<>();
                for (int i = 0; i <bigImg.size() ; i++) {
                    PandaHome.DataBean.BigImgBean bigImgBean = bigImg.get(i);
                    listimage.add(bigImgBean.getImage());
                    listtitle.add(bigImgBean.getTitle());
                }
                bigImageHolder.banner.setImages(listimage)//添加图片集合或图片url集合
                        .setDelayTime(2000)//设置轮播时间
                        .setBannerStyle(BannerConfig.CIRCLE_INDICATOR_TITLE)//指示器样式
                        .setImageLoader(new GlideImage())//加载图片
                        .setBannerTitles(listtitle)
                        .setIndicatorGravity(BannerConfig.CENTER)//设置指示器位置
                        .start();
                break;
            //熊猫播报
            case BOBAO:
                BobaoHolder bobaoHolder= (BobaoHolder) holder;
                PandaHome.DataBean.PandaeyeBean o = (PandaHome.DataBean.PandaeyeBean) listdata.get(position);
                String pandaeyelogo = o.getPandaeyelogo();
                String title = o.getTitle();
                List<PandaHome.DataBean.PandaeyeBean.ItemsBean> items = o.getItems();
                final PandaHome.DataBean.PandaeyeBean.ItemsBean itemsBean = items.get(0);
                final PandaHome.DataBean.PandaeyeBean.ItemsBean itemsBean1 = items.get(1);
                Glide.with(context).load(pandaeyelogo).into(bobaoHolder.image);
                bobaoHolder.title.setText(title);
                bobaoHolder.text1.setText(itemsBean.getBrief());
                bobaoHolder.text2.setText(itemsBean.getTitle());
                bobaoHolder.text3.setText(itemsBean1.getBrief());
                bobaoHolder.text4.setText(itemsBean1.getTitle());
                //设置点击事件
                bobaoHolder.inflate21.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        String pid1 = itemsBean.getPid();
                        String title1 = itemsBean.getTitle();
                        Intent intent = new Intent(context, JCVideoActivity.class);
                       intent.putExtra("title",title1);
                        intent.putExtra("mp4","http://115.182.35.91/api/getVideoInfoForCBox.do?pid="+pid1);
                        context.startActivity(intent);
                    }
                });
                break;
            //直播秀场
            case XIUCHANG:
                XiuchangHolder xiuchangHolder= (XiuchangHolder) holder;
                PandaHome.DataBean.PandaliveBean pandaliveBean = (PandaHome.DataBean.PandaliveBean) listdata.get(position);
                final List<PandaHome.DataBean.PandaliveBean.ListBeanX> list = pandaliveBean.getList();
                String title1 = pandaliveBean.getTitle();
                xiuchangHolder.title.setText(title1);
                xiuchangHolder.shoye_item3_gridview.setAdapter(new BaseAdapter() {
                    @Override
                    public int getCount() {
                        return list.size();
                    }

                    @Override
                    public Object getItem(int i) {
                        return list.get(i);
                    }

                    @Override
                    public long getItemId(int i) {
                        return i;
                    }

                    @Override
                    public View getView(int i, View view, ViewGroup viewGroup) {
                        View inflate = LayoutInflater.from(context).inflate(R.layout.item_shoye_recycler3_gridviewitem, null);
                        ImageView image = inflate.findViewById(R.id.item_shoye_recycler_gridview_image);
                        TextView text = inflate.findViewById(R.id.item_shoye_recycler_gridview_text);
                        TextView title = inflate.findViewById(R.id.item_shoye_recycler_gridview_tilte);

                        PandaHome.DataBean.PandaliveBean.ListBeanX listBeanX = list.get(i);
                        Glide.with(context).load(listBeanX.getImage()).into(image);
                        title.setText(listBeanX.getTitle());

                        //监听事件
                        image.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                Intent intent = new Intent(context, VitamioActivity.class);
                                context.startActivity(intent);
                            }
                        });
                        return inflate;
                    }
                });


                break;
            //精彩一刻
            case JINGCAI:
                final JingcaiHolder jingcaiHolder= (JingcaiHolder) holder;
                PandaHome.DataBean.CctvBean cctv = (PandaHome.DataBean.CctvBean) listdata.get(position);
                String title2 = cctv.getTitle();
                jingcaiHolder.shoye_item4_title.setText(title2);

                jingcaiHolder.shoye_item4_gridview.setAdapter(new BaseAdapter() {
                    @Override
                    public int getCount() {
                        return jingCaiYiKeList.size();
                    }

                    @Override
                    public Object getItem(int i) {
                        return jingCaiYiKeList.get(i);
                    }

                    @Override
                    public long getItemId(int i) {
                        return i;
                    }

                    @Override
                    public View getView(int i, View view, ViewGroup viewGroup) {
                        final View inflate = LayoutInflater.from(context).inflate(R.layout.item_shoye_recycler4_gridviewitem, null);
                        ImageView image = inflate.findViewById(R.id.item_shoye_recycler_gridview2_image);
                        TextView text = inflate.findViewById(R.id.item_shoye_recycler_gridview2_text);
                        TextView title = inflate.findViewById(R.id.item_shoye_recycler2_gridview_tilte);
                        TextView time = inflate.findViewById(R.id.item_shoye_recycler2_gridview_time);
                        final JingCaiYiKe.ListBean listBean = jingCaiYiKeList.get(i);
                        Glide.with(context).load(listBean.getImage()).into(image);
                        text.setText("     "+listBean.getVideoLength());
                        title.setText(listBean.getTitle());
                        time.setText(listBean.getDaytime());
                        //点击事件
                        image.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                String pid1 = listBean.getPid();
                                String title3 = listBean.getTitle();
                                Intent intent = new Intent(context, JCVideoActivity.class);
                                intent.putExtra("title",title3);
                                intent.putExtra("mp4","http://115.182.35.91/api/getVideoInfoForCBox.do?pid="+pid1);
                                context.startActivity(intent);
                            }
                        });
                        return inflate;
                    }
                });

                break;
            //滚滚视频
            case GUNGUN:
                final GungunHolder gungunHolder= (GungunHolder) holder;
                PandaHome.DataBean.ListBeanXX listBeanXX = (PandaHome.DataBean.ListBeanXX) listdata.get(position);
                gungunHolder.shoye_item5_title.setText(listBeanXX.getTitle());
                //接下来是给listview的item进行赋值了
                //将传来的滚滚视频的结合拿到
                gungunHolder.shoye_item5_listview.setAdapter(new ListViewAdapter());
                setListViewHeightBasedOnChildren(gungunHolder.shoye_item5_listview);
                break;
            case CHINA:
                ChinaHolder chinaHolder= (ChinaHolder) holder;
                PandaHome.DataBean.ChinaliveBean chinaliveBean = (PandaHome.DataBean.ChinaliveBean) listdata.get(position);
                chinaHolder.shoye_item6_title.setText(chinaliveBean.getTitle());
                final List<PandaHome.DataBean.ChinaliveBean.ListBean> list1 = chinaliveBean.getList();
                //设置适配器
                chinaHolder.shoye_item6_gridview.setAdapter(new BaseAdapter() {
                    @Override
                    public int getCount() {
                        return list1.size();
                    }

                    @Override
                    public Object getItem(int i) {
                        return list1.get(i);
                    }

                    @Override
                    public long getItemId(int i) {
                        return i;
                    }

                    @Override
                    public View getView(int i, View view, ViewGroup viewGroup) {
                        View inflate = LayoutInflater.from(context).inflate(R.layout.item_shoye_recycler3_gridviewitem, null);
                        ImageView image = inflate.findViewById(R.id.item_shoye_recycler_gridview_image);
                        TextView text = inflate.findViewById(R.id.item_shoye_recycler_gridview_text);
                        TextView title = inflate.findViewById(R.id.item_shoye_recycler_gridview_tilte);

                        PandaHome.DataBean.ChinaliveBean.ListBean listBean = list1.get(i);
                        Glide.with(context).load(listBean.getImage()).into(image);
                        title.setText(listBean.getTitle());
                        image.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                Intent intent = new Intent(context, VitamioActivity.class);
                                context.startActivity(intent);
                            }
                        });
                        return inflate;
                    }
                });
                break;
        }
    }

    @Override
    public int getItemCount() {
        return listdata.size();
    }



    //轮播图
    public class GlideImage extends ImageLoader {
        @Override
        public void displayImage(final Context context, Object path, ImageView imageView) {
            Glide.with(context.getApplicationContext()).load(path).into(imageView);
            imageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    String title = bigImgBeanlei.getPid();
                    Intent intent = new Intent(context, JCVideoActivity.class);
                    intent.putExtra("mp4","http://115.182.35.91/api/getVideoInfoForCBox.do?pid="+title);
                    context.startActivity(intent);
                }
            });
        }
    }


    private class BigImageHolder extends RecyclerView.ViewHolder {
        private final View inflate1;
        Banner banner;
        public BigImageHolder(View inflate) {
            super(inflate);
             inflate1 = inflate;
            banner = inflate.findViewById(R.id.shouye_bannerviewpager);
        }
    }



//熊猫播报
    private class BobaoHolder extends RecyclerView.ViewHolder {
    private final View inflate21;
    ImageView image;
    TextView text4;
    TextView text1;
    TextView text2;
    TextView text3;
    TextView title;
    public BobaoHolder(View inflate2) {
            super(inflate2);
         inflate21 = inflate2;
        title = inflate2.findViewById(R.id.shoye_item2_title);
        image = inflate2.findViewById(R.id.shoye_item2_image);
             text1 = inflate2.findViewById(R.id.shoye_item2_text);
             text2 = inflate2.findViewById(R.id.shoye_item2_text2);
             text3 = inflate2.findViewById(R.id.shoye_item2_text3);
             text4 = inflate2.findViewById(R.id.shoye_item2_text4);
        }
    }

    private class XiuchangHolder extends RecyclerView.ViewHolder {
        private final View inflate31;
        TextView title;
        GridView shoye_item3_gridview;
        public XiuchangHolder(View inflate3) {
            super(inflate3);
             inflate31 = inflate3;
            title = inflate3.findViewById(R.id.shoye_item3_title);
             shoye_item3_gridview = inflate3.findViewById(R.id.shoye_item3_gridview);
        }
    }

    private class JingcaiHolder extends RecyclerView.ViewHolder {
        private final View inflate41;
        TextView shoye_item4_title;
        MyGridView shoye_item4_gridview;
        public JingcaiHolder(View inflate4) {
            super(inflate4);
             inflate41 = inflate4;
            shoye_item4_title = inflate4.findViewById(R.id.shoye_item4_title);
             shoye_item4_gridview = inflate4.findViewById(R.id.shoye_item4_gridview);
        }
    }

    private class GungunHolder extends RecyclerView.ViewHolder {
        private final View inflate51;
        TextView shoye_item5_title;
        ListView shoye_item5_listview;
        public GungunHolder(View inflate5) {
            super(inflate5);
             inflate51 = inflate5;
            shoye_item5_title = inflate5.findViewById(R.id.shoye_item5_title);
             shoye_item5_listview = inflate5.findViewById(R.id.shoye_item5_listview);


        }
    }

    private class ChinaHolder extends RecyclerView.ViewHolder {
        private final View inflate61;
        TextView shoye_item6_title;
        MyGridView shoye_item6_gridview;
        public ChinaHolder(View inflate6) {
            super(inflate6);
             inflate61 = inflate6;
            shoye_item6_title = inflate6.findViewById(R.id.shoye_item6_title);
             shoye_item6_gridview = inflate6.findViewById(R.id.shoye_item6_gridview);
        }
    }

    class ListViewAdapter extends BaseAdapter{
        @Override
        public int getCount() {
            return gunGunBeanList.size();
        }

        @Override
        public Object getItem(int i) {
            return gunGunBeanList.get(i);
        }

        @Override
        public long getItemId(int i) {
            return i;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            View inflate = LayoutInflater.from(context).inflate(R.layout.item_shoye_recycler5_listviewitem, null);
            ImageView image = inflate.findViewById(R.id.item_shoye_recycler5_listviewitme_image);
            TextView text = inflate.findViewById(R.id.item_shoye_recycler5_listviewitme_text);
            TextView time = inflate.findViewById(R.id.item_shoye_recycler5_listviewitme_time);
            TextView playlength = inflate.findViewById(R.id.item_shoye_recycler5_listviewitme_playlength);

            final GunGunBean.ListBean listBean = gunGunBeanList.get(i);
            Glide.with(context).load(listBean.getImage()).into(image);
            text.setText(listBean.getTitle());
            time.setText(listBean.getDaytime());
            playlength.setText(listBean.getVideoLength());
            //监听
            image.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    String pid1 = listBean.getPid();
                    Intent intent = new Intent(context, JCVideoActivity.class);
                    intent.putExtra("mp4","http://115.182.35.91/api/getVideoInfoForCBox.do?pid="+pid1);
                    context.startActivity(intent);
                }
            });
            return inflate;
        }
    }


    //解决listview显示不全的问题
    public void setListViewHeightBasedOnChildren(ListView listView) {
        // 获取ListView对应的Adapter
        ListViewAdapter listAdapter = (ListViewAdapter) listView.getAdapter();
        if (listAdapter == null) {
            return;
        }
        int totalHeight = 0;
        for (int i = 0, len = listAdapter.getCount(); i < len; i++) {
            // listAdapter.getCount()返回数据项的数目
            View listItem = listAdapter.getView(i, null, listView);
            // 计算子项View 的宽高
            listItem.measure(0, 0);
            // 统计所有子项的总高度
            totalHeight += listItem.getMeasuredHeight();
        }
        ViewGroup.LayoutParams params = listView.getLayoutParams();
        params.height = totalHeight + (listView.getDividerHeight()* (listAdapter.getCount() - 1));
        listView.setLayoutParams(params);
    }

}
