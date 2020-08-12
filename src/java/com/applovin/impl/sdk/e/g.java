/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.os.Bundle
 *  android.text.TextUtils
 *  java.lang.Boolean
 *  java.lang.CharSequence
 *  java.lang.Double
 *  java.lang.Integer
 *  java.lang.Long
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.Throwable
 *  java.util.ArrayList
 *  java.util.HashMap
 *  java.util.Iterator
 *  java.util.List
 *  java.util.Map
 *  java.util.Map$Entry
 *  java.util.Set
 *  org.json.JSONArray
 *  org.json.JSONException
 *  org.json.JSONObject
 */
package com.applovin.impl.sdk.e;

import android.os.Bundle;
import android.text.TextUtils;
import com.applovin.impl.sdk.j;
import com.applovin.impl.sdk.p;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class g {
    public static float a(JSONObject jSONObject, String string2, float f2, j j2) {
        block4 : {
            if (jSONObject != null && jSONObject.has(string2)) {
                double d2;
                try {
                    d2 = jSONObject.getDouble(string2);
                }
                catch (JSONException jSONException) {
                    if (j2 == null) break block4;
                    p p2 = j2.u();
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("Failed to retrieve float property for key = ");
                    stringBuilder.append(string2);
                    p2.b("JsonUtils", stringBuilder.toString(), jSONException);
                }
                if (-3.4028234663852886E38 < d2 && d2 < 3.4028234663852886E38) {
                    return (float)d2;
                }
            }
        }
        return f2;
    }

    public static int a(JSONObject jSONObject, String string2, int n2, j j2) {
        block3 : {
            if (jSONObject != null && jSONObject.has(string2)) {
                try {
                    int n3 = jSONObject.getInt(string2);
                    return n3;
                }
                catch (JSONException jSONException) {
                    if (j2 == null) break block3;
                    p p2 = j2.u();
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("Failed to retrieve int property for key = ");
                    stringBuilder.append(string2);
                    p2.b("JsonUtils", stringBuilder.toString(), jSONException);
                }
            }
        }
        return n2;
    }

    public static long a(JSONObject jSONObject, String string2, long l2, j j2) {
        block3 : {
            if (jSONObject != null && jSONObject.has(string2)) {
                try {
                    long l3 = jSONObject.getLong(string2);
                    return l3;
                }
                catch (JSONException jSONException) {
                    if (j2 == null) break block3;
                    p p2 = j2.u();
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("Failed to retrieve int property for key = ");
                    stringBuilder.append(string2);
                    p2.b("JsonUtils", stringBuilder.toString(), jSONException);
                }
            }
        }
        return l2;
    }

    public static Boolean a(JSONObject jSONObject, String string2, Boolean bl, j j2) {
        if (jSONObject != null && jSONObject.has(string2)) {
            try {
                Boolean bl2 = jSONObject.getBoolean(string2);
                return bl2;
            }
            catch (JSONException jSONException) {
                boolean bl3 = true;
                int n2 = bl != null && bl != false ? 1 : 0;
                if (g.a(jSONObject, string2, n2, j2) <= 0) {
                    bl3 = false;
                }
                return bl3;
            }
        }
        return bl;
    }

    private static Object a(Object object) throws JSONException {
        if (object == JSONObject.NULL) {
            return null;
        }
        if (object instanceof JSONObject) {
            return g.a((JSONObject)object);
        }
        if (object instanceof JSONArray) {
            object = g.b((JSONArray)object);
        }
        return object;
    }

    public static String a(JSONObject jSONObject, j j2) {
        if (jSONObject != null) {
            try {
                String string2 = jSONObject.toString(4);
                return string2;
            }
            catch (JSONException jSONException) {
                if (j2 != null) {
                    j2.u().b("JsonUtils", "Failed to convert to indented string", jSONException);
                }
                return jSONObject.toString();
            }
        }
        return null;
    }

    public static String a(JSONObject jSONObject, String string2, String string3, j j2) {
        block3 : {
            if (jSONObject != null && jSONObject.has(string2)) {
                try {
                    String string4 = jSONObject.getString(string2);
                    return string4;
                }
                catch (JSONException jSONException) {
                    if (j2 == null) break block3;
                    p p2 = j2.u();
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("Failed to retrieve string property for key = ");
                    stringBuilder.append(string2);
                    p2.b("JsonUtils", stringBuilder.toString(), jSONException);
                }
            }
        }
        return string3;
    }

    public static ArrayList<Bundle> a(JSONArray jSONArray) {
        if (jSONArray != null && jSONArray.length() != 0) {
            ArrayList arrayList = new ArrayList(jSONArray.length());
            for (int i2 = 0; i2 < jSONArray.length(); ++i2) {
                arrayList.add((Object)g.b(jSONArray.optJSONObject(i2)));
            }
            return arrayList;
        }
        return new ArrayList();
    }

    public static Map<String, String> a(Bundle bundle) throws JSONException {
        HashMap hashMap = new HashMap(bundle.size());
        for (String string2 : bundle.keySet()) {
            hashMap.put((Object)string2, (Object)String.valueOf((Object)bundle.get(string2)));
        }
        return hashMap;
    }

    public static Map<String, String> a(JSONObject jSONObject) throws JSONException {
        HashMap hashMap = new HashMap();
        Iterator iterator = jSONObject.keys();
        while (iterator.hasNext()) {
            String string2 = (String)iterator.next();
            hashMap.put((Object)string2, (Object)g.a(jSONObject.get(string2)).toString());
        }
        return hashMap;
    }

    public static JSONArray a(JSONObject jSONObject, String string2, JSONArray jSONArray, j j2) {
        block3 : {
            if (jSONObject != null && jSONObject.has(string2)) {
                try {
                    JSONArray jSONArray2 = jSONObject.getJSONArray(string2);
                    return jSONArray2;
                }
                catch (JSONException jSONException) {
                    if (j2 == null) break block3;
                    p p2 = j2.u();
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("Failed to retrieve JSON array for key = ");
                    stringBuilder.append(string2);
                    p2.b("JsonUtils", stringBuilder.toString(), jSONException);
                }
            }
        }
        return jSONArray;
    }

    public static JSONObject a(String string2, j j2) {
        if (TextUtils.isEmpty((CharSequence)string2)) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject(string2);
            return jSONObject;
        }
        catch (Throwable throwable) {
            p p2 = j2.u();
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Failed to deserialize into JSON: ");
            stringBuilder.append(string2);
            p2.d("JsonUtils", stringBuilder.toString());
            return null;
        }
    }

    public static JSONObject a(Map<String, ?> map) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        for (Map.Entry entry : map.entrySet()) {
            jSONObject.put((String)entry.getKey(), entry.getValue());
        }
        return jSONObject;
    }

    public static JSONObject a(JSONArray jSONArray, int n2, JSONObject jSONObject, j j2) {
        block3 : {
            if (jSONArray != null && n2 < jSONArray.length()) {
                try {
                    JSONObject jSONObject2 = jSONArray.getJSONObject(n2);
                    return jSONObject2;
                }
                catch (JSONException jSONException) {
                    if (j2 == null) break block3;
                    p p2 = j2.u();
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("Failed to retrieve JSON object from array for index = ");
                    stringBuilder.append(n2);
                    p2.b("JsonUtils", stringBuilder.toString(), jSONException);
                }
            }
        }
        return jSONObject;
    }

    public static JSONObject a(JSONObject jSONObject, String string2, JSONObject jSONObject2, j j2) {
        block3 : {
            if (jSONObject != null && jSONObject.has(string2)) {
                try {
                    JSONObject jSONObject3 = jSONObject.getJSONObject(string2);
                    return jSONObject3;
                }
                catch (JSONException jSONException) {
                    if (j2 == null) break block3;
                    p p2 = j2.u();
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("Failed to retrieve JSON property for key = ");
                    stringBuilder.append(string2);
                    p2.b("JsonUtils", stringBuilder.toString(), jSONException);
                }
            }
        }
        return jSONObject2;
    }

    public static boolean a(JSONObject jSONObject, String string2) {
        return jSONObject != null && jSONObject.has(string2);
    }

    /*
     * Enabled aggressive block sorting
     */
    public static Bundle b(JSONObject jSONObject) {
        if (jSONObject == null) return Bundle.EMPTY;
        if (jSONObject.length() == 0) {
            return Bundle.EMPTY;
        }
        Bundle bundle = new Bundle();
        Iterator iterator = jSONObject.keys();
        while (iterator.hasNext()) {
            Object object;
            String string2;
            block12 : {
                String string3;
                block11 : {
                    block10 : {
                        string2 = (String)iterator.next();
                        if (!jSONObject.isNull(string2)) break block10;
                        string3 = null;
                        break block11;
                    }
                    object = jSONObject.opt(string2);
                    if (object instanceof JSONObject) {
                        bundle.putBundle(string2, g.b((JSONObject)object));
                        continue;
                    }
                    if (object instanceof JSONArray) {
                        bundle.putParcelableArrayList(string2, g.a((JSONArray)object));
                        continue;
                    }
                    if (object instanceof Boolean) {
                        bundle.putBoolean(string2, ((Boolean)object).booleanValue());
                        continue;
                    }
                    if (!(object instanceof String)) break block12;
                    string3 = (String)object;
                }
                bundle.putString(string2, string3);
                continue;
            }
            if (object instanceof Integer) {
                bundle.putInt(string2, ((Integer)object).intValue());
                continue;
            }
            if (object instanceof Long) {
                bundle.putLong(string2, ((Long)object).longValue());
                continue;
            }
            if (!(object instanceof Double)) continue;
            bundle.putDouble(string2, ((Double)object).doubleValue());
        }
        return bundle;
    }

    public static List b(JSONArray jSONArray) throws JSONException {
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < jSONArray.length(); ++i2) {
            arrayList.add(g.a(jSONArray.get(i2)));
        }
        return arrayList;
    }

    public static void b(JSONObject jSONObject, String string2, long l2, j j2) {
        block3 : {
            if (jSONObject != null) {
                try {
                    jSONObject.put(string2, l2);
                    return;
                }
                catch (JSONException jSONException) {
                    if (j2 == null) break block3;
                    p p2 = j2.u();
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("Failed to put long property for key = ");
                    stringBuilder.append(string2);
                    p2.b("JsonUtils", stringBuilder.toString(), jSONException);
                }
            }
        }
    }
}

