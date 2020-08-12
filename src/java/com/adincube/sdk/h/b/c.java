/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Enum
 *  java.lang.IllegalArgumentException
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 */
package com.adincube.sdk.h.b;

public final class c
extends Enum<c> {
    public static final /* enum */ c a = new c("SHOW");
    public static final /* enum */ c b = new c("IS_READY");
    private static final /* synthetic */ c[] d;
    public String c;

    static {
        c[] arrc = new c[]{a, b};
        d = arrc;
    }

    private c(String string2) {
        this.c = string2;
    }

    public static c a(String string) {
        IllegalArgumentException illegalArgumentException;
        for (c c2 : c.a()) {
            if (!c2.c.equals((Object)string)) continue;
            return c2;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(string);
        stringBuilder.append(" is not a valid reporting context.");
        illegalArgumentException = new IllegalArgumentException(stringBuilder.toString());
        throw illegalArgumentException;
    }

    public static c[] a() {
        return (c[])d.clone();
    }
}

