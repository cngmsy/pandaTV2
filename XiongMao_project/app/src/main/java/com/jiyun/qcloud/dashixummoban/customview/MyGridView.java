package com.jiyun.qcloud.dashixummoban.customview;


import android.content.Context;
import android.util.AttributeSet;
import android.widget.GridView;

/**
 * Created by ASUS on 2017/8/25.
 */

public class MyGridView extends GridView {

    public MyGridView(Context context) {
        super(context);
    }

    public MyGridView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MyGridView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int expandSpec = MeasureSpec.makeMeasureSpec(
                Integer.MAX_VALUE >> 2, MeasureSpec.AT_MOST);
        super.onMeasure(widthMeasureSpec, expandSpec);
    }
//    public void setHaveScrollbar(boolean haveScrollbar) {
//        this.haveScrollbar = haveScrollbar;
//    }
//    @Override
//    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
//        if (haveScrollbar == false) {
//            int expandSpec = MeasureSpec.makeMeasureSpec(Integer.MAX_VALUE >> 2, MeasureSpec.AT_MOST);
//            super.onMeasure(widthMeasureSpec, expandSpec);
//        } else {
//            super.onMeasure(widthMeasureSpec, heightMeasureSpec);
//        }
//    }
}
