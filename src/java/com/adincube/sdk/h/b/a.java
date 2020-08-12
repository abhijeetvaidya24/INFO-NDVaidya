/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Enum
 *  java.lang.String
 */
package com.adincube.sdk.h.b;

public final class a
extends Enum<a> {
    public static final /* enum */ a a = new a(1);
    public static final /* enum */ a b = new a(2);
    public static final /* enum */ a c = new a(4);
    public static final /* enum */ a d = new a(8);
    public static final /* enum */ a e = new a(16);
    public static final /* enum */ a f = new a(32);
    private static final /* synthetic */ a[] h;
    int g;

    static {
        a[] arra = new a[]{a, b, c, d, e, f};
        h = arra;
    }

    private a(int n3) {
        this.g = n3;
    }
}

