/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.app.Application
 *  com.moat.analytics.mobile.iro.NoOp$MoatAnalytics
 *  com.moat.analytics.mobile.iro.j
 *  com.moat.analytics.mobile.iro.o
 *  java.lang.Class
 *  java.lang.Exception
 *  java.lang.Object
 *  java.lang.String
 */
package com.moat.analytics.mobile.iro;

import android.app.Application;
import com.moat.analytics.mobile.iro.MoatOptions;
import com.moat.analytics.mobile.iro.NoOp;
import com.moat.analytics.mobile.iro.j;
import com.moat.analytics.mobile.iro.o;

public abstract class MoatAnalytics {
    private static MoatAnalytics \u02ce;

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static MoatAnalytics getInstance() {
        Class<MoatAnalytics> class_ = MoatAnalytics.class;
        synchronized (MoatAnalytics.class) {
            MoatAnalytics moatAnalytics = \u02ce;
            if (moatAnalytics != null) return \u02ce;
            try {
                \u02ce = new j();
                return \u02ce;
            }
            catch (Exception exception) {
                o.\u0971((Exception)exception);
                \u02ce = new NoOp.MoatAnalytics();
            }
            return \u02ce;
        }
    }

    public abstract void prepareNativeDisplayTracking(String var1);

    public abstract void start(Application var1);

    public abstract void start(MoatOptions var1, Application var2);
}

