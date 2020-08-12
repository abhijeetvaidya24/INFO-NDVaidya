/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.content.Context
 *  android.graphics.PorterDuff
 *  android.graphics.PorterDuff$Mode
 *  android.graphics.drawable.Drawable
 *  android.util.AttributeSet
 *  android.view.View
 *  android.view.ViewGroup
 *  android.view.ViewGroup$LayoutParams
 *  android.widget.ProgressBar
 *  android.widget.RelativeLayout
 *  android.widget.RelativeLayout$LayoutParams
 *  com.applovin.sdk.AppLovinSdkUtils
 */
package com.applovin.impl.adview;

import android.app.Activity;
import android.content.Context;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import com.applovin.sdk.AppLovinSdkUtils;

public class a
extends RelativeLayout {
    private final ProgressBar a;

    public a(Activity activity, int n2, int n3) {
        RelativeLayout.LayoutParams layoutParams;
        super((Context)activity);
        this.setClickable(false);
        this.a = new ProgressBar((Context)activity, null, n3);
        this.a.setIndeterminate(true);
        this.a.setClickable(false);
        if (n2 != -2 && n2 != -1) {
            int n4 = AppLovinSdkUtils.dpToPx((Context)activity, (int)n2);
            layoutParams = new RelativeLayout.LayoutParams(n4, n4);
        } else {
            layoutParams = new RelativeLayout.LayoutParams(n2, n2);
        }
        layoutParams.addRule(13);
        this.a.setLayoutParams((ViewGroup.LayoutParams)layoutParams);
        this.addView((View)this.a);
    }

    public void a() {
        this.setVisibility(0);
    }

    public void b() {
        this.setVisibility(8);
    }

    public void setColor(int n2) {
        this.a.getIndeterminateDrawable().setColorFilter(n2, PorterDuff.Mode.SRC_IN);
    }
}

