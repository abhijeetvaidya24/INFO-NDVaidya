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

public final class c
extends Enum<c> {
    public static final /* enum */ c a = new c("REQUIRED");
    public static final /* enum */ c b = new c("PASSTHROUGH");
    public static final /* enum */ c c = new c("PASSTHROUGH_REQUIRED");
    public static final /* enum */ c d = new c("IGNORED");
    private static final /* synthetic */ c[] f;
    private String e;

    static {
        c[] arrc = new c[]{a, b, c, d};
        f = arrc;
    }

    private c(String string2) {
        this.e = string2;
    }

    public static c a(String string) {
        IllegalStateException illegalStateException;
        for (c c2 : (c[])f.clone()) {
            if (!c2.e.equals((Object)string)) continue;
            return c2;
        }
        illegalStateException = new IllegalStateException(String.format((Locale)Locale.US, (String)"'%s' is not a valid user consent policy", (Object[])new Object[]{string}));
        throw illegalStateException;
    }

    public final boolean a() {
        return this == b || this == c;
        {
        }
    }
}

