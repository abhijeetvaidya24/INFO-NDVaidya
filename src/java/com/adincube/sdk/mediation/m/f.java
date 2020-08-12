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
package com.adincube.sdk.mediation.m;

import com.adincube.sdk.d.b.c;
import org.json.JSONException;
import org.json.JSONObject;

public final class f
extends com.adincube.sdk.mediation.f {
    public long e;

    public f(JSONObject jSONObject) {
        super(jSONObject);
        try {
            this.e = jSONObject.getLong("pi");
            return;
        }
        catch (JSONException jSONException) {
            throw new c("InMobi", (Throwable)jSONException);
        }
    }

    @Override
    protected final String b() {
        return "InMobi";
    }
}

