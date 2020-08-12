/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Integer
 *  java.lang.Object
 *  java.lang.String
 *  java.util.ArrayList
 *  java.util.Collection
 *  java.util.List
 *  org.json.JSONArray
 *  org.json.JSONException
 *  org.json.JSONObject
 */
package com.yandex.metrica.impl.ob;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ds {
    private final long a;
    private final String b;
    private final List<Integer> c;

    public ds(long l2, String string2, List<Integer> list) {
        this.a = l2;
        this.b = string2;
        this.c = list;
    }

    public ds(String string2) throws JSONException {
        JSONObject jSONObject = new JSONObject(string2);
        this.a = jSONObject.getLong("seconds_to_live");
        this.b = jSONObject.getString("token");
        this.c = ds.a(jSONObject.getJSONArray("ports"));
    }

    private static ArrayList<Integer> a(JSONArray jSONArray) throws JSONException {
        ArrayList arrayList = new ArrayList(jSONArray.length());
        for (int i2 = 0; i2 < jSONArray.length(); ++i2) {
            arrayList.add((Object)jSONArray.getInt(i2));
        }
        return arrayList;
    }

    public long a() {
        return this.a;
    }

    public String b() {
        return this.b;
    }

    public List<Integer> c() {
        return this.c;
    }

    public String d() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("seconds_to_live", this.a);
        jSONObject.put("token", (Object)this.b);
        jSONObject.put("ports", (Object)new JSONArray(this.c));
        return jSONObject.toString();
    }
}

