/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.applovin.impl.sdk.d.m$1
 *  java.lang.Boolean
 *  java.lang.Integer
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.System
 *  java.lang.Throwable
 *  java.util.HashMap
 *  java.util.Map
 *  java.util.concurrent.TimeUnit
 *  org.json.JSONObject
 */
package com.applovin.impl.sdk.d;

import com.applovin.impl.sdk.ad.d;
import com.applovin.impl.sdk.b.b;
import com.applovin.impl.sdk.c.g;
import com.applovin.impl.sdk.c.h;
import com.applovin.impl.sdk.c.i;
import com.applovin.impl.sdk.d.a;
import com.applovin.impl.sdk.d.m;
import com.applovin.impl.sdk.d.q;
import com.applovin.impl.sdk.d.r;
import com.applovin.impl.sdk.f;
import com.applovin.impl.sdk.j;
import com.applovin.impl.sdk.k;
import com.applovin.impl.sdk.network.b;
import com.applovin.impl.sdk.p;
import com.applovin.sdk.AppLovinAdLoadListener;
import com.applovin.sdk.AppLovinAdSize;
import com.applovin.sdk.AppLovinAdType;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import org.json.JSONObject;

public class m
extends a {
    private final d a;
    private final AppLovinAdLoadListener c;
    private boolean d = false;

    public m(d d2, AppLovinAdLoadListener appLovinAdLoadListener, j j2) {
        this(d2, appLovinAdLoadListener, "TaskFetchNextAd", j2);
    }

    m(d d2, AppLovinAdLoadListener appLovinAdLoadListener, String string, j j2) {
        super(string, j2);
        this.a = d2;
        this.c = appLovinAdLoadListener;
    }

    private void a(h h2) {
        long l2 = h2.b(g.c);
        long l3 = System.currentTimeMillis();
        if (l3 - l2 > TimeUnit.MINUTES.toMillis((long)this.b.a(b.ed).intValue())) {
            h2.b(g.c, l3);
            h2.c(g.d);
        }
    }

    static /* synthetic */ void a(m m2, int n2) {
        m2.b(n2);
    }

    static /* synthetic */ void a(m m2, JSONObject jSONObject) {
        m2.b(jSONObject);
    }

    private void b(int n2) {
        boolean bl = n2 != 204;
        p p2 = this.b().u();
        String string = this.c();
        Boolean bl2 = bl;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Unable to fetch ");
        stringBuilder.append((Object)this.a);
        stringBuilder.append(" ad: server returned ");
        stringBuilder.append(n2);
        p2.a(string, bl2, stringBuilder.toString());
        try {
            this.a(n2);
            return;
        }
        catch (Throwable throwable) {
            this.b().u().c(this.c(), "Unable process a failure to recieve an ad", throwable);
            return;
        }
    }

    private void b(JSONObject jSONObject) {
        com.applovin.impl.sdk.e.f.d(jSONObject, this.b);
        com.applovin.impl.sdk.e.f.c(jSONObject, this.b);
        this.b.h();
        com.applovin.impl.sdk.e.f.e(jSONObject, this.b);
        a a2 = this.a(jSONObject);
        if (this.b.a(b.fb).booleanValue()) {
            this.b.C().a(a2);
            return;
        }
        this.b.C().a(a2, q.a.a);
    }

    @Override
    public i a() {
        return i.n;
    }

    protected a a(JSONObject jSONObject) {
        r r2 = new r(jSONObject, this.a, this.g(), this.c, this.b);
        return r2;
    }

    protected void a(int n2) {
        AppLovinAdLoadListener appLovinAdLoadListener = this.c;
        if (appLovinAdLoadListener != null) {
            if (appLovinAdLoadListener instanceof com.applovin.impl.sdk.m) {
                ((com.applovin.impl.sdk.m)appLovinAdLoadListener).a(this.a, n2);
                return;
            }
            appLovinAdLoadListener.failedToReceiveAd(n2);
        }
    }

    public void a(boolean bl) {
        this.d = bl;
    }

    Map<String, String> f() {
        HashMap hashMap = new HashMap(4);
        hashMap.put((Object)"zone_id", (Object)com.applovin.impl.sdk.e.j.e(this.a.a()));
        if (this.a.b() != null) {
            hashMap.put((Object)"size", (Object)this.a.b().getLabel());
        }
        if (this.a.c() != null) {
            hashMap.put((Object)"require", (Object)this.a.c().getLabel());
        }
        if (this.b.a(b.aa).booleanValue()) {
            hashMap.put((Object)"n", (Object)String.valueOf((Object)f.a(this.b.s()).b(this.a.a())));
        }
        return hashMap;
    }

    protected com.applovin.impl.sdk.ad.b g() {
        if (this.a.l()) {
            return com.applovin.impl.sdk.ad.b.b;
        }
        return com.applovin.impl.sdk.ad.b.c;
    }

    protected String h() {
        return com.applovin.impl.sdk.e.f.e(this.b);
    }

    protected String i() {
        return com.applovin.impl.sdk.e.f.f(this.b);
    }

    public void run() {
        String string;
        StringBuilder stringBuilder;
        if (this.d) {
            stringBuilder = new StringBuilder();
            string = "Preloading next ad of zone: ";
        } else {
            stringBuilder = new StringBuilder();
            string = "Fetching next ad of zone: ";
        }
        stringBuilder.append(string);
        stringBuilder.append((Object)this.a);
        this.a(stringBuilder.toString());
        h h2 = this.b.D();
        h2.a(g.a);
        if (h2.b(g.c) == 0L) {
            h2.b(g.c, System.currentTimeMillis());
        }
        try {
            Map<String, String> map = this.b.G().a(this.f(), this.d, false);
            this.a(h2);
            1 var13_5 = new 1(this, com.applovin.impl.sdk.network.b.a(this.b).a(this.h()).a(map).c(this.i()).b("GET").a(new JSONObject()).a((JSONObject)this.b.a(b.dT)).b(this.b.a(b.dS)).a(), this.b);
            var13_5.a(b.aB);
            var13_5.b(b.aC);
            this.b.C().a((a)var13_5);
            return;
        }
        catch (Throwable throwable) {
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append("Unable to fetch ad ");
            stringBuilder2.append((Object)this.a);
            this.a(stringBuilder2.toString(), throwable);
            this.b(0);
            this.b.E().a(this.a());
            return;
        }
    }
}

