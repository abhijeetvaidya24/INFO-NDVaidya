/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.adincube.sdk.d.b.b
 *  java.lang.Exception
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.Throwable
 *  java.util.ArrayList
 *  java.util.List
 *  org.json.JSONArray
 *  org.json.JSONObject
 */
package com.adincube.sdk.mediation.ac;

import com.adincube.sdk.d.b.b;
import com.adincube.sdk.mediation.e;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public final class f
extends e {
    public List<String> k;
    public String l;
    public boolean m;
    public boolean n;
    public boolean o;

    public f(JSONObject jSONObject) {
        super(jSONObject);
        JSONArray jSONArray = jSONObject.getJSONArray("p");
        this.k = new ArrayList(jSONArray.length());
        int n2 = 0;
        do {
            if (n2 >= jSONArray.length()) break;
            this.k.add((Object)jSONArray.getString(n2));
            ++n2;
        } while (true);
        try {
            this.l = jSONObject.getString("k");
            this.m = jSONObject.getBoolean("m");
            this.n = jSONObject.getBoolean("b");
            this.o = "AUTOROTATE".equals((Object)jSONObject.getString("o"));
            return;
        }
        catch (Exception exception) {
            b b2;
            b2 = new b("Vungle", (Throwable)exception);
            throw b2;
        }
    }

    @Override
    protected final String a() {
        return "Vungle";
    }
}

