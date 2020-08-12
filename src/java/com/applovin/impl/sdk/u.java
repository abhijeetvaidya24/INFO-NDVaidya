/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.content.Context
 *  android.graphics.Point
 *  android.graphics.Rect
 *  android.view.View
 *  android.view.ViewParent
 *  android.view.animation.Animation
 *  com.applovin.impl.mediation.a.b
 *  java.lang.Long
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 */
package com.applovin.impl.sdk;

import android.app.Activity;
import android.content.Context;
import android.graphics.Point;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewParent;
import android.view.animation.Animation;
import com.applovin.impl.mediation.a.b;
import com.applovin.impl.sdk.a;
import com.applovin.impl.sdk.e.e;
import com.applovin.impl.sdk.e.m;
import com.applovin.impl.sdk.j;
import com.applovin.impl.sdk.p;
import com.applovin.mediation.ads.MaxAdView;
import com.applovin.sdk.AppLovinSdkUtils;

public class u {
    private final j a;
    private final p b;
    private final MaxAdView c;

    public u(MaxAdView maxAdView, j j2) {
        this.a = j2;
        this.b = j2.u();
        this.c = maxAdView;
    }

    public long a(b b2) {
        long l2;
        int n2;
        int n3;
        Activity activity;
        Animation animation;
        this.b.a("ViewabilityTracker", "Checking visibility...");
        if (!this.c.isShown()) {
            this.b.d("ViewabilityTracker", "View is hidden");
            l2 = 2L;
        } else {
            l2 = 0L;
        }
        if (this.c.getAlpha() < b2.n()) {
            this.b.d("ViewabilityTracker", "View is transparent");
            l2 |= 4L;
        }
        if ((animation = this.c.getAnimation()) != null && animation.hasStarted() && !animation.hasEnded()) {
            this.b.d("ViewabilityTracker", "View is animating");
            l2 |= 8L;
        }
        if (this.c.getParent() == null) {
            this.b.d("ViewabilityTracker", "No parent view found");
            l2 |= 16L;
        }
        if ((n2 = AppLovinSdkUtils.pxToDp(this.c.getContext(), this.c.getWidth())) < b2.l()) {
            p p2 = this.b;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("View has width (");
            stringBuilder.append(n2);
            stringBuilder.append(") below threshold");
            p2.d("ViewabilityTracker", stringBuilder.toString());
            l2 |= 32L;
        }
        if ((n3 = AppLovinSdkUtils.pxToDp(this.c.getContext(), this.c.getHeight())) < b2.m()) {
            p p3 = this.b;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("View has height (");
            stringBuilder.append(n3);
            stringBuilder.append(") below threshold");
            p3.d("ViewabilityTracker", stringBuilder.toString());
            l2 |= 64L;
        }
        Point point = e.a(this.c.getContext());
        Rect rect = new Rect(0, 0, point.x, point.y);
        int[] arrn = new int[]{-1, -1};
        this.c.getLocationOnScreen(arrn);
        Rect rect2 = new Rect(arrn[0], arrn[1], arrn[0] + this.c.getWidth(), arrn[1] + this.c.getHeight());
        if (!Rect.intersects((Rect)rect, (Rect)rect2)) {
            p p4 = this.b;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Rect (");
            stringBuilder.append((Object)rect2);
            stringBuilder.append(") outside of screen's bounds (");
            stringBuilder.append((Object)rect);
            stringBuilder.append(")");
            p4.d("ViewabilityTracker", stringBuilder.toString());
            l2 |= 128L;
        }
        if ((activity = this.a.S().a()) != null && !m.a((View)this.c, activity)) {
            this.b.d("ViewabilityTracker", "View is not in top activity's view hierarchy");
            l2 |= 256L;
        }
        p p5 = this.b;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Returning flags: ");
        stringBuilder.append(Long.toBinaryString((long)l2));
        p5.a("ViewabilityTracker", stringBuilder.toString());
        return l2;
    }
}

