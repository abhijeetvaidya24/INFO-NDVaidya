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

public final class am
extends Enum<am> {
    public static final /* enum */ am a = new am();
    public static final /* enum */ am b = new am();
    public static final /* enum */ am c = new am();
    public static final /* enum */ am d = new am();
    public static final /* enum */ am e = new am();
    private static final /* synthetic */ am[] f;

    static {
        am[] arram = new am[]{a, b, c, d, e};
        f = arram;
    }

    public static am valueOf(String string2) {
        return (am)Enum.valueOf(am.class, (String)string2);
    }

    public static am[] values() {
        return (am[])f.clone();
    }

    public String a() {
        return this.toString().toLowerCase(Locale.US);
    }
}

