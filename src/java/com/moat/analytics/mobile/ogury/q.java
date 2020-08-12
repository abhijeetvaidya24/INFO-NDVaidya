/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.os.Handler
 *  android.os.Looper
 *  com.moat.analytics.mobile.ogury.e
 *  com.moat.analytics.mobile.ogury.q$3
 *  java.lang.Class
 *  java.lang.Enum
 *  java.lang.Exception
 *  java.lang.Long
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.System
 *  java.lang.Throwable
 *  java.util.Iterator
 *  java.util.Queue
 *  java.util.concurrent.ConcurrentLinkedQueue
 *  java.util.concurrent.atomic.AtomicBoolean
 *  java.util.concurrent.atomic.AtomicInteger
 */
package com.moat.analytics.mobile.ogury;

import android.os.Handler;
import android.os.Looper;
import com.moat.analytics.mobile.ogury.base.functional.Optional;
import com.moat.analytics.mobile.ogury.e;
import com.moat.analytics.mobile.ogury.j;
import com.moat.analytics.mobile.ogury.k;
import com.moat.analytics.mobile.ogury.l;
import com.moat.analytics.mobile.ogury.q;
import java.util.Iterator;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

final class q {
    private static q \u02bb;
    private static final Queue<a> \u02bc;
    private Handler \u02bd;
    volatile int \u02ca = 10;
    private final AtomicInteger \u02ca\u0971 = new AtomicInteger(0);
    volatile int \u02cb = 200;
    private volatile long \u02cb\u0971 = 0L;
    volatile boolean \u02ce = false;
    volatile boolean \u02cf = false;
    private final AtomicBoolean \u037a = new AtomicBoolean(false);
    volatile int \u0971 = e.\u02ca;
    private final AtomicBoolean \u0971\u02ca = new AtomicBoolean(false);
    private long \u0971\u0971 = 60000L;
    private long \u141d = 1800000L;

    static {
        \u02bc = new ConcurrentLinkedQueue();
    }

    private q() {
        try {
            this.\u02bd = new Handler(Looper.getMainLooper());
            return;
        }
        catch (Exception exception) {
            l.\u0971(exception);
            return;
        }
    }

    static q \u02ca() {
        Class<q> class_ = q.class;
        synchronized (q.class) {
            if (\u02bb == null) {
                \u02bb = new q();
            }
            q q2 = \u02bb;
            // ** MonitorExit[var2] (shouldn't be in output)
            return q2;
        }
    }

    private static void \u02ce() {
        Queue<a> queue;
        Queue<a> queue2 = queue = \u02bc;
        synchronized (queue2) {
            block7 : {
                long l2 = System.currentTimeMillis();
                Iterator iterator = \u02bc.iterator();
                while (iterator.hasNext()) {
                    if (l2 - ((a)iterator.next()).\u02cb < 60000L) continue;
                    iterator.remove();
                }
                if (\u02bc.size() < 15) break block7;
                for (int i2 = 0; i2 < 5; ++i2) {
                    \u02bc.remove();
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

    private void \u0971(long l2) {
        if (!this.\u037a.compareAndSet(false, true)) {
            return;
        }
        e.1.\u02cb(3, "OnOff", this, "Performing status check.");
        new 3(this, l2).start();
    }

    final void \u02ca(b b2) throws l {
        if (this.\u0971 == e.\u02ce) {
            b2.\u02cb();
            return;
        }
        q.\u02ce();
        \u02bc.add((Object)new a(this, System.currentTimeMillis(), b2));
        if (this.\u0971\u02ca.compareAndSet(false, true)) {
            Runnable runnable = new Runnable(this){
                private /* synthetic */ q \u0971;
                {
                    this.\u0971 = q2;
                }

                public final void run() {
                    try {
                        if (\u02bc.size() > 0) {
                            q.\u02ce();
                            this.\u0971.\u02bd.postDelayed((Runnable)this, 60000L);
                            return;
                        }
                        this.\u0971.\u0971\u02ca.compareAndSet(true, false);
                        this.\u0971.\u02bd.removeCallbacks((Runnable)this);
                        return;
                    }
                    catch (Exception exception) {
                        l.\u0971(exception);
                        return;
                    }
                }
            };
            this.\u02bd.postDelayed(runnable, 60000L);
        }
    }

    final void \u0971() {
        if (System.currentTimeMillis() - this.\u02cb\u0971 > this.\u141d) {
            this.\u0971(0L);
        }
    }

    final class a {
        final Long \u02cb;
        private /* synthetic */ q \u02cf;
        final b \u0971;

        a(q q2, Long l2, b b2) {
            this.\u02cf = q2;
            this.\u02cb = l2;
            this.\u0971 = b2;
        }
    }

    static interface b {
        public void \u02cb() throws l;
    }

    static interface c {
        public void \u0971(j var1) throws l;
    }

    final class d
    implements Runnable {
        private /* synthetic */ q \u02ca;
        private final String \u02cb;
        private final c \u02ce;
        private final Handler \u0971;

        private d(q q2, String string2, Handler handler, c c2) {
            this.\u02ca = q2;
            this.\u02ce = c2;
            this.\u0971 = handler;
            StringBuilder stringBuilder = new StringBuilder("https://z.moatads.com/");
            stringBuilder.append(string2);
            stringBuilder.append("/android/");
            stringBuilder.append("5e29fb7ac3f5a02776850780700bd118383621e1".substring(0, 7));
            stringBuilder.append("/status.json");
            this.\u02cb = stringBuilder.toString();
        }

        /* synthetic */ d(q q2, String string2, Handler handler, c c2, byte by) {
            this(q2, string2, handler, c2);
        }

        private String \u02ca() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(this.\u02cb);
            stringBuilder.append("?ts=");
            stringBuilder.append(System.currentTimeMillis());
            stringBuilder.append("&v=2.4.3");
            Optional<String> optional = k.\u02cb(stringBuilder.toString());
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
                String string2 = this.\u02ca();
                j j2 = new j(string2);
                this.\u02ca.\u02cf = j2.\u02cb();
                this.\u02ca.\u02ce = j2.\u02cf();
                this.\u02ca.\u02cb = j2.\u02ca();
                this.\u02ca.\u02ca = j2.\u02ce();
                new Handler(Looper.getMainLooper()).post(new Runnable(this, j2){
                    private /* synthetic */ j \u02cb;
                    private /* synthetic */ d \u02ce;
                    {
                        this.\u02ce = d2;
                        this.\u02cb = j2;
                    }

                    public final void run() {
                        try {
                            this.\u02ce.\u02ce.\u0971(this.\u02cb);
                            return;
                        }
                        catch (Exception exception) {
                            l.\u0971(exception);
                            return;
                        }
                    }
                });
                this.\u02ca.\u02cb\u0971 = System.currentTimeMillis();
                this.\u02ca.\u037a.compareAndSet(true, false);
                if (string2 == null) {
                    if (this.\u02ca.\u02ca\u0971.incrementAndGet() < 10) {
                        this.\u02ca.\u0971(this.\u02ca.\u0971\u0971);
                    }
                } else {
                    this.\u02ca.\u02ca\u0971.set(0);
                }
            }
            catch (Exception exception) {
                l.\u0971(exception);
            }
            this.\u0971.removeCallbacks((Runnable)this);
            Looper looper = Looper.myLooper();
            if (looper != null) {
                looper.quit();
            }
        }

    }

    static final class e
    extends Enum<e> {
        public static final int \u02ca = 1;
        public static final int \u02ce = 2;
        private static final /* synthetic */ int[] \u02cf;

        static {
            \u02cf = new int[]{1, 2};
        }

        public static int[] values$160b2863() {
            return (int[])\u02cf.clone();
        }
    }

}

