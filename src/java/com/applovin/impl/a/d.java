/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Enum
 *  java.lang.Object
 *  java.lang.String
 */
package com.applovin.impl.a;

public final class d
extends Enum<d> {
    public static final /* enum */ d a = new d(-1);
    public static final /* enum */ d b = new d(100);
    public static final /* enum */ d c = new d(300);
    public static final /* enum */ d d = new d(301);
    public static final /* enum */ d e = new d(302);
    public static final /* enum */ d f = new d(303);
    public static final /* enum */ d g = new d(400);
    public static final /* enum */ d h = new d(401);
    public static final /* enum */ d i = new d(402);
    public static final /* enum */ d j = new d(405);
    public static final /* enum */ d k = new d(600);
    public static final /* enum */ d l = new d(603);
    public static final /* enum */ d m = new d(604);
    private static final /* synthetic */ d[] o;
    private final int n;

    static {
        d[] arrd = new d[]{a, b, c, d, e, f, g, h, i, j, k, l, m};
        o = arrd;
    }

    private d(int n3) {
        this.n = n3;
    }

    public static d valueOf(String string) {
        return (d)Enum.valueOf(d.class, (String)string);
    }

    public static d[] values() {
        return (d[])o.clone();
    }

    public int a() {
        return this.n;
    }
}

