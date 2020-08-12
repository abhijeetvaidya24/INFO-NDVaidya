/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Comparable
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.String
 *  java.util.concurrent.Executor
 *  java.util.concurrent.TimeUnit
 *  java.util.concurrent.atomic.AtomicInteger
 *  java.util.concurrent.atomic.AtomicReference
 */
package com.chartboost.sdk.impl;

import com.chartboost.sdk.impl.h;
import com.chartboost.sdk.impl.i;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

class j
implements Comparable<j> {
    final int a;
    final String b;
    final String c;
    final String d;
    final AtomicInteger e;
    final AtomicInteger f;
    private final com.chartboost.sdk.Libraries.i g;
    private final AtomicReference<h> h;
    private final long i;

    j(com.chartboost.sdk.Libraries.i i2, int n2, String string, String string2, String string3, AtomicInteger atomicInteger, AtomicReference<h> atomicReference, long l2, AtomicInteger atomicInteger2) {
        this.g = i2;
        this.a = n2;
        this.b = string;
        this.c = string2;
        this.d = string3;
        this.e = atomicInteger;
        this.h = atomicReference;
        this.i = l2;
        this.f = atomicInteger2;
        atomicInteger.incrementAndGet();
    }

    public int a(j j2) {
        return this.a - j2.a;
    }

    void a(Executor executor, boolean bl) {
        h h2;
        if (!(this.e.decrementAndGet() != 0 && bl || (h2 = (h)this.h.getAndSet(null)) == null)) {
            executor.execute((Runnable)new i(h2, bl, (int)TimeUnit.NANOSECONDS.toMillis(this.g.b() - this.i), this.f.get()));
        }
    }

    public /* synthetic */ int compareTo(Object object) {
        return this.a((j)object);
    }
}

