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
package com.adincube.sdk.h.a.a;

public final class b
extends Enum<b> {
    public static final /* enum */ b a = new b("D");
    public static final /* enum */ b b = new b("M");
    private static final /* synthetic */ b[] d;
    String c;

    static {
        b[] arrb = new b[]{a, b};
        d = arrb;
    }

    private b(String string2) {
        this.c = string2;
    }

    public static b a(String string) {
        IllegalArgumentException illegalArgumentException;
        for (b b2 : (b[])d.clone()) {
            if (!b2.c.equals((Object)string)) continue;
            return b2;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(string);
        stringBuilder.append(" is not a valid resource type");
        illegalArgumentException = new IllegalArgumentException(stringBuilder.toString());
        throw illegalArgumentException;
    }
}

