package com.jiyun.qcloud.dashixummoban.ui.web2.imageloder;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.BitmapDrawable;

public class URLDrawable extends BitmapDrawable {
    protected Bitmap bitmap;

    @Override
    public void draw(Canvas canvas) {
        if (bitmap != null) {
            canvas.drawBitmap(bitmap, getBounds().left, getBounds().top, getPaint());
        }
    }
}
