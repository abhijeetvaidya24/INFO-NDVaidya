/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.String
 *  java.lang.Void
 *  java.util.Comparator
 *  java.util.Map
 *  java.util.TreeMap
 */
package com.tappx.a.a.a.i.a;

import com.tappx.a.a.a.b.a.d;
import com.tappx.a.a.a.b.a.e;
import com.tappx.a.a.a.b.a.g;
import com.tappx.a.a.a.b.a.h;
import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

class c
extends e<Void> {
    private final String d;

    protected c(String string, g.b<Void> b2, g.a a2) {
        super(b2, a2);
        this.d = string;
        this.a(new h(10000, 0, 0.0f).a(false));
        this.a(e.b.a);
    }

    @Override
    public e.a a() {
        return e.a.b;
    }

    @Override
    protected g<Void> a(d d2) {
        return g.a(null);
    }

    @Override
    public String b() {
        return this.d;
    }

    @Override
    public byte[] c() {
        return new byte[0];
    }

    @Override
    public Map<String, String> d() {
        return new TreeMap(String.CASE_INSENSITIVE_ORDER);
    }
}

