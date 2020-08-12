/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.os.Build
 *  android.os.Build$VERSION
 *  java.lang.Exception
 *  java.lang.Object
 *  java.lang.String
 *  org.json.JSONArray
 *  org.json.JSONObject
 */
package com.moat.analytics.mobile.tjy;

import android.os.Build;
import org.json.JSONArray;
import org.json.JSONObject;

public class u {
    private boolean a = false;
    private boolean b = false;
    private int c = 200;

    public u(String string2) {
        this.a(string2);
    }

    private boolean a(JSONObject jSONObject) {
        block4 : {
            JSONArray jSONArray;
            int n2;
            try {
                if (!jSONObject.has("ob")) break block4;
                jSONArray = jSONObject.getJSONArray("ob");
                n2 = jSONArray.length();
            }
            catch (Exception exception) {
                return true;
            }
            for (int i2 = 0; i2 < n2; ++i2) {
                int n3 = jSONArray.getInt(i2);
                int n4 = Build.VERSION.SDK_INT;
                if (n3 != n4) continue;
                return true;
            }
        }
        return false;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void a(String string2) {
        try {
            int n2;
            JSONObject jSONObject = new JSONObject(string2);
            String string3 = jSONObject.getString("sa");
            boolean bl2 = string3.equals((Object)"8ace5ca5da6b9adb3c0f055aad4a98c2aedf4bd7");
            if ((string3.equals((Object)"on") || bl2) && !this.a(jSONObject)) {
                this.a = true;
                this.b = bl2;
            }
            if (jSONObject.has("in") && (n2 = jSONObject.getInt("in")) >= 100 && n2 <= 1000) {
                this.c = n2;
            }
            return;
        }
        catch (Exception exception) {
            this.a = false;
            this.b = false;
            this.c = 200;
            return;
        }
    }

    public boolean a() {
        return this.b;
    }

    public boolean b() {
        return this.a;
    }

    public int c() {
        return this.c;
    }
}

