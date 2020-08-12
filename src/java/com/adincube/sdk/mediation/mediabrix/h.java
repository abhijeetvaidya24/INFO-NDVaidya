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
package com.adincube.sdk.mediation.mediabrix;

import com.adincube.sdk.d.b.c;
import com.adincube.sdk.mediation.f;
import org.json.JSONException;
import org.json.JSONObject;

public final class h
extends f {
    public String e;

    public h(JSONObject jSONObject) {
        super(jSONObject);
        try {
            this.e = jSONObject.getString("t");
            return;
        }
        catch (JSONException jSONException) {
            throw new c("MediaBrix", (Throwable)jSONException);
        }
    }

    @Override
    protected final String b() {
        return "MediaBrix";
    }
}

