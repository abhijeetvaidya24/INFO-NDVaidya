/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.text.TextUtils
 *  java.lang.Boolean
 *  java.lang.CharSequence
 *  java.lang.Double
 *  java.lang.IllegalArgumentException
 *  java.lang.Long
 *  java.lang.Math
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.Throwable
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
package com.applovin.impl.sdk.c;

import android.text.TextUtils;
import com.applovin.impl.sdk.b.d;
import com.applovin.impl.sdk.c.i;
import com.applovin.impl.sdk.p;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class j {
    private final com.applovin.impl.sdk.j a;
    private final p b;
    private final Object c = new Object();
    private final Map<String, b> d = new HashMap();

    public j(com.applovin.impl.sdk.j j2) {
        this.a = j2;
        this.b = j2.u();
        this.c();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private b b(i i2) {
        Object object;
        Object object2 = object = this.c;
        synchronized (object2) {
            String string2 = i2.a();
            b b2 = (b)this.d.get((Object)string2);
            if (b2 == null) {
                b2 = new b(string2);
                this.d.put((Object)string2, (Object)b2);
            }
            return b2;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private void c() {
        Object object;
        Set set = (Set)this.a.a(d.j);
        if (set == null) {
            return;
        }
        Object object2 = object = this.c;
        synchronized (object2) {
            try {
                try {
                    Iterator iterator = set.iterator();
                    while (iterator.hasNext()) {
                        b b2 = new b(new JSONObject((String)iterator.next()));
                        this.d.put((Object)b2.a(), (Object)b2);
                    }
                }
                catch (JSONException jSONException) {
                    this.b.b("TaskStatsManager", "Failed to convert stats json.", jSONException);
                }
                return;
            }
            catch (Throwable throwable2) {}
            throw throwable2;
        }
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
    private void d() {
        Object object;
        Object object2 = object = this.c;
        // MONITORENTER : object2
        HashSet hashSet = new HashSet(this.d.size());
        for (b b2 : this.d.values()) {
            try {
                hashSet.add((Object)b2.c().toString());
            }
            catch (JSONException jSONException) {
                p p2 = this.b;
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Failed to serialize ");
                stringBuilder.append((Object)b2);
                p2.b("TaskStatsManager", stringBuilder.toString(), jSONException);
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
        this.a.a(d.j, hashSet);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public JSONArray a() {
        Object object;
        Object object2 = object = this.c;
        synchronized (object2) {
            JSONArray jSONArray = new JSONArray();
            Iterator iterator = this.d.values().iterator();
            while (iterator.hasNext()) {
                b b2 = (b)iterator.next();
                try {
                    jSONArray.put((Object)b2.c());
                }
                catch (JSONException jSONException) {
                    p p2 = this.b;
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("Failed to serialize ");
                    stringBuilder.append((Object)b2);
                    p2.b("TaskStatsManager", stringBuilder.toString(), jSONException);
                }
            }
            return jSONArray;
        }
    }

    public void a(i i2) {
        this.a(i2, false, 0L);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void a(i i2, long l2) {
        if (i2 == null) {
            throw new IllegalArgumentException("No key specified");
        }
        if (this.a.a(com.applovin.impl.sdk.b.b.eI).booleanValue()) {
            Object object;
            Object object2 = object = this.c;
            synchronized (object2) {
                this.b(i2).a(l2);
                this.d();
                return;
            }
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void a(i i2, boolean bl, long l2) {
        Object object;
        if (i2 == null) {
            throw new IllegalArgumentException("No key specified");
        }
        if (!this.a.a(com.applovin.impl.sdk.b.b.eI).booleanValue()) {
            return;
        }
        Object object2 = object = this.c;
        synchronized (object2) {
            b b2 = this.b(i2);
            b2.b();
            if (bl) {
                b2.a(l2);
            }
            this.d();
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
            this.a.b(d.j);
            return;
        }
    }

    private static class a {
        static final String a;
        static final String b;
        static final String c;
        static final String d;
        static final String e;
        static final String f;
        static final String g;
        private static final Set<String> h;

        static {
            h = new HashSet(7);
            a = a.a("tk");
            b = a.a("tc");
            c = a.a("ec");
            d = a.a("dm");
            e = a.a("dv");
            f = a.a("dh");
            g = a.a("dl");
        }

        private static String a(String string2) {
            if (!TextUtils.isEmpty((CharSequence)string2)) {
                if (!h.contains((Object)string2)) {
                    h.add((Object)string2);
                    return string2;
                }
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Key has already been used: ");
                stringBuilder.append(string2);
                throw new IllegalArgumentException(stringBuilder.toString());
            }
            throw new IllegalArgumentException("No key name specified");
        }
    }

    private static class b {
        private final String a;
        private int b = 0;
        private int c = 0;
        private double d = 0.0;
        private double e = 0.0;
        private Long f = null;
        private Long g = null;

        b(String string2) {
            this.a = string2;
        }

        b(JSONObject jSONObject) throws JSONException {
            this.a = jSONObject.getString(a.a);
            this.b = jSONObject.getInt(a.b);
            this.c = jSONObject.getInt(a.c);
            this.d = jSONObject.getDouble(a.d);
            this.e = jSONObject.getDouble(a.e);
            this.f = jSONObject.optLong(a.f);
            this.g = jSONObject.optLong(a.g);
        }

        String a() {
            return this.a;
        }

        void a(long l2) {
            Long l3;
            int n2 = this.b;
            double d2 = this.d;
            double d3 = this.e;
            this.b = n2 + 1;
            double d4 = n2;
            Double.isNaN((double)d4);
            double d5 = d2 * d4;
            double d6 = l2;
            Double.isNaN((double)d6);
            double d7 = d5 + d6;
            int n3 = this.b;
            double d8 = n3;
            Double.isNaN((double)d8);
            this.d = d7 / d8;
            double d9 = n3;
            Double.isNaN((double)d4);
            Double.isNaN((double)d9);
            double d10 = d4 / d9;
            Double.isNaN((double)d6);
            double d11 = Math.pow((double)(d2 - d6), (double)2.0);
            double d12 = this.b;
            Double.isNaN((double)d12);
            this.e = d10 * (d3 + d11 / d12);
            Long l4 = this.f;
            if (l4 == null || l2 > l4) {
                this.f = l2;
            }
            if ((l3 = this.g) == null || l2 < l3) {
                this.g = l2;
            }
        }

        void b() {
            this.c = 1 + this.c;
        }

        JSONObject c() throws JSONException {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(a.a, (Object)this.a);
            jSONObject.put(a.b, this.b);
            jSONObject.put(a.c, this.c);
            jSONObject.put(a.d, this.d);
            jSONObject.put(a.e, this.e);
            jSONObject.put(a.f, (Object)this.f);
            jSONObject.put(a.g, (Object)this.g);
            return jSONObject;
        }

        public String toString() {
            try {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("[TaskStats n=");
                stringBuilder.append(this.a);
                stringBuilder.append(", stats=");
                stringBuilder.append(this.c().toString());
                stringBuilder.append("]");
                String string2 = stringBuilder.toString();
                return string2;
            }
            catch (JSONException jSONException) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("[TaskStats n=");
                stringBuilder.append(this.a);
                stringBuilder.append(", count=");
                stringBuilder.append(this.b);
                stringBuilder.append("]");
                return stringBuilder.toString();
            }
        }
    }

}

