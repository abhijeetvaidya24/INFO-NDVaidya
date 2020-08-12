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
package com.adincube.sdk.mediation.chartboost;

import com.adincube.sdk.d.b.b;
import org.json.JSONException;
import org.json.JSONObject;

public final class e
extends com.adincube.sdk.mediation.e {
    String k;
    String l;

    public e(JSONObject jSONObject) {
        super(jSONObject);
        try {
            this.k = jSONObject.getString("k");
            this.l = jSONObject.getString("s");
            return;
        }
        catch (JSONException jSONException) {
            throw new b("Chartboost", (Throwable)jSONException);
        }
    }

    @Override
    protected final String a() {
        return "Chartboost";
    }
}

