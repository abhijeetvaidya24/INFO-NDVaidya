/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Enum
 *  java.lang.String
 */
package com.adincube.sdk.i;

public final class f
extends Enum<f> {
    public static final /* enum */ f a = new f("loading");
    public static final /* enum */ f b = new f("default");
    public static final /* enum */ f c = new f("expanded");
    public static final /* enum */ f d = new f("resized");
    public static final /* enum */ f e = new f("hidden");
    private static final /* synthetic */ f[] g;
    String f;

    static {
        f[] arrf = new f[]{a, b, c, d, e};
        g = arrf;
    }

    private f(String string2) {
        this.f = string2;
    }

    public final String toString() {
        return this.f;
    }
}

