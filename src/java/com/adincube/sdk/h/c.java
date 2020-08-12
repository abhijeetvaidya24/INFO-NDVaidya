/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Enum
 *  java.lang.Object
 *  java.lang.String
 */
package com.adincube.sdk.h;

public final class c
extends Enum<c> {
    public static final /* enum */ c a = new c("SINGLE");
    public static final /* enum */ c b = new c("MARRIED");
    private static final /* synthetic */ c[] d;
    public String c;

    static {
        c[] arrc = new c[]{a, b};
        d = arrc;
    }

    private c(String string2) {
        this.c = string2;
    }

    public static c[] a() {
        return (c[])d.clone();
    }
}

