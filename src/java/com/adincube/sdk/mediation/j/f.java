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
package com.adincube.sdk.mediation.j;

import com.adincube.sdk.d.b.b;
import com.adincube.sdk.mediation.e;
import org.json.JSONException;
import org.json.JSONObject;

public final class f
extends e {
    public Boolean k;
    public Boolean l;
    public Boolean m;
    public Float n;

    public f(JSONObject jSONObject) {
        super(jSONObject);
        try {
            this.k = jSONObject.getBoolean("dff");
            this.l = jSONObject.getBoolean("cdt");
            if (jSONObject.has("m")) {
                this.m = jSONObject.getBoolean("m");
            }
            if (jSONObject.has("v")) {
                this.n = Float.valueOf((float)((float)jSONObject.getDouble("v")));
            }
            return;
        }
        catch (JSONException jSONException) {
            throw new b("DoubleClick", (Throwable)jSONException);
        }
    }

    @Override
    protected final String a() {
        return "DoubleClick";
    }
}

