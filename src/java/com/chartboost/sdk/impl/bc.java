/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.annotation.SuppressLint
 *  android.content.Context
 *  android.view.MotionEvent
 *  android.view.View
 *  android.view.ViewGroup
 *  android.view.ViewGroup$LayoutParams
 *  android.widget.RelativeLayout
 *  android.widget.RelativeLayout$LayoutParams
 */
package com.chartboost.sdk.impl;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.chartboost.sdk.Model.a;
import com.chartboost.sdk.Model.c;
import com.chartboost.sdk.e;
import com.chartboost.sdk.impl.ax;

@SuppressLint(value={"ViewConstructor"})
public class bc
extends RelativeLayout {
    private e.a a;
    private ax b;
    private ax c;
    private final c d;

    public bc(Context context, c c2) {
        super(context);
        this.d = c2;
        if (c2.p.b == 0) {
            this.b = new ax(context);
            this.addView((View)this.b, (ViewGroup.LayoutParams)new RelativeLayout.LayoutParams(-1, -1));
            this.c = new ax(context);
            this.addView((View)this.c, (ViewGroup.LayoutParams)new RelativeLayout.LayoutParams(-1, -1));
            this.c.setVisibility(8);
        }
    }

    public void a() {
        e.a a2;
        if (this.a == null && (a2 = (this.a = this.d.k())) != null) {
            this.addView((View)a2, (ViewGroup.LayoutParams)new RelativeLayout.LayoutParams(-1, -1));
            this.a.a();
        }
    }

    public void b() {
    }

    public ax c() {
        return this.b;
    }

    public View d() {
        return this.a;
    }

    public c e() {
        return this.d;
    }

    public boolean f() {
        e.a a2 = this.a;
        return a2 != null && a2.getVisibility() == 0;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        this.performClick();
        return true;
    }

    public boolean performClick() {
        super.performClick();
        return true;
    }
}

