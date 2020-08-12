/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.adincube.sdk.d.b.b
 *  java.lang.Enum
 *  java.lang.Exception
 *  java.lang.IllegalArgumentException
 *  java.lang.IllegalStateException
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.Throwable
 *  org.json.JSONObject
 */
package com.adincube.sdk.mediation.g;

import com.adincube.sdk.mediation.e;
import org.json.JSONObject;

public final class g
extends e {
    public boolean k;
    public boolean l;
    public a m;
    public b n;

    public g(JSONObject jSONObject) {
        super(jSONObject);
        try {
            this.k = jSONObject.getBoolean("m");
            this.l = jSONObject.getBoolean("a");
            this.m = a.a(jSONObject.getString("ct"));
            this.n = b.a(jSONObject.getString("vl"));
            return;
        }
        catch (Exception exception) {
            throw new com.adincube.sdk.d.b.b("AppNext", (Throwable)exception);
        }
    }

    @Override
    protected final String a() {
        return "AppNext";
    }

}

