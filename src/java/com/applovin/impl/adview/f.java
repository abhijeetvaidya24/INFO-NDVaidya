/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.graphics.Color
 *  android.util.AttributeSet
 *  android.view.View
 *  android.view.ViewGroup
 *  android.view.ViewGroup$LayoutParams
 *  android.widget.ProgressBar
 *  android.widget.RelativeLayout
 *  android.widget.RelativeLayout$LayoutParams
 *  com.applovin.impl.sdk.b.b
 *  com.applovin.impl.sdk.j
 *  com.applovin.sdk.AppLovinSdkUtils
 *  java.lang.Integer
 *  java.lang.Object
 *  java.lang.String
 */
package com.applovin.impl.adview;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import com.applovin.impl.sdk.b.b;
import com.applovin.impl.sdk.j;
import com.applovin.sdk.AppLovinSdkUtils;

public class f
extends RelativeLayout {
    public f(Context context, j j2) {
        super(context, null, ((Integer)j2.a(b.cm)).intValue());
        this.a(context, j2);
    }

    private void a(Context context, j j2) {
        RelativeLayout.LayoutParams layoutParams;
        ProgressBar progressBar = new ProgressBar(context);
        progressBar.setIndeterminate(true);
        int n2 = (Integer)j2.a(b.cl);
        if (n2 != -2 && n2 != -1) {
            int n3 = AppLovinSdkUtils.dpToPx((Context)context, (int)n2);
            layoutParams = new RelativeLayout.LayoutParams(n3, n3);
        } else {
            layoutParams = new RelativeLayout.LayoutParams(n2, n2);
        }
        layoutParams.addRule(13);
        progressBar.setLayoutParams((ViewGroup.LayoutParams)layoutParams);
        this.setBackgroundColor(Color.parseColor((String)((String)j2.a(b.ch))));
        this.addView((View)progressBar);
    }
}

