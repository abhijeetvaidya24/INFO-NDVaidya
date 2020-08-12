/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Integer
 *  java.lang.Long
 *  java.lang.String
 *  org.json.JSONObject
 */
package com.adincube.sdk.mediation.e;

import com.adincube.sdk.mediation.f;
import org.json.JSONObject;

public final class g
extends f {
    public g(JSONObject jSONObject) {
        super(jSONObject);
    }

    @Override
    protected final String b() {
        return null;
    }

    public final Long d() {
        if (this.b == null) {
            return null;
        }
        return 1000L * (long)this.b.intValue();
    }
}

