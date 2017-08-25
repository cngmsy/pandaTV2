package com.example.lenovo.ceshifubiao;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import java.util.ArrayList;

import static android.view.View.GONE;
import static android.view.View.VISIBLE;
import static com.example.lenovo.ceshifubiao.R.id.recy;

public class MainActivity extends AppCompatActivity {
    private boolean mFlag=true;
    private ImageView jia;
    private TabLayout home_tab;
    private ViewPager viewp;
    private MyGridLayout gridlayout_drageable;
    private MyGridLayout gridlayout_undrageable;
    private LinearLayout mGridLayout_ll;
    private ArrayList<String> list1;
    private ArrayList<String> list2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }
    private void initView() {
        mGridLayout_ll = (LinearLayout)findViewById(R.id.gridlayout_ll);
        jia = (ImageView) findViewById(R.id.jia);
        home_tab = (TabLayout) findViewById(R.id.home_tab);
        viewp = (ViewPager) findViewById(R.id.viewp);
        gridlayout_drageable = (MyGridLayout) findViewById(R.id.gridlayout_drageable);
        gridlayout_undrageable = (MyGridLayout) findViewById(R.id.gridlayout_undrageable);
        jia.setImageResource(R.mipmap.ic_subscribe);
        jia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View view) {
                if (mFlag) {
                    mGridLayout_ll.setVisibility(VISIBLE);
                    home_tab.setVisibility(GONE);
                    mFlag = false;
                } else {
                    home_tab.setVisibility(VISIBLE);
                    mGridLayout_ll.setVisibility(GONE);

                    mFlag = true;
                }
            }
        });
        //初始化gridViewlayout
        initGridLayout();
        //点击下部，移除一个item在第一个里面添加一个item
        gridlayout_undrageable.setOnItemClickLitener(new MyGridLayout.OnItemClickLitener() {
            @Override
            public void OnItemClickLitener(String strItem, View v) {
                gridlayout_undrageable.removeView(v);
                gridlayout_drageable.addTvItem(strItem);
            }
        });
//点击上部，移除一个item在第二个里面添加一个item
        gridlayout_drageable.setOnItemClickLitener(new MyGridLayout.OnItemClickLitener() {
            @Override
            public void OnItemClickLitener(String strItem, View v) {

                gridlayout_drageable.removeView(v);
                gridlayout_undrageable.addTvItem(strItem);

            }
        });
    }
    private void initGridLayout() {
        gridlayout_drageable.setGridLayoutItemDrageAble(true);
        list1 = new ArrayList<String>();
        list1.add("开源资讯");
        list1.add("推荐博客");
        list1.add("技术问答");
        list1.add("每日一博");
        list1.add("编程语言");
        list1.add("软件工程");
        list1.add("云计算");
        list1.add("开源访谈");

        gridlayout_drageable.addItems(list1);

        gridlayout_undrageable.setGridLayoutItemDrageAble(false);
        list2 = new ArrayList<String>();
        list2.add("站务建议");
        list2.add("职业生涯");
        list2.add("技术问答");
        list2.add("前端开发");
        list2.add("技术分享");
        list2.add("软件工程");
        list2.add("最新软件");
        list2.add("高手问答");
        list2.add("开源硬件");
        list2.add("移动开发");
        list2.add("码云推荐");
        gridlayout_undrageable.addItems(list2);
    }
}
