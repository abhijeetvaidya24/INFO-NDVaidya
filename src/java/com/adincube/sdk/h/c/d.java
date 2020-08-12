/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.System
 *  java.util.ArrayList
 *  java.util.Collections
 *  java.util.Iterator
 *  java.util.List
 *  org.json.JSONArray
 *  org.json.JSONException
 *  org.json.JSONObject
 */
package com.adincube.sdk.h.c;

import com.adincube.sdk.g.b.c.h;
import com.adincube.sdk.g.b.c.i;
import com.adincube.sdk.h.c.b;
import com.adincube.sdk.h.c.e;
import com.adincube.sdk.h.c.f;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class d {
    public b a;
    public boolean b = false;
    public int c;
    public List<e> d = new ArrayList();
    public long e;
    public i f = null;
    public boolean g = false;

    public static d a(JSONObject jSONObject) {
        d d2 = new d();
        d2.a = b.a(jSONObject.getString("at"));
        d2.c = jSONObject.getInt("ce");
        JSONArray jSONArray = jSONObject.getJSONArray("no");
        for (int i2 = 0; i2 < jSONArray.length(); ++i2) {
            JSONObject jSONObject2 = jSONArray.getJSONObject(i2);
            e e2 = new e();
            e2.a = jSONObject2.getString("n");
            if (jSONObject2.has("c")) {
                JSONObject jSONObject3 = jSONObject2.getJSONObject("c");
                if (jSONObject3.has("sn")) {
                    e2.b = jSONObject3.getString("sn");
                }
                e2.c = jSONObject3;
            }
            long l2 = jSONObject2.has("t") ? jSONObject2.getLong("t") : System.currentTimeMillis();
            e2.d = l2;
            d2.d.add((Object)e2);
        }
        if (jSONObject.has("f")) {
            d2.g = jSONObject.getBoolean("f");
        }
        long l3 = jSONObject.has("t") ? jSONObject.getLong("t") : System.currentTimeMillis();
        d2.e = l3;
        return d2;
    }

    public static boolean a(d d2) {
        if (d2 == null) {
            return false;
        }
        return d2.f != null;
    }

    public final com.adincube.sdk.h.f.b a(e e2) {
        i i2 = this.f;
        if (i2 == null) {
            return null;
        }
        return i2.b(e2).f();
    }

    public final JSONObject a() {
        JSONObject jSONObject;
        jSONObject = new JSONObject();
        try {
            jSONObject.put("at", (Object)this.a.e);
            jSONObject.put("ce", this.c);
            jSONObject.put("f", this.g);
            JSONArray jSONArray = new JSONArray();
            Iterator iterator = this.d.iterator();
            while (iterator.hasNext()) {
                jSONArray.put((Object)((e)iterator.next()).a());
            }
            jSONObject.put("no", (Object)jSONArray);
            jSONObject.put("t", this.e);
        }
        catch (JSONException jSONException) {}
        return jSONObject;
    }

    public final boolean b() {
        return this.d.isEmpty();
    }

    public final f c() {
        return new f(this, (List<com.adincube.sdk.g.b.c.e>)Collections.emptyList());
    }

    public final String toString() {
        return this.d.toString();
    }
}

