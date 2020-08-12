/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.os.Handler
 *  android.os.Looper
 *  com.tappx.b.f
 *  com.tappx.b.o$1
 *  java.lang.IllegalArgumentException
 *  java.lang.Object
 *  java.lang.String
 *  java.util.ArrayList
 *  java.util.HashSet
 *  java.util.Iterator
 *  java.util.List
 *  java.util.Set
 *  java.util.concurrent.BlockingQueue
 *  java.util.concurrent.PriorityBlockingQueue
 *  java.util.concurrent.atomic.AtomicInteger
 */
package com.tappx.b;

import android.os.Handler;
import android.os.Looper;
import com.tappx.b.c;
import com.tappx.b.f;
import com.tappx.b.h;
import com.tappx.b.i;
import com.tappx.b.n;
import com.tappx.b.o;
import com.tappx.b.q;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

public class o {
    private static final int e = 4;
    private final AtomicInteger a = new AtomicInteger();
    private final Set<n<?>> b = new HashSet();
    private final PriorityBlockingQueue<n<?>> c = new PriorityBlockingQueue();
    private final PriorityBlockingQueue<n<?>> d = new PriorityBlockingQueue();
    private final com.tappx.b.b f;
    private final h g;
    private final q h;
    private final i[] i;
    private c j;
    private final List<b> k = new ArrayList();

    public o(com.tappx.b.b b2, h h2) {
        this(b2, h2, 4);
    }

    public o(com.tappx.b.b b2, h h2, int n2) {
        this(b2, h2, n2, (q)new f(new Handler(Looper.getMainLooper())));
    }

    public o(com.tappx.b.b b2, h h2, int n2, q q2) {
        this.f = b2;
        this.g = h2;
        this.i = new i[n2];
        this.h = q2;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public <T> n<T> a(n<T> n2) {
        Set<n<?>> set;
        n2.a(this);
        Set<n<?>> set2 = set = this.b;
        synchronized (set2) {
            this.b.add(n2);
        }
        n2.a(this.c());
        n2.a("add-to-queue");
        if (!n2.v()) {
            this.d.add(n2);
            return n2;
        }
        this.c.add(n2);
        return n2;
    }

    public void a() {
        this.b();
        this.j = new c((BlockingQueue<n<?>>)this.c, (BlockingQueue<n<?>>)this.d, this.f, this.h);
        this.j.start();
        for (int i2 = 0; i2 < this.i.length; ++i2) {
            i i3;
            this.i[i2] = i3 = new i((BlockingQueue<n<?>>)this.d, this.g, this.f, this.h);
            i3.start();
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void a(a a2) {
        Set<n<?>> set;
        Set<n<?>> set2 = set = this.b;
        synchronized (set2) {
            Iterator iterator = this.b.iterator();
            while (iterator.hasNext()) {
                n n2 = (n)iterator.next();
                if (!a2.a(n2)) continue;
                n2.n();
            }
            return;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public <T> void a(b<T> b2) {
        List<b> list;
        List<b> list2 = list = this.k;
        synchronized (list2) {
            this.k.add(b2);
            return;
        }
    }

    public void a(Object object) {
        if (object != null) {
            this.a((a)new 1(this, object));
            return;
        }
        throw new IllegalArgumentException("Cannot cancelAll with a null tag");
    }

    public void b() {
        c c2 = this.j;
        if (c2 != null) {
            c2.a();
        }
        for (i i2 : this.i) {
            if (i2 == null) continue;
            i2.a();
        }
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Converted monitor instructions to comments
     * Lifted jumps to return sites
     */
    <T> void b(n<T> n2) {
        List<b> list;
        Set<n<?>> set;
        Set<n<?>> set2 = set = this.b;
        // MONITORENTER : set2
        this.b.remove(n2);
        // MONITOREXIT : set2
        List<b> list2 = list = this.k;
        Iterator iterator = this.k.iterator();
        do {
            if (!iterator.hasNext()) {
                // MONITOREXIT : list2
                return;
            }
            ((b)iterator.next()).a(n2);
        } while (true);
        finally {
            // MONITORENTER : list2
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public <T> void b(b<T> b2) {
        List<b> list;
        List<b> list2 = list = this.k;
        synchronized (list2) {
            this.k.remove(b2);
            return;
        }
    }

    public int c() {
        return this.a.incrementAndGet();
    }

    public com.tappx.b.b d() {
        return this.f;
    }

    public static interface a {
        public boolean a(n<?> var1);
    }

    public static interface b<T> {
        public void a(n<T> var1);
    }

}

