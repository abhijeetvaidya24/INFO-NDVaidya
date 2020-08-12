/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Enum
 *  java.lang.IllegalStateException
 *  java.lang.Object
 *  java.lang.String
 *  java.util.Locale
 */
package com.adincube.sdk.h.c;

import java.util.Locale;

public final class b
extends Enum<b> {
    public static final /* enum */ b a;
    public static final /* enum */ b b;
    public static final /* enum */ b c;
    public static final /* enum */ b d;
    private static final /* synthetic */ b[] i;
    public String e;
    public String f;
    public String g;
    public String h;

    static {
        b b2;
        b b3;
        b b4;
        b b5;
        a = b2 = new b("INTERSTITIAL", "interstitial", "I", "interstitial");
        b = b3 = new b("BANNER", "banner", "B", "inline");
        c = b4 = new b("NATIVE", "native", "N", null);
        d = b5 = new b("REWARDED", "rewarded", "R", null);
        b[] arrb = new b[]{a, b, c, d};
        i = arrb;
    }

    private b(String string2, String string3, String string4, String string5) {
        this.e = string2;
        this.f = string3;
        this.g = string4;
        this.h = string5;
    }

    public static b a(String string) {
        IllegalStateException illegalStateException;
        for (b b2 : b.a()) {
            if (!b2.e.equals((Object)string)) continue;
            return b2;
        }
        illegalStateException = new IllegalStateException(String.format((Locale)Locale.US, (String)"'%s' is not a valid ad type", (Object[])new Object[]{string}));
        throw illegalStateException;
    }

    public static b[] a() {
        return (b[])i.clone();
    }
}

