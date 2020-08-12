/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Enum
 *  java.lang.String
 */
package com.adincube.sdk.i;

public final class d
extends Enum<d> {
    public static final /* enum */ d a = new d("ready", 0);
    public static final /* enum */ d b = new d("error", 1);
    public static final /* enum */ d c = new d("stateChange", 1);
    public static final /* enum */ d d = new d("viewableChange", 1);
    public static final /* enum */ d e = new d("sizeChange", 2);
    private static final /* synthetic */ d[] h;
    private String f;
    private int g;

    static {
        d[] arrd = new d[]{a, b, c, d, e};
        h = arrd;
    }

    private d(String string2, int n3) {
        this.f = string2;
        this.g = n3;
    }

    public final String toString() {
        return this.f;
    }
}

