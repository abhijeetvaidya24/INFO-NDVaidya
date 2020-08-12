/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Enum
 *  java.lang.Object
 *  java.lang.String
 */
package com.b.a.a.a.b;

public final class f
extends Enum<f> {
    public static final /* enum */ f a = new f("native");
    public static final /* enum */ f b = new f("javascript");
    public static final /* enum */ f c = new f("none");
    private static final /* synthetic */ f[] d;
    private final String owner;

    static {
        f[] arrf = new f[]{a, b, c};
        d = arrf;
    }

    private f(String string3) {
        this.owner = string3;
    }

    public static f valueOf(String string2) {
        return (f)Enum.valueOf(f.class, (String)string2);
    }

    public static f[] values() {
        return (f[])d.clone();
    }

    public String toString() {
        return this.owner;
    }
}

