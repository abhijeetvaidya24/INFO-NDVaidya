/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Enum
 *  java.lang.Object
 *  java.lang.String
 */
package com.adincube.sdk.g.b.c;

public final class e
extends Enum<e> {
    public static final /* enum */ e a;
    public static final /* enum */ e b;
    public static final /* enum */ e c;
    public static final /* enum */ e d;
    public static final /* enum */ e e;
    public static final /* enum */ e f;
    public static final /* enum */ e g;
    public static final /* enum */ e h;
    public static final /* enum */ e i;
    public static final /* enum */ e j;
    public static final /* enum */ e k;
    public static final /* enum */ e l;
    private static final /* synthetic */ e[] p;
    public String m;
    boolean n;
    int o;

    static {
        e e2;
        e e3;
        e e4;
        e e5;
        e e6;
        e e7;
        e e8;
        e e9;
        e e10;
        e e11;
        e e12;
        e e13;
        a = e7 = new e("WAITING", false, 5);
        b = e12 = new e("LOADING", false, 6);
        c = e13 = new e("LOADED", false, 8);
        d = e4 = new e("NO_MORE_INVENTORY", true, 1);
        e = e10 = new e("ERROR", true, 3);
        f = e2 = new e("TIMEOUT", true, 2);
        g = e11 = new e("WAITING_FOR_RESPONSE", true, 0);
        h = e5 = new e("WAITING_FOR_OTHER_AD_TYPE", false, 7);
        i = e3 = new e("WAITING_FOR_USER_CONSENT", false, 8);
        j = e8 = new e("REQUIRING_USER_CONSENT", true, 10);
        k = e9 = new e("EXPIRED", true, 4);
        l = e6 = new e("LIAR", true, 11);
        e[] arre = new e[]{a, b, c, d, e, f, g, h, i, j, k, l};
        p = arre;
    }

    private e(String string2, boolean bl, int n3) {
        this.m = string2;
        this.n = bl;
        this.o = n3;
    }

    public static e[] a() {
        return (e[])p.clone();
    }

    public final String toString() {
        return this.m;
    }
}

