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
package com.moat.analytics.mobile.iro;

import android.content.Context;
import android.content.Intent;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import com.moat.analytics.mobile.iro.b;
import com.moat.analytics.mobile.iro.c;
import com.moat.analytics.mobile.iro.f;
import com.moat.analytics.mobile.iro.h;
import com.moat.analytics.mobile.iro.o;
import com.moat.analytics.mobile.iro.t;
import java.util.Map;
import java.util.WeakHashMap;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

final class h {
    private static final h \u02ce = new h();
    private ScheduledFuture<?> \u02bd;
    private final ScheduledExecutorService \u02ca = Executors.newScheduledThreadPool((int)1);
    private final Map<f, String> \u02cb = new WeakHashMap();
    private ScheduledFuture<?> \u02cf;
    private final Map<c, String> \u0971 = new WeakHashMap();

    private h() {
    }

    static h \u02cb() {
        return \u02ce;
    }

    static /* synthetic */ ScheduledFuture \u02ce(h h2) {
        return h2.\u02bd;
    }

    static /* synthetic */ WeakHashMap \u0971(h h2) {
        return h2.\u02cb;
    }

    final void \u02cb(Context context, c c2) {
        if (c2 != null) {
            StringBuilder stringBuilder = new StringBuilder("addActiveTracker");
            stringBuilder.append(c2.hashCode());
            b.\u02cf(3, "JSUpdateLooper", this, stringBuilder.toString());
            if (!this.\u0971.containsKey((Object)c2)) {
                this.\u0971.put((Object)c2, (Object)"");
                ScheduledFuture<?> scheduledFuture = this.\u02cf;
                if (scheduledFuture == null || scheduledFuture.isDone()) {
                    b.\u02cf(3, "JSUpdateLooper", this, "Starting view update loop");
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
                                    b.\u02cf(3, "JSUpdateLooper", this.\u02ce, "No more active trackers");
                                    this.\u02ce.\u02cf.cancel(true);
                                }
                                return;
                            }
                            catch (Exception exception) {
                                o.\u0971(exception);
                                return;
                            }
                        }
                    };
                    this.\u02cf = this.\u02ca.scheduleWithFixedDelay(runnable, 0L, (long)t.\u02cb().\u0971, TimeUnit.MILLISECONDS);
                }
            }
        }
    }

    final void \u02ce(Context context, f f2) {
        if (f2 != null) {
            this.\u02cb.put((Object)f2, (Object)"");
            ScheduledFuture<?> scheduledFuture = this.\u02bd;
            if (scheduledFuture == null || scheduledFuture.isDone()) {
                b.\u02cf(3, "JSUpdateLooper", this, "Starting metadata reporting loop");
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
                            if (h.\u0971(this.\u0971).isEmpty()) {
                                h.\u02ce(this.\u0971).cancel(true);
                            }
                            return;
                        }
                        catch (Exception exception) {
                            o.\u0971(exception);
                            return;
                        }
                    }
                };
                this.\u02bd = this.\u02ca.scheduleWithFixedDelay(runnable, 0L, 50L, TimeUnit.MILLISECONDS);
            }
        }
    }

    final void \u02ce(f f2) {
        if (f2 != null) {
            StringBuilder stringBuilder = new StringBuilder("removeSetupNeededBridge");
            stringBuilder.append(f2.hashCode());
            b.\u02cf(3, "JSUpdateLooper", this, stringBuilder.toString());
            this.\u02cb.remove((Object)f2);
        }
    }

    final void \u0971(c c2) {
        if (c2 != null) {
            StringBuilder stringBuilder = new StringBuilder("removeActiveTracker");
            stringBuilder.append(c2.hashCode());
            b.\u02cf(3, "JSUpdateLooper", this, stringBuilder.toString());
            this.\u0971.remove((Object)c2);
        }
    }

}

