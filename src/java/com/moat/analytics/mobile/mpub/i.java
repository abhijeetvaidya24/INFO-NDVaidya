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
package com.moat.analytics.mobile.mpub;

import android.content.Context;
import android.content.Intent;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import com.moat.analytics.mobile.mpub.b;
import com.moat.analytics.mobile.mpub.j;
import com.moat.analytics.mobile.mpub.m;
import com.moat.analytics.mobile.mpub.p;
import com.moat.analytics.mobile.mpub.w;
import java.util.Map;
import java.util.WeakHashMap;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

class i {
    private static final i a = new i();
    private final Map<j, String> b = new WeakHashMap();
    private final Map<b, String> c = new WeakHashMap();
    private final ScheduledExecutorService d = Executors.newScheduledThreadPool((int)1);
    private ScheduledFuture<?> e;
    private ScheduledFuture<?> f;

    private i() {
    }

    static i a() {
        return a;
    }

    private void a(final Context context) {
        ScheduledFuture<?> scheduledFuture = this.f;
        if (scheduledFuture == null || scheduledFuture.isDone()) {
            p.a(3, "JSUpdateLooper", this, "Starting metadata reporting loop");
            Runnable runnable = new Runnable(){

                public void run() {
                    try {
                        Intent intent = new Intent("UPDATE_METADATA");
                        LocalBroadcastManager.getInstance((Context)context.getApplicationContext()).sendBroadcast(intent);
                        if (i.this.b.isEmpty()) {
                            i.this.f.cancel(true);
                            return;
                        }
                    }
                    catch (Exception exception) {
                        m.a(exception);
                    }
                }
            };
            this.f = this.d.scheduleWithFixedDelay(runnable, 0L, 50L, TimeUnit.MILLISECONDS);
        }
    }

    private void b(final Context context) {
        ScheduledFuture<?> scheduledFuture = this.e;
        if (scheduledFuture == null || scheduledFuture.isDone()) {
            p.a(3, "JSUpdateLooper", this, "Starting view update loop");
            Runnable runnable = new Runnable(){

                public void run() {
                    try {
                        Intent intent = new Intent("UPDATE_VIEW_INFO");
                        LocalBroadcastManager.getInstance((Context)context.getApplicationContext()).sendBroadcast(intent);
                        if (i.this.c.isEmpty()) {
                            p.a(3, "JSUpdateLooper", i.this, "No more active trackers");
                            i.this.e.cancel(true);
                            return;
                        }
                    }
                    catch (Exception exception) {
                        m.a(exception);
                    }
                }
            };
            this.e = this.d.scheduleWithFixedDelay(runnable, 0L, (long)w.a().d, TimeUnit.MILLISECONDS);
        }
    }

    void a(Context context, b b2) {
        if (b2 != null) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("addActiveTracker");
            stringBuilder.append(b2.hashCode());
            p.a(3, "JSUpdateLooper", this, stringBuilder.toString());
            Map<b, String> map = this.c;
            if (map != null && !map.containsKey((Object)b2)) {
                this.c.put((Object)b2, (Object)"");
                this.b(context);
            }
        }
    }

    void a(Context context, j j2) {
        Map<j, String> map = this.b;
        if (map != null && j2 != null) {
            map.put((Object)j2, (Object)"");
            this.a(context);
        }
    }

    void a(b b2) {
        if (b2 != null) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("removeActiveTracker");
            stringBuilder.append(b2.hashCode());
            p.a(3, "JSUpdateLooper", this, stringBuilder.toString());
            Map<b, String> map = this.c;
            if (map != null) {
                map.remove((Object)b2);
            }
        }
    }

    void a(j j2) {
        if (j2 != null) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("removeSetupNeededBridge");
            stringBuilder.append(j2.hashCode());
            p.a(3, "JSUpdateLooper", this, stringBuilder.toString());
            Map<j, String> map = this.b;
            if (map != null) {
                map.remove((Object)j2);
            }
        }
    }

}

