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
package com.adincube.sdk.k.b.b;

public final class g
extends Enum<g> {
    public static final /* enum */ g a = new g("progressive");
    public static final /* enum */ g b = new g("streaming");
    public static final /* enum */ g c = new g(null);
    private static final /* synthetic */ g[] e;
    private String d;

    static {
        g[] arrg = new g[]{a, b, c};
        e = arrg;
    }

    private g(String string2) {
        this.d = string2;
    }

    public static g a(String string) {
        IllegalArgumentException illegalArgumentException;
        for (g g2 : (g[])e.clone()) {
            if (!g2.d.equals((Object)string)) continue;
            return g2;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(string);
        stringBuilder.append(" is not a valid delivery.");
        illegalArgumentException = new IllegalArgumentException(stringBuilder.toString());
        throw illegalArgumentException;
    }
}

