/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.AssertionError
 *  java.lang.Long
 *  java.lang.Object
 *  java.lang.Throwable
 *  java.util.concurrent.ExecutionException
 *  java.util.concurrent.Future
 *  java.util.concurrent.TimeUnit
 *  java.util.concurrent.TimeoutException
 */
package com.tappx.b.a;

import com.tappx.b.n;
import com.tappx.b.p;
import com.tappx.b.u;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class v<T>
implements p.a,
p.b<T>,
Future<T> {
    private n<?> a;
    private boolean b = false;
    private T c;
    private u d;

    private v() {
    }

    public static <E> v<E> a() {
        return new v<T>();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private T a(Long l2) {
        v v2 = this;
        synchronized (v2) {
            if (this.d != null) {
                throw new ExecutionException((Throwable)((Object)this.d));
            }
            if (this.b) {
                T t2 = this.c;
                return t2;
            }
            if (l2 == null) {
                this.wait(0L);
            } else if (l2 > 0L) {
                this.wait(l2.longValue());
            }
            if (this.d != null) {
                throw new ExecutionException((Throwable)((Object)this.d));
            }
            if (this.b) {
                T t3 = this.c;
                return t3;
            }
            throw new TimeoutException();
        }
    }

    @Override
    public void a(n<?> n2) {
        this.a = n2;
    }

    @Override
    public void a(u u2) {
        v v2 = this;
        synchronized (v2) {
            this.d = u2;
            this.notifyAll();
            return;
        }
    }

    @Override
    public void a(T t2) {
        v v2 = this;
        synchronized (v2) {
            this.b = true;
            this.c = t2;
            this.notifyAll();
            return;
        }
    }

    public boolean cancel(boolean bl) {
        v v2 = this;
        synchronized (v2) {
            block6 : {
                n<?> n2 = this.a;
                if (n2 != null) break block6;
                return false;
            }
            if (!this.isDone()) {
                this.a.n();
                return true;
            }
            return false;
        }
    }

    public T get() {
        T t2;
        try {
            t2 = this.a((Long)null);
        }
        catch (TimeoutException timeoutException) {
            throw new AssertionError((Object)timeoutException);
        }
        return t2;
    }

    public T get(long l2, TimeUnit timeUnit) {
        return this.a(TimeUnit.MILLISECONDS.convert(l2, timeUnit));
    }

    public boolean isCancelled() {
        n<?> n2 = this.a;
        if (n2 == null) {
            return false;
        }
        return n2.o();
    }

    public boolean isDone() {
        v v2 = this;
        synchronized (v2) {
            boolean bl;
            block4 : {
                boolean bl2;
                if (!this.b && this.d == null && !(bl2 = this.isCancelled())) {
                    bl = false;
                    break block4;
                }
                bl = true;
            }
            return bl;
        }
    }
}

