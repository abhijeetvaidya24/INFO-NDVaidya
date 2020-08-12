/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.String
 *  org.json.JSONObject
 */
package com.adincube.sdk.mediation.r;

import com.adincube.sdk.mediation.e;
import org.json.JSONObject;

public final class i
extends e {
    public boolean k;

    public i(JSONObject jSONObject) {
        super(jSONObject);
        this.k = jSONObject.optBoolean("vtd", false);
    }

    @Override
    protected final String a() {
        return "MoPub";
    }
}

