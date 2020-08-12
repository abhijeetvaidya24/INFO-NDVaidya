/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.os.Handler
 *  android.os.Looper
 *  com.moat.analytics.mobile.cha.t$2$2
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
package com.moat.analytics.mobile.cha;

import android.os.Handler;
import android.os.Looper;
import com.moat.analytics.mobile.cha.base.functional.Optional;
import com.moat.analytics.mobile.cha.g;
import com.moat.analytics.mobile.cha.m;
import com.moat.analytics.mobile.cha.o;
import com.moat.analytics.mobile.cha.t;
import java.util.Iterator;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

final class t {
    private static t \u02bb;
    private static final Queue<e> \u02bd;
    private long \u02bc = 60000L;
    volatile int \u02ca = 200;
    private long \u02ca\u0971 = 1800000L;
    volatile boolean \u02cb = false;
    private final AtomicBoolean \u02cb\u0971 = new AtomicBoolean(false);
    volatile int \u02ce = a.\u0971;
    volatile boolean \u02cf = false;
    private final AtomicBoolean \u02cf\u0971 = new AtomicBoolean(false);
    volatile int \u0971 = 10;
    private final AtomicInteger \u0971\u02ca = new AtomicInteger(0);
    private volatile long \u0971\u02cb = 0L;
    private Handler \u141d;

    static {
        \u02bd = new ConcurrentLinkedQueue();
    }

    private t() {
        try {
            this.\u141d = new Handler(Looper.getMainLooper());
            return;
        }
        catch (Exception exception) {
            o.\u02ce(exception);
            return;
        }
    }

    private static void \u02ca() {
        Queue<e> queue;
        Queue<e> queue2 = queue = \u02bd;
        synchronized (queue2) {
            block7 : {
                long l2 = System.currentTimeMillis();
                Iterator iterator = \u02bd.iterator();
                while (iterator.hasNext()) {
                    if (l2 - ((e)iterator.next()).\u02ce < 60000L) continue;
                    iterator.remove();
                }
                if (\u02bd.size() < 15) break block7;
                for (int i2 = 0; i2 < 5; ++i2) {
                    \u02bd.remove();
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

    static t \u02cf() {
        Class<t> class_ = t.class;
        synchronized (t.class) {
            if (\u02bb == null) {
                \u02bb = new t();
            }
            t t2 = \u02bb;
            // ** MonitorExit[var2] (shouldn't be in output)
            return t2;
        }
    }

    private void \u02cf(long l2) {
        if (!this.\u02cf\u0971.compareAndSet(false, true)) {
            return;
        }
        com.moat.analytics.mobile.cha.a.\u02cf(3, "OnOff", this, "Performing status check.");
        new Thread(l2){
            private /* synthetic */ long \u02cf;
            {
                this.\u02cf = l2;
            }

            public final void run() {
                Looper.prepare();
                Handler handler = new Handler();
                d d2 = new d(t.this, "CHA", handler, new 2(this), 0);
                handler.postDelayed((Runnable)d2, this.\u02cf);
                Looper.loop();
            }
        }.start();
    }

    final void \u02ca(b b2) throws o {
        if (this.\u02ce == a.\u02ce) {
            b2.\u02ce();
            return;
        }
        t.\u02ca();
        \u02bd.add((Object)new e(this, System.currentTimeMillis(), b2));
        if (this.\u02cb\u0971.compareAndSet(false, true)) {
            Runnable runnable = new Runnable(this){
                private /* synthetic */ t \u0971;
                {
                    this.\u0971 = t2;
                }

                public final void run() {
                    try {
                        if (\u02bd.size() > 0) {
                            t.\u02ca();
                            this.\u0971.\u141d.postDelayed((Runnable)this, 60000L);
                            return;
                        }
                        this.\u0971.\u02cb\u0971.compareAndSet(true, false);
                        this.\u0971.\u141d.removeCallbacks((Runnable)this);
                        return;
                    }
                    catch (Exception exception) {
                        o.\u02ce(exception);
                        return;
                    }
                }
            };
            this.\u141d.postDelayed(runnable, 60000L);
        }
    }

    final void \u02ce() {
        if (System.currentTimeMillis() - this.\u0971\u02cb > this.\u02ca\u0971) {
            this.\u02cf(0L);
        }
    }

    static final class a
    extends Enum<a> {
        public static final int \u02ce = 2;
        public static final int \u0971 = 1;

        static {
            int[] arrn = new int[]{1, 2};
        }
    }

    static interface b {
        public void \u02ce() throws o;
    }

    static interface c {
        public void \u02cf(g var1) throws o;
    }

    final class d
    implements Runnable {
        private /* synthetic */ t \u02cb;
        private final String \u02ce;
        private final 2 \u02cf;
        private final Handler \u0971;

        private d(t t2, String string, Handler handler, 2 var4_4) {
            this.\u02cb = t2;
            this.\u02cf = var4_4;
            this.\u0971 = handler;
            StringBuilder stringBuilder = new StringBuilder("https://z.moatads.com/");
            stringBuilder.append(string);
            stringBuilder.append("/android/");
            stringBuilder.append("35d482907bc2811c2e46b96f16eb5f9fe00185f3".substring(0, 7));
            stringBuilder.append("/status.json");
            this.\u02ce = stringBuilder.toString();
        }

        /* synthetic */ d(t t2, String string, Handler handler, 2 var4_4, byte by) {
            this(t2, string, handler, var4_4);
        }

        private String \u02ce() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(this.\u02ce);
            stringBuilder.append("?ts=");
            stringBuilder.append(System.currentTimeMillis());
            stringBuilder.append("&v=2.4.1");
            Optional<String> optional = m.\u0971(stringBuilder.toString());
            try {
                String string = optional.get();
                return string;
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
                String string = this.\u02ce();
                g g2 = new g(string);
                this.\u02cb.\u02cf = g2.\u02ca();
                this.\u02cb.\u02cb = g2.\u0971();
                this.\u02cb.\u02ca = g2.\u02cf();
                this.\u02cb.\u0971 = g2.\u02ce();
                new Handler(Looper.getMainLooper()).post(new Runnable(this, g2){
                    private /* synthetic */ d \u02ca;
                    private /* synthetic */ g \u0971;
                    {
                        this.\u02ca = d2;
                        this.\u0971 = g2;
                    }

                    public final void run() {
                        try {
                            this.\u02ca.\u02cf.\u02cf(this.\u0971);
                            return;
                        }
                        catch (Exception exception) {
                            o.\u02ce(exception);
                            return;
                        }
                    }
                });
                this.\u02cb.\u0971\u02cb = System.currentTimeMillis();
                this.\u02cb.\u02cf\u0971.compareAndSet(true, false);
                if (string == null) {
                    if (this.\u02cb.\u0971\u02ca.incrementAndGet() < 10) {
                        this.\u02cb.\u02cf(this.\u02cb.\u02bc);
                    }
                } else {
                    this.\u02cb.\u0971\u02ca.set(0);
                }
            }
            catch (Exception exception) {
                o.\u02ce(exception);
            }
            this.\u0971.removeCallbacks((Runnable)this);
            Looper looper = Looper.myLooper();
            if (looper != null) {
                looper.quit();
            }
        }

    }

    final class e {
        final Long \u02ce;
        private /* synthetic */ t \u02cf;
        final b \u0971;

        e(t t2, Long l2, b b2) {
            this.\u02cf = t2;
            this.\u02ce = l2;
            this.\u0971 = b2;
        }
    }

}

