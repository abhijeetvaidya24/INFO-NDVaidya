/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.adincube.sdk.d.b.c
 *  java.lang.Integer
 *  java.lang.String
 *  java.lang.Throwable
 *  org.json.JSONException
 *  org.json.JSONObject
 */
package com.adincube.sdk.mediation.r;

import com.adincube.sdk.d.b.c;
import com.adincube.sdk.mediation.f;
import org.json.JSONException;
import org.json.JSONObject;

public final class j
extends f {
    public String e;
    public Integer f;
    public Integer g;

    public j(JSONObject jSONObject) {
        super(jSONObject);
        try {
            this.e = jSONObject.getString("ai");
            if (jSONObject.has("bw") && jSONObject.has("bh")) {
                this.f = jSONObject.getInt("bw");
                this.g = jSONObject.getInt("bh");
            }
            return;
        }
        catch (JSONException jSONException) {
            throw new c("MoPub", (Throwable)jSONException);
        }
    }

    @Override
    protected final String b() {
        return "MoPub";
    }
}

