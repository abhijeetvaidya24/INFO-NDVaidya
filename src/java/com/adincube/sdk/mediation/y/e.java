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
package com.adincube.sdk.mediation.y;

import com.adincube.sdk.d.b.b;
import org.json.JSONException;
import org.json.JSONObject;

public final class e
extends com.adincube.sdk.mediation.e {
    public String k;

    public e(JSONObject jSONObject) {
        super(jSONObject);
        try {
            this.k = jSONObject.getString("k");
            return;
        }
        catch (JSONException jSONException) {
            throw new b("Tapjoy", (Throwable)jSONException);
        }
    }

    @Override
    protected final String a() {
        return "Tapjoy";
    }
}

