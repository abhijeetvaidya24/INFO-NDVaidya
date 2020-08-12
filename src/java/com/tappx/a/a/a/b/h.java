/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.net.Uri
 *  android.net.Uri$Builder
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.Void
 *  java.util.Map
 */
package com.tappx.a.a.a.b;

import android.net.Uri;
import com.tappx.a.a.a.b.a.b;
import com.tappx.a.a.a.b.a.d;
import com.tappx.a.a.a.b.a.e;
import com.tappx.a.a.a.b.a.g;
import com.tappx.a.a.a.b.g;
import com.tappx.a.a.a.b.h;
import com.tappx.a.a.a.d.ac;
import com.tappx.a.a.a.d.b;
import com.tappx.a.a.a.d.z;
import com.tappx.a.a.a.h.i;
import java.util.Map;

public class h
extends e<Void> {
    private static final String a = "1";
    private static final String b = "u";
    private static final String c = "d";
    private static final String d = com.tappx.a.a.a.h.a("Y3lXBmQ23xTYiukQ1UnbWw");
    private static final String e = com.tappx.a.a.a.h.a("KG6txY+dAsHV+aE9vCpHOQ");
    private static final String f = com.tappx.a.a.a.h.a("FzLBfq4NHhh6H3aZu09wNg");
    private static final String g = "o";
    private static final String h = com.tappx.a.a.a.h.a("5RPecgzrVUOe/I8D8SnSVA");
    private static final String i = com.tappx.a.a.a.h.a("p2JtzU2YCqXoi6X+GUHC9A");
    private static final String j = com.tappx.a.a.a.h.a("ChYe7NtYsJ5it5MJ0kItoQ");
    private static final int k = 10000;
    private static final int l = 1;
    private static final float m = 1.0f;
    private final ac.a n;
    private final z.a o;
    private final b.a p;
    private final long q;
    private final i r;
    private final String s;

    h(String string, g.b<Void> b2, g.a a2, ac.a a3, z.a a4, b.a a5, long l2, i i2) {
        super(b2, a2);
        this.s = string;
        this.n = a3;
        this.o = a4;
        this.p = a5;
        this.a(false);
        this.a(new com.tappx.a.a.a.b.a.h(10000, 1, 1.0f));
        this.q = l2;
        this.r = i2;
    }

    private String a(i i2) {
        int n2 = 1.a[i2.ordinal()];
        if (n2 != 1 && n2 != 2) {
            return b;
        }
        return c;
    }

    @Override
    public e.a a() {
        return e.a.b;
    }

    @Override
    protected com.tappx.a.a.a.b.a.g<Void> a(d d2) {
        if (a.equals((Object)d2.a())) {
            return com.tappx.a.a.a.b.a.g.a(null);
        }
        return com.tappx.a.a.a.b.a.g.a(new b(b.a.c));
    }

    @Override
    public String b() {
        Uri.Builder builder = Uri.parse((String)this.s).buildUpon();
        ac ac2 = this.n.a();
        com.tappx.a.a.a.d.b b2 = this.p.a();
        z z2 = this.o.a();
        builder.appendQueryParameter(d, ac2.f);
        builder.appendQueryParameter(e, ac2.e);
        String string = f;
        String string2 = this.r.c() ? "0" : a;
        builder.appendQueryParameter(string, string2);
        builder.appendQueryParameter(g, this.a(this.r));
        builder.appendQueryParameter(h, String.valueOf((long)this.q));
        builder.appendQueryParameter(i, z2.a);
        builder.appendQueryParameter(j, b2.a);
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

