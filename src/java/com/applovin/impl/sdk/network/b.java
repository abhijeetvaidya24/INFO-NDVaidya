/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Boolean
 *  java.lang.Integer
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.util.Arrays
 *  java.util.HashMap
 *  java.util.Map
 *  org.json.JSONObject
 */
package com.applovin.impl.sdk.network;

import com.applovin.impl.sdk.j;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public class b<T> {
    private String a;
    private Map<String, String> b;
    private String c;
    private final JSONObject d;
    private String e;
    private final T f;
    private final boolean g;
    private final int h;
    private int i;
    private final int j;
    private final int k;
    private final boolean l;

    protected b(a<T> a2) {
        this.a = a2.b;
        this.b = a2.d;
        this.c = a2.a;
        this.d = a2.e;
        this.e = a2.c;
        this.f = a2.f;
        this.g = a2.g;
        this.h = a2.h;
        this.i = a2.h;
        this.j = a2.i;
        this.k = a2.j;
        this.l = a2.k;
    }

    public static <T> a<T> a(j j2) {
        return new a(j2);
    }

    public String a() {
        return this.a;
    }

    public void a(int n2) {
        this.i = n2;
    }

    public void a(String string2) {
        this.a = string2;
    }

    public Map<String, String> b() {
        return this.b;
    }

    public void b(String string2) {
        this.c = string2;
    }

    public String c() {
        return this.c;
    }

    public JSONObject d() {
        return this.d;
    }

    public String e() {
        return this.e;
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (!(object instanceof b)) {
            return false;
        }
        b b2 = (b)object;
        String string2 = this.a;
        if (string2 != null ? !string2.equals((Object)b2.a) : b2.a != null) {
            return false;
        }
        Map<String, String> map = this.b;
        if (map != null ? !map.equals(b2.b) : b2.b != null) {
            return false;
        }
        String string3 = this.e;
        if (string3 != null ? !string3.equals((Object)b2.e) : b2.e != null) {
            return false;
        }
        String string4 = this.c;
        if (string4 != null ? !string4.equals((Object)b2.c) : b2.c != null) {
            return false;
        }
        JSONObject jSONObject = this.d;
        if (jSONObject != null ? !jSONObject.equals((Object)b2.d) : b2.d != null) {
            return false;
        }
        T t2 = this.f;
        if (t2 != null ? !t2.equals(b2.f) : b2.f != null) {
            return false;
        }
        if (this.g != b2.g) {
            return false;
        }
        if (this.h != b2.h) {
            return false;
        }
        if (this.i != b2.i) {
            return false;
        }
        if (this.j != b2.j) {
            return false;
        }
        if (this.k != b2.k) {
            return false;
        }
        return this.l == b2.l;
    }

    public T f() {
        return this.f;
    }

    public boolean g() {
        return this.g;
    }

    public int h() {
        return this.h - this.i;
    }

    public int hashCode() {
        JSONObject jSONObject;
        int n2 = 31 * super.hashCode();
        String string2 = this.a;
        int n3 = string2 != null ? string2.hashCode() : 0;
        int n4 = 31 * (n2 + n3);
        String string3 = this.e;
        int n5 = string3 != null ? string3.hashCode() : 0;
        int n6 = 31 * (n4 + n5);
        String string4 = this.c;
        int n7 = string4 != null ? string4.hashCode() : 0;
        int n8 = 31 * (n6 + n7);
        T t2 = this.f;
        int n9 = 0;
        if (t2 != null) {
            n9 = t2.hashCode();
        }
        int n10 = 31 * (31 * (31 * (31 * (31 * (31 * (n8 + n9) + this.g) + this.h) + this.i) + this.j) + this.k) + this.l;
        Map<String, String> map = this.b;
        if (map != null) {
            n10 = n10 * 31 + map.hashCode();
        }
        if ((jSONObject = this.d) != null) {
            char[] arrc = jSONObject.toString().toCharArray();
            Arrays.sort((char[])arrc);
            String string5 = new String(arrc);
            n10 = n10 * 31 + string5.hashCode();
        }
        return n10;
    }

    public int i() {
        return this.i;
    }

    public int j() {
        return this.j;
    }

    public int k() {
        return this.k;
    }

    public boolean l() {
        return this.l;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("HttpRequest {endpoint=");
        stringBuilder.append(this.a);
        stringBuilder.append(", backupEndpoint=");
        stringBuilder.append(this.e);
        stringBuilder.append(", httpMethod=");
        stringBuilder.append(this.c);
        stringBuilder.append(", body=");
        stringBuilder.append((Object)this.d);
        stringBuilder.append(", emptyResponse=");
        stringBuilder.append(this.f);
        stringBuilder.append(", requiresResponse=");
        stringBuilder.append(this.g);
        stringBuilder.append(", initialRetryAttempts=");
        stringBuilder.append(this.h);
        stringBuilder.append(", retryAttemptsLeft=");
        stringBuilder.append(this.i);
        stringBuilder.append(", timeoutMillis=");
        stringBuilder.append(this.j);
        stringBuilder.append(", retryDelayMillis=");
        stringBuilder.append(this.k);
        stringBuilder.append(", encodingEnabled=");
        stringBuilder.append(this.l);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }

    public static class a<T> {
        String a;
        String b;
        String c;
        Map<String, String> d;
        JSONObject e;
        T f;
        boolean g = true;
        int h = 1;
        int i;
        int j;
        boolean k;

        public a(j j2) {
            this.i = j2.a(com.applovin.impl.sdk.b.b.dM);
            this.j = j2.a(com.applovin.impl.sdk.b.b.dL);
            this.k = j2.a(com.applovin.impl.sdk.b.b.eX);
            this.d = new HashMap();
        }

        public a<T> a(int n2) {
            this.h = n2;
            return this;
        }

        public a<T> a(T t2) {
            this.f = t2;
            return this;
        }

        public a<T> a(String string2) {
            this.b = string2;
            return this;
        }

        public a<T> a(Map<String, String> map) {
            this.d = map;
            return this;
        }

        public a<T> a(JSONObject jSONObject) {
            this.e = jSONObject;
            return this;
        }

        public a<T> a(boolean bl) {
            this.k = bl;
            return this;
        }

        public b<T> a() {
            return new b(this);
        }

        public a<T> b(int n2) {
            this.i = n2;
            return this;
        }

        public a<T> b(String string2) {
            this.a = string2;
            return this;
        }

        public a<T> c(int n2) {
            this.j = n2;
            return this;
        }

        public a<T> c(String string2) {
            this.c = string2;
            return this;
        }
    }

}

