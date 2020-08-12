/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.util.HashMap
 *  java.util.Iterator
 *  java.util.Map
 *  org.json.JSONException
 *  org.json.JSONObject
 */
package com.tapjoy.internal;

import com.tapjoy.TapjoyLog;
import com.tapjoy.internal.et;
import com.tapjoy.internal.fi;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public class ep
extends et {
    private static final String c = "ep";

    public ep(String string, String string2) {
        super(string, string2, "ad");
    }

    public static Map a(JSONObject jSONObject) {
        HashMap hashMap = new HashMap();
        if (jSONObject != null) {
            try {
                JSONObject jSONObject2 = jSONObject.getJSONObject("dimensions");
                Iterator iterator = jSONObject2.keys();
                while (iterator.hasNext()) {
                    String string = (String)iterator.next();
                    hashMap.put((Object)string, jSONObject2.get(string));
                }
            }
            catch (JSONException jSONException) {
                String string = c;
                StringBuilder stringBuilder = new StringBuilder("Unable to getAdUnitDimensions. Invalid params: ");
                stringBuilder.append((Object)jSONException);
                TapjoyLog.d(string, stringBuilder.toString());
            }
        }
        return hashMap;
    }

    public static Map b(JSONObject jSONObject) {
        HashMap hashMap = new HashMap();
        if (jSONObject != null) {
            try {
                JSONObject jSONObject2 = jSONObject.getJSONObject("values");
                Iterator iterator = jSONObject2.keys();
                while (iterator.hasNext()) {
                    String string = (String)iterator.next();
                    hashMap.put((Object)string, (Object)jSONObject2.getLong(string));
                }
            }
            catch (JSONException jSONException) {
                String string = c;
                StringBuilder stringBuilder = new StringBuilder("Unable to getAdUnitValues. Invalid params: ");
                stringBuilder.append((Object)jSONException);
                TapjoyLog.d(string, stringBuilder.toString());
            }
        }
        return hashMap;
    }

    public final fi.a a(String string, JSONObject jSONObject) {
        return this.a(string, ep.a(jSONObject), ep.b(jSONObject));
    }

    public final fi.a b(String string, JSONObject jSONObject) {
        return this.b(string, ep.a(jSONObject), ep.b(jSONObject));
    }
}

