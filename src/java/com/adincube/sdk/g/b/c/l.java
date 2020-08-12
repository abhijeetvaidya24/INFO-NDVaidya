/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.os.Handler
 *  android.os.Looper
 *  com.adincube.sdk.g.b.c.i
 *  com.adincube.sdk.g.b.c.k
 *  com.adincube.sdk.g.b.c.k$a
 *  com.adincube.sdk.g.b.c.l$1
 *  com.adincube.sdk.g.b.c.l$2
 *  com.adincube.sdk.g.b.c.l$a
 *  com.adincube.sdk.g.b.c.l$b
 *  com.adincube.sdk.h.c.a
 *  com.adincube.sdk.h.c.b
 *  com.adincube.sdk.h.c.e
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.System
 *  java.util.ArrayList
 *  java.util.Iterator
 *  java.util.List
 */
package com.adincube.sdk.g.b.c;

import android.os.Handler;
import android.os.Looper;
import com.adincube.sdk.g.b.c.i;
import com.adincube.sdk.g.b.c.k;
import com.adincube.sdk.g.b.c.l;
import com.adincube.sdk.h.c.e;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/*
 * Exception performing whole class analysis.
 */
public final class l
implements k {
    com.adincube.sdk.h.c.b a;
    com.adincube.sdk.h.c.a b;
    i c;
    long d;
    k.a e;
    Object f;
    List<b> g;
    a h;

    public l(com.adincube.sdk.h.c.b b2, com.adincube.sdk.h.c.a a2) {
        this.f = new Object();
        this.g = new ArrayList();
        this.a = b2;
        this.b = a2;
    }

    public final void a(i i2) {
        this.c = i2;
        if (this.c != null) {
            this.d = i2.g();
        }
    }

    public final void a(k.a a2) {
        this.e = a2;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final void a(e e2) {
        Object object;
        Object object2 = object = this.f;
        synchronized (object2) {
            Iterator iterator = this.g.iterator();
            do {
                if (!iterator.hasNext()) return;
            } while ((iterator.next()).a != e2);
            iterator.remove();
            return;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final void a(e e2, long l2) {
        Object object;
        Object object2 = object = this.f;
        synchronized (object2) {
            b b2 = new /* Unavailable Anonymous Inner Class!! */;
            b2.a = e2;
            b2.b = l2 + System.currentTimeMillis();
            this.g.add((Object)b2);
            return;
        }
    }

    public final boolean a() {
        return this.h != null;
    }

    public final void b() {
        l l2 = this;
        synchronized (l2) {
            new Handler(Looper.getMainLooper()).post((Runnable)new 1(this));
            return;
        }
    }

    public final void c() {
        l l2 = this;
        synchronized (l2) {
            if (this.h != null) {
                new Handler(Looper.getMainLooper()).post((Runnable)new 2(this));
            }
            return;
        }
    }
}

