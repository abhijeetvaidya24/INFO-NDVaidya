/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Enum
 *  java.lang.Object
 *  java.lang.String
 */
package com.b.a.a.a.h;

public final class d
extends Enum<d> {
    public static final /* enum */ d a = new d();
    public static final /* enum */ d b = new d();
    public static final /* enum */ d c = new d();
    private static final /* synthetic */ d[] d;

    static {
        d[] arrd = new d[]{a, b, c};
        d = arrd;
    }

    public static d valueOf(String string2) {
        return (d)Enum.valueOf(d.class, (String)string2);
    }

    public static d[] values() {
        return (d[])d.clone();
    }
}

