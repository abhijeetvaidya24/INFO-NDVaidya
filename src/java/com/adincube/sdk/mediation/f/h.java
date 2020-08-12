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
package com.adincube.sdk.mediation.f;

import com.adincube.sdk.d.b.c;
import com.adincube.sdk.mediation.f;
import org.json.JSONException;
import org.json.JSONObject;

public final class h
extends f {
    public String e = null;

    public h(JSONObject jSONObject) {
        super(jSONObject);
        try {
            if (jSONObject.has("z")) {
                this.e = jSONObject.getString("z");
            }
            return;
        }
        catch (JSONException jSONException) {
            throw new c("AppLovin", (Throwable)jSONException);
        }
    }

    @Override
    protected final String b() {
        return "AppLovin";
    }
}

