/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Enum
 *  java.lang.Object
 *  java.lang.String
 */
package com.tappx.a.a.a.e;

public final class a
extends Enum<a> {
    public static final /* enum */ a a = new a();
    public static final /* enum */ a b = new a();
    public static final /* enum */ a c = new a();
    public static final /* enum */ a d = new a();
    public static final /* enum */ a e = new a();
    public static final /* enum */ a f = new a();
    private static final /* synthetic */ a[] g;

    static {
        a[] arra = new a[]{a, b, c, d, e, f};
        g = arra;
    }

    public static a valueOf(String string2) {
        return (a)Enum.valueOf(a.class, (String)string2);
    }

    public static a[] values() {
        return (a[])g.clone();
    }
}

