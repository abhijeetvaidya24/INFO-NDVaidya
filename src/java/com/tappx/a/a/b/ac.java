/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Enum
 *  java.lang.Object
 *  java.lang.String
 */
package com.tappx.a.a.b;

final class ac
extends Enum<ac> {
    public static final /* enum */ ac a = new ac(1);
    public static final /* enum */ ac b = new ac(0);
    public static final /* enum */ ac c = new ac(-1);
    private static final /* synthetic */ ac[] e;
    private final int d;

    static {
        ac[] arrac = new ac[]{a, b, c};
        e = arrac;
    }

    private ac(int n3) {
        this.d = n3;
    }

    public static ac valueOf(String string2) {
        return (ac)Enum.valueOf(ac.class, (String)string2);
    }

    public static ac[] values() {
        return (ac[])e.clone();
    }

    int a() {
        return this.d;
    }
}

