/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Enum
 *  java.lang.Object
 *  java.lang.String
 *  java.util.Locale
 */
package com.tappx.a.a.b;

import java.util.Locale;

public final class s
extends Enum<s> {
    public static final /* enum */ s a = new s();
    public static final /* enum */ s b = new s();
    private static final /* synthetic */ s[] c;

    static {
        s[] arrs = new s[]{a, b};
        c = arrs;
    }

    public static s valueOf(String string2) {
        return (s)Enum.valueOf(s.class, (String)string2);
    }

    public static s[] values() {
        return (s[])c.clone();
    }

    String a() {
        return this.toString().toLowerCase(Locale.US);
    }
}

