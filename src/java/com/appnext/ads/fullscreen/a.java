/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.view.animation.Animation
 *  android.view.animation.Interpolator
 *  android.view.animation.LinearInterpolator
 *  android.view.animation.Transformation
 */
package com.appnext.ads.fullscreen;

import android.view.animation.Animation;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import android.view.animation.Transformation;
import com.appnext.ads.fullscreen.Circle;

public final class a
extends Animation {
    private float aA;
    private Circle ay;
    private float az;

    public a(Circle circle, float f2) {
        this.setInterpolator((Interpolator)new LinearInterpolator());
        this.az = circle.getAngle();
        this.aA = f2;
        this.ay = circle;
    }

    protected final void applyTransformation(float f2, Transformation transformation) {
        float f3 = this.az;
        float f4 = f3 - f2 * (f3 - this.aA);
        this.ay.setAngle(f4);
        this.ay.invalidate();
        this.ay.requestLayout();
    }
}

