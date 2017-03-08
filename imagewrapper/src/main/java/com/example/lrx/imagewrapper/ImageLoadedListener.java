package com.example.lrx.imagewrapper;

import android.graphics.Bitmap;

/**
 * Created by liurunxiong on 2017/3/8.
 */

public abstract class ImageLoadedListener {
    //单纯下载图片并返回Bitmap类
    public abstract void imageLoaded(Bitmap bitmap,String url);

    //单纯下载图片前
    public void beforImageLoad(String url) {};

    //单纯下载图片失败
    public void ImageLoadFailed(String url,String failMessage) {};

    //单纯下载图片取消
    public void ImageLoadCancel(String url) {};
}
