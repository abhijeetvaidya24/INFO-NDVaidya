/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.app.Application
 *  com.moat.analytics.mobile.cha.NoOp$MoatAnalytics
 *  com.moat.analytics.mobile.cha.f
 *  java.lang.Class
 *  java.lang.Exception
 *  java.lang.Object
 *  java.lang.String
 */
package com.moat.analytics.mobile.cha;

import android.app.Application;
import com.moat.analytics.mobile.cha.MoatOptions;
import com.moat.analytics.mobile.cha.NoOp;
import com.moat.analytics.mobile.cha.f;
import com.moat.analytics.mobile.cha.o;

public abstract class MoatAnalytics {
    private static MoatAnalytics \u02cf;

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static MoatAnalytics getInstance() {
        Class<MoatAnalytics> class_ = MoatAnalytics.class;
        synchronized (MoatAnalytics.class) {
            MoatAnalytics moatAnalytics = \u02cf;
            if (moatAnalytics != null) return \u02cf;
            try {
                \u02cf = new f();
                return \u02cf;
            }
            catch (Exception exception) {
                o.\u02ce(exception);
                \u02cf = new NoOp.MoatAnalytics();
            }
            return \u02cf;
        }
    }

    public abstract void prepareNativeDisplayTracking(String var1);

    public abstract void start(Application var1);

    public abstract void start(MoatOptions var1, Application var2);
}

