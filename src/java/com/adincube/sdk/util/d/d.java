/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.adincube.sdk.h.c.b
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.util.Collections
 *  java.util.Locale
 *  java.util.Map
 */
package com.adincube.sdk.util.d;

import com.adincube.sdk.mediation.b;
import com.adincube.sdk.mediation.f;
import com.adincube.sdk.util.d.c;
import com.adincube.sdk.util.x;
import java.util.Collections;
import java.util.Locale;
import java.util.Map;

public final class d {
    private com.adincube.sdk.h.c.b a = null;
    private b b = null;

    public d(com.adincube.sdk.h.c.b b2, b b3) {
        this.a = b2;
        this.b = b3;
    }

    public final String a() {
        StringBuilder stringBuilder = new StringBuilder();
        String string = c.a(this.b);
        Locale locale = Locale.US;
        Object[] arrobject = new Object[]{this.a.f, string};
        stringBuilder.append(String.format((Locale)locale, (String)"A %s ad from '%s' has been shown.", (Object[])arrobject));
        stringBuilder.append(" ");
        f f2 = this.b.b();
        Map<String, String> map = f2 == null ? Collections.emptyMap() : f2.c();
        stringBuilder.append(x.a(map, ": ", ", "));
        return stringBuilder.toString();
    }
}

