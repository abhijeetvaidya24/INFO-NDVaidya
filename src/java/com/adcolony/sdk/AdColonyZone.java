/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.String
 *  org.json.JSONObject
 */
package com.adcolony.sdk;

import com.adcolony.sdk.a;
import com.adcolony.sdk.ad;
import com.adcolony.sdk.w;
import com.adcolony.sdk.y;
import org.json.JSONObject;

public class AdColonyZone {
    private String h;
    private String i;
    private String j;
    private String k;
    private int l = 5;
    private int m;
    private int n;
    private int o;
    private int p;
    private int q;
    private int r;
    private boolean s;
    private boolean t;

    AdColonyZone(String string) {
        this.h = string;
    }

    private int c(int n2) {
        if (a.b() && !a.a().g() && !a.a().h()) {
            return n2;
        }
        this.c();
        return 0;
    }

    private void c() {
        new y.a().a("The AdColonyZone API is not available while AdColony is disabled.").a(y.g);
    }

    void a(int n2) {
        this.r = n2;
    }

    void a(ad ad2) {
        JSONObject jSONObject = ad2.c();
        JSONObject jSONObject2 = w.f(jSONObject, "reward");
        this.i = w.b(jSONObject2, "reward_name");
        this.q = w.c(jSONObject2, "reward_amount");
        this.o = w.c(jSONObject2, "views_per_reward");
        this.n = w.c(jSONObject2, "views_until_reward");
        this.j = w.b(jSONObject2, "reward_name_plural");
        this.k = w.b(jSONObject2, "reward_prompt");
        this.t = w.d(jSONObject, "rewarded");
        this.l = w.c(jSONObject, "status");
        this.m = w.c(jSONObject, "type");
        this.p = w.c(jSONObject, "play_interval");
        this.h = w.b(jSONObject, "zone_id");
        int n2 = this.l;
        int n3 = 1;
        if (n2 == n3) {
            n3 = 0;
        }
        this.s = n3;
    }

    int b() {
        return this.r;
    }

    void b(int n2) {
        this.l = n2;
    }

    public int getPlayFrequency() {
        return this.c(this.p);
    }

    public int getZoneType() {
        return this.m;
    }

    public boolean isRewarded() {
        return this.t;
    }
}

