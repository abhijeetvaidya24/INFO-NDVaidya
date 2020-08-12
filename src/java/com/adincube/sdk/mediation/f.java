/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.adincube.sdk.d.b.c
 *  java.lang.Integer
 *  java.lang.Long
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.Throwable
 *  java.util.Collections
 *  java.util.Map
 *  org.json.JSONException
 *  org.json.JSONObject
 */
package com.adincube.sdk.mediation;

import com.adincube.sdk.d.b.c;
import java.util.Collections;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public abstract class f {
    public String a = null;
    public Integer b = null;
    protected Integer c = null;
    public boolean d = false;

    public f(JSONObject jSONObject) {
        try {
            if (jSONObject.has("sn")) {
                this.a = jSONObject.getString("sn");
            }
            if (jSONObject.has("f")) {
                this.b = jSONObject.getInt("f");
            }
            if (jSONObject.has("ce")) {
                this.c = jSONObject.getInt("ce");
            }
            if (jSONObject.has("fd")) {
                this.d = jSONObject.getBoolean("fd");
            }
            return;
        }
        catch (JSONException jSONException) {
            throw new c(this.b(), (Throwable)jSONException);
        }
    }

    public final Long a() {
        Integer n2 = this.c;
        if (n2 == null) {
            return null;
        }
        return 1000L * (long)n2.intValue();
    }

    public abstract String b();

    public Map<String, String> c() {
        return Collections.emptyMap();
    }
}

