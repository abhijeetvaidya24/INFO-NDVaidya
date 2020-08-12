/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.SharedPreferences
 *  android.content.SharedPreferences$Editor
 *  android.os.SystemClock
 *  com.tapjoy.internal.dy
 *  com.tapjoy.internal.dy$a
 *  com.tapjoy.internal.eb
 *  com.tapjoy.internal.ek
 *  com.tapjoy.internal.ek$a
 *  com.tapjoy.internal.ga$1
 *  com.tapjoy.internal.n
 *  java.lang.Boolean
 *  java.lang.Long
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.String
 *  java.util.concurrent.ScheduledExecutorService
 *  java.util.concurrent.ScheduledFuture
 *  java.util.concurrent.TimeUnit
 *  java.util.concurrent.atomic.AtomicBoolean
 */
package com.tapjoy.internal;

import android.content.SharedPreferences;
import android.os.SystemClock;
import com.tapjoy.internal.ci;
import com.tapjoy.internal.dy;
import com.tapjoy.internal.eb;
import com.tapjoy.internal.ek;
import com.tapjoy.internal.ev;
import com.tapjoy.internal.fz;
import com.tapjoy.internal.ga;
import com.tapjoy.internal.gb;
import com.tapjoy.internal.gf;
import com.tapjoy.internal.gm;
import com.tapjoy.internal.go;
import com.tapjoy.internal.gq;
import com.tapjoy.internal.n;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

public final class gp {
    final gb a;
    final AtomicBoolean b = new AtomicBoolean();
    ScheduledFuture c;
    private final Runnable d = new Runnable(){

        /*
         * Enabled aggressive block sorting
         * Enabled unnecessary exception pruning
         * Enabled aggressive exception aggregation
         */
        public final void run() {
            gf gf2;
            if (!gp.this.b.compareAndSet(true, false)) {
                return;
            }
            fz.a("The session ended");
            gb gb2 = gp.this.a;
            long l2 = SystemClock.elapsedRealtime() - gb2.c;
            gf gf3 = gf2 = gb2.a;
            synchronized (gf3) {
                long l3 = l2 + gf2.c.i.a();
                gf2.c.i.a(l3);
                gf2.b.i = l3;
            }
            dy.a a2 = gb2.a(eb.APP, "session");
            a2.i = l2;
            gb2.a(a2);
            gb2.c = 0L;
            gf gf4 = gb2.a;
            long l4 = a2.e;
            gf gf5 = gf4;
            synchronized (gf5) {
                SharedPreferences.Editor editor = gf4.c.a();
                gf4.c.j.a(editor, l4);
                gf4.c.k.a(editor, l2);
                editor.commit();
                gf4.b.j = l4;
                gf4.b.k = l2;
            }
            ga ga2 = gb2.b;
            if (ga2.b != null) {
                ga2.a();
                new ga.1(ga2).run();
            }
            ga2.a.flush();
            ev.d.notifyObservers();
        }
    };
    private final Runnable e = new Runnable(){

        public final void run() {
        }
    };

    gp(gb gb2) {
        this.a = gb2;
    }

    public final void a() {
        if (this.b.get()) {
            if (Boolean.FALSE.booleanValue()) {
                ScheduledFuture scheduledFuture = this.c;
                if (scheduledFuture == null || scheduledFuture.cancel(false)) {
                    this.c = gq.a.schedule(this.d, 3000L, TimeUnit.MILLISECONDS);
                }
                return;
            }
            this.d.run();
        }
    }

}

