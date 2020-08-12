/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.RuntimeException
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.Throwable
 *  java.util.LinkedList
 *  java.util.Queue
 *  java.util.concurrent.Executor
 *  java.util.logging.Level
 *  java.util.logging.Logger
 */
package com.tapjoy.internal;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.Executor;
import java.util.logging.Level;
import java.util.logging.Logger;

public final class dg {
    private static final Logger a = Logger.getLogger((String)dg.class.getName());
    private final Queue b = new LinkedList();
    private boolean c = false;

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Loose catch block
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Converted monitor instructions to comments
     * Lifted jumps to return sites
     */
    public final void a() {
        Queue queue;
        Queue queue2 = queue = this.b;
        // MONITORENTER : queue2
        if (this.c) {
            // MONITOREXIT : queue2
            return;
        }
        this.c = true;
        // MONITOREXIT : queue2
        while (!this.b.isEmpty()) {
            a a2 = (a)this.b.poll();
            try {
                a2.b.execute(a2.a);
            }
            catch (RuntimeException runtimeException) {
                Logger logger = a;
                Level level = Level.SEVERE;
                StringBuilder stringBuilder = new StringBuilder("RuntimeException while executing runnable ");
                stringBuilder.append((Object)a2.a);
                stringBuilder.append(" with executor ");
                stringBuilder.append((Object)a2.b);
                logger.log(level, stringBuilder.toString(), (Throwable)runtimeException);
            }
        }
        return;
        {
            catch (Throwable throwable) {}
            {
                // MONITOREXIT : queue2
                throw throwable;
            }
        }
    }

    static final class a {
        final Runnable a;
        final Executor b;
    }

}

