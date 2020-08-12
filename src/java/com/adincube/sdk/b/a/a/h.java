/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Enum
 *  java.lang.String
 */
package com.adincube.sdk.b.a.a;

public final class h
extends Enum<h> {
    public static final /* enum */ h a = new h("CREATED", false);
    public static final /* enum */ h b = new h("PREPARING", false);
    public static final /* enum */ h c = new h("PREPARED", false);
    public static final /* enum */ h d = new h("READY", false);
    public static final /* enum */ h e = new h("PLAYING", false);
    public static final /* enum */ h f = new h("COMPLETED", true);
    public static final /* enum */ h g = new h("ERROR", true);
    private static final /* synthetic */ h[] j;
    public String h;
    boolean i;

    static {
        h[] arrh = new h[]{a, b, c, d, e, f, g};
        j = arrh;
    }

    private h(String string2, boolean bl) {
        this.h = string2;
        this.i = bl;
    }
}

