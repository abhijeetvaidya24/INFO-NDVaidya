/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Boolean
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  org.json.JSONObject
 */
package com.applovin.impl.mediation.a;

import com.applovin.impl.mediation.a.e;
import com.applovin.impl.sdk.j;
import org.json.JSONObject;

public class g
extends e {
    public g(JSONObject jSONObject, JSONObject jSONObject2, j j2) {
        super(jSONObject, jSONObject2, j2);
    }

    int a() {
        return this.a("max_signal_length", 2048);
    }

    public boolean b() {
        return this.b("only_collect_signal_when_initialized", false);
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("SignalProviderSpec{specObject=");
        stringBuilder.append((Object)this.s());
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}

