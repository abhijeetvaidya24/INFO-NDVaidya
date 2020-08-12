/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.applovin.impl.sdk.ad.a
 *  com.applovin.impl.sdk.d.d
 *  java.lang.Boolean
 *  java.lang.Object
 *  java.lang.String
 *  org.json.JSONObject
 */
package com.applovin.impl.sdk.d;

import com.applovin.impl.sdk.b.b;
import com.applovin.impl.sdk.c.i;
import com.applovin.impl.sdk.d.a;
import com.applovin.impl.sdk.d.d;
import com.applovin.impl.sdk.d.q;
import com.applovin.impl.sdk.e.g;
import com.applovin.impl.sdk.j;
import com.applovin.sdk.AppLovinAdLoadListener;
import com.applovin.sdk.AppLovinAdSize;
import com.applovin.sdk.AppLovinAdType;
import org.json.JSONObject;

class t
extends a {
    private final JSONObject a;
    private final JSONObject c;
    private final AppLovinAdLoadListener d;
    private final com.applovin.impl.sdk.ad.b e;

    t(JSONObject jSONObject, JSONObject jSONObject2, com.applovin.impl.sdk.ad.b b2, AppLovinAdLoadListener appLovinAdLoadListener, j j2) {
        super("TaskRenderAppLovinAd", j2);
        this.a = jSONObject;
        this.c = jSONObject2;
        this.e = b2;
        this.d = appLovinAdLoadListener;
    }

    @Override
    public i a() {
        return i.t;
    }

    public void run() {
        this.a("Rendering ad...");
        com.applovin.impl.sdk.ad.a a2 = new com.applovin.impl.sdk.ad.a(this.a, this.c, this.e, this.b);
        boolean bl = g.a(this.a, "gs_load_immediately", false, this.b);
        boolean bl2 = g.a(this.a, "vs_load_immediately", true, this.b);
        d d2 = new d(a2, this.b, this.d);
        d2.a(bl2);
        d2.b(bl);
        q.a a3 = q.a.g;
        if (this.b.a(b.aX).booleanValue()) {
            if (a2.getSize() == AppLovinAdSize.INTERSTITIAL && a2.getType() == AppLovinAdType.REGULAR) {
                a3 = q.a.e;
            } else if (a2.getSize() == AppLovinAdSize.INTERSTITIAL && a2.getType() == AppLovinAdType.INCENTIVIZED) {
                a3 = q.a.f;
            }
        }
        this.b.C().a((a)d2, a3);
    }
}

