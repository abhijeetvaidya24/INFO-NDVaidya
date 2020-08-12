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
package com.moat.analytics.mobile.cha;

import android.app.Application;
import android.content.Context;
import com.moat.analytics.mobile.cha.MoatAnalytics;
import com.moat.analytics.mobile.cha.MoatOptions;
import com.moat.analytics.mobile.cha.a;
import com.moat.analytics.mobile.cha.c;
import com.moat.analytics.mobile.cha.n;
import com.moat.analytics.mobile.cha.o;
import com.moat.analytics.mobile.cha.r;
import com.moat.analytics.mobile.cha.t;
import java.lang.ref.WeakReference;

final class f
extends MoatAnalytics
implements t.b {
    private boolean \u02bb = false;
    private String \u02bc;
    private MoatOptions \u02bd;
    WeakReference<Context> \u02ca;
    boolean \u02cb = false;
    boolean \u02ce = false;
    boolean \u02cf = false;
    a \u0971;

    f() {
    }

    private void \u02cf() {
        if (this.\u0971 == null) {
            this.\u0971 = new a(c.\u02cf(), a.d.\u02cf);
            this.\u0971.\u02ca(this.\u02bc);
            StringBuilder stringBuilder = new StringBuilder("Preparing native display tracking with partner code ");
            stringBuilder.append(this.\u02bc);
            a.\u02cf(3, "Analytics", this, stringBuilder.toString());
            StringBuilder stringBuilder2 = new StringBuilder("Prepared for native display tracking with partner code ");
            stringBuilder2.append(this.\u02bc);
            a.\u02ca("[SUCCESS] ", stringBuilder2.toString());
        }
    }

    @Override
    public final void prepareNativeDisplayTracking(String string) {
        this.\u02bc = string;
        if (t.\u02cf().\u02ce == t.a.\u0971) {
            return;
        }
        try {
            this.\u02cf();
            return;
        }
        catch (Exception exception) {
            o.\u02ce(exception);
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
            if (this.\u02bb) {
                a.\u02cf(3, "Analytics", this, "Moat SDK has already been started.");
                return;
            }
            this.\u02bd = moatOptions;
            t.\u02cf().\u02ce();
            this.\u02cb = moatOptions.disableLocationServices;
            if (application == null) throw new o("Moat Analytics SDK didn't start, application was null");
        }
        catch (Exception exception) {
            o.\u02ce(exception);
            return;
        }
        if (moatOptions.loggingEnabled && r.\u02cb(application.getApplicationContext())) {
            this.\u02ce = true;
        }
        this.\u02ca = new WeakReference((Object)application.getApplicationContext());
        this.\u02bb = true;
        this.\u02cf = moatOptions.autoTrackGMAInterstitials;
        c.\u0971(application);
        t.\u02cf().\u02ca(this);
        if (!moatOptions.disableAdIdCollection) {
            r.\u02ce(application);
        }
        a.\u02ca("[SUCCESS] ", "Moat Analytics SDK Version 2.4.1 started");
    }

    final boolean \u02ca() {
        return this.\u02bb;
    }

    final boolean \u02cb() {
        MoatOptions moatOptions = this.\u02bd;
        return moatOptions != null && moatOptions.disableLocationServices;
    }

    @Override
    public final void \u02ce() throws o {
        o.\u0971();
        n.\u02cf();
        if (this.\u02bc != null) {
            try {
                this.\u02cf();
                return;
            }
            catch (Exception exception) {
                o.\u02ce(exception);
            }
        }
    }
}

