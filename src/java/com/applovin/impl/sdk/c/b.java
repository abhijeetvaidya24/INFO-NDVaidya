/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.text.TextUtils
 *  java.lang.CharSequence
 *  java.lang.IllegalArgumentException
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.util.HashSet
 *  java.util.Set
 */
package com.applovin.impl.sdk.c;

import android.text.TextUtils;
import java.util.HashSet;
import java.util.Set;

class b {
    static final b A;
    private static final Set<String> C;
    static final b a;
    static final b b;
    static final b c;
    static final b d;
    static final b e;
    static final b f;
    static final b g;
    static final b h;
    static final b i;
    static final b j;
    static final b k;
    static final b l;
    static final b m;
    static final b n;
    static final b o;
    static final b p;
    static final b q;
    static final b r;
    static final b s;
    static final b t;
    static final b u;
    static final b v;
    static final b w;
    static final b x;
    static final b y;
    static final b z;
    private final String B;

    static {
        C = new HashSet(31);
        b.a("sasw");
        b.a("sisw");
        b.a("surw");
        b.a("surp");
        b.a("swhp");
        a = b.a("sas");
        b = b.a("srt");
        c = b.a("sft");
        d = b.a("sfs");
        e = b.a("sadb");
        f = b.a("sacb");
        g = b.a("stdl");
        h = b.a("stdi");
        i = b.a("snas");
        j = b.a("snat");
        k = b.a("stah");
        l = b.a("stas");
        m = b.a("stac");
        n = b.a("stbe");
        o = b.a("stbc");
        p = b.a("saan");
        q = b.a("suvs");
        r = b.a("sugs");
        s = b.a("svpv");
        t = b.a("stpd");
        u = b.a("sspe");
        v = b.a("shsc");
        w = b.a("shfc");
        x = b.a("svmi");
        y = b.a("stvm");
        z = b.a("schc");
        A = b.a("smwm");
    }

    private b(String string2) {
        this.B = string2;
    }

    private static b a(String string2) {
        if (!TextUtils.isEmpty((CharSequence)string2)) {
            if (!C.contains((Object)string2)) {
                C.add((Object)string2);
                return new b(string2);
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Key has already been used: ");
            stringBuilder.append(string2);
            throw new IllegalArgumentException(stringBuilder.toString());
        }
        throw new IllegalArgumentException("No key name specified");
    }

    public String a() {
        return this.B;
    }
}

