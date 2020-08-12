/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.os.Build
 *  android.os.Build$VERSION
 *  android.text.TextUtils
 *  com.applovin.impl.sdk.d.k$1
 *  java.lang.Boolean
 *  java.lang.CharSequence
 *  java.lang.Integer
 *  java.lang.Object
 *  java.lang.String
 *  java.util.HashMap
 *  java.util.Map
 *  java.util.Set
 *  java.util.concurrent.atomic.AtomicBoolean
 *  org.json.JSONObject
 */
package com.applovin.impl.sdk.d;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.applovin.impl.mediation.c.c;
import com.applovin.impl.sdk.b.b;
import com.applovin.impl.sdk.b.d;
import com.applovin.impl.sdk.c.i;
import com.applovin.impl.sdk.d.k;
import com.applovin.impl.sdk.d.p;
import com.applovin.impl.sdk.d.q;
import com.applovin.impl.sdk.e.f;
import com.applovin.impl.sdk.e.m;
import com.applovin.impl.sdk.g;
import com.applovin.impl.sdk.j;
import com.applovin.impl.sdk.k;
import com.applovin.impl.sdk.network.b;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

public class k
extends com.applovin.impl.sdk.d.a {
    private static int a;
    private final AtomicBoolean c = new AtomicBoolean();

    public k(j j2) {
        super("TaskFetchBasicSettings", j2, true);
    }

    private void a(JSONObject jSONObject) {
        if (this.c.compareAndSet(false, true)) {
            f.d(jSONObject, this.b);
            f.c(jSONObject, this.b);
            com.applovin.impl.mediation.c.b.a(jSONObject, this.b);
            com.applovin.impl.mediation.c.b.b(jSONObject, this.b);
            this.b("Executing initialize SDK...");
            p p2 = new p(this.b);
            this.b.C().a(p2);
            f.e(jSONObject, this.b);
            f.f(jSONObject, this.b);
            this.b("Finished executing initialize SDK");
        }
    }

    private String g() {
        return f.a(this.b.a(b.az), "4.0/i", this.b());
    }

    private String h() {
        return f.a(this.b.a(b.aA), "4.0/i", this.b());
    }

    @Override
    public i a() {
        return i.d;
    }

    protected Map<String, String> f() {
        String string;
        Boolean bl;
        int n2;
        Boolean bl2;
        String string2;
        HashMap hashMap = new HashMap();
        hashMap.put((Object)"sdk_version", (Object)"9.2.1");
        hashMap.put((Object)"build", (Object)String.valueOf((int)111));
        a = n2 = 1 + a;
        hashMap.put((Object)"init_count", (Object)String.valueOf((int)n2));
        hashMap.put((Object)"server_installed_at", (Object)com.applovin.impl.sdk.e.j.e(this.b.a(b.X)));
        m.a("first_install", this.b.A(), (Map<String, String>)hashMap);
        if (!this.b.a(b.eX).booleanValue()) {
            hashMap.put((Object)"sdk_key", (Object)this.b.s());
        }
        if ((bl2 = g.a(this.d())) != null) {
            hashMap.put((Object)"huc", (Object)bl2.toString());
        }
        if ((bl = g.b(this.d())) != null) {
            hashMap.put((Object)"aru", (Object)bl.toString());
        }
        if (com.applovin.impl.sdk.e.j.b(string2 = this.b.a(b.el))) {
            hashMap.put((Object)"plugin_version", (Object)com.applovin.impl.sdk.e.j.e(string2));
        }
        if (com.applovin.impl.sdk.e.j.b(string = this.b.m())) {
            hashMap.put((Object)"mediation_provider", (Object)com.applovin.impl.sdk.e.j.e(string));
        }
        c.a a2 = c.a();
        hashMap.put((Object)"installed_mediation_adapter_classnames", (Object)com.applovin.impl.sdk.e.j.e(TextUtils.join((CharSequence)",", a2.a())));
        hashMap.put((Object)"uninstalled_mediation_adapter_classnames", (Object)com.applovin.impl.sdk.e.j.e(TextUtils.join((CharSequence)",", a2.b())));
        k.b b2 = this.b.G().c();
        hashMap.put((Object)"package_name", (Object)com.applovin.impl.sdk.e.j.e(b2.c));
        hashMap.put((Object)"app_version", (Object)com.applovin.impl.sdk.e.j.e(b2.b));
        hashMap.put((Object)"platform", (Object)com.applovin.impl.sdk.e.j.e(this.b.G().b()));
        hashMap.put((Object)"os", (Object)com.applovin.impl.sdk.e.j.e(Build.VERSION.RELEASE));
        hashMap.put((Object)"tg", (Object)this.b.a(d.c));
        return hashMap;
    }

    public void run() {
        Map<String, String> map = this.f();
        com.applovin.impl.sdk.network.b<JSONObject> b2 = com.applovin.impl.sdk.network.b.a(this.b).a(this.g()).c(this.h()).a(map).b("GET").a(new JSONObject()).a((JSONObject)this.b.a(b.dY)).c(this.b.a(b.dZ)).b(this.b.a(b.dX)).a();
        this.b.C().a(new a(this.b), q.a.b, 250L + (long)this.b.a(b.dX).intValue());
        1 var3_3 = new 1(this, b2, this.b, this.e());
        var3_3.a(b.aB);
        var3_3.b(b.aC);
        this.b.C().a((com.applovin.impl.sdk.d.a)var3_3);
    }

    private class a
    extends com.applovin.impl.sdk.d.a {
        public a(j j2) {
            super("TaskTimeoutFetchBasicSettings", j2, true);
        }

        @Override
        public i a() {
            return i.g;
        }

        public void run() {
            this.d("Timing out fetch basic settings...");
            k.this.a(new JSONObject());
        }
    }

}

