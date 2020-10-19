package com.wanzhong.core.utils;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.text.TextUtils;
import android.widget.ImageView;

import androidx.core.graphics.drawable.RoundedBitmapDrawable;
import androidx.core.graphics.drawable.RoundedBitmapDrawableFactory;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.resource.drawable.GlideDrawable;
import com.bumptech.glide.request.animation.GlideAnimation;
import com.bumptech.glide.request.target.BitmapImageViewTarget;
import com.bumptech.glide.request.target.SimpleTarget;
import com.lzy.imagepicker.loader.ImageLoader;
import com.makeramen.roundedimageview.RoundedImageView;
import com.wanzhong.common.util.StringUtil;
import com.wanzhong.core.R;
import com.wanzhong.core.view.GlideCircleTransform;
import com.wanzhong.core.view.GlideRoundTransform;

import java.io.File;

public class GlideImageLoader implements ImageLoader {

    public static GlideImageLoader newInstance() {
        GlideImageLoader fragment = new GlideImageLoader();
        return fragment;
    }

    /**
     * 加载图片
     *
     * @param url       地址
     * @param imageView 控件
     */
    public void setImageurl(Context context, int url, ImageView imageView) {
        Glide.with(context).load(url)
                .placeholder(R.drawable.img_detault)
                .error(R.drawable.img_detault)
                .diskCacheStrategy(DiskCacheStrategy.ALL)//缓存全尺寸
                .into(imageView);
    }

    private int getDefaultImg(int default_img) {
        return default_img > 0 ? default_img : R.drawable.img_detault;
    }

    public void setImageurl(Context context, String url, ImageView imageView, int default_img) {
        if (StringUtil.isNullOrSpace(url)) {
            Glide.with(context).load(getDefaultImg(default_img))
                    .placeholder(getDefaultImg(default_img))
                    .error(getDefaultImg(default_img))
                    .diskCacheStrategy(DiskCacheStrategy.ALL)//缓存全尺寸
                    .into(new SimpleTarget<GlideDrawable>() {
                        @Override
                        public void onResourceReady(GlideDrawable glideDrawable, GlideAnimation<? super GlideDrawable> glideAnimation) {
                            imageView.setImageDrawable(glideDrawable); //显示图片
                        }
                    });
            return;
        }
        if (url.startsWith("http")) {
            Glide.with(context).load(url)
                    .placeholder(getDefaultImg(default_img))
                    .error(getDefaultImg(default_img))
                    .diskCacheStrategy(DiskCacheStrategy.ALL)//缓存全尺寸
                    .into(new SimpleTarget<GlideDrawable>() {
                        @Override
                        public void onLoadFailed(Exception e, Drawable errorDrawable) {
                            super.onLoadFailed(e, errorDrawable);
                            Glide.with(context).load(getDefaultImg(default_img))
                                    .placeholder(getDefaultImg(default_img))
                                    .error(getDefaultImg(default_img))
                                    .diskCacheStrategy(DiskCacheStrategy.ALL)//缓存全尺寸
                                    .into(new SimpleTarget<GlideDrawable>() {
                                        @Override
                                        public void onResourceReady(GlideDrawable glideDrawable, GlideAnimation<? super GlideDrawable> glideAnimation) {
                                            imageView.setImageDrawable(glideDrawable); //显示图片
                                        }
                                    });
                        }

                        @Override
                        public void onResourceReady(GlideDrawable glideDrawable, GlideAnimation<? super GlideDrawable> glideAnimation) {
                            imageView.setImageDrawable(glideDrawable); //显示图片
                        }
                    });
        } else {
            Glide.with(context).load(Uri.fromFile(new File(url)))
                    .placeholder(getDefaultImg(default_img))
                    .error(getDefaultImg(default_img))
                    .diskCacheStrategy(DiskCacheStrategy.ALL)//缓存全尺寸
                    .into(new SimpleTarget<GlideDrawable>() {
                        @Override
                        public void onLoadFailed(Exception e, Drawable errorDrawable) {
                            super.onLoadFailed(e, errorDrawable);
                            Glide.with(context).load(getDefaultImg(default_img))
                                    .placeholder(getDefaultImg(default_img))
                                    .error(getDefaultImg(default_img))
                                    .diskCacheStrategy(DiskCacheStrategy.ALL)//缓存全尺寸
                                    .into(new SimpleTarget<GlideDrawable>() {
                                        @Override
                                        public void onResourceReady(GlideDrawable glideDrawable, GlideAnimation<? super GlideDrawable> glideAnimation) {
                                            imageView.setImageDrawable(glideDrawable); //显示图片
                                        }
                                    });
                        }
                        @Override
                        public void onResourceReady(GlideDrawable glideDrawable, GlideAnimation<? super GlideDrawable> glideAnimation) {
                            imageView.setImageDrawable(glideDrawable); //显示图片
                        }
                    });
        }
    }


    public void setImageurlWithbad(Context context, String url, ImageView imageView, int default_img) {
        if (StringUtil.isNullOrSpace(url)) {
            Glide.with(context).load(getDefaultImg(default_img))
                    .placeholder(getDefaultImg(default_img))
                    .error(getDefaultImg(default_img))
                    .diskCacheStrategy(DiskCacheStrategy.ALL)//缓存全尺寸
                    .into(new SimpleTarget<GlideDrawable>() {
                        @Override
                        public void onResourceReady(GlideDrawable glideDrawable, GlideAnimation<? super GlideDrawable> glideAnimation) {
                            if(imageView.getTag().equals(url)){
                                imageView.setImageDrawable(glideDrawable); //显示图片
                            }
                        }
                    });
            return;
        }
        if (url.startsWith("http")) {
            Glide.with(context).load(url)
                    .placeholder(getDefaultImg(default_img))
                    .error(getDefaultImg(default_img))
                    .diskCacheStrategy(DiskCacheStrategy.ALL)//缓存全尺寸
                    .into(new SimpleTarget<GlideDrawable>() {
                        @Override
                        public void onLoadFailed(Exception e, Drawable errorDrawable) {
                            super.onLoadFailed(e, errorDrawable);
                            Glide.with(context).load(getDefaultImg(default_img))
                                    .placeholder(getDefaultImg(default_img))
                                    .error(getDefaultImg(default_img))
                                    .diskCacheStrategy(DiskCacheStrategy.ALL)//缓存全尺寸
                                    .into(new SimpleTarget<GlideDrawable>() {
                                        @Override
                                        public void onResourceReady(GlideDrawable glideDrawable, GlideAnimation<? super GlideDrawable> glideAnimation) {
                                            imageView.setImageDrawable(glideDrawable); //显示图片
                                        }
                                    });
                        }

                        @Override
                        public void onResourceReady(GlideDrawable glideDrawable, GlideAnimation<? super GlideDrawable> glideAnimation) {
                            if(imageView.getTag().equals(url)) {
                                imageView.setImageDrawable(glideDrawable); //显示图片
                            }
                        }
                    });
        } else {
            Glide.with(context).load(Uri.fromFile(new File(url)))
                    .placeholder(getDefaultImg(default_img))
                    .error(getDefaultImg(default_img))
                    .diskCacheStrategy(DiskCacheStrategy.ALL)//缓存全尺寸
                    .into(new SimpleTarget<GlideDrawable>() {
                        @Override
                        public void onLoadFailed(Exception e, Drawable errorDrawable) {
                            super.onLoadFailed(e, errorDrawable);
                            Glide.with(context).load(getDefaultImg(default_img))
                                    .placeholder(getDefaultImg(default_img))
                                    .error(getDefaultImg(default_img))
                                    .diskCacheStrategy(DiskCacheStrategy.ALL)//缓存全尺寸
                                    .into(new SimpleTarget<GlideDrawable>() {
                                        @Override
                                        public void onResourceReady(GlideDrawable glideDrawable, GlideAnimation<? super GlideDrawable> glideAnimation) {
                                            imageView.setImageDrawable(glideDrawable); //显示图片
                                        }
                                    });
                        }
                        @Override
                        public void onResourceReady(GlideDrawable glideDrawable, GlideAnimation<? super GlideDrawable> glideAnimation) {
                            if(imageView.getTag().equals(url)) {
                                imageView.setImageDrawable(glideDrawable); //显示图片
                            }
                        }
                    });
        }
    }
    /**
     * 加载图片
     *
     * @param url       地址
     * @param imageView 控件
     */
    public void setImageurl(Context context, String url, ImageView imageView) {
        setImageurl(context, url, imageView, 0);
    }

   /* public void setImageurlWithPis(Context context, String url, RoundedImageView imageView) {
        Transformation transformation = new RoundedTransformationBuilder()
                .cornerRadiusDp(30)
                .oval(false)
                .build();

        Picasso.with(context)
                .load(url)
                .fit()
                .transform(transformation)
                .into(imageView);
    }*/

    /**
     * 加载图片
     *
     * @param url       地址
     * @param imageView 控件
     */
    public void setImageurl(Context context, String url, RoundedImageView imageView) {
        if (url.startsWith("http")) {
            Glide.with(context).load(url)
                    .placeholder(R.drawable.img_detault)
                    .error(R.drawable.img_detault)
                    .diskCacheStrategy(DiskCacheStrategy.ALL)//缓存全尺寸
                    .into(imageView);
        } else {
            Glide.with(context).load(Uri.fromFile(new File(url)))
                    .placeholder(R.drawable.img_detault)
                    .error(R.drawable.img_detault)
                    .diskCacheStrategy(DiskCacheStrategy.ALL)//缓存全尺寸
                    .into(imageView);
        }

    }

    public void setCircleImageurl(Context context, String url, final ImageView imageView, int default_img) {
        if (StringUtil.isNullOrSpace(url)) {
            Glide.with(context).load(getDefaultImg(default_img))
                    .transform(new GlideCircleTransform(context))
                    .placeholder(getDefaultImg(default_img))
                    .error(getDefaultImg(default_img))
                    .diskCacheStrategy(DiskCacheStrategy.ALL)//缓存全尺寸
                    .into(new SimpleTarget<GlideDrawable>() {
                        @Override
                        public void onResourceReady(GlideDrawable glideDrawable, GlideAnimation<? super GlideDrawable> glideAnimation) {
                            imageView.setImageDrawable(glideDrawable); //显示图片
                        }
                    });
            return;
        }
        if (url.startsWith("http")) {
            Glide.with(context).load(url)
                    .transform(new GlideCircleTransform(context))
                    .placeholder(getDefaultImg(default_img))
                    .error(getDefaultImg(default_img))
                    .diskCacheStrategy(DiskCacheStrategy.ALL)//缓存全尺寸
                    .into(new SimpleTarget<GlideDrawable>() {
                        @Override
                        public void onLoadFailed(Exception e, Drawable errorDrawable) {
                            super.onLoadFailed(e, errorDrawable);
                            Glide.with(context).load(getDefaultImg(default_img))
                                    .transform(new GlideCircleTransform(context))
                                    .placeholder(getDefaultImg(default_img))
                                    .error(getDefaultImg(default_img))
                                    .diskCacheStrategy(DiskCacheStrategy.ALL)//缓存全尺寸
                                    .into(new SimpleTarget<GlideDrawable>() {
                                        @Override
                                        public void onResourceReady(GlideDrawable glideDrawable, GlideAnimation<? super GlideDrawable> glideAnimation) {
                                            imageView.setImageDrawable(glideDrawable); //显示图片
                                        }
                                    });
                        }
                        @Override
                        public void onResourceReady(GlideDrawable glideDrawable, GlideAnimation<? super GlideDrawable> glideAnimation) {
                            imageView.setImageDrawable(glideDrawable); //显示图片
                        }
                    });
        } else {
            Glide.with(context).load(Uri.fromFile(new File(url)))
                    .transform(new GlideCircleTransform(context))
                    .placeholder(getDefaultImg(default_img))
                    .error(getDefaultImg(default_img))
                    .diskCacheStrategy(DiskCacheStrategy.ALL)//缓存全尺寸
                    .into(new SimpleTarget<GlideDrawable>() {
                        @Override
                        public void onLoadFailed(Exception e, Drawable errorDrawable) {
                            super.onLoadFailed(e, errorDrawable);
                            Glide.with(context).load(getDefaultImg(default_img))
                                    .transform(new GlideCircleTransform(context))
                                    .placeholder(getDefaultImg(default_img))
                                    .error(getDefaultImg(default_img))
                                    .diskCacheStrategy(DiskCacheStrategy.ALL)//缓存全尺寸
                                    .into(new SimpleTarget<GlideDrawable>() {
                                        @Override
                                        public void onResourceReady(GlideDrawable glideDrawable, GlideAnimation<? super GlideDrawable> glideAnimation) {
                                            imageView.setImageDrawable(glideDrawable); //显示图片
                                        }
                                    });
                        }
                        @Override
                        public void onResourceReady(GlideDrawable glideDrawable, GlideAnimation<? super GlideDrawable> glideAnimation) {
                            imageView.setImageDrawable(glideDrawable); //显示图片
                        }
                    });
        }
    }

    /**
     * 加载圆形图片
     *
     * @param url       地址
     * @param imageView 控件
     */
    public void setCircleImageurl(Context context, String url, final ImageView imageView) {
        setCircleImageurl(context, url, imageView, 0);
    }

    public void setRoundedCornersImageurl(Context context, String url, final ImageView imageView, int default_img) {
        if (StringUtil.isNullOrSpace(url)) {
            Glide.with(context).load(getDefaultImg(default_img))
                    .transform(new GlideRoundTransform(context))
                    .placeholder(getDefaultImg(default_img))
                    .error(getDefaultImg(default_img))
                    .diskCacheStrategy(DiskCacheStrategy.ALL)//缓存全尺寸
                    .into(new SimpleTarget<GlideDrawable>() {
                        @Override
                        public void onResourceReady(GlideDrawable glideDrawable, GlideAnimation<? super GlideDrawable> glideAnimation) {
                            imageView.setImageDrawable(glideDrawable); //显示图片
                        }
                    });
            return;
        }
        //设置图片圆角角度
        if (url.startsWith("http")) {
            Glide.with(context).load(url)
                    .transform(new GlideRoundTransform(context))
                    .placeholder(getDefaultImg(default_img))
                    .error(getDefaultImg(default_img))
                    .diskCacheStrategy(DiskCacheStrategy.ALL)//缓存全尺寸
                    .into(new SimpleTarget<GlideDrawable>() {
                        @Override
                        public void onLoadFailed(Exception e, Drawable errorDrawable) {
                            super.onLoadFailed(e, errorDrawable);
                            Glide.with(context).load(getDefaultImg(default_img))
                                    .transform(new GlideRoundTransform(context))
                                    .placeholder(getDefaultImg(default_img))
                                    .error(getDefaultImg(default_img))
                                    .diskCacheStrategy(DiskCacheStrategy.ALL)//缓存全尺寸
                                    .into(new SimpleTarget<GlideDrawable>() {
                                        @Override
                                        public void onResourceReady(GlideDrawable glideDrawable, GlideAnimation<? super GlideDrawable> glideAnimation) {
                                            imageView.setImageDrawable(glideDrawable); //显示图片
                                        }
                                    });
                        }
                        @Override
                        public void onResourceReady(GlideDrawable glideDrawable, GlideAnimation<? super GlideDrawable> glideAnimation) {
                            imageView.setImageDrawable(glideDrawable); //显示图片
                        }
                    });
        } else {
            Glide.with(context).load(Uri.fromFile(new File(url)))
                    .transform(new GlideRoundTransform(context))
                    .placeholder(getDefaultImg(default_img))
                    .error(getDefaultImg(default_img))
                    .diskCacheStrategy(DiskCacheStrategy.ALL)//缓存全尺寸
                    .into(new SimpleTarget<GlideDrawable>() {
                        @Override
                        public void onLoadFailed(Exception e, Drawable errorDrawable) {
                            super.onLoadFailed(e, errorDrawable);
                            Glide.with(context).load(getDefaultImg(default_img))
                                    .transform(new GlideRoundTransform(context))
                                    .placeholder(getDefaultImg(default_img))
                                    .error(getDefaultImg(default_img))
                                    .diskCacheStrategy(DiskCacheStrategy.ALL)//缓存全尺寸
                                    .into(new SimpleTarget<GlideDrawable>() {
                                        @Override
                                        public void onResourceReady(GlideDrawable glideDrawable, GlideAnimation<? super GlideDrawable> glideAnimation) {
                                            imageView.setImageDrawable(glideDrawable); //显示图片
                                        }
                                    });
                        }
                        @Override
                        public void onResourceReady(GlideDrawable glideDrawable, GlideAnimation<? super GlideDrawable> glideAnimation) {
                            imageView.setImageDrawable(glideDrawable); //显示图片
                        }
                    });
        }

    }

    /**
     * 加载圆形图片
     *
     * @param url       地址
     * @param imageView 控件
     */
    public void setRoundedCornersImageurl(Context context, String url, final ImageView imageView) {

    }


    /**
     * 加载GIF图片
     *
     * @param url       地址
     * @param imageView 控件
     */
    public void setGifImageurl(Context context, String url, ImageView imageView) {
        if (url.startsWith("http")) {
            Glide.with(context).load(Uri.fromFile(new File(url)))
                    .asGif()
                    .placeholder(R.drawable.img_detault)
                    .error(R.drawable.img_detault)
                    .diskCacheStrategy(DiskCacheStrategy.ALL)//缓存全尺寸
                    .into(imageView);
        } else {
            Glide.with(context).load(url)
                    .asGif()
                    .placeholder(R.drawable.img_detault)
                    .error(R.drawable.img_detault)
                    .diskCacheStrategy(DiskCacheStrategy.ALL)//缓存全尺寸
                    .into(imageView);
        }

    }

    public void displayImage(Context activity, Uri path, RoundedImageView imageView) {
        Glide.with(activity)                             //配置上下文
                .load(path)      //设置图片路径(fix #8,文件名包含%符号 无法识别和显示)
//                .error(R.drawable.img_detault)           //设置错误图片
//               .placeholder(R.drawable.img_detault)     //设置占位图片
                .diskCacheStrategy(DiskCacheStrategy.ALL)//缓存全尺寸
                .into(imageView);
    }

    @Override
    public void displayImage(Activity activity, String path, ImageView imageView, int width, int height) {
        if (path.startsWith("http")) {
            Glide.with(activity)                             //配置上下文
                    .load(path)      //设置图片路径(fix #8,文件名包含%符号 无法识别和显示)
                    .diskCacheStrategy(DiskCacheStrategy.ALL)//缓存全尺寸
                    .into(imageView);
        } else {
            Glide.with(activity)                             //配置上下文
                    .load(Uri.fromFile(new File(path)))      //设置图片路径(fix #8,文件名包含%符号 无法识别和显示)
                    .diskCacheStrategy(DiskCacheStrategy.ALL)//缓存全尺寸
                    .into(imageView);
        }

    }

    @Override
    public void displayImagePreview(Activity activity, String path, ImageView imageView, int width, int height) {
        if (path.startsWith("http")) {
            Glide.with(activity)                             //配置上下文
                    .load(path)      //设置图片路径(fix #8,文件名包含%符号 无法识别和显示)
                    .diskCacheStrategy(DiskCacheStrategy.ALL)//缓存全尺寸
                    .into(imageView);
        } else {
            Glide.with(activity)                             //配置上下文
                    .load(Uri.fromFile(new File(path)))      //设置图片路径(fix #8,文件名包含%符号 无法识别和显示)
                    .diskCacheStrategy(DiskCacheStrategy.ALL)//缓存全尺寸
                    .into(imageView);
        }

    }

    public Bitmap downloadBitmap(Context context, String url, int width, int height) {
        try {
            return Glide.with(context)
                    .load(url)
                    .asBitmap()
                    .into(width, height)
                    .get();
        } catch (Exception e) {

        }
        return null;
    }

    /**
     * 圆角图
     *
     * @param context
     * @param imageUrl
     * @param imageView
     * @param default_img
     */
    public void setCircleImage(Context context, String imageUrl, RoundedImageView imageView, int default_img) {
        Glide.with(context).load(imageUrl)
                .asBitmap()
                .placeholder(default_img)
                .error(default_img)
                .diskCacheStrategy(DiskCacheStrategy.ALL)//缓存全尺寸
                .into(new BitmapImageViewTarget(imageView) {
                    @Override
                    protected void setResource(Bitmap resource) {
                        super.setResource(resource);
                        RoundedBitmapDrawable circularBitmapDrawable =
                                RoundedBitmapDrawableFactory.create(context.getResources(), resource);
                        circularBitmapDrawable.setCornerRadius(6); //设置圆角弧度
                        imageView.setImageDrawable(circularBitmapDrawable);
                    }
                });
    }

    /**
     * 圆图
     *
     * @param context
     * @param imageUrl
     * @param imageView
     * @param default_img
     */
    public void setCircliImage(Context context, String imageUrl, ImageView imageView, int default_img) {
        if (imageUrl == null || TextUtils.isEmpty(imageUrl)) {
            Glide.with(context).load(default_img)
                    .transform(new GlideCircleTransform(context))
                    .placeholder(default_img)
                    .error(default_img)
                    .diskCacheStrategy(DiskCacheStrategy.ALL)//缓存全尺寸
                    .into(new SimpleTarget<GlideDrawable>() {
                        @Override
                        public void onResourceReady(GlideDrawable glideDrawable, GlideAnimation<? super GlideDrawable> glideAnimation) {
                            imageView.setImageDrawable(glideDrawable); //显示图片
                        }
                    });
        } else {
            Glide.with(context).load(imageUrl)
                    .transform(new GlideCircleTransform(context))
                    .placeholder(default_img)
                    .error(default_img)
                    .diskCacheStrategy(DiskCacheStrategy.ALL)//缓存全尺寸
                    .into(new SimpleTarget<GlideDrawable>() {
                        @Override
                        public void onLoadFailed(Exception e, Drawable errorDrawable) {
                            super.onLoadFailed(e, errorDrawable);
                            Glide.with(context).load(default_img)
                                    .transform(new GlideCircleTransform(context))
                                    .placeholder(default_img)
                                    .error(default_img)
                                    .diskCacheStrategy(DiskCacheStrategy.ALL)//缓存全尺寸
                                    .into(new SimpleTarget<GlideDrawable>() {
                                        @Override
                                        public void onResourceReady(GlideDrawable glideDrawable, GlideAnimation<? super GlideDrawable> glideAnimation) {
                                            imageView.setImageDrawable(glideDrawable); //显示图片
                                        }
                                    });
                        }
                        @Override
                        public void onResourceReady(GlideDrawable glideDrawable, GlideAnimation<? super GlideDrawable> glideAnimation) {
                            imageView.setImageDrawable(glideDrawable); //显示图片
                        }
                    });
        }
    }

    @Override
    public void clearMemoryCache() {
    }
}
