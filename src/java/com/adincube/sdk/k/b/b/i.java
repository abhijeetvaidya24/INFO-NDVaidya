/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.annotation.SuppressLint
 *  java.lang.Object
 *  java.lang.String
 *  java.util.HashMap
 *  java.util.Map
 *  java.util.Map$Entry
 *  java.util.Set
 *  org.json.JSONArray
 *  org.json.JSONObject
 *  org.w3c.dom.Node
 */
package com.adincube.sdk.k.b.b;

import android.annotation.SuppressLint;
import com.adincube.sdk.k.b.b.d;
import com.adincube.sdk.util.z;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;
import org.w3c.dom.Node;

@SuppressLint(value={"NewApi"})
public final class i {
    public d a = null;
    public String b;
    public Map<String, String> c = new HashMap();

    private i() {
    }

    i(d d2, Node node) {
        this.a = d2;
        this.b = z.a(node.getTextContent());
        this.c = z.a(node);
    }

    public static i a(JSONObject jSONObject) {
        i i2 = new i();
        i2.a = d.a(jSONObject.getString("e"));
        i2.b = jSONObject.getString("u");
        JSONArray jSONArray = jSONObject.getJSONArray("a");
        for (int i3 = 0; i3 < jSONArray.length(); ++i3) {
            JSONObject jSONObject2 = jSONArray.getJSONObject(i3);
            String string = jSONObject2.getString("k");
            String string2 = jSONObject2.getString("v");
            i2.c.put((Object)string, (Object)string2);
        }
        return i2;
    }

    public final JSONObject a() {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("e", (Object)this.a.w);
        jSONObject.put("u", (Object)this.b);
        JSONArray jSONArray = new JSONArray();
        for (Map.Entry entry : this.c.entrySet()) {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("k", entry.getKey());
            jSONObject2.put("v", entry.getValue());
            jSONArray.put((Object)jSONObject2);
        }
        jSONObject.put("a", (Object)jSONArray);
        return jSONObject;
    }
}

