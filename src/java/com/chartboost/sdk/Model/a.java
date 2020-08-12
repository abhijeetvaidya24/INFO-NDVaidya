/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Integer
 *  java.lang.Object
 *  java.lang.RuntimeException
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.util.ArrayList
 *  java.util.HashMap
 *  java.util.HashSet
 *  java.util.Iterator
 *  java.util.List
 *  java.util.Map
 *  org.json.JSONArray
 *  org.json.JSONException
 *  org.json.JSONObject
 */
package com.chartboost.sdk.Model;

import com.chartboost.sdk.Model.b;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class a {
    public final JSONObject a;
    public final int b;
    public final Map<String, b> c;
    public final Map<String, String> d;
    public final String e;
    public final String f;
    public final String g;
    public final String h;
    public final String i;
    public final String j;
    public final int k;
    public final String l;
    public final String m;
    public final Map<String, List<String>> n;
    public final int o;
    public final String p;
    public final String q;
    public final b r;
    public final HashSet<String> s;

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public a(int n2, JSONObject jSONObject, boolean bl) throws JSONException {
        this.b = n2;
        this.a = jSONObject;
        this.f = jSONObject.getString("ad_id");
        this.g = jSONObject.getString("cgn");
        this.h = jSONObject.getString("creative");
        this.i = jSONObject.optString("deep-link");
        this.j = jSONObject.getString("link");
        this.m = jSONObject.getString("to");
        this.o = jSONObject.optInt("animation");
        this.p = jSONObject.optString("media-type");
        this.q = jSONObject.optString("name");
        this.c = new HashMap();
        this.d = new HashMap();
        this.n = new HashMap();
        this.s = new HashSet();
        if (n2 == 1) {
            String string2;
            JSONObject jSONObject2 = jSONObject.getJSONObject("webview");
            JSONArray jSONArray = jSONObject2.getJSONArray("elements");
            String string3 = "";
            int n3 = 0;
            int n4 = 0;
            do {
                int n5 = jSONArray.length();
                string2 = "body";
                if (n3 >= n5) break;
                JSONObject jSONObject3 = jSONArray.getJSONObject(n3);
                String string4 = jSONObject3.getString("name");
                String string5 = jSONObject3.optString("param");
                String string6 = jSONObject3.getString("type");
                String string7 = jSONObject3.getString("value");
                if (string6.equals((Object)"param")) {
                    this.d.put((Object)string5, (Object)string7);
                    if (string4.equals((Object)"reward_amount")) {
                        n4 = Integer.valueOf((String)string7);
                    } else if (string4.equals((Object)"reward_currency")) {
                        string3 = string7;
                    }
                } else {
                    if (!string6.equals((Object)"html") || !string5.isEmpty()) {
                        string2 = string5.isEmpty() ? string4 : string5;
                    }
                    b b2 = new b(string6, string4, string7);
                    this.c.put((Object)string2, (Object)b2);
                }
                ++n3;
            } while (true);
            this.k = n4;
            this.l = string3;
            this.r = (b)this.c.get((Object)string2);
            if (this.r == null) throw new RuntimeException("WebView AdUnit does not have a template html body asset");
            this.e = jSONObject2.getString("template");
            JSONObject jSONObject4 = jSONObject.optJSONObject("events");
            if (jSONObject4 != null) {
                Iterator iterator = jSONObject4.keys();
                while (iterator.hasNext()) {
                    String string8 = (String)iterator.next();
                    JSONArray jSONArray2 = jSONObject4.getJSONArray(string8);
                    ArrayList arrayList = new ArrayList();
                    for (int i2 = 0; i2 < jSONArray2.length(); ++i2) {
                        arrayList.add((Object)jSONArray2.getString(i2));
                    }
                    this.n.put((Object)string8, (Object)arrayList);
                }
            }
            JSONArray jSONArray3 = jSONObject.optJSONArray("certification_providers");
            if (jSONArray3 == null) return;
            for (int i3 = 0; i3 < jSONArray3.length(); ++i3) {
                this.s.add((Object)jSONArray3.getString(i3));
            }
            return;
        } else {
            if (bl) {
                String string9 = jSONObject.getJSONObject("icons").getString("lg");
                String string10 = string9.substring(1 + string9.lastIndexOf("/"));
                this.c.put((Object)"lg", (Object)new b("inPlayIcons", string10, string9));
                this.k = 0;
                this.l = "";
            } else {
                JSONObject jSONObject5 = jSONObject.getJSONObject("assets");
                Iterator iterator = jSONObject5.keys();
                while (iterator.hasNext()) {
                    String string11 = (String)iterator.next();
                    JSONObject jSONObject6 = jSONObject5.getJSONObject(string11);
                    String string12 = !string11.equals((Object)"video-portrait") && !string11.equals((Object)"video-landscape") ? "images" : "videos";
                    String string13 = jSONObject6.optString("id", null);
                    if (string13 == null) {
                        StringBuilder stringBuilder = new StringBuilder();
                        stringBuilder.append(jSONObject6.getString("checksum"));
                        stringBuilder.append(".png");
                        string13 = stringBuilder.toString();
                    }
                    String string14 = jSONObject6.getString("url");
                    this.c.put((Object)string11, (Object)new b(string12, string13, string14));
                }
                this.k = jSONObject.optInt("reward");
                this.l = jSONObject.optString("currency-name");
            }
            this.r = null;
            this.e = "";
        }
    }
}

