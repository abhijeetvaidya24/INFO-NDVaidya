/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.util.DisplayMetrics
 *  java.lang.Enum
 *  java.lang.Integer
 *  java.lang.Math
 *  java.lang.NoSuchFieldError
 *  java.lang.Object
 *  java.lang.String
 *  java.util.HashSet
 *  java.util.Set
 */
package com.adincube.sdk.h.c;

import android.content.Context;
import android.util.DisplayMetrics;
import com.adincube.sdk.AdinCube;
import com.adincube.sdk.h.c.a;
import com.adincube.sdk.h.f;
import com.adincube.sdk.util.b.j;
import java.util.HashSet;
import java.util.Set;

public final class c
extends Enum<c> {
    public static final /* enum */ c a;
    public static final /* enum */ c b;
    public static final /* enum */ c c;
    public static final /* enum */ c d;
    public static final /* enum */ c e;
    private static final /* synthetic */ c[] k;
    public boolean f;
    public int g;
    public String h;
    public a i;
    private int j;

    static {
        c c2;
        c c3;
        c c4;
        c c5;
        a = new c("INVALID", "INVALID");
        b = c5 = new c("AUTO", a.a, 0, 0);
        c = c2 = new c("320x50", a.b, 320, 50);
        d = c3 = new c("300x250", a.c, 300, 250);
        e = c4 = new c("728x90", a.d, 728, 90);
        c[] arrc = new c[]{a, b, c, d, e};
        k = arrc;
    }

    private c(String string2, a a2, int n3, int n4) {
        this.f = true;
        this.h = string2;
        this.i = a2;
        this.g = n3;
        this.j = n4;
    }

    private c(String string2) {
        this.f = false;
        this.h = (String)n2;
    }

    public static c a(int n2) {
        if (n2 == -1) {
            return a;
        }
        if (n2 == -2) {
            return b;
        }
        c c2 = a;
        for (c c3 : c.a()) {
            if (!c3.f || Math.abs((int)(n2 - c3.j)) > 2) continue;
            return c3;
        }
        return c2;
    }

    public static c a(AdinCube.Banner.Size size) {
        int n2 = 1.a[size.ordinal()];
        if (n2 != 1) {
            if (n2 != 2) {
                if (n2 != 3) {
                    if (n2 != 4) {
                        return a;
                    }
                    return e;
                }
                return d;
            }
            return c;
        }
        return b;
    }

    public static c[] a() {
        return (c[])k.clone();
    }

    public static Set<Integer> b() {
        HashSet hashSet = new HashSet();
        for (c c2 : c.a()) {
            if (!c2.f || c2 == b) continue;
            hashSet.add((Object)c2.j);
        }
        return hashSet;
    }

    public final int a(DisplayMetrics displayMetrics) {
        return (int)Math.floor((double)((float)this.g * displayMetrics.density));
    }

    public final f a(Context context) {
        return f.a(context, this.g, this.j);
    }

    public final boolean a(int n2, int n3, int n4) {
        if (n2 < 0) {
            return true;
        }
        if (this == b && n2 != n4) {
            return false;
        }
        if (this.g > n2) {
            return false;
        }
        if (n3 < 0) {
            return true;
        }
        return this.j <= n3;
    }

    public final boolean a(Context context, int n2, int n3) {
        int n4 = Math.round((float)((float)j.b(context)));
        Math.round((float)((float)j.c(context)));
        if (n2 > 0) {
            n2 = j.a(context, n2);
        }
        if (n3 > 0) {
            n3 = j.a(context, n3);
        }
        return this.a(n2, n3, n4);
    }

    public final int b(DisplayMetrics displayMetrics) {
        return (int)Math.floor((double)((float)this.j * displayMetrics.density));
    }

}

