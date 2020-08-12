/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.net.Uri
 *  android.net.Uri$Builder
 *  java.lang.Object
 *  java.lang.String
 *  java.util.Locale
 *  java.util.Map
 */
package com.tappx.a.a.a.b;

import android.net.Uri;
import com.tappx.a.a.a.b.a.b;
import com.tappx.a.a.a.b.a.e;
import com.tappx.a.a.a.b.a.g;
import com.tappx.a.a.a.b.a.h;
import com.tappx.a.a.a.b.k;
import java.util.Locale;
import java.util.Map;

public class d
extends e<com.tappx.a.a.a.h.b> {
    private static final String a = "ES";
    private static final String b = com.tappx.a.a.a.h.a("Atea2vjkWMaKJqXPDr3CPg");
    private static final int c = 10000;
    private static final int d = 1;
    private static final float e = 1.0f;
    private final String f;
    private final k g;

    d(k k2, g.b<com.tappx.a.a.a.h.b> b2, g.a a2) {
        super(b2, a2);
        this.g = k2;
        this.f = com.tappx.a.a.a.a.a.d();
        this.a(true);
        this.a(new h(10000, 1, 1.0f));
    }

    private String e() {
        Locale locale = Locale.getDefault();
        if (locale == null) {
            return a;
        }
        return locale.getLanguage().toUpperCase(Locale.US);
    }

    @Override
    public e.a a() {
        return e.a.b;
    }

    @Override
    protected g<com.tappx.a.a.a.h.b> a(com.tappx.a.a.a.b.a.d d2) {
        try {
            g<com.tappx.a.a.a.h.b> g2 = g.a(this.g.b(d2));
            return g2;
        }
        catch (com.tappx.a.a.a.e.a.a a2) {
            return g.a(new b(b.a.c));
        }
    }

    @Override
    public String b() {
        Uri.Builder builder = Uri.parse((String)this.f).buildUpon();
        builder.appendQueryParameter(b, this.e());
        return builder.build().toString();
    }

    @Override
    public byte[] c() {
        return null;
    }

    @Override
    public Map<String, String> d() {
        return this.aa();
    }

}

