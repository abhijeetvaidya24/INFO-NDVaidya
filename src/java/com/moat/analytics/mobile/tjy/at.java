/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.moat.analytics.mobile.tjy.as
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.String
 *  java.lang.Thread
 *  java.util.concurrent.ThreadFactory
 */
package com.moat.analytics.mobile.tjy;

import com.moat.analytics.mobile.tjy.as;
import java.util.concurrent.ThreadFactory;

class at
implements ThreadFactory {
    final /* synthetic */ as a;

    at(as as2) {
        this.a = as2;
    }

    public Thread newThread(Runnable runnable) {
        Thread thread = new Thread(runnable, "MoatStatus");
        thread.setDaemon(true);
        return thread;
    }
}

