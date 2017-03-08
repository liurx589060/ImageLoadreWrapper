package com.example.lrx.imageloadrewrapper;

import android.app.Activity;
import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.lrx.imagewrapper.AbsImageLoader;
import com.example.lrx.imagewrapper.GlideImageLoader;
import com.example.lrx.imagewrapper.ImageLoadedListener;
import com.example.lrx.imagewrapper.ImageParams;
import com.example.lrx.imagewrapper.ImageWrapper;

import jp.wasabeef.glide.transformations.CropCircleTransformation;

public class MainActivity extends AppCompatActivity {

    String url = "http://img4.duitang.com/uploads/item/201307/18/20130718171017_CdByt.jpeg";

    String gifUrl = "http://static2.photo.sina.com.cn/bmiddle/4f0d32e4g57ca130148d1";

    private ImageView mImageView;
    private ImageView mImageView2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        ImageWrapper.init(new GlideImageLoader());

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mImageView = (ImageView) findViewById(R.id.imageView);
        mImageView2 = (ImageView) findViewById(R.id.imageView2);

//        ImageWrapper.getInstance().with(this)
//        .setUrl(url)
//        .setImageView(mImageView, new AbsImageLoader() {
//            @Override
//            public void setImage(ImageParams params) {
//                Glide.with((Activity) params.mContext)
//                        .load(url)
//                        .crossFade(3000)
//                        .into(mImageView);
//            }
//
//            @Override
//            public void downImage() {
//
//            }
//        });

//        ImageWrapper.getInstance().with(this)
//                //.setUrl("http://img1.gtimg.com/sports/pics/hv1/195/203/689/44854185.jpg")
//                .setUrl(gifUrl)
//                .setImageView(mImageView);

        ImageWrapper.getInstance().with(this)
                .downImage(url, new ImageLoadedListener() {
                    @Override
                    public void imageLoaded(Bitmap bitmap, String url) {
                        Log.e("yy",url);
                        mImageView.setImageBitmap(bitmap);
                    }
                });

        ImageWrapper.getInstance().with(this)
                .setImageView(mImageView2, new AbsImageLoader() {
                    @Override
                    public void setImage(ImageParams params) {
                        Glide.with((Activity) params.mContext)
                        .load(url).bitmapTransform(new CropCircleTransformation((Activity)params.mContext))
                        .crossFade(3000)
                        .into(params.imageView);
                    }
                });
    }
}
