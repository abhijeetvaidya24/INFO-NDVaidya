/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Enum
 *  java.lang.Object
 *  java.lang.String
 */
package com.moat.analytics.mobile.aer;

public final class k
extends Enum<k> {
    public static final /* enum */ k a = new k();
    public static final /* enum */ k b = new k();
    public static final /* enum */ k c = new k();
    public static final /* enum */ k d = new k();
    public static final /* enum */ k e = new k();
    private static final /* synthetic */ k[] f;

    static {
        k[] arrk = new k[]{a, b, c, d, e};
        f = arrk;
    }

    public static k valueOf(String string) {
        return (k)Enum.valueOf(k.class, (String)string);
    }

    public static k[] values() {
        return (k[])f.clone();
    }
}

