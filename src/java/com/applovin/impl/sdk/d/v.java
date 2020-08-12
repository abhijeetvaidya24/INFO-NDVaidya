/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.applovin.impl.a.a
 *  com.applovin.impl.sdk.d.h
 *  java.lang.Boolean
 *  java.lang.IllegalArgumentException
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.Throwable
 *  java.util.HashSet
 *  java.util.Iterator
 *  java.util.List
 *  java.util.Set
 *  org.json.JSONObject
 */
package com.applovin.impl.sdk.d;

import com.applovin.impl.a.a;
import com.applovin.impl.a.c;
import com.applovin.impl.a.d;
import com.applovin.impl.a.f;
import com.applovin.impl.a.g;
import com.applovin.impl.a.i;
import com.applovin.impl.sdk.b.b;
import com.applovin.impl.sdk.d.a;
import com.applovin.impl.sdk.d.h;
import com.applovin.impl.sdk.d.q;
import com.applovin.impl.sdk.e.n;
import com.applovin.impl.sdk.j;
import com.applovin.sdk.AppLovinAdLoadListener;
import com.applovin.sdk.AppLovinAdType;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.json.JSONObject;

class v
extends a {
    private c a;
    private final AppLovinAdLoadListener c;

    v(c c2, AppLovinAdLoadListener appLovinAdLoadListener, j j2) {
        super("TaskRenderVastAd", j2);
        if (c2 != null) {
            this.c = appLovinAdLoadListener;
            this.a = c2;
            return;
        }
        throw new IllegalArgumentException("No context specified.");
    }

    private void a(d d2, Throwable throwable) {
        this.a("Failed to render valid VAST ad", throwable);
        i.a(this.a, this.c, d2, -6, this.b);
    }

    @Override
    public com.applovin.impl.sdk.c.i a() {
        return com.applovin.impl.sdk.c.i.v;
    }

    /*
     * Enabled aggressive exception aggregation
     */
    public void run() {
        String string;
        this.a("Rendering VAST ad...");
        int n2 = this.a.b().size();
        HashSet hashSet = new HashSet(n2);
        HashSet hashSet2 = new HashSet(n2);
        Iterator iterator = this.a.b().iterator();
        String string2 = string = "";
        f f2 = null;
        com.applovin.impl.a.j j2 = null;
        com.applovin.impl.a.b b2 = null;
        while (iterator.hasNext()) {
            n n3;
            String string3 = i.a(n3 = (n)iterator.next()) ? "Wrapper" : "InLine";
            n n4 = n3.c(string3);
            if (n4 != null) {
                n n5 = n4.c("AdSystem");
                if (n5 != null) {
                    f2 = f.a(n5, f2, this.b);
                }
                string = i.a(n4, "AdTitle", string);
                string2 = i.a(n4, "Description", string2);
                i.a(n4.a("Impression"), (Set<g>)hashSet, this.a, this.b);
                i.a(n4.a("Error"), (Set<g>)hashSet2, this.a, this.b);
                n n6 = n4.b("Creatives");
                if (n6 == null) continue;
                for (n n7 : n6.d()) {
                    n n8 = n7.b("Linear");
                    if (n8 != null) {
                        j2 = com.applovin.impl.a.j.a(n8, j2, this.a, this.b);
                        continue;
                    }
                    n n9 = n7.c("CompanionAds");
                    if (n9 != null) {
                        n n10 = n9.c("Companion");
                        if (n10 == null) continue;
                        b2 = com.applovin.impl.a.b.a(n10, b2, this.a, this.b);
                        continue;
                    }
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("Received and will skip rendering for an unidentified creative: ");
                    stringBuilder.append((Object)n7);
                    this.d(stringBuilder.toString());
                }
                continue;
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Did not find wrapper or inline response for node: ");
            stringBuilder.append((Object)n3);
            this.d(stringBuilder.toString());
        }
        try {
            com.applovin.impl.a.a a2 = com.applovin.impl.a.a.ay().a(this.b).a(this.a.c()).b(this.a.d()).a(this.a.e()).a(this.a.f()).a(string).b(string2).a(f2).a(j2).a(b2).a((Set<g>)hashSet).b((Set<g>)hashSet2).a();
            d d2 = i.a(a2);
            if (d2 == null) {
                h h2 = new h(a2, this.b, this.c);
                q.a a3 = q.a.g;
                if (this.b.a(b.aX).booleanValue()) {
                    if (a2.getType() == AppLovinAdType.REGULAR) {
                        a3 = q.a.e;
                    } else if (a2.getType() == AppLovinAdType.INCENTIVIZED) {
                        a3 = q.a.f;
                    }
                }
                this.b.C().a((a)h2, a3);
                return;
            }
            this.a(d2, null);
            return;
        }
        catch (Throwable throwable) {
            this.a(d.c, throwable);
            this.b.E().a(this.a());
            return;
        }
    }
}

