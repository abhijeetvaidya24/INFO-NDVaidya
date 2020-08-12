/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.os.Handler
 *  android.os.Looper
 *  android.view.ViewGroup
 *  android.view.ViewGroup$LayoutParams
 *  android.widget.RelativeLayout
 *  android.widget.RelativeLayout$LayoutParams
 *  android.widget.TextView
 *  java.lang.CharSequence
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.String
 */
package com.aerserv.sdk.view.component;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.aerserv.sdk.utils.DisplayUtils;

public final class TimerText
extends TextView {
    private final int size = DisplayUtils.convertDipToPx(super.getContext(), 20);
    private int value = Integer.MAX_VALUE;

    public TimerText(Context context) {
        super(context);
        this.setTextColor(-1);
        int n2 = this.size;
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(n2, n2);
        this.setGravity(17);
        layoutParams.addRule(9);
        layoutParams.addRule(12);
        this.setLayoutParams((ViewGroup.LayoutParams)layoutParams);
    }

    public void onTime(int n2, int n3) {
        int n4 = n3 - n2;
        final int n5 = n4 / 1000;
        if (n3 <= 1000) {
            return;
        }
        if (n4 == 1000) {
            return;
        }
        if (n2 >= n3) {
            return;
        }
        if (n5 < this.value && n3 > 0 && n5 >= 0) {
            this.value = n5;
            Runnable runnable = new Runnable(){

                public void run() {
                    TimerText.this.setShadowLayer(0.01f, -2.0f, 2.0f, -16777216);
                    TimerText.this.setText((CharSequence)String.valueOf((int)n5));
                }
            };
            if (Looper.myLooper() == Looper.getMainLooper()) {
                runnable.run();
                return;
            }
            new Handler(Looper.getMainLooper()).post(runnable);
        }
    }

}

