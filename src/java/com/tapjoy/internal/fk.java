/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.io.File
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.String
 *  java.lang.Throwable
 *  java.util.HashMap
 *  java.util.Map
 *  java.util.concurrent.BlockingQueue
 *  java.util.concurrent.LinkedBlockingQueue
 *  java.util.concurrent.ThreadPoolExecutor
 *  java.util.concurrent.TimeUnit
 */
package com.tapjoy.internal;

import com.tapjoy.internal.fj;
import com.tapjoy.internal.gb;
import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public final class fk
extends fj {
    private final ThreadPoolExecutor b;

    public fk(File file, gb gb2) {
        ThreadPoolExecutor threadPoolExecutor;
        super(file, gb2);
        this.b = threadPoolExecutor = new ThreadPoolExecutor(0, 1, 1L, TimeUnit.SECONDS, (BlockingQueue)new LinkedBlockingQueue());
    }

    @Override
    protected final void a() {
        try {
            ThreadPoolExecutor threadPoolExecutor = this.b;
            Runnable runnable = new Runnable(2, 0L, null, null, null){
                private int b;
                private long c;
                private String d;
                private String e;
                private Map f;
                {
                    this.b = n2;
                    this.c = l2;
                    this.d = string;
                    this.e = string2;
                    this.f = map;
                }

                /*
                 * Enabled aggressive block sorting
                 * Enabled unnecessary exception pruning
                 * Enabled aggressive exception aggregation
                 */
                public final void run() {
                    try {
                        int n2 = this.b;
                        if (n2 == 1) {
                            fk.super.a(this.c);
                            return;
                        }
                        if (n2 == 2) {
                            fk.super.a();
                            return;
                        }
                        if (n2 != 3) {
                            return;
                        }
                        fk.super.a(this.c, this.d, this.e, this.f);
                        return;
                    }
                    catch (Throwable throwable) {
                        fk.super.a();
                        return;
                    }
                }
            };
            threadPoolExecutor.execute(runnable);
        }
        catch (Throwable throwable) {}
    }

    @Override
    protected final void a(long l2) {
        try {
            ThreadPoolExecutor threadPoolExecutor = this.b;
            Runnable runnable = new /* invalid duplicate definition of identical inner class */;
            threadPoolExecutor.execute(runnable);
        }
        catch (Throwable throwable) {}
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    @Override
    protected final void a(long l2, String string, String string2, Map map) {
        try {
            ThreadPoolExecutor threadPoolExecutor = this.b;
            HashMap hashMap = map != null ? new HashMap(map) : null;
            Runnable runnable = new /* invalid duplicate definition of identical inner class */;
            threadPoolExecutor.execute(runnable);
            return;
        }
        catch (Throwable throwable) {}
    }

    @Override
    protected final void finalize() {
        try {
            this.b.shutdown();
            this.b.awaitTermination(1L, TimeUnit.SECONDS);
            return;
        }
        finally {
            super.finalize();
        }
    }

}

