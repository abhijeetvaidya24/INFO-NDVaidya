/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Enum
 *  java.lang.NoSuchFieldError
 *  java.lang.Object
 *  java.lang.String
 */
package com.tappx.a.a.a.h;

public final class i
extends Enum<i> {
    public static final /* enum */ i a = new i();
    public static final /* enum */ i b = new i();
    public static final /* enum */ i c = new i();
    public static final /* enum */ i d = new i();
    public static final /* enum */ i e = new i();
    private static final /* synthetic */ i[] f;

    static {
        i[] arri = new i[]{a, b, c, d, e};
        f = arri;
    }

    public static i valueOf(String string2) {
        return (i)Enum.valueOf(i.class, (String)string2);
    }

    public static i[] values() {
        return (i[])f.clone();
    }

    public boolean a() {
        int n2 = 1.a[this.ordinal()];
        return n2 == 1 || n2 == 2;
    }

    public boolean b() {
        int n2 = 1.a[this.ordinal()];
        return n2 == 1 || n2 == 3;
    }

    public boolean c() {
        int n2 = 1.a[this.ordinal()];
        return n2 == 2 || n2 == 4;
    }

}

