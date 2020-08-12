/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.webkit.WebView
 *  com.b.a.a.a.b.i
 *  java.lang.Enum
 *  java.lang.Object
 *  java.lang.String
 *  java.util.List
 *  org.json.JSONArray
 *  org.json.JSONObject
 */
package com.b.a.a.a.g;

import android.content.Context;
import android.webkit.WebView;
import com.b.a.a.a.b.d;
import com.b.a.a.a.b.e;
import com.b.a.a.a.b.g;
import com.b.a.a.a.b.h;
import com.b.a.a.a.b.i;
import com.b.a.a.a.c.c;
import com.b.a.a.a.f.b;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public abstract class a {
    private b a;
    private com.b.a.a.a.b.a b;
    private com.b.a.a.a.b.a.a c;
    private a d;
    private double e;

    public a() {
        this.i();
        this.a = new b(null);
    }

    public void a() {
    }

    public void a(float f2) {
        com.b.a.a.a.c.d.a().a(this.c(), f2);
    }

    void a(WebView webView) {
        this.a = new b(webView);
    }

    public void a(com.b.a.a.a.b.a.a a2) {
        this.c = a2;
    }

    public void a(com.b.a.a.a.b.a a2) {
        this.b = a2;
    }

    public void a(com.b.a.a.a.b.c c2) {
        com.b.a.a.a.c.d.a().a(this.c(), c2.c());
    }

    public void a(i i2, d d2) {
        String string2 = i2.g();
        JSONObject jSONObject = new JSONObject();
        com.b.a.a.a.e.b.a(jSONObject, "environment", "app");
        com.b.a.a.a.e.b.a(jSONObject, "adSessionType", (Object)d2.f());
        com.b.a.a.a.e.b.a(jSONObject, "deviceInfo", (Object)com.b.a.a.a.e.a.d());
        JSONArray jSONArray = new JSONArray();
        jSONArray.put((Object)"clid");
        jSONArray.put((Object)"vlid");
        com.b.a.a.a.e.b.a(jSONObject, "supports", (Object)jSONArray);
        JSONObject jSONObject2 = new JSONObject();
        com.b.a.a.a.e.b.a(jSONObject2, "partnerName", d2.a().a());
        com.b.a.a.a.e.b.a(jSONObject2, "partnerVersion", d2.a().b());
        com.b.a.a.a.e.b.a(jSONObject, "omidNativeInfo", (Object)jSONObject2);
        JSONObject jSONObject3 = new JSONObject();
        com.b.a.a.a.e.b.a(jSONObject3, "libraryVersion", "1.2.0-Startapp");
        com.b.a.a.a.e.b.a(jSONObject3, "appId", c.a().b().getApplicationContext().getPackageName());
        com.b.a.a.a.e.b.a(jSONObject, "app", (Object)jSONObject3);
        if (d2.d() != null) {
            com.b.a.a.a.e.b.a(jSONObject, "customReferenceData", d2.d());
        }
        JSONObject jSONObject4 = new JSONObject();
        for (h h2 : d2.b()) {
            com.b.a.a.a.e.b.a(jSONObject4, h2.a(), h2.c());
        }
        com.b.a.a.a.c.d.a().a(this.c(), string2, jSONObject, jSONObject4);
    }

    public void a(String string2) {
        com.b.a.a.a.c.d.a().a(this.c(), string2, null);
    }

    public void a(String string2, double d2) {
        if (d2 > this.e) {
            this.d = a.b;
            com.b.a.a.a.c.d.a().c(this.c(), string2);
        }
    }

    public void a(String string2, JSONObject jSONObject) {
        com.b.a.a.a.c.d.a().a(this.c(), string2, jSONObject);
    }

    public void a(boolean bl) {
        if (this.f()) {
            String string2 = bl ? "foregrounded" : "backgrounded";
            com.b.a.a.a.c.d.a().d(this.c(), string2);
        }
    }

    public void b() {
        this.a.clear();
    }

    public void b(String string2, double d2) {
        if (d2 > this.e && this.d != a.c) {
            this.d = a.c;
            com.b.a.a.a.c.d.a().c(this.c(), string2);
        }
    }

    public WebView c() {
        return (WebView)this.a.get();
    }

    public com.b.a.a.a.b.a d() {
        return this.b;
    }

    public com.b.a.a.a.b.a.a e() {
        return this.c;
    }

    public boolean f() {
        return this.a.get() != null;
    }

    public void g() {
        com.b.a.a.a.c.d.a().a(this.c());
    }

    public void h() {
        com.b.a.a.a.c.d.a().b(this.c());
    }

    public void i() {
        this.e = com.b.a.a.a.e.d.a();
        this.d = a.a;
    }

    static final class a
    extends Enum<a> {
        public static final /* enum */ a a = new a();
        public static final /* enum */ a b = new a();
        public static final /* enum */ a c = new a();
        private static final /* synthetic */ a[] d;

        static {
            a[] arra = new a[]{a, b, c};
            d = arra;
        }

        public static a valueOf(String string2) {
            return (a)Enum.valueOf(a.class, (String)string2);
        }

        public static a[] values() {
            return (a[])d.clone();
        }
    }

}

