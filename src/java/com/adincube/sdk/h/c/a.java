/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Enum
 *  java.lang.String
 */
package com.adincube.sdk.h.c;

public final class a
extends Enum<a> {
    public static final /* enum */ a a = new a("BANNER_AUTO");
    public static final /* enum */ a b = new a("BANNER_320x50");
    public static final /* enum */ a c = new a("BANNER_300x250");
    public static final /* enum */ a d = new a("BANNER_728x90");
    private static final /* synthetic */ a[] f;
    public String e;

    static {
        a[] arra = new a[]{a, b, c, d};
        f = arra;
    }

    private a(String string2) {
        this.e = string2;
    }
}

