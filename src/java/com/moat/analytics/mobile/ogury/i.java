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
package com.moat.analytics.mobile.ogury;

import android.app.Application;
import android.content.Context;
import com.moat.analytics.mobile.ogury.MoatAnalytics;
import com.moat.analytics.mobile.ogury.MoatOptions;
import com.moat.analytics.mobile.ogury.a;
import com.moat.analytics.mobile.ogury.d;
import com.moat.analytics.mobile.ogury.e;
import com.moat.analytics.mobile.ogury.l;
import com.moat.analytics.mobile.ogury.m;
import com.moat.analytics.mobile.ogury.q;
import com.moat.analytics.mobile.ogury.s;
import java.lang.ref.WeakReference;

final class i
extends MoatAnalytics
implements q.b {
    private MoatOptions \u02bb;
    private String \u02bc;
    d \u02ca;
    boolean \u02cb = false;
    boolean \u02ce = false;
    WeakReference<Context> \u02cf;
    boolean \u0971 = false;
    private boolean \u0971\u0971 = false;

    i() {
    }

    private void \u0971() {
        if (this.\u02ca == null) {
            this.\u02ca = new d((Context)a.\u02cf(), d.b.\u02cf);
            this.\u02ca.\u02cb(this.\u02bc);
            StringBuilder stringBuilder = new StringBuilder("Preparing native display tracking with partner code ");
            stringBuilder.append(this.\u02bc);
            e.1.\u02cb(3, "Analytics", this, stringBuilder.toString());
            StringBuilder stringBuilder2 = new StringBuilder("Prepared for native display tracking with partner code ");
            stringBuilder2.append(this.\u02bc);
            e.1.\u0971("[SUCCESS] ", stringBuilder2.toString());
        }
    }

    @Override
    public final void prepareNativeDisplayTracking(String string) {
        this.\u02bc = string;
        if (q.\u02ca().\u0971 == q.e.\u02ca) {
            return;
        }
        try {
            this.\u0971();
            return;
        }
        catch (Exception exception) {
            l.\u0971(exception);
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
            if (this.\u0971\u0971) {
                e.1.\u02cb(3, "Analytics", this, "Moat SDK has already been started.");
                return;
            }
            this.\u02bb = moatOptions;
            q.\u02ca().\u0971();
            this.\u02cb = moatOptions.disableLocationServices;
            if (application == null) throw new l("Moat Analytics SDK didn't start, application was null");
        }
        catch (Exception exception) {
            l.\u0971(exception);
            return;
        }
        if (moatOptions.loggingEnabled && s.\u0971(application.getApplicationContext())) {
            this.\u02ce = true;
        }
        this.\u02cf = new WeakReference((Object)application.getApplicationContext());
        this.\u0971\u0971 = true;
        this.\u0971 = moatOptions.autoTrackGMAInterstitials;
        a.\u02cb(application);
        q.\u02ca().\u02ca(this);
        if (!moatOptions.disableAdIdCollection) {
            s.\u02ce((Context)application);
        }
        e.1.\u0971("[SUCCESS] ", "Moat Analytics SDK Version 2.4.3 started");
    }

    @Override
    public final void \u02cb() throws l {
        l.\u02cb();
        m.\u02ce();
        if (this.\u02bc != null) {
            try {
                this.\u0971();
                return;
            }
            catch (Exception exception) {
                l.\u0971(exception);
            }
        }
    }

    final boolean \u02ce() {
        MoatOptions moatOptions = this.\u02bb;
        return moatOptions != null && moatOptions.disableLocationServices;
    }

    final boolean \u02cf() {
        return this.\u0971\u0971;
    }
}

