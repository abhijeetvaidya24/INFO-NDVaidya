/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.os.PersistableBundle
 *  com.appnext.base.a.b.c
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.Throwable
 *  org.json.JSONObject
 */
package com.appnext.base.b;

import android.os.PersistableBundle;
import org.json.JSONObject;

public final class c {
    public static final String DATA = "data";
    public static final String KEY = "key";
    public static final String STATUS = "status";
    public static final String eO = "cycle";
    public static final String eP = "cycle_type";
    public static final String eQ = "sample";
    public static final String eR = "sample_type";
    public static final String eS = "service_key";

    public static com.appnext.base.a.b.c b(PersistableBundle persistableBundle) {
        if (persistableBundle == null) {
            return null;
        }
        String string2 = persistableBundle.getString(KEY, "");
        String string3 = persistableBundle.getString(eO, "");
        String string4 = persistableBundle.getString(eP, "");
        String string5 = persistableBundle.getString(eQ, "");
        String string6 = persistableBundle.getString(eR, "");
        String string7 = persistableBundle.getString(eS, "");
        String string8 = persistableBundle.getString(STATUS, "");
        String string9 = persistableBundle.getString(DATA, null);
        com.appnext.base.a.b.c c2 = new com.appnext.base.a.b.c(string8, string5, string6, string3, string4, string2, string7, string9);
        return c2;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static com.appnext.base.a.b.c c(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        try {
            String string2 = jSONObject.has(KEY) ? jSONObject.getString(KEY) : null;
            String string3 = jSONObject.has(eO) ? jSONObject.getString(eO) : null;
            String string4 = jSONObject.has(eP) ? jSONObject.getString(eP) : null;
            String string5 = jSONObject.has(eQ) ? jSONObject.getString(eQ) : null;
            String string6 = jSONObject.has(eR) ? jSONObject.getString(eR) : null;
            String string7 = jSONObject.has(eS) ? jSONObject.getString(eS) : null;
            String string8 = jSONObject.has(STATUS) ? jSONObject.getString(STATUS) : null;
            String string9 = jSONObject.has(DATA) ? jSONObject.getString(DATA) : null;
            return new com.appnext.base.a.b.c(string8, string5, string6, string3, string4, string2, string7, string9);
        }
        catch (Throwable throwable) {
            return null;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static PersistableBundle e(com.appnext.base.a.b.c c2) {
        PersistableBundle persistableBundle = new PersistableBundle();
        try {
            JSONObject jSONObject;
            String string2 = c2.getKey();
            String string3 = "";
            String string4 = string2 != null ? c2.getKey() : string3;
            persistableBundle.putString(KEY, string4);
            String string5 = c2.an() != null ? c2.an() : string3;
            persistableBundle.putString(eO, string5);
            String string6 = c2.ao() != null ? c2.ao() : string3;
            persistableBundle.putString(eP, string6);
            c2.al();
            persistableBundle.putString(eQ, c2.al());
            String string7 = c2.am() != null ? c2.am() : string3;
            persistableBundle.putString(eR, string7);
            String string8 = c2.ap() != null ? c2.ap() : string3;
            persistableBundle.putString(eS, string8);
            if (c2.ak() != null) {
                string3 = c2.ak();
            }
            persistableBundle.putString(STATUS, string3);
            JSONObject jSONObject2 = c2.aq();
            if (jSONObject2 != null) {
                persistableBundle.putString(DATA, c2.aq().toString());
            }
            if ((jSONObject = c2.aq()) == null) return persistableBundle;
            {
                persistableBundle.putString(DATA, jSONObject.toString());
                return persistableBundle;
            }
        }
        catch (Throwable throwable) {
            throwable.getMessage();
        }
        return persistableBundle;
    }
}

