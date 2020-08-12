/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.animation.TimeInterpolator
 *  android.animation.ValueAnimator
 *  android.animation.ValueAnimator$AnimatorUpdateListener
 *  android.content.Context
 *  android.os.Build
 *  android.os.Build$VERSION
 *  android.util.AttributeSet
 *  android.view.animation.AccelerateDecelerateInterpolator
 *  android.view.animation.Interpolator
 *  android.widget.ProgressBar
 *  java.lang.Integer
 *  java.lang.Object
 */
package com.startapp.android.publish.inappbrowser;

import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Interpolator;
import android.widget.ProgressBar;

public class AnimatingProgressBar
extends ProgressBar {
    private static final Interpolator a = new AccelerateDecelerateInterpolator();
    private ValueAnimator b;
    private boolean c = false;

    public AnimatingProgressBar(Context context, AttributeSet attributeSet, int n2) {
        super(context, attributeSet, n2);
        int n3 = Build.VERSION.SDK_INT;
        boolean bl = false;
        if (n3 >= 11) {
            bl = true;
        }
        this.c = bl;
    }

    public void a() {
        AnimatingProgressBar.super.setProgress(0);
        ValueAnimator valueAnimator = this.b;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
    }

    protected ValueAnimator getAnimator() {
        return this.b;
    }

    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        ValueAnimator valueAnimator = this.b;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
    }

    public void setProgress(int n2) {
        if (!this.c) {
            super.setProgress(n2);
            return;
        }
        ValueAnimator valueAnimator = this.b;
        if (valueAnimator != null) {
            valueAnimator.cancel();
            if (this.getProgress() >= n2) {
                return;
            }
        } else {
            int[] arrn = new int[]{this.getProgress(), n2};
            this.b = ValueAnimator.ofInt((int[])arrn);
            this.b.setInterpolator((TimeInterpolator)a);
            this.b.addUpdateListener(new ValueAnimator.AnimatorUpdateListener(){
                Integer a;

                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    this.a = (Integer)valueAnimator.getAnimatedValue();
                    AnimatingProgressBar.super.setProgress(this.a);
                }
            });
        }
        ValueAnimator valueAnimator2 = this.b;
        int[] arrn = new int[]{this.getProgress(), n2};
        valueAnimator2.setIntValues(arrn);
        this.b.start();
    }

}

