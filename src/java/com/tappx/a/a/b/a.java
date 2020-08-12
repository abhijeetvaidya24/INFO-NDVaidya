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

public final class a
extends Enum<a> {
    public static final /* enum */ a a = new a();
    public static final /* enum */ a b = new a();
    public static final /* enum */ a c = new a();
    private static final /* synthetic */ a[] d;

    static {
        a[] arra = new a[]{a, b, c};
        d = arra;
    }

    public static a a(String string2) {
        if (string2 == null) {
            return null;
        }
        try {
            a a2 = a.valueOf(string2);
            return a2;
        }
        catch (Exception exception) {
            return a;
        }
    }

    public static String a(a a2) {
        if (a2 == null) {
            return null;
        }
        return a2.name();
    }

    public static a valueOf(String string2) {
        return (a)Enum.valueOf(a.class, (String)string2);
    }

    public static a[] values() {
        return (a[])d.clone();
    }
}

