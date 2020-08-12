/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.String
 *  java.lang.System
 *  java.util.Iterator
 *  java.util.Queue
 *  java.util.concurrent.ConcurrentLinkedQueue
 *  java.util.concurrent.ExecutorService
 *  java.util.concurrent.Executors
 *  java.util.concurrent.Future
 *  java.util.concurrent.ThreadFactory
 *  java.util.concurrent.atomic.AtomicReference
 */
package com.moat.analytics.mobile.aer;

import com.moat.analytics.mobile.aer.al;
import com.moat.analytics.mobile.aer.am;
import com.moat.analytics.mobile.aer.an;
import com.moat.analytics.mobile.aer.ap;
import com.moat.analytics.mobile.aer.aq;
import com.moat.analytics.mobile.aer.ar;
import com.moat.analytics.mobile.aer.at;
import com.moat.analytics.mobile.aer.w;
import java.util.Iterator;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicReference;

class ao
implements al {
    private static final AtomicReference<ExecutorService> a = new AtomicReference();
    private static final Queue<am> b = new ConcurrentLinkedQueue();
    private static volatile an c = an.a;
    private static volatile boolean d = false;

    ao(w w2) {
        ExecutorService executorService;
        if (a.get() == null && a.compareAndSet(null, (Object)(executorService = Executors.newSingleThreadExecutor((ThreadFactory)new ap(this))))) {
            ((ExecutorService)a.get()).submit((Runnable)new ar("AER", w2, new aq(this), null));
        }
    }

    static /* synthetic */ an a(an an2) {
        c = an2;
        return an2;
    }

    static /* synthetic */ void a(ao ao2) {
        ao2.e();
    }

    static /* synthetic */ boolean a(boolean bl) {
        d = bl;
        return bl;
    }

    static /* synthetic */ an c() {
        return c;
    }

    static /* synthetic */ Queue d() {
        return b;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private void e() {
        Queue<am> queue;
        Queue<am> queue2 = queue = b;
        synchronized (queue2) {
            long l2 = System.currentTimeMillis();
            Iterator iterator = b.iterator();
            while (iterator.hasNext()) {
                am am2 = (am)iterator.next();
                if (!am2.c() && l2 - am2.d() < 300000L) continue;
                iterator.remove();
            }
            if (b.size() >= 15) {
                for (int i2 = 0; i2 < 5; ++i2) {
                    b.remove();
                }
            }
            return;
        }
    }

    @Override
    public an a() {
        return c;
    }

    @Override
    public void a(am am2) {
        this.e();
        b.add((Object)am2);
    }

    @Override
    public boolean b() {
        return d;
    }
}

