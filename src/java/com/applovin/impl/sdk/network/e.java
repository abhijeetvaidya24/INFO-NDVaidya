/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Boolean
 *  java.lang.Class
 *  java.lang.Exception
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.System
 *  java.util.Collections
 *  java.util.HashMap
 *  java.util.Map
 *  org.json.JSONException
 *  org.json.JSONObject
 */
package com.applovin.impl.sdk.network;

import com.applovin.impl.sdk.b.b;
import com.applovin.impl.sdk.e.g;
import com.applovin.impl.sdk.j;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public class e {
    private String a;
    private String b;
    private Map<String, String> c;
    private Map<String, String> d;
    private boolean e;
    private int f;

    private e(a a2) {
        this.a = a2.a;
        this.b = a2.b;
        this.c = a2.c;
        this.d = a2.d;
        this.e = a2.e;
        this.f = 0;
    }

    e(JSONObject jSONObject, j j2) throws Exception {
        String string2;
        int n2;
        String string3;
        Map<String, String> map;
        Map map2;
        block2 : {
            block1 : {
                block0 : {
                    string3 = jSONObject.getString("targetUrl");
                    n2 = jSONObject.getInt("attemptNumber");
                    map = g.a(jSONObject, "parameters") ? g.a(jSONObject.getJSONObject("parameters")) : Collections.EMPTY_MAP;
                    if (!j2.a(b.dK).booleanValue()) break block0;
                    string2 = g.a(jSONObject, "backupUrl", "", j2);
                    if (g.a(jSONObject, "requestBody")) break block1;
                    map2 = Collections.EMPTY_MAP;
                    break block2;
                }
                string2 = jSONObject.getString("backupUrl");
            }
            map2 = g.a(jSONObject.getJSONObject("requestBody"));
        }
        this.a = string3;
        this.b = string2;
        this.c = map;
        this.d = map2;
        this.e = jSONObject.optBoolean("isEncodingEnabled", false);
        this.f = n2;
    }

    public static a j() {
        return new a();
    }

    String a() {
        return this.a;
    }

    String b() {
        return this.b;
    }

    Map<String, String> c() {
        return this.d;
    }

    Map<String, String> d() {
        return this.c;
    }

    boolean e() {
        return this.e;
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object != null) {
            if (this.getClass() != object.getClass()) {
                return false;
            }
            e e2 = (e)object;
            String string2 = this.a;
            if (string2 != null ? !string2.equals((Object)e2.a) : e2.a != null) {
                return false;
            }
            String string3 = this.b;
            if (string3 != null ? !string3.equals((Object)e2.b) : e2.b != null) {
                return false;
            }
            Map<String, String> map = this.c;
            if (map != null ? !map.equals(e2.c) : e2.c != null) {
                return false;
            }
            Map<String, String> map2 = this.d;
            if (map2 != null ? !map2.equals(e2.d) : e2.d != null) {
                return false;
            }
            if (this.f != e2.f) {
                return false;
            }
            return this.e == e2.e;
        }
        return false;
    }

    int f() {
        return this.f;
    }

    void g() {
        this.f = 1 + this.f;
    }

    void h() {
        HashMap hashMap = new HashMap();
        Map<String, String> map = this.c;
        if (map != null) {
            hashMap.putAll(map);
        }
        hashMap.put((Object)"postback_ts", (Object)String.valueOf((long)System.currentTimeMillis()));
        this.c = hashMap;
    }

    public int hashCode() {
        int n2 = 31 * this.f;
        String string2 = this.a;
        int n3 = string2 != null ? string2.hashCode() : 0;
        int n4 = 31 * (n2 + n3);
        String string3 = this.b;
        int n5 = string3 != null ? string3.hashCode() : 0;
        int n6 = 31 * (n4 + n5);
        Map<String, String> map = this.c;
        int n7 = map != null ? map.hashCode() : 0;
        int n8 = 31 * (n6 + n7);
        Map<String, String> map2 = this.d;
        int n9 = 0;
        if (map2 != null) {
            n9 = map2.hashCode();
        }
        return 31 * (n8 + n9 + this.e);
    }

    JSONObject i() throws JSONException {
        Map<String, String> map;
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("targetUrl", (Object)this.a);
        jSONObject.put("backupUrl", (Object)this.b);
        jSONObject.put("isEncodingEnabled", this.e);
        jSONObject.put("attemptNumber", this.f);
        Map<String, String> map2 = this.c;
        if (map2 != null) {
            jSONObject.put("parameters", (Object)new JSONObject(map2));
        }
        if ((map = this.d) != null) {
            jSONObject.put("requestBody", (Object)new JSONObject(map));
        }
        return jSONObject;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("PostbackRequest{targetUrl='");
        stringBuilder.append(this.a);
        stringBuilder.append('\'');
        stringBuilder.append(", backupUrl='");
        stringBuilder.append(this.b);
        stringBuilder.append('\'');
        stringBuilder.append(", parameters='");
        stringBuilder.append(this.c);
        stringBuilder.append('\'');
        stringBuilder.append(", requestBody=");
        stringBuilder.append(this.d);
        stringBuilder.append(", attemptNumber=");
        stringBuilder.append(this.f);
        stringBuilder.append(", isEncodingEnabled=");
        stringBuilder.append(this.e);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }

    public static class a {
        private String a;
        private String b;
        private Map<String, String> c;
        private Map<String, String> d;
        private boolean e;

        public a a(String string2) {
            this.a = string2;
            return this;
        }

        public a a(Map<String, String> map) {
            this.c = map;
            return this;
        }

        public a a(boolean bl) {
            this.e = bl;
            return this;
        }

        public e a() {
            return new e(this);
        }

        public a b(String string2) {
            this.b = string2;
            return this;
        }

        public a b(Map<String, String> map) {
            this.d = map;
            return this;
        }
    }

}

