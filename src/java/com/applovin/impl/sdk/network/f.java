/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Integer
 *  java.lang.Object
 *  java.lang.String
 *  java.util.Map
 *  org.json.JSONObject
 */
package com.applovin.impl.sdk.network;

import com.applovin.impl.sdk.j;
import com.applovin.impl.sdk.network.b;
import java.util.Map;
import org.json.JSONObject;

public class f<T>
extends b {
    protected f(a a2) {
        super(a2);
    }

    public static a b(j j2) {
        return new a(j2);
    }

    public static class a<T>
    extends b.a<T> {
        public a(j j2) {
            super(j2);
            this.g = false;
            this.h = j2.a(com.applovin.impl.sdk.b.b.dG);
            this.i = j2.a(com.applovin.impl.sdk.b.b.dF);
            this.j = j2.a(com.applovin.impl.sdk.b.b.dL);
        }

        @Override
        public /* synthetic */ b.a a(int n2) {
            return this.d(n2);
        }

        @Override
        public /* synthetic */ b.a a(Object object) {
            return this.b(object);
        }

        @Override
        public /* synthetic */ b.a a(String string) {
            return this.d(string);
        }

        @Override
        public /* synthetic */ b.a a(Map map) {
            return this.b((Map<String, String>)map);
        }

        @Override
        public /* synthetic */ b.a a(JSONObject jSONObject) {
            return this.b(jSONObject);
        }

        @Override
        public /* synthetic */ b.a a(boolean bl) {
            return this.b(bl);
        }

        @Override
        public /* synthetic */ b a() {
            return this.b();
        }

        @Override
        public /* synthetic */ b.a b(int n2) {
            return this.e(n2);
        }

        @Override
        public /* synthetic */ b.a b(String string) {
            return this.e(string);
        }

        public a b(T t2) {
            this.f = t2;
            return this;
        }

        public a b(Map<String, String> map) {
            this.d = map;
            return this;
        }

        public a b(JSONObject jSONObject) {
            this.e = jSONObject;
            return this;
        }

        public a b(boolean bl) {
            this.k = bl;
            return this;
        }

        public f<T> b() {
            return new f(this);
        }

        @Override
        public /* synthetic */ b.a c(int n2) {
            return this.f(n2);
        }

        @Override
        public /* synthetic */ b.a c(String string) {
            return this.f(string);
        }

        public a d(int n2) {
            this.h = n2;
            return this;
        }

        public a d(String string) {
            this.b = string;
            return this;
        }

        public a e(int n2) {
            this.i = n2;
            return this;
        }

        public a e(String string) {
            this.a = string;
            return this;
        }

        public a f(int n2) {
            this.j = n2;
            return this;
        }

        public a f(String string) {
            this.c = string;
            return this;
        }
    }

}

