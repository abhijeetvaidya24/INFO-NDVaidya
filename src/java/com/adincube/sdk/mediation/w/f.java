/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.adincube.sdk.d.b.b
 *  com.adincube.sdk.h.b.d
 *  java.lang.Double
 *  java.lang.Long
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.Throwable
 *  java.util.Iterator
 *  java.util.Map
 *  org.json.JSONException
 *  org.json.JSONObject
 */
package com.adincube.sdk.mediation.w;

import com.adincube.sdk.d.b.b;
import com.adincube.sdk.h.b.d;
import com.adincube.sdk.mediation.e;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public final class f
extends e {
    public long k;
    public Long l;
    public Long m;
    public long n;
    public long o;
    public String p;
    public boolean q;
    public long r;
    public boolean s;
    public boolean t;
    public double u;
    public d v;

    public f(JSONObject jSONObject) {
        super(jSONObject);
        try {
            this.k = jSONObject.getLong("mc");
            this.n = jSONObject.getLong("mcms");
            if (jSONObject.has("mcm")) {
                this.l = jSONObject.getLong("mcm");
            }
            if (jSONObject.has("mcmfl")) {
                this.m = jSONObject.getLong("mcmfl");
            }
            this.o = jSONObject.getLong("msib");
            if (jSONObject.has("afs")) {
                this.p = jSONObject.getString("afs");
            }
            this.q = jSONObject.getBoolean("iowui");
            this.r = jSONObject.getLong("mtbsar");
            this.s = jSONObject.getBoolean("exo");
            this.t = jSONObject.getBoolean("mpm");
            this.u = jSONObject.getDouble("pbnr");
            JSONObject jSONObject2 = jSONObject.getJSONObject("mfsp");
            d d2 = new d();
            d2.a = jSONObject2.getString("t");
            d2.b = jSONObject2.getDouble("s");
            d2.c = jSONObject2.getDouble("d");
            d2.d = jSONObject2.getDouble("u");
            JSONObject jSONObject3 = jSONObject2.getJSONObject("f");
            Iterator iterator = jSONObject3.keys();
            while (iterator.hasNext()) {
                String string = (String)iterator.next();
                Double d3 = jSONObject3.getDouble(string);
                d2.e.put((Object)string, (Object)d3);
            }
            d2.f = jSONObject2.getInt("b");
            d2.g = jSONObject2.getDouble("bs");
            d2.h = jSONObject2.getDouble("bps");
            this.v = d2;
            return;
        }
        catch (JSONException jSONException) {
            b b2;
            b2 = new b("RTB", (Throwable)jSONException);
            throw b2;
        }
    }

    @Override
    protected final String a() {
        return "RTB";
    }
}

