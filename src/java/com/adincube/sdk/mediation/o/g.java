/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.String
 *  org.json.JSONObject
 */
package com.adincube.sdk.mediation.o;

import com.adincube.sdk.mediation.f;
import org.json.JSONObject;

public final class g
extends f {
    public String e;

    public g(JSONObject jSONObject) {
        super(jSONObject);
        this.e = jSONObject.optString("p");
    }

    @Override
    protected final String b() {
        return "IronSource";
    }
}

