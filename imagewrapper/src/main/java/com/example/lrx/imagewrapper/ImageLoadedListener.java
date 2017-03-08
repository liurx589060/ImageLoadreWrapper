package com.example.lrx.imagewrapper;

import android.graphics.Bitmap;

/**
 * Created by liurunxiong on 2017/3/8.
 */

public abstract class ImageLoadedListener {
    //单纯下载图片并返回Bitmap类
    public abstract void imageLoaded(Bitmap bitmap,String url);
}
