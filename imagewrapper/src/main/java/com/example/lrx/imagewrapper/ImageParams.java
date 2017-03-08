package com.example.lrx.imagewrapper;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import java.io.File;

/**
 * Created by liurunxiong on 2017/3/7.
 */

public class ImageParams<T> {
    public T mContext;
    public String url;
    public int placeholder;
    public ImageView imageView;
    public AbsImageLoader imageLoader;

    public int resId = -1;
    public File resFile;

    public ImageParams() {

    }

    public ImageParams(T context) {
        this.mContext = context;
    }

    public void setmContext(T context) {
        this.mContext = context;
    }

    public ImageParams setUrl(String url) {
        this.url = url;
        return this;
    }

    public ImageParams setPlaceholder(int resId) {
        this.placeholder = resId;
        return this;
    }

    public void setImageView(ImageView img) {
        this.imageView = img;
        if(imageLoader != null && this.imageView != null) {
            imageLoader.setImage(this);
        }
    }

    public void setImageView(ImageView img,AbsImageLoader imageLoader) {
        this.imageView = img;
        if(imageLoader != null) {
            imageLoader.setImage(this);
        }
    }

    public ImageParams setImageLoader(AbsImageLoader abs) {
        this.imageLoader = abs;
        return this;
    }

    public ImageParams setResId(int resId) {
        this.resId = resId;
        return this;
    }

    public ImageParams setResFile(File resFile) {
        this.resFile = resFile;
        return this;
    }

    public void downImage(ImageLoadedListener listener) {
        if(imageLoader != null) {
            imageLoader.downImage(this,listener);
        }
    }

    public void downImage(String url,ImageLoadedListener listener) {
        if(imageLoader != null) {
            this.setUrl(url);
            imageLoader.downImage(this,listener);
        }
    }
}
