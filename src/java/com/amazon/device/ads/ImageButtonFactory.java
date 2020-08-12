/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.Resources
 *  android.graphics.drawable.BitmapDrawable
 *  android.widget.ImageButton
 *  android.widget.ImageView
 *  java.lang.CharSequence
 *  java.lang.Object
 *  java.lang.String
 */
package com.amazon.device.ads;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.BitmapDrawable;
import android.widget.ImageButton;
import android.widget.ImageView;
import com.amazon.device.ads.ImageViewFactory;

class ImageButtonFactory
implements ImageViewFactory {
    ImageButtonFactory() {
    }

    @Override
    public BitmapDrawable createBitmapDrawable(Resources resources, String string) {
        return new BitmapDrawable(resources, string);
    }

    public ImageButton createImageView(Context context, String string) {
        ImageButton imageButton = new ImageButton(context);
        imageButton.setContentDescription((CharSequence)string);
        return imageButton;
    }
}

