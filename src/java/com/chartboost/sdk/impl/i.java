/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.Runnable
 */
package com.chartboost.sdk.impl;

import com.chartboost.sdk.impl.h;

public class i
implements Runnable {
    public final boolean a;
    private final h b;
    private final int c;
    private final int d;

    i(h h2, boolean bl, int n2, int n3) {
        this.b = h2;
        this.a = bl;
        this.c = n2;
        this.d = n3;
    }

    public void run() {
        this.b.a(this.a, this.c, this.d);
    }
}

