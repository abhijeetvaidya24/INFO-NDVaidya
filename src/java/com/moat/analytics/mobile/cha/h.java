/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.Intent
 *  androidx.localbroadcastmanager.content.LocalBroadcastManager
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
package com.moat.analytics.mobile.cha;

import android.content.Context;
import android.content.Intent;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import com.moat.analytics.mobile.cha.a;
import com.moat.analytics.mobile.cha.d;
import com.moat.analytics.mobile.cha.j;
import com.moat.analytics.mobile.cha.o;
import com.moat.analytics.mobile.cha.t;
import java.util.Map;
import java.util.WeakHashMap;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

final class h {
    private static final h \u02ca = new h();
    private ScheduledFuture<?> \u02bd;
    private final Map<j, String> \u02cb = new WeakHashMap();
    private ScheduledFuture<?> \u02ce;
    private final ScheduledExecutorService \u02cf = Executors.newScheduledThreadPool((int)1);
    private final Map<d, String> \u0971 = new WeakHashMap();

    private h() {
    }

    static h \u02ca() {
        return \u02ca;
    }

    final void \u02ca(j j2) {
        if (j2 != null) {
            StringBuilder stringBuilder = new StringBuilder("removeSetupNeededBridge");
            stringBuilder.append(j2.hashCode());
            a.\u02cf(3, "JSUpdateLooper", this, stringBuilder.toString());
            this.\u02cb.remove((Object)j2);
        }
    }

    final void \u02cb(Context context, j j2) {
        if (j2 != null) {
            this.\u02cb.put((Object)j2, (Object)"");
            ScheduledFuture<?> scheduledFuture = this.\u02bd;
            if (scheduledFuture == null || scheduledFuture.isDone()) {
                a.\u02cf(3, "JSUpdateLooper", this, "Starting metadata reporting loop");
                Runnable runnable = new Runnable(this, context){
                    private /* synthetic */ Context \u02cb;
                    private /* synthetic */ h \u0971;
                    {
                        this.\u0971 = h2;
                        this.\u02cb = context;
                    }

                    public final void run() {
                        try {
                            Intent intent = new Intent("UPDATE_METADATA");
                            LocalBroadcastManager.getInstance((Context)this.\u02cb.getApplicationContext()).sendBroadcast(intent);
                            if (this.\u0971.\u02cb.isEmpty()) {
                                this.\u0971.\u02bd.cancel(true);
                            }
                            return;
                        }
                        catch (Exception exception) {
                            o.\u02ce(exception);
                            return;
                        }
                    }
                };
                this.\u02bd = this.\u02cf.scheduleWithFixedDelay(runnable, 0L, 50L, TimeUnit.MILLISECONDS);
            }
        }
    }

    final void \u0971(Context context, d d2) {
        if (d2 != null) {
            StringBuilder stringBuilder = new StringBuilder("addActiveTracker");
            stringBuilder.append(d2.hashCode());
            a.\u02cf(3, "JSUpdateLooper", this, stringBuilder.toString());
            if (!this.\u0971.containsKey((Object)d2)) {
                this.\u0971.put((Object)d2, (Object)"");
                ScheduledFuture<?> scheduledFuture = this.\u02ce;
                if (scheduledFuture == null || scheduledFuture.isDone()) {
                    a.\u02cf(3, "JSUpdateLooper", this, "Starting view update loop");
                    Runnable runnable = new Runnable(this, context){
                        private /* synthetic */ Context \u02cb;
                        private /* synthetic */ h \u02ce;
                        {
                            this.\u02ce = h2;
                            this.\u02cb = context;
                        }

                        public final void run() {
                            try {
                                Intent intent = new Intent("UPDATE_VIEW_INFO");
                                LocalBroadcastManager.getInstance((Context)this.\u02cb.getApplicationContext()).sendBroadcast(intent);
                                if (this.\u02ce.\u0971.isEmpty()) {
                                    a.\u02cf(3, "JSUpdateLooper", this.\u02ce, "No more active trackers");
                                    this.\u02ce.\u02ce.cancel(true);
                                }
                                return;
                            }
                            catch (Exception exception) {
                                o.\u02ce(exception);
                                return;
                            }
                        }
                    };
                    this.\u02ce = this.\u02cf.scheduleWithFixedDelay(runnable, 0L, (long)t.\u02cf().\u02ca, TimeUnit.MILLISECONDS);
                }
            }
        }
    }

    final void \u0971(d d2) {
        if (d2 != null) {
            StringBuilder stringBuilder = new StringBuilder("removeActiveTracker");
            stringBuilder.append(d2.hashCode());
            a.\u02cf(3, "JSUpdateLooper", this, stringBuilder.toString());
            this.\u0971.remove((Object)d2);
        }
    }

}

