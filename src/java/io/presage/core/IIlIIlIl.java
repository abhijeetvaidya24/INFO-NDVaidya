/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  io.presage.core.IIlIIlIl$1
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.util.concurrent.ExecutorService
 *  java.util.concurrent.atomic.AtomicInteger
 */
package io.presage.core;

import io.presage.core.IIlIIlIl;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.atomic.AtomicInteger;

public abstract class IIlIIlIl {
    protected ExecutorService IIIIIIII;
    protected AtomicInteger IIIIIIIl;
    private IIIIIIII IIIIIIlI;

    protected IIlIIlIl(ExecutorService executorService) {
        this.IIIIIIII = executorService;
        this.IIIIIIIl = new AtomicInteger();
    }

    private void IIIIIIIl() {
        IIIIIIII iIIIIIII = this.IIIIIIlI;
        if (iIIIIIII != null) {
            iIIIIIII.IIIIIIII();
        }
    }

    public final void IIIIIIII() {
        this.IIIIIIIl.decrementAndGet();
        new Object[1][0] = this.IIIIIIIl.intValue();
        if (this.IIIIIIIl.intValue() == 0) {
            this.IIIIIIIl();
        }
    }

    public void execute(Runnable runnable) {
        this.IIIIIIIl.incrementAndGet();
        new Object[1][0] = this.IIIIIIIl.intValue();
        this.IIIIIIII.execute(runnable);
    }

    public void shutdown() {
        Object[] arrobject = new Object[]{this.IIIIIIIl.intValue(), this.IIIIIIII.isShutdown(), this.IIIIIIII.isTerminated()};
        if (this.IIIIIIIl.intValue() == 0) {
            this.IIIIIIII.shutdown();
            return;
        }
        1 var2_2 = new 1(this);
        if (this.IIIIIIlI == null) {
            this.IIIIIIlI = var2_2;
        }
        if (this.IIIIIIIl.intValue() == 0) {
            this.IIIIIIIl();
        }
    }

    static interface IIIIIIII {
        public void IIIIIIII();
    }

}

