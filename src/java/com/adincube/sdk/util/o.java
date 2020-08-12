/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.os.Handler
 *  android.os.Looper
 *  java.lang.Boolean
 *  java.lang.InterruptedException
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.String
 *  java.lang.Throwable
 *  java.util.Collection
 *  java.util.Iterator
 *  java.util.concurrent.Callable
 *  java.util.concurrent.Semaphore
 *  java.util.concurrent.atomic.AtomicReference
 */
package com.adincube.sdk.util;

import android.os.Handler;
import android.os.Looper;
import com.adincube.sdk.util.ErrorReportingHelper;
import com.adincube.sdk.util.a;
import java.util.Collection;
import java.util.Iterator;
import java.util.concurrent.Callable;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicReference;

public final class o {
    private static boolean a;

    public static <T> T a(final Callable<T> callable, T t2) {
        Object object;
        if (a) {
            return t2;
        }
        final Semaphore semaphore = new Semaphore(0);
        final AtomicReference atomicReference = new AtomicReference(null);
        new Handler(Looper.getMainLooper()).post(new Runnable(){

            /*
             * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
             * Unable to fully structure code
             * Enabled aggressive block sorting
             * Enabled unnecessary exception pruning
             * Enabled aggressive exception aggregation
             * Lifted jumps to return sites
             */
            public final void run() {
                atomicReference.set(callable.call());
lbl3: // 2 sources:
                do {
                    semaphore.release();
                    return;
                    break;
                } while (true);
                {
                    catch (Throwable var2_1) {
                    }
                    catch (Throwable var1_2) {}
                    {
                        a.c("HandlerUtil.dispatchOnUiThread", new Object[]{var1_2});
                        ErrorReportingHelper.report("HandlerUtil.dispatchOnUiThread", var1_2);
                        ** continue;
                    }
                }
                semaphore.release();
                throw var2_1;
            }
        });
        try {
            semaphore.acquire();
            object = atomicReference.get();
        }
        catch (InterruptedException interruptedException) {
            return t2;
        }
        return (T)object;
    }

    public static void a(Runnable runnable) {
        o.a("HandlerUtil.dispatchOnUiThread", runnable);
    }

    public static void a(Runnable runnable, long l2) {
        o.a("HandlerUtil.dispatchOnUiThreadDelayed", runnable, l2);
    }

    public static <T> void a(final String string, final T t2, final com.adincube.sdk.util.c.a<T> a2) {
        if (a) {
            return;
        }
        if (t2 == null) {
            return;
        }
        new Handler(Looper.getMainLooper()).post(new Runnable(){

            public final void run() {
                try {
                    a2.a(t2);
                    return;
                }
                catch (Throwable throwable) {
                    a.c(string, new Object[]{throwable});
                    ErrorReportingHelper.report(string, throwable);
                    return;
                }
            }
        });
    }

    public static void a(final String string, final Runnable runnable) {
        if (a) {
            return;
        }
        new Handler(Looper.getMainLooper()).post(new Runnable(){

            public final void run() {
                try {
                    runnable.run();
                    return;
                }
                catch (Throwable throwable) {
                    a.c(string, new Object[]{throwable});
                    ErrorReportingHelper.report("HandlerUtil.dispatchOnUiThread", throwable);
                    return;
                }
            }
        });
    }

    public static void a(final String string, final Runnable runnable, long l2) {
        if (a) {
            return;
        }
        new Handler(Looper.getMainLooper()).postDelayed(new Runnable(){

            public final void run() {
                try {
                    runnable.run();
                    return;
                }
                catch (Throwable throwable) {
                    a.c(string, new Object[]{throwable});
                    ErrorReportingHelper.report(string, throwable);
                    return;
                }
            }
        }, l2);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static <T> void a(String string, Collection<T> collection, final com.adincube.sdk.util.c.a<T> a2) {
        if (a) {
            return;
        }
        if (collection == null) {
            return;
        }
        Collection<T> collection2 = collection;
        synchronized (collection2) {
            Handler handler = new Handler(Looper.getMainLooper());
            Iterator iterator = collection.iterator();
            while (iterator.hasNext()) {
                handler.post(new Runnable(iterator.next(), string){
                    final /* synthetic */ Object b;
                    final /* synthetic */ String c;
                    {
                        this.b = object;
                        this.c = string;
                    }

                    public final void run() {
                        try {
                            a2.a(this.b);
                            return;
                        }
                        catch (Throwable throwable) {
                            a.c(this.c, new Object[]{throwable});
                            ErrorReportingHelper.report(this.c, throwable);
                            return;
                        }
                    }
                });
            }
            return;
        }
    }

    public static boolean a() {
        return Looper.getMainLooper() == Looper.myLooper();
    }

    public static boolean a(Callable<Boolean> callable) {
        return o.a(callable, false);
    }

    public static <T> void b(final T t2, final com.adincube.sdk.util.c.a<T> a2) {
        if (t2 == null) {
            return;
        }
        new Handler(Looper.getMainLooper()).post(new Runnable(){

            public final void run() {
                a2.a(t2);
            }
        });
    }

}

