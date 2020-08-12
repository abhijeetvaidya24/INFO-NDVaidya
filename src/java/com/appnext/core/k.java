/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.Resources
 *  android.graphics.Bitmap
 *  android.graphics.drawable.BitmapDrawable
 *  android.graphics.drawable.Drawable
 *  android.os.Handler
 *  android.os.Looper
 *  android.widget.ImageView
 *  com.appnext.core.AppnextAd
 *  java.lang.Boolean
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.String
 *  java.lang.Thread
 *  java.lang.Throwable
 */
package com.appnext.core;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.widget.ImageView;
import com.appnext.core.AppnextAd;
import com.appnext.core.R;
import com.appnext.core.f;
import com.appnext.core.p;

public final class k {
    public static void a(final Context context, final ImageView imageView) {
        new Thread(new Runnable(){

            public final void run() {
                try {
                    final Bitmap bitmap = f.Z("https://cdn.appnext.com/tools/sdk/adchoices/adchoices_big.png");
                    new Handler(Looper.getMainLooper()).post(new Runnable(){

                        public final void run() {
                            try {
                                if (bitmap != null) {
                                    BitmapDrawable bitmapDrawable = new BitmapDrawable(context.getResources(), bitmap);
                                    imageView.setImageDrawable((Drawable)bitmapDrawable);
                                    return;
                                }
                                imageView.setImageResource(R.drawable.apnxt_adchoices);
                            }
                            catch (Throwable throwable) {}
                        }
                    });
                    return;
                }
                catch (Throwable throwable) {
                    new Handler(Looper.getMainLooper()).post(new Runnable(){

                        public final void run() {
                            imageView.setImageResource(R.drawable.apnxt_adchoices);
                        }
                    });
                    return;
                }
            }

        }).start();
    }

    public static boolean a(AppnextAd appnextAd, p p2) {
        return appnextAd.isGdpr() && Boolean.parseBoolean((String)p2.get("gdpr"));
    }

}

