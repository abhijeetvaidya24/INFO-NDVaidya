/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.view.animation.AccelerateInterpolator
 *  android.view.animation.Animation
 *  android.view.animation.Interpolator
 *  android.view.animation.TranslateAnimation
 *  java.lang.NoSuchFieldError
 *  java.lang.Object
 *  java.util.Random
 */
package com.tappx.a.a.b;

import android.view.animation.AccelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.Interpolator;
import android.view.animation.TranslateAnimation;
import com.tappx.a.a.a.c;
import com.tappx.a.a.b.b;
import java.util.Random;

public class d {
    public static final int a = 800;
    public static final int b = 1500;
    private static final b[] c;
    private static final Random d;

    static {
        b[] arrb = new b[]{b.c, b.b, b.d, b.e};
        c = arrb;
        d = new Random();
    }

    private static Animation a(Interpolator interpolator, int n2) {
        TranslateAnimation translateAnimation = new TranslateAnimation(2, 1.0f, 2, 0.0f, 2, 0.0f, 2, 0.0f);
        translateAnimation.setDuration((long)n2);
        translateAnimation.setInterpolator(interpolator);
        return translateAnimation;
    }

    public static Animation a(b b2) {
        int n2;
        if (b2 == b.f) {
            b2 = d.a();
        }
        if ((n2 = 1.a[b2.ordinal()]) != 1) {
            if (n2 != 2) {
                if (n2 != 3) {
                    if (n2 != 4) {
                        return null;
                    }
                    return d.a(new c.f(), 1500);
                }
                return d.a((Interpolator)new AccelerateInterpolator(), 800);
            }
            return d.b(new c.f(), 1500);
        }
        return d.b((Interpolator)new AccelerateInterpolator(), 800);
    }

    static b a() {
        b[] arrb = c;
        return arrb[d.nextInt(arrb.length)];
    }

    private static Animation b(Interpolator interpolator, int n2) {
        TranslateAnimation translateAnimation = new TranslateAnimation(2, -1.0f, 2, 0.0f, 2, 0.0f, 2, 0.0f);
        translateAnimation.setDuration((long)n2);
        translateAnimation.setInterpolator(interpolator);
        return translateAnimation;
    }

}

