/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.adincube.sdk.d.b.b
 *  java.lang.Boolean
 *  java.lang.Float
 *  java.lang.String
 *  java.lang.Throwable
 *  org.json.JSONException
 *  org.json.JSONObject
 */
package com.adincube.sdk.mediation.c;

import com.adincube.sdk.d.b.b;
import com.adincube.sdk.mediation.e;
import org.json.JSONException;
import org.json.JSONObject;

public final class i
extends e {
    public String k;
    public Boolean l;
    public Boolean m;
    public Boolean n;
    public boolean o;
    public Float p;
    public String q;

    public i(JSONObject jSONObject) {
        super(jSONObject);
        try {
            this.l = jSONObject.getBoolean("dff");
            this.m = jSONObject.getBoolean("cdt");
            this.n = jSONObject.getBoolean("tfuac");
            this.o = jSONObject.getBoolean("m");
            if (jSONObject.has("k")) {
                this.k = jSONObject.getString("k");
            }
            if (jSONObject.has("v")) {
                this.p = Float.valueOf((float)((float)jSONObject.getDouble("v")));
            }
            if (jSONObject.has("macr")) {
                this.q = jSONObject.getString("macr");
            }
            return;
        }
        catch (JSONException jSONException) {
            throw new b("AdMob", (Throwable)jSONException);
        }
    }

    @Override
    protected final String a() {
        return "AdMob";
    }
}

