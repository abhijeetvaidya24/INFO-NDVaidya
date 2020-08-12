/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.graphics.drawable.Drawable
 *  android.os.Build
 *  android.os.Build$VERSION
 *  android.os.Handler
 *  android.os.Looper
 *  android.view.ViewGroup
 *  android.view.ViewGroup$LayoutParams
 *  android.widget.Button
 *  android.widget.RelativeLayout
 *  android.widget.RelativeLayout$LayoutParams
 *  java.lang.CharSequence
 *  java.lang.Exception
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.String
 */
package com.aerserv.sdk.view.component;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;
import com.aerserv.sdk.utils.AerServLog;
import com.aerserv.sdk.utils.DisplayUtils;

public final class CloseButton
extends Button {
    private static final String LOG_TAG = "com.aerserv.sdk.view.component.CloseButton";
    private Drawable background;
    public final int size = DisplayUtils.convertDipToPx(super.getContext(), 50);

    public CloseButton(Context context) {
        super(context);
        this.setWidth(this.size);
        this.setHeight(this.size);
        int n2 = this.size;
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(n2, n2);
        this.setText((CharSequence)"X");
        this.background = this.getBackground();
        this.setGravity(17);
        layoutParams.addRule(11);
        layoutParams.addRule(10);
        this.setLayoutParams((ViewGroup.LayoutParams)layoutParams);
    }

    public void setVisibility(final boolean bl) {
        Runnable runnable = new Runnable(){

            public void run() {
                try {
                    if (bl) {
                        CloseButton.this.setText((CharSequence)"X");
                        if (Build.VERSION.SDK_INT < 16) {
                            CloseButton.this.setBackgroundDrawable(CloseButton.this.background);
                            return;
                        }
                        CloseButton.this.setBackground(CloseButton.this.background);
                        return;
                    }
                    CloseButton.this.setText((CharSequence)"");
                    CloseButton.this.setBackgroundColor(0);
                    return;
                }
                catch (Exception exception) {
                    AerServLog.e(LOG_TAG, "Exception caught", exception);
                    return;
                }
            }
        };
        new Handler(Looper.getMainLooper()).post(runnable);
    }

}

