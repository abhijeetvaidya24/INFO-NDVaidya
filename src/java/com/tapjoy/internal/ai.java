/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.view.animation.Animation
 *  java.lang.Enum
 *  java.lang.NoSuchFieldError
 *  java.lang.Object
 */
package com.tapjoy.internal;

import android.view.animation.Animation;

public class ai {
    protected final Animation a;

    public ai(Animation animation) {
        this.a = animation;
        animation.setDuration(400L);
    }

    public Animation a() {
        return this.a;
    }

    public final ai b() {
        this.a.setDuration(600L);
        return this;
    }

    public static final class a
    extends Enum {
        public static final /* enum */ int a = 1;
        public static final /* enum */ int b = 2;
        public static final /* enum */ int c = 3;
        public static final /* enum */ int d = 4;
        private static final /* synthetic */ int[] e;

        static {
            int[] arrn = new int[]{a, b, c, d};
            e = arrn;
        }

        public static int[] a() {
            return (int[])e.clone();
        }
    }

}

