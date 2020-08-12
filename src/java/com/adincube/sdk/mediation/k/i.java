/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.adincube.sdk.d.b.c
 *  java.lang.String
 *  java.lang.Throwable
 *  org.json.JSONException
 *  org.json.JSONObject
 */
package com.adincube.sdk.mediation.k;

import com.adincube.sdk.d.b.c;
import com.adincube.sdk.mediation.f;
import org.json.JSONException;
import org.json.JSONObject;

public final class i
extends f {
    public String e;
    public boolean f;

    public i(JSONObject jSONObject) {
        super(jSONObject);
        try {
            this.e = jSONObject.getString("p");
            this.f = false;
            if (jSONObject.has("nb")) {
                this.f = jSONObject.getBoolean("nb");
            }
            return;
        }
        catch (JSONException jSONException) {
            throw new c("Facebook", (Throwable)jSONException);
        }
    }

    @Override
    protected final String b() {
        return "Facebook";
    }
}

