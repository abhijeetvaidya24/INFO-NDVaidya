/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.os.Process
 *  io.presage.core.IIlIIllI
 *  io.presage.core.IIlIlIII
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
 *  java.util.concurrent.ScheduledExecutorService
 *  java.util.concurrent.ThreadFactory
 *  java.util.concurrent.atomic.AtomicInteger
 */
package io.presage.core;

import android.os.Process;
import io.presage.core.IIlIIlIl;
import io.presage.core.IIlIIllI;
import io.presage.core.IIlIlIII;
import io.presage.core.IlIlllll;
import io.presage.core.lIIIIIlI;
import io.presage.core.lIIIIlII;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

public final class IIlIIlII {
    private static final String IIIIIlIl = lIIIIIlI.IIIIlIII.IIIIIIII;
    private static final String IIIIIllI = lIIIIIlI.IIIIlIII.IIIIIIIl;
    private static final String IIIIIlll = lIIIIIlI.IIIIlIII.IIIIIIlI;
    private static final String IIIIlIII = lIIIIIlI.IIIIlIII.IIIIIIll;
    private static final String IIIIlIIl = lIIIIIlI.IIIIlIII.IIIIIlII;
    public final IIlIlIII IIIIIIII = new IIlIlIII(Executors.newScheduledThreadPool((int)5, (ThreadFactory)new IIIIIIII(this.IIIIIlII, IIIIIllI)));
    public final IIlIIllI IIIIIIIl = new IIlIIllI(Executors.newSingleThreadExecutor((ThreadFactory)new IIIIIIII(this.IIIIIlII, IIIIIlll)));
    public final IIlIIllI IIIIIIlI = new IIlIIllI(Executors.newFixedThreadPool((int)2, (ThreadFactory)new IIIIIIII(this.IIIIIlII, IIIIlIII)));
    public final IIlIIllI IIIIIIll = new IIlIIllI(Executors.newSingleThreadExecutor((ThreadFactory)new IIIIIIII(this.IIIIIlII, IIIIlIIl)));
    private final ThreadGroup IIIIIlII = new ThreadGroup(IIIIIlIl);

    public final void IIIIIIII() {
        new Object[1][0] = this.IIIIIIII.isTerminated();
        new Object[1][0] = this.IIIIIIIl.isTerminated();
        new Object[1][0] = this.IIIIIIlI.isTerminated();
        new Object[1][0] = this.IIIIIIll.isTerminated();
        lIIIIlII.IIIIIIII((IIlIIlIl)this.IIIIIIII);
        lIIIIlII.IIIIIIII((IIlIIlIl)this.IIIIIIIl);
        lIIIIlII.IIIIIIII((IIlIIlIl)this.IIIIIIlI);
        lIIIIlII.IIIIIIII((IIlIIlIl)this.IIIIIIll);
        ThreadGroup threadGroup = this.IIIIIlII;
        if (threadGroup != null) {
            threadGroup.interrupt();
        }
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

