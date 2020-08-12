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
package com.adincube.sdk.h.f;

import java.util.Locale;

public final class d
extends Enum<d> {
    public static final /* enum */ d a = new d("UNKNOWN");
    public static final /* enum */ d b = new d("ASKING");
    public static final /* enum */ d c = new d("ACCEPTED");
    public static final /* enum */ d d = new d("DECLINED");
    public static final /* enum */ d e = new d("NOT_APPLICABLE");
    private static final /* synthetic */ d[] g;
    public String f;

    static {
        d[] arrd = new d[]{a, b, c, d, e};
        g = arrd;
    }

    private d(String string2) {
        this.f = string2;
    }

    public static d a(String string) {
        IllegalStateException illegalStateException;
        for (d d2 : (d[])g.clone()) {
            if (!d2.f.equals((Object)string)) continue;
            return d2;
        }
        illegalStateException = new IllegalStateException(String.format((Locale)Locale.US, (String)"'%s' is not a valid user consent status", (Object[])new Object[]{string}));
        throw illegalStateException;
    }

    public final boolean a() {
        return this == c;
    }
}

