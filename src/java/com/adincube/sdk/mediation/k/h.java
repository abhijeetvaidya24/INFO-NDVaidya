/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.adincube.sdk.d.b.b
 *  java.lang.Enum
 *  java.lang.Exception
 *  java.lang.IllegalStateException
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.Throwable
 *  org.json.JSONObject
 */
package com.adincube.sdk.mediation.k;

import com.adincube.sdk.d.b.b;
import com.adincube.sdk.mediation.e;
import org.json.JSONObject;

public final class h
extends e {
    public boolean k;
    public boolean l;
    public a m;

    public h(JSONObject jSONObject) {
        super(jSONObject);
        try {
            this.k = jSONObject.getBoolean("cd");
            this.l = jSONObject.getBoolean("a");
            this.m = a.a(jSONObject.getString("ntm"));
            return;
        }
        catch (Exception exception) {
            throw new b("Facebook", (Throwable)exception);
        }
    }

    @Override
    protected final String a() {
        return "Facebook";
    }

}

