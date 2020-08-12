/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.applovin.impl.sdk.d.y$1
 *  java.lang.Integer
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.Throwable
 */
package com.applovin.impl.sdk.d;

import com.applovin.impl.a.c;
import com.applovin.impl.a.i;
import com.applovin.impl.sdk.ad.d;
import com.applovin.impl.sdk.b.b;
import com.applovin.impl.sdk.d.a;
import com.applovin.impl.sdk.d.q;
import com.applovin.impl.sdk.d.y;
import com.applovin.impl.sdk.e.m;
import com.applovin.impl.sdk.e.n;
import com.applovin.impl.sdk.j;
import com.applovin.impl.sdk.network.b;
import com.applovin.sdk.AppLovinAdLoadListener;

class y
extends a {
    private c a;
    private final AppLovinAdLoadListener c;

    y(c c2, AppLovinAdLoadListener appLovinAdLoadListener, j j2) {
        super("TaskResolveVastWrapper", j2);
        this.c = appLovinAdLoadListener;
        this.a = c2;
    }

    static /* synthetic */ c a(y y2) {
        return y2.a;
    }

    private void a(int n2) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Failed to resolve VAST wrapper due to error code ");
        stringBuilder.append(n2);
        this.d(stringBuilder.toString());
        if (n2 == -103) {
            m.a(this.c, this.a.g(), n2, this.b);
            return;
        }
        com.applovin.impl.a.d d2 = n2 == -102 ? com.applovin.impl.a.d.d : com.applovin.impl.a.d.c;
        i.a(this.a, this.c, d2, n2, this.b);
    }

    static /* synthetic */ void a(y y2, int n2) {
        y2.a(n2);
    }

    static /* synthetic */ AppLovinAdLoadListener b(y y2) {
        return y2.c;
    }

    @Override
    public com.applovin.impl.sdk.c.i a() {
        return com.applovin.impl.sdk.c.i.x;
    }

    public void run() {
        String string = i.a(this.a);
        if (com.applovin.impl.sdk.e.j.b(string)) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Resolving VAST ad with depth ");
            stringBuilder.append(this.a.a());
            stringBuilder.append(" at ");
            stringBuilder.append(string);
            this.a(stringBuilder.toString());
            try {
                1 var7_3 = new 1(this, com.applovin.impl.sdk.network.b.a(this.b).a(string).b("GET").a(n.a).a((n)this.b.a(b.eU)).b(this.b.a(b.eV)).a(false).a(), this.b);
                this.b.C().a((a)var7_3);
                return;
            }
            catch (Throwable throwable) {
                this.a("Unable to resolve VAST wrapper", throwable);
                this.a(-1);
                this.b.E().a(this.a());
                return;
            }
        }
        this.d("Resolving VAST failed. Could not find resolution URL");
        this.a(-1);
    }
}

