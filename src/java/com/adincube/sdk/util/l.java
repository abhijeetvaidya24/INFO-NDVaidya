/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.Resources
 *  android.graphics.Bitmap
 *  android.graphics.drawable.BitmapDrawable
 *  android.graphics.drawable.Drawable
 *  java.lang.Object
 */
package com.adincube.sdk.util;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import com.adincube.sdk.util.b.j;

public final class l {
    public static Drawable a(Context context, Bitmap bitmap) {
        if (bitmap == null) {
            return null;
        }
        float f2 = j.d(context) / (float)(bitmap.getDensity() / 160);
        BitmapDrawable bitmapDrawable = new BitmapDrawable(context.getResources(), bitmap);
        bitmapDrawable.setBounds(0, 0, (int)(f2 * (float)bitmap.getHeight()), (int)(f2 * (float)bitmap.getWidth()));
        return bitmapDrawable;
    }
}

