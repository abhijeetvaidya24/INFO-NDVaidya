/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Integer
 *  java.lang.Object
 *  java.lang.RuntimeException
 *  java.lang.String
 *  java.lang.System
 *  java.util.ArrayList
 *  java.util.Arrays
 *  java.util.Collections
 *  java.util.List
 *  java.util.Map
 *  org.json.JSONException
 *  org.json.JSONObject
 */
package com.adincube.sdk.g.b;

import com.adincube.sdk.g.a;
import com.adincube.sdk.g.b.e.a.b;
import com.adincube.sdk.h.b.c;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public final class e {
    com.adincube.sdk.h.c.b a;
    int b = 0;
    int c;
    a d;
    com.adincube.sdk.g.b.e.b.b e = null;
    com.adincube.sdk.g.b.e.a.a f = null;

    public e(com.adincube.sdk.h.c.b b2, a a2) {
        this(b2, a2, new b("back-cfg"), new com.adincube.sdk.g.b.e.b.a(b2, "back-no"));
    }

    private e(com.adincube.sdk.h.c.b b2, a a2, com.adincube.sdk.g.b.e.a.a a3, com.adincube.sdk.g.b.e.b.b b3) {
        this.a = b2;
        this.c = 3;
        this.d = a2;
        this.e = b3;
        this.f = a3;
    }

    static com.adincube.sdk.h.b.b a() {
        com.adincube.sdk.h.b.b b2;
        b2 = new com.adincube.sdk.h.b.b();
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("to", 900);
            jSONObject.put("oto", (Object)new JSONObject());
            jSONObject.put("nnacl", (Object)new JSONObject());
            jSONObject.put("bcp", true);
            jSONObject.put("mnatl", 10);
            jSONObject.put("mpvvi", 1.0);
            jSONObject.put("k", (Object)"hVDr9tXqFF_UyOsQMVZnvXHc1p-ucsyJMA8V2gKIwJnthcI37tq0O6dPvbIVSFpqQyKScelXzWPf8hiFTXGydv");
            jSONObject.put("m", false);
            b2.R.put((Object)"AppLovin", (Object)jSONObject);
            b2.a = System.currentTimeMillis();
            b2.d = "00000000000=";
            b2.e = 200;
            b2.f = 0;
            b2.h = 1;
            b2.i = 2;
            b2.j = 3;
            b2.k.put((Object)com.adincube.sdk.h.c.b.a, (Object)3);
            b2.k.put((Object)com.adincube.sdk.h.c.b.b, (Object)1);
            b2.k.put((Object)com.adincube.sdk.h.c.b.c, (Object)3);
            b2.k.put((Object)com.adincube.sdk.h.c.b.d, (Object)3);
            b2.l = 7000L;
            b2.n = Collections.emptyList();
            c[] arrc = new c[]{c.a};
            b2.p = Arrays.asList((Object[])arrc);
            b2.s = 60000L;
            b2.t = 60000L;
            b2.u = 30000L;
            b2.v = 300000L;
            b2.w = 1000L;
            b2.x = 1000L;
            b2.y = 3000L;
            b2.z = 10000L;
            b2.A = -1L;
            b2.B = true;
            b2.C = true;
            b2.G = true;
            b2.E = -1L;
            b2.G = false;
            b2.D = false;
            b2.H = 1;
            b2.I = 3;
            b2.J = 3;
            Object[] arrobject = new Integer[]{1, 4, 7};
            b2.K = Arrays.asList((Object[])arrobject);
            b2.L = 5;
            b2.N = new ArrayList();
            b2.O = new ArrayList();
            b2.P = new ArrayList();
            b2.Q = 3000L;
            b2.T = 3000;
            b2.U = 15000;
            b2.V = 10;
            b2.W = 1000;
            b2.X = 4000;
            b2.Y = 1;
        }
        catch (RuntimeException | JSONException throwable) {}
        return b2;
    }
}

