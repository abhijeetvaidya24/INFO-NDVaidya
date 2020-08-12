/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Enum
 *  java.lang.Object
 *  java.lang.String
 */
package com.adincube.sdk.h;

public final class b
extends Enum<b> {
    public static final /* enum */ b a = new b("MALE");
    public static final /* enum */ b b = new b("FEMALE");
    private static final /* synthetic */ b[] d;
    public String c;

    static {
        b[] arrb = new b[]{a, b};
        d = arrb;
    }

    private b(String string2) {
        this.c = string2;
    }

    public static b[] a() {
        return (b[])d.clone();
    }
}

