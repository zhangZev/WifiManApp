package com.wanzhong.core.entity;

import android.graphics.Bitmap;

import java.io.Serializable;

public abstract class ShareContent implements Serializable {
    public abstract int getShareWay();

    public abstract String getContent();

    public abstract String getTitle();

    public abstract void setTitle(String title);

    public abstract String getURL();

    public abstract int getPictureResource();

    public abstract Bitmap getBitmap();



}
