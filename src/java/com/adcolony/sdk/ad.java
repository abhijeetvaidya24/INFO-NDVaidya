/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.String
 *  org.json.JSONException
 *  org.json.JSONObject
 */
package com.adcolony.sdk;

import com.adcolony.sdk.a;
import com.adcolony.sdk.y;
import org.json.JSONException;
import org.json.JSONObject;

class ad {
    private String a;
    private JSONObject b;

    ad(String string, int n2) {
        try {
            this.a = string;
            this.b = new JSONObject();
            this.b.put("m_target", n2);
            return;
        }
        catch (JSONException jSONException) {
            new y.a().a("JSON Error in ADCMessage constructor: ").a(jSONException.toString()).a(y.h);
            return;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    ad(String string, int n2, JSONObject jSONObject) {
        try {
            this.a = string;
            if (jSONObject == null) {
                jSONObject = new JSONObject();
            }
            this.b = jSONObject;
            this.b.put("m_target", n2);
            return;
        }
        catch (JSONException jSONException) {
            new y.a().a("JSON Error in ADCMessage constructor: ").a(jSONException.toString()).a(y.h);
            return;
        }
    }

    ad(JSONObject jSONObject) {
        try {
            this.b = jSONObject;
            this.a = jSONObject.getString("m_type");
            return;
        }
        catch (JSONException jSONException) {
            new y.a().a("JSON Error in ADCMessage constructor: ").a(jSONException.toString()).a(y.h);
            return;
        }
    }

    ad a(JSONObject jSONObject) {
        try {
            ad ad2 = new ad("reply", this.b.getInt("m_origin"), jSONObject);
            ad2.b.put("m_id", this.b.getInt("m_id"));
            return ad2;
        }
        catch (JSONException jSONException) {
            new y.a().a("JSON error in ADCMessage's createReply(): ").a(jSONException.toString()).a(y.h);
            return new ad("JSONException", 0);
        }
    }

    void b() {
        a.a(this.a, this.b);
    }

    JSONObject c() {
        return this.b;
    }

    String d() {
        return this.a;
    }
}

