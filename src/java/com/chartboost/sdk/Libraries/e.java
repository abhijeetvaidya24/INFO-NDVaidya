/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.chartboost.sdk.Tracking.a
 *  java.lang.Exception
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  org.json.JSONException
 *  org.json.JSONObject
 */
package com.chartboost.sdk.Libraries;

import org.json.JSONException;
import org.json.JSONObject;

public class e {
    public static a a(String string2, Object object) {
        return new a(string2, object);
    }

    public static /* varargs */ JSONObject a(JSONObject jSONObject, String ... arrstring) {
        for (String string2 : arrstring) {
            if (jSONObject == null) {
                return jSONObject;
            }
            jSONObject = jSONObject.optJSONObject(string2);
        }
        return jSONObject;
    }

    public static /* varargs */ JSONObject a(a ... arra) {
        JSONObject jSONObject = new JSONObject();
        for (a a2 : arra) {
            e.a(jSONObject, a2.a, a2.b);
        }
        return jSONObject;
    }

    public static void a(JSONObject jSONObject, String string2, Object object) {
        try {
            jSONObject.put(string2, object);
            return;
        }
        catch (JSONException jSONException) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("put (");
            stringBuilder.append(string2);
            stringBuilder.append(")");
            com.chartboost.sdk.Tracking.a.a(e.class, (String)stringBuilder.toString(), (Exception)((Object)jSONException));
            return;
        }
    }

    public static class a {
        final String a;
        final Object b;

        public a(String string2, Object object) {
            this.a = string2;
            this.b = object;
        }
    }

}

