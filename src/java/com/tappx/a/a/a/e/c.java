/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Enum
 *  java.lang.Object
 *  java.lang.String
 */
package com.tappx.a.a.a.e;

public final class c
extends Enum<c> {
    public static final /* enum */ c a = new c("banner");
    public static final /* enum */ c b = new c("interstitial");
    private static final /* synthetic */ c[] d;
    private final String c;

    static {
        c[] arrc = new c[]{a, b};
        d = arrc;
    }

    private c(String string3) {
        this.c = string3;
    }

    public static c valueOf(String string2) {
        return (c)Enum.valueOf(c.class, (String)string2);
    }

    public static c[] values() {
        return (c[])d.clone();
    }

    public String a() {
        return this.c;
    }
}

