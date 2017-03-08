package com.example.lrx.imagewrapper;

import android.graphics.Bitmap;

/**
 * Created by liurunxiong on 2017/3/7.
 */

public abstract class AbsImageLoader {
    //加载图片并设置图片到控件
    public abstract void setImage(ImageParams params);

    //单纯加载图片并有Bitmap类返回
    public void downImage(ImageParams params,ImageLoadedListener listener) {};
}
