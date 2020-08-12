/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.os.Bundle
 *  com.applovin.impl.sdk.b.a
 *  com.applovin.impl.sdk.b.b
 *  com.applovin.impl.sdk.e.g
 *  com.applovin.impl.sdk.e.j
 *  com.applovin.impl.sdk.j
 *  com.applovin.impl.sdk.p
 *  com.applovin.sdk.AppLovinPrivacySettings
 *  java.lang.Boolean
 *  java.lang.CharSequence
 *  java.lang.IllegalArgumentException
 *  java.lang.Long
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.util.ArrayList
 *  java.util.Collection
 *  java.util.Collections
 *  java.util.List
 *  java.util.Map
 *  java.util.Set
 *  org.json.JSONArray
 *  org.json.JSONException
 *  org.json.JSONObject
 */
package com.applovin.impl.mediation.a;

import android.content.Context;
import android.os.Bundle;
import com.applovin.impl.sdk.b.a;
import com.applovin.impl.sdk.b.b;
import com.applovin.impl.sdk.e.g;
import com.applovin.impl.sdk.e.j;
import com.applovin.impl.sdk.p;
import com.applovin.sdk.AppLovinPrivacySettings;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class e {
    private final JSONObject a;
    protected final com.applovin.impl.sdk.j b;
    private final JSONObject c;
    private final Object d = new Object();
    private final Object e = new Object();

    public e(JSONObject jSONObject, JSONObject jSONObject2, com.applovin.impl.sdk.j j2) {
        if (j2 != null) {
            if (jSONObject2 != null) {
                if (jSONObject != null) {
                    this.b = j2;
                    this.a = jSONObject2;
                    this.c = jSONObject;
                    return;
                }
                throw new IllegalArgumentException("No spec object specified");
            }
            throw new IllegalArgumentException("No full response specified");
        }
        throw new IllegalArgumentException("No sdk specified");
    }

    private List<String> a(List<String> list, Map<String, String> map) {
        p p2 = this.b.u();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Replacing postback macros for postbacks: ");
        stringBuilder.append(list);
        p2.a("MediationAdapterSpec", stringBuilder.toString());
        Map<String, String> map2 = this.a();
        ArrayList arrayList = new ArrayList(list.size());
        for (String string : list) {
            for (String string2 : map2.keySet()) {
                string = string.replace((CharSequence)string2, (CharSequence)this.g((String)map2.get((Object)string2)));
            }
            for (String string3 : map.keySet()) {
                string = string.replace((CharSequence)string3, (CharSequence)map.get((Object)string3));
            }
            arrayList.add((Object)string);
        }
        p p3 = this.b.u();
        StringBuilder stringBuilder2 = new StringBuilder();
        stringBuilder2.append("Finished replacing macros for postbacks: ");
        stringBuilder2.append((Object)arrayList);
        p3.a("MediationAdapterSpec", stringBuilder2.toString());
        return arrayList;
    }

    private Map<String, String> a() {
        String string = (String)this.b.a(a.h);
        try {
            Map map = g.a((JSONObject)new JSONObject(string));
            return map;
        }
        catch (JSONException jSONException) {
            return Collections.EMPTY_MAP;
        }
    }

    private List<String> e(String string) {
        try {
            List list = g.b((JSONArray)this.a(string, new JSONArray()));
            return list;
        }
        catch (JSONException jSONException) {
            return Collections.EMPTY_LIST;
        }
    }

    private List<String> f(String string) {
        try {
            List list = g.b((JSONArray)this.b(string, new JSONArray()));
            return list;
        }
        catch (JSONException jSONException) {
            return Collections.EMPTY_LIST;
        }
    }

    private String g(String string) {
        String string2 = this.b(string, "");
        if (j.b((String)string2)) {
            return string2;
        }
        return this.a(string, "");
    }

    public long A() {
        long l2 = this.b("ad_refresh_ms", -1L);
        if (l2 >= 0L) {
            return l2;
        }
        return this.a("ad_refresh_ms", (Long)this.b.a(a.v));
    }

    public long B() {
        long l2 = this.b("fullscreen_display_delay_ms", -1L);
        if (l2 >= 0L) {
            return l2;
        }
        return (Long)this.b.a(a.D);
    }

    public long C() {
        long l2 = this.b("init_completion_delay_ms", -1L);
        if (l2 >= 0L) {
            return l2;
        }
        return (Long)this.b.a(a.p);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    protected float a(String string, float f2) {
        Object object;
        Object object2 = object = this.d;
        synchronized (object2) {
            return g.a((JSONObject)this.c, (String)string, (float)f2, (com.applovin.impl.sdk.j)this.b);
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    protected int a(String string, int n2) {
        Object object;
        Object object2 = object = this.d;
        synchronized (object2) {
            return g.a((JSONObject)this.c, (String)string, (int)n2, (com.applovin.impl.sdk.j)this.b);
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    protected long a(String string, long l2) {
        Object object;
        Object object2 = object = this.e;
        synchronized (object2) {
            return g.a((JSONObject)this.a, (String)string, (long)l2, (com.applovin.impl.sdk.j)this.b);
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    protected String a(String string, String string2) {
        Object object;
        Object object2 = object = this.e;
        synchronized (object2) {
            return g.a((JSONObject)this.a, (String)string, (String)string2, (com.applovin.impl.sdk.j)this.b);
        }
    }

    public List<String> a(String string, Map<String, String> map) {
        if (string != null) {
            if (this.b(string)) {
                return this.a(this.f(string), map);
            }
            return null;
        }
        throw new IllegalArgumentException("No key specified");
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    protected JSONArray a(String string, JSONArray jSONArray) {
        Object object;
        Object object2 = object = this.e;
        synchronized (object2) {
            return g.a((JSONObject)this.a, (String)string, (JSONArray)jSONArray, (com.applovin.impl.sdk.j)this.b);
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    protected JSONObject a(String string, JSONObject jSONObject) {
        Object object;
        Object object2 = object = this.d;
        synchronized (object2) {
            return g.a((JSONObject)this.c, (String)string, (JSONObject)jSONObject, (com.applovin.impl.sdk.j)this.b);
        }
    }

    public boolean a(Context context) {
        if (this.b("huc")) {
            return this.b("huc", false);
        }
        return this.a("huc", AppLovinPrivacySettings.hasUserConsent((Context)context));
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    protected boolean a(String string) {
        Object object;
        Object object2 = object = this.e;
        synchronized (object2) {
            return this.a.has(string);
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    protected boolean a(String string, Boolean bl) {
        Object object;
        Object object2 = object = this.e;
        synchronized (object2) {
            return g.a((JSONObject)this.a, (String)string, (Boolean)bl, (com.applovin.impl.sdk.j)this.b);
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    protected long b(String string, long l2) {
        Object object;
        Object object2 = object = this.d;
        synchronized (object2) {
            return g.a((JSONObject)this.c, (String)string, (long)l2, (com.applovin.impl.sdk.j)this.b);
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    protected String b(String string, String string2) {
        Object object;
        Object object2 = object = this.d;
        synchronized (object2) {
            return g.a((JSONObject)this.c, (String)string, (String)string2, (com.applovin.impl.sdk.j)this.b);
        }
    }

    /*
     * Enabled aggressive block sorting
     */
    public List<String> b(String string, Map<String, String> map) {
        List<String> list;
        if (string == null) throw new IllegalArgumentException("No key specified");
        boolean bl = this.a(string);
        boolean bl2 = this.b(string);
        if (!bl) {
            if (!bl2) return null;
        }
        if (bl2 && bl) {
            if (!this.d(string)) {
                List<String> list2 = this.f(string);
                list = this.e(string);
                list.addAll(list2);
                return this.a(list, map);
            }
        } else if (bl2) {
            list = this.f(string);
            return this.a(list, map);
        }
        list = this.e(string);
        return this.a(list, map);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    protected JSONArray b(String string, JSONArray jSONArray) {
        Object object;
        Object object2 = object = this.d;
        synchronized (object2) {
            return g.a((JSONObject)this.c, (String)string, (JSONArray)jSONArray, (com.applovin.impl.sdk.j)this.b);
        }
    }

    public boolean b(Context context) {
        if (this.b("aru")) {
            return this.b("aru", false);
        }
        return this.a("aru", AppLovinPrivacySettings.isAgeRestrictedUser((Context)context));
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    protected boolean b(String string) {
        Object object;
        Object object2 = object = this.d;
        synchronized (object2) {
            return this.c.has(string);
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    protected boolean b(String string, Boolean bl) {
        Object object;
        Object object2 = object = this.d;
        synchronized (object2) {
            return g.a((JSONObject)this.c, (String)string, (Boolean)bl, (com.applovin.impl.sdk.j)this.b);
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    protected Object c(String string) {
        Object object;
        Object object2 = object = this.d;
        synchronized (object2) {
            return this.c.opt(string);
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    protected void c(String string, long l2) {
        Object object;
        Object object2 = object = this.d;
        synchronized (object2) {
            g.b((JSONObject)this.c, (String)string, (long)l2, (com.applovin.impl.sdk.j)this.b);
            return;
        }
    }

    public boolean d(String string) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("fire_in_succession_");
        stringBuilder.append(string);
        return this.a(stringBuilder.toString(), true);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    protected JSONObject r() {
        Object object;
        Object object2 = object = this.e;
        synchronized (object2) {
            return this.a;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    protected JSONObject s() {
        Object object;
        Object object2 = object = this.d;
        synchronized (object2) {
            return this.c;
        }
    }

    public String t() {
        return this.b("class", (String)null);
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[MediationAdapterSpec, specObject=");
        stringBuilder.append((Object)this.s());
        stringBuilder.append("fullResponse=");
        stringBuilder.append((Object)this.r());
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    public String u() {
        return this.b("name", (String)null);
    }

    public boolean v() {
        if (this.b("is_testing")) {
            return this.b("is_testing", false);
        }
        return this.a("is_testing", (Boolean)this.b.a(a.E));
    }

    public boolean w() {
        return this.b("run_on_ui_thread", (Boolean)this.b.a(a.r));
    }

    public Bundle x() {
        JSONObject jSONObject;
        if (this.c("server_parameters") instanceof JSONObject && (jSONObject = this.a("server_parameters", (JSONObject)null)) != null) {
            return g.b((JSONObject)jSONObject);
        }
        return Bundle.EMPTY;
    }

    public long y() {
        return this.b("adapter_timeout_ms", (Long)this.b.a(a.s));
    }

    public boolean z() {
        return this.A() >= 0L;
    }
}

