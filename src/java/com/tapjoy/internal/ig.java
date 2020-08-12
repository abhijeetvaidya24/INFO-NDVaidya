/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.tapjoy.internal.ig$1
 *  java.io.InterruptedIOException
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.System
 *  java.lang.Thread
 */
package com.tapjoy.internal;

import com.tapjoy.internal.ig;
import java.io.InterruptedIOException;

public class ig {
    public static final ig a = new 1();
    private boolean b;
    private long c;

    public void a() {
        if (!Thread.interrupted()) {
            if (this.b) {
                if (this.c - System.nanoTime() > 0L) {
                    return;
                }
                throw new InterruptedIOException("deadline reached");
            }
            return;
        }
        throw new InterruptedIOException("thread interrupted");
    }
}

