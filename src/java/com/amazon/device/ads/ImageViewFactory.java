/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.Resources
 *  android.graphics.drawable.BitmapDrawable
 *  android.widget.ImageView
 *  java.lang.Object
 *  java.lang.String
 */
package com.amazon.device.ads;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.BitmapDrawable;
import android.widget.ImageView;

interface ImageViewFactory {
    public BitmapDrawable createBitmapDrawable(Resources var1, String var2);

    public ImageView createImageView(Context var1, String var2);
}

