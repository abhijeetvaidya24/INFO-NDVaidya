/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.adincube.sdk.d.b.b
 *  java.lang.String
 *  java.lang.Throwable
 *  org.json.JSONException
 *  org.json.JSONObject
 */
package com.adincube.sdk.mediation.q;

import com.adincube.sdk.d.b.b;
import com.adincube.sdk.mediation.e;
import org.json.JSONException;
import org.json.JSONObject;

public final class d
extends e {
    public String k;
    public String l;
    public boolean m = true;
    public boolean n = true;

    public d(JSONObject jSONObject) {
        super(jSONObject);
        try {
            this.k = jSONObject.getString("ai");
            this.l = jSONObject.getString("k");
            if (jSONObject.has("nvs")) {
                this.m = jSONObject.getBoolean("nvs");
            }
            if (jSONObject.has("mvaf")) {
                this.n = jSONObject.getBoolean("mvaf");
            }
            return;
        }
        catch (JSONException jSONException) {
            throw new b("Mobvista", (Throwable)jSONException);
        }
    }

    @Override
    protected final String a() {
        return "Mobvista";
    }
}

