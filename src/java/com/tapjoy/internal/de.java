/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Error
 *  java.lang.IllegalStateException
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.Throwable
 *  java.util.concurrent.CancellationException
 *  java.util.concurrent.ExecutionException
 *  java.util.concurrent.TimeUnit
 *  java.util.concurrent.TimeoutException
 *  java.util.concurrent.locks.AbstractQueuedSynchronizer
 */
package com.tapjoy.internal;

import com.tapjoy.internal.cs;
import com.tapjoy.internal.dg;
import com.tapjoy.internal.dh;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;

public abstract class de
implements dh {
    private final a a = new AbstractQueuedSynchronizer(){
        private Object a;
        private Throwable b;

        final Object a() {
            int n2 = this.getState();
            if (n2 != 2) {
                if (n2 != 4) {
                    StringBuilder stringBuilder = new StringBuilder("Error, synchronizer in invalid state: ");
                    stringBuilder.append(n2);
                    throw new IllegalStateException(stringBuilder.toString());
                }
                throw new CancellationException("Task was cancelled.");
            }
            Throwable throwable = this.b;
            if (throwable == null) {
                return this.a;
            }
            throw new ExecutionException(throwable);
        }

        final boolean a(Object object, Throwable throwable, int n2) {
            boolean bl = this.compareAndSetState(0, 1);
            if (bl) {
                this.a = object;
                this.b = throwable;
                this.releaseShared(n2);
                return bl;
            }
            if (this.getState() == 1) {
                this.acquireShared(-1);
            }
            return bl;
        }

        final boolean b() {
            return (6 & this.getState()) != 0;
        }

        final boolean c() {
            return this.getState() == 4;
        }

        protected final int tryAcquireShared(int n2) {
            if (this.b()) {
                return 1;
            }
            return -1;
        }

        protected final boolean tryReleaseShared(int n2) {
            this.setState(n2);
            return true;
        }
    };
    private final dg b = new dg();

    protected final boolean a(Object object) {
        boolean bl = this.a.a(object, null, 2);
        if (bl) {
            this.b.a();
        }
        return bl;
    }

    protected final boolean a(Throwable throwable) {
        boolean bl = this.a.a(null, (Throwable)((Object)cs.a((Object)throwable)), 2);
        if (bl) {
            this.b.a();
        }
        if (!(throwable instanceof Error)) {
            return bl;
        }
        throw (Error)throwable;
    }

    public boolean cancel(boolean bl) {
        if (!this.a.a(null, null, 4)) {
            return false;
        }
        this.b.a();
        return true;
    }

    public Object get() {
        a a2 = this.a;
        a2.acquireSharedInterruptibly(-1);
        return a2.a();
    }

    public Object get(long l2, TimeUnit timeUnit) {
        a a2 = this.a;
        if (a2.tryAcquireSharedNanos(-1, timeUnit.toNanos(l2))) {
            return a2.a();
        }
        throw new TimeoutException("Timeout waiting for task.");
    }

    public boolean isCancelled() {
        return this.a.c();
    }

    public boolean isDone() {
        return this.a.b();
    }

}

