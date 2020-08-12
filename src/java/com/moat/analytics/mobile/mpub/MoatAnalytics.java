/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.app.Application
 *  com.moat.analytics.mobile.mpub.k
 *  com.moat.analytics.mobile.mpub.v$a
 *  java.lang.Class
 *  java.lang.Exception
 *  java.lang.Object
 *  java.lang.String
 */
package com.moat.analytics.mobile.mpub;

import android.app.Application;
import com.moat.analytics.mobile.mpub.MoatOptions;
import com.moat.analytics.mobile.mpub.k;
import com.moat.analytics.mobile.mpub.m;
import com.moat.analytics.mobile.mpub.v;

public abstract class MoatAnalytics {
    private static MoatAnalytics a;

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static MoatAnalytics getInstance() {
        Class<MoatAnalytics> class_ = MoatAnalytics.class;
        synchronized (MoatAnalytics.class) {
            MoatAnalytics moatAnalytics = a;
            if (moatAnalytics != null) return a;
            try {
                a = new k();
                return a;
            }
            catch (Exception exception) {
                m.a(exception);
                a = new v.a();
            }
            return a;
        }
    }

    public abstract void prepareNativeDisplayTracking(String var1);

    public abstract void start(Application var1);

    public abstract void start(MoatOptions var1, Application var2);
}

