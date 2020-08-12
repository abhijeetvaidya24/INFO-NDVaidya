/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.content.Context
 *  com.applovin.impl.sdk.d
 *  com.applovin.impl.sdk.q
 *  java.lang.Boolean
 *  java.lang.Long
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.System
 *  java.lang.Throwable
 *  java.util.Iterator
 *  java.util.LinkedHashSet
 */
package com.applovin.impl.sdk.d;

import android.app.Activity;
import android.content.Context;
import com.applovin.impl.mediation.MediationServiceImpl;
import com.applovin.impl.sdk.AppLovinAdServiceImpl;
import com.applovin.impl.sdk.NativeAdServiceImpl;
import com.applovin.impl.sdk.ad.e;
import com.applovin.impl.sdk.c.c;
import com.applovin.impl.sdk.c.g;
import com.applovin.impl.sdk.c.h;
import com.applovin.impl.sdk.c.i;
import com.applovin.impl.sdk.d;
import com.applovin.impl.sdk.d.a;
import com.applovin.impl.sdk.d.b;
import com.applovin.impl.sdk.d.q;
import com.applovin.impl.sdk.j;
import com.applovin.impl.sdk.k;
import com.applovin.impl.sdk.n;
import com.applovin.impl.sdk.q;
import com.applovin.sdk.AppLovinAdSize;
import com.applovin.sdk.AppLovinAdType;
import com.applovin.sdk.AppLovinEventService;
import java.util.Iterator;
import java.util.LinkedHashSet;

public class p
extends a {
    private final j a;

    public p(j j2) {
        super("TaskInitializeSdk", j2);
        this.a = j2;
    }

    private void a(com.applovin.impl.sdk.b.b<Boolean> b2) {
        if (this.a.a(b2).booleanValue()) {
            com.applovin.impl.sdk.ad.d d2 = com.applovin.impl.sdk.ad.d.a(AppLovinAdSize.INTERSTITIAL, AppLovinAdType.INCENTIVIZED, this.a);
            this.a.L().f(d2);
        }
    }

    private boolean f() {
        if (!k.a("android.permission.INTERNET", this.d())) {
            this.b().u().e(this.c(), "Unable to enable AppLovin SDK: no android.permission.INTERNET");
            return false;
        }
        return true;
    }

    private void g() {
        b b2 = new b(this.a);
        if (this.a.a(com.applovin.impl.sdk.b.b.dU).booleanValue()) {
            this.a.C().a(b2);
            return;
        }
        this.a.C().a(b2, q.a.a);
    }

    private void h() {
        this.a.L().a();
        this.a.M().a();
    }

    private void i() {
        this.j();
        this.k();
        this.l();
    }

    private void j() {
        LinkedHashSet<com.applovin.impl.sdk.ad.d> linkedHashSet = this.a.O().b();
        if (!linkedHashSet.isEmpty()) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Scheduling preload(s) for ");
            stringBuilder.append(linkedHashSet.size());
            stringBuilder.append(" zone(s)");
            this.a(stringBuilder.toString());
            for (com.applovin.impl.sdk.ad.d d2 : linkedHashSet) {
                if (d2.d()) {
                    this.a.o().preloadAds(d2);
                    continue;
                }
                this.a.n().preloadAds(d2);
            }
        }
    }

    private void k() {
        com.applovin.impl.sdk.b.b<Boolean> b2 = com.applovin.impl.sdk.b.b.aP;
        String string = this.a.a(com.applovin.impl.sdk.b.b.aO);
        int n2 = string.length();
        boolean bl = false;
        if (n2 > 0) {
            Iterator iterator = com.applovin.impl.sdk.e.d.a(string).iterator();
            while (iterator.hasNext()) {
                AppLovinAdSize appLovinAdSize = AppLovinAdSize.fromString((String)iterator.next());
                if (appLovinAdSize == null) continue;
                com.applovin.impl.sdk.ad.d d2 = com.applovin.impl.sdk.ad.d.a(appLovinAdSize, AppLovinAdType.REGULAR, this.a);
                this.a.L().f(d2);
                if (!AppLovinAdSize.INTERSTITIAL.getLabel().equals((Object)appLovinAdSize.getLabel())) continue;
                this.a(b2);
                bl = true;
            }
        }
        if (!bl) {
            this.a(b2);
        }
    }

    private void l() {
        if (this.a.a(com.applovin.impl.sdk.b.b.aQ).booleanValue()) {
            this.a.M().f(com.applovin.impl.sdk.ad.d.h(this.a));
        }
    }

    @Override
    public i a() {
        return i.a;
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    public void run() {
        block12 : {
            var1_1 = "succeeded";
            var2_2 = System.currentTimeMillis();
            this.a("Initializing AppLovin SDK 9.2.1...");
            if (this.f()) {
                this.a.D().d();
                this.a.D().c(g.b);
                this.a.N().c(this.d());
                this.a.N().b(this.d());
                this.h();
                this.i();
                if (this.a.y() != null) {
                    var26_3 = this.a.y();
                    this.a.a(var26_3).maybeInitialize(var26_3);
                }
                this.a.P().a();
                this.a.h();
                this.g();
                this.a.G().e();
                this.a.a(true);
                this.a.F().a();
                this.a.p().trackEvent("landing");
                break block12;
            }
            this.a.a(false);
            this.b().u().e(this.c(), "Couldn't initialize the AppLovin SDK due to missing INTERNET permission");
        }
        this.a.e();
        if (this.a.a(com.applovin.impl.sdk.b.b.ao).booleanValue()) {
            var23_4 = this.a.a(com.applovin.impl.sdk.b.b.ap);
            this.a.a(var23_4);
        }
        var5_5 = new StringBuilder();
        var5_5.append("AppLovin SDK 9.2.1 initialization ");
        if (this.a.d()) ** GOTO lbl35
        do {
            var1_1 = "failed";
lbl35: // 3 sources:
            do {
                var5_5.append(var1_1);
                var5_5.append(" in ");
                var5_5.append(System.currentTimeMillis() - var2_2);
                var5_5.append("ms");
                this.a(var5_5.toString());
                return;
                break;
            } while (true);
            break;
        } while (true);
        {
            catch (Throwable var13_6) {
            }
            catch (Throwable var4_7) {}
            {
                this.a("Unable to initialize SDK.", var4_7);
                this.a.a(false);
                this.a.E().a(this.a());
            }
            this.a.e();
            if (this.a.a(com.applovin.impl.sdk.b.b.ao).booleanValue()) {
                var11_8 = this.a.a(com.applovin.impl.sdk.b.b.ap);
                this.a.a(var11_8);
            }
            var5_5 = new StringBuilder();
            var5_5.append("AppLovin SDK 9.2.1 initialization ");
            if (!this.a.d()) ** continue;
            ** continue;
        }
        this.a.e();
        if (this.a.a(com.applovin.impl.sdk.b.b.ao).booleanValue()) {
            var20_9 = this.a.a(com.applovin.impl.sdk.b.b.ap);
            this.a.a(var20_9);
        }
        var14_10 = new StringBuilder();
        var14_10.append("AppLovin SDK 9.2.1 initialization ");
        if (!this.a.d()) {
            var1_1 = "failed";
        }
        var14_10.append(var1_1);
        var14_10.append(" in ");
        var14_10.append(System.currentTimeMillis() - var2_2);
        var14_10.append("ms");
        this.a(var14_10.toString());
        throw var13_6;
    }
}

