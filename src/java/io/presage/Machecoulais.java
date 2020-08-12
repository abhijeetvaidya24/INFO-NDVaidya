/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.String
 *  org.json.JSONObject
 */
package io.presage;

import org.json.JSONObject;

public final class Machecoulais {
    public static final int a(JSONObject jSONObject, String string2, int n2) {
        if (jSONObject != null) {
            return jSONObject.optInt(string2, n2);
        }
        return n2;
    }

    public static final long a(JSONObject jSONObject, String string2, long l2) {
        if (jSONObject != null) {
            return jSONObject.optLong(string2, l2);
        }
        return l2;
    }

    public static final String a(JSONObject jSONObject, String string2, String string3) {
        String string4;
        if (jSONObject == null || (string4 = jSONObject.optString(string2, string3)) == null) {
            string4 = string3;
        }
        return string4;
    }

    public static final boolean a(JSONObject jSONObject) {
        return jSONObject.length() == 0;
    }

    public static final boolean a(JSONObject jSONObject, String string2, boolean bl2) {
        if (jSONObject != null) {
            return jSONObject.optBoolean(string2, bl2);
        }
        return bl2;
    }
}

