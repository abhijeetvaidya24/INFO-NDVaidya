/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Exception
 *  java.lang.String
 *  java.lang.Throwable
 */
package com.tappx.b;

import com.tappx.b.k;

public class u
extends Exception {
    public final k a;
    private long b;

    public u() {
        this.a = null;
    }

    public u(k k2) {
        this.a = k2;
    }

    public u(String string2) {
        super(string2);
        this.a = null;
    }

    public u(String string2, Throwable throwable) {
        super(string2, throwable);
        this.a = null;
    }

    public u(Throwable throwable) {
        super(throwable);
        this.a = null;
    }

    void a(long l2) {
        this.b = l2;
    }

    public long b() {
        return this.b;
    }
}

