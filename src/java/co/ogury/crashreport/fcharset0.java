/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Exception
 *  java.lang.Object
 *  java.lang.Thread
 *  java.lang.Thread$UncaughtExceptionHandler
 *  java.lang.Throwable
 */
package co.ogury.crashreport;

import co.ogury.crashreport.cocoartf1671;
import co.ogury.crashreport.f0;
import co.ogury.crashreport.tx8640;

public final class fcharset0
implements Thread.UncaughtExceptionHandler {
    public static final rtf1 a = new rtf1(0);
    private final cocoartf1671 b;
    private final Thread.UncaughtExceptionHandler c;

    public fcharset0(cocoartf1671 cocoartf16712, Thread.UncaughtExceptionHandler uncaughtExceptionHandler) {
        tx8640.b(cocoartf16712, "crashFileStore");
        this.b = cocoartf16712;
        this.c = uncaughtExceptionHandler;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public final void uncaughtException(Thread thread, Throwable throwable) {
        Thread.UncaughtExceptionHandler uncaughtExceptionHandler;
        tx8640.b((Object)thread, "thread");
        tx8640.b((Object)throwable, "exception");
        try {
            this.b.a(throwable);
            uncaughtExceptionHandler = this.c;
            if (uncaughtExceptionHandler == null) return;
        }
        catch (Exception exception) {
            f0.a(exception);
            return;
        }
        uncaughtExceptionHandler.uncaughtException(thread, throwable);
    }

    public static final class rtf1 {
        private rtf1() {
        }

        public /* synthetic */ rtf1(byte by2) {
            this();
        }
    }

}

