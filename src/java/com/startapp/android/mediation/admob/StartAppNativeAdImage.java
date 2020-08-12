/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.Resources
 *  android.graphics.Bitmap
 *  android.graphics.drawable.BitmapDrawable
 *  android.graphics.drawable.Drawable
 *  android.net.Uri
 *  com.google.android.gms.ads.formats.NativeAd
 *  com.google.android.gms.ads.formats.NativeAd$Image
 *  java.lang.String
 */
package com.startapp.android.mediation.admob;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import com.google.android.gms.ads.formats.NativeAd;

public class StartAppNativeAdImage
extends NativeAd.Image {
    private Bitmap bitmap;
    private Context context;
    private String uri;

    public StartAppNativeAdImage(Context context, Bitmap bitmap, String string) {
        this.context = context;
        this.bitmap = bitmap;
        this.uri = string;
    }

    public Drawable getDrawable() {
        return new BitmapDrawable(this.context.getResources(), this.bitmap);
    }

    public double getScale() {
        return 1.0;
    }

    public Uri getUri() {
        return Uri.parse((String)this.uri);
    }
}

