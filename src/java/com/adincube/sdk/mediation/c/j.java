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
package com.adincube.sdk.mediation.c;

import com.adincube.sdk.d.b.c;
import com.adincube.sdk.mediation.f;
import org.json.JSONException;
import org.json.JSONObject;

public final class j
extends f {
    public String e;

    public j(JSONObject jSONObject) {
        super(jSONObject);
        try {
            this.e = jSONObject.getString("aui");
            return;
        }
        catch (JSONException jSONException) {
            throw new c("AdMob", (Throwable)jSONException);
        }
    }

    @Override
    protected final String b() {
        return "AdMob";
    }
}

