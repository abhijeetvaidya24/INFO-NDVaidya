/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Class
 *  java.lang.Object
 *  java.lang.String
 *  org.json.JSONException
 *  org.json.JSONObject
 */
package com.yandex.metrica.impl.ob;

import org.json.JSONException;
import org.json.JSONObject;

public final class cm {
    private final String a;
    private final int b;
    private final boolean c;

    public cm(String string2, int n2, boolean bl2) {
        this.a = string2;
        this.b = n2;
        this.c = bl2;
    }

    public cm(String string2, boolean bl2) {
        this(string2, -1, bl2);
    }

    public cm(JSONObject jSONObject) throws JSONException {
        this.a = jSONObject.getString("name");
        this.c = jSONObject.getBoolean("required");
        this.b = jSONObject.optInt("version", -1);
    }

    public JSONObject a() throws JSONException {
        JSONObject jSONObject = new JSONObject().put("name", (Object)this.a).put("required", this.c);
        int n2 = this.b;
        if (n2 != -1) {
            jSONObject.put("version", n2);
        }
        return jSONObject;
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object != null) {
            if (this.getClass() != object.getClass()) {
                return false;
            }
            cm cm2 = (cm)object;
            if (this.b != cm2.b) {
                return false;
            }
            if (this.c != cm2.c) {
                return false;
            }
            String string2 = this.a;
            if (string2 != null) {
                return string2.equals((Object)cm2.a);
            }
            if (cm2.a == null) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        String string2 = this.a;
        int n2 = string2 != null ? string2.hashCode() : 0;
        return 31 * (n2 * 31 + this.b) + this.c;
    }
}

