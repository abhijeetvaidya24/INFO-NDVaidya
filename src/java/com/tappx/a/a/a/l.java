/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Math
 *  java.lang.Object
 */
package com.tappx.a.a.a;

import com.tappx.a.a.a.f;
import com.tappx.a.a.a.g;

public class l<T>
implements f<T> {
    private final long a;
    private T b;
    private long c;

    public l(long l2) {
        if (l2 < 0L) {
            l2 = 0L;
        }
        this.a = l2;
    }

    private long b() {
        return g.a();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    @Override
    public T a() {
        long l2;
        T t2;
        l l3 = this;
        synchronized (l3) {
            t2 = this.b;
            l2 = this.c;
        }
        boolean bl = t2 == null || l2 == 0L || Math.abs((long)(this.b() - l2)) > this.a;
        if (bl) {
            t2 = null;
        }
        return t2;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    @Override
    public void a(T t2) {
        l l2 = this;
        synchronized (l2) {
            this.b = t2;
            this.c = this.b();
            return;
        }
    }
}

