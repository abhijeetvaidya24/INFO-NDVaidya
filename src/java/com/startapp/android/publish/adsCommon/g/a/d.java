/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Enum
 *  java.lang.Object
 *  java.lang.String
 */
package com.startapp.android.publish.adsCommon.g.a;

public final class d
extends Enum<d> {
    public static final /* enum */ d a = new d();
    public static final /* enum */ d b = new d();
    public static final /* enum */ d c = new d();
    public static final /* enum */ d d = new d();
    public static final /* enum */ d e = new d();
    private static final /* synthetic */ d[] f;

    static {
        d[] arrd = new d[]{a, b, c, d, e};
        f = arrd;
    }

    public static d valueOf(String string) {
        return (d)Enum.valueOf(d.class, (String)string);
    }

    public static d[] values() {
        return (d[])f.clone();
    }

    public String toString() {
        return this.name().toLowerCase();
    }
}

