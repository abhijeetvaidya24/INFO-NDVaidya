/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.os.Handler
 *  android.os.Looper
 *  com.moat.analytics.mobile.mpub.w$1$1
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
 *  java.util.Iterator
 *  java.util.Queue
 *  java.util.concurrent.ConcurrentLinkedQueue
 *  java.util.concurrent.atomic.AtomicBoolean
 *  java.util.concurrent.atomic.AtomicInteger
 */
package com.moat.analytics.mobile.mpub;

import android.os.Handler;
import android.os.Looper;
import com.moat.analytics.mobile.mpub.l;
import com.moat.analytics.mobile.mpub.m;
import com.moat.analytics.mobile.mpub.p;
import com.moat.analytics.mobile.mpub.q;
import com.moat.analytics.mobile.mpub.w;
import java.util.Iterator;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

class w {
    private static w h;
    private static final Queue<c> i;
    volatile d a = d.a;
    volatile boolean b = false;
    volatile boolean c = false;
    volatile int d = 200;
    volatile int e = 10;
    private long f = 1800000L;
    private long g = 60000L;
    private Handler j;
    private final AtomicBoolean k = new AtomicBoolean(false);
    private volatile long l = 0L;
    private final AtomicInteger m = new AtomicInteger(0);
    private final AtomicBoolean n = new AtomicBoolean(false);

    static {
        i = new ConcurrentLinkedQueue();
    }

    private w() {
        try {
            this.j = new Handler(Looper.getMainLooper());
            return;
        }
        catch (Exception exception) {
            m.a(exception);
            return;
        }
    }

    static w a() {
        Class<w> class_ = w.class;
        synchronized (w.class) {
            if (h == null) {
                h = new w();
            }
            w w2 = h;
            // ** MonitorExit[var2] (shouldn't be in output)
            return w2;
        }
    }

    private void a(final long l2) {
        if (!this.n.compareAndSet(false, true)) {
            return;
        }
        p.a(3, "OnOff", this, "Performing status check.");
        new Thread(){

            public void run() {
                Looper.prepare();
                Handler handler = new Handler();
                a a2 = new a("MPUB", handler, (e)new 1(this));
                handler.postDelayed((Runnable)a2, l2);
                Looper.loop();
            }
        }.start();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private void d() {
        Queue<c> queue;
        Queue<c> queue2 = queue = i;
        synchronized (queue2) {
            long l2 = System.currentTimeMillis();
            Iterator iterator = i.iterator();
            while (iterator.hasNext()) {
                if (l2 - ((c)iterator.next()).a < 60000L) continue;
                iterator.remove();
            }
            if (i.size() >= 15) {
                for (int i2 = 0; i2 < 5; ++i2) {
                    i.remove();
                }
            }
            return;
        }
    }

    private void e() {
        if (!this.k.compareAndSet(false, true)) {
            return;
        }
        Runnable runnable = new Runnable(){

            public void run() {
                try {
                    if (i.size() > 0) {
                        w.this.d();
                        w.this.j.postDelayed((Runnable)this, 60000L);
                        return;
                    }
                    w.this.k.compareAndSet(true, false);
                    w.this.j.removeCallbacks((Runnable)this);
                    return;
                }
                catch (Exception exception) {
                    m.a(exception);
                    return;
                }
            }
        };
        this.j.postDelayed(runnable, 60000L);
    }

    void a(b b2) {
        if (this.a == d.b) {
            b2.c();
            return;
        }
        this.d();
        i.add((Object)new c(System.currentTimeMillis(), b2));
        this.e();
    }

    void b() {
        if (System.currentTimeMillis() - this.l > this.f) {
            this.a(0L);
        }
    }

    private class a
    implements Runnable {
        private final Handler b;
        private final String c;
        private final e d;

        private a(String string2, Handler handler, e e2) {
            this.d = e2;
            this.b = handler;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("https://z.moatads.com/");
            stringBuilder.append(string2);
            stringBuilder.append("/android/");
            stringBuilder.append("9d24c90729bf464dce5d8fd1ace14a60656dbb2d".substring(0, 7));
            stringBuilder.append("/status.json");
            this.c = stringBuilder.toString();
        }

        private void a() {
            String string2 = this.b();
            final l l2 = new l(string2);
            w.this.b = l2.a();
            w.this.c = l2.b();
            w.this.d = l2.c();
            w.this.e = l2.d();
            new Handler(Looper.getMainLooper()).post(new Runnable(){

                public void run() {
                    try {
                        a.this.d.a(l2);
                        return;
                    }
                    catch (Exception exception) {
                        m.a(exception);
                        return;
                    }
                }
            });
            w.this.l = System.currentTimeMillis();
            w.this.n.compareAndSet(true, false);
            if (string2 == null) {
                if (w.this.m.incrementAndGet() < 10) {
                    w w2 = w.this;
                    w2.a(w2.g);
                    return;
                }
            } else {
                w.this.m.set(0);
            }
        }

        private String b() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(this.c);
            stringBuilder.append("?ts=");
            stringBuilder.append(System.currentTimeMillis());
            stringBuilder.append("&v=");
            stringBuilder.append("2.4.5");
            com.moat.analytics.mobile.mpub.a.b.a<String> a2 = q.a(stringBuilder.toString());
            try {
                String string2 = a2.b();
                return string2;
            }
            catch (Exception exception) {
                return null;
            }
        }

        public void run() {
            try {
                this.a();
            }
            catch (Exception exception) {
                m.a(exception);
            }
            this.b.removeCallbacks((Runnable)this);
            Looper looper = Looper.myLooper();
            if (looper != null) {
                looper.quit();
            }
        }

    }

    static interface b {
        public void c();

        public void d();
    }

    private class c {
        final Long a;
        final b b;

        c(Long l2, b b2) {
            this.a = l2;
            this.b = b2;
        }
    }

    static final class d
    extends Enum<d> {
        public static final /* enum */ d a = new d();
        public static final /* enum */ d b = new d();
        private static final /* synthetic */ d[] c;

        static {
            d[] arrd = new d[]{a, b};
            c = arrd;
        }

        public static d valueOf(String string2) {
            return (d)Enum.valueOf(d.class, (String)string2);
        }

        public static d[] values() {
            return (d[])c.clone();
        }
    }

    static interface e {
        public void a(l var1);
    }

}

