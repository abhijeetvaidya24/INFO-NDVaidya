/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.os.Build
 *  android.os.Build$VERSION
 *  java.lang.Enum
 *  java.lang.Exception
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.Thread
 *  java.util.concurrent.BlockingQueue
 *  java.util.concurrent.Executor
 *  java.util.concurrent.LinkedBlockingQueue
 *  java.util.concurrent.RejectedExecutionHandler
 *  java.util.concurrent.ScheduledExecutorService
 *  java.util.concurrent.ScheduledFuture
 *  java.util.concurrent.ScheduledThreadPoolExecutor
 *  java.util.concurrent.ThreadFactory
 *  java.util.concurrent.ThreadPoolExecutor
 *  java.util.concurrent.TimeUnit
 *  java.util.concurrent.atomic.AtomicInteger
 */
package com.startapp.common;

import android.os.Build;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public final class g {
    private static final String a = "g";
    private static final int b;
    private static final int c;
    private static final ThreadFactory d;
    private static final ThreadFactory e;
    private static final RejectedExecutionHandler f;
    private static final Executor g;
    private static final Executor h;
    private static final ScheduledExecutorService i;

    static {
        int n2 = Build.VERSION.SDK_INT < 22 ? 10 : 20;
        b = n2;
        int n3 = Build.VERSION.SDK_INT < 22 ? 4 : 8;
        c = n3;
        d = new ThreadFactory(){
            private final AtomicInteger a = new AtomicInteger(1);

            public Thread newThread(Runnable runnable) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("highPriorityThreadFactory #");
                stringBuilder.append(this.a.getAndIncrement());
                return new Thread(runnable, stringBuilder.toString());
            }
        };
        e = new ThreadFactory(){
            private final AtomicInteger a = new AtomicInteger(1);

            public Thread newThread(Runnable runnable) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("defaultPriorityThreadFactory #");
                stringBuilder.append(this.a.getAndIncrement());
                return new Thread(runnable, stringBuilder.toString());
            }
        };
        f = new RejectedExecutionHandler(){

            public void rejectedExecution(Runnable runnable, ThreadPoolExecutor threadPoolExecutor) {
                String string = a;
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("ThreadPoolExecutor rejected execution! ");
                stringBuilder.append((Object)threadPoolExecutor);
                com.startapp.common.a.g.a(string, 6, stringBuilder.toString());
            }
        };
        int n4 = b;
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(n4, n4, 20L, TimeUnit.SECONDS, (BlockingQueue)new LinkedBlockingQueue(), d, f);
        g = threadPoolExecutor;
        int n5 = c;
        ThreadPoolExecutor threadPoolExecutor2 = new ThreadPoolExecutor(n5, n5, 20L, TimeUnit.SECONDS, (BlockingQueue)new LinkedBlockingQueue(), e, f);
        h = threadPoolExecutor2;
        i = new ScheduledThreadPoolExecutor(1);
    }

    public static ScheduledFuture<?> a(Runnable runnable, long l2) {
        return i.schedule(runnable, l2, TimeUnit.MILLISECONDS);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static void a(a a2, Runnable runnable) {
        Executor executor = null;
        try {
            boolean bl = a2.equals((Object)a.b);
            executor = null;
            Executor executor2 = bl ? g : h;
            executor = executor2;
            executor.execute(runnable);
            return;
        }
        catch (Exception exception) {
            String string = a;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("executeWithPriority failed to execute! ");
            stringBuilder.append((Object)executor);
            com.startapp.common.a.g.a(string, 6, stringBuilder.toString());
            return;
        }
    }

    public static final class a
    extends Enum<a> {
        public static final /* enum */ a a = new a();
        public static final /* enum */ a b = new a();
        private static final /* synthetic */ a[] c;

        static {
            a[] arra = new a[]{a, b};
            c = arra;
        }

        public static a valueOf(String string) {
            return (a)Enum.valueOf(a.class, (String)string);
        }

        public static a[] values() {
            return (a[])c.clone();
        }
    }

}

