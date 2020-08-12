/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.util.HashMap
 *  java.util.Map
 */
package com.startapp.common.b;

import java.util.HashMap;
import java.util.Map;

public class b {
    private final a a;

    private b(a a2) {
        this.a = a2;
    }

    public int a() {
        return this.a.a;
    }

    public Map<String, String> b() {
        return this.a.b;
    }

    public long c() {
        return this.a.c;
    }

    public long d() {
        return this.a.d;
    }

    public boolean e() {
        return this.a.e;
    }

    public boolean f() {
        return this.a.f;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("RunnerRequest: ");
        stringBuilder.append(this.a.a);
        stringBuilder.append(" ");
        stringBuilder.append(this.a.c);
        stringBuilder.append(" ");
        stringBuilder.append(this.a.e);
        stringBuilder.append(" ");
        stringBuilder.append(this.a.d);
        stringBuilder.append(" ");
        stringBuilder.append((Object)this.a.b);
        return stringBuilder.toString();
    }

    public static class a {
        private int a;
        private Map<String, String> b = new HashMap();
        private long c;
        private long d = 100L;
        private boolean e = false;
        private boolean f = false;

        public a(int n2) {
            this.a = n2;
        }

        public a a(long l2) {
            this.c = l2;
            return this;
        }

        public a a(String string, String string2) {
            this.b.put((Object)string, (Object)string2);
            return this;
        }

        public a a(Map<String, String> map) {
            if (map != null) {
                this.b.putAll(map);
            }
            return this;
        }

        public a a(boolean bl) {
            this.e = bl;
            return this;
        }

        public b a() {
            return new b(this);
        }

        public a b(boolean bl) {
            this.f = bl;
            return this;
        }
    }

}

