package com.example.lrx.imageloadrewrapper;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;

import com.example.lrx.imagewrapper.AbsImageLoader;
import com.example.lrx.imagewrapper.ImageLoadedListener;
import com.example.lrx.imagewrapper.ImageParams;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.core.assist.FailReason;
import com.nostra13.universalimageloader.core.assist.ImageScaleType;
import com.nostra13.universalimageloader.core.display.FadeInBitmapDisplayer;
import com.nostra13.universalimageloader.core.display.RoundedBitmapDisplayer;
import com.nostra13.universalimageloader.core.listener.ImageLoadingListener;

/**
 * Created by liurunxiong on 2017/3/8.
 */

public class UniversalImageLoader extends AbsImageLoader {
    public DisplayImageOptions options;

    public UniversalImageLoader(Context context) {
        ImageLoader.getInstance().init(ImageLoaderConfiguration.createDefault(context));

        options = new DisplayImageOptions.Builder()
                .showImageOnLoading(R.mipmap.ic_launcher) //设置图片在下载期间显示的图片
                .showImageForEmptyUri(R.mipmap.ic_launcher)//设置图片Uri为空或是错误的时候显示的图片
                .showImageOnFail(R.mipmap.ic_launcher)  //设置图片加载/解码过程中错误时候显示的图片
                .cacheInMemory(true)//设置下载的图片是否缓存在内存中
                .cacheOnDisc(true)//设置下载的图片是否缓存在SD卡中
                .considerExifParams(true)  //是否考虑JPEG图像EXIF参数（旋转，翻转）
                .imageScaleType(ImageScaleType.EXACTLY_STRETCHED)//设置图片以如何的编码方式显示
                .bitmapConfig(Bitmap.Config.RGB_565)//设置图片的解码类型//
                //.resetViewBeforeLoading(true)//设置图片在下载前是否重置，复位
                .displayer(new RoundedBitmapDisplayer(20))//是否设置为圆角，弧度为多少
                .displayer(new FadeInBitmapDisplayer(100))//是否图片加载好后渐入的动画时间
                .build();//构建完成
    }

    @Override
    public void setImage(ImageParams params) {
        ImageLoader.getInstance().displayImage(params.url,params.imageView,options);
    }

    @Override
    public void downImage(ImageParams params, final ImageLoadedListener listener) {
        super.downImage(params, listener);
        ImageLoader.getInstance().loadImage(params.url, new ImageLoadingListener() {
            @Override
            public void onLoadingStarted(String s, View view) {

            }

            @Override
            public void onLoadingFailed(String s, View view, FailReason failReason) {

            }

            @Override
            public void onLoadingComplete(String s, View view, Bitmap bitmap) {
                if(listener != null) {
                    listener.imageLoaded(bitmap,s);
                }
            }

            @Override
            public void onLoadingCancelled(String s, View view) {

            }
        });
    }
}
