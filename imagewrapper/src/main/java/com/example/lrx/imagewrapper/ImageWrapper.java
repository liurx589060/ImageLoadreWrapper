package com.example.lrx.imagewrapper;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.support.v4.app.FragmentActivity;
import android.util.Log;

/**
 * Created by liurunxiong on 2017/3/7.
 */

public class ImageWrapper {
    public static AbsImageLoader imageLoader;

    public static ImageWrapper imageWrapper;

    public static final String TAG = "ImageWrapper";

    public ImageWrapper() {
    }

    public static void init(AbsImageLoader excute) {
        imageLoader = excute;
    }

    /**
     * 单例获取
     */
    public static ImageWrapper getInstance() {
        try{
            if(imageLoader == null) {
                throw new NullPointerException();
            }
        }catch (Exception e) {
            Log.e(TAG,"请调用init方法");
        }

        if(imageWrapper == null) {
            imageWrapper = new ImageWrapper();
        }
        return imageWrapper;
    }

    private <T> ImageParams withBase(T context) {
        ImageParams params = new ImageParams<T>(context);
        params.setImageLoader(imageLoader);
        return params;
    }

    public ImageParams with(Context context) {
        return  withBase((Context)context);
    }

    public ImageParams with(Activity context) {
        return  withBase((Activity) context);
    }

    public ImageParams with(Fragment context) {
        return  withBase((Fragment) context);
    }

    public ImageParams with(FragmentActivity context) {
        return  withBase((FragmentActivity) context);
    }
}
