/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Enum
 *  java.lang.Object
 *  java.lang.String
 */
package com.b.a.a.a.b;

public final class e
extends Enum<e> {
    public static final /* enum */ e a = new e("html");
    public static final /* enum */ e b = new e("native");
    private static final /* synthetic */ e[] c;
    private final String typeString;

    static {
        e[] arre = new e[]{a, b};
        c = arre;
    }

    private e(String string3) {
        this.typeString = string3;
    }

    public static e valueOf(String string2) {
        return (e)Enum.valueOf(e.class, (String)string2);
    }

    public static e[] values() {
        return (e[])c.clone();
    }

    public String toString() {
        return this.typeString;
    }
}

