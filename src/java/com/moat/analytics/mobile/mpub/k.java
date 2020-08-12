/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.app.Application
 *  android.content.Context
 *  java.lang.Exception
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.ref.WeakReference
 */
package com.moat.analytics.mobile.mpub;

import android.app.Application;
import android.content.Context;
import com.moat.analytics.mobile.mpub.MoatAnalytics;
import com.moat.analytics.mobile.mpub.MoatOptions;
import com.moat.analytics.mobile.mpub.a;
import com.moat.analytics.mobile.mpub.g;
import com.moat.analytics.mobile.mpub.m;
import com.moat.analytics.mobile.mpub.o;
import com.moat.analytics.mobile.mpub.p;
import com.moat.analytics.mobile.mpub.s;
import com.moat.analytics.mobile.mpub.w;
import java.lang.ref.WeakReference;

class k
extends MoatAnalytics
implements w.b {
    boolean a = false;
    boolean b = false;
    boolean c = false;
    g d;
    WeakReference<Context> e;
    private boolean f = false;
    private String g;
    private MoatOptions h;

    k() {
    }

    private void a(MoatOptions moatOptions, Application application) {
        if (this.f) {
            p.a(3, "Analytics", this, "Moat SDK has already been started.");
            return;
        }
        this.h = moatOptions;
        w.a().b();
        this.c = moatOptions.disableLocationServices;
        if (application != null) {
            if (moatOptions.loggingEnabled && s.b(application.getApplicationContext())) {
                this.a = true;
            }
            this.e = new WeakReference((Object)application.getApplicationContext());
            this.f = true;
            this.b = moatOptions.autoTrackGMAInterstitials;
            a.a(application);
            w.a().a(this);
            if (!moatOptions.disableAdIdCollection) {
                s.a((Context)application);
            }
            p.a("[SUCCESS] ", "Moat Analytics SDK Version 2.4.5 started");
            return;
        }
        throw new m("Moat Analytics SDK didn't start, application was null");
    }

    private void e() {
        if (this.d == null) {
            this.d = new g((Context)a.a(), g.a.a);
            this.d.a(this.g);
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Preparing native display tracking with partner code ");
            stringBuilder.append(this.g);
            p.a(3, "Analytics", this, stringBuilder.toString());
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append("Prepared for native display tracking with partner code ");
            stringBuilder2.append(this.g);
            p.a("[SUCCESS] ", stringBuilder2.toString());
        }
    }

    boolean a() {
        return this.f;
    }

    boolean b() {
        MoatOptions moatOptions = this.h;
        return moatOptions != null && moatOptions.disableLocationServices;
    }

    @Override
    public void c() {
        m.a();
        o.a();
        if (this.g != null) {
            try {
                this.e();
                return;
            }
            catch (Exception exception) {
                m.a(exception);
            }
        }
    }

    @Override
    public void d() {
    }

    @Override
    public void prepareNativeDisplayTracking(String string) {
        this.g = string;
        if (w.a().a == w.d.a) {
            return;
        }
        try {
            this.e();
            return;
        }
        catch (Exception exception) {
            m.a(exception);
            return;
        }
    }

    @Override
    public void start(Application application) {
        this.start(new MoatOptions(), application);
    }

    @Override
    public void start(MoatOptions moatOptions, Application application) {
        try {
            this.a(moatOptions, application);
            return;
        }
        catch (Exception exception) {
            m.a(exception);
            return;
        }
    }
}

