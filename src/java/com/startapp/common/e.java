/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Exception
 *  java.lang.String
 *  java.lang.Throwable
 */
package com.startapp.common;

public class e
extends Exception {
    private boolean b = false;
    private int c = 0;

    public e() {
    }

    public e(String string, Throwable throwable) {
        this(string, throwable, false);
    }

    public e(String string, Throwable throwable, int n2) {
        this(string, throwable, false, n2);
    }

    public e(String string, Throwable throwable, boolean bl) {
        this(string, throwable, bl, 0);
    }

    public e(String string, Throwable throwable, boolean bl, int n2) {
        super(string, throwable);
        this.b = bl;
        this.c = n2;
    }

    public int a() {
        return this.c;
    }

    public boolean b() {
        return this.b;
    }
}

