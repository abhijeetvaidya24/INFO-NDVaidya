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

public class i {
    public static final i A;
    public static final i B;
    public static final i C;
    public static final i D;
    public static final i E;
    public static final i F;
    public static final i G;
    public static final i H;
    public static final i I;
    private static final Set<String> K;
    public static final i a;
    public static final i b;
    public static final i c;
    public static final i d;
    public static final i e;
    public static final i f;
    public static final i g;
    public static final i h;
    public static final i i;
    public static final i j;
    public static final i k;
    public static final i l;
    public static final i m;
    public static final i n;
    public static final i o;
    public static final i p;
    public static final i q;
    public static final i r;
    public static final i s;
    public static final i t;
    public static final i u;
    public static final i v;
    public static final i w;
    public static final i x;
    public static final i y;
    public static final i z;
    private final String J;

    static {
        K = new HashSet(64);
        a = i.a("is");
        b = i.a("cai");
        c = i.a("dp");
        d = i.a("fbs");
        e = i.a("rr");
        f = i.a("rt");
        g = i.a("ito");
        h = i.a("asd");
        i = i.a("caa");
        j = i.a("cnai");
        k = i.a("cnav");
        l = i.a("cva");
        m = i.a("fma");
        n = i.a("fna");
        o = i.a("fnna");
        p = i.a("fta");
        q = i.a("par");
        r = i.a("psvr");
        s = i.a("pvwr");
        t = i.a("raa");
        u = i.a("rna");
        v = i.a("rva");
        w = i.a("rrwd");
        x = i.a("rvw");
        y = i.a("ua");
        z = i.a("vr");
        A = i.a("aia");
        B = i.a("cs");
        C = i.a("fnma");
        D = i.a("lad");
        E = i.a("pmw");
        F = i.a("pnma");
        G = i.a("tma");
        H = i.a("tsc");
        I = i.a("fmp");
        i.a("das");
        i.a("bt");
    }

    protected i(String string2) {
        this.J = string2;
    }

    private static i a(String string2) {
        if (!TextUtils.isEmpty((CharSequence)string2)) {
            if (!K.contains((Object)string2)) {
                K.add((Object)string2);
                return new i(string2);
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Key has already been used: ");
            stringBuilder.append(string2);
            throw new IllegalArgumentException(stringBuilder.toString());
        }
        throw new IllegalArgumentException("No key name specified");
    }

    public String a() {
        return this.J;
    }
}

