package com.jiyun.qcloud.dashixummoban.ui.china;


import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.jiyun.qcloud.dashixummoban.R;
import com.jiyun.qcloud.dashixummoban.adapter.AdapterFarmentChina;
import com.jiyun.qcloud.dashixummoban.base.BaseFragment;
import com.jiyun.qcloud.dashixummoban.entity.china.ChinaDiming;
import com.jiyun.qcloud.dashixummoban.entity.china.MyGridLayout;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import de.greenrobot.event.EventBus;

import static com.jiyun.qcloud.dashixummoban.R.id.gridlayout_drageable;
import static com.jiyun.qcloud.dashixummoban.R.id.gridlayout_undrageable;

/**
 * A simple {@link Fragment} subclass.
 */
//直播中国
public class ChinaFragment extends BaseFragment implements ChinaContract.View {
    @BindView(R.id.home_tab)
    TabLayout homeTab;
    @BindView(R.id.jia)
    ImageView jia;
    @BindView(R.id.vp)
    ViewPager vp;
    Unbinder unbinder;
    private ChinaContract.Presenter1 presenter1;
    private List<String> tab = new ArrayList<String>();
    private List<BaseFragment> framentlist = new ArrayList<BaseFragment>();
    private PopupWindow popupWindow;
    private MyGridLayout gridlayout_undrageable;
    private MyGridLayout gridlayout_drageable;
    private TextView Chinabianji;
    private ImageView guanbi;
    private boolean as=true;
    private List<ChinaDiming.TablistBean> tablist;
    private List<ChinaDiming.AlllistBean> alllist;
    private AdapterFarmentChina adapterFarmentChina;

    @Override
    protected int getLayoutRes() {
        return R.layout.fragment_china;
    }

    @Override
    protected void initData() {
        presenter1.stare();
    }

    @Override
    protected void initView(View view) {
        Log.e("11111111111","22222222");
    }
    @Override
    public void setBundle(Bundle bundle) {

    }

    @Override
    public void showHomeListData(ChinaDiming chinaDiming) {
        tablist = chinaDiming.getTablist();
        alllist = chinaDiming.getAlllist();
        Log.e("11111111111", alllist.size()+"");
        for (int i = 0; i < tablist.size(); i++) {
            tab.add(tablist.get(i).getTitle());
            framentlist.add(new ChinaFragments(tablist.get(i).getUrl()));
        }
        adapterFarmentChina = new AdapterFarmentChina(getChildFragmentManager(),tab,framentlist);
        homeTab.setupWithViewPager(vp);
        vp.setCurrentItem(0);
        vp.setAdapter(adapterFarmentChina);
        jia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                xianshifubiao();
            }
        });
        //        viewById.setOnClickListener(new View.OnClickListener() {
        //            @Override
        //            public void onClick(View v) {
        //                popupWindow.showAtLocation(viewById1, Gravity.BOTTOM,0,0);
        //            }
        //        });





//        tablist.get(0);
//        Log.e("--------",tablist.get(0).getTitle());
    }

    @Override
    public void setPresenter(ChinaContract.Presenter1 presenter1) {
        this.presenter1 = presenter1;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // TODO: inflate a fragment view
        View rootView = super.onCreateView(inflater, container, savedInstanceState);
        unbinder = ButterKnife.bind(this, rootView);
        return rootView;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    private ArrayList<String> list1;
    private ArrayList<String> list2;
    private void initGridLayout() {
        gridlayout_drageable.setGridLayoutItemDrageAble(true);
        list1 = new ArrayList<String>();
        for (int i = 0; i <tablist.size() ; i++) {
            list1.add(tablist.get(i).getTitle());
        }
        gridlayout_drageable.addItems(list1);

        gridlayout_undrageable.setGridLayoutItemDrageAble(false);
        list2 = new ArrayList<String>();
        for (int i = 0; i < alllist.size(); i++) {
            for (int j = 0; j <tablist.size() ; j++) {
                if(tablist.get(j).getTitle().equals(alllist.get(i).getTitle())){
                    alllist.remove(i);
                }
            }
            list2.add(alllist.get(i).getTitle());
        }
        gridlayout_undrageable.addItems(list2);
    }
    private void xianshifubiao(){
        View inflate = LayoutInflater.from(getActivity()).inflate(R.layout.layout_gridlayout_two, null);
        gridlayout_drageable = (MyGridLayout) inflate.findViewById(R.id.gridlayout_drageable);
        gridlayout_undrageable = (MyGridLayout) inflate.findViewById(R.id.gridlayout_undrageable);
        Chinabianji =  inflate.findViewById(R.id.Chinabianji);
        guanbi =  inflate.findViewById(R.id.guanbi);
        //这是初始化布局为了显示PuPO
        //这是new一个对象后面的参数。第一个参数布局，第二个参数用容器调用一个系统的方法，后面的是旋转的度数
        popupWindow = new PopupWindow(inflate, ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.MATCH_PARENT);
        initGridLayout();
        popupWindow.setFocusable(true);
        //new一个过期的方法点击屏幕以外消失
        popupWindow.setBackgroundDrawable(new BitmapDrawable());
        //这是i定义的引用动画
//                popupWindow.setAnimationStyle(R.style.qqq);
        // 这个是显示的意思
        popupWindow.showAsDropDown(inflate);
        Chinabianji.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(as){
                    Chinabianji.setText("完成");
                    //点击下部，移除一个item在第一个里面添加一个item
                    gridlayout_undrageable.setOnItemClickLitener(new MyGridLayout.OnItemClickLitener() {
                        @Override
                        public void OnItemClickLitener(String strItem, View v) {
                            Log.e("3333333333333",strItem);
                            gridlayout_undrageable.removeView(v);
                            gridlayout_drageable.addTvItem(strItem);
                            for (int i = 0; i <alllist.size(); i++) {
                                if(alllist.get(i).getTitle().equals(strItem)){
                                    ChinaDiming.TablistBean tablistBean = new ChinaDiming.TablistBean();
                                    ChinaDiming.AlllistBean alllistBean = alllist.get(i);
                                    tablistBean.setTitle(alllistBean.getTitle());
                                    tablistBean.setUrl(alllistBean.getUrl());
                                    tablist.add(tablistBean);
                                    alllist.remove(i);
                                    adapterFarmentChina.notifyDataSetChanged();
                                }
                            }
                        }
                    });
//点击上部，移除一个item在第二个里面添加一个item
                    gridlayout_drageable.setOnItemClickLitener(new MyGridLayout.OnItemClickLitener() {
                        @Override
                        public void OnItemClickLitener(String strItem, View v) {
                            Log.e("44444444444444444",strItem);
                            gridlayout_drageable.removeView(v);
                            gridlayout_undrageable.addTvItem(strItem);
                            for (int i = 0; i <tablist.size(); i++) {
                                    if(tablist.get(i).getTitle().equals(strItem)){
                                        ChinaDiming.AlllistBean alllistBean1 = new ChinaDiming.AlllistBean();
                                        ChinaDiming.TablistBean tablistBean = tablist.get(i);
                                        alllistBean1.setTitle(tablistBean.getTitle());
                                        alllistBean1.setUrl(tablistBean.getUrl());
                                        alllist.add(alllistBean1);
                                        tablist.remove(i);
                                        adapterFarmentChina.notifyDataSetChanged();
                                    }
                            }
                        }

                    });
                    as=false;
                }else{
                    Chinabianji.setText("编辑");
                    gridlayout_undrageable.setOnItemClickLitener(new MyGridLayout.OnItemClickLitener() {
                        @Override
                        public void OnItemClickLitener(String strItem, View v) {
//                                    gridlayout_undrageable.removeView(v);
//                                    gridlayout_drageable.addTvItem(strItem);
                        }
                    });
//点击上部，移除一个item在第二个里面添加一个item
                    gridlayout_drageable.setOnItemClickLitener(new MyGridLayout.OnItemClickLitener() {
                        @Override
                        public void OnItemClickLitener(String strItem, View v) {

//                                    gridlayout_drageable.removeView(v);
//                                    gridlayout_undrageable.addTvItem(strItem);

                        }
                    });
                    as=true;
                }
            }
        });
        guanbi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                popupWindow.dismiss();
            }
        });
    }



}
