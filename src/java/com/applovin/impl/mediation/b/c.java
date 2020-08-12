/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.content.Context
 *  android.graphics.Point
 *  android.os.Bundle
 *  android.text.TextUtils
 *  com.applovin.impl.mediation.b.c$1
 *  java.lang.Boolean
 *  java.lang.CharSequence
 *  java.lang.Exception
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
 *  java.util.LinkedHashSet
 *  java.util.Locale
 *  java.util.Map
 *  java.util.UUID
 *  java.util.concurrent.TimeUnit
 *  org.json.JSONArray
 *  org.json.JSONException
 *  org.json.JSONObject
 */
package com.applovin.impl.mediation.b;

import android.app.Activity;
import android.content.Context;
import android.graphics.Point;
import android.os.Bundle;
import android.text.TextUtils;
import com.applovin.impl.mediation.MediationServiceImpl;
import com.applovin.impl.mediation.b.c;
import com.applovin.impl.mediation.b.f;
import com.applovin.impl.sdk.b.d;
import com.applovin.impl.sdk.c.g;
import com.applovin.impl.sdk.c.i;
import com.applovin.impl.sdk.c.j;
import com.applovin.impl.sdk.d.a;
import com.applovin.impl.sdk.d.q;
import com.applovin.impl.sdk.e.e;
import com.applovin.impl.sdk.e.h;
import com.applovin.impl.sdk.k;
import com.applovin.impl.sdk.network.b;
import com.applovin.impl.sdk.p;
import com.applovin.mediation.MaxAdFormat;
import com.applovin.mediation.MaxAdListener;
import com.applovin.sdk.AppLovinSdkSettings;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Locale;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class c
extends a {
    private final String a;
    private final MaxAdFormat c;
    private final com.applovin.impl.mediation.f d;
    private final Activity e;
    private final MaxAdListener f;
    private JSONArray g;

    public c(String string, MaxAdFormat maxAdFormat, com.applovin.impl.mediation.f f2, Activity activity, com.applovin.impl.sdk.j j2, MaxAdListener maxAdListener) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("TaskFetchMediatedAd ");
        stringBuilder.append(string);
        super(stringBuilder.toString(), j2);
        if (!TextUtils.isEmpty((CharSequence)string)) {
            if (activity != null) {
                if (maxAdListener != null) {
                    this.a = string;
                    this.c = maxAdFormat;
                    this.d = f2;
                    this.e = activity;
                    this.f = maxAdListener;
                    return;
                }
                throw new IllegalArgumentException("No listener specified");
            }
            throw new IllegalArgumentException("No activity specified");
        }
        throw new IllegalArgumentException("No ad unit ID specified");
    }

    private void a(int n2) {
        boolean bl = n2 != 204;
        p p2 = this.b.u();
        String string = this.c();
        Boolean bl2 = bl;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Unable to fetch ");
        stringBuilder.append(this.a);
        stringBuilder.append(" ad: server returned ");
        stringBuilder.append(n2);
        p2.a(string, bl2, stringBuilder.toString());
        this.b(n2);
    }

    static /* synthetic */ void a(c c2, int n2) {
        c2.a(n2);
    }

    static /* synthetic */ void a(c c2, JSONObject jSONObject) {
        c2.a(jSONObject);
    }

    private void a(com.applovin.impl.sdk.c.h h2) {
        long l2 = h2.b(g.c);
        long l3 = System.currentTimeMillis();
        if (l3 - l2 > TimeUnit.MINUTES.toMillis((long)this.b.a(com.applovin.impl.sdk.b.b.ed).intValue())) {
            h2.b(g.c, l3);
            h2.c(g.d);
        }
    }

    private void a(JSONObject jSONObject) {
        try {
            com.applovin.impl.sdk.e.f.d(jSONObject, this.b);
            com.applovin.impl.sdk.e.f.c(jSONObject, this.b);
            com.applovin.impl.sdk.e.f.f(jSONObject, this.b);
            com.applovin.impl.mediation.c.b.a(jSONObject, this.b);
            com.applovin.impl.mediation.c.b.b(jSONObject, this.b);
            this.b.h();
            f f2 = this.b(jSONObject);
            if (this.b.a(com.applovin.impl.sdk.b.a.g).booleanValue()) {
                this.b.C().a(f2);
                return;
            }
            q.a a2 = com.applovin.impl.mediation.c.c.a(this.c, this.b);
            this.b.C().a(f2, a2);
            return;
        }
        catch (Throwable throwable) {
            this.a("Unable to process mediated ad response", throwable);
            this.b(-800);
            return;
        }
    }

    private f b(JSONObject jSONObject) {
        f f2 = new f(this.a, this.c, jSONObject, this.d, this.e, this.b, this.f);
        return f2;
    }

    private void b(int n2) {
        h.a(this.f, this.a, n2, this.b);
    }

    private void c(JSONObject jSONObject) {
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("loaded", (Object)new JSONArray(this.b.a(this.e).getLoadedAdapterClassnames()));
            jSONObject2.put("failed", (Object)new JSONArray(this.b.a(this.e).getFailedAdapterClassnames()));
            jSONObject.put("classname_info", (Object)jSONObject2);
            jSONObject.put("initialized_adapter_classnames", (Object)new JSONArray(this.b.a(this.e).getInitializedAdapterNames()));
            return;
        }
        catch (Exception exception) {
            this.a("Failed to populate adapter classnames", exception);
            return;
        }
    }

    private void d(JSONObject jSONObject) throws JSONException {
        JSONArray jSONArray = this.g;
        if (jSONArray != null) {
            jSONObject.put("signal_data", (Object)jSONArray);
        }
    }

    private void e(JSONObject jSONObject) throws JSONException {
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put("ad_unit_id", (Object)this.a);
        if (this.d != null && this.b.a(com.applovin.impl.sdk.b.a.f).booleanValue()) {
            jSONObject2.put("extra_parameters", (Object)com.applovin.impl.sdk.e.g.a(com.applovin.impl.sdk.e.g.a(this.d.a())));
        }
        if (this.b.a(com.applovin.impl.sdk.b.b.aa).booleanValue()) {
            jSONObject2.put("n", (Object)String.valueOf((Object)com.applovin.impl.sdk.f.a(this.b.s()).b(this.a)));
        }
        jSONObject.put("ad_info", (Object)jSONObject2);
    }

    private String f() {
        return com.applovin.impl.mediation.c.b.a(this.b);
    }

    private void f(JSONObject jSONObject) throws JSONException {
        Boolean bl;
        k.c c2;
        Boolean bl2;
        k k2 = this.b.G();
        k.d d2 = k2.a();
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put("brand", (Object)d2.d);
        jSONObject2.put("brand_name", (Object)d2.e);
        jSONObject2.put("hardware", (Object)d2.f);
        jSONObject2.put("api_level", d2.h);
        jSONObject2.put("carrier", (Object)d2.j);
        jSONObject2.put("country_code", (Object)d2.i);
        jSONObject2.put("locale", (Object)d2.k);
        jSONObject2.put("model", (Object)d2.a);
        jSONObject2.put("os", (Object)d2.b);
        jSONObject2.put("platform", (Object)d2.c);
        jSONObject2.put("revision", (Object)d2.g);
        jSONObject2.put("orientation_lock", (Object)d2.l);
        jSONObject2.put("tz_offset", d2.o);
        jSONObject2.put("wvvc", d2.p);
        jSONObject2.put("adns", (double)d2.m);
        jSONObject2.put("adnsd", d2.n);
        jSONObject2.put("sim", (Object)com.applovin.impl.sdk.e.j.a(d2.u));
        jSONObject2.put("gy", (Object)com.applovin.impl.sdk.e.j.a(d2.v));
        jSONObject2.put("tv", (Object)com.applovin.impl.sdk.e.j.a(d2.w));
        jSONObject2.put("fs", d2.y);
        jSONObject2.put("adr", (Object)com.applovin.impl.sdk.e.j.a(d2.q));
        jSONObject2.put("volume", d2.s);
        jSONObject2.put("network", (Object)com.applovin.impl.sdk.e.f.d(this.b));
        if (com.applovin.impl.sdk.e.j.b(d2.t)) {
            jSONObject2.put("ua", (Object)d2.t);
        }
        if (com.applovin.impl.sdk.e.j.b(d2.x)) {
            jSONObject2.put("so", (Object)d2.x);
        }
        if ((c2 = d2.r) != null) {
            jSONObject2.put("act", c2.a);
            jSONObject2.put("acm", c2.b);
        }
        if ((bl2 = d2.z) != null) {
            jSONObject2.put("huc", (Object)bl2.toString());
        }
        if ((bl = d2.A) != null) {
            jSONObject2.put("aru", (Object)bl.toString());
        }
        Point point = e.a(this.d());
        jSONObject2.put("dx", (Object)Integer.toString((int)point.x));
        jSONObject2.put("dy", (Object)Integer.toString((int)point.y));
        this.g(jSONObject2);
        jSONObject.put("device_info", (Object)jSONObject2);
        k.b b2 = k2.c();
        JSONObject jSONObject3 = new JSONObject();
        jSONObject3.put("package_name", (Object)b2.c);
        jSONObject3.put("installer_name", (Object)b2.d);
        jSONObject3.put("app_name", (Object)b2.a);
        jSONObject3.put("app_version", (Object)b2.b);
        jSONObject3.put("installed_at", b2.f);
        jSONObject3.put("tg", (Object)b2.e);
        jSONObject3.put("api_did", (Object)this.b.a(com.applovin.impl.sdk.b.b.R));
        jSONObject3.put("sdk_version", (Object)"9.2.1");
        jSONObject3.put("build", 111);
        jSONObject3.put("test_ads", this.b.l().isTestAdsEnabled());
        jSONObject3.put("first_install", (Object)String.valueOf((boolean)this.b.A()));
        String string = this.b.a(com.applovin.impl.sdk.b.b.el);
        if (com.applovin.impl.sdk.e.j.b(string)) {
            jSONObject3.put("plugin_version", (Object)string);
        }
        jSONObject.put("app_info", (Object)jSONObject3);
    }

    private String g() {
        return com.applovin.impl.mediation.c.b.b(this.b);
    }

    private void g(JSONObject jSONObject) {
        try {
            k.a a2 = this.b.G().d();
            String string = a2.b;
            if (com.applovin.impl.sdk.e.j.b(string)) {
                jSONObject.put("idfa", (Object)string);
            }
            jSONObject.put("dnt", a2.a);
            return;
        }
        catch (Throwable throwable) {
            this.a("Failed to populate advertising info", throwable);
            return;
        }
    }

    private JSONObject h() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        this.e(jSONObject);
        this.f(jSONObject);
        this.d(jSONObject);
        this.c(jSONObject);
        jSONObject.put("sc", (Object)com.applovin.impl.sdk.e.j.e(this.b.a(com.applovin.impl.sdk.b.b.V)));
        jSONObject.put("sc2", (Object)com.applovin.impl.sdk.e.j.e(this.b.a(com.applovin.impl.sdk.b.b.W)));
        jSONObject.put("server_installed_at", (Object)com.applovin.impl.sdk.e.j.e(this.b.a(com.applovin.impl.sdk.b.b.X)));
        String string = this.b.a(d.r);
        if (com.applovin.impl.sdk.e.j.b(string)) {
            jSONObject.put("persisted_data", (Object)com.applovin.impl.sdk.e.j.e(string));
        }
        if (this.b.a(com.applovin.impl.sdk.b.b.eD).booleanValue()) {
            this.h(jSONObject);
        }
        return jSONObject;
    }

    private void h(JSONObject jSONObject) {
        try {
            com.applovin.impl.sdk.c.h h2 = this.b.D();
            jSONObject.put("li", (Object)String.valueOf((long)h2.b(g.b)));
            jSONObject.put("si", (Object)String.valueOf((long)h2.b(g.d)));
            jSONObject.put("pf", (Object)String.valueOf((long)h2.b(g.h)));
            jSONObject.put("mpf", (Object)String.valueOf((long)h2.b(g.q)));
            jSONObject.put("gpf", (Object)String.valueOf((long)h2.b(g.i)));
            return;
        }
        catch (Throwable throwable) {
            this.a("Failed to populate ad serving info", throwable);
            return;
        }
    }

    @Override
    public i a() {
        return i.C;
    }

    public void a(JSONArray jSONArray) {
        this.g = jSONArray;
    }

    public void run() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Fetching next ad for ad unit id: ");
        stringBuilder.append(this.a);
        stringBuilder.append(" and format: ");
        stringBuilder.append((Object)this.c);
        this.a(stringBuilder.toString());
        com.applovin.impl.sdk.c.h h2 = this.b.D();
        h2.a(g.p);
        if (h2.b(g.c) == 0L) {
            h2.b(g.c, System.currentTimeMillis());
        }
        try {
            JSONObject jSONObject = this.h();
            HashMap hashMap = new HashMap();
            hashMap.put((Object)"rid", (Object)UUID.randomUUID().toString());
            if (jSONObject.has("huc")) {
                hashMap.put((Object)"huc", (Object)String.valueOf((Object)com.applovin.impl.sdk.e.g.a(jSONObject, "huc", false, this.b)));
            }
            if (jSONObject.has("aru")) {
                hashMap.put((Object)"aru", (Object)String.valueOf((Object)com.applovin.impl.sdk.e.g.a(jSONObject, "aru", false, this.b)));
            }
            if (!this.b.a(com.applovin.impl.sdk.b.b.eX).booleanValue()) {
                hashMap.put((Object)"sdk_key", (Object)this.b.s());
            }
            this.a(h2);
            1 var16_5 = new 1(this, b.a(this.b).b("POST").a(this.f()).c(this.g()).a((Map<String, String>)hashMap).a(jSONObject).a(new JSONObject()).b(this.b.a(com.applovin.impl.sdk.b.a.e).intValue()).a((JSONObject)this.b.a(com.applovin.impl.sdk.b.b.dT)).c(this.b.a(com.applovin.impl.sdk.b.a.d).intValue()).a(), this.b);
            var16_5.a(com.applovin.impl.sdk.b.a.a);
            var16_5.b(com.applovin.impl.sdk.b.a.b);
            this.b.C().a((a)var16_5);
            return;
        }
        catch (Throwable throwable) {
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append("Unable to fetch ad ");
            stringBuilder2.append(this.a);
            this.a(stringBuilder2.toString(), throwable);
            this.a(0);
            this.b.E().a(this.a());
            return;
        }
    }
}

