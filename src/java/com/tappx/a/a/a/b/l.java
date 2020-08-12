/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.net.Uri
 *  android.net.Uri$Builder
 *  java.io.UnsupportedEncodingException
 *  java.lang.Class
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.System
 *  java.util.Comparator
 *  java.util.Map
 *  java.util.TreeMap
 *  org.json.JSONException
 *  org.json.JSONObject
 */
package com.tappx.a.a.a.b;

import android.net.Uri;
import com.tappx.a.a.a.b.a.b;
import com.tappx.a.a.a.b.a.d;
import com.tappx.a.a.a.b.a.e;
import com.tappx.a.a.a.b.a.g;
import com.tappx.a.a.a.b.a.h;
import com.tappx.a.a.a.b.e;
import com.tappx.a.a.a.b.k;
import com.tappx.a.a.a.d.ac;
import com.tappx.a.a.a.d.b;
import com.tappx.a.a.a.d.f;
import com.tappx.a.a.a.d.w;
import com.tappx.a.a.a.d.y;
import com.tappx.a.a.a.d.z;
import com.tappx.a.a.a.e.i;
import java.io.UnsupportedEncodingException;
import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;
import org.json.JSONException;
import org.json.JSONObject;

public class l
extends com.tappx.a.a.a.b.a.e<com.tappx.a.a.a.e.d> {
    private static final String A;
    private static final String B;
    private static final String C;
    private static final String D;
    private static final String E;
    private static final String F;
    private static final String G;
    private static final String H;
    private static final String I;
    private static final String J;
    private static final String K;
    private static final String L;
    private static final String M;
    private static final String N;
    private static final String O;
    private static final String P;
    private static final String Q;
    private static final String R;
    private static final String S;
    private static final String T;
    private static final String U;
    private static final String V;
    private static final String W;
    private static final String X;
    private static final String Y;
    private static final String Z = "1";
    protected static final String a = "utf-8";
    private static final String aa = "0";
    private static final int ab = 10000;
    private static final int ac = 1;
    private static final float ad = 1.0f;
    private static final String b;
    private static final String c;
    private static final String d;
    private static final String e;
    private static final String f;
    private static final String g;
    private static final String h;
    private static final String i;
    private static final String j;
    private static final String k;
    private static final String l;
    private static final String m;
    private static final String n;
    private static final String o;
    private static final String p;
    private static final String q;
    private static final String r;
    private static final String s;
    private static final String t;
    private static final String u;
    private static final String v;
    private static final String w;
    private static final String x;
    private static final String y;
    private static final String z;
    private final i ae;
    private final String af;
    private final k ag;
    private final f.a ah;
    private final b ai;

    static {
        b = com.tappx.a.a.a.h.a("77ArF2mfR8mLfcGap5jD6g");
        c = com.tappx.a.a.a.h.a("7lAm3cGZz4MMRzfjNT4s5w");
        d = com.tappx.a.a.a.h.a("FWglxwdJfJhEJQ2u/gQTTw");
        e = com.tappx.a.a.a.h.a("C+OhxTPPpo3q0ccShq55MA");
        f = com.tappx.a.a.a.h.a("pW2LPtjW0UUX7JS2ruZS9g");
        g = com.tappx.a.a.a.h.a("b3Ty9Arp6SEsDLjDv7sQhw");
        h = com.tappx.a.a.a.h.a("Kfr1MfjhTO6k6Dkd2aU7ug");
        i = com.tappx.a.a.a.h.a("MewM3hsCD6lF4b4pq/MB/w");
        j = com.tappx.a.a.a.h.a("BofHbqtksbtqBxOOyIw2/Q");
        k = com.tappx.a.a.a.h.a("v3rpcHUEBHCj+SDrTPNLsA");
        l = com.tappx.a.a.a.h.a("KG6txY+dAsHV+aE9vCpHOQ");
        m = com.tappx.a.a.a.h.a("3dvYm6Xvl9FFfhUKlT2TtQ");
        n = com.tappx.a.a.a.h.a("khtm/xAwBWzQp10NRXGuqA");
        o = com.tappx.a.a.a.h.a("9nWGCL3NdwiFy0xSGqi5dQ");
        p = com.tappx.a.a.a.h.a("B801MW7MuCv99Bnm+Cshyw");
        q = com.tappx.a.a.a.h.a("c0Cj/XgEAkwylbtQQt2eUg");
        r = com.tappx.a.a.a.h.a("Fc2cuCXnuosnbQH2tQGPtA");
        s = com.tappx.a.a.a.h.a("D6LJLF0L3OzSTmLFSqOjvQ");
        t = com.tappx.a.a.a.h.a("G+gQdhCBmZY9f6qYFitNhw");
        u = com.tappx.a.a.a.h.a("RSQEohXlDkuDhgJBP4BD9w");
        v = com.tappx.a.a.a.h.a("sdr1wB8h8BJdTk3kOjhdVw");
        w = com.tappx.a.a.a.h.a("dQbExkxxgpJk5z4Py5H9gA");
        x = com.tappx.a.a.a.h.a("xdfsnunMP6zKUKafQp8oQA");
        y = com.tappx.a.a.a.h.a("K854LPrXhnmhmiLiBUTwFQ");
        z = com.tappx.a.a.a.h.a("Scef4ajUBa55DRiLWB02jA");
        A = com.tappx.a.a.a.h.a("zTaDp+uAqTLGxgz/Wialzg");
        B = com.tappx.a.a.a.h.a("E/zD1fv3M5fdAxTbJyGzDg");
        C = com.tappx.a.a.a.h.a("1PVYr1bWWK+ljOjtyJEBVw");
        D = com.tappx.a.a.a.h.a("9suwPwn+WLUpPD3BVjperw");
        E = com.tappx.a.a.a.h.a("+Jt+IAPBqGywGS/ciLQD8Q");
        F = com.tappx.a.a.a.h.a("qIrM1nW8iKgHCSV+09cPYg");
        G = com.tappx.a.a.a.h.a("07mcOPB5Kn5RU76uWZMDAA");
        H = com.tappx.a.a.a.h.a("Y2pS89MuwD0NqKFT0ha4Tg");
        I = com.tappx.a.a.a.h.a("ChYe7NtYsJ5it5MJ0kItoQ");
        J = com.tappx.a.a.a.h.a("7GjiqjQAzZYK8G4/W7aLAA");
        K = com.tappx.a.a.a.h.a("Q0coubMFIJvX7cMWWkNhCA");
        L = com.tappx.a.a.a.h.a("xnSvbKT08yXg5O5mePOhwA");
        M = com.tappx.a.a.a.h.a("stfgL9icAJsNR9ZpfQozUw");
        N = com.tappx.a.a.a.h.a("qqj9czY1MuOhT2XqP/tlmA");
        O = com.tappx.a.a.a.h.a("qU0lBb8lxbr9j2OfZ4UvKg");
        P = com.tappx.a.a.a.h.a("c8D2ptqQgwOdbZgSV5KsUQ");
        Q = com.tappx.a.a.a.h.a("WwPqFEhzWFBqqq0kRdmF7A");
        R = com.tappx.a.a.a.h.a("3qOsJNtxfUaX4kTgVR4tRQ");
        S = com.tappx.a.a.a.h.a("fiitS3ulxlIdz/yQTv6VIA");
        T = com.tappx.a.a.a.h.a("p+sS5Lp0dC3hu2MWuZ1KbA");
        U = com.tappx.a.a.a.h.a("xD47jZZdA1/IvKza265nxQ");
        V = com.tappx.a.a.a.h.a("dBSWv960DRaaiDVKOe2pfA");
        W = com.tappx.a.a.a.h.a("wFxvQx38+pSI6Q6/UsP42w");
        X = com.tappx.a.a.a.h.a("mgmMeavqQqGW0G+pbpSf4Q");
        Y = com.tappx.a.a.a.h.a("qspNwupZGv/L+I8ZN3mGMA");
    }

    l(k k2, String string, i i2, f.a a2, b b2, g.b<com.tappx.a.a.a.e.d> b3, g.a a3) {
        super(b3, a3);
        this.ag = k2;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(string);
        stringBuilder.append(com.tappx.a.a.a.a.a.b());
        this.af = stringBuilder.toString();
        this.ae = i2;
        this.ah = a2;
        this.ai = b2;
        this.a(false);
        this.a(new h(10000, 1, 1.0f));
    }

    private String a(String string) {
        if (string == null) {
            return null;
        }
        String string2 = string.trim();
        int n2 = string2.length();
        if (n2 >= 6) {
            if (n2 > 128) {
                return null;
            }
            return string2;
        }
        return null;
    }

    private String ab() {
        return this.ai.a(this.ae);
    }

    private static void b(JSONObject jSONObject, String string, int n2) {
        jSONObject.put(string, n2);
    }

    private static void b(JSONObject jSONObject, String string, long l2) {
        jSONObject.put(string, l2);
    }

    private static void b(JSONObject jSONObject, String string, String string2) {
        jSONObject.put(string, (Object)e.a(string2));
    }

    @Override
    public e.a a() {
        return e.a.a;
    }

    @Override
    protected g<com.tappx.a.a.a.e.d> a(d d2) {
        try {
            Object[] arrobject = new Object[]{String.valueOf((long)d2.d), this.af};
            com.tappx.a.a.a.c.a.e("zEfD4hGYqgGlREP0sIIg/hstxJ7mtJesC+XfeD//U5A", arrobject);
            g<com.tappx.a.a.a.e.d> g2 = g.a(this.ag.a(d2));
            return g2;
        }
        catch (com.tappx.a.a.a.e.a.a a2) {
            return g.a(new com.tappx.a.a.a.b.a.b(b.a.c));
        }
    }

    @Override
    public String b() {
        String string;
        String string2;
        Uri.Builder builder = Uri.parse((String)this.af).buildUpon();
        builder.appendQueryParameter(c, String.valueOf((long)(System.currentTimeMillis() / 1000L)));
        if (this.ae.a() != null) {
            builder.appendQueryParameter(f, e.a(this.ae.a()));
        }
        if ((string2 = this.a(this.ae.d())) != null) {
            builder.appendQueryParameter(d, string2);
        }
        if ((string = e.a(this.ae.b())) != null) {
            builder.appendQueryParameter(e, string);
        }
        String string3 = g;
        String string4 = this.ae.j() ? Z : aa;
        builder.appendQueryParameter(string3, string4);
        return builder.build().toString();
    }

    @Override
    public byte[] c() {
        String string = this.ab();
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
        TreeMap treeMap = new TreeMap(String.CASE_INSENSITIVE_ORDER);
        treeMap.put((Object)b, (Object)this.ah.a().j);
        return treeMap;
    }

}

