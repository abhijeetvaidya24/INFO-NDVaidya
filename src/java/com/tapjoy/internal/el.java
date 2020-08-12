/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.os.SystemClock
 *  java.lang.NullPointerException
 *  java.lang.Object
 */
package com.tapjoy.internal;

import android.os.SystemClock;

public final class el {
    public static final el a = new el(-1L);
    public final long b;
    public long c;

    public el() {
        this.b = 3600000L;
        try {
            this.c = SystemClock.elapsedRealtime() - 3600000L;
            return;
        }
        catch (NullPointerException nullPointerException) {
            this.c = -1L;
            return;
        }
    }

    public el(long l2) {
        this.b = l2;
        this.c = SystemClock.elapsedRealtime();
    }

    public final boolean a() {
        boolean bl2;
        bl2 = true;
        try {
            long l2 = SystemClock.elapsedRealtime() - this.c;
            long l3 = this.b;
            if (l2 > l3) {
                return bl2;
            }
            bl2 = false;
        }
        catch (NullPointerException nullPointerException) {}
        return bl2;
    }

    public final boolean a(long l2) {
        try {
            long l3 = l2 + (SystemClock.elapsedRealtime() - this.c);
            long l4 = this.b;
            return l3 > l4;
        }
        catch (NullPointerException nullPointerException) {
            return true;
        }
    }
}

