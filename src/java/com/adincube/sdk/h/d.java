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
package com.adincube.sdk.h;

public final class d
extends Enum<d> {
    public static final /* enum */ d a = new d("PORT");
    public static final /* enum */ d b = new d("LAND");
    public static final /* enum */ d c = new d("BOTH");
    private static final /* synthetic */ d[] e;
    public String d;

    static {
        d[] arrd = new d[]{a, b, c};
        e = arrd;
    }

    private d(String string2) {
        this.d = string2;
    }

    public static d a(String string) {
        IllegalArgumentException illegalArgumentException;
        for (d d2 : d.a()) {
            if (!d2.d.equals((Object)string)) continue;
            return d2;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(string);
        stringBuilder.append(" is not a valid orientation.");
        illegalArgumentException = new IllegalArgumentException(stringBuilder.toString());
        throw illegalArgumentException;
    }

    public static d[] a() {
        return (d[])e.clone();
    }
}

