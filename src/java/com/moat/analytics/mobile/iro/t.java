/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.os.Handler
 *  android.os.Looper
 *  com.moat.analytics.mobile.iro.t$5$2
 *  java.lang.Class
 *  java.lang.Enum
 *  java.lang.Exception
 *  java.lang.Long
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.System
 *  java.lang.Thread
 *  java.lang.Throwable
 *  java.util.Iterator
 *  java.util.Queue
 *  java.util.concurrent.ConcurrentLinkedQueue
 *  java.util.concurrent.atomic.AtomicBoolean
 *  java.util.concurrent.atomic.AtomicInteger
 */
package com.moat.analytics.mobile.iro;

import android.os.Handler;
import android.os.Looper;
import com.moat.analytics.mobile.iro.base.functional.Optional;
import com.moat.analytics.mobile.iro.i;
import com.moat.analytics.mobile.iro.l;
import com.moat.analytics.mobile.iro.o;
import com.moat.analytics.mobile.iro.t;
import java.util.Iterator;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

final class t {
    private static final Queue<b> \u02bb = new ConcurrentLinkedQueue();
    private static t \u02bd;
    private long \u02bc = 60000L;
    volatile int \u02ca = 10;
    private long \u02ca\u0971 = 1800000L;
    volatile int \u02cb = c.\u02ca;
    private final AtomicInteger \u02cb\u0971 = new AtomicInteger(0);
    volatile boolean \u02ce = false;
    volatile boolean \u02cf = false;
    private final AtomicBoolean \u02cf\u0971 = new AtomicBoolean(false);
    volatile int \u0971 = 200;
    private final AtomicBoolean \u0971\u02ca = new AtomicBoolean(false);
    private volatile long \u0971\u02cb = 0L;
    private Handler \u141d;

    private t() {
        try {
            this.\u141d = new Handler(Looper.getMainLooper());
            return;
        }
        catch (Exception exception) {
            o.\u0971(exception);
            return;
        }
    }

    private static void \u02ca() {
        Queue<b> queue;
        Queue<b> queue2 = queue = \u02bb;
        synchronized (queue2) {
            block7 : {
                long l2 = System.currentTimeMillis();
                Iterator iterator = \u02bb.iterator();
                while (iterator.hasNext()) {
                    if (l2 - ((b)iterator.next()).\u0971 < 60000L) continue;
                    iterator.remove();
                }
                if (\u02bb.size() < 15) break block7;
                for (int i2 = 0; i2 < 5; ++i2) {
                    \u02bb.remove();
                }
            }
            try {
                return;
            }
            catch (Throwable throwable) {
                throw throwable;
            }
        }
    }

    static t \u02cb() {
        Class<t> class_ = t.class;
        synchronized (t.class) {
            if (\u02bd == null) {
                \u02bd = new t();
            }
            t t2 = \u02bd;
            // ** MonitorExit[var2] (shouldn't be in output)
            return t2;
        }
    }

    private void \u02cb(long l2) {
        if (!this.\u02cf\u0971.compareAndSet(false, true)) {
            return;
        }
        com.moat.analytics.mobile.iro.b.\u02cf(3, "OnOff", this, "Performing status check.");
        new Thread(l2){
            private /* synthetic */ long \u02cb;
            {
                this.\u02cb = l2;
            }

            public final void run() {
                Looper.prepare();
                Handler handler = new Handler();
                d d2 = new d(t.this, "IRO", handler, new 2(this), 0);
                handler.postDelayed((Runnable)d2, this.\u02cb);
                Looper.loop();
            }
        }.start();
    }

    final void \u02cf() {
        if (System.currentTimeMillis() - this.\u0971\u02cb > this.\u02ca\u0971) {
            this.\u02cb(0L);
        }
    }

    final void \u0971(a a2) throws o {
        if (this.\u02cb == c.\u0971) {
            a2.\u0971();
            return;
        }
        t.\u02ca();
        \u02bb.add((Object)new b(this, System.currentTimeMillis(), a2));
        if (this.\u0971\u02ca.compareAndSet(false, true)) {
            Runnable runnable = new Runnable(this){
                private /* synthetic */ t \u02cb;
                {
                    this.\u02cb = t2;
                }

                public final void run() {
                    try {
                        if (\u02bb.size() > 0) {
                            t.\u02ca();
                            this.\u02cb.\u141d.postDelayed((Runnable)this, 60000L);
                            return;
                        }
                        this.\u02cb.\u0971\u02ca.compareAndSet(true, false);
                        this.\u02cb.\u141d.removeCallbacks((Runnable)this);
                        return;
                    }
                    catch (Exception exception) {
                        o.\u0971(exception);
                        return;
                    }
                }
            };
            this.\u141d.postDelayed(runnable, 60000L);
        }
    }

    static interface a {
        public void \u0971() throws o;
    }

    final class b {
        final a \u02cb;
        private /* synthetic */ t \u02cf;
        final Long \u0971;

        b(t t2, Long l2, a a2) {
            this.\u02cf = t2;
            this.\u0971 = l2;
            this.\u02cb = a2;
        }
    }

    static final class c
    extends Enum<c> {
        public static final int \u02ca = 1;
        public static final int \u0971 = 2;

        static {
            int[] arrn = new int[]{1, 2};
        }
    }

    final class d
    implements Runnable {
        private final Handler \u02cb;
        private final com.moat.analytics.mobile.iro.t$5$2 \u02ce;
        private final String \u02cf;
        private /* synthetic */ t \u0971;

        private d(t t2, String string2, Handler handler, com.moat.analytics.mobile.iro.t$5$2 var4_4) {
            this.\u0971 = t2;
            this.\u02ce = var4_4;
            this.\u02cb = handler;
            StringBuilder stringBuilder = new StringBuilder("https://z.moatads.com/");
            stringBuilder.append(string2);
            stringBuilder.append("/android/");
            stringBuilder.append("2bc3418b93f01686fcbd1ebebcc04694651821b2".substring(0, 7));
            stringBuilder.append("/status.json");
            this.\u02cf = stringBuilder.toString();
        }

        /* synthetic */ d(t t2, String string2, Handler handler, com.moat.analytics.mobile.iro.t$5$2 var4_4, byte by) {
            this(t2, string2, handler, var4_4);
        }

        private String \u0971() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(this.\u02cf);
            stringBuilder.append("?ts=");
            stringBuilder.append(System.currentTimeMillis());
            stringBuilder.append("&v=2.4.0");
            Optional<String> optional = l.\u0971(stringBuilder.toString());
            try {
                String string2 = optional.get();
                return string2;
            }
            catch (Exception exception) {
                return null;
            }
        }

        /*
         * Enabled aggressive block sorting
         * Enabled unnecessary exception pruning
         * Enabled aggressive exception aggregation
         */
        public final void run() {
            try {
                String string2 = this.\u0971();
                i i2 = new i(string2);
                this.\u0971.\u02ce = i2.\u02ca();
                this.\u0971.\u02cf = i2.\u02ce();
                this.\u0971.\u0971 = i2.\u02cb();
                this.\u0971.\u02ca = i2.\u0971();
                new Handler(Looper.getMainLooper()).post(new Runnable(this, i2){
                    private /* synthetic */ i \u02ce;
                    private /* synthetic */ d \u0971;
                    {
                        this.\u0971 = d2;
                        this.\u02ce = i2;
                    }

                    public final void run() {
                        try {
                            this.\u0971.\u02ce.\u02cb(this.\u02ce);
                            return;
                        }
                        catch (Exception exception) {
                            o.\u0971(exception);
                            return;
                        }
                    }
                });
                this.\u0971.\u0971\u02cb = System.currentTimeMillis();
                this.\u0971.\u02cf\u0971.compareAndSet(true, false);
                if (string2 == null) {
                    if (this.\u0971.\u02cb\u0971.incrementAndGet() < 10) {
                        this.\u0971.\u02cb(this.\u0971.\u02bc);
                    }
                } else {
                    this.\u0971.\u02cb\u0971.set(0);
                }
            }
            catch (Exception exception) {
                o.\u0971(exception);
            }
            this.\u02cb.removeCallbacks((Runnable)this);
            Looper looper = Looper.myLooper();
            if (looper != null) {
                looper.quit();
            }
        }

    }

    static interface e {
        public void \u02cb(i var1) throws o;
    }

}

