/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.adincube.sdk.d.b.b
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.Throwable
 *  java.util.ArrayList
 *  java.util.List
 *  org.json.JSONArray
 *  org.json.JSONException
 *  org.json.JSONObject
 */
package com.adincube.sdk.mediation.b;

import com.adincube.sdk.d.b.b;
import com.adincube.sdk.mediation.e;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class f
extends e {
    public String k;
    public List<String> l = new ArrayList();

    public f(JSONObject jSONObject) {
        JSONArray jSONArray;
        int n2;
        super(jSONObject);
        try {
            this.k = jSONObject.getString("k");
            jSONArray = jSONObject.getJSONArray("z");
            n2 = 0;
        }
        catch (JSONException jSONException) {
            b b2;
            b2 = new b("AdColony", (Throwable)jSONException);
            throw b2;
        }
        do {
            if (n2 >= jSONArray.length()) break;
            this.l.add((Object)jSONArray.getString(n2));
            ++n2;
        } while (true);
        return;
    }

    @Override
    protected final String a() {
        return "AdColony";
    }
}

