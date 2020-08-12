/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.annotation.SuppressLint
 *  android.content.Context
 *  android.content.res.Resources
 *  android.graphics.Typeface
 *  android.util.DisplayMetrics
 *  android.view.View
 *  android.view.ViewGroup
 *  android.view.ViewGroup$LayoutParams
 *  android.widget.ImageView
 *  android.widget.ImageView$ScaleType
 *  android.widget.LinearLayout
 *  android.widget.LinearLayout$LayoutParams
 *  android.widget.TextView
 *  com.chartboost.sdk.impl.v
 *  com.chartboost.sdk.impl.y$1
 *  java.lang.CharSequence
 *  java.lang.Math
 *  java.lang.String
 */
package com.chartboost.sdk.impl;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.chartboost.sdk.Libraries.h;
import com.chartboost.sdk.e;
import com.chartboost.sdk.impl.ay;
import com.chartboost.sdk.impl.az;
import com.chartboost.sdk.impl.v;
import com.chartboost.sdk.impl.y;

@SuppressLint(value={"ViewConstructor"})
public class y
extends LinearLayout {
    final v a;
    final az b;
    private LinearLayout c;
    private ay d;
    private TextView e;
    private int f = Integer.MIN_VALUE;

    public y(Context context, v v2) {
        super(context);
        this.a = v2;
        int n2 = Math.round((float)(8.0f * context.getResources().getDisplayMetrics().density));
        this.setOrientation(1);
        this.setGravity(17);
        this.c = new LinearLayout(context);
        this.c.setGravity(17);
        this.c.setOrientation(0);
        this.c.setPadding(n2, n2, n2, n2);
        this.d = new ay(context);
        this.d.setScaleType(ImageView.ScaleType.FIT_CENTER);
        this.d.setPadding(0, 0, n2, 0);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        v2.a((ViewGroup.LayoutParams)layoutParams, v2.H, 1.0f);
        this.e = new TextView(this.getContext());
        this.e.setTextColor(-1);
        this.e.setTypeface(null, 1);
        this.e.setGravity(17);
        TextView textView = this.e;
        float f2 = e.a(context) ? 26.0f : 16.0f;
        textView.setTextSize(2, f2);
        this.c.addView((View)this.d, (ViewGroup.LayoutParams)layoutParams);
        this.c.addView((View)this.e, (ViewGroup.LayoutParams)new LinearLayout.LayoutParams(-2, -2));
        this.b = new 1(this, this.getContext());
        this.b.setContentDescription((CharSequence)"CBWatch");
        this.b.setPadding(0, 0, 0, n2);
        this.b.a(ImageView.ScaleType.FIT_CENTER);
        this.b.setPadding(n2, n2, n2, n2);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        v2.a((ViewGroup.LayoutParams)layoutParams2, v2.G, 1.0f);
        this.d.a(v2.H);
        this.b.a(v2.G);
        this.addView((View)this.c, (ViewGroup.LayoutParams)new LinearLayout.LayoutParams(-2, -2));
        this.addView((View)this.b, (ViewGroup.LayoutParams)layoutParams2);
        this.a();
    }

    public void a() {
        this.a(this.a.s());
    }

    public void a(String string, int n2) {
        this.e.setText((CharSequence)string);
        this.f = n2;
        this.a(this.a.s());
    }

    public void a(boolean bl) {
        int n2 = bl ? -16777216 : this.f;
        this.setBackgroundColor(n2);
    }
}

