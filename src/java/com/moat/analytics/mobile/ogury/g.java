/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.Intent
 *  androidx.localbroadcastmanager.content.LocalBroadcastManager
 *  com.moat.analytics.mobile.ogury.e
 *  java.lang.Exception
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.util.Map
 *  java.util.WeakHashMap
 *  java.util.concurrent.Executors
 *  java.util.concurrent.ScheduledExecutorService
 *  java.util.concurrent.ScheduledFuture
 *  java.util.concurrent.TimeUnit
 */
package com.moat.analytics.mobile.ogury;

import android.content.Context;
import android.content.Intent;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import com.moat.analytics.mobile.ogury.c;
import com.moat.analytics.mobile.ogury.e;
import com.moat.analytics.mobile.ogury.f;
import com.moat.analytics.mobile.ogury.l;
import com.moat.analytics.mobile.ogury.q;
import java.util.Map;
import java.util.WeakHashMap;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

final class g {
    private static final g \u02cb = new g();
    private final ScheduledExecutorService \u02ca = Executors.newScheduledThreadPool((int)1);
    private final Map<f, String> \u02ce = new WeakHashMap();
    private final Map<c, String> \u02cf = new WeakHashMap();
    private ScheduledFuture<?> \u0971;
    private ScheduledFuture<?> \u141d;

    private g() {
    }

    static g \u02cb() {
        return \u02cb;
    }

    final void \u02ca(f f2) {
        StringBuilder stringBuilder = new StringBuilder("removeSetupNeededBridge");
        stringBuilder.append(f2.hashCode());
        e.1.\u02cb(3, "JSUpdateLooper", this, stringBuilder.toString());
        this.\u02ce.remove((Object)f2);
    }

    final void \u02cb(Context context, c c2) {
        if (c2 != null) {
            StringBuilder stringBuilder = new StringBuilder("addActiveTracker");
            stringBuilder.append(c2.hashCode());
            e.1.\u02cb(3, "JSUpdateLooper", this, stringBuilder.toString());
            if (!this.\u02cf.containsKey((Object)c2)) {
                this.\u02cf.put((Object)c2, (Object)"");
                ScheduledFuture<?> scheduledFuture = this.\u0971;
                if (scheduledFuture == null || scheduledFuture.isDone()) {
                    e.1.\u02cb(3, "JSUpdateLooper", this, "Starting view update loop");
                    Runnable runnable = new Runnable(this, context){
                        private /* synthetic */ Context \u02ce;
                        private /* synthetic */ g \u02cf;
                        {
                            this.\u02cf = g2;
                            this.\u02ce = context;
                        }

                        public final void run() {
                            try {
                                Intent intent = new Intent("UPDATE_VIEW_INFO");
                                LocalBroadcastManager.getInstance((Context)this.\u02ce.getApplicationContext()).sendBroadcast(intent);
                                if (this.\u02cf.\u02cf.isEmpty()) {
                                    e.1.\u02cb(3, "JSUpdateLooper", this.\u02cf, "No more active trackers");
                                    this.\u02cf.\u0971.cancel(true);
                                }
                                return;
                            }
                            catch (Exception exception) {
                                l.\u0971(exception);
                                return;
                            }
                        }
                    };
                    this.\u0971 = this.\u02ca.scheduleWithFixedDelay(runnable, 0L, (long)q.\u02ca().\u02cb, TimeUnit.MILLISECONDS);
                }
            }
        }
    }

    final void \u02cb(Context context, f f2) {
        this.\u02ce.put((Object)f2, (Object)"");
        ScheduledFuture<?> scheduledFuture = this.\u141d;
        if (scheduledFuture == null || scheduledFuture.isDone()) {
            e.1.\u02cb(3, "JSUpdateLooper", this, "Starting metadata reporting loop");
            Runnable runnable = new Runnable(this, context){
                private /* synthetic */ Context \u02cb;
                private /* synthetic */ g \u02cf;
                {
                    this.\u02cf = g2;
                    this.\u02cb = context;
                }

                public final void run() {
                    try {
                        Intent intent = new Intent("UPDATE_METADATA");
                        LocalBroadcastManager.getInstance((Context)this.\u02cb.getApplicationContext()).sendBroadcast(intent);
                        if (this.\u02cf.\u02ce.isEmpty()) {
                            this.\u02cf.\u141d.cancel(true);
                        }
                        return;
                    }
                    catch (Exception exception) {
                        l.\u0971(exception);
                        return;
                    }
                }
            };
            this.\u141d = this.\u02ca.scheduleWithFixedDelay(runnable, 0L, 50L, TimeUnit.MILLISECONDS);
        }
    }

    final void \u02ce(c c2) {
        if (c2 != null) {
            StringBuilder stringBuilder = new StringBuilder("removeActiveTracker");
            stringBuilder.append(c2.hashCode());
            e.1.\u02cb(3, "JSUpdateLooper", this, stringBuilder.toString());
            this.\u02cf.remove((Object)c2);
        }
    }

}

