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
package com.moat.analytics.mobile.iro;

import android.app.Application;
import android.content.Context;
import com.moat.analytics.mobile.iro.MoatAnalytics;
import com.moat.analytics.mobile.iro.MoatOptions;
import com.moat.analytics.mobile.iro.a;
import com.moat.analytics.mobile.iro.b;
import com.moat.analytics.mobile.iro.k;
import com.moat.analytics.mobile.iro.o;
import com.moat.analytics.mobile.iro.p;
import com.moat.analytics.mobile.iro.t;
import java.lang.ref.WeakReference;

final class j
extends MoatAnalytics
implements t.a {
    private String \u02bc;
    b \u02ca;
    private MoatOptions \u02ca\u0971;
    WeakReference<Context> \u02cb;
    boolean \u02ce = false;
    boolean \u02cf = false;
    boolean \u0971 = false;
    private boolean \u141d = false;

    j() {
    }

    private void \u02cb() {
        if (this.\u02ca == null) {
            this.\u02ca = new b(a.\u02ce(), b.a.\u02cf);
            this.\u02ca.\u02cb(this.\u02bc);
            StringBuilder stringBuilder = new StringBuilder("Preparing native display tracking with partner code ");
            stringBuilder.append(this.\u02bc);
            b.\u02cf(3, "Analytics", this, stringBuilder.toString());
            StringBuilder stringBuilder2 = new StringBuilder("Prepared for native display tracking with partner code ");
            stringBuilder2.append(this.\u02bc);
            b.\u02ce("[SUCCESS] ", stringBuilder2.toString());
        }
    }

    @Override
    public final void prepareNativeDisplayTracking(String string) {
        this.\u02bc = string;
        if (t.\u02cb().\u02cb == t.c.\u02ca) {
            return;
        }
        try {
            this.\u02cb();
            return;
        }
        catch (Exception exception) {
            o.\u0971(exception);
            return;
        }
    }

    @Override
    public final void start(Application application) {
        this.start(new MoatOptions(), application);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    @Override
    public final void start(MoatOptions moatOptions, Application application) {
        try {
            if (this.\u141d) {
                b.\u02cf(3, "Analytics", this, "Moat SDK has already been started.");
                return;
            }
            this.\u02ca\u0971 = moatOptions;
            t.\u02cb().\u02cf();
            this.\u02cf = moatOptions.disableLocationServices;
            if (application == null) throw new o("Moat Analytics SDK didn't start, application was null");
        }
        catch (Exception exception) {
            o.\u0971(exception);
            return;
        }
        if (moatOptions.loggingEnabled && p.\u02ce(application.getApplicationContext())) {
            this.\u0971 = true;
        }
        this.\u02cb = new WeakReference((Object)application.getApplicationContext());
        this.\u141d = true;
        this.\u02ce = moatOptions.autoTrackGMAInterstitials;
        a.\u02ca(application);
        t.\u02cb().\u0971(this);
        if (!moatOptions.disableAdIdCollection) {
            p.\u02ca(application);
        }
        b.\u02ce("[SUCCESS] ", "Moat Analytics SDK Version 2.4.0 started");
    }

    final boolean \u02ca() {
        return this.\u141d;
    }

    final boolean \u02cf() {
        MoatOptions moatOptions = this.\u02ca\u0971;
        return moatOptions != null && moatOptions.disableLocationServices;
    }

    @Override
    public final void \u0971() throws o {
        o.\u02ca();
        k.\u02ce();
        if (this.\u02bc != null) {
            try {
                this.\u02cb();
                return;
            }
            catch (Exception exception) {
                o.\u0971(exception);
            }
        }
    }
}

