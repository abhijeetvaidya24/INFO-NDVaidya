/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.text.TextUtils
 *  com.applovin.impl.sdk.AppLovinAdBase
 *  com.applovin.impl.sdk.c.c$1
 *  java.lang.Boolean
 *  java.lang.CharSequence
 *  java.lang.IllegalArgumentException
 *  java.lang.Integer
 *  java.lang.Long
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.System
 *  java.lang.Throwable
 *  java.util.Collection
 *  java.util.HashMap
 *  java.util.HashSet
 *  java.util.LinkedHashMap
 *  java.util.Map
 *  java.util.Map$Entry
 *  java.util.Set
 *  org.json.JSONArray
 *  org.json.JSONException
 *  org.json.JSONObject
 */
package com.applovin.impl.sdk.c;

import android.text.TextUtils;
import com.applovin.impl.sdk.AppLovinAdBase;
import com.applovin.impl.sdk.b.d;
import com.applovin.impl.sdk.c.c;
import com.applovin.impl.sdk.d.q;
import com.applovin.impl.sdk.e.f;
import com.applovin.impl.sdk.j;
import com.applovin.impl.sdk.network.b;
import com.applovin.impl.sdk.p;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class c {
    private final j a;
    private final p b;
    private final Object c = new Object();
    private final b d = new b();

    public c(j j2) {
        if (j2 != null) {
            this.a = j2;
            this.b = j2.u();
            return;
        }
        throw new IllegalArgumentException("No sdk specified");
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private a a(AppLovinAdBase appLovinAdBase) {
        Object object;
        Object object2 = object = this.c;
        synchronized (object2) {
            String string2 = appLovinAdBase.getPrimaryKey();
            a a2 = (a)this.d.get((Object)string2);
            if (a2 == null) {
                a2 = new a(string2, appLovinAdBase.getSecondaryKey1(), appLovinAdBase.getSecondaryKey2());
                this.d.put((Object)string2, (Object)a2);
            }
            return a2;
        }
    }

    static /* synthetic */ p a(c c2) {
        return c2.b;
    }

    private void a(JSONObject jSONObject) {
        1 var2_2 = new 1(this, com.applovin.impl.sdk.network.b.a(this.a).a(this.c()).c(this.d()).a(f.c(this.a)).b("POST").a(jSONObject).b(this.a.a(com.applovin.impl.sdk.b.b.eF)).a(this.a.a(com.applovin.impl.sdk.b.b.eG).intValue()).a(), this.a);
        var2_2.a(com.applovin.impl.sdk.b.b.aD);
        var2_2.b(com.applovin.impl.sdk.b.b.aE);
        this.a.C().a((com.applovin.impl.sdk.d.a)var2_2, q.a.c);
    }

    private String c() {
        return f.a("2.0/s", this.a);
    }

    private String d() {
        return f.b("2.0/s", this.a);
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
    private void e() {
        Object object;
        Object object2 = object = this.c;
        // MONITORENTER : object2
        HashSet hashSet = new HashSet(this.d.size());
        for (a a2 : this.d.values()) {
            try {
                String string2 = a2.b();
                if (string2 == null) continue;
                hashSet.add((Object)string2);
            }
            catch (JSONException jSONException) {
                p p2 = this.b;
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Failed to serialize ");
                stringBuilder.append((Object)a2);
                p2.b("AdEventStatsManager", stringBuilder.toString(), jSONException);
            }
        }
        // MONITOREXIT : object2
        {
            catch (Throwable throwable) {}
            {
                // MONITOREXIT : object2
                throw throwable;
            }
        }
        this.a.a(d.m, hashSet);
    }

    public void a() {
        if (this.a.a(com.applovin.impl.sdk.b.b.eE).booleanValue()) {
            Set set = (Set)this.a.b(d.m, new HashSet(0));
            this.a.b(d.m);
            if (set != null && !set.isEmpty()) {
                p p2 = this.b;
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("De-serializing ");
                stringBuilder.append(set.size());
                stringBuilder.append(" stat ad events");
                p2.a("AdEventStatsManager", stringBuilder.toString());
                JSONArray jSONArray = new JSONArray();
                for (String string2 : set) {
                    try {
                        jSONArray.put((Object)new JSONObject(string2));
                    }
                    catch (JSONException jSONException) {
                        p p3 = this.b;
                        StringBuilder stringBuilder2 = new StringBuilder();
                        stringBuilder2.append("Failed to parse: ");
                        stringBuilder2.append(string2);
                        p3.b("AdEventStatsManager", stringBuilder2.toString(), jSONException);
                    }
                }
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("stats", (Object)jSONArray);
                    this.a(jSONObject);
                    return;
                }
                catch (JSONException jSONException) {
                    this.b.b("AdEventStatsManager", "Failed to create stats to submit", jSONException);
                    return;
                }
            }
            this.b.a("AdEventStatsManager", "No serialized ad events found");
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void a(com.applovin.impl.sdk.c.b b2, long l2, AppLovinAdBase appLovinAdBase) {
        if (appLovinAdBase == null) {
            throw new IllegalArgumentException("No ad specified");
        }
        if (b2 == null) {
            throw new IllegalArgumentException("No key specified");
        }
        if (this.a.a(com.applovin.impl.sdk.b.b.eE).booleanValue()) {
            Object object;
            Object object2 = object = this.c;
            synchronized (object2) {
                this.a(appLovinAdBase).a(b2.a(), l2);
            }
            this.e();
            return;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void b() {
        Object object;
        Object object2 = object = this.c;
        synchronized (object2) {
            this.d.clear();
            return;
        }
    }

    private static class a {
        private final String a;
        private final String b;
        private final String c;
        private final long d;
        private final Map<String, Long> e = new HashMap();

        private a(String string2, String string3, String string4) {
            this.a = string2;
            this.b = string3;
            this.c = string4;
            this.d = System.currentTimeMillis();
        }

        private JSONObject a() throws JSONException {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("pk", (Object)this.a);
            jSONObject.put("ts", this.d);
            if (!TextUtils.isEmpty((CharSequence)this.b)) {
                jSONObject.put("sk1", (Object)this.b);
            }
            if (!TextUtils.isEmpty((CharSequence)this.c)) {
                jSONObject.put("sk2", (Object)this.c);
            }
            for (Map.Entry entry : this.e.entrySet()) {
                jSONObject.put((String)entry.getKey(), entry.getValue());
            }
            return jSONObject;
        }

        private String b() throws JSONException {
            return this.a().toString();
        }

        void a(String string2, long l2) {
            this.e.put((Object)string2, (Object)l2);
        }

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("[AdEventStats pk: ");
            stringBuilder.append(this.a);
            stringBuilder.append(", size: ");
            stringBuilder.append(this.e.size());
            stringBuilder.append("]");
            return stringBuilder.toString();
        }
    }

    private class b
    extends LinkedHashMap<String, a> {
        private b() {
        }

        protected boolean removeEldestEntry(Map.Entry<String, a> entry) {
            return this.size() > c.this.a.a(com.applovin.impl.sdk.b.b.eH);
        }
    }

}

