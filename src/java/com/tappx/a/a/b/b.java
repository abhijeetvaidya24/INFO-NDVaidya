/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Enum
 *  java.lang.Exception
 *  java.lang.Object
 *  java.lang.String
 */
package com.tappx.a.a.b;

public final class b
extends Enum<b> {
    public static final /* enum */ b a = new b();
    public static final /* enum */ b b = new b();
    public static final /* enum */ b c = new b();
    public static final /* enum */ b d = new b();
    public static final /* enum */ b e = new b();
    public static final /* enum */ b f = new b();
    private static final /* synthetic */ b[] g;

    static {
        b[] arrb = new b[]{a, b, c, d, e, f};
        g = arrb;
    }

    public static b a(String string2) {
        if (string2 == null) {
            return null;
        }
        try {
            b b2 = b.valueOf(string2);
            return b2;
        }
        catch (Exception exception) {
            return null;
        }
    }

    public static String a(b b2) {
        if (b2 == null) {
            return null;
        }
        return b2.name();
    }

    public static b valueOf(String string2) {
        return (b)Enum.valueOf(b.class, (String)string2);
    }

    public static b[] values() {
        return (b[])g.clone();
    }
}

