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
package com.moat.analytics.mobile.tjy;

import com.moat.analytics.mobile.tjy.aa;
import com.moat.analytics.mobile.tjy.ap;
import com.moat.analytics.mobile.tjy.aq;
import com.moat.analytics.mobile.tjy.ar;
import com.moat.analytics.mobile.tjy.at;
import com.moat.analytics.mobile.tjy.au;
import com.moat.analytics.mobile.tjy.av;
import com.moat.analytics.mobile.tjy.ax;
import java.util.Iterator;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicReference;

class as
implements ap {
    private static final AtomicReference a = new AtomicReference();
    private static final Queue b = new ConcurrentLinkedQueue();
    private static volatile ar c = ar.a;
    private static volatile boolean d = false;
    private static volatile int e = 200;

    as(aa aa2) {
        ExecutorService executorService;
        if (a.get() == null && a.compareAndSet(null, (Object)(executorService = Executors.newSingleThreadExecutor((ThreadFactory)new at(this))))) {
            ((ExecutorService)a.get()).submit((Runnable)new av("TJY", aa2, new au(this), null));
        }
    }

    static /* synthetic */ int a(int n2) {
        e = n2;
        return n2;
    }

    static /* synthetic */ ar a(ar ar2) {
        c = ar2;
        return ar2;
    }

    static /* synthetic */ void a(as as2) {
        as2.g();
    }

    static /* synthetic */ boolean a(boolean bl2) {
        d = bl2;
        return bl2;
    }

    static /* synthetic */ ar d() {
        return c;
    }

    static /* synthetic */ Queue e() {
        return b;
    }

    static /* synthetic */ boolean f() {
        return d;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private void g() {
        Queue queue;
        Queue queue2 = queue = b;
        synchronized (queue2) {
            long l2 = System.currentTimeMillis();
            Iterator iterator = b.iterator();
            while (iterator.hasNext()) {
                aq aq2 = (aq)iterator.next();
                if (!aq2.c() && l2 - aq2.d() < 300000L) continue;
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
    public ar a() {
        return c;
    }

    @Override
    public void a(aq aq2) {
        this.g();
        b.add((Object)aq2);
    }

    @Override
    public boolean b() {
        return d;
    }

    @Override
    public int c() {
        return e;
    }
}

