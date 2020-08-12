/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.net.Uri
 *  android.net.Uri$Builder
 *  java.io.UnsupportedEncodingException
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.System
 *  java.util.List
 *  java.util.Map
 */
package com.tappx.a.a.a.b;

import android.net.Uri;
import com.tappx.a.a.a.b.a.b;
import com.tappx.a.a.a.b.a.d;
import com.tappx.a.a.a.b.a.e;
import com.tappx.a.a.a.b.a.g;
import com.tappx.a.a.a.b.a.h;
import com.tappx.a.a.a.b.k;
import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Map;

public class f
extends e<com.tappx.a.a.a.e.f> {
    protected static final String a = "utf-8";
    private static final String b = com.tappx.a.a.a.h.a("7lAm3cGZz4MMRzfjNT4s5w");
    private static final int c = 10000;
    private static final int d = 1;
    private static final float e = 1.0f;
    private final String f;
    private final k g;
    private final String h;

    f(k k2, String string, String string2, g.b<com.tappx.a.a.a.e.f> b2, g.a a2) {
        super(b2, a2);
        this.g = k2;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(string);
        stringBuilder.append(com.tappx.a.a.a.a.a.c());
        this.f = stringBuilder.toString();
        this.h = string2;
        this.a(false);
        this.a(new h(10000, 1, 1.0f));
    }

    @Override
    public e.a a() {
        return e.a.a;
    }

    @Override
    protected g<com.tappx.a.a.a.e.f> a(d d2) {
        try {
            Object[] arrobject = new Object[]{String.valueOf((long)d2.d), this.f};
            com.tappx.a.a.a.c.a.e("zEfD4hGYqgGlREP0sIIg/hstxJ7mtJesC+XfeD//U5A", arrobject);
            com.tappx.a.a.a.e.d d3 = this.g.a(d2);
            if (!d3.b()) {
                com.tappx.a.a.a.e.b b2 = (com.tappx.a.a.a.e.b)d3.a().get(0);
                if (b2 instanceof com.tappx.a.a.a.e.f) {
                    return g.a((com.tappx.a.a.a.e.f)b2);
                }
                throw new com.tappx.a.a.a.e.a.a();
            }
            g<b> g2 = g.a(new b(b.a.d));
            return g2;
        }
        catch (com.tappx.a.a.a.e.a.a a2) {
            return g.a(new b(b.a.c));
        }
    }

    @Override
    public String b() {
        Uri.Builder builder = Uri.parse((String)this.f).buildUpon();
        builder.appendQueryParameter(b, String.valueOf((long)(System.currentTimeMillis() / 1000L)));
        return builder.build().toString();
    }

    @Override
    public byte[] c() {
        String string = this.h;
        if (string == null) {
            return null;
        }
        try {
            byte[] arrby = string.getBytes(a);
            return arrby;
        }
        catch (UnsupportedEncodingException unsupportedEncodingException) {
            com.tappx.a.a.a.c.a.e("mcDfyrZIyDh7srkDi3vhYS4jCqm7NCw5DOnMQ6j4pn8", new Object[0]);
            return null;
        }
    }

    @Override
    public Map<String, String> d() {
        return this.aa();
    }

}

