/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.moat.analytics.mobile.aer.ao
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.String
 *  java.lang.Thread
 *  java.util.concurrent.ThreadFactory
 */
package com.moat.analytics.mobile.aer;

import com.moat.analytics.mobile.aer.ao;
import java.util.concurrent.ThreadFactory;

class ap
implements ThreadFactory {
    final /* synthetic */ ao a;

    ap(ao ao2) {
        this.a = ao2;
    }

    public Thread newThread(Runnable runnable) {
        Thread thread = new Thread(runnable, "MoatStatus");
        thread.setDaemon(true);
        return thread;
    }
}

