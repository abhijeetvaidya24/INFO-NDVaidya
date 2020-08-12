/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.os.Process
 *  io.presage.core.IIlIIllI
 *  java.io.PrintWriter
 *  java.io.StringWriter
 *  java.io.Writer
 *  java.lang.Exception
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.SecurityManager
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.System
 *  java.lang.Thread
 *  java.lang.Thread$UncaughtExceptionHandler
 *  java.lang.ThreadGroup
 *  java.lang.Throwable
 *  java.util.concurrent.ExecutorService
 *  java.util.concurrent.Executors
 *  java.util.concurrent.ThreadFactory
 *  java.util.concurrent.atomic.AtomicInteger
 */
package io.presage.core;

import android.os.Process;
import io.presage.core.IIlIIllI;
import io.presage.core.IlIlllll;
import io.presage.core.lIIIIIlI;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

public final class IIlIIlll {
    public static final String IIIIIIII = lIIIIIlI.IIIIlIll.IIIIIIII;
    private static final String IIIIIIIl = lIIIIIlI.IIIIlIll.IIIIIIIl;
    private static final String IIIIIIlI = lIIIIIlI.IIIIlIll.IIIIIIlI;
    private static final String IIIIIIll = lIIIIIlI.IIIIlIll.IIIIIIll;
    private static IIlIIlll IIIIIlll;
    private IIlIIllI IIIIIlII;
    private IIlIIllI IIIIIlIl;
    private IIlIIllI IIIIIllI;

    public static IIlIIlll IIIIIIII() {
        if (IIIIIlll == null) {
            IIIIIlll = new IIlIIlll();
        }
        return IIIIIlll;
    }

    public final IIlIIllI IIIIIIIl() {
        IIlIIllI iIlIIllI = this.IIIIIlII;
        if (iIlIIllI == null || iIlIIllI.isTerminated()) {
            this.IIIIIlII = new IIlIIllI(Executors.newFixedThreadPool((int)3, (ThreadFactory)new IIIIIIII(new ThreadGroup(IIIIIIII), IIIIIIll)));
        }
        return this.IIIIIlII;
    }

    public final IIlIIllI IIIIIIlI() {
        IIlIIllI iIlIIllI = this.IIIIIlIl;
        if (iIlIIllI == null || iIlIIllI.isTerminated()) {
            this.IIIIIlIl = new IIlIIllI(Executors.newFixedThreadPool((int)2, (ThreadFactory)new IIIIIIII(new ThreadGroup(IIIIIIII), IIIIIIlI)));
        }
        return this.IIIIIlIl;
    }

    public final IIlIIllI IIIIIIll() {
        IIlIIllI iIlIIllI = this.IIIIIllI;
        if (iIlIIllI == null || iIlIIllI.isTerminated()) {
            this.IIIIIllI = new IIlIIllI(Executors.newSingleThreadExecutor((ThreadFactory)new IIIIIIII(new ThreadGroup(IIIIIIII), IIIIIIIl)));
        }
        return this.IIIIIllI;
    }

    static final class IIIIIIII
    implements ThreadFactory {
        private static final AtomicInteger IIIIIIII = new AtomicInteger(1);
        private final ThreadGroup IIIIIIIl;
        private final AtomicInteger IIIIIIlI = new AtomicInteger(1);
        private final String IIIIIIll;

        IIIIIIII(ThreadGroup threadGroup, String string2) {
            SecurityManager securityManager = System.getSecurityManager();
            ThreadGroup threadGroup2 = securityManager != null ? securityManager.getThreadGroup() : Thread.currentThread().getThreadGroup();
            this.IIIIIIIl = threadGroup2;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(threadGroup.getName());
            stringBuilder.append("-");
            stringBuilder.append(IIIIIIII.getAndIncrement());
            stringBuilder.append("-");
            stringBuilder.append(string2);
            stringBuilder.append("-");
            this.IIIIIIll = stringBuilder.toString();
        }

        public final Thread newThread(Runnable runnable) {
            ThreadGroup threadGroup = this.IIIIIIIl;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(this.IIIIIIll);
            stringBuilder.append(this.IIIIIIlI.getAndIncrement());
            Thread thread = new Thread(threadGroup, runnable, stringBuilder.toString(), 0L);
            thread.setUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler(){

                public final void uncaughtException(Thread thread, Throwable throwable) {
                    StringWriter stringWriter = new StringWriter();
                    throwable.printStackTrace(new PrintWriter((Writer)stringWriter));
                    Object[] arrobject = new Object[]{thread.getId(), thread.getName(), stringWriter.toString()};
                    IlIlllll.IIIIIIII(new Exception(throwable), 1);
                    Process.killProcess((int)Process.myPid());
                    System.exit((int)10);
                }
            });
            if (thread.isDaemon()) {
                thread.setDaemon(false);
            }
            if (thread.getPriority() != 5) {
                thread.setPriority(5);
            }
            return thread;
        }

    }

}

