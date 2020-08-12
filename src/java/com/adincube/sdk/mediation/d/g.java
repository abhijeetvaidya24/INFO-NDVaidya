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
package com.adincube.sdk.mediation.d;

import com.adincube.sdk.d.b.b;
import com.adincube.sdk.mediation.e;
import org.json.JSONException;
import org.json.JSONObject;

public final class g
extends e {
    public String k;

    public g(JSONObject jSONObject) {
        super(jSONObject);
        try {
            this.k = jSONObject.getString("k");
            return;
        }
        catch (JSONException jSONException) {
            throw new b("AerServ", (Throwable)jSONException);
        }
    }

    @Override
    protected final String a() {
        return "AerServ";
    }
}

