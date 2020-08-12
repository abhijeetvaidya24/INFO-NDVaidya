/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.applovin.impl.sdk.b.a
 *  java.lang.Boolean
 *  java.lang.Enum
 *  java.lang.IllegalArgumentException
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.System
 *  java.lang.Thread
 *  java.lang.Thread$UncaughtExceptionHandler
 *  java.lang.Throwable
 *  java.util.ArrayList
 *  java.util.Iterator
 *  java.util.List
 *  java.util.concurrent.Future
 *  java.util.concurrent.ScheduledExecutorService
 *  java.util.concurrent.ScheduledFuture
 *  java.util.concurrent.ScheduledThreadPoolExecutor
 *  java.util.concurrent.ThreadFactory
 *  java.util.concurrent.TimeUnit
 */
package com.applovin.impl.sdk.d;

import com.applovin.impl.sdk.c.i;
import com.applovin.impl.sdk.e.e;
import com.applovin.impl.sdk.e.m;
import com.applovin.impl.sdk.j;
import com.applovin.impl.sdk.p;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;

public class q {
    private final String a = "TaskManager";
    private final j b;
    private final p c;
    private final ScheduledThreadPoolExecutor d;
    private final ScheduledThreadPoolExecutor e;
    private final ScheduledThreadPoolExecutor f;
    private final ScheduledThreadPoolExecutor g;
    private final ScheduledThreadPoolExecutor h;
    private final ScheduledThreadPoolExecutor i;
    private final ScheduledThreadPoolExecutor j;
    private final ScheduledThreadPoolExecutor k;
    private final ScheduledThreadPoolExecutor l;
    private final ScheduledThreadPoolExecutor m;
    private final ScheduledThreadPoolExecutor n;
    private final ScheduledThreadPoolExecutor o;
    private final ScheduledThreadPoolExecutor p;
    private final ScheduledThreadPoolExecutor q;
    private final ScheduledThreadPoolExecutor r;
    private final ScheduledThreadPoolExecutor s;
    private final List<c> t = new ArrayList(5);
    private final Object u = new Object();
    private boolean v;

    public q(j j2) {
        this.b = j2;
        this.c = j2.u();
        this.d = this.a("main");
        this.e = this.a("timeout");
        this.f = this.a("back");
        this.g = this.a("postbacks");
        this.h = this.a("caching_interstitial");
        this.i = this.a("caching_incentivized");
        this.j = this.a("caching_other");
        this.k = this.a("reward");
        this.l = this.a("mediation_main");
        this.m = this.a("mediation_timeout");
        this.n = this.a("mediation_background");
        this.o = this.a("mediation_backup");
        this.p = this.a("mediation_postbacks");
        this.q = this.a("mediation_banner");
        this.r = this.a("mediation_interstitial");
        this.s = this.a("mediation_incentivized");
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private long a(a a2) {
        long l2;
        ScheduledThreadPoolExecutor scheduledThreadPoolExecutor;
        if (a2 == a.a) {
            l2 = this.d.getTaskCount();
            scheduledThreadPoolExecutor = this.d;
            do {
                return l2 - scheduledThreadPoolExecutor.getCompletedTaskCount();
                break;
            } while (true);
        }
        if (a2 == a.b) {
            l2 = this.e.getTaskCount();
            scheduledThreadPoolExecutor = this.e;
            return l2 - scheduledThreadPoolExecutor.getCompletedTaskCount();
        }
        if (a2 == a.c) {
            l2 = this.f.getTaskCount();
            scheduledThreadPoolExecutor = this.f;
            return l2 - scheduledThreadPoolExecutor.getCompletedTaskCount();
        }
        if (a2 == a.d) {
            l2 = this.g.getTaskCount();
            scheduledThreadPoolExecutor = this.g;
            return l2 - scheduledThreadPoolExecutor.getCompletedTaskCount();
        }
        if (a2 == a.e) {
            l2 = this.h.getTaskCount();
            scheduledThreadPoolExecutor = this.h;
            return l2 - scheduledThreadPoolExecutor.getCompletedTaskCount();
        }
        if (a2 == a.f) {
            l2 = this.i.getTaskCount();
            scheduledThreadPoolExecutor = this.i;
            return l2 - scheduledThreadPoolExecutor.getCompletedTaskCount();
        }
        if (a2 == a.g) {
            l2 = this.j.getTaskCount();
            scheduledThreadPoolExecutor = this.j;
            return l2 - scheduledThreadPoolExecutor.getCompletedTaskCount();
        }
        if (a2 == a.h) {
            l2 = this.k.getTaskCount();
            scheduledThreadPoolExecutor = this.k;
            return l2 - scheduledThreadPoolExecutor.getCompletedTaskCount();
        }
        if (a2 == a.i) {
            l2 = this.l.getTaskCount();
            scheduledThreadPoolExecutor = this.l;
            return l2 - scheduledThreadPoolExecutor.getCompletedTaskCount();
        }
        if (a2 == a.j) {
            l2 = this.m.getTaskCount();
            scheduledThreadPoolExecutor = this.m;
            return l2 - scheduledThreadPoolExecutor.getCompletedTaskCount();
        }
        if (a2 == a.k) {
            l2 = this.n.getTaskCount();
            scheduledThreadPoolExecutor = this.n;
            return l2 - scheduledThreadPoolExecutor.getCompletedTaskCount();
        }
        if (a2 == a.l) {
            l2 = this.o.getTaskCount();
            scheduledThreadPoolExecutor = this.o;
            return l2 - scheduledThreadPoolExecutor.getCompletedTaskCount();
        }
        if (a2 == a.m) {
            l2 = this.p.getTaskCount();
            scheduledThreadPoolExecutor = this.p;
            return l2 - scheduledThreadPoolExecutor.getCompletedTaskCount();
        }
        if (a2 == a.n) {
            l2 = this.q.getTaskCount();
            scheduledThreadPoolExecutor = this.q;
            return l2 - scheduledThreadPoolExecutor.getCompletedTaskCount();
        }
        if (a2 == a.o) {
            l2 = this.r.getTaskCount();
            scheduledThreadPoolExecutor = this.r;
            return l2 - scheduledThreadPoolExecutor.getCompletedTaskCount();
        }
        if (a2 != a.p) return 0L;
        l2 = this.s.getTaskCount();
        scheduledThreadPoolExecutor = this.s;
        return l2 - scheduledThreadPoolExecutor.getCompletedTaskCount();
    }

    static /* synthetic */ long a(q q2, a a2) {
        return q2.a(a2);
    }

    private ScheduledThreadPoolExecutor a(String string2) {
        return new ScheduledThreadPoolExecutor(1, (ThreadFactory)new b(string2));
    }

    private static void a(Runnable runnable, long l2, ScheduledExecutorService scheduledExecutorService) {
        if (l2 > 0L) {
            scheduledExecutorService.schedule(runnable, l2, TimeUnit.MILLISECONDS);
            return;
        }
        scheduledExecutorService.submit(runnable);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private boolean a(c c2) {
        Object object;
        if (c2.c.e()) {
            return false;
        }
        Object object2 = object = this.u;
        synchronized (object2) {
            if (this.v) {
                return false;
            }
            this.t.add((Object)c2);
            return true;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void a() {
        Object object;
        Object object2 = object = this.u;
        synchronized (object2) {
            this.v = false;
            return;
        }
    }

    public void a(com.applovin.impl.sdk.d.a a2) {
        if (a2 != null) {
            long l2 = System.currentTimeMillis();
            try {
                p p2 = this.c;
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Executing ");
                stringBuilder.append(a2.c());
                stringBuilder.append(" immediately...");
                p2.b("TaskManager", stringBuilder.toString());
                a2.run();
                long l3 = System.currentTimeMillis() - l2;
                this.b.E().a(a2.a(), l3);
                p p3 = this.c;
                StringBuilder stringBuilder2 = new StringBuilder();
                stringBuilder2.append(a2.c());
                stringBuilder2.append(" finished executing...");
                p3.b("TaskManager", stringBuilder2.toString());
                return;
            }
            catch (Throwable throwable) {
                this.c.b(a2.c(), "Task failed execution", throwable);
                long l4 = System.currentTimeMillis() - l2;
                this.b.E().a(a2.a(), true, l4);
                return;
            }
        }
        this.c.d("TaskManager", "Attempted to execute null task immediately");
    }

    public void a(com.applovin.impl.sdk.d.a a2, a a3) {
        this.a(a2, a3, 0L);
    }

    /*
     * Enabled aggressive block sorting
     */
    public void a(com.applovin.impl.sdk.d.a a2, a a3, long l2) {
        ScheduledThreadPoolExecutor scheduledThreadPoolExecutor;
        c c2;
        if (a2 == null) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("No task specified");
            throw illegalArgumentException;
        }
        if (l2 < 0L) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Invalid delay specified: ");
            stringBuilder.append(l2);
            throw new IllegalArgumentException(stringBuilder.toString());
        }
        if (!((Boolean)this.b.a(com.applovin.impl.sdk.b.a.G)).booleanValue()) {
            if (a3 == a.i) {
                a3 = a.a;
            } else if (a3 == a.k) {
                a3 = a.c;
            } else if (a3 == a.m) {
                a3 = a.d;
            }
        }
        if (this.a(c2 = new c(a2, a3))) {
            p p2 = this.c;
            String string2 = a2.c();
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Task ");
            stringBuilder.append(a2.c());
            stringBuilder.append(" execution delayed until after init");
            p2.b(string2, stringBuilder.toString());
            return;
        }
        long l3 = 1L + this.a(a3);
        p p3 = this.c;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Scheduling ");
        stringBuilder.append(a2.c());
        stringBuilder.append(" on ");
        stringBuilder.append((Object)a3);
        stringBuilder.append(" queue in ");
        stringBuilder.append(l2);
        stringBuilder.append("ms with new queue size ");
        stringBuilder.append(l3);
        p3.a("TaskManager", stringBuilder.toString());
        if (a3 == a.a) {
            scheduledThreadPoolExecutor = this.d;
        } else if (a3 == a.b) {
            scheduledThreadPoolExecutor = this.e;
        } else if (a3 == a.c) {
            scheduledThreadPoolExecutor = this.f;
        } else if (a3 == a.d) {
            scheduledThreadPoolExecutor = this.g;
        } else if (a3 == a.e) {
            scheduledThreadPoolExecutor = this.h;
        } else if (a3 == a.f) {
            scheduledThreadPoolExecutor = this.i;
        } else if (a3 == a.g) {
            scheduledThreadPoolExecutor = this.j;
        } else if (a3 == a.h) {
            scheduledThreadPoolExecutor = this.k;
        } else if (a3 == a.i) {
            scheduledThreadPoolExecutor = this.l;
        } else if (a3 == a.j) {
            scheduledThreadPoolExecutor = this.m;
        } else if (a3 == a.k) {
            scheduledThreadPoolExecutor = this.n;
        } else if (a3 == a.l) {
            scheduledThreadPoolExecutor = this.o;
        } else if (a3 == a.m) {
            scheduledThreadPoolExecutor = this.p;
        } else if (a3 == a.n) {
            scheduledThreadPoolExecutor = this.q;
        } else if (a3 == a.o) {
            scheduledThreadPoolExecutor = this.r;
        } else {
            if (a3 != a.p) return;
            scheduledThreadPoolExecutor = this.s;
        }
        q.a(c2, l2, (ScheduledExecutorService)scheduledThreadPoolExecutor);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void b() {
        Object object;
        Object object2 = object = this.u;
        synchronized (object2) {
            this.v = true;
            Iterator iterator = this.t.iterator();
            do {
                if (!iterator.hasNext()) {
                    this.t.clear();
                    return;
                }
                c c2 = (c)iterator.next();
                this.a(c2.c, c2.d);
            } while (true);
        }
    }

    public static final class a
    extends Enum<a> {
        public static final /* enum */ a a = new a();
        public static final /* enum */ a b = new a();
        public static final /* enum */ a c = new a();
        public static final /* enum */ a d = new a();
        public static final /* enum */ a e = new a();
        public static final /* enum */ a f = new a();
        public static final /* enum */ a g = new a();
        public static final /* enum */ a h = new a();
        public static final /* enum */ a i = new a();
        public static final /* enum */ a j = new a();
        public static final /* enum */ a k = new a();
        public static final /* enum */ a l = new a();
        public static final /* enum */ a m = new a();
        public static final /* enum */ a n = new a();
        public static final /* enum */ a o = new a();
        public static final /* enum */ a p = new a();
        private static final /* synthetic */ a[] q;

        static {
            a[] arra = new a[]{a, b, c, d, e, f, g, h, i, j, k, l, m, n, o, p};
            q = arra;
        }

        public static a valueOf(String string2) {
            return (a)Enum.valueOf(a.class, (String)string2);
        }

        public static a[] values() {
            return (a[])q.clone();
        }
    }

    private class b
    implements ThreadFactory {
        private final String b;

        public b(String string2) {
            this.b = string2;
        }

        public Thread newThread(Runnable runnable) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("AppLovinSdk:");
            stringBuilder.append(this.b);
            stringBuilder.append(":");
            stringBuilder.append(m.a(q.this.b.s()));
            Thread thread = new Thread(runnable, stringBuilder.toString());
            thread.setDaemon(true);
            thread.setPriority(10);
            thread.setUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler(){

                public void uncaughtException(Thread thread, Throwable throwable) {
                    q.this.c.b("TaskManager", "Caught unhandled exception", throwable);
                }
            });
            return thread;
        }

    }

    private class c
    implements Runnable {
        private final String b;
        private final com.applovin.impl.sdk.d.a c;
        private final a d;

        c(com.applovin.impl.sdk.d.a a2, a a3) {
            this.b = a2.c();
            this.c = a2;
            this.d = a3;
        }

        /*
         * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
         * Unable to fully structure code
         * Enabled aggressive block sorting
         * Enabled unnecessary exception pruning
         * Enabled aggressive exception aggregation
         * Lifted jumps to return sites
         */
        public void run() {
            block6 : {
                var1_1 = System.currentTimeMillis();
                e.a();
                if (q.a(q.this).c() && !this.c.e()) {
                    q.b(q.this).b(this.b, "Task re-scheduled...");
                    q.this.a(this.c, this.d, 2000L);
                    break block6;
                }
                q.b(q.this).b(this.b, "Task started execution...");
                this.c.run();
                var31_2 = System.currentTimeMillis() - var1_1;
                q.a(q.this).E().a(this.c.a(), var31_2);
                var33_3 = q.b(q.this);
                var34_4 = this.b;
                var35_5 = new StringBuilder();
                var35_5.append("Task executed successfully in ");
                var35_5.append(var31_2);
                var35_5.append("ms.");
                var33_3.b(var34_4, var35_5.toString());
            }
            var12_6 = q.a(q.this, this.d) - 1L;
            var14_7 = q.b(q.this);
            var15_8 = new StringBuilder();
lbl23: // 2 sources:
            do {
                var15_8.append((Object)this.d);
                var15_8.append(" queue finished task ");
                var15_8.append(this.c.c());
                var15_8.append(" with queue size ");
                var15_8.append(var12_6);
                var14_7.b("TaskManager", var15_8.toString());
                return;
                break;
            } while (true);
            {
                catch (Throwable var21_9) {
                }
                catch (Throwable var3_10) {}
                {
                    var4_11 = System.currentTimeMillis() - var1_1;
                    q.a(q.this).E().a(this.c.a(), true, var4_11);
                    var6_12 = q.b(q.this);
                    var7_13 = this.c.c();
                    var8_14 = new StringBuilder();
                    var8_14.append("Task failed execution in ");
                    var8_14.append(var4_11);
                    var8_14.append("ms.");
                    var6_12.b(var7_13, var8_14.toString(), var3_10);
                }
                var12_6 = q.a(q.this, this.d) - 1L;
                var14_7 = q.b(q.this);
                var15_8 = new StringBuilder();
                ** continue;
            }
            var22_15 = q.a(q.this, this.d) - 1L;
            var24_16 = q.b(q.this);
            var25_17 = new StringBuilder();
            var25_17.append((Object)this.d);
            var25_17.append(" queue finished task ");
            var25_17.append(this.c.c());
            var25_17.append(" with queue size ");
            var25_17.append(var22_15);
            var24_16.b("TaskManager", var25_17.toString());
            throw var21_9;
        }
    }

}

