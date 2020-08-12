/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.app.Application
 *  com.moat.analytics.mobile.ogury.NoOp$MoatAnalytics
 *  com.moat.analytics.mobile.ogury.i
 *  java.lang.Class
 *  java.lang.Exception
 *  java.lang.Object
 *  java.lang.String
 */
package com.moat.analytics.mobile.ogury;

import android.app.Application;
import com.moat.analytics.mobile.ogury.MoatOptions;
import com.moat.analytics.mobile.ogury.NoOp;
import com.moat.analytics.mobile.ogury.i;
import com.moat.analytics.mobile.ogury.l;

public abstract class MoatAnalytics {
    private static MoatAnalytics \u0971;

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static MoatAnalytics getInstance() {
        Class<MoatAnalytics> class_ = MoatAnalytics.class;
        synchronized (MoatAnalytics.class) {
            MoatAnalytics moatAnalytics = \u0971;
            if (moatAnalytics != null) return \u0971;
            try {
                \u0971 = new i();
                return \u0971;
            }
            catch (Exception exception) {
                l.\u0971(exception);
                \u0971 = new NoOp.MoatAnalytics();
            }
            return \u0971;
        }
    }

    public abstract void prepareNativeDisplayTracking(String var1);

    public abstract void start(Application var1);

    public abstract void start(MoatOptions var1, Application var2);
}

