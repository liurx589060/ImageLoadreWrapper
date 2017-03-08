package com.example.lrx.imagewrapper;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.support.v4.app.FragmentActivity;

import com.bumptech.glide.DrawableTypeRequest;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestManager;

/**
 * Created by liurunxiong on 2017/3/7.
 */

public class GlideImageLoader extends AbsImageLoader {

    @Override
    public void setImage(ImageParams params) {
        RequestManager manager = null;
        if(params.mContext instanceof Activity) {
            manager = Glide.with((Activity)params.mContext);
        }else if (params.mContext instanceof Context) {
            manager = Glide.with((Context) params.mContext);
        }else if (params.mContext instanceof Fragment) {
            manager = Glide.with((Fragment) params.mContext);
        }else if (params.mContext instanceof FragmentActivity) {
            manager = Glide.with((FragmentActivity) params.mContext);
        }

        DrawableTypeRequest drawableTypeRequest = null;
        if(params.url != null) {
           drawableTypeRequest = manager.load(params.url);
        }

        if(params.resId != -1) {
            drawableTypeRequest = manager.load(params.resId);
        }

        if(params.resFile != null) {
            drawableTypeRequest = manager.load(params.resFile);
        }

        if(drawableTypeRequest != null) {
            drawableTypeRequest.into(params.imageView);
        }
    }

    @Override
    public void downImage() {

    }
}
