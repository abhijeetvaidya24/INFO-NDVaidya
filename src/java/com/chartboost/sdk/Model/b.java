/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.chartboost.sdk.Tracking.a
 *  java.io.File
 *  java.lang.Exception
 *  java.lang.Math
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.util.HashMap
 *  java.util.Iterator
 *  java.util.Map
 *  java.util.Map$Entry
 *  java.util.Set
 *  org.json.JSONArray
 *  org.json.JSONException
 *  org.json.JSONObject
 */
package com.chartboost.sdk.Model;

import com.chartboost.sdk.Libraries.e;
import com.chartboost.sdk.Tracking.a;
import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class b {
    public final String a;
    public final String b;
    public final String c;

    public b(String string2, String string3, String string4) {
        this.a = string2;
        this.b = string3;
        this.c = string4;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static Map<String, b> a(JSONObject jSONObject) {
        HashMap hashMap = new HashMap();
        JSONArray jSONArray = jSONObject.getJSONArray("videos");
        int n2 = jSONArray.length();
        for (int i2 = 0; i2 < n2; ++i2) {
            try {
                JSONObject jSONObject2 = jSONArray.getJSONObject(i2);
                String string2 = jSONObject2.getString("id");
                hashMap.put((Object)string2, (Object)new b("videos", string2, jSONObject2.getString("video")));
                continue;
            }
            catch (JSONException jSONException) {
                try {
                    a.a(b.class, (String)"deserializeNativeVideos (file)", (Exception)((Object)jSONException));
                }
                catch (JSONException jSONException2) {
                    a.a(b.class, (String)"deserializeNativeVideos (videos array)", (Exception)((Object)jSONException2));
                    return hashMap;
                }
                continue;
            }
        }
        return hashMap;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static Map<String, b> a(JSONObject jSONObject, int n2) {
        HashMap hashMap = new HashMap();
        try {
            JSONObject jSONObject2 = jSONObject.getJSONObject("cache_assets");
            Iterator iterator = jSONObject2.keys();
            while (iterator.hasNext()) {
                String string2;
                int n3;
                JSONArray jSONArray;
                block8 : {
                    JSONArray jSONArray2;
                    int n4;
                    block7 : {
                        block6 : {
                            string2 = (String)iterator.next();
                            boolean bl = string2.equals((Object)"templates");
                            if (!bl) break block6;
                            jSONArray2 = jSONObject2.optJSONArray("templates");
                            if (jSONArray2 == null) continue;
                            n4 = Math.min((int)n2, (int)jSONArray2.length());
                            break block7;
                        }
                        jSONArray = jSONObject2.getJSONArray(string2);
                        break block8;
                    }
                    for (n3 = 0; n3 < n4; ++n3) {
                        Iterator iterator2 = b.b(b.a(jSONArray2.getJSONObject(n3).getJSONArray("elements"))).entrySet().iterator();
                        while (iterator2.hasNext()) {
                            b b2 = (b)((Map.Entry)iterator2.next()).getValue();
                            hashMap.put((Object)b2.b, (Object)b2);
                        }
                    }
                    continue;
                }
                while (n3 < jSONArray.length()) {
                    JSONObject jSONObject3 = jSONArray.getJSONObject(n3);
                    String string3 = jSONObject3.getString("name");
                    hashMap.put((Object)string3, (Object)new b(string2, string3, jSONObject3.getString("value")));
                    ++n3;
                }
            }
            return hashMap;
        }
        catch (JSONException jSONException) {
            a.a(b.class, (String)"v2PrefetchToAssets", (Exception)((Object)jSONException));
        }
        return hashMap;
    }

    private static JSONObject a(JSONArray jSONArray) throws JSONException {
        JSONObject jSONObject = e.a(new e.a[0]);
        for (int i2 = 0; i2 < jSONArray.length(); ++i2) {
            JSONObject jSONObject2 = jSONArray.getJSONObject(i2);
            String string2 = jSONObject2.optString("name");
            String string3 = jSONObject2.optString("type");
            String string4 = jSONObject2.optString("value");
            String string5 = jSONObject2.optString("param");
            if (string3.equals((Object)"param") || !string5.isEmpty()) continue;
            JSONObject jSONObject3 = jSONObject.optJSONObject(string3);
            if (jSONObject3 == null) {
                jSONObject3 = e.a(new e.a[0]);
                jSONObject.put(string3, (Object)jSONObject3);
            }
            String string6 = string3.equals((Object)"html") ? "body" : string2;
            e.a[] arra = new e.a[]{e.a("filename", (Object)string2), e.a("url", (Object)string4)};
            jSONObject3.put(string6, (Object)e.a(arra));
        }
        return jSONObject;
    }

    private static Map<String, b> b(JSONObject jSONObject) throws JSONException {
        HashMap hashMap = new HashMap();
        Iterator iterator = jSONObject.keys();
        while (iterator.hasNext()) {
            String string2 = (String)iterator.next();
            JSONObject jSONObject2 = jSONObject.getJSONObject(string2);
            Iterator iterator2 = jSONObject2.keys();
            while (iterator2.hasNext()) {
                String string3 = (String)iterator2.next();
                JSONObject jSONObject3 = jSONObject2.getJSONObject(string3);
                hashMap.put((Object)string3, (Object)new b(string2, jSONObject3.getString("filename"), jSONObject3.getString("url")));
            }
        }
        return hashMap;
    }

    public File a(File file) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.a);
        stringBuilder.append("/");
        stringBuilder.append(this.b);
        return new File(file, stringBuilder.toString());
    }
}

