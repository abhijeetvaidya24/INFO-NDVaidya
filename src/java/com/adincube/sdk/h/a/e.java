/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.adincube.sdk.d.b.c
 *  com.adincube.sdk.h.a.a
 *  com.adincube.sdk.h.a.a.a
 *  com.adincube.sdk.h.a.a.b
 *  com.adincube.sdk.h.a.c
 *  com.adincube.sdk.h.c.b
 *  java.lang.CharSequence
 *  java.lang.Integer
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.Throwable
 *  java.net.MalformedURLException
 *  java.net.URL
 *  java.util.ArrayList
 *  java.util.Collection
 *  java.util.HashMap
 *  java.util.HashSet
 *  java.util.Iterator
 *  java.util.Map
 *  java.util.Set
 *  org.json.JSONArray
 *  org.json.JSONException
 *  org.json.JSONObject
 */
package com.adincube.sdk.h.a;

import com.adincube.sdk.h.a.a;
import com.adincube.sdk.h.a.a.a;
import com.adincube.sdk.h.a.a.b;
import com.adincube.sdk.h.a.a.d;
import com.adincube.sdk.h.a.c;
import com.adincube.sdk.mediation.f;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public abstract class e
extends f {
    private Set<com.adincube.sdk.h.a.a.a> e = new HashSet();
    public String o;
    public String p;
    public String q;
    public String r;
    public Integer s;
    public Integer t;
    public boolean u;

    public e(JSONObject jSONObject) {
        super(jSONObject);
        try {
            this.a(jSONObject);
            return;
        }
        catch (JSONException jSONException) {
            throw new com.adincube.sdk.d.b.c("RTB", (Throwable)jSONException);
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private Set<com.adincube.sdk.h.a.a.a> h() {
        Set<com.adincube.sdk.h.a.a.a> set;
        Set<com.adincube.sdk.h.a.a.a> set2 = set = this.e;
        synchronized (set2) {
            return new HashSet(this.e);
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final void a(com.adincube.sdk.h.a.a.a a2) {
        Set<com.adincube.sdk.h.a.a.a> set;
        Set<com.adincube.sdk.h.a.a.a> set2 = set = this.e;
        synchronized (set2) {
            this.e.add((Object)a2);
            return;
        }
    }

    protected void a(JSONObject jSONObject) {
        if (jSONObject.has("r")) {
            JSONArray jSONArray = jSONObject.getJSONArray("r");
            for (int i2 = 0; i2 < jSONArray.length(); ++i2) {
                JSONObject jSONObject2 = jSONArray.getJSONObject(i2);
                this.a(new a.a(this, b.a((String)jSONObject2.getString("t")), jSONObject2.getBoolean("p"), jSONObject2));
            }
        }
        this.o = jSONObject.getString("i");
        this.p = jSONObject.getString("c");
        this.u = jSONObject.getBoolean("bua");
        if (jSONObject.has("afs")) {
            this.r = jSONObject.getString("afs");
        }
        if (jSONObject.has("ow") && jSONObject.has("oh")) {
            this.s = jSONObject.getInt("oh");
            this.t = jSONObject.getInt("ow");
        }
        if (jSONObject.has("ts")) {
            this.q = jSONObject.getString("ts");
        }
        if (jSONObject.has("cr")) {
            JSONArray jSONArray = jSONObject.getJSONArray("cr");
            for (int i3 = 0; i3 < jSONArray.length(); ++i3) {
                try {
                    URL uRL = new URL(jSONArray.getString(i3));
                    this.a(new com.adincube.sdk.h.a.a.c(this, b.b, false, uRL));
                    continue;
                }
                catch (MalformedURLException malformedURLException) {}
            }
        }
    }

    @Override
    protected final String b() {
        return "RTB";
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Loose catch block
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Converted monitor instructions to comments
     * Lifted jumps to return sites
     */
    protected void b(JSONObject jSONObject) {
        Set<com.adincube.sdk.h.a.a.a> set;
        String string;
        Integer n2;
        Set<com.adincube.sdk.h.a.a.a> set2 = set = this.e;
        // MONITORENTER : set2
        if (!this.e.isEmpty()) {
            JSONArray jSONArray = new JSONArray();
            Iterator iterator = this.e.iterator();
            while (iterator.hasNext()) {
                jSONArray.put((Object)((com.adincube.sdk.h.a.a.a)iterator.next()).f());
                jSONObject.put("r", (Object)jSONArray);
            }
        }
        // MONITOREXIT : set2
        {
            catch (Throwable throwable) {}
            {
                // MONITOREXIT : set2
                throw throwable;
            }
        }
        jSONObject.put("i", (Object)this.o);
        jSONObject.put("c", (Object)this.p);
        jSONObject.put("bua", this.u);
        String string2 = this.r;
        if (string2 != null) {
            jSONObject.put("afs", (Object)string2);
        }
        if (this.s != null && (n2 = this.t) != null) {
            jSONObject.put("ow", (Object)n2);
            jSONObject.put("oh", (Object)this.s);
        }
        if ((string = this.q) == null) return;
        jSONObject.put("ts", (Object)string);
    }

    @Override
    public final Map<String, String> c() {
        HashMap hashMap = new HashMap();
        hashMap.put((Object)"Id", (Object)this.o);
        return hashMap;
    }

    public abstract com.adincube.sdk.h.c.b d();

    public a e() {
        if (this.p.contains((CharSequence)"<VAST")) {
            return a.b;
        }
        return a.a;
    }

    public boolean equals(Object object) {
        if (object == null) {
            return false;
        }
        if (!(object instanceof c)) {
            return false;
        }
        return this.o.equals((Object)((c)object).o);
    }

    public final JSONObject f() {
        JSONObject jSONObject;
        jSONObject = new JSONObject();
        try {
            this.b(jSONObject);
        }
        catch (JSONException jSONException) {}
        return jSONObject;
    }

    public final Collection<? extends com.adincube.sdk.h.a.a.a> g() {
        ArrayList arrayList = new ArrayList();
        String string = this.p;
        if (string != null && string.length() > 0) {
            arrayList.add((Object)((Object)new d(this, this.e().d, this.p)));
        }
        arrayList.addAll(this.h());
        return arrayList;
    }

    public int hashCode() {
        return this.o.hashCode();
    }
}

