/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.text.TextUtils
 *  com.applovin.impl.sdk.d.b$1
 *  java.lang.Boolean
 *  java.lang.CharSequence
 *  java.lang.Integer
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.Throwable
 *  java.util.List
 *  java.util.Locale
 *  java.util.Map
 *  org.json.JSONArray
 *  org.json.JSONException
 *  org.json.JSONObject
 */
package com.applovin.impl.sdk.d;

import android.content.Context;
import android.text.TextUtils;
import com.applovin.impl.sdk.b.c;
import com.applovin.impl.sdk.c.f;
import com.applovin.impl.sdk.c.h;
import com.applovin.impl.sdk.c.i;
import com.applovin.impl.sdk.d.a;
import com.applovin.impl.sdk.d.b;
import com.applovin.impl.sdk.d.q;
import com.applovin.impl.sdk.e.d;
import com.applovin.impl.sdk.e.g;
import com.applovin.impl.sdk.j;
import com.applovin.impl.sdk.k;
import com.applovin.impl.sdk.network.b;
import com.applovin.impl.sdk.p;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

class b
extends a {
    b(j j2) {
        super("TaskApiSubmitData", j2);
    }

    static /* synthetic */ void a(b b2, JSONObject jSONObject) {
        b2.a(jSONObject);
    }

    private void a(JSONObject jSONObject) {
        try {
            this.b.H().c();
            JSONObject jSONObject2 = com.applovin.impl.sdk.e.f.a(jSONObject);
            c c2 = this.b.v();
            c2.a(com.applovin.impl.sdk.b.b.R, jSONObject2.getString("device_id"));
            c2.a(com.applovin.impl.sdk.b.b.T, jSONObject2.getString("device_token"));
            c2.a(com.applovin.impl.sdk.b.b.S, jSONObject2.getString("publisher_id"));
            c2.a();
            com.applovin.impl.sdk.e.f.d(jSONObject2, this.b);
            this.b.h();
            com.applovin.impl.sdk.e.f.e(jSONObject2, this.b);
            String string = g.a(jSONObject2, "latest_version", "", this.b);
            if (this.e(string)) {
                p p2 = this.b.u();
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Please integrate the latest version of the AppLovin SDK (");
                stringBuilder.append(string);
                stringBuilder.append("). Not doing so can negatively impact your eCPMs!");
                p2.e("ALSdk", stringBuilder.toString());
            }
            this.b.D().b();
            this.b.E().b();
            return;
        }
        catch (Throwable throwable) {
            this.a("Unable to parse API response", throwable);
            return;
        }
    }

    private void b(JSONObject jSONObject) throws JSONException {
        k.c c2;
        Locale locale;
        Boolean bl;
        String string;
        String string2;
        k k2 = this.b.G();
        k.b b2 = k2.c();
        k.d d2 = k2.a();
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put("model", (Object)d2.a);
        jSONObject2.put("os", (Object)d2.b);
        jSONObject2.put("brand", (Object)d2.d);
        jSONObject2.put("brand_name", (Object)d2.e);
        jSONObject2.put("hardware", (Object)d2.f);
        jSONObject2.put("sdk_version", d2.h);
        jSONObject2.put("revision", (Object)d2.g);
        jSONObject2.put("adns", (double)d2.m);
        jSONObject2.put("adnsd", d2.n);
        jSONObject2.put("gy", (Object)com.applovin.impl.sdk.e.j.a(d2.v));
        jSONObject2.put("country_code", (Object)d2.i);
        jSONObject2.put("carrier", (Object)d2.j);
        jSONObject2.put("orientation_lock", (Object)d2.l);
        jSONObject2.put("tz_offset", d2.o);
        jSONObject2.put("adr", (Object)com.applovin.impl.sdk.e.j.a(d2.q));
        jSONObject2.put("wvvc", d2.p);
        jSONObject2.put("volume", d2.s);
        jSONObject2.put("type", (Object)"android");
        jSONObject2.put("sim", (Object)com.applovin.impl.sdk.e.j.a(d2.u));
        jSONObject2.put("tv", (Object)com.applovin.impl.sdk.e.j.a(d2.w));
        jSONObject2.put("fs", d2.y);
        this.g(jSONObject2);
        Boolean bl2 = d2.z;
        if (bl2 != null) {
            jSONObject2.put("huc", (Object)bl2.toString());
        }
        if ((bl = d2.A) != null) {
            jSONObject2.put("aru", (Object)bl.toString());
        }
        if ((c2 = d2.r) != null) {
            jSONObject2.put("act", c2.a);
            jSONObject2.put("acm", c2.b);
        }
        if (com.applovin.impl.sdk.e.j.b(string2 = d2.t)) {
            jSONObject2.put("ua", (Object)com.applovin.impl.sdk.e.j.e(string2));
        }
        if (!TextUtils.isEmpty((CharSequence)(string = d2.x))) {
            jSONObject2.put("so", (Object)com.applovin.impl.sdk.e.j.e(string));
        }
        if ((locale = d2.k) != null) {
            jSONObject2.put("locale", (Object)com.applovin.impl.sdk.e.j.e(locale.toString()));
        }
        jSONObject.put("device_info", (Object)jSONObject2);
        JSONObject jSONObject3 = new JSONObject();
        jSONObject3.put("package_name", (Object)b2.c);
        jSONObject3.put("installer_name", (Object)b2.d);
        jSONObject3.put("app_name", (Object)b2.a);
        jSONObject3.put("app_version", (Object)b2.b);
        jSONObject3.put("installed_at", b2.f);
        jSONObject3.put("tg", (Object)b2.e);
        jSONObject3.put("applovin_sdk_version", (Object)"9.2.1");
        jSONObject3.put("first_install", (Object)String.valueOf((boolean)this.b.A()));
        String string3 = this.b.a(com.applovin.impl.sdk.b.b.el);
        if (string3 != null && string3.length() > 0) {
            jSONObject3.put("plugin_version", (Object)string3);
        }
        jSONObject.put("app_info", (Object)jSONObject3);
    }

    private void c(JSONObject jSONObject) throws JSONException {
        if (this.b.a(com.applovin.impl.sdk.b.b.eD).booleanValue()) {
            jSONObject.put("stats", (Object)this.b.D().c());
        }
        if (this.b.a(com.applovin.impl.sdk.b.b.ae).booleanValue()) {
            JSONObject jSONObject2 = com.applovin.impl.sdk.network.c.b(this.d());
            if (jSONObject2.length() > 0) {
                jSONObject.put("network_response_codes", (Object)jSONObject2);
            }
            if (this.b.a(com.applovin.impl.sdk.b.b.af).booleanValue()) {
                com.applovin.impl.sdk.network.c.a(this.d());
            }
        }
    }

    private void d(JSONObject jSONObject) throws JSONException {
        JSONArray jSONArray;
        if (this.b.a(com.applovin.impl.sdk.b.b.eJ).booleanValue() && (jSONArray = this.b.H().a()) != null && jSONArray.length() > 0) {
            jSONObject.put("errors", (Object)jSONArray);
        }
    }

    private void e(JSONObject jSONObject) throws JSONException {
        JSONArray jSONArray;
        if (this.b.a(com.applovin.impl.sdk.b.b.eI).booleanValue() && (jSONArray = this.b.E().a()) != null && jSONArray.length() > 0) {
            jSONObject.put("tasks", (Object)jSONArray);
        }
    }

    private boolean e(String string) {
        block5 : {
            if (!com.applovin.impl.sdk.e.j.b(string) || "9.2.1".equals((Object)string)) break block5;
            List<String> list = d.a(string, "\\.");
            List<String> list2 = d.a("9.2.1", "\\.");
            if (list.size() != 3 || list2.size() != 3) break block5;
            for (int i2 = 0; i2 < 3; ++i2) {
                try {
                    int n2 = Integer.parseInt((String)((String)list2.get(i2)));
                    int n3 = Integer.parseInt((String)((String)list.get(i2)));
                    if (n2 < n3) {
                        return true;
                    }
                    if (n2 <= n3) continue;
                    return false;
                }
                catch (Throwable throwable) {
                    this.a("Encountered exception while checking if current version is outdated", throwable);
                    break;
                }
            }
        }
        return false;
    }

    private void f(JSONObject jSONObject) {
        1 var2_2 = new 1(this, com.applovin.impl.sdk.network.b.a(this.b).a(com.applovin.impl.sdk.e.f.a("2.0/device", this.b)).c(com.applovin.impl.sdk.e.f.b("2.0/device", this.b)).a(com.applovin.impl.sdk.e.f.c(this.b)).b("POST").a(jSONObject).a(new JSONObject()).a((JSONObject)this.b.a(com.applovin.impl.sdk.b.b.dV)).a(), this.b);
        var2_2.a(com.applovin.impl.sdk.b.b.aD);
        var2_2.b(com.applovin.impl.sdk.b.b.aE);
        this.b.C().a((a)var2_2);
    }

    private void g(JSONObject jSONObject) {
        try {
            k.a a2 = this.b.G().d();
            String string = a2.b;
            if (com.applovin.impl.sdk.e.j.b(string)) {
                jSONObject.put("idfa", (Object)string);
            }
            jSONObject.put("dnt", (Object)Boolean.toString((boolean)a2.a));
            return;
        }
        catch (Throwable throwable) {
            this.a("Failed to populate advertising info", throwable);
            return;
        }
    }

    @Override
    public i a() {
        return i.h;
    }

    public void run() {
        try {
            this.b("Submitting user data...");
            JSONObject jSONObject = new JSONObject();
            this.b(jSONObject);
            this.c(jSONObject);
            this.d(jSONObject);
            this.e(jSONObject);
            this.f(jSONObject);
            return;
        }
        catch (JSONException jSONException) {
            this.a("Unable to build JSON message with collected data", jSONException);
            this.b.E().a(this.a());
            return;
        }
    }
}

